<%-- 
    Document   : UserHome
    Created on : 17 Apr, 2015, 10:40:57 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file= "header.jsp" %>
<%@ include file= "Applicant_Side_Navigation.jsp" %>

<div id="sidebarcenter">
    <h3>Welcome ${userbean} !! ${UserId} ${userName}</h3>
    
    
    <a href="/UMC/UserApplications">Apply New or View Application Status</a><br><br>
    <a href="Application_Status?action=update">Update Your Profile</a><br><br>
     <!-- <a href="/UMC/ApplicationDetails?mode=insert">Create a New Application</a> -->
     <!--<a href="/UMC1/ApplicationDetails?mode=insert">Click here</a> to Apply New.-->
    
</div>
</div>
<%@ include file= "footer.jsp" %>