<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Smart Watch</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/Style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta2/css/all.min.css">
    
    
</head>
<body>
    <div class="container">
        <div class="ecommerce-name"></div>
        <div class="navbar">
            <ul class="navlist">
                <li><a href="watch.jsp">Home</a></li>
                <li><a href="${pageContext.request.contextPath}/DisplayProductUser">Product</a></li>
                <li><a href="${pageContext.request.contextPath}/AboutUs.jsp">About Us</a></li>
                <% 
            if (session.getAttribute("username") == null) {
            %>
                <a href="${pageContext.request.contextPath}/pages/Login.jsp">Login</a>
            <% } else { %>
                <a href="${pageContext.request.contextPath}/LogOutServlet">Logout</a>
            <% } %>
                <!--<li><a href="#">SignUp</a></li> -->
            </ul>
             <li><a href="${pageContext.request.contextPath}/UserProfile" id="profile-link"><i class="fa-solid fa-user"></i></a></li>
             <li><a href="#"><i class="fa-solid fa-cart-shopping"></i></a></li>
            <button> Get Started</button>
        </div>
        <section class="hero">
            <div class="content">
                <h1>Choose TimZy For <span>Luxurious Life</span></h1>
                <p>TimZy is a well-reputed smartWatch brand renowned for its innovative design, cutting-edge technology, and user-friendly features.</p>
                <button>Explore More</button>
            </div>
            <div class="Img_box">
                <img src="${pageContext.request.contextPath}/images/smart watch.png" alt="Smart Watch">
                
            </div>
            <div class="features">
                <div class="card">
                    <img src="${pageContext.request.contextPath}/images/mark location.png" alt="Smart Watch">
                    <h3>GPS Tracking</h3>
                </div>
                <div class="card">
                    <<img src="${pageContext.request.contextPath}/images/heart pulse.png" alt="Smart Watch">
                    <h3>Heart Rate Sensor</h3>
                </div>
                <div class="card">
                    <img src="${pageContext.request.contextPath}/images/calories.png" alt="Smart Watch">
                    <h3>Calories Count</h3>
                </div>
            </div>
        </section>

    </div>
</body>
</html>