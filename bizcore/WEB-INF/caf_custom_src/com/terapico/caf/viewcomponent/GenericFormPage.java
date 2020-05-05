package com.terapico.caf.viewcomponent;

import com.terapico.caf.appview.ChangeRequestData;

public class GenericFormPage extends ChangeRequestData implements VPage {

  @Override
  public String getPageTitle() {
    return getTitle();
  }
}
