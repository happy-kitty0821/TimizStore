package controller.servles;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.DatabaseController;
import models.ProductModel;
import utils.StringUtils;

/**
 * Servlet implementation class AddProductServlet
 */
@WebServlet("/AddProductServlet")
@MultipartConfig(fileSizeThreshold=1024 * 1024 * 5,
maxFileSize = 1024*1024*10,
maxRequestSize = 1024*1024*50
)
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductServlet() {
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
		String productName = request.getParameter("product_name");
        String productDescription = request.getParameter("product_description");
        double price = Double.parseDouble(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int brandId = Integer.parseInt(request.getParameter("brand_id"));
        Part productImagePart = request.getPart("product_image");
        Double screenSize = Double.parseDouble(request.getParameter("screen_size"));
        String connectivity = request.getParameter("connectivity");
        String os = request.getParameter("os");
        String features = request.getParameter("features");
        String watch_color = request.getParameter("color");
        ProductModel productModel = new ProductModel(productName, productDescription, price, quantity, brandId, 
        		productImagePart, screenSize, connectivity, os, features, watch_color );
        String savePath = StringUtils.PRODUCT_PIC_SAVE_DIR;
		String fileName = productModel.getProduct_image();
		try {
		    if (fileName != null && !fileName.isEmpty()) {
		    	productImagePart.write(savePath + fileName);
		    }
		} catch (IOException ex) {
		    ex.printStackTrace();
		    // Handle the exception appropriately (e.g., log it, return an error message, etc.)
		}
		int result = dbController.addProduct(productModel);
		 if (result == 1) {
		        request.setAttribute("successMessage", "Product added successfully!");
		    } else {
		        request.setAttribute("errorMessage", "Error occurred while adding product.");
		    }
		    
		    // Forward the request to your JSP
		    request.getRequestDispatcher("pages/AddProducts.jsp").forward(request, response);
	}

}
