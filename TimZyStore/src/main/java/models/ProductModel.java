package models;

import java.io.File;

import javax.servlet.http.Part;

import utils.StringUtils;

public class ProductModel {
	private int product_id;
	private String product_name;
	private String product_description;
	private double price;
	private int quantity;
	private int brand_id;
	private String product_image;
	private double screen_size;
	private String connectivity;
	private String os;
	private String features;
	
	
	private String getProductPicName(Part part) {
		String imagePath = StringUtils.PRODUCT_PIC_SAVE_DIR;
		File imageSaveDir = new File(imagePath);
		String productPicUrlFromPath = null;
		if(!imageSaveDir.exists()) {
			imageSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String []items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				productPicUrlFromPath = s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		if(productPicUrlFromPath  == null || productPicUrlFromPath .isEmpty()) {
			productPicUrlFromPath = "defaultpp.png";
		}
		return productPicUrlFromPath;	
}

	//primary constructor used for saving the product
	public ProductModel(String product_name, String product_description, double price, int quantity, int brand_id,
			Part product_pic, double screen_size, String connectivity, String os, String features) {
		super();
		this.product_name = product_name;
		this.product_description = product_description;
		this.price = price;
		this.quantity = quantity;
		this.brand_id = brand_id;
		this.product_image = getProductPicName(product_pic);
		this.screen_size = screen_size;
		this.connectivity = connectivity;
		this.os = os;
		this.features = features;
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

	public String getProduct_description() {
		return product_description;
	}

	public void setProduct_description(String product_description) {
		this.product_description = product_description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}

	public String getProduct_image() {
		return product_image;
	}

	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}

	public double getScreen_size() {
		return screen_size;
	}

	public void setScreen_size(double screen_size) {
		this.screen_size = screen_size;
	}

	public String getConnectivity() {
		return connectivity;
	}

	public void setConnectivity(String connectivity) {
		this.connectivity = connectivity;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}
	
}