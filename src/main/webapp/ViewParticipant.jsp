<%@page import="com.Operation.ParticipantOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<%@page import="com.Operation.ParticipantOperation" %>
<%@page import="com.application.Participant" %>
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
<% ParticipantOperation participantOperation=new ParticipantOperation();
List<Participant> participants = participantOperation.getAllParticipants();
request.setAttribute("participantList", participants); %>
<div class="navbar">
 <div class="logo">Funfit</div>
  <a href="AddBatch.jsp">AddBatch</a>
  <a href="UpdateBatch.jsp">UpdateBatch</a>
  <a href="ViewBatch.jsp">View</a>
  <a href="AddParticipant.jsp">AddParticpant</a>
  <a href="UpdateParticipant.jsp">UpdateParticipant</a>
  <a href="ViewParticipant.jsp">View</a>
</div>
<h1>Participant List</h1>
    
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone Number</th>
            <th>Batch ID</th>
            <th>Operation</th>
        </tr>
        <!-- Loop through the list of participants and display each participant -->
        <c:forEach var="participant" items="${participantList}">
            <tr>
                <td>${participant.id}</td>
                <td>${participant.name}</td>
                <td>${participant.email}</td>
                <td>${participant.phoneNumber}</td>
                <td>${participant.batchId}</td>
                 <td>
                    <form action="ParticipantServlet" method="post">
                        <input type="hidden" name="action" value="delete">
                        <input type="hidden" name="id" value="${participant.id}">
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>