package com.maity.UI;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.maity.Utility.VedioUtils;
import com.maity.datamodel.PageSession;

public class SignInJPanel extends JPanel implements UIObject {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String emailOrMobile,lEmailOrMobileTxt;
	private String password,lPasswordTxt;
	private String OTP,lOTPTxt;
	private String errorMessage;
	private PageSession pageSession;
	
	SignInJPanel(String language ){
		this.pageSession  = new PageSession(language);
		generateUI();
	}
	
	
	@Override
	public void generateUI() {

		try {
			lEmailOrMobileTxt = this.pageSession.getBundle().getProperty(VedioUtils.PROP_LABLE_NAME_UNAME);
			lPasswordTxt = this.pageSession.getBundle().getProperty(VedioUtils.PROP_LABLE_NAME_PASSWORD);

		} catch (FileNotFoundException e) {
			this.errorMessage = "File Not Found : ";
		} catch (IOException e) {
			this.errorMessage = "IOException : ";
		}
		if(this.errorMessage == null) {
			this.setBounds(40,80,200,200);
			
			JLabel lEmailOrMobile = new JLabel();
			lEmailOrMobile.setText(lEmailOrMobileTxt);
			lEmailOrMobile.setBounds(50,100,80,30);
			JTextField jEmailOrMobile = new JTextField(15);
			jEmailOrMobile.setBounds(50,100, 50,30);
			jEmailOrMobile.setText(emailOrMobile);
			JLabel lPassword = new JLabel();
			lPassword.setText(lPasswordTxt);
			lPassword.setBounds(100,100,80,30);
			this.add(lEmailOrMobile);
			this.add(lPassword);
			
		}else {
			this.setBounds(40,80,200,200);
			
			JLabel lError = new JLabel();
			lError.setText(this.errorMessage);
			lError.setBounds(50,100,80,30);
			this.add(lError);
		}
		
	}
	@Override
	public void updateLanguage(PageSession pageSession) {
		
	}
	@Override
	public void updateLanguage(String language) {
		this.pageSession  = new PageSession(language);
		
	}
	
	
	

}
