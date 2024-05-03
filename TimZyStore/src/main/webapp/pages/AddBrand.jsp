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
</style>
</head>
<body>
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
		<h2>All Brands</h2>
		<table>
			<thead>
				<tr>
					<th>Brand Name</th>
					<th>Country of Origin</th>
					<th>Website</th>
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
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="3">No brands found</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>
