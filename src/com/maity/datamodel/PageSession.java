package com.maity.datamodel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.maity.Utility.VedioUtils;

public class PageSession {
	
	private UserDetails loggedInUser;
	private List<ErrorInfo> pageError;
	private Properties bundle;
	private String configFile;
	private String fileName;
	
	
	public PageSession(UserDetails user) {
		this.loggedInUser = user;
		this.configFile = "I18N_DETAILS";
		this.fileName = VedioUtils.getBundleFileName(this.configFile, user.getLocale());
		
	}
	public PageSession(String language) {
		this.configFile = "I18N_DETAILS";
		this.fileName = VedioUtils.getBundleFileName(this.configFile, language);
	}
	
	
	public Properties getBundle() throws FileNotFoundException, IOException {
		this.bundle = VedioUtils.getPropertiseFromFile(this.fileName);
		return this.bundle;	
	}
	/*public void setBundle(Properties p) {
		this.bundle = p;
	}*/
	public UserDetails getLoggedInUser() {
		return this.loggedInUser;
	}
}
