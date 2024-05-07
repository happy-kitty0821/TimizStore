package models;

import java.sql.Date;

public class CartModel {
	private int cart_id;
	private int user_id;
	private int product_id;
	private int quantity;
	private Date timestamp;
	public CartModel(int user_id, int product_id, int quantity) {
		super();
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	//constructor to be used for displaying cart info to the user
	public CartModel(int cart_id, int user_id, int product_id, int quantity, Date timestamp) {
		super();
		this.cart_id = cart_id;
		this.user_id = user_id;
		this.product_id = product_id;
		this.quantity = quantity;
		this.timestamp = timestamp;
	}
	
}
