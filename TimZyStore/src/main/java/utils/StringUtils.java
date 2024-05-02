package utils;

import java.io.File;

public class StringUtils {
	//login query
	public static final String LOGIN_QUERY = "select * from User where user_name = ?;";
	//user registration query
	public static final String USER_REGISTRATION_QUERY = "insert into User (user_name, password, full_name, email, phone_number, profile_picture_image)"
			+ "values(?,?,?,?,?,?)";
	//query to add products
	public static final String PRODUCT_ADD_QUERY = "";
	//query to get the product count
	public static final String GET_PRODUCT_COUNT_QUERY = "SELECT COUNT(*) FROM product";
	
	
	//constants 
	public static final String user_name = "username";
	public static final String password = "password";
	public static final String full_name = "fullname";
	public static final String email = "email";
	public static final String phone_number = "phonenumber";

	//uploaded picture store dir
	public static final String PROFILE_PIC_DIR = "\\Users\\HeheHe\\eclipse-workspace\\TimZyStore\\src\\main\\webapp\\Uploads\\ProfilePictures\\";
	public static final String PROFILE_PIC_SAVE_DIR = "C:" + File.separator + PROFILE_PIC_DIR;
	public static final String PRODUCT_PIC_DIR = "Users\\HeheHe\\eclipse-workspace\\TimZyStore\\src\\main\\webapp\\Uploads\\ProductPictures\\";
	public static final String PRODUCT_PIC_SAVE_DIR = "C:" + File.separator + PROFILE_PIC_DIR;
	
	public static final String LOGIN_PAGE = "/pages/Login.jsp";
	public static final String REGISTER_PAGE = "/pages/SignUp.jsp";
	public static final String ADD_ADMIN_PAGE = "/pages/AdminRegistration.jsp";
	public static final String HOME_PAGE = "/pages/Index.jsp";
	public static final String ADMIN_PAGE = "/pages/Admin.jsp";
	public static final String CONTACT_US_PAGE = "/pages/Contact.jsp";
	public static final String ADD_BRAND = "/pages/AddBrand.jsp";
	public static final String ADD_PRODUCT_PAGE = "/pages/AddProducts.jsp";
	// End JSP Route
	
	// Start Servlet Route
	public static final String REGISTER_SERVLET = "/RegisterServlet";
	public static final String LOGIN_SERVLET = "/UserLogin";
	public static final String ADMIN_HOME_SERVLET = "/AdminHomeServlet";
	// End Servlet Route


	//Start of constant string messages
	public static final String SUCCESSFULLY_REGISTERED_MESSAGE = "The User Was Successfully Registered!";
	public static final String INCORRECT_FORM_DATA_MESSAGE = "Please Check and Enter The Correct Form Data.";
	public static final String SERVER_ERROR_MESSAGE = "An unexpected server error occurred.";
	public static final String SUCCESS_MESSAGE = "successMessage";
    public static final String ERROR_MESSAGE = "errorMessage";
    public static final String INCORRECT_LOGIN_CREDENTIAL_ERROR = "Username or Password Incorrect";
	public static final String Successfully_Stored_Message = "Dear user your message has been successfully stored, please wait for an response";
	public static final String SUCCESSFULLY_ADD_BRAND_MESSAGE = "Brand Added Successfully";
	public static final String PRODUCT_SUCCESSFULLU_ADD_MESSAGE = "The product was added successfully";
    public static final String PRODUCT_ALREADY_EXISTS_MESSAGE = "This product already exists";
    public static final String USERANME_ALREADY_EXISTS_MESSAGE = "The user already exists";
    // End string messages

}