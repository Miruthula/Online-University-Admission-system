<%-- 
    Document   : Update_Profile
    Created on : 19 Apr, 2015, 3:39:32 PM
    Author     : Admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file= "header.jsp" %>
<%@ include file= "Applicant_Side_Navigation.jsp" %>

<div id="sidebarcenter">
<form action="Application_Status" method="get">
    <br>
    <br>
    
Please update your information and update<br>
    <br>
    Email Address :    <br>Enter Updated Value :<input type="text" name="email" required="required" value="${updateinfo.getEmail()}"> <br><br>
    Address Line 1:  <br>Enter  Updated Value : <input type="text" name="address" required="required" value="${updateinfo.getAddress_Line1()}"><br><br>
    Address Line 2:  <br>Enter  Updated Value : <input type="text" name="address1" required="required" value="${updateinfo.getAddress_Line2()}"><br><br>    
    City :  <br>Enter Updated Value :<input type="text" name="city" required="required" value="${updateinfo.getCity()}"><br><br>
    State : <br>Enter Updated Value :<input type="text" name="state" required="required" value="${updateinfo.getState()}"><br><br>
    Postal Code : <br> Enter Updated Value :<input type="text" name="zip" required="required" value="${updateinfo.getPostal_Code()}"><br><br>
Phone :  <br>Enter Updated Value :<input type="text" name="phone" required="required" value="${updateinfo.getPhone_Number()}"><br><br>
<input type="Submit" name="action" value="UpdateValue">
</form>

<form action="Application_Status" method="get">
    
<input type="Submit" name="action" value="Back">
</form>
</div>
</div>
<%@ include file= "footer.jsp" %>