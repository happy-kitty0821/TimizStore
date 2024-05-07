package controller.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.OrderModel;

/**
 * Servlet implementation class PurchaseServlet
 */
@WebServlet("/PurchaseServlet")
public class PurchaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = (String) request.getSession().getAttribute("username");
        if (username != null) {
        	System.out.println("Username is : " + username);
        }
        else {
        	System.out.println("user is not logged in");
            // Redirect to the login page
            response.sendRedirect(request.getContextPath() + "/pages/Login.jsp");
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	int product_id = Integer.parseInt(request.getParameter("product_id"));
    	int quantity = Integer.parseInt(request.getParameter("quantity"));
    	int user_id = Integer.parseInt(request.getParameter("user_id"));
    	Double price = Double.parseDouble(request.getParameter("price"));
    	Double total_price = quantity * price;
    	OrderModel orderModel = new OrderModel(user_id, total_price, product_id, quantity, price);
    	int result = dbController.storePurchases(orderModel);
	}

}
