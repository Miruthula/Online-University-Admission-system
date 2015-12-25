package databasequeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetUserApplicationDetails {

    public ResultSet getUserApplicationDetails(String applnID) {
            Connection con = null;
            ResultSet rs = null;
            PreparedStatement ps;
            try {
                con = DBUtitlities.getConnection();
                ps = con.prepareStatement("select A.Application_ID 'ApplicationID', TD.Term_ID 'TermId', TD.Term_Details 'Term', PD.Program_ID 'PGMID', CONCAT(PD.Program_dept, \"-\", PD.Program_Name) 'Program', APS.Application_Status_ID 'Status_ID', APS.Application_Status_Desc 'Status', UA.User_FirstName 'Fname', UA.User_LastName 'Lname', UA.User_Email 'email', UA.User_PhoneNumber 'phone', UA.User_DOB 'dob', UA.User_Gender 'Gender', UA.User_Country_of_Citizenship 'Citizenship', UA.User_Visa_Status 'Visa' from UMC_db.application A, UMC_db.User_Account UA, UMC_db.term_details TD, UMC_db.program_details PD, UMC_db.application_status APS  where A.Application_ID = ? and A.User_ID = UA.User_ID and A.Term_ID = TD.Term_ID and A.Program_ID = PD.Program_ID and A.Application_Status = APS.Application_Status_ID;");
                ps.setString(1, applnID);
                rs = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rs;
    }
    
    public ResultSet getUserApplicationDocumentDetails(String applnID) {
            Connection con = null;
            ResultSet rs = null;
            PreparedStatement ps;
            try {
                con = DBUtitlities.getConnection();
                ps = con.prepareStatement("select UCD.User_Perm_AddressLine1 'PermAdress1', UCD.User_Perm_AddressLine2 'PermAdress2', UCD.User_Perm_City 'PermCity', UCD.User_Perm_State 'PermState', UCD.User_Perm_PostalCode 'PermPostal', UCD.User_Perm_Country 'PermCountry', UCD.User_Postal_AddressLine1 'PostAdress1', UCD.User_Postal_AddressLine2 'PostAdress2', UCD.User_Postal_City 'PostCity', UCD.User_Postal_State 'PostState', UCD.User_Postal_Country 'PostCountry', UCD.User_Postal_PostalCode 'PostPostal', AED.UG_University 'UGuniv', AED.UG_GPA 'UGgpa', AED.UG_Major 'UGMajor', AED.UG_Graduated 'UGGrad', AED.UG_Graduation_Date 'UGGradDate', AED.PG_University 'PGuniv', AED.PG_GPA 'PGgpa', AED.PG_Major 'PGMajor', AED.PG_Graduated 'PGGrad', AED.PG_Graduation_Date 'PGGradDate', AED.GRE_Score 'gre', AED.TOEFL_Score 'toefl', AED.sop 'sop', AED.Resume 'resume', AED.Recommendation_1 'reco1', AED.Recommendation_2 'reco2', USD.User_UG_Transcripts 'UGtrans', USD.User_PG_Transcripts 'PGtrans', USD.User_ID_Proof 'idproof' from UMC_db.User_Contact_Details UCD, UMC_db.User_Documents USD, UMC_db.Application_Educational_Details AED where UCD.Application_ID = ? and UCD.User_ID = USD.User_ID and UCD.User_ID = AED.User_id and UCD.Application_ID = USD.Application_ID and UCD.Application_ID = AED.Application_ID;");
                ps.setString(1, applnID);
                rs = ps.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
            }
            return rs;
    } 
    
    public int getMaxApplicationId()
    {
        Connection con = null;
        ResultSet rs = null;
        int newMaxId = -9999;
        PreparedStatement ps;
        try {
            con = DBUtitlities.getConnection();
            ps = con.prepareStatement("select max(application_id) + 1 'NewId' from UMC_db.application;");
            rs = ps.executeQuery();
            while (rs.next()) {
                newMaxId = Integer.valueOf(rs.getString("NewId"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return newMaxId;
        
    }
    
    public ResultSet getUserPersonalDetails(String userId)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            con = DBUtitlities.getConnection();
            ps = con.prepareStatement("select UA.User_FirstName 'Fname', UA.User_LastName 'Lname', UA.User_Email 'email', UA.User_PhoneNumber 'phone', UA.User_DOB 'dob', UA.User_Gender 'Gender', UA.User_Country_of_Citizenship 'Citizenship', UA.User_Visa_Status 'Visa' from UMC_db.User_Account UA where UA.User_ID = ?;");
            ps.setString(1, userId);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
}
