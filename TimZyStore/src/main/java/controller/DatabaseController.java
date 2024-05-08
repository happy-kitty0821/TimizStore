package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.bcrypt.BCrypt;

import models.AboutUsModel;
import models.AdminModel;
import models.BrandModel;
import models.CartModel;
import models.DisplayCartModel;
import models.OrderModel;
import models.ProductModel;
import models.UserModel;
import utils.StringUtils;

public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/TimZyStore";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}

	public int getUserLogin(String username, String password) {
		try (Connection con = getConnection()) {
			PreparedStatement stmnt = con.prepareStatement(StringUtils.LOGIN_QUERY);
			stmnt.setString(1, username);
			ResultSet result = stmnt.executeQuery();

			if (result.next()) {
				String hashedPasswordFromDb = result.getString("password");
				if (BCrypt.checkpw(password, hashedPasswordFromDb)) {
					String accountCategory = result.getString("account_category");
					if ("User".equals(accountCategory)) {
						return 1;// indicates that the user is customer

					} else if ("Admin".equals(accountCategory)) {
						return 2; // indicates that the user type is admin
					}
				}
			}
			return 0; // Username or password is incorrect
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1; // Server error or exception
		}
	}

	public int addNewUser(UserModel userModel) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(StringUtils.USER_REGISTRATION_QUERY);
			String hashedPassword = BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt());
			statement.setString(1, userModel.getUser_name());
			statement.setString(2, hashedPassword);
			statement.setString(3, userModel.getFull_name());
			statement.setString(4, userModel.getEmail());
			statement.setString(5, userModel.getPhone_number());
			statement.setString(6, userModel.getProfile_picture_image());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}

	public int addProduct(ProductModel productModel) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(StringUtils.PRODUCT_ADD_QUERY);
			statement.setString(1, productModel.getProduct_name());
			statement.setString(2, productModel.getProduct_description());
			statement.setDouble(3, productModel.getPrice());
			statement.setInt(4, productModel.getQuantity());
			statement.setInt(5, productModel.getBrand_id());
			statement.setString(6, productModel.getProduct_image());
			statement.setDouble(7, productModel.getScreen_size());
			statement.setString(8, productModel.getConnectivity());
			statement.setString(9, productModel.getOs());
			statement.setString(10, productModel.getFeatures());
			statement.setString(11, productModel.getWatch_color());
            int result = statement.executeUpdate();
            System.out.print("product add :"+ result );
            return result > 0 ? 1 : 0;

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public int getProductCount() {
	    int count = 0;
	    try (Connection con = getConnection();
	         PreparedStatement statement = con.prepareStatement(StringUtils.GET_PRODUCT_COUNT_QUERY);
	         ResultSet result = statement.executeQuery()) {
	        if (result.next()) {
	            count = result.getInt(1);
	            System.out.println("product count = " + count);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}

	public int getCustomerCount() {
	    int count = 0;
	    try (Connection con = getConnection();
	         PreparedStatement statement = con.prepareStatement(StringUtils.GET_CUSTOMER_COUNT_QUERY);
	         ResultSet result = statement.executeQuery()) {
	        if (result.next()) {
	            count = result.getInt(1);
	            System.out.println("customer count = " + count);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	public int addAdminUser(AdminModel adminModel) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.ADD_ADMIN_USER_QUERY);
			String hashedPassword = BCrypt.hashpw(adminModel.getPassword(), BCrypt.gensalt());
			statement.setString(1, adminModel.getUser_name());
			statement.setString(2, hashedPassword);
			statement.setString(3, adminModel.getFull_name());
			statement.setString(4, adminModel.getEmail());
			statement.setString(5, adminModel.getAccount_category());
			statement.setString(6, adminModel.getPhone_number());
			statement.setString(7, adminModel.getProfile_picture_image());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public int addBrands(BrandModel brandModel) {
	    try (Connection con = getConnection()) {
	        PreparedStatement statement = con.prepareStatement(StringUtils.ADD_BRAND_QUERY);
	        statement.setString(1, brandModel.getBrand_name());
	        statement.setString(2, brandModel.getCountry_of_origin());
	        statement.setString(3, brandModel.getWebsite());
	        int result = statement.executeUpdate();
	        return result > 0 ? 1 : 0;
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	        return -1;
	    }
	}

	
	public List<BrandModel> getBrandDetails(){
		List<BrandModel> brandDetails = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.GET_ALL_BRAND_DETAILS_QUERY);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				int brand_id = resultSet.getInt("brand_id");
				String brand_name = resultSet.getString("brand_name");
				String country_of_origin = resultSet.getString("country_of_origin");
				String website = resultSet.getString("website");
				BrandModel brandModel = new BrandModel(brand_id,brand_name, country_of_origin, website);
				brandDetails.add(brandModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return brandDetails;	
	}
	
	public List<ProductModel> getProductsDetails(){
		List<ProductModel> productDetails = new ArrayList<>();
			try(Connection con = getConnection()){
		        PreparedStatement statement = con.prepareStatement(StringUtils.GET_ALL_PRODUCTS);
		        ResultSet resultSet = statement.executeQuery();
		        while (resultSet.next()) {
		        	int product_id = resultSet.getInt("product_id");
		            String product_name = resultSet.getString("product_name");
		            String product_description = resultSet.getString("product_description");
		            double price = resultSet.getDouble("price");
		            int quantity = resultSet.getInt("quantity");
		            int brand_id = resultSet.getInt("brand_id");
		            String product_image = resultSet.getString("product_image");
		            double screen_size = resultSet.getDouble("screen_size");
		            String connectivity = resultSet.getString("connectivity");
		            String os = resultSet.getString("os");
		            String features = resultSet.getString("features");
		            String watch_color = resultSet.getString("watch_color");
		            ProductModel productModel = new ProductModel(product_id, product_name,product_description, price,
		            quantity, brand_id, product_image, screen_size, connectivity, os, features, watch_color);
		            productDetails.add(productModel);
		        }
		        
		    } catch (ClassNotFoundException | SQLException e) {
		        e.printStackTrace();
		    }
		    return productDetails;
		}
		
	public int deleteBrand(int brand_id) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.DELETE_BRAND_QUERY);
			statement.setInt(1, brand_id);
			int result = statement.executeUpdate();
			return result;
		}catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	
	public int storeAbouUsMessage(AboutUsModel aboutUsModel) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.ADD_ABOUT_US_MESSAGE);
			statement.setString(1, aboutUsModel.getSender_name() );
			statement.setString(2, aboutUsModel.getSender_email());
			statement.setString(3, aboutUsModel.getSubject());
			statement.setString(4, aboutUsModel.getMessage());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		
	}
	
	public List<AboutUsModel> getAllMessages(){
		List<AboutUsModel> allMessages = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.GET_ALL_MESSAGES_QUERY);
			ResultSet resultSet = statement.executeQuery();
		        while (resultSet.next()) {
		        	String sender_name = resultSet.getString("sender_name");
		        	String sender_email = resultSet.getString("sender_email");
		        	String subject = resultSet.getString("subject");
		        	String message = resultSet.getString("message");
		        	Date timestamp = resultSet.getDate("timestamp");
		        	AboutUsModel aboutUsModel = new AboutUsModel(sender_name, sender_email, subject, message, timestamp);
		        	allMessages.add(aboutUsModel);
		        }
		        
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return allMessages;
	}
	
	public List <UserModel> getLoggedinUserDetails(String username){
		List<UserModel> userDetails = new ArrayList<>();
			try(Connection con = getConnection()){
				PreparedStatement statement = con.prepareStatement(StringUtils.GET_LOGGEDIN_USER_DETAILS);
				statement.setString(1, username);				
				ResultSet result = statement.executeQuery();
				while(result.next()) {
					int user_id_num = result.getInt("user_id");
					String user_name = result.getString("user_name");
					String password = result.getString("password");
					String full_name = result.getString("full_name");
					String email = result.getString("email");
					String account_catrgory = result.getString("account_category");
					String phone_number = result.getString("phone_number");
					String profile_picture_image = result.getString("profile_picture_image");
					UserModel userModel = new UserModel(user_id_num, user_name, password, full_name, email, account_catrgory, phone_number, profile_picture_image);
					userDetails.add(userModel);
				}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userDetails;
	}
	
	public List <OrderModel> getUsersOrderDetail(int user_id){
		List<OrderModel> userOrderDetails = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.GET_ORDER_HISTORY_QUERY);
			statement.setInt(1, user_id);
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				int order_id = resultSet.getInt("order_id");
	            int user_id_num = resultSet.getInt("user_id");
	            Double total_amount = resultSet.getDouble("total_amount");
	            LocalDateTime order_date = resultSet.getTimestamp("order_date").toLocalDateTime();
	            int product_id = resultSet.getInt("product_id");
	            String product_name = resultSet.getString("product_name");
	            int quantity = resultSet.getInt("quantity");
	            Double price = resultSet.getDouble("price");
//	            OrderModel orderDetails = new OrderModel();
	            
	            // Add the OrderDetailsModel object to the list
//	            userOrderDetails.add(orderDetails);
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userOrderDetails;
	}
	

	public int getUserId(String user_name) {
	    int user_id = -1; // Default value if no user is found
	    try (Connection con = getConnection()) {
	        PreparedStatement statement = con.prepareStatement(StringUtils.GET_USER_ID_QUERY);
	        statement.setString(1, user_name); // Set the user_name parameter
	        ResultSet resultSet = statement.executeQuery();
	        if (resultSet.next()) {
	            user_id = resultSet.getInt(1);
	            System.out.println("user_id = " + user_id);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return user_id;
	}

	public int addProductToCart(CartModel cartModel) {
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.ADD_TO_CART_QUERY);
			statement.setInt(1, cartModel.getUser_id());
			statement.setInt(2, cartModel.getProduct_id());
			statement.setInt(3, cartModel.getQuantity());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
	public int storePurchases(OrderModel orderModel) {
		try (Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.INSERT_INTO_ORDERS);
			statement.setInt(1, orderModel.getUser_id());
			statement.setDouble(2, orderModel.getTotal_amount());
			statement.setInt(3, orderModel.getProduct_id());
			statement.setInt(4, orderModel.getQuantity());
			statement.setDouble(5, orderModel.getPrice());  
			
			int result = statement.executeUpdate();
			return result  > 0 ? 1 : 0;
			} catch (SQLException | ClassNotFoundException e) {
			    e.printStackTrace();
			    return -1;
		}
	}
	
	public List<DisplayCartModel> getUsersCartDetails(int user_id) {
	    List<DisplayCartModel> cartDetails = new ArrayList<>();
	    try (Connection con = getConnection();
	         PreparedStatement statement = con.prepareStatement(StringUtils.GET_CART_HISTROY )) {
	        statement.setInt(1, user_id);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            while (resultSet.next()) {
	                int product_id = resultSet.getInt("product_id");
	                String product_name = resultSet.getString("product_name");
	                int quantity = resultSet.getInt("quantity");
	                double price = resultSet.getDouble("price");
	                double total_price = price * quantity;
	                String product_image = resultSet.getString("product_image");
	                DisplayCartModel displayCartModel = new DisplayCartModel(product_id, product_name, quantity, total_price, product_image);
	                cartDetails.add(displayCartModel);
	            }
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        // Consider logging the exception instead of printing stack trace
	        e.printStackTrace();
	    }
	    return cartDetails;
	}
	
	public List<ProductModel> getResultFromSearch(String keyword){
		List<ProductModel> result = new ArrayList<>();
		try(Connection con = getConnection()){
			PreparedStatement statement = con.prepareStatement(StringUtils.SEARCH_QUERY);
			statement.setString(1,"%"+ keyword+"%");
			ResultSet searchResult = statement.executeQuery();
			while(searchResult.next()){
				int product_id = searchResult.getInt("product_id");
                String product_name = searchResult.getString("product_name");
                String product_description = searchResult.getString("product_description");
                Double price = searchResult.getDouble("price");
                int quantity = searchResult.getInt("quantity");
                String product_image = searchResult.getString("product_image");
                ProductModel productModel = new ProductModel(product_id, product_name, product_description, price, quantity, product_image);
                result.add(productModel);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
