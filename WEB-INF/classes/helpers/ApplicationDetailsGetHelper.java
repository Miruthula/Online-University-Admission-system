package helpers;

import databasequeries.GetUserApplicationDetails;
import databasequeries.GetUserApplicationStatus;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.UserApplication;
import model.UserContactDetails;
import model.UserDetails;
import model.UserDocumentProofs;
import model.UserEducationalQualifications;
import model.UserPersonalDetails;
import model.UserTestScores;

public class ApplicationDetailsGetHelper {

    private GetUserApplicationStatus getUserApplnStatus = new GetUserApplicationStatus();
    private GetUserApplicationDetails getUserApplnDetails = new GetUserApplicationDetails();
    

    public UserDetails getApplications(String userName) throws SQLException {
        UserDetails usrDtls = new UserDetails();
        ResultSet rs = getUserApplnStatus.getUserApplicationEligibility(userName);
        usrDtls = mapUserType(rs, usrDtls);
        
        if( "Applicant".equalsIgnoreCase(usrDtls.getUserType()) )
        {
            usrDtls = getApplicationStatus(userName, usrDtls);
        }
        
        return usrDtls;
    }

    public UserDetails getApplicationStatus(String userName, UserDetails usrDtls) throws SQLException {
        ResultSet rs = getUserApplnStatus.getUserApplicationStatus(userName);
        usrDtls.setUserApplnApplied( mapUserApplnStatus(rs) );
        
        if(usrDtls.getUserApplnApplied().size() > 0)
        {
            usrDtls.setApplicationExists(true);
        }

        return usrDtls;
    }
    
    public UserDetails getApplicationDetails(String applicationID, UserDetails usrDtls) throws SQLException
    {
        ResultSet rs = getUserApplnDetails.getUserApplicationDetails(applicationID);
        usrDtls.setCurrentApplication(mapUserApplnDetails(rs));
        
        rs = getUserApplnDetails.getUserApplicationDocumentDetails(applicationID);
        
        usrDtls.setCurrentApplication(mapUserApplnDocDetails(rs, usrDtls.getCurrentApplication()));
        
        return usrDtls;
    }
    
    public UserApplication createNewApplication(String userId) throws SQLException
    {
        UserApplication usrAppln = new UserApplication();
        ResultSet rs = getUserApplnDetails.getUserPersonalDetails(userId);
        
        usrAppln.setUgQual(new UserEducationalQualifications());
        usrAppln.setPgQual(new UserEducationalQualifications());
        usrAppln.setPermanentAddress(new UserContactDetails());
        usrAppln.setPostalAddress(new UserContactDetails());
        usrAppln.setTestScores(new UserTestScores());
        usrAppln.setDocProof(new UserDocumentProofs());
        usrAppln.setPersonalDtls(mapUserApplnPersonalDetails(rs));
        
        return usrAppln;
    }

    private UserPersonalDetails mapUserApplnPersonalDetails(ResultSet rs) throws SQLException {
        UserPersonalDetails usrPersonalDtls = new UserPersonalDetails();
        while (rs.next()) {
            usrPersonalDtls.setFirstName(rs.getString("Fname"));
            usrPersonalDtls.setLastName(rs.getString("Lname"));
            usrPersonalDtls.setEmail(rs.getString("email"));
            usrPersonalDtls.setPhoneNum(rs.getString("phone"));
            usrPersonalDtls.setDob(rs.getDate("dob"));
            usrPersonalDtls.setGender(rs.getString("Gender"));
            usrPersonalDtls.setCitizenship(rs.getString("Citizenship"));
            usrPersonalDtls.setVisaStatus(rs.getString("Visa"));
        }
        
        return usrPersonalDtls;
    }
    
    
    private UserDetails mapUserType(ResultSet rs, UserDetails usrDtls) throws SQLException {
        if(rs != null )
        {
            while (rs.next()) {
                usrDtls.setUserType(rs.getString("UserType"));
            }
        }
        return usrDtls;
    }
    
    private List<UserApplication> mapUserApplnStatus(ResultSet rs) throws SQLException {
        UserApplication usrAppln = null;
        List<UserApplication> usrApplnList = new ArrayList<UserApplication>();
        while (rs.next()) {
            usrAppln = new UserApplication();
            usrAppln.setApplnId(rs.getString("ApplicationID"));
            usrAppln.setTermName(rs.getString("Term"));
            usrAppln.setProgramName(rs.getString("Program"));
            usrAppln.setApplicationStatus(rs.getString("Status"));
            
            usrApplnList.add(usrAppln);
        }
        
        return usrApplnList;
    }
    
    private UserApplication mapUserApplnDetails(ResultSet rs) throws SQLException {
        UserApplication usrAppln = new UserApplication();
        while (rs.next()) {
            usrAppln.setApplnId(rs.getString("ApplicationID"));
            usrAppln.setTermId(rs.getString("TermId"));
            usrAppln.setTermName(rs.getString("Term"));
            usrAppln.setProgramId(rs.getString("PGMID"));
            usrAppln.setProgramName(rs.getString("Program"));
            usrAppln.setApplicationStatus(rs.getString("Status"));
            
            UserPersonalDetails usrPersonalDtls = new UserPersonalDetails();
            usrPersonalDtls.setFirstName(rs.getString("Fname"));
            usrPersonalDtls.setLastName(rs.getString("Lname"));
            usrPersonalDtls.setEmail(rs.getString("email"));
            usrPersonalDtls.setPhoneNum(rs.getString("phone"));
            usrPersonalDtls.setDob(rs.getDate("dob"));
            usrPersonalDtls.setGender(rs.getString("Gender"));
            usrPersonalDtls.setCitizenship(rs.getString("Citizenship"));
            usrPersonalDtls.setVisaStatus(rs.getString("Visa"));
            
            usrAppln.setPersonalDtls(usrPersonalDtls);
        }
        
        return usrAppln;
    }
    
    private UserApplication mapUserApplnDocDetails(ResultSet rs, UserApplication usrAppln) throws SQLException {
        while (rs.next()) {
            //for permanent address
            UserContactDetails usrContDtls = new UserContactDetails();
            usrContDtls.setAddressLine1(rs.getString("PermAdress1"));
            usrContDtls.setAddressLine2(rs.getString("PermAdress2"));
            usrContDtls.setCity(rs.getString("PermCity"));
            usrContDtls.setState(rs.getString("PermState"));
            usrContDtls.setCountry(rs.getString("PermCountry"));
            String strZip = rs.getString("PermPostal");
            if(strZip != null && !"-9999".equalsIgnoreCase(strZip) )
                usrContDtls.setZip(strZip);
            else 
                usrContDtls.setZip("");
            
            usrAppln.setPermanentAddress(usrContDtls);
            
            //for residence address
            usrContDtls = new UserContactDetails();
            usrContDtls.setAddressLine1(rs.getString("PostAdress1"));
            usrContDtls.setAddressLine2(rs.getString("PostAdress2"));
            usrContDtls.setCity(rs.getString("PostCity"));
            usrContDtls.setState(rs.getString("PostState"));
            usrContDtls.setCountry(rs.getString("PostCountry"));
            
            strZip = rs.getString("PostPostal");
            if(strZip != null && !"-9999".equalsIgnoreCase(strZip) )
                usrContDtls.setZip(strZip);
            else 
                usrContDtls.setZip("");
            
            usrAppln.setPostalAddress(usrContDtls);
            
            UserEducationalQualifications ugQual = new UserEducationalQualifications();
            ugQual.setGpa(rs.getFloat("UGgpa"));
            ugQual.setGraduated(convertStringYNTOBoolean(rs.getString("UGGrad")));
            ugQual.setGraduatedDate(rs.getDate("UGGradDate"));
            ugQual.setMajor(rs.getString("UGMajor"));
            ugQual.setUniversity(rs.getString("UGuniv"));
            
            usrAppln.setUgQual(ugQual);
            
            UserEducationalQualifications pgQual = new UserEducationalQualifications();
            pgQual.setGpa(rs.getFloat("PGgpa"));
            pgQual.setGraduated(convertStringYNTOBoolean(rs.getString("PGGrad")));
            pgQual.setGraduatedDate(rs.getDate("PGGradDate"));
            pgQual.setMajor(rs.getString("PGMajor"));
            pgQual.setUniversity(rs.getString("PGuniv"));
            
            usrAppln.setPgQual(pgQual);
            
            UserTestScores usrTest = new UserTestScores();
            usrTest.setGreScore(rs.getInt("gre"));
            usrTest.setToeflScore(rs.getInt("toefl"));
            usrAppln.setTestScores(usrTest);
            
            InputStream isTemp = null;
            UserDocumentProofs usrDocs = new UserDocumentProofs();
            if(rs.getBlob("idproof")!=null)
                usrDocs.setId_proof(rs.getBlob("idproof").getBinaryStream());
            else 
                usrDocs.setId_proof(isTemp);
            
            if(rs.getBlob("PGtrans")!=null)
                usrDocs.setPg_proof(rs.getBlob("PGtrans").getBinaryStream());
            else
                usrDocs.setPg_proof(null);
            
            if(rs.getBlob("reco1")!=null)
                usrDocs.setReco1(rs.getBlob("reco1").getBinaryStream());
            else
                usrDocs.setReco1(null);
            
            if(rs.getBlob("reco2")!=null)
                usrDocs.setReco2(rs.getBlob("reco2").getBinaryStream());
            else
                usrDocs.setReco2(null);
            
            if(rs.getBlob("resume")!=null)
                usrDocs.setResume(rs.getBlob("resume").getBinaryStream());
            else
                usrDocs.setResume(null);
            
            if(rs.getBlob("sop")!=null)
                usrDocs.setSop(rs.getBlob("sop").getBinaryStream());
            else
                usrDocs.setSop(null);
            
            if(rs.getBlob("UGtrans")!=null)
                usrDocs.setUg_proof(rs.getBlob("UGtrans").getBinaryStream());
            else
                usrDocs.setUg_proof(null);
            
            usrAppln.setDocProof(usrDocs);
        }
        
        return usrAppln;
    }
    
    private boolean convertStringYNTOBoolean(String inputVal)
    {
        boolean result = false;
        
        if("yes".equalsIgnoreCase(inputVal) || "y".equalsIgnoreCase(inputVal))
        {
            result = true;
        }
        
        return result;
    }
    
    private String convertBlobToString(Blob inputBlob)
    {
        String outputString = null;
        
        if(null != inputBlob)
        {
            outputString = inputBlob.toString();
        }
        
        return outputString;
    }
}
