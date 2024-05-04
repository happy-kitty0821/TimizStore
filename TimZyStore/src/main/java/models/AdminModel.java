package models;

import java.io.File;

import javax.servlet.http.Part;

import utils.StringUtils;

public class AdminModel {
	private String  user_name;
	private String password;
	private String full_name;
	private String email;
	private String account_category;
	private String phone_number;
	private String profile_picture_image;
	
	private String getProfilePicName(Part part) {
		String imagePath = StringUtils.PROFILE_PIC_SAVE_DIR;
		File imageSaveDir = new File(imagePath);
		String profilePicUrlFromPath = null;
		if(!imageSaveDir.exists()) {
			imageSaveDir.mkdir();
		}
		String contentDisp = part.getHeader("content-disposition");
		String []items = contentDisp.split(";");
		for(String s : items) {
			if(s.trim().startsWith("filename")) {
				profilePicUrlFromPath = s.substring(s.indexOf("=") + 2, s.length() -1);
			}
		}
		if(profilePicUrlFromPath == null || profilePicUrlFromPath.isEmpty()) {
			profilePicUrlFromPath = "defaultpp.png";
		}
		return profilePicUrlFromPath;
	}

	public AdminModel(String user_name, String password, String full_name, String email, String account_category,
			String phone_number, Part profile_pic) {
		this.user_name = user_name;
		this.password = password;
		this.full_name = full_name;
		this.email = email;
		this.account_category = account_category;
		this.phone_number = phone_number;
		this.profile_picture_image = getProfilePicName(profile_pic);
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccount_category() {
		return account_category;
	}

	public void setAccount_category(String account_category) {
		this.account_category = account_category;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getProfile_picture_image() {
		return profile_picture_image;
	}

	public void setProfile_picture_image(Part part) {
		this.profile_picture_image = getProfilePicName(part);
	}
}
