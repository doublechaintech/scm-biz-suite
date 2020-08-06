package com.terapico.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DBChecker {
    protected static Map<String, List<String>> tableFieldNames = new HashMap<>();
    public static Map<String, Object> verifyTable(String tableName, String title, String[][] fieldInfo, String[] indexSql, String[] constraintSql, DBQuerier q) throws Exception {
        saveTableFieldNames(tableName, fieldInfo);
        if (!q.isTableExists(tableName)){
            return MapUtil.put("exists", false)
                    .put("message", tableName+"("+title+") not exists")
                    .put("result", false)
                    .put("sql", makeCreateTableSql(tableName, title, fieldInfo, indexSql, constraintSql))
                    .into_map();
        }

        List<String> sql = new ArrayList<>();
        for (String[] strings : fieldInfo) {
            String fieldName = strings[0];
            String fieldType = strings[1];
            String fieldNullable = strings[2];
            String fieldTitle = strings[3];
            String referTableName = strings[4];
            String referFieldName = strings[5];
            if (!q.isFieldExists(tableName, fieldName)){
                sql.add(makeAddFieldSql(tableName, fieldName, fieldType, fieldNullable, fieldTitle));
                continue;
            }
            if (!q.isFieldSame(tableName, fieldName, fieldType)){
                sql.add(makeAlterFieldSql(tableName, fieldName, fieldType, fieldNullable, fieldTitle));
            }
        }
        if (sql.isEmpty()) {
            return MapUtil.put("exists", true)
                    .put("result", true)
                    .into_map();
        }

        return MapUtil.put("exists", true)
                .put("result", false)
                .put("message", "table " + tableName+" field changed")
                .put("sql", String.join("\r\n", sql))
                .into_map();

    }



    private static String makeAlterFieldSql(String tableName, String fieldName, String fieldType, String fieldNullable, String fieldTitle) {
        // ALTER TABLE `yrzx`.`account_book_data`
        //CHANGE COLUMN `type` `type2` INT NULL DEFAULT NULL COMMENT '类型' ;
        return String.format("ALTER TABLE %s CHANGE COLUMN %s %s %s %s COMMENT '%s';",
                tableName,fieldName,fieldName,fieldType,
                TextUtil.isBlank(fieldNullable)?"NULL DEFAULT NULL":"NOT NULL",
                fieldTitle);
    }

    private static String makeAddFieldSql(String tableName, String fieldName, String fieldType, String fieldNullable, String fieldTitle) {
        // ALTER TABLE `yrzx`.`account_book_data`
        //ADD COLUMN `fieldName` VARCHAR(48) NULL DEFAULT NULL COMMENT '所有人' AFTER `type`;
        return String.format("ALTER TABLE %s ADD COLUMN %s %s %s COMMENT '%s';",
                tableName,fieldName,fieldType,
                TextUtil.isBlank(fieldNullable)?"NULL DEFAULT NULL":"NOT NULL",
                fieldTitle);
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
            if (i < (fieldInfo.length-1)){
                sb.append(",\r\n");
            }else{
                sb.append("\r\n");
            }
        }
        sb.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = \"").append(title).append("\";");
        if (indexSql != null){
            sb.append("\r\n").append(String.join("\r\n", indexSql));
        }
        if (constraintSqls != null){
            sb.append("\r\n").append(String.join("\r\n", constraintSqls));
        }
        return sb.toString();
    }


    public static Map<String, Object> verifyData(String tableName, String[][] rowData, DBQuerier q) throws Exception{
        List<String> sqls = new ArrayList<>();
        if (!q.isTableExists(tableName)) {
            return MapUtil.put("result", false)
                    .put("message", "table " + tableName+" not existed, please create the table first")
                    .put("sql", String.join("\r\n", sqls))
                    .into_map();
        }
        String sql = "select * from " + tableName +" where code=?";

        for (String[] rowDatum : rowData) {
            String code = rowDatum[0];
            String values = rowDatum[1];
            List<Map<String, Object>> list = q.queryForMapList(sql, new Object[]{code});
            if (list == null || list.isEmpty()) {
                sqls.add(makeInsertDataSql(tableName, values));
                continue;
            }
            if (list.size() == 1){
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
                .put("message", "table " + tableName+" data not same with what defined in model")
                .put("sql", String.join("\r\n", sqls))
                .into_map();
    }

    private static String makeDeleteSql(String tableName, String code) {
        return "delete from " + tableName + " where code=" + code+";";
    }

    private static String makeInsertDataSql(String tableName, String values) {
        return "insert into " + tableName +" ("+getFieldNameList(tableName)+") "+" values(" + values +");";
    }

    private static String getFieldNameList(String tableName) {
        return String.join(",",tableFieldNames.get(tableName));
    }

    private static void saveTableFieldNames(String tableName, String[][] fieldInfo) {
        List<String> fNames = Stream.of(fieldInfo).map(fi -> fi[0]).collect(Collectors.toList());
        tableFieldNames.put(tableName, fNames);
    }
}
