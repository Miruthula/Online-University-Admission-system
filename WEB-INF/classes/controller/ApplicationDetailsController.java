package controller;

import com.mysql.jdbc.StringUtils;
import helpers.ApplicationDetailsGetHelper;
import helpers.ApplicationDetailsSaveHelper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UserApplication;
import model.UserContactDetails;
import model.UserDetails;
import model.UserDocumentProofs;
import model.UserEducationalQualifications;
import model.UserPersonalDetails;
import model.UserTestScores;

@WebServlet(name = "ApplicationDetails", urlPatterns = {"/ApplicationDetails"})
public class ApplicationDetailsController extends BaseController {
    private ApplicationDetailsGetHelper applnDtlsGetHelper = new ApplicationDetailsGetHelper();
    private ApplicationDetailsSaveHelper applnSaveHelper = new ApplicationDetailsSaveHelper();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            
            String operationMode = request.getParameter("mode");
            UserDetails usrDtls = (UserDetails) request.getSession().getAttribute("UserDetails");
            if( "update".equalsIgnoreCase(operationMode) )
            {
                String applnId = request.getParameter("applnID");
                usrDtls = applnDtlsGetHelper.getApplicationDetails(applnId, usrDtls);
            } else if ( "insert".equalsIgnoreCase(operationMode) )
            {
                usrDtls.setCurrentApplication( applnDtlsGetHelper.createNewApplication(usrDtls.getUserid()));
            }
                request.getSession().setAttribute("UserApplicationDetails", usrDtls);
                pageForward("/ApplyCourse.jsp", request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            UserApplication usrApplication = null;
            UserDetails usrDtls = (UserDetails) request.getSession().getAttribute("UserDetails");
            String operationMode = request.getParameter("mode");
            
            if( "update".equalsIgnoreCase(operationMode) )
            {
                usrDtls.setCurrentApplication( getUserApplicationInputs(request) );
                applnSaveHelper.updateApplications(usrDtls);
            } else if ( "insert".equalsIgnoreCase(operationMode) )
            {
                usrApplication =  getUserApplicationInputs(request);
                usrDtls.setCurrentApplication(usrApplication);
                applnSaveHelper.insertNewApplication(usrDtls);
            }
            String applnId = usrDtls.getCurrentApplication().getApplnId();
            request.getSession().setAttribute("UserApplicationDetails", usrDtls);
            pageRedirects("/UMC1/UserApplications", request, response);
            
        } catch (Exception ex) {
            Logger.getLogger(ApplicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private UserApplication getUserApplicationInputs(HttpServletRequest request)
    {
        UserApplication usrAppln = new UserApplication();
        
        usrAppln.setTermId( request.getParameter("CourseTerm") );
        usrAppln.setProgramId(request.getParameter("CourseProgram") );
        usrAppln.setApplnId(request.getParameter("applnID"));
        usrAppln.setPersonalDtls(getUserPersonalDetailInputs(request));
        usrAppln.setUgQual(getUGDetailInputs(request));
        usrAppln.setPgQual(getPGDetailInputs(request));
        usrAppln.setPermanentAddress(getUserPermContactDetailInputs(request));
        usrAppln.setPostalAddress(getUserResContactDetailInputs(request));
        usrAppln.setTestScores(getTestScoreInputs(request));
        usrAppln.setDocProof(getDocumentProofsInputs(request));
        
        usrAppln.setFinalSubmit(Boolean.valueOf(request.getParameter("finalSubmit")));
        
        return usrAppln;
    }
    
    private UserContactDetails getUserPermContactDetailInputs(HttpServletRequest request)
    {
        UserContactDetails permContact = new UserContactDetails();
        
        permContact.setAddressLine1(request.getParameter("PermAddressLine1"));
        permContact.setAddressLine2(request.getParameter("PermAddressLine2"));
        permContact.setCity(request.getParameter("PermCity"));
        permContact.setCountry(request.getParameter("PermCountry"));
        permContact.setState(request.getParameter("PermState"));
        permContact.setZip(request.getParameter("PermZip"));
        
        return permContact;
    }
    
    private UserContactDetails getUserResContactDetailInputs(HttpServletRequest request)
    {
        UserContactDetails resContact = new UserContactDetails();
        
        resContact.setAddressLine1(request.getParameter("AddressLine1"));
        resContact.setAddressLine2(request.getParameter("AddressLine2"));
        resContact.setCity(request.getParameter("City"));
        resContact.setCountry(request.getParameter("Country"));
        resContact.setState(request.getParameter("State"));
        resContact.setZip(request.getParameter("Zip"));
        
        return resContact;
    }
    
    private UserPersonalDetails getUserPersonalDetailInputs(HttpServletRequest request)
    {
        UserPersonalDetails persDtls = new UserPersonalDetails();
        
        persDtls.setCitizenship(request.getParameter("Citizenship"));
        persDtls.setVisaStatus(request.getParameter("VisaStatus"));
        
        String month = request.getParameter("MonthOfBirth");
        String date = request.getParameter("DayOfBirth");
        String yr = request.getParameter("YearOfBirth");
        Date dob = null;
        
        if ( !StringUtils.isNullOrEmpty(month) && !StringUtils.isNullOrEmpty(date) && !StringUtils.isNullOrEmpty(yr))
        {
            dob = new Date(Integer.valueOf(yr), Integer.valueOf(month), Integer.valueOf(date));
        }
        
        persDtls.setDob(dob);
        persDtls.setEmail(request.getParameter("EmailAddress"));
        persDtls.setFirstName(request.getParameter("FirstName"));
        persDtls.setLastName(request.getParameter("LastName"));
        persDtls.setGender(request.getParameter("Gender"));
        persDtls.setPhoneNum(request.getParameter("phone"));
        
        return persDtls;
    }
    
    private UserEducationalQualifications getUGDetailInputs(HttpServletRequest request)
    {
        UserEducationalQualifications ugQual = new UserEducationalQualifications();
        
        ugQual.setGpa(Float.valueOf(request.getParameter("UGgpa")));
        ugQual.setGraduated(Boolean.valueOf(request.getParameter("UGGraduation")));
        
        String month = request.getParameter("UGGradMonth");
        String date = request.getParameter("UGGradDt");
        String yr = request.getParameter("UGGradYear");
        
        Date gradDate = null;
        
        if( !StringUtils.isNullOrEmpty(month) && !StringUtils.isNullOrEmpty(date) && !StringUtils.isNullOrEmpty(yr))
        {
            gradDate = new Date(Integer.valueOf(yr), Integer.valueOf(month), Integer.valueOf(date));
        }

        ugQual.setGraduatedDate(gradDate);
        ugQual.setMajor(request.getParameter("UGMajor"));
        ugQual.setUniversity(request.getParameter("UGuniv"));
        
        return ugQual;
    }
    
    private UserEducationalQualifications getPGDetailInputs(HttpServletRequest request)
    {
        UserEducationalQualifications pgQual = new UserEducationalQualifications();
        
        pgQual.setGpa(Float.valueOf(request.getParameter("PGgpa")));
        pgQual.setGraduated(Boolean.valueOf(request.getParameter("PGGraduation")));
        
        String month = request.getParameter("PGGradMonth");
        String date = request.getParameter("PGGradDt");
        String yr = request.getParameter("PGGradYear");
        
        Date gradDate = null;
        
        if( !StringUtils.isNullOrEmpty(month) && !StringUtils.isNullOrEmpty(date) && !StringUtils.isNullOrEmpty(yr))
        {
            gradDate = new Date(Integer.valueOf(yr), Integer.valueOf(month), Integer.valueOf(date));
        }

        pgQual.setGraduatedDate(gradDate);
        pgQual.setMajor(request.getParameter("PGMajor"));
        pgQual.setUniversity(request.getParameter("PGuniv"));
        
        return pgQual;
    }
    
    private UserTestScores getTestScoreInputs(HttpServletRequest request)
    {
        UserTestScores testScore = new UserTestScores();
        
        testScore.setGreScore(Integer.valueOf(request.getParameter("gre")));
        testScore.setToeflScore(Integer.valueOf(request.getParameter("toefl")));
        
        return testScore;
    }
    
    private UserDocumentProofs getDocumentProofsInputs(HttpServletRequest request)
    {
        UserDocumentProofs docProofs = new UserDocumentProofs();
        
        docProofs.setId_proof(null);
        docProofs.setPg_proof(null);
        docProofs.setUg_proof(null);
        docProofs.setReco1(null);
        docProofs.setReco2(null);
        docProofs.setResume(null);
        docProofs.setSop(null);
        
        return docProofs;
    }

}
