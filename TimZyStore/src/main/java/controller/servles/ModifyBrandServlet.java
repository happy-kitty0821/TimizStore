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
 * Servlet implementation class DeleteBrandServlet
 */
@WebServlet("/ModifyBrandServlet")
public class ModifyBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyBrandServlet() {
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
	    // Extract the brand ID from the request parameters
	    String brandIdParameter = request.getParameter("brandId");
	    if (brandIdParameter != null && !brandIdParameter.isEmpty()) {
	        int brandId = Integer.parseInt(brandIdParameter);
	        
	        // Call the deleteBrand method to delete the brand
	        int deleted = dbController.deleteBrand(brandId);
	        
	        // Set response status and message
	        if (deleted > 0) {
	        	request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.BRAND_DELETED_MESSAGE);
			    request.getRequestDispatcher("/AddBrandsServlet").forward(request, response);
	        } else {
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Status 500 Internal Server Error
	            response.getWriter().write("Failed to delete brand.");
	        }
	    } else {
	        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // Status 400 Bad Request
	        response.getWriter().write("No brand ID provided.");
	    }
	}


	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    // Extract the brand ID from the request
	    int brandId = Integer.parseInt(request.getParameter("brandId"));

	    // Call the deleteBrand method to delete the brand
	    int deleted = dbController.deleteBrand(brandId); // Assuming brandService is an instance of your service class

	    // Set response status and message
	    if (deleted > 0) {
	        response.setStatus(HttpServletResponse.SC_OK); // Status 200 OK
	        response.getWriter().write("Brand deleted successfully!");
	    } else {
	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // Status 500 Internal Server Error
	        response.getWriter().write("Failed to delete brand.");
	    }
	}
}
