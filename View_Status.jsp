<%-- 
    Document   : View_Status
    Created on : 19 Apr, 2015, 3:20:54 PM
    Author     : Admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file= "header.jsp" %>
<%@ include file= "Applicant_Side_Navigation.jsp" %>
<div id="sidebarcenter">
<c:choose>
    <c:when test="${temp2== 0}">
        <h2>No New Applications Submitted</h2>
    </c:when>
    <c:otherwise>
    <h2> List of Applications </h2>
    <table>
        <tr>
        <th>Application Id</th>
        <th>Term</th>
        <th>Program Name</th>
        <th>Program Department</th>
        <th>Application Status</th>
        
        
        </tr>
        
        <c:forEach var="item" items="${view}">
  
            <tr>  
    
        <td>
            <c:out value='${item.getApplication_Id()}'/>
        </td>
        <td>
            <c:out value='${item.getTerm()}'/>
        </td>
        <td>
            <c:out value='${item.getProgram()}'/>
        </td>
        <td>
            <c:out value='${item.getPgm_Dept()}'/>
        </td>
        <td>
            <c:out value='${item.getApp_Status()}'/>
        </td>
        </tr>

</c:forEach> 
            
            </table>
    </c:otherwise>
    
</c:choose> 
</div>
</div>

<%@ include file= "footer.jsp" %>
   

