package com.terapico.caf.viewcomponent;

import com.terapico.caf.appview.CRAction;
import com.terapico.caf.appview.ChangeRequestData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenericFormPage extends ChangeRequestData implements VPage {
  private String randomId;
  private Map<String,Object> extraInfo;

  @Override
  public String getPageTitle() {
    return getTitle();
  }

  public String getRandomId() {
    return randomId;
  }

  public void setRandomId(String randomId) {
    this.randomId = randomId;
  }


  protected Map<String,Object> ensureExtraInfo() {
    if (extraInfo == null) {
      extraInfo = new HashMap<>();
    }
    return extraInfo;
  }

  public Map<String, Object> getExtraInfo() {
    return ensureExtraInfo();
  }

  public void setExtraInfo(Map<String, Object> pExtraInfo) {
    extraInfo = pExtraInfo;
  }
}
