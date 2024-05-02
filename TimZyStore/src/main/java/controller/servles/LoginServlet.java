package controller.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import utils.StringUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	controller.DatabaseController dbController = new DatabaseController();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter(StringUtils.user_name);
        String password = request.getParameter(StringUtils.password);
        System.out.println(username);
        System.out.println(password);
        int login_result = dbController.getUserLogin(username, password);
        System.out.println("login result is :" + login_result);
        

        if (login_result == 1) {
            request.getSession().setAttribute("username", username);
            request.getSession().setMaxInactiveInterval(30 * 60); //setting the maximum session timeout to 30 minutes
            response.sendRedirect(request.getContextPath() + StringUtils.HOME_PAGE);
        } 
        else if (login_result == 2) {
            request.getSession().setAttribute("username", username);
            response.sendRedirect(request.getContextPath() + StringUtils.HOME_ADMIN_SERVLET);
        } 
        else if (login_result == 0) {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.INCORRECT_LOGIN_CREDENTIAL_ERROR);
            System.out.println("Username or Password Incorrect");
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        } 
        else {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
        
        
	}

}
