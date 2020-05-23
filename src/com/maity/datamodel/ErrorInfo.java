package com.maity.datamodel;


import java.util.Set;

public class ErrorInfo {
	private String errorMessage;
	private String errorCode;
	private Set<KeyValuePair> property;
	
	public ErrorInfo() {}
	
	
		
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}



	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}



	public void setProperty(Set<KeyValuePair> property) {
		this.property = property;
	}



	public ErrorInfo(String errorCode,Set<KeyValuePair> property) {
		this.errorCode = errorCode;
		this.property = property;
		
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public Set<KeyValuePair> getProperty() {
		return property;
	}
}
