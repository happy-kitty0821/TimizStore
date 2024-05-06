<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/user.css">
</head>
<body>
<div class="container">
  <div class="profile">
    <div class="profile-details">
      <h2>User Profile</h2>
      <div class="form-group">
        <strong><label for="full-name">Full Name:</label></strong>
        <div id="fullname">${full_name}</div> <!-- Accessing full_name attribute -->
      </div>
      <div class="form-group">
        <strong><label for="user-name">User Name:</label></strong>
        <div id="username">${user_name}</div> <!-- Accessing user_name attribute -->
      </div>
      <div class="form-group">
        <strong><label for="email">Email:</label></strong>
        <div id="email">${email}</div> <!-- Accessing email attribute -->
      </div>
      <div class="form-group">
        <strong><label for="phone">Phone Number:</label></strong>
        <div id="phone">${phone_number}</div> <!-- Accessing phone_number attribute -->
      </div>
    </div>
    <div class="profile-pic">
      <img src="${pageContext.request.contextPath}/Uploads/ProfilePictures/${profilePictureImage}" alt="Profile Picture"> <!-- Accessing profilePictureImage attribute -->
    </div>
    <button id="edit-profile-btn" style="margin-top: 10px;">Purchase History</button>
  </div>
</div>

<script>
document.getElementById("edit-profile-btn").addEventListener("click", function() {
    // Retrieve the user_id from the JSP page using EL
    var userId = "${user_id}";
    // Redirect to the PurchaseHistoryServlet with user_id as a query parameter
    window.location.href = "<%= request.getContextPath() %>/PurchaseHistoryServlet?user_id=" + userId;
});
</script>

</body>
</html>
