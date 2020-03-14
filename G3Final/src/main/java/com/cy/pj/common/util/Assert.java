package com.cy.pj.common.util;

import com.cy.pj.common.exception.ServiceException;

public class Assert {

	public static void isArgumentAvailable(boolean statement, String message) {
		if(statement)
			throw new IllegalArgumentException(message);
	}
	
	public static void isServiceVerified(boolean statement, String message) {
		if(statement)
			throw new ServiceException(message);
	}
}
