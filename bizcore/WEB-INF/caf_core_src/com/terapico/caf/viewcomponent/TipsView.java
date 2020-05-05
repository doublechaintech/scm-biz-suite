package com.terapico.caf.viewcomponent;

public class TipsView extends BaseViewComponent{
    public String getTitle() {
        return String.valueOf(this.getContent());
    }
    
    public int duration = 3500;

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
    
    
}
