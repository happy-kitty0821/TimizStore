package controller.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        int login_result = dbController.getUserLogin(username, password);
        System.out.println("login result is :" + login_result);

        if (login_result == 1 || login_result == 2) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            int user_id = dbController.getUserId(username);
            session.setAttribute("user_id", user_id);
            session.setMaxInactiveInterval(30 * 60); // Setting the maximum session timeout to 30 minutes
            if (login_result == 1) {
                response.sendRedirect(request.getContextPath() + StringUtils.HOME_PAGE);
            } else {
                response.sendRedirect(request.getContextPath() + "/HomeAdmin");
            }
        } else if (login_result == 0) {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.INCORRECT_LOGIN_CREDENTIAL_ERROR);
            System.out.println("Username or Password Incorrect");
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        } else {
            request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
            request.getRequestDispatcher(StringUtils.LOGIN_PAGE).forward(request, response);
        }
    }


}
