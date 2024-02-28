

package com.rt.pot.sandeep.response;

public class Response {
	private String message;
	private int statusCode;
	private Object responsePayload;

	public Response(int statusCode, String message, Object responsePayload) {
		this.message = message;
		this.statusCode =statusCode;
		this.responsePayload = responsePayload;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public Object getResponsePayload() {
		return responsePayload;
	}
	public void setResponsePayload(Object responsePayload) {
		this.responsePayload = responsePayload;
	}
}
