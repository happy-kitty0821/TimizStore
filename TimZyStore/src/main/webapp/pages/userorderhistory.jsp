<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Order History</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/Stylesheet/orderhhistory.css">
<style>
  /* Your CSS styles here */
</style>
</head>
<body>

<div class="header">
  <h1>Orders</h1>
</div>

<div class="container">
  <table>
    <thead>
      <tr>
        <th>Product Photo</th>
        <th>Name</th>
        <th>Description</th>
        <th>Price</th>
      </tr>
    </thead>
    <tbody id="order-list">
      <!-- Order items will be dynamically added here -->
    </tbody>
    <tfoot>
      <tr>
        <td colspan="3" style="text-align: right;">Total:</td>
        <td id="total-price">$0.00</td>
      </tr>
    </tfoot>
  </table>
  <button onclick="goBack()">Back to Cart</button> <!-- Button to go back to cart -->
</div>

<script>
// Function to add product to order history and calculate total price
function addToOrder(productName, description, price) {
  // Create a new row for the product
  var newRow = document.createElement("tr");
  newRow.innerHTML = `
    <td><img src="product_image.jpg" alt="${productName}"></td>
    <td>${productName}</td>
    <td>${description}</td>
    <td class="price">${price}</td>
  `;
  document.getElementById("order-list").appendChild(newRow);

  // Update total price
  var totalPrice = parseFloat(document.getElementById("total-price").innerText.replace("$", ""));
  totalPrice += parseFloat(price.replace("$", ""));
  document.getElementById("total-price").innerText = "$" + totalPrice.toFixed(2);
}

// Function to go back to the shopping cart
function goBack() {
  window.location.href = "addtocart.html"; // Replace "addtocart.html" with the actual URL of the shopping cart page
}
</script>

</body>
</html>
