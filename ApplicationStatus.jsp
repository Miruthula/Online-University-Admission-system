<%-- 
    Document   : ApplicationStatus
    Created on : Apr 16, 2015
    Author     : Admin
--%>

<%@page import="model.UserDetails"%>
<%@page import="model.UserApplication"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "Applicant_Side_Navigation.jsp" %>

<div id="sidebarcenter">
    <%
        UserDetails usrDtls = (UserDetails) session.getAttribute("UserDetails");
        String userType = usrDtls.getUserType();
        boolean isApplicationExists = usrDtls.isApplicationExists();

        if("Admin".equalsIgnoreCase(userType))
        {
    %>
    <p>
        Your role is not eligible to apply for the courses.
    </p>
    <%
        }
    %>
        
    <%    
        if(!isApplicationExists)
        {
    %>
    <p>
        Applications are not yet created.
    </p>
    <%
        }
        else
        {
    %>
    <p>
        Please find the different applications applied and its status below
    </p>

    <table>
        <thead>
            <tr>
                <th>Application ID</th>
                <th>Term</th>
                <th>Program Department - Major</th>
                <th>Status</th>
            </tr>
        </thead>
        <tbody>
            <%
                List<UserApplication> usrApplns = usrDtls.getUserApplnApplied();
                
                for( UserApplication usrAppln : usrApplns )
                {
            %>
                <tr>
                    <td><a href="/UMC1/ApplicationDetails?mode=update&applnID=<%= usrAppln.getApplnId() %>"><%= usrAppln.getApplnId() %></a></td>
                    <td><%= usrAppln.getTermName() %></td>
                    <td><%= usrAppln.getProgramName() %></td>
                    <td><%= usrAppln.getApplicationStatus() %></td>
                </tr>
            <%
                }
            %>

        </tbody>
    </table>
    
    <%
        }
    %>
    <p>
        <a href="/UMC1/ApplicationDetails?mode=insert">Click here</a> to Apply New.
    </p>

</div>
</div>

<%@ include file= "footer.jsp" %>