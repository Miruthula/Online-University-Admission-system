<%-- 
    Document   : Login
    Created on : 18 Apr, 2015, 12:10:51 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "side-navigation.jsp" %>


<div id="center">
<h2>Please enter your Login Details</h2>
<form action="LoginController" method="post">
Username: <input type="text" name="username"><br><br>
password : <input type="password" name="password"><br><br>
<input type="submit" name="action" value="login"><br><br>
</form>


<a href="Register.jsp">Sign Up</a>

</div>
</div>
<%@ include file= "footer.jsp" %>