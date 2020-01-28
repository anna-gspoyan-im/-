<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 12/26/2019
  Time: 11:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% if (request.getAttribute("jog")!=null) {
    response.getWriter().println(request.getAttribute("jog"));
}
%>
<form method="post" action="/register">
    name:<input type="text" name="name"><br/>
    surname:<input type="text" name="surname"><br/>
    age:<input type="text" name="age"><br/>
    Username : <input type="text" name="username"><br/>
    Password : <input type="password" name="pass"><br/>
    code:<input type="text" name="code"><br/>
    <input type="submit" name="Sign in">
</form>
</body>
</html>
