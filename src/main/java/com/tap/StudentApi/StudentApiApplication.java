package com.tap.StudentApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StudentApiApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentApiApplication.class, args);
		int beancount = context.getBeanDefinitionCount();
		System.out.println(beancount + " Number of Beans");
		String[] beanname = context.getBeanDefinitionNames();
		System.out.println(beanname.length);
		for(   String a:beanname)
		{
			if(a.contains("student"))
			{
				System.out.println(a);
			}
			//System.out.println(a);
		}

		//System.out.println("HelloWorld");
	}

}
