package com.maity.datamodel;

public class AppianIntegration {
	private ErrorInfo errorInfo;
	private String responseInfo;
	
	public AppianIntegration(ErrorInfo errorInfo,String responseInfo) {
		this.errorInfo = errorInfo;
		this.responseInfo = responseInfo;
	}

	public ErrorInfo getErrorInfo() {
		return errorInfo;
	}

	public String getResponseInfo() {
		return responseInfo;
	}
	
	
}
