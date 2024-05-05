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
import models.UserModel;
import utils.StringUtils;

/**
 * Servlet implementation class UserRegisterServlet
 */
@WebServlet("/UserRegisterServlet")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 5,
maxFileSize = 1024*1024*10,
maxRequestSize = 1024*1024*50
)
public class UserRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	controller.DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter(StringUtils.user_name);
		String fullName = request.getParameter(StringUtils.full_name);
		String email = request.getParameter(StringUtils.email);
		String password = request.getParameter(StringUtils.password);
		String phoneNumber = request.getParameter(StringUtils.phone_number);
		Part profilePicture = request.getPart("profilepic");
		UserModel userModel = new UserModel(userName,password,fullName, email,phoneNumber, profilePicture);
		
		String savePath = StringUtils.PROFILE_PIC_SAVE_DIR;
		String fileName = userModel.getProfile_picture_image();
		try {
		    if (fileName != null && !fileName.isEmpty()) {
		    	profilePicture.write(savePath + fileName);
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		    // Handle the exception appropriately (e.g., log it, return an error message, etc.)
		}
		int result = dbController.addNewUser(userModel);
		
		System.out.println("result is: "+result);
		
		if (result == 1) {
		    request.setAttribute(StringUtils.SUCCESS_MESSAGE, "User registration success");
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
