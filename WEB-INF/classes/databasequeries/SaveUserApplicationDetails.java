package databasequeries;

import com.mysql.jdbc.StringUtils;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.UserApplication;
import model.UserContactDetails;
import model.UserDetails;
import model.UserDocumentProofs;
import model.UserEducationalQualifications;
import model.UserTestScores;

public class SaveUserApplicationDetails {

    public void insertApplication(UserDetails usrDtls, int newApplnId)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        UserApplication currentAppln = usrDtls.getCurrentApplication();
        UserEducationalQualifications ugQual = currentAppln.getUgQual();
        UserEducationalQualifications pgQual = currentAppln.getPgQual();
        UserTestScores testScores = currentAppln.getTestScores();
        UserDocumentProofs docs = currentAppln.getDocProof();
        UserContactDetails perm = currentAppln.getPermanentAddress();
        UserContactDetails postal = currentAppln.getPostalAddress();
        int applnStatus = (currentAppln.isFinalSubmit()? 1 : 4 );
        Blob blob = null;
        
        try {
            con = DBUtitlities.getConnection();

            ps = con.prepareStatement("insert into UMC_db.application(User_ID, Application_Status, Term_Id, Program_ID, Application_ID) values (?,?,?,?,?);");
            ps.setInt(1, (getIntegerValue(usrDtls.getUserid())!=-9999 ? getIntegerValue(usrDtls.getUserid()) : null));
            ps.setInt(2, applnStatus);
            ps.setInt(3, (getIntegerValue(currentAppln.getTermId())!=-9999 ? getIntegerValue(currentAppln.getTermId()) : null));
            ps.setInt(4, (getIntegerValue(currentAppln.getProgramId())!=-9999 ? getIntegerValue(currentAppln.getProgramId()) : null));
            ps.setInt(5, newApplnId);
            ps.executeUpdate();
            
            ps = con.prepareStatement("insert into UMC_db.application_educational_details(UG_University, UG_GPA, UG_Major, UG_Graduated, UG_Graduation_Date,PG_University, PG_GPA, PG_Major, PG_Graduated, PG_Graduation_Date, SOP, Resume, Recommendation_1, Recommendation_2, GRE_Score, TOEFL_Score, User_ID, Application_ID) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setString(1, ugQual.getUniversity());
            ps.setFloat(2, ugQual.getGpa());
            ps.setString(3, ugQual.getMajor());
            ps.setString(4, (ugQual.isGraduated()? "Yes":"No"));
            if(ugQual.getGraduatedDate()!=null)
                ps.setDate(5, new java.sql.Date( ugQual.getGraduatedDate().getYear(), ugQual.getGraduatedDate().getMonth(), ugQual.getGraduatedDate().getDate()));
            else
                ps.setDate(5, null);
            ps.setString(6, pgQual.getUniversity());
            ps.setFloat(7, pgQual.getGpa());
            ps.setString(8, pgQual.getMajor());
            ps.setString(9, (pgQual.isGraduated()? "Yes":"No"));
            if(pgQual.getGraduatedDate()!=null)
                ps.setDate(10, new java.sql.Date( pgQual.getGraduatedDate().getYear(), pgQual.getGraduatedDate().getMonth(), pgQual.getGraduatedDate().getDate()));
            else
                ps.setDate(10, null);
            if(docs.getSop()!= null)
                ps.setBlob(11, docs.getSop());
            else
                ps.setBlob(11, blob);
            
            if(docs.getResume()!= null)
                ps.setBlob(12, docs.getResume());
            else
                ps.setBlob(12, blob);
            
            if(docs.getReco1()!= null)
                ps.setBlob(13, docs.getReco1());
            else
                ps.setBlob(13, blob);
    
            if(docs.getReco2()!= null)
                ps.setBlob(14, docs.getReco2());
            else
                ps.setBlob(14, blob);
            
            ps.setFloat(15, testScores.getGreScore());
            ps.setFloat(16, testScores.getToeflScore());
            ps.setInt(17, (getIntegerValue(usrDtls.getUserid())!=-9999 ? getIntegerValue(usrDtls.getUserid()) : null));
            ps.setInt(18, newApplnId);
            ps.executeUpdate();
            
            ps = con.prepareStatement("insert into UMC_db.User_Contact_Details(User_ID, User_Perm_AddressLine1, User_Perm_AddressLine2, User_Perm_City, User_Perm_State, User_Perm_Country, User_Perm_PostalCode, User_Postal_AddressLine1, User_Postal_AddressLine2, User_Postal_City, User_Postal_State, User_Postal_Country, User_Postal_PostalCode, Application_ID) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            ps.setInt(1, (getIntegerValue(usrDtls.getUserid())!=-9999 ? getIntegerValue(usrDtls.getUserid()) : null));
            ps.setString(2, perm.getAddressLine1());
            ps.setString(3, perm.getAddressLine2());
            ps.setString(4, perm.getCity());
            ps.setString(5, perm.getState());
            ps.setString(6, perm.getCountry());
            ps.setInt(7, (getIntegerValue( perm.getZip())));
            ps.setString(8, postal.getAddressLine1());
            ps.setString(9, postal.getAddressLine2());
            ps.setString(10, postal.getCity());
            ps.setString(11, postal.getState());
            ps.setString(12, postal.getCountry());
            ps.setInt(13, (getIntegerValue( postal.getZip())));
            ps.setInt(14, newApplnId);
            ps.executeUpdate();
            
            ps = con.prepareStatement("insert into UMC_db.User_Documents(User_ID, User_UG_Transcripts, User_PG_Transcripts, User_ID_Proof, Application_ID) values(?, ?, ?, ?, ?);");
            ps.setInt(1, (getIntegerValue(usrDtls.getUserid())!=-9999 ? getIntegerValue(usrDtls.getUserid()) : null));
            
            if(docs.getUg_proof()!= null)
                ps.setBlob(2, docs.getUg_proof());
            else    
                ps.setBlob(2, blob);
            
            if(docs.getPg_proof()!= null)
                ps.setBlob(3, docs.getPg_proof());
            else    
                ps.setBlob(3, blob);

            if(docs.getId_proof()!= null)
                ps.setBlob(4, docs.getId_proof());
            else    
                ps.setBlob(4, blob);

            ps.setInt(5, newApplnId);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateApplication(UserDetails usrDtls)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        UserApplication currentAppln = usrDtls.getCurrentApplication();
        int applnId = Integer.valueOf(currentAppln.getApplnId());
        UserEducationalQualifications ugQual = currentAppln.getUgQual();
        UserEducationalQualifications pgQual = currentAppln.getPgQual();
        UserTestScores testScores = currentAppln.getTestScores();
        UserDocumentProofs docs = currentAppln.getDocProof();
        UserContactDetails perm = currentAppln.getPermanentAddress();
        UserContactDetails postal = currentAppln.getPostalAddress();
        int applnStatus = (currentAppln.isFinalSubmit()? 1 : 4 );
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.application set Term_ID = ?,Program_ID = ?, Application_Status = ? where Application_ID = ?;");
            ps.setString(1, currentAppln.getTermId());
            ps.setString(2, currentAppln.getProgramId());
            ps.setInt(3, applnStatus);
            ps.setInt(4, applnId);
            ps.executeUpdate();
            
            ps = con.prepareStatement("update UMC_db.application_educational_details set UG_University = ?,UG_GPA = ?,UG_Major = ?,UG_Graduated = ?,UG_Graduation_Date = ?,PG_University = ?,PG_GPA = ?,PG_Major = ?,PG_Graduated = ?,PG_Graduation_Date = ?,GRE_Score = ?,TOEFL_Score = ? where Application_ID = ?;");
            ps.setString(1, ugQual.getUniversity());
            ps.setFloat(2, ugQual.getGpa());
            ps.setString(3, ugQual.getMajor());
            ps.setString(4, (ugQual.isGraduated()? "Yes":"No"));
            if( ugQual.getGraduatedDate()!= null)
                ps.setDate(5, new java.sql.Date( ugQual.getGraduatedDate().getYear(), ugQual.getGraduatedDate().getMonth(), ugQual.getGraduatedDate().getDate()));
            else
                ps.setDate(5, null);
            
            ps.setString(6, pgQual.getUniversity());
            ps.setFloat(7, pgQual.getGpa());
            ps.setString(8, pgQual.getMajor());
            ps.setString(9, (pgQual.isGraduated()? "Yes":"No"));
            if( pgQual.getGraduatedDate()!= null)
                ps.setDate(10, new java.sql.Date( pgQual.getGraduatedDate().getYear(), pgQual.getGraduatedDate().getMonth(), pgQual.getGraduatedDate().getDate()));
            else
                ps.setDate(10, null);
            
            ps.setFloat(11, testScores.getGreScore());
            ps.setFloat(12, testScores.getToeflScore());
            ps.setInt(13, applnId);
            ps.executeUpdate();
               
            ps = con.prepareStatement("update UMC_db.User_Contact_Details set	User_Perm_AddressLine1 = ?,User_Perm_AddressLine2 = ?,User_Perm_City = ?,User_Perm_State = ?,User_Perm_Country = ?,User_Perm_PostalCode = ?,User_Postal_AddressLine1 = ?,User_Postal_AddressLine2 = ?,User_Postal_City = ?,User_Postal_State = ?,User_Postal_Country = ?,User_Postal_PostalCode = ? where Application_ID = ?;");
            ps.setString(1, perm.getAddressLine1());
            ps.setString(2, perm.getAddressLine2());
            ps.setString(3, perm.getCity());
            ps.setString(4, perm.getState());
            ps.setString(5, perm.getCountry());
            //ps.setString(6, perm.getZip());
            ps.setInt(6, getIntegerValue(perm.getZip()));
            ps.setString(7, postal.getAddressLine1());
            ps.setString(8, postal.getAddressLine2());
            ps.setString(9, postal.getCity());
            ps.setString(10, postal.getState());
            ps.setString(11, postal.getCountry());
            //ps.setString(12, postal.getZip());
            ps.setInt(12, getIntegerValue(postal.getZip()));
            ps.setInt(13, applnId);
            ps.executeUpdate();    
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
     
    private int getIntegerValue(String inputValue)
    {
        int defaultValue = -9999;
        
        if(!StringUtils.isNullOrEmpty(inputValue))
        {
            defaultValue = Integer.valueOf(inputValue);
        }
        return defaultValue;
    }
}
