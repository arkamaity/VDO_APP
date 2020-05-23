package com.Vedio.Arka;

@MyCustomAnnotation(isClass="TRUE",elementName="CLASS")
public class MyCustomAnnotationExample {
	
	@MYCustomMethodAnnotation(elementName="DoIt")
	void doIt() {
		System.out.println("Inside Do It");
	}
	
	@MYCustomMethodAnnotation(elementName="NotDoIt")
	private void NotDoIt() {
		System.out.println("Inside NotDoIt");
	}
}
