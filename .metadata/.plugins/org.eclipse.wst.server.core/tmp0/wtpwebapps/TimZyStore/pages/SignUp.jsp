<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up</title>
    <style>
      body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f5f5f5;
        }

        .container {
            display: flex;
            width: 100%;
            max-width: 800px;
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
            background-color: #fff;
        }

        .image-container {
            flex: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            overflow: hidden;
            background-color: #002f34;
        }

        .image-placeholder img {
            max-width: 100%;
            height: auto;
        }

        .form-container {
            flex: 1;
            padding: 40px;
        }

        h1 {
            margin-bottom: 30px;
            font-size: 24px;
            text-align: center;
            color: #002f34;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 8px;
            font-size: 14px;
            color: #002f34;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="tel"],
        select {
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-bottom: 15px;
            font-size: 16px;
            outline: none;
        }

        select {
            appearance: none;
            background: url('data:image/svg+xml;utf8,<svg fill="#002f34" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" width="24px" height="24px"><path d="M7 10l5 5 5-5z"/><path d="M0 0h24v24H0z" fill="none"/></svg>') no-repeat right #fff;
            background-size: 16px;
            padding-right: 30px;
        }

        .checkbox-container {
            display: flex;
            align-items: center;
            margin-bottom: 20px;
            font-size: 14px;
            color: #002f34;
        }

        .checkbox-container input[type="checkbox"] {
            margin-right: 8px;
        }

        button {
            background-color: #ff6d02;
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #ff8700;
        }

        p {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            color: #002f34;
        }

        a {
            color: #ff6d02;
            text-decoration: none;
        }
        <!-- Your CSS styles here -->
    </style>
</head>
<body>
    <div class="container">
        <div class="image-container">
            <div class="image-placeholder">
                <img src="https://via.placeholder.com/400" alt="Daraz Image">
            </div>
        </div>
        <div class="form-container">
            <h1>Create Your Account</h1>
            <form action="${pageContext.request.contextPath}/UserRegisterServlet" method="POST"enctype='multipart/form-data'>
                <label for="user-name">User Name</label>
                <input type="text" id="user-name" name="username" required>
                <label for="last-name">Full Name</label>
                <input type="text" id="Full-Name" name="fullname" required>
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
                <label for="phone-number">Phone Number</label>
                <input type="tel" id="phone-number" name="phonenumber" required>
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
                <label for="password">Profile Picture</label>
                <input type="file" id="profilepic" name="profilepic" required>
                <div class="checkbox-container">
                    <input type="checkbox" id="agree-terms" name="agree-terms" required>
                    <label for="agree-terms">I agree to the <a href="#">terms and conditions</a></label>
                </div>
                <button type="submit">Sign Up</button>
                <p> Already have an Account <a href="${pageContext.request.contextPath}/pages/Login.jsp">Login</a></p>
            </form>
        </div>
    </div>
</body>
</html>