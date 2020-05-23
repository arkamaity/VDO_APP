package com.maity.datamodel;

public class KeyValuePair {
	private String property;
	private boolean isMultilangSupported;
	private String value;
	
	public KeyValuePair(String property, boolean isMultilangSupported,String value) {
		this.property = property;
		this.isMultilangSupported = isMultilangSupported;
		this.value = value;
	}

	public String getProperty() {
		return property;
	}

	public boolean isMultilangSupported() {
		return isMultilangSupported;
	}

	public String getValue() {
		return value;
	}
}
