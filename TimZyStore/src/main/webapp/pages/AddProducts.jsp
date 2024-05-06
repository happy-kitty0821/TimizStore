<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        form {
            display: grid;
            grid-gap: 10px;
        }
        label {
            font-weight: bold;
        }
        input[type="text"], input[type="number"], textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[type="submit"] {
            width: auto;
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Add Product</h2>
        <div class="messages">
        	    <%-- Display success message if available --%>
    <% if (request.getAttribute("successMessage") != null) { %>
        <div style="color: green;">
            <%= request.getAttribute("successMessage") %>
        </div>
    <% } %>
    
    <%-- Display error message if available --%>
    <% if (request.getAttribute("errorMessage") != null) { %>
        <div style="color: red;">
            <%= request.getAttribute("errorMessage") %>
        </div>
    <% } %>
        </div>
        <form action="${pageContext.request.contextPath}/AddProductServlet" method="POST" enctype="multipart/form-data">
            <label for="productName">Product Name:</label>
            <input type="text" id="productName" name="product_name" required>
            
            <label for="productDescription">Product Description:</label>
            <textarea id="productDescription" name="product_description" rows="4"></textarea>
            
            <label for="price">Price:</label>
            <input type="number" id="price" name="price" min="0" step="0.01" required>
            
            <label for="quantity">Quantity:</label>
            <input type="number" id="quantity" name="quantity" min="0" required>
            
            <label for="brandId">Brand ID:</label>
            <input type="number" id="brandId" name="brand_id" min="0">
            
            <label for="productImage">Product Image:</label>
            <input type="file" id="productImage" name="product_image">
            
            <label for="screenSize">Screen Size:</label>
            <input type="number" id="screenSize" name="screen_size" min="0" step="0.01">
            
            <label for="connectivity">Connectivity:</label>
            <input type="text" id="connectivity" name="connectivity">
            
            <label for="os">Operating System:</label>
            <input type="text" id="os" name="os">
            
            <label for="os">Watch color:</label>
            <input type="text" id="color" name="color">
            
            <label for="features">Features:</label>
            <textarea id="features" name="features" rows="4"></textarea>
            
            <input type="submit" value="Add Product">
        </form>
    </div>
</body>
</html>