package com.terapico.uccaf.explorer;

import com.terapico.uccaf.BaseUserContext;

public abstract class TodoTask {

	public abstract String getName();
	public abstract Object getTargetObject();
	public abstract void execute(BaseUserContext ctx);
}
