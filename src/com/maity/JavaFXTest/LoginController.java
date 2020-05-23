package com.maity.JavaFXTest;



import com.maity.datamodel.AppianIntegration;
import com.maity.datamodel.PageSession;



public class LoginController {
	
	
	private PageSession ps;
	
	public void getUserDetails (String uName, String uPasscode) {
		AppianLoginUtility loginUtility = new AppianLoginUtility();
		AppianIntegration appInt = loginUtility.getAppianLogin(uName, uPasscode);
		if(appInt.getErrorInfo() == null && appInt.getResponseInfo() != null) {
			ps = new PageSession(loginUtility.parseUserDetails(appInt.getResponseInfo()));
			if(ps.getLoggedInUser() != null && ps.getLoggedInUser().getUserId() > 0) {
				//There is a user
			}else {
				//There is no user
			}
		}else if(appInt.getErrorInfo()!= null) {
			//There is error 
		}else if(appInt.getErrorInfo() == null && appInt.getResponseInfo() == null) {
			//There is error from Appian Side
		}
	}
}
