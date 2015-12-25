package databasequeries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetUserApplicationStatus {
    public ResultSet getUserApplicationStatus(String userName) {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            con = DBUtitlities.getConnection();
            ps = con.prepareStatement("select A.Application_ID 'ApplicationID', TD.Term_Details 'Term', CONCAT(PD.Program_Name,\"-\",PD.Program_dept) 'Program', APS.Application_Status_Desc 'Status' from UMC_db.application A, UMC_db.User_Account UA, UMC_db.term_details TD, UMC_db.program_details PD, UMC_db.application_status APS where UA.User_UserName = ? and A.User_ID = UA.User_ID and A.Term_ID = TD.Term_ID and A.Program_ID = PD.Program_ID and A.Application_Status = APS.Application_Status_ID;");
            ps.setString(1, userName);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public ResultSet getUserApplicationEligibility(String userName){
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            con = DBUtitlities.getConnection();
            ps = con.prepareStatement("select AT.UserType_ID 'UserTypeID', AT.UserName 'UserType' from UMC_db.User_Account_type AT, .UMC_db.User_Account UA where User_UserName = ? and AT.UserType_ID = UA.User_UserType_ID;");
            ps.setString(1, userName);
            rs = ps.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(GetUserApplicationStatus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }
          
}
