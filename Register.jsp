<%-- 
    Document   : Register
    Created on : 18 Apr, 2015, 1:34:42 AM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "side-navigation.jsp" %>
<div id="center">
    <h1>Please fill in the registration form</h1>
    <form action="RegisterController" method="post">
    Firstname &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="firstname"><br><br>
    Lastname&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="lastname"><br><br>
    
    Email&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="email" required="required" pattern="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$" name="email"><br><br>
   Phone Number: <input type="number" required="required" name="phone"> <br><br>
    
   Username&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" maxlength ="16" name="username"><br><br>
   Password&nbsp&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="password" required="required" maxlength ="16" name="password"><br><br>
    <h3>Please select your Security Question</h3><br>
    <select name="security" required="required" >
        <option  value="select">Select your Question</option>
        <option value="What is your Mother's Maiden name?">What is your Mother's Maiden name?</option>
        <option value="Who is your favourite teacher?">Who is your favourite teacher?</option>
        <option value="Who is your childhood best friend?">Who is your childhood best friend?</option>
        <option value="What is your pet name?">What is your favourite pet?</option>
    </select>
    Answer : <input type="text" required="required"  name="answer"><br><br>
    
    Date of Birth : <input type="text" id="dob" required="required" name="dob"><label for="dob">(Format dd/mm/yyyy)</label> <br><br>
    Gender: <input type="radio" name="gender" required="required" value="male">Male
    <input type="radio" name="gender" required="required" value="female">Female<br><br><br>
    AddressLine1&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="Addressline1"><br><br>
    AddressLine2&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="Addressline2"><br><br>
    City &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="city"><br><br>
    State&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="state"><br><br>
    PostalCode &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="number" required="required" name="Postalcode"><br><br>
    Country of Citizenship &nbsp;&nbsp;&nbsp;: <input type="text" required="required" name="countryofcitizenship"><br><br>
    <h5> Select your Visa Status</h5>
    <select name="visastatus" required="required" >
        <option  value="select">Visa Status</option>
        <option value="AC">American Citizen</option>
        <option value="H1">H1</option>
        <option value="H4">H4</option>
        <option value="L1">L1</option>
        <option value="F1">F1</option>
    </select><br><br><br>
    <input type="submit" name="action" value="Register">
    <input type="reset" value="Reset" name="reset">
    </form>
    </div>
</div>
<%@ include file= "footer.jsp" %>