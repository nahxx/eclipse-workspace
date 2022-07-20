package com.varxyz.jv251.exception;

@SuppressWarnings("serial")
public class DuplicateEntityException extends RuntimeException {
	public DuplicateEntityException(String msg) {
		super(msg);
	}
}
