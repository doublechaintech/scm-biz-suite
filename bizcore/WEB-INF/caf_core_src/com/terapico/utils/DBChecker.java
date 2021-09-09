package com.terapico.utils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBChecker {
    protected static Map<String, List<String>> tableFieldNames = new HashMap<>();
    public static final String TYPE_PRIMARY_KEY = "PK";
    public static final String TYPE_FOREIGN_KEY = "FK";
    //   "alter table employee_data add constraint fk4person_information_of_employee_data foreign key (person_information) references personal_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;",
    //   "alter table employee_data add constraint pk4id_of_employee_data primary key (id);",
    protected static Pattern ptnPKConstrains = Pattern.compile("alter table ([a-zA-Z0-9_]+) " +
            "add constraint ([a-zA-Z0-9_]+) primary key \\(([a-zA-Z0-9_]+)\\).*", Pattern.CASE_INSENSITIVE);
    protected static Pattern ptnFKConstrains = Pattern.compile("alter table ([a-zA-Z0-9_]+) " +
            "add constraint ([a-zA-Z0-9_]+) foreign key \\(([a-zA-Z0-9_]+)\\) " +
            "references ([a-zA-Z0-9_]+)\\(([a-zA-Z0-9_]+)\\) ON DELETE CASCADE ON UPDATE CASCADE.*", Pattern.CASE_INSENSITIVE);

    public static Map<String, Object> verifyTable(String schemaName, String tableName, String title, String[][] fieldInfo, String[] indexSql, String[] constraintSql, DBQuerier q) throws Exception {
        saveTableFieldNames(tableName, fieldInfo);
        if (!q.isTableExists(tableName)) {
            return MapUtil.put("exists", false)
                    .put("message", tableName + "(" + title + ") not exists")
                    .put("result", false)
                    .put("sql", makeCreateTableSql(tableName, title, fieldInfo, indexSql, constraintSql))
                    .into_map();
        }

        List<String> sql = new ArrayList<>();
        String lstFieldName = null;
        for (String[] strings : fieldInfo) {
            String fieldName = strings[0];
            String fieldType = strings[1];
            String fieldNullable = strings[2];
            String fieldTitle = strings[3];
            String referTableName = strings[4];
            String referFieldName = strings[5];
            if (!q.isFieldExists(tableName, fieldName)) {
                sql.add(makeAddFieldSql(tableName, fieldName, fieldType, fieldNullable, fieldTitle, lstFieldName));
                lstFieldName = fieldName;
                continue;
            }
            if (!q.isFieldSame(tableName, fieldName, fieldType)) {
                sql.add(makeAlterFieldSql(tableName, fieldName, fieldType, fieldNullable, fieldTitle));
            }
            lstFieldName = fieldName;
        }

        if (constraintSql != null) {
            LinkedHashMap<String, Map<String, Object>> constraintVerifyTasks = new LinkedHashMap<>();
            for (String csSql : constraintSql) {
                if (TextUtil.isBlank(csSql)) {
                    continue;
                }
                Matcher m = ptnPKConstrains.matcher(csSql);
                if (m.matches()) {
                    String tName = m.group(1);
                    String kName = m.group(2);
                    String cName = m.group(3);

                    addConstraintVerify(constraintVerifyTasks, TYPE_PRIMARY_KEY, csSql, tName, cName, kName);
                    continue;
                }
                m = ptnFKConstrains.matcher(csSql);
                if (m.matches()) {
                    String tName = m.group(1);
                    String kName = m.group(2);
                    String cName = m.group(3);
                    String rtName = m.group(4);
                    String rcName = m.group(5);
                    addConstraintVerify(constraintVerifyTasks, TYPE_FOREIGN_KEY, csSql, tName, cName, kName, rtName, rcName);
                    continue;
                }
                throw new RuntimeException("不能处理语句: " + csSql);
            }
            runConstraintVerify(schemaName, tableName, q, constraintVerifyTasks, sql);
        }
        if (sql.isEmpty()) {
            return MapUtil.put("exists", true)
                    .put("result", true)
                    .into_map();
        }

        return MapUtil.put("exists", true)
                .put("result", false)
                .put("message", "table " + tableName + " field changed")
                .put("sql", String.join("\r\n", sql))
                .into_map();

    }

    private static void runConstraintVerify(String schemaName, String tableName, DBQuerier q, LinkedHashMap<String, Map<String, Object>> constraintVerifyTasks, List<String> sql) throws Exception {
        LinkedHashMap<String, Map<String, Object>> existsConstrains = q.queryConstrainsByTableName(schemaName, tableName);
        Set<String> allCNames = new HashSet<>(constraintVerifyTasks.keySet());
        Set<String> keptCNames = new HashSet<>();

        Iterator<Map.Entry<String, Map<String, Object>>> it = existsConstrains.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Map<String, Object>> entry = it.next();

            Map<String, Object> data = entry.getValue();

            String name = (String) data.get("name");
            String columns = (String) data.get("columnNames");
            String refTableName = (String) data.get("refTableName");
            String refColumnNames = (String) data.get("refColumnNames");
            if (name.equalsIgnoreCase("PRIMARY") && columns.equalsIgnoreCase("id")) {
                // 主键约束, 忽略
                continue;
            }
            if (refTableName == null && refColumnNames == null && sameColumns(columns, "id", "version")) {
                // id-ver 唯一性约束, 忽略
                continue;
            }
            Map<String, Object> task = findMatchedConstraints(constraintVerifyTasks, columns, refTableName, refColumnNames);
            if (task != null) {
                allCNames.remove((String) task.get("name"));
                keptCNames.add(name);
                continue;
            }
            // 没找到对应的, name旧的要删掉
            if (refTableName == null) {
                //sql.add(makeRemoveConstraintSql(TYPE_PRIMARY_KEY, tableName, name));
            } else {
                sql.add(makeRemoveConstraintSql(TYPE_FOREIGN_KEY, tableName, name));
            }

        }
        for (String cname : allCNames) {
            String type = (String) constraintVerifyTasks.get(cname).get("type");
            if (type.equals(TYPE_PRIMARY_KEY)) {
                continue; // 暂时先跳过主键
            }
            sql.add((String) constraintVerifyTasks.get(cname).get("defaultSql"));
        }
    }

    private static String makeRemoveConstraintSql(String type, String tableName, String name) {
        if (TYPE_FOREIGN_KEY.equals(type)) {
            return String.format("alter table %s drop foreign key %s;\n", tableName, name);
        }

        throw new RuntimeException("还没有处理" + type + "的删除");
    }

    private static Map<String, Object> findMatchedConstraints(LinkedHashMap<String, Map<String, Object>> constraintVerifyTasks, String columns, String refTableName, String refColumnNames) {
        for (Map<String, Object> data : constraintVerifyTasks.values()) {
            String columns1 = (String) data.get("columnNames");
            String refTableName1 = (String) data.get("refTableName");
            String refColumnNames1 = (String) data.get("refColumnNames");
            if (!sameColumns(columns1, columns.split("\\s*,\\s*"))) {
                continue;
            }
            if (refTableName1 == null) {
                return data; // 如果没有外键, 字段相同就算找到了
            }
            if (!refTableName1.equalsIgnoreCase(refTableName)) {
                continue;
            }
            if (!sameColumns(refColumnNames1, refColumnNames.split("\\s*,\\s*"))) {
                continue;
            }
            return data;
        }
        return null;
    }

    private static boolean sameColumns(String columnNames, String... wantedColumnNames) {
        List<String> list1 = new ArrayList<>(Arrays.asList(columnNames.split("\\s*,\\s*")));
        List<String> list2 = new ArrayList<>(Arrays.asList(wantedColumnNames));
        if (list1.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equalsIgnoreCase(list2.get(i))) {
                continue;
            }
            return false;
        }
        return true;
    }

    private static void addConstraintVerify(Map<String, Map<String, Object>> tasks, String constraintType, String csSql, String tName, String cName, String kName, String rtName, String rcName) {
        tasks.put(kName, MapUtil.put("type", constraintType)
                .put("tableName", tName)
                .put("columnNames", cName)
                .put("name", kName)
                .put("refTableName", rtName)
                .put("refColumnNames", rcName)
                .put("defaultSql", csSql)
                .into_map());
    }

    private static void addConstraintVerify(Map<String, Map<String, Object>> tasks, String constraintType, String csSql, String tName, String cName, String kName) {
        tasks.put(kName, MapUtil.put("type", constraintType)
                .put("tableName", tName)
                .put("columnNames", cName)
                .put("name", kName)
                .put("defaultSql", csSql)
                .into_map());
    }


    private static String makeAlterFieldSql(String tableName, String fieldName, String fieldType, String fieldNullable, String fieldTitle) {
        // ALTER TABLE `yrzx`.`account_book_data`
        //CHANGE COLUMN `type` `type2` INT NULL DEFAULT NULL COMMENT '类型' ;
        return String.format("ALTER TABLE %s CHANGE COLUMN %s %s %s %s COMMENT '%s';",
                tableName, fieldName, fieldName, fieldType,
                TextUtil.isBlank(fieldNullable) ? "NULL DEFAULT NULL" : "NOT NULL",
                fieldTitle);
    }

    private static String makeAddFieldSql(String tableName, String fieldName, String fieldType, String fieldNullable, String fieldTitle, String lstFieldName) {
        // ALTER TABLE `yrzx`.`account_book_data`
        //ADD COLUMN `fieldName` VARCHAR(48) NULL DEFAULT NULL COMMENT '所有人' AFTER `type`;

        return String.format("ALTER TABLE %s ADD COLUMN %s %s %s COMMENT '%s'%s;",
                tableName, fieldName, fieldType,
                TextUtil.isBlank(fieldNullable) ? "NULL DEFAULT NULL" : "NOT NULL",
                fieldTitle, lstFieldName == null ? "" : (" AFTER " + lstFieldName));
    }


    private static String makeCreateTableSql(String tableName, String title, String[][] fieldInfo, String[] indexSql, String[] constraintSqls) {
        StringBuilder sb = new StringBuilder("drop table  if exists ").append(tableName).append(";\r\n");
        sb.append("create table ").append(tableName).append(" (\r\n");
        for (int i = 0; i < fieldInfo.length; i++) {
            String[] fi = fieldInfo[i];
            sb.append("        ").append(fi[0]).append(' ')
                    .append(fi[1]).append(' ')
                    .append(fi[2]).append(" comment '")
                    .append(fi[3]).append("'");
            if (i < (fieldInfo.length - 1)) {
                sb.append(",\r\n");
            } else {
                sb.append("\r\n");
            }
        }
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = \"").append(title).append("\";");
        if (indexSql != null) {
            sb.append("\r\n").append(String.join("\r\n", indexSql));
        }
        if (constraintSqls != null) {
            sb.append("\r\n").append(String.join("\r\n", constraintSqls));
        }
        return sb.toString();
    }


    public static Map<String, Object> verifyData(String tableName, String[][] rowData, DBQuerier q) throws Exception {
        List<String> sqls = new ArrayList<>();
        if (!q.isTableExists(tableName)) {
            return MapUtil.put("result", false)
                    .put("message", "table " + tableName + " not existed, please create the table first")
                    .put("sql", String.join("\r\n", sqls))
                    .into_map();
        }
        String sql = "select * from " + tableName + " where code=?";

        for (String[] rowDatum : rowData) {
            String code = rowDatum[0];
            String values = rowDatum[1];
            List<Map<String, Object>> list = q.queryForMapList(sql, new Object[]{code});
            if (list == null || list.isEmpty()) {
                sqls.add(makeInsertDataSql(tableName, values));
                continue;
            }
            if (list.size() == 1) {
                continue;
            }
            sqls.add(makeDeleteSql(tableName, code));
            sqls.add(makeInsertDataSql(tableName, values));
        }

        if (sqls.isEmpty()) {
            return MapUtil.put("result", true)
                    .into_map();
        }
        return MapUtil.put("result", false)
                .put("message", "table " + tableName + " data not same with what defined in model")
                .put("sql", String.join("\r\n", sqls))
                .into_map();
    }

    private static String makeDeleteSql(String tableName, String code) {
        return "delete from " + tableName + " where code=" + code + ";";
    }

    private static String makeInsertDataSql(String tableName, String values) {
        return "insert into " + tableName + " (" + getFieldNameList(tableName) + ") " + " values(" + values + ");";
    }

    private static String getFieldNameList(String tableName) {
        return String.join(",", tableFieldNames.get(tableName));
    }

    private static void saveTableFieldNames(String tableName, String[][] fieldInfo) {
        List<String> fNames = Stream.of(fieldInfo).map(fi -> fi[0]).collect(Collectors.toList());
        tableFieldNames.put(tableName, fNames);
    }
}
