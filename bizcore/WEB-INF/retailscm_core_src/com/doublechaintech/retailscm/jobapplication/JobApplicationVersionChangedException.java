
package com.doublechaintech.retailscm.jobapplication;
import com.doublechaintech.retailscm.EntityNotFoundException;

public class JobApplicationVersionChangedException extends JobApplicationManagerException {
	private static final long serialVersionUID = 1L;
	public JobApplicationVersionChangedException(String string) {
		super(string);
	}


}


