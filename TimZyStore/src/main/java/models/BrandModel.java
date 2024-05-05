package models;

public class BrandModel {
	private int brand_id;
	private String brand_name;
	private String country_of_origin;
	private String website;
	//primary constructor used for adding brands
	public BrandModel(String brand_name, String country_of_origin, String website) {
		super();
		this.brand_name = brand_name;
		this.country_of_origin = country_of_origin;
		this.website = website;
	}
	public int getBrand_id() {
		return brand_id;
	}
	public void setBrand_id(int brand_id) {
		this.brand_id = brand_id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getCountry_of_origin() {
		return country_of_origin;
	}
	public void setCountry_of_origin(String country_of_origin) {
		this.country_of_origin = country_of_origin;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public BrandModel(int brand_id, String brand_name, String country_of_origin, String website) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.country_of_origin = country_of_origin;
		this.website = website;
	}
	
}
