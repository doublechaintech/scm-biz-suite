package com.doublechaintech.retailscm;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateKey extends BaseEntity {
	
	
	private static final long serialVersionUID = 1L;

	public Date getDateValue() {
		return dateValue;
	}

	public void setDateValue(Date dateValue) {
		this.dateValue = dateValue;
	}
	private Date dateValue;
	public String getDisplayName() {
		if(getDateValue()==null) {
			return "Empty Value";
		}
		SimpleDateFormat format = new SimpleDateFormat("YYYY/MM/dd");
		return format.format(getDateValue());

	}
	
	
}

