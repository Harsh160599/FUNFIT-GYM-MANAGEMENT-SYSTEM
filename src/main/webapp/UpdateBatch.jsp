<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@page import="com.Operation.BatchOperation" %>
<%@page import="com.application.Batch" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HARSH RAJ</title>
<style>
       .navbar {
        overflow: hidden;
        background-color: #333;
    }

    .navbar a {
        float: left;
        display: block;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
    }

    .navbar a:hover {
        background-color: #ddd;
        color: black;
    }

    h1 {
        text-align: center;
    }

    form {
        max-width: 400px;
        margin: 0 auto;
        padding: 20px;
        background: #f9f9f9;
        border-radius: 8px;
        box-shadow: 0 0 20px rgba(0, 0, 0, 0.1);
    }

    input[type="text"], select, input[type="submit"] {
        width: 100%;
        padding: 10px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }

    input[type="submit"] {
        background-color: #333;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type="submit"]:hover {
        background-color: #ddd;
        color: black;
    }
    .navbar .logo {
            float: right;
            color: #f2f2f2;
            font-size: 24px;
            padding: 14px 16px;
            text-decoration: none;
            margin-right: 40px;
        }
    </style>
</head>
<body>
<% BatchOperation batchOperation = new BatchOperation();
List<Integer> batchIds = batchOperation.getAllBatchIds();
   request.setAttribute("batchIds", batchIds); %>
   <div class="navbar">
  <a href="AddBatch.jsp">AddBatch</a>
   <div class="logo">Funfit</div>
  <a href="UpdateBatch.jsp">UpdateBatch</a>
  <a href="ViewBatch.jsp">View</a>
  <a href="AddParticipant.jsp">AddParticpant</a>
  <a href="UpdateParticipant.jsp">UpdateParticipant</a>
  <a href="ViewParticipant.jsp">View</a>
</div>
<h1>Update Batch</h1>
    <form action="BatchServlet" method="post">
        Batch ID: <select id="id" name="id">
            <c:forEach items="${batchIds}" var="batchId">
                <option value="${batchId}">${batchId}</option>
            </c:forEach>
        </select><br><br>
        New Batch Name: <input type="text" name="name"><br>
        New Batch Time:<select name="time">
            <option value="morning">Morning</option>
            <option value="evening">Evening</option>
        </select><br>
        <input type="hidden" name="action" value="update">
        <input type="submit" value="Update Batch">
    </form>
</body>
</html>