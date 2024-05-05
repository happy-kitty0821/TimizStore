<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>
<%@ page import="models.BrandModel"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Brand</title>
    <style>
        /* General styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 80%;
            margin: 20px auto;
        }
        .error-message, .success-message {
            background-color: #f2dede;
            color: #a94442;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
        .success-message {
            background-color: #dff0d8;
            color: #3c763d;
        }
        .form {
            margin-bottom: 20px;
        }
        .form h2 {
            margin-bottom: 10px;
        }
        .form label {
            display: block;
            margin-bottom: 5px;
        }
        .form input[type="text"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        .form input[type="submit"] {
            background-color: #007bff;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .form input[type="submit"]:hover {
            background-color: #0056b3;
        }
        .table h2 {
            margin-bottom: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
        /* Buttons */
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
    </style>
</head>
<body>
    <div class="container">
        <div class="error-message">
            <%-- Display success message --%>
            <% String message = (String) request.getAttribute("message");%>
            <%if (message != null) {%>
            <div class="success-message"><%=message%></div>
            <%}%>
            <%-- Display error message --%>
            <%
            String errorMessage = (String) request.getAttribute("errorMessage");
            %>
            <%
            if (errorMessage != null) {
            %>
            <div class="error-message"><%=errorMessage%></div>
            <%
            }
            %>
        </div>
        <div class="form">
            <h2>Add Brand</h2>
            <form action="${pageContext.request.contextPath}/AddBrandsServlet"
                method="POST">
                <label for="brand_name">Brand Name:</label><br> <input
                    type="text" id="brand_name" name="brand_name" required><br>
                <br> <label for="country_of_origin">Country of Origin:</label><br>
                <input type="text" id="country_of_origin" name="country_of_origin"><br>
                <br> <label for="website">Website:</label><br> <input
                    type="text" id="website" name="website"><br>
                <br> <input type="submit" value="Submit">
            </form>
        </div>
        <div class="table">
        	<div class=brand-delte-msg>
        	
        	</div>
            <h2>All Brands</h2>
            <table>
                <thead>
                    <tr>
                        <th>Brand Name</th>
                        <th>Country of Origin</th>
                        <th>Website</th>
                        <th>Actions</th> <!-- Added Actions column -->
                    </tr>
                </thead>
                <tbody>
                    <%
                    List<BrandModel> brands = (List<BrandModel>) request.getAttribute("brands");
                    if (brands != null) {
                        for (BrandModel brand : brands) {
                    %>
                    <tr>
                        <td><%=brand.getBrand_name()%></td>
                        <td><%=brand.getCountry_of_origin()%></td>
                        <td><a href="<%=brand.getWebsite()%>"><%=brand.getWebsite()%></a></td>
                        <td class="actions">
                            <!-- Edit button -->
                            <a href="${pageContext.request.contextPath}/ModifyBrandServlet?brandId=<%= brand.getBrand_id() %>">Edit</a>
                            <!-- Delete button -->
                            <form action="${pageContext.request.contextPath}/ModifyBrandServlet" method="POST">
 								<input type="hidden" name="_method" value="DELETE">
                        		<input type="hidden" name="brandId" value="<%= brand.getBrand_id() %>">
                        		<input type="submit" value="Delete">
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="4">No brands found</td>
                    </tr>
                    <%
                    }
                    %>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>
