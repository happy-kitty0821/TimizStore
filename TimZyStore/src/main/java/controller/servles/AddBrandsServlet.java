package controller.servles;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.DatabaseController;
import models.BrandModel;
import utils.StringUtils;

/**
 * Servlet implementation class AddBrandsServlet
 */
@WebServlet("/AddBrandsServlet")
public class AddBrandsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DatabaseController dbController = new DatabaseController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBrandsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		 List<BrandModel> brandDetails = dbController.getBrandDetails();
        request.setAttribute("brands", brandDetails);
        request.getRequestDispatcher("/pages/AddBrand.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String brand_name = request.getParameter("brand_name");
		String country_of_origin = request.getParameter("country_of_origin");
		String website = request.getParameter("website");
		BrandModel brandModel = new BrandModel(brand_name, country_of_origin, website);
		
		int result = dbController.addBrands(brandModel);
		System.out.print(result);
		if (result == 1) {
		    request.setAttribute(StringUtils.SUCCESS_MESSAGE, StringUtils.SUCCESSFULLY_ADD_BRAND_MESSAGE);
		    doGet(request,response);
		    //request.getRequestDispatcher(StringUtils.ADD_BRAND).forward(request, response);
		} 
		else if (result == 0) {
		    request.getSession().setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.INCORRECT_FORM_DATA_MESSAGE);
		    request.getRequestDispatcher(StringUtils.ADD_BRAND).forward(request, response);
		} 
		else {
		    request.setAttribute(StringUtils.ERROR_MESSAGE, StringUtils.SERVER_ERROR_MESSAGE);
		    request.getRequestDispatcher(StringUtils.ADD_BRAND).forward(request, response);
		}
		
	}

}
