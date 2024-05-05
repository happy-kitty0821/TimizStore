<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="models.AboutUsModel" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Messages</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }
        h1 {
            color: #333;
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #fff;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            font-weight: bold;
        }
        tr:nth-child(even) {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>All Messages</h1>
    <table>
        <tr>
            <th>Sender Name</th>
            <th>Sender Email</th>
            <th>Subject</th>
            <th>Message</th>
            <th>Timestamp</th>
        </tr>
        <% 
        List<AboutUsModel> messages = (List<AboutUsModel>) request.getAttribute("messages");
        if (messages != null) {
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            for (AboutUsModel message : messages) { %>
                <tr>
                    <td><%= message.getSender_name() %></td>
                    <td><%= message.getSender_email() %></td>
                    <td><%= message.getSubject() %></td>
                    <td><%= message.getMessage() %></td>
                    <td><%= sdf.format(message.getTimestamp()) %></td>
                </tr>
        <% } 
        } %>
    </table>
</body>
</html>
