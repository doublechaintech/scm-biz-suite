package com.terapico.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import com.terapico.caf.baseelement.CandidateQuery;

@SuppressWarnings("unchecked")
public abstract class BaseCandidatesUtil {
	
	protected static class Initor {
		protected String modelName;
		protected String workingType; // usedIn|referTo
		protected String workingModelName;

		public Initor(String name) {
			this.modelName = name;
		}

		protected Map<String, Object> get() {
			Map<String, Object> rst = QUERY_RELATIONS.get(this.modelName);
			if (rst != null) {
				return rst;
			}
			rst = new HashMap<>();
			QUERY_RELATIONS.put(modelName, rst);
			return rst;
		}

		protected void addData(String dataLabel, String typeName, String data) {
			Map<String, Object> cData = (Map<String, Object>) get().get(dataLabel);
			if (cData == null) {
				cData = new HashMap<>();
				get().put(dataLabel, cData);
			}
			List<String> existedData = (List<String>) cData.get(typeName);
			if (existedData == null) {
				existedData = new ArrayList<>();
				cData.put(typeName, existedData);
			}
			existedData.add(data);
		}

		public Initor usedIn(String typeName) {
			this.workingModelName = typeName;
			this.workingType = "usedIn";
			return this;
		}

		public Initor withRole(String columnName) {
			addData(workingType, workingModelName, columnName);
			return this;
		}

		public Initor referTo(String typeName) {
			this.workingModelName = typeName;
			this.workingType = "referTo";
			return this;
		}

		public Initor targetType(String value) {
			get().put("name", value);
			return this;
		}

		public Initor groupBy(String typeName) {
			this.workingModelName = typeName;
			this.workingType = "groupBy";
			return this;
		}

		public Initor whichType(String value) {
			addData(workingType, workingModelName, value);
			return this;
		}

		public Initor isTree(Object value) {
			get().put("isTree", DataTypeUtil.getBoolean(value));
			return this;
		}

		public Initor hasFields(String string) {
			get().put("fields", string);
			return this;
		}

		public Initor anchorColumn(String value) {
			get().put("anchorColumn", value);
			return this;
		}

	}

	protected static Map<String, Map<String, Object>> QUERY_RELATIONS = new HashMap<>();

	protected abstract String normalizeModelName(String typeName) throws Exception;

	protected abstract String getDisplayNameColumn(String typeName);

	protected static Initor _for(String name) {
		return new Initor(name);
	}
	
	protected CandidateQuery prepareQueryInput(CandidateQuery orginalQuery) throws Exception {
		
		// 先规整参数名字,都用模型名的格式
		CandidateQuery query = getQueryFromInput(orginalQuery);
		// check Target related params
		checkTargetParams(orginalQuery, query);
		// fix params
		fixOwnerParam(query);
		fixListParam(query);
		fixOwnerInListParam(query);
		fixGroupByParam(query);
		fixOwnerRoleInTarget(query);
		fixOwnerRoleInList(query);
		fixTargetRoleInList(query);
		autoFillOwnerRoleInTarget(query);
		autoFillTargetRoleInList(query);
		autoFillOwnerRoleInList(query);
		autoFillGroupBy(query);
		
		System.out.println("最终的查询参数为:" + DebugUtil.dumpAsJson(query, true));
		return query;
	}

	

	

	protected void autoFillGroupBy(CandidateQuery query) {
		if (query.getGroupBy() != null) {
			return; // 已经填好了
		}
		// 如果只有一个group by,那么就用这个
		Map<String, List<String>> groupByMap = this.getGroupByMap(query.getTargetType());
		if (groupByMap == null || groupByMap.size() != 1) {
			return; // 算不来
		}
		List<String> fields = groupByMap.values().iterator().next();
		if (fields == null || fields.size() != 1) {
			return; // 无法确定
		}
		query.setGroupBy(fields.get(0));
	}

	// 1. 必须; 2. 是已知类型
	protected void checkTargetParams(CandidateQuery orginalQuery, CandidateQuery query) throws Exception {
		if (TextUtil.isBlank(query.getTargetType())) {
			throw new Exception("您未指定查询的目标类型");
		}
		if (getDataByType(query.getTargetType()) == null) {
			throw new Exception(orginalQuery.getTargetType()+"不是本系统内定义的类型");
		}
	}
	// 1. type和ID必须同时提供; 2. type必须是已知类型
	protected void fixOwnerParam(CandidateQuery query) {
		if (TextUtil.isBlank(query.getOwnerId()) || TextUtil.isBlank(query.getOwnerType())) {
			query.setOwnerType(null);
			query.setOwnerId(null);
			return;
		}
		if (getDataByType(query.getOwnerType()) == null) {
			query.setOwnerType(null);
			query.setOwnerId(null);
			return;
		}
	}
	// 1. type 必须是已知类型
	protected void fixListParam(CandidateQuery query) {
		if (TextUtil.isBlank(query.getListType())) {
			query.setListType(null);
			query.setOwnerRoleInList(null);
			return;
		}
		if (getDataByType(query.getListType()) == null) {
			query.setListType(null);
			query.setOwnerRoleInList(null);
			return;
		}
	}
	// 1. 必须是target中的某个字段
	protected void fixGroupByParam(CandidateQuery query) {
		if (TextUtil.isBlank(query.getGroupBy())) {
			query.setGroupBy(null);
			return;
		}
		if (!typeHasField(query.getTargetType(), query.getGroupBy())) {
			query.setGroupBy(null);
			return;
		}
	}
	// 1. owner参数要正常	2. 必须是已知的对象字段名 （target里的字段，指向Owner类型）"
	protected void fixOwnerRoleInTarget(CandidateQuery query) {
		if (query.getOwnerType() == null || TextUtil.isBlank(query.getOwnerRoleInTarget())) {
			query.setOwnerRoleInTarget(null);
			return;
		}
		if (!hasCorrentOwnerRole(query)) {
			query.setOwnerRoleInTarget(null);
		}
	}
	// 1. owner参数要正常	2. 必须是已知的对象字段名 （target里的字段，指向Owner类型）"
	protected void fixOwnerRoleInList(CandidateQuery query) {
		if (query.getOwnerType() == null || query.getListType() == null || TextUtil.isBlank(query.getOwnerRoleInList())) {
			query.setOwnerRoleInList(null);
			return;
		}
		if (!hasCorrectOwnerRoleInList(query)) {
			query.setOwnerRoleInList(null);
			return;
		}
	}
	// 1. owner参数要正常	2. 必须是已知的对象字段名 （target里的字段，指向Owner类型）"
	protected void fixTargetRoleInList(CandidateQuery query) {
		if (query.getTargetType() == null || query.getListType() == null || TextUtil.isBlank(query.getTargetRoleInList())) {
			query.setTargetRoleInList(null);
			return;
		}
		if (!hasCorrectReferRoleByList(query)) {
			query.setOwnerRoleInList(null);
			return;
		}
	}
	
	// 自动填充 ownerRoleInTarget
	protected void autoFillOwnerRoleInTarget(CandidateQuery query) {
		if (query.getOwnerType() == null) {
			return; // 不用填
		}
		if (query.getOwnerRoleInTarget() != null) {
			return; // 已经有了
		}
		// 如果有指定的 owner 和 target 关系 且只有一个, 就用这个
		Map<String, List<String>> rtMap = this.getReferToMap(query.getTargetType());
		if (rtMap == null) {
			return; // 无法计算
		}
		List<String> referToField = rtMap.get(query.getOwnerType());
		if (referToField == null) {
			return; // 无法计算
		}
		query.setOwnerRoleInTarget(String.join(",",referToField));
	}
	// 自动填充 ownerRoleInList
	protected void autoFillOwnerRoleInList(CandidateQuery query) {
		if (query.getOwnerType() == null || query.getListType() == null) {
			return; // 不用填
		}
		if (query.getOwnerRoleInList() != null) {
			return; // 已经有了
		}
		// 如果有指定的 owner 和 list 关系 且只有一个, 就用这个
		Map<String, List<String>> rtMap = this.getReferToMap(query.getListType());
		if (rtMap == null) {
			return; // 无法计算
		}
		List<String> referToField = rtMap.get(query.getOwnerType());
		if (referToField == null) {
			return; // 无法计算
		}
		query.setOwnerRoleInList(String.join(",", referToField));
	}
	// 自动填充 targetRoleInList
	protected void autoFillTargetRoleInList(CandidateQuery query) {
		if (query.getListType() == null || query.getTargetRoleInList() != null) {
			return;
		}
		// 如果指定的 list 只有一个字段引用 target, 就用这个
		Map<String, List<String>> rtMap = this.getReferToMap(query.getListType());
		if (rtMap == null || rtMap.size() != 1) {
			return; // 无法计算
		}
		List<String> referToField = rtMap.get(query.getTargetType());
		if (referToField == null || referToField.size() != 1) {
			return; // 无法计算
		}
		query.setTargetRoleInList(referToField.get(0));
	}
	
	// 检查指定的类型 typeName 中是否有字段 fieldName
	protected boolean typeHasField(String typeName, String fieldName) {
		Map<String, Object> data = getDataByType(typeName);
		if (data == null) {
			return false;
		}
		String fields = (String) data.get("fields");
		if (fields != null && fields.contains(";"+fieldName+";")) {
			return true;
		}
		Map<String, List<String>> referToMap = this.getReferToMap(typeName);
		return referToMap.values().stream().flatMap(list->list.stream()).anyMatch(fname->fname.equals(fieldName));
	}

	protected CandidateQuery getQueryFromInput(CandidateQuery orginalQuery) throws Exception {
		CandidateQuery query = new CandidateQuery();
		query.setTargetType(normalizeModelName(orginalQuery.getTargetType()));
		query.setFilterKey(orginalQuery.getFilterKey());
		query.setGroupBy(normalizeModelName(orginalQuery.getGroupBy()));
		
		query.setOwnerType(normalizeModelName(orginalQuery.getOwnerType()));
		query.setOwnerId(orginalQuery.getOwnerId());
		query.setListType(normalizeModelName(orginalQuery.getListType()));
		query.setScenceCode(orginalQuery.getScenceCode());
		
		query.setOwnerRoleInList(normalizeModelName(orginalQuery.getOwnerRoleInList()));
		query.setOwnerRoleInTarget(normalizeModelName(orginalQuery.getOwnerRoleInTarget()));
		query.setTargetRoleInList(normalizeModelName(orginalQuery.getTargetRoleInList()));
		
		query.setPageNo(Math.max(1,orginalQuery.getPageNo()));
		query.setPageSize(Math.max(orginalQuery.getPageSize(), 20));
		return query;
	}

	

	protected void fixOwnerInListParam(CandidateQuery query) {
		if (!isCorrectListInOwner(query)) {
			query.setListType(null);
			query.setOwnerRoleInList(null);
		} else if (!hasCorrectOwnerRoleInList(query)) {
			query.setOwnerRoleInList(null);
		}
	}

	

	

	protected String getGroupByBame(CandidateQuery query) {
		Map<String, List<String>> data = getGroupByMap(query.getTargetType());
		if (data == null || data.isEmpty()) {
			return null;
		}
		return data.keySet().iterator().next();
	}

	protected boolean isCorrectGroupByParam(CandidateQuery query) {
		if (query.getGroupBy() == null) {
			return false;
		}
		// 有指定, 但是可能是普通字段,也可能是对象属性
		if (query.getGroupBy() != null) {
			return true;
		}
		Map<String, List<String>> groupByMap = getGroupByMap(query.getTargetType());
		if (groupByMap == null || query.getGroupBy() == null) {
			return false;
		}
		return groupByMap.containsKey(query.getGroupBy());
	}

	protected boolean isCorrectListInOwner(CandidateQuery query) {
		Map<String, List<String>> listReferToMap = getReferToMap(query.getListType());
		if (listReferToMap == null || query.getOwnerType() == null) {
			return false;
		}
		return listReferToMap.containsKey(query.getOwnerType());
	}

	protected boolean hasCorrectOwnerRoleInList(CandidateQuery query) {
		Map<String, List<String>> listReferToMap = getReferToMap(query.getListType());
		if (listReferToMap == null || query.getOwnerType() == null || query.getOwnerRoleInList() == null) {
			return false;
		}
		List<String> roles = listReferToMap.get(query.getOwnerType());
		if (roles == null) {
			return false;
		}
		return roles.contains(query.getOwnerRoleInList());
	}

	protected boolean isCorrectReferByList(CandidateQuery query) {
		Map<String, List<String>> usedInMap = getUsedInMap(query.getTargetType());
		if (usedInMap == null || query.getListType() == null) {
			return false;
		}
		return usedInMap.containsKey(query.getListType());
	}

	protected boolean hasCorrectReferRoleByList(CandidateQuery query) {
		Map<String, List<String>> usedInMap = getUsedInMap(query.getTargetType());
		if (usedInMap == null || query.getListType() == null || query.getTargetRoleInList() == null) {
			return false;
		}
		List<String> roles = usedInMap.get(query.getListType());
		if (roles == null) {
			return false;
		}
		return roles.contains(query.getTargetRoleInList());
	}

	protected boolean hasCorrentOwnerRole(CandidateQuery query) {
		Map<String, List<String>> referToMap = getReferToMap(query.getTargetType());
		if (referToMap == null || query.getOwnerType() == null || query.getOwnerRoleInTarget() == null) {
			return false;
		}
		List<String> roles = referToMap.get(query.getOwnerType());
		return roles.contains(query.getOwnerRoleInTarget());
	}

	protected Map<String, List<String>> getReferToMap(String targetType) {
		return getListDataByRelationType(targetType, "referTo");
	}

	protected Map<String, List<String>> getUsedInMap(String targetType) {
		return getListDataByRelationType(targetType, "usedIn");
	}

	protected Map<String, List<String>> getGroupByMap(String targetType) {
		return getListDataByRelationType(targetType, "groupBy");
	}

	protected Map<String, List<String>> getListDataByRelationType(String targetType, String relationType) {
		Map<String, Object> data = getDataByType(targetType);
		if (data == null) {
			return null;
		}
		return (Map<String, List<String>>) data.get(relationType);
	}

	protected Map<String, Object> getDataByType(String targetType) {
		if (targetType == null) {
			return null;
		}
		Map<String, Object> data = QUERY_RELATIONS.get(targetType);
		return data;
	}

	/**
	 * assign 场景下, 忽略List的任何信息, 所以只需要考虑 ownerRoleInTarget
	 * @param query
	 * @param params
	 * @return
	 */
	protected String prepareSqlForAssign(CandidateQuery query, List<Object> params) {
		StringBuilder sb = new StringBuilder();
		String displayNameColumn = getDisplayNameColumn(query.getTargetType());
		// select
		sb.append("select distinct T.* from ").append(getDbTableName(query.getTargetType())).append(" T ");
		if (query.getOwnerRoleInTarget() != null) {
			sb.append(" left join ").append(getDbTableName(query.getOwnerType())).append(" O on ")
					.append(makeJoinConditionClause("T", "O", query.getOwnerRoleInTarget().split(",")));
		}

		// where
		String wherePrefix = " where ";
		if (query.getOwnerId() != null && query.getOwnerRoleInTarget() != null) {
			sb.append(wherePrefix).append(" O.id=? ");
			params.add(query.getOwnerId());
			wherePrefix = " and ";
		}
		if (!TextUtil.isBlank(query.getFilterKey())) {
			sb.append(wherePrefix).append("( T.").append(displayNameColumn).append(" like ? or T.id like ?) ");
			params.add("%" + query.getFilterKey() + "%");
			params.add("%" + query.getFilterKey() + "%");
			wherePrefix = " and ";
		}
		String anchorColumn = getAnchorColumn(query.getTargetType());
		if (anchorColumn != null) {
			sb.append(wherePrefix).append(" T.").append(anchorColumn).append(" is not null ");
			wherePrefix = " and ";
		}
		
		// order by
		{
			sb.append(" order by cast(T.").append(displayNameColumn)
					.append(" as CHAR CHARACTER SET GBK) asc , T.id desc");
		}

		// limit
		if (query.getPageNo() <= 1) {
			sb.append(" limit ? ");
			params.add(query.getPageSize());
		} else {
			int offSet = (Math.max(1, query.getPageNo()) - 1) * query.getPageSize();
			sb.append(" limit ?,? ");
			params.add(offSet);
			params.add(query.getPageSize());
		}
		return sb.toString();
	}

	protected String getJavaClassName(String targetType) {
		return TextUtil.toCamelCase(targetType);
	}

	protected String getJavaMemberName(String targetType) {
		return TextUtil.uncapFirstChar(TextUtil.toCamelCase(targetType));
	}
	
	protected String getDbTableName(String targetType) {
		if(targetType==null) {
			throw new IllegalArgumentException("Table name for type "+targetType+" not found");
		}
		return targetType.toLowerCase() + "_data";
	}
	protected void checkQueryForSearch(CandidateQuery query, List<Object> params) {
		// TODO Auto-generated method stub
		if(query==null) {
			throw new IllegalArgumentException("checkQueryForSearch(CandidateQuery query, List<Object> params) "+query+" can not be null");

		}
		
		String[] checkList= {
				"query.getTargetType()",query.getTargetType(),
				"query.getOwnerType()",query.getOwnerType(),
				"query.getTargetType()",query.getTargetType(),
				"query.getListType()",query.getListType(),
				"query.getOwnerId()",query.getOwnerId(),
				
		};
		
		int length = checkList.length;
		for(int i=0;i<length;i++) {
			String target = checkList[i];
			if(target!=null) {
				continue;
			}
			String parameterName = checkList[i-1];
			String message = String.format("Parameter '%s' in '%s' is not expected to be null",
					parameterName,"prepareSqlForSearch(CandidateQuery query, List<Object> params)");
			throw new IllegalArgumentException(message);
		}
		
		
	}
	protected String prepareSqlForSearch(CandidateQuery query, List<Object> params) {
		if (query.getOwnerRoleInList() != null && query.getOwnerRoleInTarget() != null && query.getTargetRoleInList() != null) {
			return prepareSqlForSearchWhenAllRelationExists(query, params);
		}
		
		checkQueryForSearch(query,params);
		
		StringBuilder sb = new StringBuilder();
		String displayNameColumn = getDisplayNameColumn(query.getTargetType());
		String tblOwner = getDbTableName(query.getOwnerType());
		String tblTarget = getDbTableName(query.getTargetType());
		String tblList = getDbTableName(query.getListType());
		// select
		sb.append("select distinct T.* from ").append(tblTarget).append(" T ");
		if (query.getOwnerRoleInTarget() != null) {
			sb.append(" left join ").append(tblOwner).append(" O on ")
			.append(makeJoinConditionClause("T", "O", query.getOwnerRoleInTarget().split(",")));
		}
		if (query.getTargetRoleInList() != null) {
			sb.append(" left join ").append(tblList).append(" L on ")
				.append(makeJoinConditionClause("L", "T", query.getTargetRoleInList().split(",")));
		}

		// where
		String wherePrefix = " where ";
		if (query.getOwnerRoleInTarget() != null) {
			sb.append(wherePrefix).append(" O.id=? ");
			params.add(query.getOwnerId());
			wherePrefix = "and";
		}
		if (query.getTargetRoleInList() != null) {
			sb.append(wherePrefix).append(" L.id is not null ");
			wherePrefix = "and";
		}
		if (!TextUtil.isBlank(query.getFilterKey())) {
			sb.append(wherePrefix).append("( T.").append(displayNameColumn).append(" like ? or T.id like ?) ");
			params.add("%" + query.getFilterKey() + "%");
			params.add("%" + query.getFilterKey() + "%");
			wherePrefix = "and";
		}
		String anchorColumn = getAnchorColumn(query.getTargetType());
		if (anchorColumn != null) {
			sb.append(wherePrefix).append(" T.").append(anchorColumn).append(" is not null ");
		}
		
		// order by
		{
			sb.append(" order by cast(T.").append(displayNameColumn)
					.append(" as CHAR CHARACTER SET GBK) asc , T.id desc");
		}

		// limit
		if (query.getPageNo() <= 1) {
			sb.append(" limit ? ");
			params.add(query.getPageSize());
		} else {
			int offSet = (Math.max(1, query.getPageNo()) - 1) * query.getPageSize();
			sb.append(" limit ?,? ");
			params.add(offSet);
			params.add(query.getPageSize());
		}
		return sb.toString();
	}

	

	protected String prepareSqlForSearchWhenAllRelationExists(CandidateQuery query, List<Object> params) {
		StringBuilder sb = new StringBuilder();
		String tblOwner = getDbTableName(query.getOwnerType());
		String tblTarget = getDbTableName(query.getTargetType());
		String tblList = getDbTableName(query.getListType());
		sb.append("select distinct T.* from ").append(tblTarget).append(" T ");
		sb.append(" left join ").append(tblOwner).append(" O on ")
				.append(makeJoinConditionClause("T", "O", query.getOwnerRoleInTarget().split(",")));
		sb.append(" left join ").append(tblList).append(" L on ")
				.append(makeJoinConditionClause("L", "O", query.getOwnerRoleInList().split(",")));
		sb.append(" where O.id=? and exists (select id from ").append(tblList).append(" X where ")
			.append(makeJoinConditionClause("X", "T", query.getTargetRoleInList().split(",")))
			.append(")");
		params.add(query.getOwnerId());
		String displayNameColumn = getDisplayNameColumn(query.getTargetType());
		if (!TextUtil.isBlank(query.getFilterKey())) {
			sb.append(" and ( T.").append(displayNameColumn).append(" like ? or T.id like ?) ");
			params.add("%" + query.getFilterKey() + "%");
			params.add("%" + query.getFilterKey() + "%");
		}
		String anchorColumn = getAnchorColumn(query.getTargetType());
		if (anchorColumn != null) {
			sb.append(" and T.").append(anchorColumn).append(" is not null ");
		}
		
		// order by
		{
			sb.append(" order by cast(T.").append(displayNameColumn)
					.append(" as CHAR CHARACTER SET GBK) asc , T.id desc");
		}

		// limit
		if (query.getPageNo() <= 1) {
			sb.append(" limit ? ");
			params.add(query.getPageSize());
		} else {
			int offSet = (Math.max(1, query.getPageNo()) - 1) * query.getPageSize();
			sb.append(" limit ?,? ");
			params.add(offSet);
			params.add(query.getPageSize());
		}
		return sb.toString();
	}

	protected String getAnchorColumn(String targetType) {
		Map<String, Object> data = this.getDataByType(targetType);
		if (data == null) {
			return null;
		}
		return (String) data.get("anchorColumn");
	}

	protected String makeJoinConditionClause(String L, String O, String[] roles) {
		StringBuilder sb = new StringBuilder();
		if (roles.length == 1) {
			sb.append(L).append(".").append(roles[0]).append("=").append(O).append(".id");
		}else {
			String pre = "";
			sb.append("(");
			for(String role: roles) {
				sb.append(pre).append(L).append(".").append(role).append("=").append(O).append(".id");
				pre = " or ";
			}
			sb.append(")");
		}
		return sb.toString();
	}

	protected boolean isGroupByObject(CandidateQuery query) {
		String typeName = getGroupByTypeName(query);
		return typeName != null;
	}
	
	protected String getGroupByTypeName(CandidateQuery query) {
		if (query.getGroupBy() == null) {
			return null;
		}
		Map<String, List<String>> referToMap = getReferToMap(query.getTargetType());
		if (referToMap == null) {
			return null; // 目标类型没有指向任何其他类型, 就一定不是 group by Object
		}
		for(String typeName: referToMap.keySet()) {
			List<String> roles = referToMap.get(typeName);
			if (roles.contains(query.getGroupBy())) {
				return typeName;
			}
		}
		return null;
	}

	protected boolean isGroupByTree(CandidateQuery query) {
		String typeName = getGroupByTypeName(query);
		if (typeName == null) {
			return false;
		}
		Map<String, Object> data = getDataByType(typeName);
		if (data == null) {
			return false;
		}
		return DataTypeUtil.getBoolean(data.get("isTree"));
	}

	protected static final Pattern ptnFieldName = Pattern.compile("^[\\w]+$"); // \w = [A-Za-z0-9_]
	protected boolean isValidFieldName(String name) {
		if (TextUtil.isBlank(name)) {
			return true; // 允许空参数
		}
		return ptnFieldName.matcher(name).matches();
	}

}
