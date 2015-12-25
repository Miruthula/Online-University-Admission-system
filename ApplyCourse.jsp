<%-- 
    Document   : ApplyCourse
    Created on : 2 Apr, 2015, 11:51:58 PM
    Author     : Admin
--%>

<%@page import="model.UserDocumentProofs"%>
<%@page import="model.UserTestScores"%>
<%@page import="model.UserEducationalQualifications"%>
<%@page import="model.UserContactDetails"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.UserPersonalDetails"%>
<%@page import="model.UserApplication"%>
<%@page import="model.UserDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file= "header.jsp" %>
<%@ include file= "Applicant_Side_Navigation.jsp" %>

<div id="sidebarcenter" class="tabbody">
    <%
        UserDetails usrDtls = (UserDetails) session.getAttribute("UserApplicationDetails");
        UserApplication usrAppln = usrDtls.getCurrentApplication();
        UserPersonalDetails usrPersonalDtls = usrAppln.getPersonalDtls();
        UserContactDetails usrPermAddDtls = usrAppln.getPermanentAddress();
        UserContactDetails usrPostAddDtls = usrAppln.getPostalAddress();
        UserEducationalQualifications ugDtls = usrAppln.getUgQual();
        UserEducationalQualifications pgDtls = usrAppln.getPgQual();
        UserTestScores usrTest = usrAppln.getTestScores();
        UserDocumentProofs docs = usrAppln.getDocProof();
    %>
    <h1>Application</h1>

    <ul id="tabs">
        <li><a href="#instructions">Instructions</a></li>
        <li><a href="#general">General</a></li>
        <li><a href="#contact">Contact</a></li>
        <li><a href="#education">Education</a></li>
        <li><a href="#test">Test Scores</a></li>
        <li><a href="#docs">Documents</a></li>
    </ul>
    <form name="applnform" method="POST">
        <div class="tabContent" id="instructions">
            <h2>Instructions</h2>
            <div>
                <p>Instructions for All Applicants
                    Please note the following items must be submitted as part of this online admission application; paper submissions will not be accepted.
                    <br><br>
                    * $75 Processing Fee (non-refundable and non-transferable) using Mastercard, Visa, or American Express
                    <br><br>
                    * Statement of Purpose
                    <br><br>
                    * Recommender Information (required for doctoral and master's programs as well as some   certificate programs) including names and email addresses
                    <br><br>
                    * Any additional documents required by the program to which you are applying for admission
                    <br>
                </p>
            </div>
        </div>

        <div class="tabContent" id="general">
            <h2>General Informations</h2>
            <div id="genDiv">
                <ul class="noliststyle">
                    <li>
                        <p>Enter your&nbsp;name <font color="#ff0000">EXACTLY&nbsp;</font>as it appears on your&nbsp;United States social security card (or passport if you&nbsp;are an international student).&nbsp; Leave&nbsp;the middle name&nbsp;field blank if&nbsp;you do not have a middle name.</p>
                        <p>&nbsp;</p>   </li>
                    <li>
                        <label for="FirstName">First Name:</label>
                        <input type="text" id="FirstName" name="FirstName" value="<%=(usrPersonalDtls.getFirstName() != null) ? usrPersonalDtls.getFirstName() : "" %>" size="35" maxlength="25" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>
                        <label for="LastName">Last Name (Family):</label>
                        <input type="text" id="LastName" name="LastName" value="<%=usrPersonalDtls.getLastName()!= null ? usrPersonalDtls.getLastName() : "" %>"  size="35" maxlength="25" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>&nbsp;</li>
                    <li>
                        <label for="Gender">Sex:</label>
                        <select name="Gender" id="Gender" >
                            <option value="">Select</option>
                            <option value="Female">Female</option>
                            <option value="Male">Male</option>
                        </select><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>
                        <label for="DateofBirth">Date of Birth:</label>
                        <select id="MonthOfBirth" name="MonthOfBirth" >
                            <option value="">Select</option>
                            <option value="1">Jan</option>
                            <option value="2">Feb</option>
                            <option value="3">Mar</option>
                            <option value="4">Apr</option>
                            <option value="5">May</option>
                            <option value="6">Jun</option>
                            <option value="7">Jul</option>
                            <option value="8">Aug</option>
                            <option value="9">Sep</option>
                            <option value="10">Oct</option>
                            <option value="11">Nov</option>
                            <option value="12">Dec</option>
                        </select>&nbsp;
                        <select id="DayOfBirth" name="DayOfBirth" >
                            <option value="">Select</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>&nbsp;
                        <select id="YearOfBirth" name="YearOfBirth" >
                            <option value="">Select</option>
                            <option value="2002">2002</option>
                            <option value="2001">2001</option>
                            <option value="2000">2000</option>
                            <option value="1999">1999</option>
                            <option value="1998">1998</option>
                            <option value="1997">1997</option>
                            <option value="1996">1996</option>
                            <option value="1995">1995</option>
                            <option value="1994">1994</option>
                            <option value="1993">1993</option>
                            <option value="1992">1992</option>
                            <option value="1991">1991</option>
                            <option value="1990">1990</option>
                            <option value="1989">1989</option>
                            <option value="1988">1988</option>
                            <option value="1987">1987</option>
                            <option value="1986">1986</option>
                            <option value="1985">1985</option>
                            <option value="1984">1984</option>
                            <option value="1983">1983</option>
                            <option value="1982">1982</option>
                            <option value="1981">1981</option>
                            <option value="1980">1980</option>
                            <option value="1979">1979</option>
                            <option value="1978">1978</option>
                            <option value="1977">1977</option>
                            <option value="1976">1976</option>
                            <option value="1975">1975</option>
                            <option value="1974">1974</option>
                            <option value="1973">1973</option>
                            <option value="1972">1972</option>
                            <option value="1971">1971</option>
                            <option value="1970">1970</option>
                            <option value="1969">1969</option>
                            <option value="1968">1968</option>
                            <option value="1967">1967</option>
                            <option value="1966">1966</option>
                            <option value="1965">1965</option>
                            <option value="1964">1964</option>
                            <option value="1963">1963</option>
                            <option value="1962">1962</option>
                            <option value="1961">1961</option>
                            <option value="1960">1960</option>
                            <option value="1959">1959</option>
                            <option value="1958">1958</option>
                            <option value="1957">1957</option>
                            <option value="1956">1956</option>
                            <option value="1955">1955</option>
                            <option value="1954">1954</option>
                            <option value="1953">1953</option>
                            <option value="1952">1952</option>
                            <option value="1951">1951</option>
                            <option value="1950">1950</option>
                            <option value="1949">1949</option>
                            <option value="1948">1948</option>
                            <option value="1947">1947</option>
                            <option value="1946">1946</option>
                            <option value="1945">1945</option>
                            <option value="1944">1944</option>
                            <option value="1943">1943</option>
                            <option value="1942">1942</option>
                            <option value="1941">1941</option>
                            <option value="1940">1940</option>
                            <option value="1939">1939</option>
                            <option value="1938">1938</option>
                            <option value="1937">1937</option>
                            <option value="1936">1936</option>
                            <option value="1935">1935</option>
                            <option value="1934">1934</option>
                            <option value="1933">1933</option>
                            <option value="1932">1932</option>
                            <option value="1931">1931</option>
                            <option value="1930">1930</option>
                        </select><span class="smalltext">&nbsp;(m/d/yyyy)</span><span class="required">&nbsp;(required)</span>
                    </li>
                    <div class="dividerline2">&nbsp;</div>
                    <li>&nbsp;</li>
                    <li>
                        <label for="Citizenship">Citizenship:</label>
                        <select name="Citizenship" id="Citizenship" onchange="onChange_Country(this.value, & quot; PermAddy & quot; , this)">
                            <option value="">Select</option>
                            <option value="United States">United States</option>
                            <option value="Afghanistan">Afghanistan</option>
                            <option value="Albania">Albania</option>
                            <option value="Algeria">Algeria</option>
                            <option value="American Samoa">American Samoa</option>
                            <option value="Andorra">Andorra</option>
                            <option value="Angola">Angola</option>
                            <option value="Anguilla">Anguilla</option>
                            <option value="Antarctica">Antarctica</option>
                            <option value="Antigua and Barbuda">Antigua and Barbuda</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Armenia">Armenia</option>
                            <option value="Aruba">Aruba</option>
                            <option value="Australia">Australia</option>
                            <option value="Austria">Austria</option>
                            <option value="Azerbaijan">Azerbaijan</option>
                            <option value="Bahamas, The">Bahamas, The</option>
                            <option value="Bahrain">Bahrain</option>
                            <option value="Bangladesh">Bangladesh</option>
                            <option value="Barbados">Barbados</option>
                            <option value="Belarus">Belarus</option>
                            <option value="Belgium">Belgium</option>
                            <option value="Belize">Belize</option>
                            <option value="Benin">Benin</option>
                            <option value="Bermuda">Bermuda</option>
                            <option value="Bhutan">Bhutan</option>
                            <option value="Bolivia">Bolivia</option>
                            <option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
                            <option value="Botswana">Botswana</option>
                            <option value="Bouvet Island">Bouvet Island</option>
                            <option value="Brazil">Brazil</option>
                            <option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
                            <option value="Brunei">Brunei</option>
                            <option value="Bulgaria">Bulgaria</option>
                            <option value="Burkina Faso">Burkina Faso</option>
                            <option value="Burma">Burma</option>
                            <option value="Burundi">Burundi</option>
                            <option value="Cambodia">Cambodia</option>
                            <option value="Cameroon">Cameroon</option>
                            <option value="Canada">Canada</option>
                            <option value="Cape Verde">Cape Verde</option>
                            <option value="Cayman Islands">Cayman Islands</option>
                            <option value="Central African Republic">Central African Republic</option>
                            <option value="Chad">Chad</option>
                            <option value="Chile">Chile</option>
                            <option value="China">China</option>
                            <option value="China (Taiwan)">China (Taiwan)</option>
                            <option value="Christmas Island">Christmas Island</option>
                            <option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
                            <option value="Colombia">Colombia</option>
                            <option value="Comoros">Comoros</option>
                            <option value="Congo">Congo</option>
                            <option value="Cook Islands">Cook Islands</option>
                            <option value="Costa Rica">Costa Rica</option>
                            <option value="Cote D' Ivoire">Cote D' Ivoire</option>
                            <option value="Croatia">Croatia</option>
                            <option value="Cuba">Cuba</option>
                            <option value="Cyprus">Cyprus</option>
                            <option value="Czech Republic">Czech Republic</option>
                            <option value="Denmark">Denmark</option>
                            <option value="Djibouti">Djibouti</option>
                            <option value="Dominica">Dominica</option>
                            <option value="Dominican Republic">Dominican Republic</option>
                            <option value="East Germany">East Germany</option>
                            <option value="Ecuador">Ecuador</option>
                            <option value="Egypt">Egypt</option>
                            <option value="El Salvador">El Salvador</option>
                            <option value="Equatorial Guinea">Equatorial Guinea</option>
                            <option value="Eritrea">Eritrea</option>
                            <option value="Estonia">Estonia</option>
                            <option value="Ethiopia">Ethiopia</option>
                            <option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
                            <option value="Faroe Islands">Faroe Islands</option>
                            <option value="Fiji">Fiji</option>
                            <option value="Finland">Finland</option>
                            <option value="France">France</option>
                            <option value="French Guiana">French Guiana</option>
                            <option value="French Polynesia">French Polynesia</option>
                            <option value="French Southern Territories">French Southern Territories</option>
                            <option value="Gabon">Gabon</option>
                            <option value="Gambia">Gambia</option>
                            <option value="Georgia">Georgia</option>
                            <option value="Germany">Germany</option>
                            <option value="Ghana">Ghana</option>
                            <option value="Gibraltar">Gibraltar</option>
                            <option value="Greece">Greece</option>
                            <option value="Greenland">Greenland</option>
                            <option value="Grenada">Grenada</option>
                            <option value="Guadeloupe">Guadeloupe</option>
                            <option value="Guam">Guam</option>
                            <option value="Guatemala">Guatemala</option>
                            <option value="Guinea">Guinea</option>
                            <option value="Guinea-Bissau">Guinea-Bissau</option>
                            <option value="Guyana">Guyana</option>
                            <option value="Haiti">Haiti</option>
                            <option value="Heard and McDonald Islands">Heard and McDonald Islands</option>
                            <option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
                            <option value="Honduras">Honduras</option>
                            <option value="Hong Kong">Hong Kong</option>
                            <option value="Hungary">Hungary</option>
                            <option value="Iceland">Iceland</option>
                            <option value="India">India</option>
                            <option value="Indonesia">Indonesia</option>
                            <option value="Iran">Iran</option>
                            <option value="Iraq">Iraq</option>
                            <option value="Ireland">Ireland</option>
                            <option value="Israel">Israel</option>
                            <option value="Italy">Italy</option>
                            <option value="Ivory Coast">Ivory Coast</option>
                            <option value="Jamaica">Jamaica</option>
                            <option value="Japan">Japan</option>
                            <option value="Jordan">Jordan</option>
                            <option value="Kazakhstan">Kazakhstan</option>
                            <option value="Kenya">Kenya</option>
                            <option value="Kiribati">Kiribati</option>
                            <option value="Korea, Democratic People's Rep">Korea, Democratic People's Rep</option>
                            <option value="Korea, Republic Of">Korea, Republic Of</option>
                            <option value="Kuwait">Kuwait</option>
                            <option value="Kyrgyzstan">Kyrgyzstan</option>
                            <option value="Laos">Laos</option>
                            <option value="Latvia">Latvia</option>
                            <option value="Lebanon">Lebanon</option>
                            <option value="Lesotho">Lesotho</option>
                            <option value="Liberia">Liberia</option>
                            <option value="Libya">Libya</option>
                            <option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
                            <option value="Liechtenstein">Liechtenstein</option>
                            <option value="Lithuania">Lithuania</option>
                            <option value="Luxembourg">Luxembourg</option>
                            <option value="Macao">Macao</option>
                            <option value="Macedonia, Former Yugoslav">Macedonia, Former Yugoslav</option>
                            <option value="Madagascar">Madagascar</option>
                            <option value="Malawi">Malawi</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="Maldives">Maldives</option>
                            <option value="Mali">Mali</option>
                            <option value="Malta">Malta</option>
                            <option value="Marshall Islands">Marshall Islands</option>
                            <option value="Martinique">Martinique</option>
                            <option value="Mauritania">Mauritania</option>
                            <option value="Mauritius">Mauritius</option>
                            <option value="Mayotte">Mayotte</option>
                            <option value="Mexico">Mexico</option>
                            <option value="Micronesia, Federated States">Micronesia, Federated States</option>
                            <option value="Moldova, Republic Of">Moldova, Republic Of</option>
                            <option value="Monaco">Monaco</option>
                            <option value="Mongolia">Mongolia</option>
                            <option value="Montserrat">Montserrat</option>
                            <option value="Morocco">Morocco</option>
                            <option value="Mozambique">Mozambique</option>
                            <option value="Myanmar">Myanmar</option>
                            <option value="Namibia">Namibia</option>
                            <option value="Nauru">Nauru</option>
                            <option value="Nepal">Nepal</option>
                            <option value="Netherlands">Netherlands</option>
                            <option value="Netherlands Antilles">Netherlands Antilles</option>
                            <option value="New Caledonia">New Caledonia</option>
                            <option value="New Zealand">New Zealand</option>
                            <option value="Nicaragua">Nicaragua</option>
                            <option value="Niger">Niger</option>
                            <option value="Nigeria">Nigeria</option>
                            <option value="Niue">Niue</option>
                            <option value="Norfolk Island">Norfolk Island</option>
                            <option value="North Korea">North Korea</option>
                            <option value="North Yemen">North Yemen</option>
                            <option value="Northern Mariana Islands">Northern Mariana Islands</option>
                            <option value="Norway">Norway</option>
                            <option value="Oman">Oman</option>
                            <option value="Pakistan">Pakistan</option>
                            <option value="Palau">Palau</option>
                            <option value="Palestinian Territory Occupied">Palestinian Territory Occupied</option>
                            <option value="Panama">Panama</option>
                            <option value="Papua New Guinea">Papua New Guinea</option>
                            <option value="Paraguay">Paraguay</option>
                            <option value="Peru">Peru</option>
                            <option value="Philippines">Philippines</option>
                            <option value="Pitcairn">Pitcairn</option>
                            <option value="Poland">Poland</option>
                            <option value="Portugal">Portugal</option>
                            <option value="Puerto Rico">Puerto Rico</option>
                            <option value="Qatar">Qatar</option>
                            <option value="Reunion">Reunion</option>
                            <option value="Romania">Romania</option>
                            <option value="Russia">Russia</option>
                            <option value="Rwanda">Rwanda</option>
                            <option value="Saint Lucia">Saint Lucia</option>
                            <option value="Samoa">Samoa</option>
                            <option value="San Marino">San Marino</option>
                            <option value="Sao Tome and Principe">Sao Tome and Principe</option>
                            <option value="Saudi Arabia">Saudi Arabia</option>
                            <option value="Senegal">Senegal</option>
                            <option value="Serbia and Montenegro">Serbia and Montenegro</option>
                            <option value="Seychelles">Seychelles</option>
                            <option value="Sierra Leone">Sierra Leone</option>
                            <option value="Singapore">Singapore</option>
                            <option value="Slovakia">Slovakia</option>
                            <option value="Slovenia">Slovenia</option>
                            <option value="Solomon Islands">Solomon Islands</option>
                            <option value="Somalia">Somalia</option>
                            <option value="South Africa">South Africa</option>
                            <option value="South Georgia and Sandwich Isl">South Georgia and Sandwich Isl</option>
                            <option value="South Korea">South Korea</option>
                            <option value="South Yemen">South Yemen</option>
                            <option value="Spain">Spain</option>
                            <option value="Sri Lanka">Sri Lanka</option>
                            <option value="St. Helena">St. Helena</option>
                            <option value="St. Kitts and Nevis">St. Kitts and Nevis</option>
                            <option value="St. Pierre and Miquelon">St. Pierre and Miquelon</option>
                            <option value="St. Vincent and Grenadines">St. Vincent and Grenadines</option>
                            <option value="Sudan">Sudan</option>
                            <option value="Suriname">Suriname</option>
                            <option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
                            <option value="Swaziland">Swaziland</option>
                            <option value="Sweden">Sweden</option>
                            <option value="Switzerland">Switzerland</option>
                            <option value="Syria">Syria</option>
                            <option value="Taiwan, Province of China">Taiwan, Province of China</option>
                            <option value="Tajikistan">Tajikistan</option>
                            <option value="Tanzania">Tanzania</option>
                            <option value="Thailand">Thailand</option>
                            <option value="Timor-Leste">Timor-Leste</option>
                            <option value="Togo">Togo</option>
                            <option value="Tokelau">Tokelau</option>
                            <option value="Tongo">Tongo</option>
                            <option value="Trinidad and Tobago">Trinidad and Tobago</option>
                            <option value="Tunisia">Tunisia</option>
                            <option value="Turkey">Turkey</option>
                            <option value="Turkmenistan">Turkmenistan</option>
                            <option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
                            <option value="Tuvalu">Tuvalu</option>
                            <option value="Uganda">Uganda</option>
                            <option value="Ukraine">Ukraine</option>
                            <option value="United Arab Emirates">United Arab Emirates</option>
                            <option value="United Kingdom">United Kingdom</option>
                            <option value="United States">United States</option>
                            <option value="United States Minor Outlying">United States Minor Outlying</option>
                            <option value="Unknown">Unknown</option>
                            <option value="Upper Volta">Upper Volta</option>
                            <option value="Uruguay">Uruguay</option>
                            <option value="Uzbekistan">Uzbekistan</option>
                            <option value="Vanuatu">Vanuatu</option>
                            <option value="Venezuela">Venezuela</option>
                            <option value="Vietnam">Vietnam</option>
                            <option value="Virgin Islands, British">Virgin Islands, British</option>
                            <option value="Virgin, Islands, U.S.">Virgin, Islands, U.S.</option>
                            <option value="Wallis and Futuna">Wallis and Futuna</option>
                            <option value="West Germany">West Germany</option>
                            <option value="Western Sahara">Western Sahara</option>
                            <option value="Western Samoa">Western Samoa</option>
                            <option value="Yemen">Yemen</option>
                            <option value="Yugoslavia">Yugoslavia</option>
                            <option value="Zaire">Zaire</option>
                            <option value="Zambia">Zambia</option>
                            <option value="Zimbabwe">Zimbabwe</option>
                        </select><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>
                        <label for="VisaStatus">Visa Status:</label>
                        <input type="text" id="VisaStatus" name="VisaStatus" value="<%=usrPersonalDtls.getVisaStatus()!=null ? usrPersonalDtls.getVisaStatus() : "" %>"  size="35" maxlength="40" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <div class="dividerline2">&nbsp;</div>
                    <li>&nbsp;</li>
                    <li>
                        <label for="CourseProgram">Program:</label>
                        <select id="CourseProgram" name="CourseProgram">
                            <option value="">Select</option>
                            <option value="13">Bachelors-CIVIL</option>
                            <option value="4">Bachelors-CS</option>
                            <option value="7">Bachelors-EE</option>
                            <option value="19">Bachelors-FIN</option>
                            <option value="1">Bachelors-IT</option>
                            <option value="10">Bachelors-MECH</option>
                            <option value="16">Bachelors-MGMT</option>
                            <option value="14">Masters-CIVIL</option>
                            <option value="5">Masters-CS</option>
                            <option value="8">Masters-EE</option>
                            <option value="20">Masters-FIN</option>
                            <option value="2">Masters-IT</option>
                            <option value="11">Masters-MECH</option>
                            <option value="17">Masters-MGMT</option>
                            <option value="15">PhD-CIVIL</option>
                            <option value="6">PhD-CS</option>
                            <option value="9">PhD-EE</option>
                            <option value="21">PhD-FIN</option>
                            <option value="3">PhD-IT</option>
                            <option value="12">PhD-MECH</option>
                            <option value="18">PhD-MGMT</option>
                        </select>&nbsp;
                    </li>


                    <li>
                        <label for="CourseTerm">Term:</label>
                        <select id="CourseTerm" name="CourseTerm">
                            <option value="">Select</option>
                            <option value="1">Fall 2015</option>
                            <option value="2">Spring 2016</option>
                            <option value="3">Fall 2016</option>
                            <option value="4">Spring 2017</option>
                        </select>&nbsp;
                </ul>
            </div>
        </div>

        <div class="tabContent" id="contact">
            <h2>Contact Informations</h2>
            <div id="contactDiv">
                <ul class="noliststyle">
                    <li>
                        <label for="EmailAddress">Email Address:</label>
                        <input type="text" name="EmailAddress" id="EmailAddress" value="<%=usrPersonalDtls.getEmail()!= null ? usrPersonalDtls.getEmail(): "" %>"  size="35" maxlength="40" onfocus="select()" onblur="javascript:validate_Email(EmailAddress);"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>
                        <label for="RetypeEmailAddress">Retype Email Address:</label>
                        <input type="text" id="RetypeEmailAddress" name="EmailAddress2" value="<%=usrPersonalDtls.getEmail()!=null ? usrPersonalDtls.getEmail(): "" %>"  size="35" maxlength="40" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>
                        <label for="CellPhoneNumber">Cell Phone #:</label>
                        <span id="cellforeign" class="tr_hide"><input type="text" id="phone" name="phone" value="<%=usrPersonalDtls.getPhoneNum()!= null ? usrPersonalDtls.getPhoneNum(): "" %>"   size="20" maxlength="20" onfocus="select()"></span>
                    </li>
                    <div class="dividerline2">&nbsp;</div>
                    <li>&nbsp;</li>
                    <li>
                        Please enter your <strong>permanent</strong> address.
                    </li>
                    <li>&nbsp;</li>
                    <li>
                        <label for="PermCountry">Country:</label>
                        <select name="PermCountry" id="PermCountry" onchange="onChange_Country(this.value, & quot; PermAddy & quot; , this)">
                            <option value="">Select</option>
                            <option value="United States">United States</option>
                            <option value="Afghanistan">Afghanistan</option>
                            <option value="Albania">Albania</option>
                            <option value="Algeria">Algeria</option>
                            <option value="American Samoa">American Samoa</option>
                            <option value="Andorra">Andorra</option>
                            <option value="Angola">Angola</option>
                            <option value="Anguilla">Anguilla</option>
                            <option value="Antarctica">Antarctica</option>
                            <option value="Antigua and Barbuda">Antigua and Barbuda</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Armenia">Armenia</option>
                            <option value="Aruba">Aruba</option>
                            <option value="Australia">Australia</option>
                            <option value="Austria">Austria</option>
                            <option value="Azerbaijan">Azerbaijan</option>
                            <option value="Bahamas, The">Bahamas, The</option>
                            <option value="Bahrain">Bahrain</option>
                            <option value="Bangladesh">Bangladesh</option>
                            <option value="Barbados">Barbados</option>
                            <option value="Belarus">Belarus</option>
                            <option value="Belgium">Belgium</option>
                            <option value="Belize">Belize</option>
                            <option value="Benin">Benin</option>
                            <option value="Bermuda">Bermuda</option>
                            <option value="Bhutan">Bhutan</option>
                            <option value="Bolivia">Bolivia</option>
                            <option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
                            <option value="Botswana">Botswana</option>
                            <option value="Bouvet Island">Bouvet Island</option>
                            <option value="Brazil">Brazil</option>
                            <option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
                            <option value="Brunei">Brunei</option>
                            <option value="Bulgaria">Bulgaria</option>
                            <option value="Burkina Faso">Burkina Faso</option>
                            <option value="Burma">Burma</option>
                            <option value="Burundi">Burundi</option>
                            <option value="Cambodia">Cambodia</option>
                            <option value="Cameroon">Cameroon</option>
                            <option value="Canada">Canada</option>
                            <option value="Cape Verde">Cape Verde</option>
                            <option value="Cayman Islands">Cayman Islands</option>
                            <option value="Central African Republic">Central African Republic</option>
                            <option value="Chad">Chad</option>
                            <option value="Chile">Chile</option>
                            <option value="China">China</option>
                            <option value="China (Taiwan)">China (Taiwan)</option>
                            <option value="Christmas Island">Christmas Island</option>
                            <option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
                            <option value="Colombia">Colombia</option>
                            <option value="Comoros">Comoros</option>
                            <option value="Congo">Congo</option>
                            <option value="Cook Islands">Cook Islands</option>
                            <option value="Costa Rica">Costa Rica</option>
                            <option value="Cote D' Ivoire">Cote D' Ivoire</option>
                            <option value="Croatia">Croatia</option>
                            <option value="Cuba">Cuba</option>
                            <option value="Cyprus">Cyprus</option>
                            <option value="Czech Republic">Czech Republic</option>
                            <option value="Denmark">Denmark</option>
                            <option value="Djibouti">Djibouti</option>
                            <option value="Dominica">Dominica</option>
                            <option value="Dominican Republic">Dominican Republic</option>
                            <option value="East Germany">East Germany</option>
                            <option value="Ecuador">Ecuador</option>
                            <option value="Egypt">Egypt</option>
                            <option value="El Salvador">El Salvador</option>
                            <option value="Equatorial Guinea">Equatorial Guinea</option>
                            <option value="Eritrea">Eritrea</option>
                            <option value="Estonia">Estonia</option>
                            <option value="Ethiopia">Ethiopia</option>
                            <option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
                            <option value="Faroe Islands">Faroe Islands</option>
                            <option value="Fiji">Fiji</option>
                            <option value="Finland">Finland</option>
                            <option value="France">France</option>
                            <option value="French Guiana">French Guiana</option>
                            <option value="French Polynesia">French Polynesia</option>
                            <option value="French Southern Territories">French Southern Territories</option>
                            <option value="Gabon">Gabon</option>
                            <option value="Gambia">Gambia</option>
                            <option value="Georgia">Georgia</option>
                            <option value="Germany">Germany</option>
                            <option value="Ghana">Ghana</option>
                            <option value="Gibraltar">Gibraltar</option>
                            <option value="Greece">Greece</option>
                            <option value="Greenland">Greenland</option>
                            <option value="Grenada">Grenada</option>
                            <option value="Guadeloupe">Guadeloupe</option>
                            <option value="Guam">Guam</option>
                            <option value="Guatemala">Guatemala</option>
                            <option value="Guinea">Guinea</option>
                            <option value="Guinea-Bissau">Guinea-Bissau</option>
                            <option value="Guyana">Guyana</option>
                            <option value="Haiti">Haiti</option>
                            <option value="Heard and McDonald Islands">Heard and McDonald Islands</option>
                            <option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
                            <option value="Honduras">Honduras</option>
                            <option value="Hong Kong">Hong Kong</option>
                            <option value="Hungary">Hungary</option>
                            <option value="Iceland">Iceland</option>
                            <option value="India">India</option>
                            <option value="Indonesia">Indonesia</option>
                            <option value="Iran">Iran</option>
                            <option value="Iraq">Iraq</option>
                            <option value="Ireland">Ireland</option>
                            <option value="Israel">Israel</option>
                            <option value="Italy">Italy</option>
                            <option value="Ivory Coast">Ivory Coast</option>
                            <option value="Jamaica">Jamaica</option>
                            <option value="Japan">Japan</option>
                            <option value="Jordan">Jordan</option>
                            <option value="Kazakhstan">Kazakhstan</option>
                            <option value="Kenya">Kenya</option>
                            <option value="Kiribati">Kiribati</option>
                            <option value="Korea, Democratic People's Rep">Korea, Democratic People's Rep</option>
                            <option value="Korea, Republic Of">Korea, Republic Of</option>
                            <option value="Kuwait">Kuwait</option>
                            <option value="Kyrgyzstan">Kyrgyzstan</option>
                            <option value="Laos">Laos</option>
                            <option value="Latvia">Latvia</option>
                            <option value="Lebanon">Lebanon</option>
                            <option value="Lesotho">Lesotho</option>
                            <option value="Liberia">Liberia</option>
                            <option value="Libya">Libya</option>
                            <option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
                            <option value="Liechtenstein">Liechtenstein</option>
                            <option value="Lithuania">Lithuania</option>
                            <option value="Luxembourg">Luxembourg</option>
                            <option value="Macao">Macao</option>
                            <option value="Macedonia, Former Yugoslav">Macedonia, Former Yugoslav</option>
                            <option value="Madagascar">Madagascar</option>
                            <option value="Malawi">Malawi</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="Maldives">Maldives</option>
                            <option value="Mali">Mali</option>
                            <option value="Malta">Malta</option>
                            <option value="Marshall Islands">Marshall Islands</option>
                            <option value="Martinique">Martinique</option>
                            <option value="Mauritania">Mauritania</option>
                            <option value="Mauritius">Mauritius</option>
                            <option value="Mayotte">Mayotte</option>
                            <option value="Mexico">Mexico</option>
                            <option value="Micronesia, Federated States">Micronesia, Federated States</option>
                            <option value="Moldova, Republic Of">Moldova, Republic Of</option>
                            <option value="Monaco">Monaco</option>
                            <option value="Mongolia">Mongolia</option>
                            <option value="Montserrat">Montserrat</option>
                            <option value="Morocco">Morocco</option>
                            <option value="Mozambique">Mozambique</option>
                            <option value="Myanmar">Myanmar</option>
                            <option value="Namibia">Namibia</option>
                            <option value="Nauru">Nauru</option>
                            <option value="Nepal">Nepal</option>
                            <option value="Netherlands">Netherlands</option>
                            <option value="Netherlands Antilles">Netherlands Antilles</option>
                            <option value="New Caledonia">New Caledonia</option>
                            <option value="New Zealand">New Zealand</option>
                            <option value="Nicaragua">Nicaragua</option>
                            <option value="Niger">Niger</option>
                            <option value="Nigeria">Nigeria</option>
                            <option value="Niue">Niue</option>
                            <option value="Norfolk Island">Norfolk Island</option>
                            <option value="North Korea">North Korea</option>
                            <option value="North Yemen">North Yemen</option>
                            <option value="Northern Mariana Islands">Northern Mariana Islands</option>
                            <option value="Norway">Norway</option>
                            <option value="Oman">Oman</option>
                            <option value="Pakistan">Pakistan</option>
                            <option value="Palau">Palau</option>
                            <option value="Palestinian Territory Occupied">Palestinian Territory Occupied</option>
                            <option value="Panama">Panama</option>
                            <option value="Papua New Guinea">Papua New Guinea</option>
                            <option value="Paraguay">Paraguay</option>
                            <option value="Peru">Peru</option>
                            <option value="Philippines">Philippines</option>
                            <option value="Pitcairn">Pitcairn</option>
                            <option value="Poland">Poland</option>
                            <option value="Portugal">Portugal</option>
                            <option value="Puerto Rico">Puerto Rico</option>
                            <option value="Qatar">Qatar</option>
                            <option value="Reunion">Reunion</option>
                            <option value="Romania">Romania</option>
                            <option value="Russia">Russia</option>
                            <option value="Rwanda">Rwanda</option>
                            <option value="Saint Lucia">Saint Lucia</option>
                            <option value="Samoa">Samoa</option>
                            <option value="San Marino">San Marino</option>
                            <option value="Sao Tome and Principe">Sao Tome and Principe</option>
                            <option value="Saudi Arabia">Saudi Arabia</option>
                            <option value="Senegal">Senegal</option>
                            <option value="Serbia and Montenegro">Serbia and Montenegro</option>
                            <option value="Seychelles">Seychelles</option>
                            <option value="Sierra Leone">Sierra Leone</option>
                            <option value="Singapore">Singapore</option>
                            <option value="Slovakia">Slovakia</option>
                            <option value="Slovenia">Slovenia</option>
                            <option value="Solomon Islands">Solomon Islands</option>
                            <option value="Somalia">Somalia</option>
                            <option value="South Africa">South Africa</option>
                            <option value="South Georgia and Sandwich Isl">South Georgia and Sandwich Isl</option>
                            <option value="South Korea">South Korea</option>
                            <option value="South Yemen">South Yemen</option>
                            <option value="Spain">Spain</option>
                            <option value="Sri Lanka">Sri Lanka</option>
                            <option value="St. Helena">St. Helena</option>
                            <option value="St. Kitts and Nevis">St. Kitts and Nevis</option>
                            <option value="St. Pierre and Miquelon">St. Pierre and Miquelon</option>
                            <option value="St. Vincent and Grenadines">St. Vincent and Grenadines</option>
                            <option value="Sudan">Sudan</option>
                            <option value="Suriname">Suriname</option>
                            <option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
                            <option value="Swaziland">Swaziland</option>
                            <option value="Sweden">Sweden</option>
                            <option value="Switzerland">Switzerland</option>
                            <option value="Syria">Syria</option>
                            <option value="Taiwan, Province of China">Taiwan, Province of China</option>
                            <option value="Tajikistan">Tajikistan</option>
                            <option value="Tanzania">Tanzania</option>
                            <option value="Thailand">Thailand</option>
                            <option value="Timor-Leste">Timor-Leste</option>
                            <option value="Togo">Togo</option>
                            <option value="Tokelau">Tokelau</option>
                            <option value="Tongo">Tongo</option>
                            <option value="Trinidad and Tobago">Trinidad and Tobago</option>
                            <option value="Tunisia">Tunisia</option>
                            <option value="Turkey">Turkey</option>
                            <option value="Turkmenistan">Turkmenistan</option>
                            <option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
                            <option value="Tuvalu">Tuvalu</option>
                            <option value="Uganda">Uganda</option>
                            <option value="Ukraine">Ukraine</option>
                            <option value="United Arab Emirates">United Arab Emirates</option>
                            <option value="United Kingdom">United Kingdom</option>
                            <option value="United States">United States</option>
                            <option value="United States Minor Outlying">United States Minor Outlying</option>
                            <option value="Unknown">Unknown</option>
                            <option value="Upper Volta">Upper Volta</option>
                            <option value="Uruguay">Uruguay</option>
                            <option value="Uzbekistan">Uzbekistan</option>
                            <option value="Vanuatu">Vanuatu</option>
                            <option value="Venezuela">Venezuela</option>
                            <option value="Vietnam">Vietnam</option>
                            <option value="Virgin Islands, British">Virgin Islands, British</option>
                            <option value="Virgin, Islands, U.S.">Virgin, Islands, U.S.</option>
                            <option value="Wallis and Futuna">Wallis and Futuna</option>
                            <option value="West Germany">West Germany</option>
                            <option value="Western Sahara">Western Sahara</option>
                            <option value="Western Samoa">Western Samoa</option>
                            <option value="Yemen">Yemen</option>
                            <option value="Yugoslavia">Yugoslavia</option>
                            <option value="Zaire">Zaire</option>
                            <option value="Zambia">Zambia</option>
                            <option value="Zimbabwe">Zimbabwe</option>
                        </select><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>&nbsp;</li>
                    <li id="PermAddy1a_tr" class="tr_hide">
                        <label for="AddressLine1">Address Line 1:</label>
                        <input type="text" id="PermAddressLine1" name="PermAddressLine1" value="<%=usrPermAddDtls.getAddressLine1() != null ? usrPermAddDtls.getAddressLine1() : "" %>"   size="40" maxlength="40" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li id="PermAddy1b_tr" class="tr_hide">
                        <label for="AddressLine2">Address Line 2:</label>
                        <input type="text" id="PermAddressLine2" name="PermAddressLine2" value="<%=usrPermAddDtls.getAddressLine2() != null ? usrPermAddDtls.getAddressLine2() : "" %>"   size="40" maxlength="40" onfocus="select()">
                    </li>
                    <li id="PermAddy1c_tr" class="tr_hide">
                        <label for="City">City:</label>
                        <input type="text" id="PermCity" name="PermCity" value="<%=usrPermAddDtls.getCity() != null ? usrPermAddDtls.getCity(): "" %>"  size="35" maxlength="35" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li id="PermAddy1d_tr" class="tr_hide">
                        <label for="State">State:</label>
                        <input type="text" id="PermState" name="PermState" value="<%=usrPermAddDtls.getState() != null ? usrPermAddDtls.getState(): "" %>"  size="35" maxlength="35" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li id="PermAddy1e_tr" class="tr_hide">
                        <label for="PermZip">Zip Code:</label>
                        <input type="text" id="PermZip" name="PermZip" value="<%=usrPermAddDtls.getZip()!= null ? usrPermAddDtls.getZip(): "" %>"   size="10" maxlength="5" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>&nbsp;</li>
                    <li>&nbsp;</li>
                    <li>
                        Please enter your <strong>current mailing</strong> address.
                    </li>
                    <li>&nbsp;</li>
                    <li>
                        <label for="Country">Country:</label>
                        <select name="Country" id="Country" onchange="onChange_Country(this.value, & quot; MailAddy & quot; , this)" >
                            <option value="">Select</option>
                            <option value="United States">United States</option>
                            <option value="Afghanistan">Afghanistan</option>
                            <option value="Albania">Albania</option>
                            <option value="Algeria">Algeria</option>
                            <option value="American Samoa">American Samoa</option>
                            <option value="Andorra">Andorra</option>
                            <option value="Angola">Angola</option>
                            <option value="Anguilla">Anguilla</option>
                            <option value="Antarctica">Antarctica</option>
                            <option value="Antigua and Barbuda">Antigua and Barbuda</option>
                            <option value="Argentina">Argentina</option>
                            <option value="Armenia">Armenia</option>
                            <option value="Aruba">Aruba</option>
                            <option value="Australia">Australia</option>
                            <option value="Austria">Austria</option>
                            <option value="Azerbaijan">Azerbaijan</option>
                            <option value="Bahamas, The">Bahamas, The</option>
                            <option value="Bahrain">Bahrain</option>
                            <option value="Bangladesh">Bangladesh</option>
                            <option value="Barbados">Barbados</option>
                            <option value="Belarus">Belarus</option>
                            <option value="Belgium">Belgium</option>
                            <option value="Belize">Belize</option>
                            <option value="Benin">Benin</option>
                            <option value="Bermuda">Bermuda</option>
                            <option value="Bhutan">Bhutan</option>
                            <option value="Bolivia">Bolivia</option>
                            <option value="Bosnia and Herzegovina">Bosnia and Herzegovina</option>
                            <option value="Botswana">Botswana</option>
                            <option value="Bouvet Island">Bouvet Island</option>
                            <option value="Brazil">Brazil</option>
                            <option value="British Indian Ocean Territory">British Indian Ocean Territory</option>
                            <option value="Brunei">Brunei</option>
                            <option value="Bulgaria">Bulgaria</option>
                            <option value="Burkina Faso">Burkina Faso</option>
                            <option value="Burma">Burma</option>
                            <option value="Burundi">Burundi</option>
                            <option value="Cambodia">Cambodia</option>
                            <option value="Cameroon">Cameroon</option>
                            <option value="Canada">Canada</option>
                            <option value="Cape Verde">Cape Verde</option>
                            <option value="Cayman Islands">Cayman Islands</option>
                            <option value="Central African Republic">Central African Republic</option>
                            <option value="Chad">Chad</option>
                            <option value="Chile">Chile</option>
                            <option value="China">China</option>
                            <option value="China (Taiwan)">China (Taiwan)</option>
                            <option value="Christmas Island">Christmas Island</option>
                            <option value="Cocos (Keeling) Islands">Cocos (Keeling) Islands</option>
                            <option value="Colombia">Colombia</option>
                            <option value="Comoros">Comoros</option>
                            <option value="Congo">Congo</option>
                            <option value="Cook Islands">Cook Islands</option>
                            <option value="Costa Rica">Costa Rica</option>
                            <option value="Cote D' Ivoire">Cote D' Ivoire</option>
                            <option value="Croatia">Croatia</option>
                            <option value="Cuba">Cuba</option>
                            <option value="Cyprus">Cyprus</option>
                            <option value="Czech Republic">Czech Republic</option>
                            <option value="Denmark">Denmark</option>
                            <option value="Djibouti">Djibouti</option>
                            <option value="Dominica">Dominica</option>
                            <option value="Dominican Republic">Dominican Republic</option>
                            <option value="East Germany">East Germany</option>
                            <option value="Ecuador">Ecuador</option>
                            <option value="Egypt">Egypt</option>
                            <option value="El Salvador">El Salvador</option>
                            <option value="Equatorial Guinea">Equatorial Guinea</option>
                            <option value="Eritrea">Eritrea</option>
                            <option value="Estonia">Estonia</option>
                            <option value="Ethiopia">Ethiopia</option>
                            <option value="Falkland Islands (Malvinas)">Falkland Islands (Malvinas)</option>
                            <option value="Faroe Islands">Faroe Islands</option>
                            <option value="Fiji">Fiji</option>
                            <option value="Finland">Finland</option>
                            <option value="France">France</option>
                            <option value="French Guiana">French Guiana</option>
                            <option value="French Polynesia">French Polynesia</option>
                            <option value="French Southern Territories">French Southern Territories</option>
                            <option value="Gabon">Gabon</option>
                            <option value="Gambia">Gambia</option>
                            <option value="Georgia">Georgia</option>
                            <option value="Germany">Germany</option>
                            <option value="Ghana">Ghana</option>
                            <option value="Gibraltar">Gibraltar</option>
                            <option value="Greece">Greece</option>
                            <option value="Greenland">Greenland</option>
                            <option value="Grenada">Grenada</option>
                            <option value="Guadeloupe">Guadeloupe</option>
                            <option value="Guam">Guam</option>
                            <option value="Guatemala">Guatemala</option>
                            <option value="Guinea">Guinea</option>
                            <option value="Guinea-Bissau">Guinea-Bissau</option>
                            <option value="Guyana">Guyana</option>
                            <option value="Haiti">Haiti</option>
                            <option value="Heard and McDonald Islands">Heard and McDonald Islands</option>
                            <option value="Holy See (Vatican City State)">Holy See (Vatican City State)</option>
                            <option value="Honduras">Honduras</option>
                            <option value="Hong Kong">Hong Kong</option>
                            <option value="Hungary">Hungary</option>
                            <option value="Iceland">Iceland</option>
                            <option value="India">India</option>
                            <option value="Indonesia">Indonesia</option>
                            <option value="Iran">Iran</option>
                            <option value="Iraq">Iraq</option>
                            <option value="Ireland">Ireland</option>
                            <option value="Israel">Israel</option>
                            <option value="Italy">Italy</option>
                            <option value="Ivory Coast">Ivory Coast</option>
                            <option value="Jamaica">Jamaica</option>
                            <option value="Japan">Japan</option>
                            <option value="Jordan">Jordan</option>
                            <option value="Kazakhstan">Kazakhstan</option>
                            <option value="Kenya">Kenya</option>
                            <option value="Kiribati">Kiribati</option>
                            <option value="Korea, Democratic People's Rep">Korea, Democratic People's Rep</option>
                            <option value="Korea, Republic Of">Korea, Republic Of</option>
                            <option value="Kuwait">Kuwait</option>
                            <option value="Kyrgyzstan">Kyrgyzstan</option>
                            <option value="Laos">Laos</option>
                            <option value="Latvia">Latvia</option>
                            <option value="Lebanon">Lebanon</option>
                            <option value="Lesotho">Lesotho</option>
                            <option value="Liberia">Liberia</option>
                            <option value="Libya">Libya</option>
                            <option value="Libyan Arab Jamahiriya">Libyan Arab Jamahiriya</option>
                            <option value="Liechtenstein">Liechtenstein</option>
                            <option value="Lithuania">Lithuania</option>
                            <option value="Luxembourg">Luxembourg</option>
                            <option value="Macao">Macao</option>
                            <option value="Macedonia, Former Yugoslav">Macedonia, Former Yugoslav</option>
                            <option value="Madagascar">Madagascar</option>
                            <option value="Malawi">Malawi</option>
                            <option value="Malaysia">Malaysia</option>
                            <option value="Maldives">Maldives</option>
                            <option value="Mali">Mali</option>
                            <option value="Malta">Malta</option>
                            <option value="Marshall Islands">Marshall Islands</option>
                            <option value="Martinique">Martinique</option>
                            <option value="Mauritania">Mauritania</option>
                            <option value="Mauritius">Mauritius</option>
                            <option value="Mayotte">Mayotte</option>
                            <option value="Mexico">Mexico</option>
                            <option value="Micronesia, Federated States">Micronesia, Federated States</option>
                            <option value="Moldova, Republic Of">Moldova, Republic Of</option>
                            <option value="Monaco">Monaco</option>
                            <option value="Mongolia">Mongolia</option>
                            <option value="Montserrat">Montserrat</option>
                            <option value="Morocco">Morocco</option>
                            <option value="Mozambique">Mozambique</option>
                            <option value="Myanmar">Myanmar</option>
                            <option value="Namibia">Namibia</option>
                            <option value="Nauru">Nauru</option>
                            <option value="Nepal">Nepal</option>
                            <option value="Netherlands">Netherlands</option>
                            <option value="Netherlands Antilles">Netherlands Antilles</option>
                            <option value="New Caledonia">New Caledonia</option>
                            <option value="New Zealand">New Zealand</option>
                            <option value="Nicaragua">Nicaragua</option>
                            <option value="Niger">Niger</option>
                            <option value="Nigeria">Nigeria</option>
                            <option value="Niue">Niue</option>
                            <option value="Norfolk Island">Norfolk Island</option>
                            <option value="North Korea">North Korea</option>
                            <option value="North Yemen">North Yemen</option>
                            <option value="Northern Mariana Islands">Northern Mariana Islands</option>
                            <option value="Norway">Norway</option>
                            <option value="Oman">Oman</option>
                            <option value="Pakistan">Pakistan</option>
                            <option value="Palau">Palau</option>
                            <option value="Palestinian Territory Occupied">Palestinian Territory Occupied</option>
                            <option value="Panama">Panama</option>
                            <option value="Papua New Guinea">Papua New Guinea</option>
                            <option value="Paraguay">Paraguay</option>
                            <option value="Peru">Peru</option>
                            <option value="Philippines">Philippines</option>
                            <option value="Pitcairn">Pitcairn</option>
                            <option value="Poland">Poland</option>
                            <option value="Portugal">Portugal</option>
                            <option value="Puerto Rico">Puerto Rico</option>
                            <option value="Qatar">Qatar</option>
                            <option value="Reunion">Reunion</option>
                            <option value="Romania">Romania</option>
                            <option value="Russia">Russia</option>
                            <option value="Rwanda">Rwanda</option>
                            <option value="Saint Lucia">Saint Lucia</option>
                            <option value="Samoa">Samoa</option>
                            <option value="San Marino">San Marino</option>
                            <option value="Sao Tome and Principe">Sao Tome and Principe</option>
                            <option value="Saudi Arabia">Saudi Arabia</option>
                            <option value="Senegal">Senegal</option>
                            <option value="Serbia and Montenegro">Serbia and Montenegro</option>
                            <option value="Seychelles">Seychelles</option>
                            <option value="Sierra Leone">Sierra Leone</option>
                            <option value="Singapore">Singapore</option>
                            <option value="Slovakia">Slovakia</option>
                            <option value="Slovenia">Slovenia</option>
                            <option value="Solomon Islands">Solomon Islands</option>
                            <option value="Somalia">Somalia</option>
                            <option value="South Africa">South Africa</option>
                            <option value="South Georgia and Sandwich Isl">South Georgia and Sandwich Isl</option>
                            <option value="South Korea">South Korea</option>
                            <option value="South Yemen">South Yemen</option>
                            <option value="Spain">Spain</option>
                            <option value="Sri Lanka">Sri Lanka</option>
                            <option value="St. Helena">St. Helena</option>
                            <option value="St. Kitts and Nevis">St. Kitts and Nevis</option>
                            <option value="St. Pierre and Miquelon">St. Pierre and Miquelon</option>
                            <option value="St. Vincent and Grenadines">St. Vincent and Grenadines</option>
                            <option value="Sudan">Sudan</option>
                            <option value="Suriname">Suriname</option>
                            <option value="Svalbard and Jan Mayen">Svalbard and Jan Mayen</option>
                            <option value="Swaziland">Swaziland</option>
                            <option value="Sweden">Sweden</option>
                            <option value="Switzerland">Switzerland</option>
                            <option value="Syria">Syria</option>
                            <option value="Taiwan, Province of China">Taiwan, Province of China</option>
                            <option value="Tajikistan">Tajikistan</option>
                            <option value="Tanzania">Tanzania</option>
                            <option value="Thailand">Thailand</option>
                            <option value="Timor-Leste">Timor-Leste</option>
                            <option value="Togo">Togo</option>
                            <option value="Tokelau">Tokelau</option>
                            <option value="Tongo">Tongo</option>
                            <option value="Trinidad and Tobago">Trinidad and Tobago</option>
                            <option value="Tunisia">Tunisia</option>
                            <option value="Turkey">Turkey</option>
                            <option value="Turkmenistan">Turkmenistan</option>
                            <option value="Turks and Caicos Islands">Turks and Caicos Islands</option>
                            <option value="Tuvalu">Tuvalu</option>
                            <option value="Uganda">Uganda</option>
                            <option value="Ukraine">Ukraine</option>
                            <option value="United Arab Emirates">United Arab Emirates</option>
                            <option value="United Kingdom">United Kingdom</option>
                            <option value="United States">United States</option>
                            <option value="United States Minor Outlying">United States Minor Outlying</option>
                            <option value="Unknown">Unknown</option>
                            <option value="Upper Volta">Upper Volta</option>
                            <option value="Uruguay">Uruguay</option>
                            <option value="Uzbekistan">Uzbekistan</option>
                            <option value="Vanuatu">Vanuatu</option>
                            <option value="Venezuela">Venezuela</option>
                            <option value="Vietnam">Vietnam</option>
                            <option value="Virgin Islands, British">Virgin Islands, British</option>
                            <option value="Virgin, Islands, U.S.">Virgin, Islands, U.S.</option>
                            <option value="Wallis and Futuna">Wallis and Futuna</option>
                            <option value="West Germany">West Germany</option>
                            <option value="Western Sahara">Western Sahara</option>
                            <option value="Western Samoa">Western Samoa</option>
                            <option value="Yemen">Yemen</option>
                            <option value="Yugoslavia">Yugoslavia</option>
                            <option value="Zaire">Zaire</option>
                            <option value="Zambia">Zambia</option>
                            <option value="Zimbabwe">Zimbabwe</option>
                        </select><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>&nbsp;</li>
                    <li id="MailAddy1a_tr" class="tr_show">
                        <label for="AddressLine1">Address Line 1:</label>
                        <input type="text" id="AddressLine1" name="AddressLine1" value="<%=usrPostAddDtls.getAddressLine1() != null ? usrPostAddDtls.getAddressLine1() : "" %>"   size="40" maxlength="40" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li id="MailAddy1b_tr" class="tr_show">
                        <label for="AddressLine2">Address Line 2:</label>
                        <input type="text" id="AddressLine2" name="AddressLine2" value="<%=usrPostAddDtls.getAddressLine2() != null ? usrPostAddDtls.getAddressLine2() : "" %>"   size="40" maxlength="40" onfocus="select()">
                    </li>
                    <li id="MailAddy1c_tr" class="tr_show">
                        <label for="City">City:</label>
                        <input type="text" id="City" name="City" value="<%=usrPostAddDtls.getCity()!= null ? usrPostAddDtls.getCity(): "" %>"   size="35" maxlength="35" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li id="MailAddy1d_tr" class="tr_show">
                        <label for="State">State:</label>
                        <input type="text" id="State" name="State" value="<%=usrPostAddDtls.getState()!= null ? usrPostAddDtls.getState(): "" %>"   size="35" maxlength="35" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li id="MailAddy1e_tr" class="tr_show">
                        <label for="Zip">Zip Code:</label>
                        <input type="text" id="Zip" name="Zip" value="<%=usrPostAddDtls.getZip()!= null ? usrPostAddDtls.getZip(): "" %>"   size="10" maxlength="5" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>&nbsp;</li>
                    <div class="dividerline2">&nbsp;</div>
                    <li>&nbsp;</li>
                </ul>
            </div>
        </div>

        <div class="tabContent" id="education">
            <h2>Educational Informations</h2>
            <div>
                <ul class="noliststyle">
                    <li>
                        <B>UG University</B>
                    </li>
                    <li>
                        <label for="UGUniv">College/University:</label><input type="text" id="UGUniv" name="UGuniv" value="<%=ugDtls.getUniversity()!= null ? ugDtls.getUniversity(): "" %>" size="44" maxlength="75">
                    </li>
                    <li>&nbsp;</li>
                    <div class="spacer"></div>
                    <li><label for="UGGraduation">Graduation:</label><select name="UGGraduation" id="UGGraduation" >
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                        </select><span class="required">&nbsp;(required)</span></li>

                    <li>
                        <label for="UGGradMonth">Graduation Date (if applicable):</label><select id="UGGradMonth" name="UGGradMonth" >
                            <option value=""></option>
                            <option value="1">Jan</option>
                            <option value="2">Feb</option>
                            <option value="3">Mar</option>
                            <option value="4">Apr</option>
                            <option value="5">May</option>
                            <option value="6">Jun</option>
                            <option value="7">Jul</option>
                            <option value="8">Aug</option>
                            <option value="9">Sep</option>
                            <option value="10">Oct</option>
                            <option value="11">Nov</option>
                            <option value="12">Dec</option>
                        </select>&nbsp;
                        <select id="UGGradDt" name="UGGradDt" >
                            <option value="">Select</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>&nbsp;
                        <select id="UGGradYear" name="UGGradYear" >
                            <option value=""></option>
                            <option value="2020">2020</option>
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                            <option value="2008">2008</option>
                            <option value="2007">2007</option>
                            <option value="2006">2006</option>
                            <option value="2005">2005</option>
                            <option value="2004">2004</option>
                            <option value="2003">2003</option>
                            <option value="2002">2002</option>
                            <option value="2001">2001</option>
                            <option value="2000">2000</option>
                            <option value="1999">1999</option>
                            <option value="1998">1998</option>
                            <option value="1997">1997</option>
                            <option value="1996">1996</option>
                            <option value="1995">1995</option>
                            <option value="1994">1994</option>
                            <option value="1993">1993</option>
                            <option value="1992">1992</option>
                            <option value="1991">1991</option>
                            <option value="1990">1990</option>
                            <option value="1989">1989</option>
                            <option value="1988">1988</option>
                            <option value="1987">1987</option>
                            <option value="1986">1986</option>
                            <option value="1985">1985</option>
                            <option value="1984">1984</option>
                            <option value="1983">1983</option>
                            <option value="1982">1982</option>
                            <option value="1981">1981</option>
                            <option value="1980">1980</option>
                            <option value="1979">1979</option>
                            <option value="1978">1978</option>
                            <option value="1977">1977</option>
                            <option value="1976">1976</option>
                            <option value="1975">1975</option>
                            <option value="1974">1974</option>
                            <option value="1973">1973</option>
                            <option value="1972">1972</option>
                            <option value="1971">1971</option>
                            <option value="1970">1970</option>
                            <option value="1969">1969</option>
                            <option value="1968">1968</option>
                            <option value="1967">1967</option>
                            <option value="1966">1966</option>
                            <option value="1965">1965</option>
                            <option value="1964">1964</option>
                            <option value="1963">1963</option>
                            <option value="1962">1962</option>
                            <option value="1961">1961</option>
                            <option value="1960">1960</option>
                            <option value="1959">1959</option>
                            <option value="1958">1958</option>
                            <option value="1957">1957</option>
                            <option value="1956">1956</option>
                            <option value="1955">1955</option>
                        </select><span class="smalltext">&nbsp;(mm/yyyy)</span></li>			   
                    <div class="spacer"></div>
                    <li><label for="MAJOR_COLLEGE">Major:</label>
                        <input type="text" name="UGMajor" id="UGMajor" value="<%=ugDtls.getMajor()!= null ? ugDtls.getMajor(): "" %>" maxlength="50" size="44" > 
                    </li>
                    <li><label for="UGgpa">GPA</label>
                        <input type="text" name="UGgpa" value="<%=ugDtls.getGpa()%>" maxlength="50" size="44" > 
                    </li>
                    <li>&nbsp;</li>
                    <div class="dividerline2">&nbsp;</div>
                    <li>&nbsp;</li>

                    <li>
                        <B>PG University</B>
                    </li>
                    <li>
                        <label for="PGUniv">College/University:</label><input type="text" id="PGUniv" name="PGuniv" value="<%=pgDtls.getUniversity()!= null ? pgDtls.getUniversity(): "" %>" size="44" maxlength="75">
                    </li>
                    <li>&nbsp;</li>
                    <div class="spacer"></div>
                    <li><label for="PGGraduation">Graduation:</label><select name="PGGraduation" id="PGGraduation" >
                            <option value="Yes">Yes</option>
                            <option value="No">No</option>
                        </select><span class="required">&nbsp;(required)</span></li>

                    <li>
                        <label for="PGGradMonth">Graduation Date (if applicable):</label><select id="PGGradMonth" name="PGGradMonth" >
                            <option value=""></option>
                            <option value="1">Jan</option>
                            <option value="2">Feb</option>
                            <option value="3">Mar</option>
                            <option value="4">Apr</option>
                            <option value="5">May</option>
                            <option value="6">Jun</option>
                            <option value="7">Jul</option>
                            <option value="8">Aug</option>
                            <option value="9">Sep</option>
                            <option value="10">Oct</option>
                            <option value="11">Nov</option>
                            <option value="12">Dec</option>
                        </select>&nbsp;
                        <select id="PGGradDt" name="PGGradDt" >
                            <option value="">Select</option>
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                            <option value="11">11</option>
                            <option value="12">12</option>
                            <option value="13">13</option>
                            <option value="14">14</option>
                            <option value="15">15</option>
                            <option value="16">16</option>
                            <option value="17">17</option>
                            <option value="18">18</option>
                            <option value="19">19</option>
                            <option value="20">20</option>
                            <option value="21">21</option>
                            <option value="22">22</option>
                            <option value="23">23</option>
                            <option value="24">24</option>
                            <option value="25">25</option>
                            <option value="26">26</option>
                            <option value="27">27</option>
                            <option value="28">28</option>
                            <option value="29">29</option>
                            <option value="30">30</option>
                            <option value="31">31</option>
                        </select>&nbsp;
                        <select id="PGGradYear" name="PGGradYear" >
                            <option value=""></option>
                            <option value="2020">2020</option>
                            <option value="2019">2019</option>
                            <option value="2018">2018</option>
                            <option value="2017">2017</option>
                            <option value="2016">2016</option>
                            <option value="2015">2015</option>
                            <option value="2014">2014</option>
                            <option value="2013">2013</option>
                            <option value="2012">2012</option>
                            <option value="2011">2011</option>
                            <option value="2010">2010</option>
                            <option value="2009">2009</option>
                            <option value="2008">2008</option>
                            <option value="2007">2007</option>
                            <option value="2006">2006</option>
                            <option value="2005">2005</option>
                            <option value="2004">2004</option>
                            <option value="2003">2003</option>
                            <option value="2002">2002</option>
                            <option value="2001">2001</option>
                            <option value="2000">2000</option>
                            <option value="1999">1999</option>
                            <option value="1998">1998</option>
                            <option value="1997">1997</option>
                            <option value="1996">1996</option>
                            <option value="1995">1995</option>
                            <option value="1994">1994</option>
                            <option value="1993">1993</option>
                            <option value="1992">1992</option>
                            <option value="1991">1991</option>
                            <option value="1990">1990</option>
                            <option value="1989">1989</option>
                            <option value="1988">1988</option>
                            <option value="1987">1987</option>
                            <option value="1986">1986</option>
                            <option value="1985">1985</option>
                            <option value="1984">1984</option>
                            <option value="1983">1983</option>
                            <option value="1982">1982</option>
                            <option value="1981">1981</option>
                            <option value="1980">1980</option>
                            <option value="1979">1979</option>
                            <option value="1978">1978</option>
                            <option value="1977">1977</option>
                            <option value="1976">1976</option>
                            <option value="1975">1975</option>
                            <option value="1974">1974</option>
                            <option value="1973">1973</option>
                            <option value="1972">1972</option>
                            <option value="1971">1971</option>
                            <option value="1970">1970</option>
                            <option value="1969">1969</option>
                            <option value="1968">1968</option>
                            <option value="1967">1967</option>
                            <option value="1966">1966</option>
                            <option value="1965">1965</option>
                            <option value="1964">1964</option>
                            <option value="1963">1963</option>
                            <option value="1962">1962</option>
                            <option value="1961">1961</option>
                            <option value="1960">1960</option>
                            <option value="1959">1959</option>
                            <option value="1958">1958</option>
                            <option value="1957">1957</option>
                            <option value="1956">1956</option>
                            <option value="1955">1955</option>
                        </select><span class="smalltext">&nbsp;(mm/yyyy)</span></li>			   
                    <div class="spacer"></div>
                    <li><label for="MAJOR_COLLEGE">Major:</label>
                        <input type="text" name="PGMajor" id="PGMajor" value="<%=pgDtls.getMajor()!= null ? pgDtls.getMajor(): "" %>" maxlength="50" size="44" > 
                    </li>
                    <li><label for="PGgpa">GPA</label>
                        <input type="text" name="PGgpa" value="<%=pgDtls.getGpa()%>" maxlength="50" size="44" > 
                    </li>
                    <div class="spacer"></div>
                </ul>
            </div>
        </div>
        <div class="tabContent" id="test">
            <h2>Test Scores</h2>
            <div>
                <ul class="noliststyle">
                    <li>
                        <label for="gre">GRE Score:</label>
                        <input type="text" name="gre" id="gre" value="<%=usrTest.getGreScore()%>"  size="35" maxlength="40" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                    <li>
                        <label for="toefl">TOEFL Scores:</label>
                        <input type="text" id="toefl" name="toefl" value="<%=usrTest.getToeflScore()%>"  size="35" maxlength="40" onfocus="select()"><span class="required">&nbsp;(required)</span>
                    </li>
                </ul>
            </div>
        </div>

        <div class="tabContent" id="docs">
            <h2>Document Uploads</h2>
            <div>
                <%
                    if( (usrAppln.getApplicationStatus() != null))
                    {
                %> 
                  <table>
                      <tr>
                            <th>Files</th>
                            <th>Upload</th>
                            <th>Action</th>
                      </tr>
                      <tr>
                            <td>SOP</td>
                            <td><a href="javascript:myFunction('sop')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getSop() != null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('sop')">SOP</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                      <tr>
                            <td>Resume</td>
                            <td><a href="javascript:myFunction('resume')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getResume()!= null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('resume')">Resume</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                      <tr>
                            <td>UG Transscripts</td>
                            <td><a href="javascript:myFunction('ug')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getUg_proof()!= null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('ug')">UG Document</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                      <tr>
                            <td>PG Transcripts</td>
                            <td><a href="javascript:myFunction('pg')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getPg_proof()!= null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('pg')">PG Document</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                      <tr>
                            <td>Recommendation 1</td>
                            <td><a href="javascript:myFunction('reco1')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getReco1()!= null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('reco1')">Recommendation 1</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                      <tr>
                            <td>Recommendation 2</td>
                            <td><a href="javascript:myFunction('reco2')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getReco2()!= null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('reco2')">Recommendation 2</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                      <tr>
                            <td>Identity Proof</td>
                            <td><a href="javascript:myFunction('idproof')">Upload</a></td>
                            <td>
                                <%
                                    if(docs.getId_proof()!= null)
                                    {
                                %>
                                <a href="javascript:openUploadedFile('idproof')">Identity Proof</a>
                                <%
                                    }
                                %>
                            </td>
                      </tr>
                  </table>
                <%
                    }
                    else
                    {
                %>
                <p>Please save at least once to upload document proofs.</p>
                <%
                    }
                %>
                
            </div>
        </div>
                    
        <%
            if( (usrAppln.getApplicationStatus() != null && usrAppln.getApplicationStatus().equalsIgnoreCase("saved") ) || (usrAppln.getApplicationStatus() == null))
            {
        %> 
            <div>
                <input type="button" value="Save" class="myButton" onclick="return onSave(false);">
                <input type="button" value="Submit" class="myButton" onclick="return onSave(true);">
            </div>
        <%
            }
        %>                
    </form>

</div>

</div>
<script type="text/javascript">
            //<![CDATA[

            var tabLinks = new Array();
            var contentDivs = new Array();
            
            function openUploadedFile(fileType){
                var myWindow = window.open("/UMC1/FileUploads?fromBean=false&fileType=" + fileType, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=0, left=0");
            }
            
            
            function myFunction(fileType) {
                var myWindow = window.open("uploadFiles.jsp?fileType=" + fileType, "_blank", "toolbar=yes, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
            }
            
            
            function onSave(isFinalSubmit)
            {
                
                var formActionURL = "/UMC1/ApplicationDetails?mode="; 
                <%
                    if( (usrAppln.getApplicationStatus() != null && usrAppln.getApplicationStatus().equalsIgnoreCase("saved") ))
                    {
                %>
                       formActionURL = formActionURL + "update";
                <%
                    }
                    if( (usrAppln.getApplicationStatus() == null ) )
                    {
                %>     
                       formActionURL = formActionURL + "insert";
                <%
                    }
                %>
                        
                formActionURL = formActionURL + "&applnID=<%= usrAppln.getApplnId() %>&finalSubmit=" + isFinalSubmit ;
    
                document.applnform.action = formActionURL;
                document.applnform.submit();

            }
            
            function init() {
                // Grab the tab links and content divs from the page
                var tabListItems = document.getElementById('tabs').childNodes;
                for (var i = 0; i < tabListItems.length; i++) {
                if (tabListItems[i].nodeName == "LI") {
                        var tabLink = getFirstChildWithTagName(tabListItems[i], 'A');
                        var id = getHash(tabLink.getAttribute('href'));
                        tabLinks[id] = tabLink;
                        contentDivs[id] = document.getElementById(id);
                    }
                    setDropDownSelectedValues();
                }

                // Assign onclick events to the tab links, and
                // highlight the first tab
                var i = 0;
                for (var id in tabLinks) {
                    tabLinks[id].onclick = showTab;
                    tabLinks[id].onfocus = function() { this.blur() };
                    if (i == 0) tabLinks[id].className = 'selected';
                        i++;
                }

                // Hide all content divs except the first
                var i = 0;
                for (var id in contentDivs) {
                        if (i != 0) contentDivs[id].className = 'tabContent hide';
                        i++;
                    }
            }

            function setDropDownSelectedValues(){
                <%
                    String userGender = "";
                    if(usrPersonalDtls.getGender() != null)
                    {
                        userGender = usrPersonalDtls.getGender();
                    }
                    
                    String dayOfBirth = "";
                    String monthOfBirth = "";
                    String yearOfBirth = "";
                    Date dob = null;
                    
                    if(usrPersonalDtls.getDob() != null)
                    {
                        dob = usrPersonalDtls.getDob();
                        dayOfBirth = String.valueOf(dob.getDate());
                        monthOfBirth = String.valueOf(dob.getMonth() + 1);
                        yearOfBirth = String.valueOf(dob.getYear() + 1900);
                    }
                    
                    String citizenShip = "";
                    if(usrPersonalDtls.getCitizenship() != null )
                    {
                        citizenShip = usrPersonalDtls.getCitizenship();
                    }
                    
                    String selProgram = "";
                    String selTerm = "";
                    if( usrAppln.getProgramName() != null)
                    {
                        selProgram = usrAppln.getProgramId();
                    }

                    if( usrAppln.getTermName()!= null)
                    {
                        selTerm = usrAppln.getTermId();
                    }
                    
                    String permCountry = "";
                    if(usrPermAddDtls.getCountry() != null )
                    {
                        permCountry = usrPermAddDtls.getCountry();
                    }
                    
                    String postCountry = "";
                    if(usrPostAddDtls.getCountry() != null )
                    {
                        postCountry = usrPostAddDtls.getCountry();
                    }
                    
                    String gratuated="No";
                    if(ugDtls.isGraduated())
                    {
                        gratuated="Yes";
                    }
                    
                    String ugDate = "";
                    String ugMonth = "";
                    String ugYr = "";
                    Date ugGradDt = null;
                    
                    if(ugDtls.getGraduatedDate() != null)
                    {
                        ugGradDt = ugDtls.getGraduatedDate();
                        ugDate = String.valueOf(ugGradDt.getDate());
                        ugMonth = String.valueOf(ugGradDt.getMonth() + 1);
                        ugYr = String.valueOf(ugGradDt.getYear() + 1900);
                    }
                    
                    
                    String pgGratuated="No";
                    if(pgDtls.isGraduated())
                    {
                        pgGratuated="Yes";
                    }
                    
                    String pgDate = "";
                    String pgMonth = "";
                    String pgYr = "";
                    Date pgGradDt = null;
                    
                    if(pgDtls.getGraduatedDate() != null)
                    {
                        pgGradDt = pgDtls.getGraduatedDate();
                        pgDate = String.valueOf(pgGradDt.getDate());
                        pgMonth = String.valueOf(pgGradDt.getMonth() + 1);
                        pgYr = String.valueOf(pgGradDt.getYear() + 1900);
                    }
                %>
                
                document.getElementById("Gender").value = "<%=userGender%>";
                document.getElementById("DayOfBirth").value = "<%=dayOfBirth%>";
                document.getElementById("MonthOfBirth").value = "<%=monthOfBirth%>";
                document.getElementById("YearOfBirth").value = "<%=yearOfBirth%>";
                
                document.getElementById("Citizenship").value = "<%=citizenShip%>";
                
                document.getElementById("CourseProgram").value = "<%=selProgram%>";
                document.getElementById("CourseTerm").value = "<%=selTerm%>";
                
                document.getElementById("PermCountry").value = "<%=permCountry%>";
                document.getElementById("Country").value = "<%=postCountry%>";

                document.getElementById("UGGraduation").value = "<%=gratuated%>";
                document.getElementById("UGGradDt").value = "<%=ugDate%>";
                document.getElementById("UGGradMonth").value = "<%=ugMonth%>";
                document.getElementById("UGGradYear").value = "<%=ugYr%>";
                
                document.getElementById("PGGraduation").value = "<%=pgGratuated%>";
                document.getElementById("PGGradDt").value = "<%=pgDate%>";
                document.getElementById("PGGradMonth").value = "<%=pgMonth%>";
                document.getElementById("PGGradYear").value = "<%=pgYr%>";
            }


    function showTab() {
        var selectedId = getHash(this.getAttribute('href'));
        // Highlight the selected tab, and dim all others.
        // Also show the selected content div, and hide all others.
        for (var id in contentDivs) {
            if (id == selectedId) {
            tabLinks[id].className = 'selected';
                    contentDivs[id].className = 'tabContent';
            } else {
            tabLinks[id].className = '';
                    contentDivs[id].className = 'tabContent hide';
            }
        }

        // Stop the browser following the link
        return false;
    }

    function getFirstChildWithTagName(element, tagName) {
        for (var i = 0; i < element.childNodes.length; i++) {
        if (element.childNodes[i].nodeName == tagName) return element.childNodes[i];
        }
    }

    function getHash(url) {
        var hashPos = url.lastIndexOf ('#');
        return url.substring(hashPos + 1);
    }

    window.onload = init();
            //]]>
</script>
<%@ include file= "footer.jsp" %>