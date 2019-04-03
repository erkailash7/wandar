package com.wander.wander.project.exception;

public class WanderException extends RuntimeException{

	public WanderException() {
		super();
	}

	public WanderException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public WanderException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public WanderException(String arg0) {
		super(arg0);
	}

	public WanderException(Throwable arg0) {
		super(arg0);
	}

	
}
