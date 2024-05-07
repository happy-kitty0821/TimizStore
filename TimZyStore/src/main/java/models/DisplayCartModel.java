package models;

public class DisplayCartModel {
	private int product_id;
	private String product_name;
	private int quantity;
	private double price;
	private String product_image;
	
	public DisplayCartModel(int product_id, String product_name, int quantity, double price, String product_image) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.quantity = quantity;
		this.price = price;
		this.product_image = product_image;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
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
	public String getProduct_image() {
		return product_image;
	}
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
}
