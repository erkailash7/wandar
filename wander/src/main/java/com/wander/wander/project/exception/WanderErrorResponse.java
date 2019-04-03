package com.wander.wander.project.exception;

public class WanderErrorResponse {

	private int status;
	private String message;
	private long timeStump;
	
	WanderErrorResponse(){
		
	}

	public WanderErrorResponse(int status, String message, long timeStump) {
		this.status = status;
		this.message = message;
		this.timeStump = timeStump;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStump() {
		return timeStump;
	}

	public void setTimeStump(long timeStump) {
		this.timeStump = timeStump;
	}

}
