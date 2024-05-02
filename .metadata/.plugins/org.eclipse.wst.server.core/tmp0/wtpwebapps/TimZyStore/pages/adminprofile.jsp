<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Profile</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/Stylesheet/admin.css">
</head>
<body>
<div class="container">
  <div class="profile">
    <div class="profile-details">
      <h2>Admin</h2>
      <div class="form-group">
        <label for="name">Name:</label>
        <div id="name">Admin Name</div>
      </div>
      <div class="form-group">
        <label for="email">Email:</label>
        <div id="email">admin@example.com</div>
      </div>
      <div class="form-group">
        <label for="phone">Phone Number:</label>
        <div id="phone">123-456-7890</div>
      </div>
    </div>
    <div class="profile-pic">
      <img src="admin_profile_pic.jpg" alt="Admin Profile Picture">
    </div>
    <button id="edit-profile-btn" style="margin-top: 10px;">Edit Profile</button>
  </div>
</div>

<script>
document.getElementById("edit-profile-btn").addEventListener("click", function() {
  // Redirect to the edit profile page
  window.location.href = "admineditprofile.jsp"; // Replace "admineditprofile.jsp" with the actual URL of your admin edit profile JSP page
});
</script>

</body>
</html>
