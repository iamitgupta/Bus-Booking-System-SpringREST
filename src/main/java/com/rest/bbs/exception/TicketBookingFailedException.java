package com.rest.bbs.exception;

public class TicketBookingFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public TicketBookingFailedException(String excep) {
		super(excep);
	}

}
