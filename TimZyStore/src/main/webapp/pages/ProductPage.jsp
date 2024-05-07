<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Page</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	 <% 
    // Check if a success or error message exists in the request scope
    String successMessage = (String) request.getAttribute("successMessage");
    String errorMessage = (String) request.getAttribute("errorMessage");
    
    if (successMessage != null) {
    %>
        <div class="alert alert-success" role="alert">
            <%= successMessage %>
        </div>
    <% 
    }
    
    if (errorMessage != null) {
    %>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
    <% 
    }
     
    List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
    if (products != null) {
        for (ProductModel product : products) { 
    %>
    <div class="card" style="width: 18rem; display: inline-block; margin: 10px;">
        <img src="${pageContext.request.contextPath}/Uploads/ProductPictures/<%= product.getProduct_image()%>" class="card-img-top" alt="<%= product.getProduct_name() %>">
        <div class="card-body">
            <h5 class="card-title"><%= product.getProduct_name() %></h5>
            
            <p class="card-text">Price: $<%= product.getPrice() %></p>
            <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
            	<input type="hidden" value="<%= product.getProduct_id()%>"name="product_id">
            	<input type="hidden" value = 1 name="quantity">
            	<input type="hidden" value="<%= session.getAttribute("user_id") %>" name="user_id">
            	<button type="submit" class="btn btn-primary">Add to cart</button>
            </form>
            <br>
            <form action="${pageContext.request.contextPath}/PurchaseServlet" method="post">
            	<input type="hidden" value="<%= product.getProduct_id()%>" name="product_id">
            	<input type="hidden" value = 1 name="quantity">
            	<input type="hidden" value =<%= product.getPrice() %> name="price">
            	<input type="hidden" value="<%= session.getAttribute("user_id") %>" name="user_id">
            	<button type="submit" class="btn btn-success">Buy Now</button>
            </form>
        </div>
    </div>
    <% 
        }
    } else {
    	%>
        <h1>No products have been added. Please add them.</h1>
        <% } %>
</div>
<!-- Include Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
