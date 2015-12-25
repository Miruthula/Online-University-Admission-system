+++++<%-- 
    Document   : View_Application
    Created on : 16 Apr, 2015, 1:42:13 AM
    Author     : Admin
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@page import="com.Application.Application_Bean" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%@ include file= "header.jsp" %>
<%@ include file= "Faculty_Side-navigation.jsp" %>
<div id="sidebarcenter">
    <h3>Student Details</h3>
    <b>Application ID:</b> ${AppId} <br><br>
    <b>First Name :</b> ${bean.getFirst_Name()} <br><br>
    <b>Last Name :</b>${bean.getLast_Name()} <br><br>
    <b>Term :</b>${bean.getTerm()} <br><br>
    <b>Program :</b>${bean.getProgram()} <br><br>
    <b>Department :</b>${bean.getPgm_Dept()} <br><br>
    <b>Country of Citizenship :</b> ${bean.getCountry_Of_Citizenship()} <br><br>
    <b>Visa Status :</b> ${bean.getVisa_Status()} <br><br>
    
    <b>Test Scores :</b><br>
    <table>
        <thead>
            <tr>
                <th>Exam</th>
                <th>Score</th>
            </tr>    
        </thead>
        <tbody>
            <tr>
                <td>GRE</td>
                <td>${bean.getGRE()}</td>
            </tr>
            <tr>
                <td>TOEFL</td>
                <td>${bean.getTOEFL()}</td>
            </tr>
        </tbody>    
    </table>
            
    <b>Education Qualifications:</b><br>        
    <table>
        <thead>
            <tr>
                <th></th>
                <th>University</th>
                <th>Major</th>
                <th>GPA</th>
                <th>Graduated</th>
                <th>Graduated Date</th>
            </tr>    
        </thead>
        <tbody>
            <tr>
                <td>UG</td>
                <td>${bean.getUG_University()}</td>
                <td>${bean.getUG_Major()}</td>
                <td>${bean.getUG_GPA()}</td>
                <td>${bean.getUG_Graduated()}</td>
                <td>${bean.getUG_Graduated_Date()}</td>
            </tr>
            <tr>
                <td>PG</td>
                <td>${bean.getPG_University()}</td>
                <td>${bean.getPG_Major()}</td>
                <td>${bean.getPG_GPA()}</td>
                <td>${bean.getPG_Graduated()}</td>
                <td>${bean.getPG_Graduated_Date()}</td>
            </tr>    

        </tbody>
    </table>        
     
    <b>SOP Document :</b> <%
                                Application_Bean beanTemp = (Application_Bean) session.getAttribute("bean");
                                    if(beanTemp.getSOP() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('sop')">SOP</a>
                                <%
                                    }
                                %>
   <br><br> 

       <b>Resume Document :</b> <%
                                
                                    if(beanTemp.getResume() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('resume')">Resume</a>
                                <%
                                    }
                                %>
   <br><br> 

       <b>Recommendation 1 Document :</b> <%
                                
                                    if(beanTemp.getRec1() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('reco1')">Recommendation 1</a>
                                <%
                                    }
                                %>
   <br><br> 

       <b>Recommendation 2 Document :</b> <%
                                 if(beanTemp.getRec2() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('reco2')">Recommendation 2</a>
                                <%
                                    }
                                %>
   <br><br> 
    <b>UG Transcripts :</b> <%
                               
                                    if(beanTemp.getUg() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('ug')">UG Trascripts</a>
                                <%
                                    }
                                %>
   <br><br> 
   <b>PG Transcripts :</b> <%
                                
                                    if(beanTemp.getPg() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('pg')">PG Trascripts</a>
                                <%
                                    }
                                %>
   <br><br> 
   <b>ID Proof :</b> <%
                                
                                    if(beanTemp.getIdProof() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('idproof')">ID Proof</a>
                                <%
                                    }
                                %>
   <br><br> 
   
    <form action="Applications" method="post">
        <input type="submit" name="action" value="Grant Admission"> <br><br>
        <input type="submit" name="action" value="Deny Admission"> <br><br>
        
    </form>
   
    
    
    
</div>

</div>
<script type="text/javascript">
            //<![CDATA[

            var tabLinks = new Array();
            var contentDivs = new Array();
            
            function openUploadedFile(fileType){
                var myWindow = window.open("/UMC1/FileUploads?fromBean=true&fileType=" + fileType, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
            }
            //]]>
</script>
<%@ include file= "footer.jsp" %>