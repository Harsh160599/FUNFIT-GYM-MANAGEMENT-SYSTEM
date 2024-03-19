<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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

        input[type="text"], input[type="submit"] {
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
<div class="navbar">
 <div class="logo">Funfit</div>
  <a href="AddBatch.jsp">AddBatch</a>
  <a href="UpdateBatch.jsp">UpdateBatch</a>
  <a href="ViewBatch.jsp">View</a>
  <a href="AddParticipant.jsp">AddParticpant</a>
  <a href="UpdateParticipant.jsp">UpdateParticipant</a>
  <a href="ViewParticipant.jsp">View</a>
</div>
<h1>Add Participant</h1>
        <form action="ParticipantServlet" method="post">
            <input type="hidden" name="action" value="add">
            ID: <input type="text" name="id"><br>
            Name: <input type="text" name="name"><br>
            Email: <input type="text" name="email"><br>
            Phone Number: <input type="text" name="phoneNumber"><br>
            Batch ID: <input type="text" name="batchId"><br>
            <input type="submit" value="Add Participant">
        </form>
</body>
</html>