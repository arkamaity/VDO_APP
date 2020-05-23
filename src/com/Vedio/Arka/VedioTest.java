package com.Vedio.Arka;

import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.JFrame;

import com.maity.datamodel.UserDetails;

public class VedioTest  {

	private Properties languageProperties = null;
	
	VedioTest(String language) throws IOException{
		InputStream lFile = new FileInputStream("I18N_DETAILS_en.PROPERTISE");
		System.out.println("point1");
		languageProperties.load(lFile);System.out.println("point2");
		System.out.println(languageProperties.getProperty("label.Sign_in.title"));
		
	}
	 public static void main(String args[]) throws IOException {
		 VedioTest v = new VedioTest("j");
		 
		   /* try {
		        File myObj = new File("filename.txt");
		        if (myObj.createNewFile()) {
		          System.out.println("File created: " + myObj.getName());
		        } else {
		          System.out.println("File already exists.");
		        }
		        if (myObj.exists()) {
		            System.out.println("File name: " + myObj.getName());
		            System.out.println("Absolute path: " + myObj.getAbsolutePath());
		            System.out.println("Writeable: " + myObj.canWrite());
		            System.out.println("Readable " + myObj.canRead());
		            System.out.println("File size in bytes " + myObj.length());
		          } else {
		            System.out.println("The file does not exist.");
		          }
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }*/
	 }
}
