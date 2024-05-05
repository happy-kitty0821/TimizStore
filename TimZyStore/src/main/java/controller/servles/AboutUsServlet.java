package controller.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.AboutUsModel;
import utils.StringUtils;

/**
 * Servlet implementation class AboutUsServlet
 */
@WebServlet("/AboutUsServlet")
public class AboutUsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutUsServlet() {
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
		String sender_name = request.getParameter("name");
		String sender_email = request.getParameter("email");
		String subject = request.getParameter("subject");
		String message = request.getParameter("feedback");
		AboutUsModel aboutUsModel = new AboutUsModel(sender_name, sender_email, subject, message);
		int result = dbController.storeAbouUsMessage(aboutUsModel);
	
		if (result == 1) {
		    request.getSession().setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.Successfully_Stored_Message);
		    response.sendRedirect(request.getContextPath() + StringUtils.ABOUT_US_PAGE);
		} 
		else if (result == 0) {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.INCORRECT_FORM_DATA_MESSAGE);
		    request.getRequestDispatcher(StringUtils.ABOUT_US_PAGE).forward(request, response);
		} 
		else {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.ABOUT_US_PAGE).forward(request, response);
		}
	}

}
