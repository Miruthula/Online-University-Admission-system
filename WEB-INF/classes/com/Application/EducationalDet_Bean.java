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
import java.io.Serializable;
import java.util.Date;
import java.sql.Blob;

public class EducationalDet_Bean  implements Serializable 
{

    public void setResume(Blob Resume) {
        this.Resume = Resume;
    }

    public EducationalDet_Bean(){};
    public EducationalDet_Bean(String UG_University, double UG_GPA, String UG_Major, String UG_Graduated, Date UG_Graduated_Date, String PG_University, double PG_GPA, String PG_Major, String PG_Graduated, Date PG_Graduated_Date, Blob SOP,Blob Resume, Blob Rec1, Blob Rec2, int GRE, int TOEFL, int User_id) {
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
        this.Resume=Resume;
        this.User_id = User_id;
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

    public Blob getSOP() {
        return SOP;
    }

    public void setSOP(Blob SOP) {
        this.SOP = SOP;
    }

    public Blob getRec1() {
        return Rec1;
    }

    public void setRec1(Blob Rec1) {
        this.Rec1 = Rec1;
    }

    public Blob getRec2() {
        return Rec2;
    }

    public void setRec2(Blob Rec2) {
        this.Rec2 = Rec2;
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
    private Blob SOP;
    private Blob Rec1;
    private Blob Rec2;
    private int GRE;
    private int TOEFL;
    private int User_id;
    private Blob Resume;
    
    
    
}
