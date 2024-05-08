<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Products</title>
</head>
<body>
    <h1>Search Products</h1>
    <form action="${pageContext.request.contextPath}/SearchServlet" method="get">
        <label for="keyword">Keyword:</label>
        <input type="text" id="keyword" name="keyword">
        <button type="submit">Search</button>
    </form>
    <div class="display-result">
        <h1>Search Results</h1>
        <% 
        List<ProductModel> searchResults = (List<ProductModel>) request.getAttribute("search_result");
        if (searchResults != null) {
            for (ProductModel product : searchResults) { %>
                <div>
                    <h3><%= product.getProduct_name() %></h3>
                    <p>Description: <%= product.getProduct_description() %></p>
                    <p>Price: <%= product.getPrice() %></p>
                </div>
            <% }
        } else { %>
            <p>No results found.</p>
        <% }
        %>
    </div>
</body>
</html>
