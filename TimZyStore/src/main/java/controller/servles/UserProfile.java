package controller.servles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.UserModel;

/**
 * Servlet implementation class UserProfile
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
            System.out.println("User Profile Servlet");
            System.out.println("username is "+ username);
            // Call the method to get user details based on the username
            List<UserModel> userDetails = dbController.getLoggedinUserDetails(username);

            for (UserModel user : userDetails) {
                int userId = user.getUser_id();
                String userName = user.getUser_name();
                String password = user.getPassword();
                String fullName = user.getFull_name();
                String email = user.getEmail();
                String accountCategory = user.getAccount_category();
                String phoneNumber = user.getPhone_number();
                String profilePictureImage = user.getProfile_picture_image();

                // Now you can use these individual values as needed
                System.out.println("User ID: " + userId);
                System.out.println("User Name: " + userName);
                System.out.println("Password: " + password);
                System.out.println("Full Name: " + fullName);
                System.out.println("Email: " + email);
                System.out.println("Account Category: " + accountCategory);
                System.out.println("Phone Number: " + phoneNumber);
                System.out.println("Profile Picture Image: " + profilePictureImage);
                
                // Set user details as attributes in the request
                request.setAttribute("user_id", userId);
                request.setAttribute("user_name", userName);
                request.setAttribute("full_name", fullName);
                request.setAttribute("email", email);
                request.setAttribute("phone_number", phoneNumber );
                request.setAttribute("profilePictureImage", profilePictureImage);
                
                // Forward the request to UserProfile.jsp
                request.getRequestDispatcher("/pages/UserProfile.jsp").forward(request, response);
            }
        } else {
        	System.out.println("user is not logged in");
            // Redirect to the login page
            response.sendRedirect(request.getContextPath() + "/pages/Login.jsp");
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
