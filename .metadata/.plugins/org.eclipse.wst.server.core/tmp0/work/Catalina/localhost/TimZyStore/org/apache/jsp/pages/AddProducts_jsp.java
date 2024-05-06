/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-05-06 06:17:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AddProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Add Product</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            background-color: #f4f4f4;\r\n");
      out.write("            margin: 0;\r\n");
      out.write("            padding: 0;\r\n");
      out.write("        }\r\n");
      out.write("        .container {\r\n");
      out.write("            max-width: 600px;\r\n");
      out.write("            margin: 20px auto;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            background-color: #fff;\r\n");
      out.write("            border-radius: 8px;\r\n");
      out.write("            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("        }\r\n");
      out.write("        h2 {\r\n");
      out.write("            text-align: center;\r\n");
      out.write("            margin-bottom: 20px;\r\n");
      out.write("        }\r\n");
      out.write("        form {\r\n");
      out.write("            display: grid;\r\n");
      out.write("            grid-gap: 10px;\r\n");
      out.write("        }\r\n");
      out.write("        label {\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("        }\r\n");
      out.write("        input[type=\"text\"], input[type=\"number\"], textarea {\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            border: 1px solid #ccc;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            box-sizing: border-box;\r\n");
      out.write("        }\r\n");
      out.write("        input[type=\"submit\"] {\r\n");
      out.write("            width: auto;\r\n");
      out.write("            padding: 10px 20px;\r\n");
      out.write("            background-color: #007bff;\r\n");
      out.write("            color: #fff;\r\n");
      out.write("            border: none;\r\n");
      out.write("            border-radius: 4px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            font-size: 16px;\r\n");
      out.write("        }\r\n");
      out.write("        input[type=\"submit\"]:hover {\r\n");
      out.write("            background-color: #0056b3;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <h2>Add Product</h2>\r\n");
      out.write("        <div class=\"messages\">\r\n");
      out.write("        	    ");
      out.write("\r\n");
      out.write("    ");
 if (request.getAttribute("successMessage") != null) { 
      out.write("\r\n");
      out.write("        <div style=\"color: green;\">\r\n");
      out.write("            ");
      out.print( request.getAttribute("successMessage") );
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    ");
      out.write("\r\n");
      out.write("    ");
 if (request.getAttribute("errorMessage") != null) { 
      out.write("\r\n");
      out.write("        <div style=\"color: red;\">\r\n");
      out.write("            ");
      out.print( request.getAttribute("errorMessage") );
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <form action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/AddProductServlet\" method=\"POST\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <label for=\"productName\">Product Name:</label>\r\n");
      out.write("            <input type=\"text\" id=\"productName\" name=\"product_name\" required>\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"productDescription\">Product Description:</label>\r\n");
      out.write("            <textarea id=\"productDescription\" name=\"product_description\" rows=\"4\"></textarea>\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"price\">Price:</label>\r\n");
      out.write("            <input type=\"number\" id=\"price\" name=\"price\" min=\"0\" step=\"0.01\" required>\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"quantity\">Quantity:</label>\r\n");
      out.write("            <input type=\"number\" id=\"quantity\" name=\"quantity\" min=\"0\" required>\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"brandId\">Brand ID:</label>\r\n");
      out.write("            <input type=\"number\" id=\"brandId\" name=\"brand_id\" min=\"0\">\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"productImage\">Product Image:</label>\r\n");
      out.write("            <input type=\"file\" id=\"productImage\" name=\"product_image\">\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"screenSize\">Screen Size:</label>\r\n");
      out.write("            <input type=\"number\" id=\"screenSize\" name=\"screen_size\" min=\"0\" step=\"0.01\">\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"connectivity\">Connectivity:</label>\r\n");
      out.write("            <input type=\"text\" id=\"connectivity\" name=\"connectivity\">\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"os\">Operating System:</label>\r\n");
      out.write("            <input type=\"text\" id=\"os\" name=\"os\">\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"os\">Watch color:</label>\r\n");
      out.write("            <input type=\"text\" id=\"color\" name=\"color\">\r\n");
      out.write("            \r\n");
      out.write("            <label for=\"features\">Features:</label>\r\n");
      out.write("            <textarea id=\"features\" name=\"features\" rows=\"4\"></textarea>\r\n");
      out.write("            \r\n");
      out.write("            <input type=\"submit\" value=\"Add Product\">\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
