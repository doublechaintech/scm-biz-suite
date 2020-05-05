package com.terapico.caf.baseelement;

import com.terapico.caf.RemoteInitiable;

/**
 * 查询候选值.
 * 
 * 一个完整的候选值查询应该还包括条件,例如'状态为成功或者待处理', 这种查询的处理需要定制,不包括在自动生成的部分.
 * 这里处理的是'自然场景',可以表达为类似如下查询:<br/>
 * <p><b>查询候选的 '当前公司是合同类型制定者' 的 '合同类型' when '查看当前公司作为甲方' 的 '合同列表' in '公司' for '创建新合同'.</b></p>
 * 映射为函数名为:<br/>
 * <p><b>queryCandidate[TARGET]In[LIST(AsRole)]By[OWNER_ROLE]For[search|assign]</b></p>
 * 解释一下就是: 当前在一个公司的页面上,当用户正在创建新合同时,需要选择一个合同类型, 此时已知当前公司将会成为甲方, 并且要找的合同类型中,当前公司应该作为制定者.
 * 
 * @author clariones
 *
 */
public class CandidateQuery implements RemoteInitiable {
	public static final String FOR_ASSIGN = "assign"; // 为对象指定某个值时(例如创建,transfer),查询可用的候选值. 此时应为所有有效的值
	public static final String FOR_SEARCH = "search"; // 作为搜索过滤条件的时候,应该只有其子对象所引用的值
	public static final String FORCE_NULL = "NA"; 	  // 强制为空. 例如有group by的类型,强制不group by. 暂时不支持. 没看到必要的场景
	
	protected String targetType;	// 必须. 查询的结果,称为'Target', 这个是它的类型, 对应其InternalType的值.
	
	protected String filterKey;	// 可选. 查询的过滤关键字
	protected String groupBy;	// 可选, 候选值按照哪个字段进行分组
	
	protected String ownerType;	// 可选. 发起查询的对象, 称为'Owner', 这个是它的类型, 对应InternalType的值.
	protected String ownerId;	// 可选. Owner的ID
	protected String scenceCode = FOR_ASSIGN;		// 可选. 用于哪个场景下的查询,目前有搜索和指派两种
	protected String listType;	// 可选. 发起查询时,是在处理哪个页面上. 可能为空,例如新建页面.
	
	protected String ownerRoleInTarget;	// 可选. 发起查询的对象,在被查询对象中的角色. 对应java对象字段名
	protected String ownerRoleInList;	// 可选. 发起查询的对象,在当前list对应的对象中的角色
	protected String targetRoleInList;	// 可选. 查询的结果,在当前list对应的对象中的角色
	
	protected int pageSize = 500;	// 一页多少个. 
	protected int pageNo = 1; 		// 当前查询第几页. 1 起始
	
	public String getTargetType() {
		return targetType;
	}
	public void setTargetType(String targetType) {
		this.targetType = targetType;
	}
	public String getFilterKey() {
		return filterKey;
	}
	public void setFilterKey(String filterKey) {
		this.filterKey = filterKey;
	}
	public String getOwnerType() {
		return ownerType;
	}
	public void setOwnerType(String ownerType) {
		this.ownerType = ownerType;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getScenceCode() {
		return scenceCode;
	}
	public void setScenceCode(String scenceCode) {
		this.scenceCode = scenceCode;
	}
	public String getListType() {
		return listType;
	}
	public void setListType(String listType) {
		this.listType = listType;
	}
	public String getOwnerRoleInTarget() {
		return ownerRoleInTarget;
	}
	public void setOwnerRoleInTarget(String ownerRoleInTarget) {
		this.ownerRoleInTarget = ownerRoleInTarget;
	}
	public String getOwnerRoleInList() {
		return ownerRoleInList;
	}
	public void setOwnerRoleInList(String ownerRoleInList) {
		this.ownerRoleInList = ownerRoleInList;
	}
	public String getTargetRoleInList() {
		return targetRoleInList;
	}
	public void setTargetRoleInList(String targetRoleInList) {
		this.targetRoleInList = targetRoleInList;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getGroupBy() {
		return groupBy;
	}
	public void setGroupBy(String groupBy) {
		this.groupBy = groupBy;
	}
	
	
}
