<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.DisplayCartModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Details</title>
<style>
    /* CSS for styling */
    .cart-item {
        border: 1px solid #ddd;
        padding: 10px;
        margin-bottom: 10px;
    }
    .product-info {
        display: inline-block;
        width: 70%;
    }
    .quantity {
        display: inline-block;
        width: 15%;
    }
    .price {
        display: inline-block;
        width: 15%;
    }
</style>
</head>
<body>
    <h1>Cart Details</h1>
    <div class="cart-items">
    <% 
    List<DisplayCartModel> cartDetails = (List<DisplayCartModel>) request.getAttribute("cart_details");
    if (cartDetails != null && !cartDetails.isEmpty()) {
        for (DisplayCartModel item : cartDetails) { 
    %>
    <div class="cart-item">
        <div class="product-info">
            <h3><%= item.getProduct_name() %></h3>
            <p>Product ID: <%= item.getProduct_id() %></p>
            <img src="${pageContext.request.contextPath}/Uploads/ProductPictures/<%= item.getProduct_image() %>" alt="<%= item.getProduct_name() %>">
        </div>
        <div class="quantity">
            Quantity: <%= item.getQuantity() %>
        </div>
        <div class="price">
            Price: $<%= item.getPrice() %>
        </div>
    </div>
    <% 
        }
    } else {
    	%>
        <h2>No items in the cart</h2>
        <% } %>
    </div>
</body>
</html>
