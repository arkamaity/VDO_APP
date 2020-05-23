package com.Vedio.Arka;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)

public @interface MyCustomAnnotation {
	String type() default "STRING";
	String elementName();
	String isClass() default "FALSE";
}
