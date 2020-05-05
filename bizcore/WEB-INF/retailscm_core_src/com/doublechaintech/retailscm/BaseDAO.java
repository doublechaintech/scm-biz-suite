package com.doublechaintech.retailscm;


public interface BaseDAO {
	/**
	 * 以id='ownerId'的,类型为'resutlClassName'.'ownerMemberName'为出发点, 查看'resutlClassName'.'resultMemberName',类型为'targetClassName'的所有对象,用于过滤搜索结果.<p>
	 * 例如 requestCandidateValuesForSearch(author,A000001,postBy,artwork,MoyiUser)
	 * 表示 以 artwork.author.id='A000001' 的对象为出发点, 查看它所关联的,所有关联到artwork.postBy的moyiUser对象,来过滤artwork列表.
	 */
	SmartList<BaseEntity> requestCandidateValuesForSearch(String ownerMemberName, String ownerId, String resultMemberName, String resutlClassName, String targetClassName, String searchKey, int pageNo);
}















