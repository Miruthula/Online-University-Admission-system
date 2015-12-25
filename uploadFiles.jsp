<%-- 
    Document   : uploadFiles
    Created on : Apr 19, 2015, 4:04:57 PM
    Author     : josephaswin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>File Upload</title>
    </head>
    <body>
     <%
         String fileToUpload = request.getParameter("fileType");
     %>
        <form name='fileupload' action="/UMC1/FileUploads?fileType=<%=fileToUpload%>" enctype="multipart/form-data" encoding="multipart/form-data" method="POST">
            Select a file:
            <input type="file" name="file"/><span class="required">
            <br>   
           <input type="submit"> 
            <!-- <input type="button" name="upload" value="upload" onclick="javascript:onSave();"> -->
            <input type="button" name="cancel" value="cancel" onclick="javascript:window.close();">
        </form>
    </body>
    <script type="text/javascript">
            //<![CDATA[
            function onSave()
            {
                document.fileupload.action = "/UMC1/FileUploads?fileType=<%=fileToUpload%>";
                document.fileupload.submit();
                setTimeout(window.close();, 3000);
            }
            //]]>
</script>    
</html>
