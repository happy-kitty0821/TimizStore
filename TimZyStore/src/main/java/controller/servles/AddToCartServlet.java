package controller.servles;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.CartModel;

/**
 * Servlet implementation class AddToCartServlet
 */
@WebServlet("/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
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
		// TODO Auto-generated method stub
		doGet(request, response);
    	int product_id = Integer.parseInt(request.getParameter("product_id"));
    	int quantity = Integer.parseInt(request.getParameter("quantity"));
    	int user_id = Integer.parseInt(request.getParameter("user_id"));
    	
    	CartModel cartModel = new CartModel(user_id ,product_id, quantity);
    	int result = dbController.addProductToCart(cartModel);
        if (result == 1) {
            request.setAttribute("successMessage", "Product added to cart successfully");
        } 
        else {
            request.setAttribute("errorMessage", "Failed to add product to cart");
        }
        request.getRequestDispatcher("/DisplayProductUser").forward(request, response);
	}

}
