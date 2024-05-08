<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>  
    <style>
    /* Footer Styles */
.footer {
    background-color: #f4f4f4;
    padding: 50px 0;
}

.footer-container {
    max-width: 1200px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
}

.company-description, .contact-info {
    width: 45%;
}

.company-description h2, .contact-info h2 {
    font-size: 24px;
    color: #333;
    margin-bottom: 20px;
}

.company-description p {
    color: #666;
}

.contact-info ul {
    list-style-type: none;
    padding: 0;
}

.contact-info ul li {
    margin-bottom: 10px;
}

.footer-bottom {
    background-color: #ddd;
    padding: 10px 0;
    text-align: center;
    margin-top: 30px;
}

.footer-bottom p {
    font-size: 14px;
    color: #666;
}
    
    </style>
    <footer class="footer">
    <div class="footer-container">
        <div class="company-description">
            <h2>About TimZy</h2>
            <p>TimZy is a leading brand in smartwatch technology, dedicated to providing innovative and stylish wearable devices that enhance everyday life. Our commitment to quality and customer satisfaction drives us to continually push the boundaries of what's possible in wearable technology.</p>
        </div>
        <div class="contact-info">
            <h2>Contact Us</h2>
            <ul>
                <li>Email: info@timzy.com</li>
                <li>Phone: +977 987726351</li>
                <li>Address: 123 Smartwatch Street, City, Country</li>
            </ul>
        </div>
    </div>
    <div class="footer-bottom">
        <p>&copy; 2024 TimZy. All rights reserved.</p>
    </div>
</footer>