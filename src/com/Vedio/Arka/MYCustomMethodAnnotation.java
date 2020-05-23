package com.Vedio.Arka;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})

public @interface MYCustomMethodAnnotation {
	String type() default "STRING";
	String elementName();
}
