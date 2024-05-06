<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        img {
            max-width: 100px;
            height: auto;
        }
        .actions {
            white-space: nowrap;
        }
        .actions a, .actions input[type="submit"] {
            padding: 5px 10px;
            text-decoration: none;
            color: #fff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            margin-right: 5px; /* Add space between buttons */
        }
        .actions input[type="submit"] {
            background-color: #dc3545; /* Red color for delete button */
        }
        .actions input[type="submit"]:hover {
            background-color: #c82333; /* Darker red on hover */
        }
        
        /* Responsive styles */
        @media screen and (max-width: 768px) {
            table {
                font-size: 14px;
            }
            th, td {
                padding: 8px;
            }
            img {
                max-width: 80px;
            }
            .actions a, .actions input[type="submit"] {
                padding: 3px 6px;
                margin-right: 3px;
            }
        }
    </style>
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
                <td><img src="${pageContext.request.contextPath}/Uploads/ProductPictures/<%= product.getProduct_image() %>" alt="<%= product.getProduct_name() %>"></td>
                <td><%= product.getProduct_name() %></td>
                <td><%= product.getProduct_description() %></td>
                <td><%= product.getPrice() %></td>
                <td><%= product.getQuantity() %></td>
                <td class="actions">
                    <!-- Edit button -->
                    <a href="editProductServlet?productId=<%= product.getProduct_id() %>">Edit</a>
                    <br>
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
