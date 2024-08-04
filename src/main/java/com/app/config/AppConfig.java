package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.app.Address;
import com.app.Order;
import com.app.Product;

@Configuration
@ComponentScan(basePackages = {"com.app"})
public class AppConfig {
	@Bean
	public Product iphone() {
		Product product = new Product();
		product.setProductName("Iphone-15Pro");
		product.setQuantity(12);
		product.setPrice(75000.00);
		product.setVendor("Apple");
		
		return product;
	}
	
	@Bean(name = {"SAMSUNG", "sAMSUNg"})
	public Product samsung() {
		Product product = new Product();
		product.setProductName("Samsung-Galaxy");
		product.setQuantity(6);
		product.setPrice(55000.00);
		product.setVendor("Samsung");
		
		return product;
	}
	
	@Bean(initMethod = "orderCreated", destroyMethod = "orderDelivered")
	public Order order() {
		Order order = new Order();
		order.setProduct(iphone());
		order.setOrderQuantity(2);
		order.setTotalAmount(order.getOrderQuantity()*order.getProduct().getPrice());
		order.setShipTo(office());
		
		return order;
	}
	
	@Bean(autowireCandidate = false)
	public Address office() {
		Address address = new Address();
		address.setHouseNo("2026-11");
		address.setArea("Hi-tech city");
		address.setCity("Hyderabad");
		address.setCountry("India");
		address.setZipcode("506122");
		address.setPhoneNo("9999900000");
		
		return address;
	}
}
