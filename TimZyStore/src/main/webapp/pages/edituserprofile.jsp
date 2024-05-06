<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Edit Profile</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/user.css">
</head>
<body>
<div class="container">
  <div class="profile">
    <div class="profile-details">
      <h2>Edit Profile</h2>
      <form id="edit-profile-form">
        <div class="form-group">
          <label for="name">Name:</label>
          <input type="text" id="name" name="name" placeholder="Your Name">
        </div>
        <div class="form-group">
          <label for="email">Email:</label>
          <input type="email" id="email" name="email" placeholder="Your Email">
        </div>
        <div class="form-group">
          <label for="phone">Phone Number:</label>
          <input type="tel" id="phone" name="phone" placeholder="Your Phone Number">
        </div>
        <div class="form-group">
          <label for="profile-pic">Profile Picture:</label>
          <input type="file" id="profile-pic" name="profile-pic">
        </div>
        <button type="submit">Save Changes</button>
      </form>
    </div>
    <div class="profile-pic">
      <img id="profile-img" src="thar.jpeg" alt="Profile Picture">
    </div>
  </div>
</div>

<script>
document.getElementById("edit-profile-form").addEventListener("submit", function(event) {
  event.preventDefault(); // Prevent form submission
  
  // Perform actions to save changes (e.g., update database)
  
  // Redirect user back to user profile page after saving changes
  window.location.href = "profile.jsp"; // Replace "profile.jsp" with the actual URL of the user profile JSP page
});
</script>

</body>
</html>
