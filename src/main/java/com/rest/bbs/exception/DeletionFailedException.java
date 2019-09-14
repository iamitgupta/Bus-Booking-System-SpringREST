package com.rest.bbs.exception;

public class DeletionFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public DeletionFailedException(String excep) {
		super(excep);
	}

}
