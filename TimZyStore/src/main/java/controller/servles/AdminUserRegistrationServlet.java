package controller.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.DatabaseController;
import models.AdminModel;
import models.UserModel;
import utils.StringUtils;

/**
 * Servlet implementation class AdminUserRegistrationServlet
 */

@WebServlet("/AdminUserRegistrationServlet")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 5,
maxFileSize = 1024*1024*10,
maxRequestSize = 1024*1024*50
)
public class AdminUserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(StringUtils.user_name);
		String fullName = request.getParameter(StringUtils.full_name);
		String email = request.getParameter(StringUtils.email);
		String accountCategory = request.getParameter(StringUtils.account_category);
		String password = request.getParameter(StringUtils.password);
		String phoneNumber = request.getParameter(StringUtils.phone_number);
		Part profilePicture = request.getPart("profilepic");
		AdminModel adminModel = new AdminModel(userName, password, fullName, email, 
				accountCategory, phoneNumber, profilePicture);
		
		String savePath = StringUtils.PROFILE_PIC_SAVE_DIR;
		String fileName = adminModel.getProfile_picture_image();
		try {
		    if (fileName != null && !fileName.isEmpty()) {
		    	profilePicture.write(savePath + fileName);
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		    // Handle the exception appropriately (e.g., log it, return an error message, etc.)
		}
		int result = dbController.addAdminUser(adminModel);
		
		System.out.println("result is: "+result);
		
		if (result == 1) {
		    request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESSFULLY_REGISTERED_ADMIN_MESSAGE);
		    response.sendRedirect(request.getContextPath() + StringUtils.LOGIN_PAGE);
		} 
		else if (result == 0) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.INCORRECT_FORM_DATA_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		} 
		else {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.REGISTER_PAGE).forward(request, response);
		}
	}
}
