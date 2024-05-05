package controller.servles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.AboutUsModel;
import models.ProductModel;

/**
 * Servlet implementation class DisplayMessageServlet
 */
@WebServlet("/DisplayMessageServlet")
public class DisplayMessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<AboutUsModel> messages = dbController.getAllMessages();
		System.out.println("Calling of dsiplay product servlet");
        // Set the attribute in the request to pass the list of products to the JSP
        request.setAttribute("messages", messages);
        // Forward the request to your JSP
        request.getRequestDispatcher("pages/DisplayMessages.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
