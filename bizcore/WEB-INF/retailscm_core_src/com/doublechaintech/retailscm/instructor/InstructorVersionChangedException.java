
package com.doublechaintech.retailscm.instructor;
import com.doublechaintech.retailscm.EntityNotFoundException;

public class InstructorVersionChangedException extends InstructorManagerException {
	private static final long serialVersionUID = 1L;
	public InstructorVersionChangedException(String string) {
		super(string);
	}


}


