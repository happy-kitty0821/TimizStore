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
    List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
    if (products != null) {
        for (ProductModel product : products) { 
    %>
    <div class="card" style="width: 18rem; display: inline-block; margin: 10px;">
        <img src="${pageContext.request.contextPath}/Uploads/ProductPictures/<%= product.getProduct_image()%>" class="card-img-top" alt="<%= product.getProduct_name() %>">
        <div class="card-body">
            <h5 class="card-title"><%= product.getProduct_name() %></h5>
            <p class="card-text"><%= product.getProduct_description() %></p>
            <p class="card-text">Price: $<%= product.getPrice() %></p>
            <form action="${pageContext.request.contextPath}/AddToCartServlet" method="post">
            	<input type="hidden" value="<%= product.getProduct_id()%>"name="product_id">
            	<input type="hidden" value = 1 name="quantity">
            	
            	<button type="submit" class="btn btn-primary">Add to cart</button>
            </form>
            <br>
            <form action="${pageContext.request.contextPath}/PurchaseServlet" method="post">
            	<input type="hidden" value="<%= product.getProduct_id()%>">
            	<button type="submit" class="btn btn-success">Add to cart</button>
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
