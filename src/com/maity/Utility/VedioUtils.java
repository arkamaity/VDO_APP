package com.maity.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.Locale;
import java.util.Properties;

public class VedioUtils {

	/*private static final Exception KeyNotFoundException = null;*/


	public static String languageFilePath = "label.Sign_in.title";
	
	
	public static String PROP_LABLE_NAME_TITLE = "label.Sign_in.title";
	public static String PROP_LABLE_NAME_UNAME = "label.Sign_in.userName";
	public static String PROP_LABLE_NAME_PASSWORD = "label.Sign_in.password";
	public static String PROP_LABLE_NAME_OTP = "label.Sign_in.OTP";
	public static String PROP_LABLE_NAME_ERROR_MSG_OTP = "label.Sign_in.ErrorMessage.InvalidOTP";
	public static String PROP_LABLE_NAME_ERROR_MSG_UNME_PSCD = "label.Sign_in.ErrorMessage.invalidLogin";
	
	public static Properties getPropertiseFromFile(String filePath) throws FileNotFoundException, IOException {
		Properties properties = null;
		InputStream lFile = new FileInputStream(filePath);
		InputStreamReader isr = new InputStreamReader(lFile, "utf-8");
		properties = new Properties();
		properties.load(isr); 
		lFile.close();
		return properties;
	}
	public static String getPropertyValue(Properties p ,String label)  {
		if(p.containsKey(label)) {
			return p.getProperty(label);
		}else {
			return null; /* Need to throw KeyNotFoundException;*/
		}
	}
	public static String getBundleFileName(String fileName,String locale) {
		String fullFileName ;
		switch(locale) {
		case "BNG" : 
			fullFileName = fileName + "_bn.properties";
			break;
		case "HND" :
			fullFileName = fileName + "_hn.properties";
			break;
		case "EN" :
			fullFileName = fileName + "_en.properties";
			break;
		default :
			fullFileName = fileName + "_en.properties";
			break;
		}
		return fullFileName;
	}
	///public static void main(String args[]) {
		/*try {
			Properties p = VedioUtils.getPropertiseFromFile("I18N_DETAILS_en.PROPERTIES");
			System.out.println("data1 : " + p.toString());
			System.out.println("data2 : " + VedioUtils.getPropertyValue(p, "label.Sign_in.title"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//Locale aLocale = new Locale.Builder().setLanguage("bn").setRegion("IND").build();
		/*Locale localeArray[] =Locale.getAvailableLocales();
		for(int i = 0; i< localeArray.length;i++) {
			System.out.println(i + ". Locale : " + localeArray[i].getDisplayLanguage() +
					", Code : " + localeArray[i].getLanguage() + 
					", " + localeArray[i].toString()
					);
			
		}*/
	////}
}
