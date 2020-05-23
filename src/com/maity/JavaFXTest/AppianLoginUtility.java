package com.maity.JavaFXTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import com.maity.datamodel.AppianIntegration;
import com.maity.datamodel.ErrorInfo;
import com.maity.datamodel.UserDetails;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

public class AppianLoginUtility {
	private AppianIntegration apnResponse;
	private UserDetails usr;
	

	
	/*Integration Parameter need from XML File*/
	private static String endPoint = "https://techmahindradev.appiancloud.com/suite/webapi/GetUserDetails";
	private static String method = "POST";
	private static String userName = "Arka.Maity";
	private static String password = "BOURN1987";
	/*Integration Parameter need from XML File*/
	
	public AppianIntegration getAppianLogin(String uName,String uPasscode) {
		ErrorInfo errorInfo = new ErrorInfo();
		Base64.Encoder encoder = Base64.getUrlEncoder();
		String authStringEnc = encoder.encodeToString(new String(AppianLoginUtility.userName + ":" + AppianLoginUtility.password).getBytes());
		String responseInfo = new String();
        HttpURLConnection urlConn = null;
        BufferedReader reader = null;
        try {
        	URL urlObj = new URL(endPoint);
            urlConn = (HttpURLConnection) urlObj.openConnection();
            urlConn.setDoOutput(true);
            urlConn.setRequestMethod(method);
            urlConn.setConnectTimeout(5000);
            urlConn.setReadTimeout(5000);
            urlConn.setRequestProperty("Accept", "application/json");
            urlConn.addRequestProperty("Authorization", "Basic " + authStringEnc);
            byte[] out = new String("{\"userName\": \"" + uName+ "\", \"password\": \""+uPasscode+"\"}").getBytes(StandardCharsets.UTF_8);
            int length = out.length;
            urlConn.setFixedLengthStreamingMode(length);
            urlConn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConn.connect();
            try(OutputStream os = urlConn.getOutputStream()) {
                os.write(out);
            }
            
            if (urlConn.getResponseCode() != HttpURLConnection.HTTP_OK) {
            	errorInfo.setErrorCode("-1");
            	errorInfo.setErrorMessage("Error Response Code : " + urlConn.getResponseCode() + " ");
            }
            else {
            	InputStream is = urlConn.getInputStream();
            	reader = new BufferedReader(new InputStreamReader((is)));
            	String tmpStr = null;
            	while((tmpStr = reader.readLine()) != null){
            		if(responseInfo != null) {
            			responseInfo = responseInfo + tmpStr;
            		}else {
            			responseInfo = tmpStr;
            		}
            		
                }
            }
        }catch (MalformedURLException e) {
        	errorInfo.setErrorCode("-1");
        	errorInfo.setErrorMessage("MalformedURLException");
        }catch (IOException e) {

        	errorInfo.setErrorCode("-1");
        	errorInfo.setErrorMessage("IOException");
        }finally {
            try {
                if(reader != null) reader.close();
                if(urlConn != null) urlConn.disconnect();
            } catch(Exception ex){
            	errorInfo.setErrorCode("-1");
            	errorInfo.setErrorMessage("Exception");
            }
        }
        apnResponse = new AppianIntegration(errorInfo, responseInfo);
		return apnResponse;
		
	}
	
	public UserDetails parseUserDetails(String response) {
		ErrorInfo errorInfo = new ErrorInfo();
		JSONParser parser = new JSONParser();
		try {
			JSONObject obj = (JSONObject) parser.parse(response);
			boolean flag = (boolean) obj.get("success");
			usr = new UserDetails();
			if(flag) {
				JSONArray  userArray = (JSONArray) obj.get("userData");
				JSONObject userJSON = (JSONObject) userArray.get(0);
				
				usr = new UserDetails();
				usr.setUserLastName((String)userJSON.get("lastName"));
				usr.setUserId(( long)userJSON.get("id"));
				usr.setUserFirstName((String)userJSON.get("firstName"));
				usr.setPhoneNumber((String)userJSON.get("phoneNumber1"));
				usr.setLocale((String)userJSON.get("language"));
				usr.setUserMiddleName((String)userJSON.get("middleName"));
				usr.setPhoneNumber((String)userJSON.get("activeStatusCode"));
				usr.setActive(true);
				usr.setAddress1(null);
				//System.out.println(userJSON);
			}else {
				
			}
			System.out.println(usr.getUserId());
			System.out.println(flag);
		} catch (ParseException e) {
			errorInfo.setErrorCode("-2");
        	errorInfo.setErrorMessage("Unable to parse");
        	usr = null;
		}
		
		return usr;
	}
	
	public static void main(String args[]) {
		String user = "{\"success\":true,\"errorMessage\":[],\"userData\":[{\"activeStatusCode\":\"Y\",\"language\":\"EN\",\"phoneNumber1\":\"81162909100\",\"email\":\"mike.smith@techmahin\",\"lastName\":\"Smith\",\"middleName\":null,\"firstName\":\"Mike\",\"token\":\"Appian@123\",\"id\":1000}]}";
		AppianLoginUtility aa = new AppianLoginUtility();
		aa.parseUserDetails(user);
	}

}
