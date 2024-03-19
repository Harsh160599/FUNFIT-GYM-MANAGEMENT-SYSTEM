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

        table {
            border-collapse: collapse;
            width: 100%;
        }

        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        form {
            display: inline;
        }

        input[type="submit"] {
            background-color: #333;
            color: white;
            padding: 6px 10px;
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
<%
	BatchOperation batchOperation = new BatchOperation();
	List<Batch> batches = batchOperation.ViewAllBatch();
	pageContext.setAttribute("batchList", batches);
%>
<div class="navbar">
 <div class="logo">Funfit</div>
  <a href="AddBatch.jsp">AddBatch</a>
  <a href="UpdateBatch.jsp">UpdateBatch</a>
  <a href="ViewBatch.jsp">View</a>
  <a href="AddParticipant.jsp">AddParticpant</a>
  <a href="UpdateParticipant.jsp">UpdateParticipant</a>
  <a href="ViewParticipant.jsp">View</a>
</div>
  <h1>View Batch</h1>
  <form id="updateForm" method="post">
        <input type="hidden" id="batchId" name="id">
    </form>
    <table border="1">
        <tr>
            <th>Batch ID</th>
            <th>Batch Name</th>
            <th>Batch Time</th>
            <th>Operation</th>
        </tr>
        <c:forEach items="${batchList}" var="batch">
            <tr>
                 <td><c:out value="${batch.id}" /></td>
                    <td><c:out value="${batch.name}" /></td>
                    <td><c:out value="${batch.time}" /></td>
                    <td>
                    <form action="BatchServlet" method="post">
                        <input type="hidden" name="id" value="${batch.id}">
                        <input type="hidden" name="action" value="delete">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>