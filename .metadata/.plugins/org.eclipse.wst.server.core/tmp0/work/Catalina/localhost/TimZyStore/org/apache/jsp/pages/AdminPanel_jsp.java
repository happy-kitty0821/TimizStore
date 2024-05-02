/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.99
 * Generated at: 2024-05-02 16:02:48 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AdminPanel_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\">\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("\n");
      out.write("    <!-- Boxicons -->\n");
      out.write("    <link href='https://unpkg.com/boxicons@2.0.9/css/boxicons.min.css' rel='stylesheet'>\n");
      out.write("    <!-- My CSS -->\n");
      out.write("     <link rel=\"stylesheet\" href=\"");
      out.print( request.getContextPath() );
      out.write("/css/AdminPanel.css\">\n");
      out.write("\n");
      out.write("    <title>AdminPanel</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- SIDEBAR -->\n");
      out.write("<section id=\"sidebar\">\n");
      out.write("    <a href=\"#\" class=\"brand\">\n");
      out.write("        <i class='bx bxs-smile'></i>\n");
      out.write("        <span class=\"text\">Admin</span>\n");
      out.write("    </a>\n");
      out.write("    <ul class=\"side-menu top\">\n");
      out.write("        <li class=\"active\">\n");
      out.write("            <a href=\"#\">\n");
      out.write("                <i class='bx bxs-dashboard' ></i>\n");
      out.write("                <span class=\"text\">Dashboard</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\">\n");
      out.write("                <i class='bx bxs-shopping-bag-alt' ></i>\n");
      out.write("                <span class=\"text\">My Store</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\">\n");
      out.write("                <i class='bx bxs-doughnut-chart' ></i>\n");
      out.write("                <span class=\"text\">Categories</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\">\n");
      out.write("                <i class='bx bxs-message-dots' ></i>\n");
      out.write("                <span class=\"text\">Message</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("       \n");
      out.write("    </ul>\n");
      out.write("    <ul class=\"side-menu\">\n");
      out.write("        <li>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/pages/AddProducts.jsp\">\n");
      out.write("                <i class='bx bxs-cog' ></i>\n");
      out.write("                <span class=\"text\">Add Product</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"#\" class=\"Admin\">\n");
      out.write("                <i class='bx bxs-log-out-circle' ></i>\n");
      out.write("                <span class=\"text\">Add Admin</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        <li>\n");
      out.write("            <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/LogOutServlet\" class=\"logout\">\n");
      out.write("                <i class='bx bxs-log-out-circle' ></i>\n");
      out.write("                <span class=\"text\">Logout</span>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("</section>\n");
      out.write("<!-- SIDEBAR -->\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!-- CONTENT -->\n");
      out.write("<section id=\"content\">\n");
      out.write("    <!-- NAVBAR -->\n");
      out.write("    <nav>\n");
      out.write("        <i class='bx bx-menu' ></i>\n");
      out.write("        <a href=\"#\" class=\"nav-link\">Categories</a>\n");
      out.write("        <form action=\"#\">\n");
      out.write("            <div class=\"form-input\">\n");
      out.write("                <input type=\"search\" placeholder=\"Search...\">\n");
      out.write("                <button type=\"submit\" class=\"search-btn\"><i class='bx bx-search' ></i></button>\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("        <input type=\"checkbox\" id=\"switch-mode\" hidden>\n");
      out.write("        <label for=\"switch-mode\" class=\"switch-mode\"></label>\n");
      out.write("        <a href=\"#\" class=\"notification\">\n");
      out.write("            <i class='bx bxs-bell' ></i>\n");
      out.write("            <span class=\"num\">8</span>\n");
      out.write("        </a>\n");
      out.write("        <a href=\"#\" class=\"profile\">\n");
      out.write("            <img src=\"https://gifdb.com/images/high/profile-pic-zero-two-cute-smiling-anime-girl-0xasiqei8p4kvjfi.gif\">\n");
      out.write("        </a>\n");
      out.write("    </nav>\n");
      out.write("    <!-- NAVBAR -->\n");
      out.write("\n");
      out.write("    <!-- MAIN -->\n");
      out.write("    <main>\n");
      out.write("        <div class=\"head-title\">\n");
      out.write("            <div class=\"left\">\n");
      out.write("                <h1>Dashboard</h1>\n");
      out.write("                <ul class=\"breadcrumb\">\n");
      out.write("                    <li>\n");
      out.write("                        <a href=\"#\">Dashboard</a>\n");
      out.write("                    </li>\n");
      out.write("                    <li><i class='bx bx-chevron-right' ></i></li>\n");
      out.write("                    <li>\n");
      out.write("                        <a class=\"active\" href=\"#\">Home</a>\n");
      out.write("                    </li>\n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <ul class=\"box-info\">\n");
      out.write("            <li>\n");
      out.write("                <i class='bx bxs-calendar-check' ></i>\n");
      out.write("                <span class=\"text\">\n");
      out.write("                    <h3><span>");
      out.print(request.getAttribute("productCount"));
      out.write("</span></h3>\n");
      out.write("                    <p>Total Products</p>\n");
      out.write("                </span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <i class='bx bxs-group' ></i>\n");
      out.write("                <span class=\"text\">\n");
      out.write("                    <h3><span>");
      out.print(request.getAttribute("customerCount"));
      out.write("</span></h3>\n");
      out.write("                    <p>Total User</p>\n");
      out.write("                </span>\n");
      out.write("            </li>\n");
      out.write("            <li>\n");
      out.write("                <i class='bx bxs-dollar-circle' ></i>\n");
      out.write("                <span class=\"text\">\n");
      out.write("                    <h3>$2543</h3>\n");
      out.write("                    <p>Recent Order</p>\n");
      out.write("                </span>\n");
      out.write("            </li>\n");
      out.write("        </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"table-data\">\n");
      out.write("            <div class=\"order\">\n");
      out.write("                <div class=\"head\">\n");
      out.write("                    <h3>Recent Orders</h3>\n");
      out.write("                    <i class='bx bx-search' ></i>\n");
      out.write("                    <i class='bx bx-filter' ></i>\n");
      out.write("                </div>\n");
      out.write("                <table>\n");
      out.write("                    <thead>\n");
      out.write("                    <tr>\n");
      out.write("                        <th>User</th>\n");
      out.write("                        <th>Product</th>\n");
      out.write("                        <th>Price</th>\n");
      out.write("                        <th>Action</th>\n");
      out.write("                    </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                    <tr>\n");
      out.write("                        <td>\n");
      out.write("                            <img src=\"\">\n");
      out.write("                            <p>John Doe</p>\n");
      out.write("                        </td>\n");
      out.write("                        <td>\n");
      out.write("                            <img src=\" \" alt=\"Product Image\">\n");
      out.write("                            <p>Product Name</p>\n");
      out.write("                        </td>\n");
      out.write("                        <td>$50</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select>\n");
      out.write("                                <option value=\"pending\">Pending</option>\n");
      out.write("                                <option value=\"confirmed\">Confirmed</option>\n");
      out.write("                                <option value=\"delivered\">Delivered</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                    </tr>\n");
      out.write("                    <!-- Add more rows as needed -->\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </main>\n");
      out.write("    <!-- MAIN -->\n");
      out.write("</section>\n");
      out.write("<!-- CONTENT -->\n");
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"script.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
