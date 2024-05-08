package utils;

import java.io.File;

public class StringUtils {
	//login query
	public static final String LOGIN_QUERY = "select * from User where user_name = ?;";
	//user registration query
	public static final String USER_REGISTRATION_QUERY = "insert into User (user_name, password, full_name, email, phone_number, profile_picture_image)"
			+ "values(?,?,?,?,?,?)";
	//query to add products
	public static final String PRODUCT_ADD_QUERY = "INSERT INTO Product " +
		    "(product_name, product_description, price, quantity, brand_id, product_image, screen_size, connectivity, os, features, watch_color) " +
		    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	public static final String GET_PRODUCT_COUNT_QUERY = "SELECT COUNT(*) FROM product";
	//query to get the customer count
	public static final String GET_CUSTOMER_COUNT_QUERY = "select count(*) from user where account_category = 'User'";
	//query to add brand
	public static final String ADD_BRAND_QUERY = "insert into brand (brand_name, country_of_origin, website)"
			+ "values(?,?,?)";
	//query to get the brand info from the brand table
	public static final String GET_BRAND_INFO_QUERY = "select * from brand";
	//query to add admin user
	public static final String ADD_ADMIN_USER_QUERY = "insert into User (user_name, password, full_name, email, account_category, phone_number, profile_picture_image)"
			+ "values(?,?,?,?,?,?,?)";
	//query to get all the rows from brand taable
	public static final String GET_ALL_BRAND_DETAILS_QUERY = "SELECT * FROM Brand";
	//query to get the all products
	public static final String GET_ALL_PRODUCTS = "select * from Product";
	//delete product query
	public static final String DELETE_PRODUCT_QUERY = "DELETE FROM product WHERE product_id = ?";
	//delete brand query
	public static final String DELETE_BRAND_QUERY = "delete from Brand where brand_id = ?";
	//store about us message 
	public static final String ADD_ABOUT_US_MESSAGE = "insert into contact_us_messages (sender_name,sender_email,subject,message)"
			+ "values(?,?,?,?)";
	//get all message query
	public static final String GET_ALL_MESSAGES_QUERY = "SELECT * FROM contact_us_messages";
	//get logged in user details
	public static final String GET_LOGGEDIN_USER_DETAILS = "SELECT * FROM user where user_name = ?";
	//see order history
	public static final String GET_ORDER_HISTORY_QUERY = "SELECT o.order_id, o.total_amount, o.order_date, p.product_name, p.product_image, o.quantity, o.price"
			+"FROM orders o"
			+"JOIN products p ON o.product_id = p.product_id"
			+"WHERE o.user_id = ?";
	//query to get all orders
	public static final String GET_ALL_ORDERS_QUERU = "SELECT o.order_id, o.user_id, o.total_amount, o.order_date, od.product_id, p.product_name, od.quantity, od.price"
			+ "FROM orders o"
			+ "JOIN order_details od ON o.order_id = od.order_id"
			+ "JOIN product p ON od.product_id = p.product_id";
	//query to get user_id
	public static final String GET_USER_ID_QUERY = "select user_id from user WHERE user_name=?";
	//query to add product to cart
	public static final String ADD_TO_CART_QUERY = "INSERT INTO cart (user_id, product_id, quantity) "
	        + "VALUES (?, ?, ?) "
	        + "ON DUPLICATE KEY UPDATE quantity = quantity + VALUES(quantity)";
	//insert into orders table 
	public static final String INSERT_INTO_ORDERS = "INSERT INTO Orders (user_id, total_amount, product_id, quantity, price) "
			+ "VALUES (?, ?, ?, ?, ?)";
	//query to get user cart info
	public static final String GET_CART_HISTROY = "SELECT "
	        + "    c.cart_id, "
	        + "    c.user_id, "
	        + "    c.product_id, "
	        + "    c.quantity, "
	        + "    p.product_name, "
	        + "    p.price, "
	        + "    p.product_image "
	        + "FROM "
	        + "    cart c JOIN product p ON c.product_id = p.product_id "
	        + "WHERE "
	        + "    c.user_id = ?";
	
	//query to update the database after a purchase
	public static final String UPDATE_PRODUCT_QUANTITY_QUERY = "UPDATE products p"
			+ "JOIN orders o ON p.product_id = o.product_id"
			+ "SET p.quantity = p.quantity - o.quantity"	
			+ "WHERE o.order_id = ?";
	//search query
	public static final String SEARCH_QUERY = "SELECT * FROM product WHERE product_name LIKE ?";
	
	//constants 
	public static final String user_name = "username";
	public static final String password = "password";
	public static final String full_name = "fullname";
	public static final String email = "email";
	public static final String phone_number = "phonenumber";
	public static final String account_category = "account_category";

	//uploaded picture store dir
	//Users\\Asian\\
	public static final String PROFILE_PIC_DIR = "\\Users\\HeheHe\\eclipse-workspace\\TimZyStore\\src\\main\\webapp\\Uploads\\ProfilePictures\\";
	public static final String PROFILE_PIC_SAVE_DIR = "C:" + File.separator + PROFILE_PIC_DIR;
	public static final String PRODUCT_PIC_DIR = "Users\\HeheHe\\eclipse-workspace\\TimZyStore\\src\\main\\webapp\\Uploads\\ProductPictures\\";
	public static final String PRODUCT_PIC_SAVE_DIR = "C:" + File.separator + PRODUCT_PIC_DIR;
	
	public static final String LOGIN_PAGE = "/pages/Login.jsp";
	public static final String REGISTER_PAGE = "/pages/SignUp.jsp";
	public static final String ADD_ADMIN_PAGE = "/pages/AdminRegistration.jsp";
	public static final String HOME_PAGE = "/pages/Index.jsp";
	public static final String ADMIN_PAGE = "/pages/Admin.jsp";
	public static final String ABOUT_US_PAGE = "/pages/AboutUs.jsp";
	public static final String ADD_BRAND = "/pages/AddBrand.jsp";
	public static final String ADD_PRODUCT_PAGE = "/pages/AddProducts.jsp";
	// End JSP Route
	


	//Start of constant string messages
	public static final String SUCCESSFULLY_REGISTERED_ADMIN_MESSAGE = "The User Was Successfully Registered!";
	public static final String INCORRECT_FORM_DATA_MESSAGE = "Please Check and Enter The Correct Form Data.";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
	public static final String SUCCESS_MESSAGE = "successMessage";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String INCORRECT_LOGIN_CREDENTIAL_ERROR = "Your Username or Password is Incorrect";
	public static final String Successfully_Stored_Message = "Your message has been successfully stored!";
	public static final String SUCCESSFULLY_ADD_BRAND_MESSAGE = "Brand Added Successfully";
	public static final String PRODUCT_SUCCESSFULLY_ADD_MESSAGE = "The product was added successfully";
    public static final String PRODUCT_ALREADY_EXISTS_MESSAGE = "The product already exists";
    public static final String BRAND_DELETED_MESSAGE = "The requested brand was deleted sucessfully";
    public static final String PRODUCT_DELETED_MESSAGE = "The proudct was deletd";
    public static final String USERANME_ALREADY_EXISTS_MESSAGE = "The user already exists";
    // End string messages
	

}