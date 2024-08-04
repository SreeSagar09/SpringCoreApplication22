package com.app;

public class Order {
	private Product product;
	private Integer orderQuantity;
	private Double totalAmount;
	private Address shipTo;
	
	public Product getProduct() {
		return product;
	}
	
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public Integer getOrderQuantity() {
		return orderQuantity;
	}
	
	public void setOrderQuantity(Integer orderQuantity) {
		this.orderQuantity = orderQuantity;
	}
	
	public Double getTotalAmount() {
		return totalAmount;
	}
	
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	public Address getShipTo() {
		return shipTo;
	}
	
	public void setShipTo(Address shipTo) {
		this.shipTo = shipTo;
	}
	
	@Override
	public String toString() {
		return "Order [product=" + product + ", orderQuantity=" + orderQuantity + ", totalAmount=" + totalAmount
				+ ", shipTo=" + shipTo + "]";
	}
	
	public void orderCreated() {
		System.out.println("Order created with the item: "+product.getProductName());
	}
	
	public void orderDelivered() {
		System.out.println("Order delivered to: "+shipTo.getHouseNo()+", "+shipTo.getArea()+", "+shipTo.getCity());
	}
	
}
