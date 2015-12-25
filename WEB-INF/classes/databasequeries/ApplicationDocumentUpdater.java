package databasequeries;

import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationDocumentUpdater {

    public void updateSOPDocument(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.application_educational_details set sop = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateResumeDocument(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.application_educational_details set resume = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateReco1Document(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.application_educational_details set Recommendation_1 = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateReco2Document(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.application_educational_details set Recommendation_2 = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateUGDocument(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.User_Documents set User_UG_Transcripts = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updatePGDocument(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.User_Documents set User_PG_Transcripts = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void updateIDDocument(int applnId, InputStream fileInput)
    {
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ps;
        Blob blob = null;

        try {
            con = DBUtitlities.getConnection();
            
            ps = con.prepareStatement("update UMC_db.User_Documents set User_ID_Proof = ? where Application_ID = ?;");
            if(fileInput!= null)
                ps.setBlob(1, fileInput);
            else
                ps.setBlob(1, blob);
            ps.setInt(2, applnId);
            ps.executeUpdate();
            
            } catch (Exception ex) {
            Logger.getLogger(SaveUserApplicationDetails.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
