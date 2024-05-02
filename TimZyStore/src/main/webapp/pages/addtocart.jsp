<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Shopping Cart</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/Stylesheet/addtocart.css">
<style>
  /* Your CSS styles here */
</style>
</head>
<body>

<div class="header">
  <h1>Shopping Cart</h1>
</div>

<div class="container">
  <h2>Products</h2>
  <div class="product">
    <h3>Product 1</h3>
    <p>Description: Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    <p>Price: $19.99</p>
    <input type="number" id="quantity-product1" value="1" min="1"> <!-- Quantity field -->
    <button onclick="addToOrder('Product 1', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', '$19.99', 'quantity-product1')">Add to Cart</button> <!-- Buy Now button -->
    <button onclick="removeFromCart('quantity-product1')">Delete</button> <!-- Delete button -->
  </div>
  <div class="product">
    <h3>Product 2</h3>
    <p>Description: Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
    <p>Price: $29.99</p>
    <input type="number" id="quantity-product2" value="1" min="1"> <!-- Quantity field -->
    <button onclick="addToOrder('Product 2', 'Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', '$29.99', 'quantity-product2')">Add to Cart</button> <!-- Buy Now button -->
    <button onclick="removeFromCart('quantity-product2')">Delete</button> <!-- Delete button -->
  </div>
  <button onclick="goToOrderHistory()">Order History</button> <!-- Button to go to order history page -->
</div>

<script>
// Function to add product to order history and calculate total price
function addToOrder(productName, description, price, quantityId) {
  var quantity = parseInt(document.getElementById(quantityId).value); // Get quantity from input field

  // Create a new row for the product
  var newRow = document.createElement("tr");
  newRow.innerHTML = `
    <td><img src="product_image.jpg" alt="${productName}"></td>
    <td>${productName}</td>
    <td>${description}</td>
    <td class="price">${price}</td>
    <td>${quantity}</td>
  `;
  document.getElementById("order-list").appendChild(newRow);

  // Update total price
  var totalPrice = parseFloat(document.getElementById("total-price").innerText.replace("$", ""));
  totalPrice += parseFloat(price.replace("$", "")) * quantity;
  document.getElementById("total-price").innerText = "$" + totalPrice.toFixed(2);
}

// Function to remove product from cart
function removeFromCart(quantityId) {
  var quantity = parseInt(document.getElementById(quantityId).value); // Get quantity from input field
  var pricePerItem = parseFloat(document.querySelector('.price').innerText.replace("$", "")); // Get price per item

  // Update total price
  var totalPrice = parseFloat(document.getElementById("total-price").innerText.replace("$", ""));
  totalPrice -= pricePerItem * quantity;
  document.getElementById("total-price").innerText = "$" + totalPrice.toFixed(2);

  // Remove product from the cart
  var productContainer = document.getElementById(quantityId).parentNode; // Get the parent container of the product
  productContainer.parentNode.removeChild(productContainer); // Remove the product container from the DOM
}

// Function to go to order history page
function goToOrderHistory() {
  window.location.href = "orderhistory.jsp"; // Replace "orderhistory.jsp" with the actual URL of the order history page
}
</script>

</body>
</html>
