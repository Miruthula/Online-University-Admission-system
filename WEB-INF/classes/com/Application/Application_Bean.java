/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Application;

/**
 *
 * @author Admin
 * 
 */
import java.io.InputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
public class Application_Bean implements Serializable
{

    public InputStream getSOP() {
        return SOP;
    }

    public String getApp_Status() {
        return App_Status;
    }

    public void setApp_Status(String App_Status) {
        this.App_Status = App_Status;
    }

    public void setSOP(InputStream SOP) {
        this.SOP = SOP;
    }

    public InputStream getRec1() {
        return Rec1;
    }

    public void setRec1(InputStream Rec1) {
        this.Rec1 = Rec1;
    }

    public InputStream getRec2() {
        return Rec2;
    }

    public void setRec2(InputStream Rec2) {
        this.Rec2 = Rec2;
    }

    public InputStream getResume() {
        return Resume;
    }

    public void setResume(InputStream Resume) {
        this.Resume = Resume;
    }

    public Application_Bean(int Application_Id, String Term, String Program, int Status, String Country_Citizenship, String First_Name, String Visa_Status, String Pgm_Dept, String Last_Name, String Email, String Phone_Number, Date DOB, String Gender, String Address_Line1, String Address_Line2, String City, String State, String Postal_Code, String Country_Of_Citizenship, String UG_University, double UG_GPA, String UG_Major, String UG_Graduated, Date UG_Graduated_Date, String PG_University, double PG_GPA, String PG_Major, String PG_Graduated, Date PG_Graduated_Date, InputStream SOP, InputStream  Rec1, InputStream  Rec2, int GRE, int TOEFL, int User_id, InputStream  Resume) {
        this.Application_Id = Application_Id;
        this.Term = Term;
        this.Program = Program;
        this.Status = Status;
        this.Country_Citizenship = Country_Citizenship;
        this.First_Name = First_Name;
        this.Visa_Status = Visa_Status;
        this.Pgm_Dept = Pgm_Dept;
        this.Last_Name = Last_Name;
        this.Email = Email;
        this.Phone_Number = Phone_Number;
        this.DOB = DOB;
        this.Gender = Gender;
        this.Address_Line1 = Address_Line1;
        this.Address_Line2 = Address_Line2;
        this.City = City;
        this.State = State;
        this.Postal_Code = Postal_Code;
        this.Country_Of_Citizenship = Country_Of_Citizenship;
        this.UG_University = UG_University;
        this.UG_GPA = UG_GPA;
        this.UG_Major = UG_Major;
        this.UG_Graduated = UG_Graduated;
        this.UG_Graduated_Date = UG_Graduated_Date;
        this.PG_University = PG_University;
        this.PG_GPA = PG_GPA;
        this.PG_Major = PG_Major;
        this.PG_Graduated = PG_Graduated;
        this.PG_Graduated_Date = PG_Graduated_Date;
        this.SOP = SOP;
        this.Rec1 = Rec1;
        this.Rec2 = Rec2;
        this.GRE = GRE;
        this.TOEFL = TOEFL;
        this.User_id = User_id;
        this.Resume = Resume;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String Last_Name) {
        this.Last_Name = Last_Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhone_Number() {
        return Phone_Number;
    }

    public void setPhone_Number(String Phone_Number) {
        this.Phone_Number = Phone_Number;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getAddress_Line1() {
        return Address_Line1;
    }

    public void setAddress_Line1(String Address_Line1) {
        this.Address_Line1 = Address_Line1;
    }

    public String getAddress_Line2() {
        return Address_Line2;
    }

    public void setAddress_Line2(String Address_Line2) {
        this.Address_Line2 = Address_Line2;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getState() {
        return State;
    }

    public void setState(String State) {
        this.State = State;
    }

    public String getPostal_Code() {
        return Postal_Code;
    }

    public void setPostal_Code(String Postal_Code) {
        this.Postal_Code = Postal_Code;
    }

    public String getCountry_Of_Citizenship() {
        return Country_Of_Citizenship;
    }

    public void setCountry_Of_Citizenship(String Country_Of_Citizenship) {
        this.Country_Of_Citizenship = Country_Of_Citizenship;
    }

    public String getUG_University() {
        return UG_University;
    }

    public void setUG_University(String UG_University) {
        this.UG_University = UG_University;
    }

    public double getUG_GPA() {
        return UG_GPA;
    }

    public void setUG_GPA(double UG_GPA) {
        this.UG_GPA = UG_GPA;
    }

    public String getUG_Major() {
        return UG_Major;
    }

    public void setUG_Major(String UG_Major) {
        this.UG_Major = UG_Major;
    }

    public String getUG_Graduated() {
        return UG_Graduated;
    }

    public void setUG_Graduated(String UG_Graduated) {
        this.UG_Graduated = UG_Graduated;
    }

    public Date getUG_Graduated_Date() {
        return UG_Graduated_Date;
    }

    public void setUG_Graduated_Date(Date UG_Graduated_Date) {
        this.UG_Graduated_Date = UG_Graduated_Date;
    }

    public String getPG_University() {
        return PG_University;
    }

    public void setPG_University(String PG_University) {
        this.PG_University = PG_University;
    }

    public double getPG_GPA() {
        return PG_GPA;
    }

    public void setPG_GPA(double PG_GPA) {
        this.PG_GPA = PG_GPA;
    }

    public String getPG_Major() {
        return PG_Major;
    }

    public void setPG_Major(String PG_Major) {
        this.PG_Major = PG_Major;
    }

    public String getPG_Graduated() {
        return PG_Graduated;
    }

    public void setPG_Graduated(String PG_Graduated) {
        this.PG_Graduated = PG_Graduated;
    }

    public Date getPG_Graduated_Date() {
        return PG_Graduated_Date;
    }

    public void setPG_Graduated_Date(Date PG_Graduated_Date) {
        this.PG_Graduated_Date = PG_Graduated_Date;
    }

      public int getGRE() {
        return GRE;
    }

    public void setGRE(int GRE) {
        this.GRE = GRE;
    }

    public int getTOEFL() {
        return TOEFL;
    }

    public void setTOEFL(int TOEFL) {
        this.TOEFL = TOEFL;
    }

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int User_id) {
        this.User_id = User_id;
    }

  
    public Application_Bean(){};


    public int getApplication_Id() {
        return Application_Id;
    }

    public void setApplication_Id(int Application_Id) {
        this.Application_Id = Application_Id;
    }

    public String getTerm() {
        return Term;
    }

    public void setTerm(String Term) {
        this.Term = Term;
    }

    public String getProgram() {
        return Program;
    }

    public void setProgram(String Program) {
        this.Program = Program;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getCountry_Citizenship() {
        return Country_Citizenship;
    }

    public void setCountry_Citizenship(String Country_Citizenship) {
        this.Country_Citizenship = Country_Citizenship;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
    }

    public String getVisa_Status() {
        return Visa_Status;
    }

    public void setVisa_Status(String Visa_Status) {
        this.Visa_Status = Visa_Status;
    }

    public String getPgm_Dept() {
        return Pgm_Dept;
    }

    public void setPgm_Dept(String Pgm_Dept) {
        this.Pgm_Dept = Pgm_Dept;
    }

  
    private int Application_Id  ;
    private String Term;
    private String Program;
    private int Status;
    private String App_Status;
    private String Country_Citizenship;
    private String First_Name;
    private String Visa_Status;
    private String Pgm_Dept;
    private String Last_Name;
    private String Email;
    private String Phone_Number;
    private Date DOB;
    private String Gender;
    private String Address_Line1;
    private String Address_Line2;
    private String City;
    private String State;
    private String Postal_Code;
    private String Country_Of_Citizenship;
    private String UG_University;
    private double UG_GPA;
    private String UG_Major;
    private String UG_Graduated;
    private Date UG_Graduated_Date;
    private String PG_University;
    private double PG_GPA;
    private String PG_Major;
    private String PG_Graduated;
    private Date PG_Graduated_Date;
    private InputStream SOP;
    private InputStream Rec1;
    private InputStream Rec2;
    private int GRE;
    private int TOEFL;
    private int User_id;
    private InputStream Resume;
    private InputStream ug;
    private InputStream pg;
    private InputStream idProof;

    /**
     * @return the ug
     */
    public InputStream getUg() {
        return ug;
    }

    /**
     * @param ug the ug to set
     */
    public void setUg(InputStream ug) {
        this.ug = ug;
    }

    /**
     * @return the pg
     */
    public InputStream getPg() {
        return pg;
    }

    /**
     * @param pg the pg to set
     */
    public void setPg(InputStream pg) {
        this.pg = pg;
    }

    /**
     * @return the idProof
     */
    public InputStream getIdProof() {
        return idProof;
    }

    /**
     * @param idProof the idProof to set
     */
    public void setIdProof(InputStream idProof) {
        this.idProof = idProof;
    }
    
    
}
