<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
    <h2>Product List</h2>
    
    <table border="1">
        <tr>
            <th>Product Image</th>
            <th>Product Name</th>
            <th>Product Description</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Actions</th>
        </tr>
        <% 
            List<ProductModel> products = (List<ProductModel>) request.getAttribute("products");
            if (products != null) {
                for (ProductModel product : products) { 
        %>
            <tr>
                <td><img src="Uploads/ProductPictures/<%= product.getProduct_image() %>" alt="<%= product.getProduct_name() %>"></td>
                <td><%= product.getProduct_name() %></td>
                <td><%= product.getProduct_description() %></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getQuantity() %></td>
                <td>
                    <!-- Edit button -->
                    <a href="editProductServlet?productId=<%= product.getProduct_id() %>">Edit</a>
                    <!-- Delete button -->
                    <form action="deleteProductServlet" method="post">
                        <input type="hidden" name="productId" value="<%= product.getProduct_id() %>">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        <% 
                } 
            } 
        %>
    </table>
</body>
</html>