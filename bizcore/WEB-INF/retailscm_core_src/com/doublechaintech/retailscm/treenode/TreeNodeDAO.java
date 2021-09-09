
package com.doublechaintech.retailscm.treenode;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import java.util.Map;
import com.terapico.caf.baseelement.CandidateQuery;
import com.doublechaintech.retailscm.BaseDAO;
import com.doublechaintech.retailscm.BaseEntity;
import com.doublechaintech.retailscm.SmartList;
import com.doublechaintech.retailscm.MultipleAccessKey;
import com.doublechaintech.retailscm.RetailscmUserContext;




public interface TreeNodeDAO extends BaseDAO{

	public SmartList<TreeNode> loadAll();
	public Stream<TreeNode> loadAllAsStream();
	public TreeNode load(String id, Map<String,Object> options) throws Exception;
	public void enhanceList(List<TreeNode> treeNodeList);
	public void collectAndEnhance(BaseEntity ownerEntity);

	public void alias(List<BaseEntity> entityList);


	

	public TreeNode present(TreeNode treeNode,Map<String,Object> options) throws Exception;
	public TreeNode clone(String id, Map<String,Object> options) throws Exception;

	

	public TreeNode save(TreeNode treeNode,Map<String,Object> options);
	public SmartList<TreeNode> saveTreeNodeList(SmartList<TreeNode> treeNodeList,Map<String,Object> options);
	public SmartList<TreeNode> removeTreeNodeList(SmartList<TreeNode> treeNodeList,Map<String,Object> options);
	public SmartList<TreeNode> findTreeNodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public int countTreeNodeWithKey(MultipleAccessKey key,Map<String, Object> options);
	public Map<String, Integer> countTreeNodeWithGroupKey(String groupKey, MultipleAccessKey filterKey,
			Map<String, Object> options);
	public void delete(String treeNodeId, int version) throws Exception;
	public TreeNode disconnectFromAll(String treeNodeId, int version) throws Exception;
	public int deleteAll() throws Exception;
	public void resetNextId();

	
	

	public SmartList<TreeNode> queryList(String sql, Object ... parameters);
	public List<String> queryIdList(String sql, Object ... parameters);
	public Stream<TreeNode> queryStream(String sql, Object... parameters) ;
	public int count(String sql, Object ... parameters);
	public CandidateTreeNode executeCandidatesQuery(CandidateQuery query, String sql, Object ... parmeters) throws Exception ;


	List<TreeNode> search(TreeNodeRequest pRequest);
}

















