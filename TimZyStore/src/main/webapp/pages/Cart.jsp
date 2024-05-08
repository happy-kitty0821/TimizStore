<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="models.DisplayCartModel" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart Details</title>
<!-- Include Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<style>
    /* CSS for additional styling */
    .cart-item {
        border: 1px solid #ddd;
        padding: 10px;
        margin-bottom: 10px;
        background-color: #f9f9f9;
    }
    .product-info img {
        max-width: 100px;
        max-height: 100px;
    }
    .quantity-controls {
        display: flex;
        align-items: center;
    }
    .quantity-controls button {
        margin-left: 10px;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>Cart Details</h1>
        <div class="cart-items">
            <% 
            List<DisplayCartModel> cartDetails = (List<DisplayCartModel>) request.getAttribute("cart_details");
            if (cartDetails != null && !cartDetails.isEmpty()) {
                for (DisplayCartModel item : cartDetails) { 
            %>
            <div class="cart-item">
                <div class="row">
                    <div class="col-md-8">
                        <h3><%= item.getProduct_name() %></h3>
                        <!--<p>Product ID: <%= item.getProduct_id() %></p> -->
                        <img src="${pageContext.request.contextPath}/Uploads/ProductPictures/<%= item.getProduct_image() %>" alt="<%= item.getProduct_name() %>" class="img-fluid">
                    </div>
                    <div class="col-md-2">
                        <div class="quantity-controls">
                            <button class="btn btn-sm btn-secondary">-</button>
                            Quantity: <%= item.getQuantity() %>
                            <button class="btn btn-sm btn-secondary">+</button>
                        </div>
                    </div>
                    <div class="col-md-2">
                        Price: $<%= item.getPrice() %>
                    </div>
                </div>
            </div>
            <% 
                }
            } else {
            	%>
                <h2>No items in the cart</h2>
                <% } %>
        </div>
    </div>
<!-- Include Bootstrap JS -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
