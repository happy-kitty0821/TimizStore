package models;

import java.sql.Date;

public class OrderModel {
	private int order_id;
	private int user_id;
	private double total_amount;
	private Date order_date;
	private int product_id;
	private int quantity;
	private double price;
	public OrderModel(int order_id, int user_id, double total_amount, Date order_date, int product_id, int quantity,
			double price) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.order_date = order_date;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public double getTotal_amount() {
		return total_amount;
	}
	public void setTotal_amount(double total_amount) {
		this.total_amount = total_amount;
	}
	public Date getOrder_date() {
		return order_date;
	}
	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderModel(int user_id, double total_amount, int product_id, int quantity, double price) {
		super();
		this.user_id = user_id;
		this.total_amount = total_amount;
		this.product_id = product_id;
		this.quantity = quantity;
		this.price = price;
	}
	
}
