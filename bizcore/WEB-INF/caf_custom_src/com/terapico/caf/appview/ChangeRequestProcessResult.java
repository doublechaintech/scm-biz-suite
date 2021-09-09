package com.terapico.caf.appview;

import com.terapico.uccaf.CafEntity;
import java.util.Map;

public class ChangeRequestProcessResult {
  public static final String CODE_COMMITTED = "commited"; // 判断此次是个commit操作,通常需要业务介入
  public static final String CODE_NOT_COMMITTED = "notCommit"; // 还没走完所有的scene, 没有提交整个CR

  protected ChangeRequestPostData postedData; // 提交的数据
  protected CafEntity changeRequest; // 根据提交的数据,加载出来的 ChangeRequest 对象
  protected String resultCode; // 处理结果代码, 见CODE_COMMITTED/CODE_NOT_COMMITTED
  protected String newChangeRequestType; // 处理结束后,下一步的CR type(应该不需要中途改CR类型,有点乱,但是先留着)
  protected String newSceneCode; // 处理结束后,下一步的scenceCode
  protected Map<String, Integer>
      newGroupIds; // 暂时不用. 用来说明处理结束后,下一步的scence中, 每个group都应该加载哪个group. 暂不在目前的scope里

  public ChangeRequestPostData getPostedData() {
    return postedData;
  }

  public void setPostedData(ChangeRequestPostData postedData) {
    this.postedData = postedData;
  }

  public CafEntity getChangeRequest() {
    return changeRequest;
  }

  public void setChangeRequest(CafEntity changeRequest) {
    this.changeRequest = changeRequest;
  }

  public String getResultCode() {
    return resultCode;
  }

  public void setResultCode(String resultCode) {
    this.resultCode = resultCode;
  }

  public String getNewChangeRequestType() {
    return newChangeRequestType;
  }

  public void setNewChangeRequestType(String newChangeRequestType) {
    this.newChangeRequestType = newChangeRequestType;
  }

  public String getNewSceneCode() {
    return newSceneCode;
  }

  public void setNewSceneCode(String newSceneCode) {
    this.newSceneCode = newSceneCode;
  }

  public Map<String, Integer> getNewGroupIds() {
    return newGroupIds;
  }

  public void setNewGroupIds(Map<String, Integer> newGroupIds) {
    this.newGroupIds = newGroupIds;
  }
}
