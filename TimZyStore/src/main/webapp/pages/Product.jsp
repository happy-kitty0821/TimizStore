<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.ProductModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/product.css">
    <title>Products</title>
    <!-- Your CSS styles -->
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">TimZy</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                <li class="nav-item">
                    <a class="nav-link" href="#">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Products</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">About Us</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">User</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Add to Cart</a>
                </li>
            </ul>
            <!-- Search form -->
            <form class="d-flex" action="${pageContext.request.contextPath}/SearchServlet" method="get">
                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="keyword">
                <button class="btn btn-outline-success" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<!-- End Navbar -->
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

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="card mb-4">
                <a href="#" class="card-link">
                    <div class="card-body">
                        <div class="category-image">
                            <img src="images/product_image.jpg" alt="Product image" class="img-fluid rounded">
                        </div>
                        <h4 class="card-title"><a>Product Name</a></h4>
                        <hr>
                        <div class="card-text">
                        	<span class="description float-start">Price:</span><br>
                            <span class="description float-start">Product Description</span><br>
                            <span class="description float-start">Connectivity:</span><br>
                            <span class="description float-start">Brand Name:</span><br>
                            <span class="description float-start">Operating System</span><br>
                            <span class="description float-start">ScreenSize:</span>
                            <span class="description float-start">Watch Color:</span><br>
                            <span class="description float-start">Features:</span>

                            </span>
                        
                            <div style="clear:both;"></div>
                            <button class="btn btn-primary">Add to Cart</button>
                            <button class="btn btn-success">Buy Now</button>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        
    </div>
</div>
<div class="container">
    <div class="row">
        <div class="col-md-3">
            <div class="card mb-4">
                <a href="#" class="card-link">
                    <div class="card-body">
                        <div class="category-image">
                            <img src="images/product_image.jpg" alt="Product image" class="img-fluid rounded">
                        </div>
                        <h4 class="card-title"><a>Product Name</a></h4>
                        <hr>
                        <div class="card-text">
                        	<span class="description float-start">Price:</span><br>
                            <span class="description float-start">Product Description</span><br>
                            <span class="description float-start">Connectivity:</span><br>
                            <span class="description float-start">Brand Name:</span><br>
                            <span class="description float-start">Operating System</span><br>
                            <span class="description float-start">ScreenSize:</span>
                            <span class="description float-start">Watch Color:</span><br>
                            <span class="description float-start">Features:</span>
                            </span>
                            <div style="clear:both;"></div>
                            <button class="btn btn-primary">Add to Cart</button>
                            <button class="btn btn-success">Buy Now</button>
                        </div>
                    </div>
                </a>
            </div>
        </div>
        
    </div>
</div>

<%@ include file="footer.jsp" %> <!-- Assuming you have a footer.jsp file for the footer -->

</body>
</html>