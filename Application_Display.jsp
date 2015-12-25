<%-- 
    Document   : Application_Details
    Created on : 15 Apr, 2015, 1:24:14 AM
    Author     : Admin
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file= "header.jsp" %>
<%@ include file= "Faculty_Side-navigation.jsp" %>
<div id="sidebarcenter">
<c:choose>
    <c:when test="${temp1== 0}">
        <h2>No New Applications Submitted</h2>
    </c:when>
    <c:otherwise>
    <h2> List of Applications </h2>
    <table>
        <tr>
        <th>Application Id</th>
        <th>Term</th>
        <th>First Name</th>
        <th>Country of Citizenship</th>
        <th>Visa Status</th>
        <th>Program Name</th>
        <th>Program Department</th>
        
        
        </tr>
        
        <c:forEach var="item" items="${bean2}">
  
            <tr>  
    
        <td>
            <a href="StudentDetails?action=${item.getApplication_Id()}"><c:out value='${item.getApplication_Id()}'/></a>
        </td>
        <td>
            <c:out value='${item.getTerm()}'/>
        </td>
        <td>
            <c:out value='${item.getFirst_Name()}'/>
        </td>
        <td>
            <c:out value='${item.getCountry_Citizenship()}'/>
        </td>
        <td>
            <c:out value='${item.getVisa_Status()}'/>
        </td>
        <td>
            <c:out value='${item.getProgram()}'/>
        </td>
        <td>
            <c:out value='${item.getPgm_Dept()}'/>
        </td>
        
        </tr>

</c:forEach> 
            
            </table>
    </c:otherwise>
    
</c:choose> 
</div>
</div>

<%@ include file= "footer.jsp" %>