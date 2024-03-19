<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
    </style>
</head>
<body>
<div class="navbar">
  <a href="AddBatch.jsp">AddBatch</a>
  <a href="UpdateBatch.jsp">UpdateBatch</a>
  <a href="ViewBatch.jsp">View</a>
  <a href="AddParticipant.jsp">AddParticpant</a>
  <a href="UpdateParticipant.jsp">UpdateParticipant</a>
  <a href="ViewParticipant.jsp">View</a>
</div>
 <form action="ParticipantServlet" method="post">
  Participant ID to Delete: <input type="text" name="id"><br>
        <input type="hidden" name="action" value="delete">
        <input type="hidden" name="id" value="${participantId}">
        <input type="submit" value="Delete">
 </form>
</body>
</html>