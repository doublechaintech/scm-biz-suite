package com.terapico.menu;

import com.terapico.uccaf.BaseUserContext;

public interface MenuLoader {
  Menu load(BaseUserContext ctx, String code);
}
