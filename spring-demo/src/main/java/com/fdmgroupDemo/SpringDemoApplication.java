package com.fdmgroupDemo;



import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) 
	{
		ApplicationContext context =SpringApplication.run(SpringDemoApplication.class, args);
		
		hellofromSpring objectOfHello = context.getBean(hellofromSpring.class);
		
		objectOfHello.sayHello();
		
		System.out.println(Arrays.toString(hellofromSpring.class.getMethods()));
		System.out.println(Arrays.toString(hellofromSpring.class.getDeclaredFields()));
	}

}
