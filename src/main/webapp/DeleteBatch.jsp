<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <h1>Delete Batch</h1>
    <form action="BatchServlet" method="post">
        Batch ID to Delete: <input type="text" name="id"><br>
        <input type="hidden" name="action" value="delete">
        <input type="submit" value="Delete Batch">
    </form>
</body>
</html>