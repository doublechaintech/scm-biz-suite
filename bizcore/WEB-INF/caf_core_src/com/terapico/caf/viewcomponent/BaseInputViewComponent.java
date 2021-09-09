package com.terapico.caf.viewcomponent;

/**
 * 基础的输入类组件。 不会真正的传递到前台。
 * @author clariones
 *
 */
public abstract class BaseInputViewComponent  extends BaseViewComponent{
    protected String placeHolder;
    
    
    public String getPlaceHolder() {
        return placeHolder;
    }


    public void setPlaceHolder(String placeHolder) {
        this.placeHolder = placeHolder;
    }


    public BaseInputViewComponent() {
	this.setInputable(true);
    }
}
