package com.terapico.changerequest;

import com.terapico.caf.appview.ChangeRequestPostData;
import com.terapico.caf.viewcomponent.GenericFormPage;

public class ChangeRequestProcessingContext {
    protected CRSpec crSpec;
    protected CRGroupSpec groupSpec;
    protected CRFieldSpec fieldSpec;
    protected String sceneCode;
    protected ChangeRequestPostData postData;
    protected String actionCode;
    protected String changingFieldName;
    protected GenericFormPage requestData;
    protected String crId;

    public CRSpec getCrSpec() {
        return crSpec;
    }

    public void setCrSpec(CRSpec crSpec) {
        this.crSpec = crSpec;
    }

    public CRGroupSpec getGroupSpec() {
        return groupSpec;
    }

    public void setGroupSpec(CRGroupSpec groupSpec) {
        this.groupSpec = groupSpec;
    }

    public CRFieldSpec getFieldSpec() {
        return fieldSpec;
    }

    public void setFieldSpec(CRFieldSpec fieldSpec) {
        this.fieldSpec = fieldSpec;
    }

    public String getSceneCode() {
        return sceneCode;
    }

    public void setSceneCode(String sceneCode) {
        this.sceneCode = sceneCode;
    }

    public ChangeRequestPostData getPostData() {
        return postData;
    }

    public void setPostData(ChangeRequestPostData postData) {
        this.postData = postData;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public String getChangingFieldName() {
        return changingFieldName;
    }

    public void setChangingFieldName(String changingFieldName) {
        this.changingFieldName = changingFieldName;
    }

    public GenericFormPage getRequestData() {
        return requestData;
    }

    public void setRequestData(GenericFormPage requestData) {
        this.requestData = requestData;
    }

    public String getCrId() {
        return crId;
    }

    public void setCrId(String crId) {
        this.crId = crId;
    }
}
