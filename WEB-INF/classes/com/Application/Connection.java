/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Application;

/**
 *
 * @author Admin
 */
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class Connection
{
    
    public ArrayList<Application_Bean> getApplication(String Pgm_Name)
    {
        
        ArrayList<Application_Bean> bean1=new ArrayList<Application_Bean>();
        String query="select a.application_ID,t.term_details,u.User_FirstName,"
                + "u.User_Country_of_Citizenship,u.User_Visa_Status,p.Program_Name,"
                + "p.Program_dept from UMC_db.application a join UMC_db.User_Account u join UMC_db.term_details t "
                + "join UMC_db.program_details p "
                + "where u.User_ID=a.User_ID and a.Application_Status=1 and p.Program_Name='"+Pgm_Name+"' and "
                + "a.Term_ID=t.Term_ID and a.Program_ID=p.Program_ID; ";
        Statement statement = DBConnection.getNewStatement();
        ResultSet resultSet = null;
        int i=0;

        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) 
            {
                Application_Bean bean = new Application_Bean();
                bean.setApplication_Id(resultSet.getInt("a.application_ID"));
                bean.setTerm(resultSet.getString("t.term_details"));
                bean.setFirst_Name(resultSet.getString("u.User_FirstName"));
                bean.setCountry_Citizenship(resultSet.getString("u.User_Country_of_Citizenship"));
                bean.setVisa_Status(resultSet.getString("u.User_Visa_Status"));
                bean.setProgram(resultSet.getString("p.Program_Name"));
                bean.setPgm_Dept(resultSet.getString("p.Program_dept"));
            
                bean1.add(bean);
                
            }
            
        }
        
        catch(Exception e)
        {}
        return bean1;
    }
    
    public Application_Bean getApplicationDetails(int applicationID)
    {
       
        Personal_details b1=new Personal_details();
        EducationalDet_Bean b2=new EducationalDet_Bean();
        Application_Bean b3=new Application_Bean();
        String query="select a.Application_ID,u.User_FirstName,u.User_LastName,p.Program_dept,p.Program_Name,u.User_Country_of_Citizenship,\n" +
"u.User_Visa_Status,t.Term_Details,e.GRE_Score,e.PG_GPA,e.PG_Graduated,e.PG_Graduation_Date,\n" +
"e.PG_Major,e.PG_University,e.Recommendation_1,e.Recommendation_2,e.Resume,e.SOP,e.TOEFL_Score,\n" +
"e.UG_GPA,e.UG_Graduated,e.UG_Graduation_Date,e.UG_Major,e.UG_University, ud.User_UG_Transcripts 'ug_doc', ud.User_PG_Transcripts 'pg_doc', ud.User_ID_Proof 'id_doc', u.User_Email 'email'\n" +
"from UMC_db.application a, \n" +
"UMC_db.User_Account u, \n" +
"UMC_db.program_details p, \n" +
"UMC_db.term_details t, \n" +
"UMC_db.application_educational_details e, UMC_db.User_Documents ud \n" +
"where u.User_ID = a.user_id \n" +
"and e.User_ID = a.User_ID \n" +
"and e.Application_ID = a.Application_ID \n" +
"and ud.Application_ID = a.Application_ID \n" +
"and p.Program_ID = a.Program_ID \n" +
"and t.Term_ID = a.Term_ID \n" +
"and a.Application_ID='" + applicationID + "'";
        Statement statement = DBConnection.getNewStatement();
        ResultSet resultSet = null;
        
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) 
            {
             b3.setPgm_Dept(resultSet.getString("p.Program_dept"));
             b3.setProgram(resultSet.getString("p.Program_Name"));
             b3.setTerm(resultSet.getString("t.Term_Details"));
             b3.setFirst_Name(resultSet.getString("u.User_FirstName"));
             b3.setLast_Name(resultSet.getString("u.User_LastName"));
             b3.setCountry_Of_Citizenship(resultSet.getString("u.User_Country_of_Citizenship"));
             b3.setVisa_Status(resultSet.getString("u.User_Visa_Status"));
              b3.setEmail(resultSet.getString("email"));
             b3.setGRE(resultSet.getInt("e.GRE_Score"));
             b3.setTOEFL(resultSet.getInt("e.TOEFL_Score"));
             b3.setUG_University(resultSet.getString("e.UG_University"));
             b3.setUG_Major(resultSet.getString("e.UG_Major"));
             b3.setUG_GPA(resultSet.getDouble("e.UG_GPA"));
             b3.setUG_Graduated(resultSet.getString("e.UG_Graduated"));
             b3.setUG_Graduated_Date(resultSet.getDate("e.UG_Graduation_Date"));
             b3.setPG_University(resultSet.getString("e.PG_University"));
             b3.setPG_Major(resultSet.getString("e.PG_Major"));
             b3.setPG_GPA(resultSet.getDouble("e.PG_GPA"));
             b3.setPG_Graduated(resultSet.getString("e.PG_Graduated"));
             b3.setPG_Graduated_Date(resultSet.getDate("e.PG_Graduation_Date"));
             
             b3.setSOP(resultSet.getBlob("e.SOP").getBinaryStream());
             b3.setResume(resultSet.getBlob("e.Resume").getBinaryStream());
             b3.setRec1(resultSet.getBlob("e.Recommendation_1").getBinaryStream());
             b3.setRec2(resultSet.getBlob("e.Recommendation_2").getBinaryStream());
             b3.setUg(resultSet.getBlob("ug_doc").getBinaryStream());
             b3.setPg(resultSet.getBlob("pg_doc").getBinaryStream());
             b3.setIdProof(resultSet.getBlob("idProof").getBinaryStream());
             
            }
        }
        catch(Exception e)
        {
        }
        return b3;
        }
    
    public int Admission(int appId, boolean admitstatus)
    {
        java.sql.Connection con=DBConnection.getConnection();
        PreparedStatement ps;
        int result ;
        String query=null;
        boolean status=admitstatus;
        if(status==true)
        {
           query = "update UMC_db.application set application_status=2 where Application_ID=?";
        }
        else
        {
            query= "update UMC_db.application set application_status=3 where Application_ID=?";
        }
        
             
      try
      {
        ps=con.prepareStatement(query);
        ps.setInt(1, appId);
        result=ps.executeUpdate();
        
      }
      catch(Exception e)
      {
          return 0;
      }
         
      if (result>0)
      { return 1;
      }
      else
      {   return 0;
      }
        
            
       
    }
    
     public Personal_details getUserDetails(String username) 
      {
        Personal_details l=new Personal_details();
        String query= "SELECT User_FirstName,User_LastName,User_ID,User_Password,User_UserType_ID from UMC_db.User_Account where User_UserName='"+ username +"'";
        Statement statement = DBConnection.getNewStatement();
        ResultSet resultSet = null;
        

        try {
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
                l.setFirst_Name(resultSet.getString("User_FirstName"));
                l.setLast_Name(resultSet.getString("User_LastName"));
                l.setUser_ID(resultSet.getInt("User_ID"));
                l.setPassword(resultSet.getString("User_Password"));
                l.setUserType(resultSet.getInt("User_UserType_ID"));
               }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

       return l;

 
     }
     public int adduser(Personal_details login)
    {
       Statement statement = DBConnection.getNewStatement();
       java.sql.Connection con=DBConnection.getConnection();
        ResultSet resultSet = null;
       int i=0;
        String query="insert into UMC_db.User_Account(User_FirstName,User_LastName,User_Email,User_PhoneNumber,User_UserName,User_Password,User_SecurityQues,User_Answer,User_DOB,User_Gender,User_AddressLine1,User_AddressLine2,User_City,User_State,User_PostalCode,User_Country_of_Citizenship,User_Visa_Status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                  PreparedStatement ps;
       PreparedStatement ps1;
        // insert the new row into the table
        try {
            ps = con.prepareStatement(query);
           ps.setString(1, login.getFirst_Name());
            ps.setString(2, login.getLast_Name());
            ps.setString(3, login.getEmail());
            ps.setString(4, login.getPhone_Number());
            ps.setString(5, login.getUsername());
            ps.setString(6, login.getPassword());
            ps.setString(7, login.getSecurity_Question());
            ps.setString(8, login.getAnswer());
            ps.setString(9,login.getDOB());
            ps.setString(10, login.getGender());
            ps.setString(11, login.getAddress_Line1());
            ps.setString(12, login.getAddress_Line2()); 
            ps.setString(13,login.getCity());
            ps.setString(14,login.getState());
            ps.setString(15,login.getPostal_Code());
            ps.setString(16,login.getCountry_Of_Citizenship());
            ps.setString(17,login.getVisa_Status());
          
            ps.executeUpdate();    
            i=1;

        } 
        
         catch (SQLException se) {
            /* 
            if (((se.getErrorCode() == 30000) && ("23505".equals(se.getSQLState())))) {
                System.out.println("ERROR: Could not insert record into PRODUCT; dup primary key: " +login.getUsername() );
            } else {
                System.out.println("ERROR: Could not add row to PRODUCT table: " + login.getUsername() + " " + se.getCause());
            }*/
            
                 i=0;
        } 
        catch (Exception e) {
            i=0;
           
            //System.out.println("ERROR: Could not add row to PRODUCT table: " + login.getUsername());
            
        }
       // System.out.println("Added product to PRODUCT table: " + login.getUsername());
        return i;
      
    }
      public int CheckUser(String username) 
      {
        Personal_details l=new Personal_details();
        String query= "SELECT User_UserName from UMC_db.User_Account where User_UserName='"+ username +"'";
        Statement statement = DBConnection.getNewStatement();
        ResultSet resultSet = null;
       int i=0;

        try {
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
              i=1;
               }

        } 
        catch (SQLException e) 
        {
           return 0;
        }

    
return i;
 
     }
      public ArrayList<Application_Bean> getApplicationStatus(int userid)
    {
       
        
        ArrayList<Application_Bean> b1=new ArrayList<Application_Bean>();
        String query="select a.Application_ID,p.Program_dept,p.Program_Name,t.Term_Details,s.Application_Status_Desc\n" +
"from UMC_db.application a\n" +
"join UMC_db.program_details p on a.Program_ID=p.Program_ID\n" +
"join UMC_db.term_details t on a.Term_ID=t.Term_ID\n" +
"join UMC_db.application_status s on a.Application_Status=s.Application_Status_ID\n" +
"where a.User_ID='"+userid+"'";
        Statement statement = DBConnection.getNewStatement();
        ResultSet resultSet = null;
        
        try {
            resultSet = statement.executeQuery(query);
            while (resultSet.next()) 
            {
                Application_Bean b3= new Application_Bean();
             b3.setPgm_Dept(resultSet.getString("p.Program_dept"));
             b3.setProgram(resultSet.getString("p.Program_Name"));
             b3.setTerm(resultSet.getString("t.Term_Details"));
            b3.setApp_Status(resultSet.getString("s.Application_Status_Desc"));
            b3.setApplication_Id(resultSet.getInt("a.Application_ID"));
            b1.add(b3);
                 }
            
        }
        catch(Exception e)
        {
         
        }
        return b1;
        }

public Personal_details UserInfo(int userid) 
      {
        Personal_details l=new Personal_details();
        String query= "SELECT User_Email,User_PhoneNumber,User_AddressLine1,User_AddressLine2,User_City,User_State,User_PostalCode from UMC_db.User_Account where User_ID='"+ userid +"'";
        Statement statement = DBConnection.getNewStatement();
        ResultSet resultSet = null;
        

        try {
            resultSet = statement.executeQuery(query);
            if(resultSet.next()) {
               l.setAddress_Line1(resultSet.getString("User_AddressLine1"));
               l.setAddress_Line2(resultSet.getString("User_AddressLine2"));
               l.setCity(resultSet.getString("User_City"));
               l.setPhone_Number(resultSet.getString("User_PhoneNumber"));
               l.setPostal_Code(resultSet.getString("User_PostalCode"));
               l.setState(resultSet.getString("User_State"));
               l.setEmail(resultSet.getString("User_Email"));
               }

        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }

       return l;

 
     }

public int update(int userid,String line1,String line2,String city,String state,String pin,String email,String phone)
    {
        java.sql.Connection con=DBConnection.getConnection();
         Statement statement = DBConnection.getNewStatement();
        PreparedStatement ps;
        int result;
        ResultSet resultSet = null;
        String query=" update UMC_db.User_Account set User_Email =?,User_PhoneNumber=?,User_AddressLine1=?,User_AddressLine2=?,User_City=?,User_State=?,User_PostalCode=? where User_Id=?";
       try
      {
      ps=con.prepareStatement(query);
        ps.setString(1, email);
        ps.setString(2, phone);
        ps.setString(3, line1);
        ps.setString(4, line2);
        ps.setString(5, city);
        ps.setString(6, state);
        ps.setString(7, pin);
        ps.setInt(8, userid);
        result=ps.executeUpdate();
        
        
        
      }
      catch(Exception e)
      {
          return 0;
      }
         
      return 1;
    }


}
        
    