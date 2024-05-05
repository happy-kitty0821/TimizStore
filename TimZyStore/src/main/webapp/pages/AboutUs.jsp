<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>About Us Page</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath() %>/css/aboutus.css">
    </head>
    <body>
        <div class="section">
            <div class="container">
                <div class="content-section">
                    <div class="title">
                        <h1>About Us</h1>
                    </div>
                    <div class="content">
                        <h3>Timzy - Redefining Time, One Innovation at a Time</h3>
                        <p>Welcome to Timzy, where every second counts. We're dedicated to crafting smartwatches that blend style with innovation, keeping you connected and inspired. Join us in redefining the way you experience time.We provide you with timeless elegance. You can make a huge choice of product in our store !</p>
                        <div class="feedback-form">
                            <form action="${pageContext.request.contextPath}/AboutUsServlet" method="post">
                                <input type="text" name="name" placeholder="Your Name">
                                <input type="email" name="email" placeholder="Your Email">
                                <input type="text" name="subject" placeholder="Enter your subject">
                                <textarea name="feedback" placeholder="Your Feedback"></textarea>
                                <button type="submit">Submit</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="image-section">
                   
                     <img src="${pageContext.request.contextPath}/images/try.png" alt="about us">
                </div>
            </div>
        </div>
    </body>
</html>
