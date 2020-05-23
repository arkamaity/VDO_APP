package com.Vedio.Arka;
import java.lang.annotation.*;
import java.lang.reflect.Method;
public class AnnotationTest {

	public static void main(String[] args) {
		Class aClass = MyCustomAnnotationExample.class;
		Method[] methods = aClass.getDeclaredMethods();
		
		Annotation[] annotations = aClass.getAnnotations();

		for(Annotation annotation : annotations){
			System.out.println("name: " +annotation.annotationType());
		    /*if(annotation instanceof MYCustomMethodAnnotation){
		    	MYCustomMethodAnnotation myAnnotation = (MYCustomMethodAnnotation) annotation;
		        System.out.println("name: " + myAnnotation.elementName());
		        System.out.println("value: " + myAnnotation.type());
		    }*/
		}
		for(Method method :methods) {
			System.out.println("Method Name: " + method.getName());
			Annotation[] methodAnnotations = method.getDeclaredAnnotations();
			for(Annotation annotation : methodAnnotations){
				System.out.println("1: ");
				if(annotation instanceof MYCustomMethodAnnotation){
			    	MYCustomMethodAnnotation myAnnotation = (MYCustomMethodAnnotation) annotation;
			        System.out.println("name: " + myAnnotation.elementName());
			        System.out.println("value: " + myAnnotation.type());
			    }
				
			}
		}

	}

}
