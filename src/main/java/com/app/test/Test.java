package com.app.test;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.app.Order;
import com.app.Product;
import com.app.config.AppConfig;

public class Test {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) applicationContext.getAutowireCapableBeanFactory();
		
		String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		System.out.println("--------- Beans Names ----------");
		for (String string : beanDefinitionNames) {
			System.out.println(string);
		}
		
		Order order = applicationContext.getBean(Order.class);
		System.out.println("---------- Order ----------");
		System.out.println(order);
		System.out.println("-------- Product ----------");
		System.out.println(order.getProduct());
		System.out.println("----------- Address ---------");
		System.out.println(order.getShipTo());
		
		beanDefinitionRegistry.removeBeanDefinition("order");
		
		System.out.println("---- Accessing Samsung Product with 'SAMSUNG' Bean Name ----");
		Product SAMSUNG = (Product) applicationContext.getBean("SAMSUNG");
		System.out.println(SAMSUNG);
		
		System.out.println("---- Accessing Samsung Product with 'sAMSUNg' Bean Name ----");
		Product sAMSUNg = (Product) applicationContext.getBean("sAMSUNg");
		System.out.println(sAMSUNg);
	}
}
