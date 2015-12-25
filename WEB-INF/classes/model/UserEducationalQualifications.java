package model;

import java.util.Date;

public class UserEducationalQualifications {
    private String university;
    private float gpa;
    private String major;
    private boolean graduated;
    private Date graduatedDate;

    /**
     * @return the university
     */
    public String getUniversity() {
        return university;
    }

    /**
     * @param university the university to set
     */
    public void setUniversity(String university) {
        this.university = university;
    }

    /**
     * @return the gpa
     */
    public float getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major the major to set
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the graduated
     */
    public boolean isGraduated() {
        return graduated;
    }

    /**
     * @param graduated the graduated to set
     */
    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    /**
     * @return the graduatedDate
     */
    public Date getGraduatedDate() {
        return graduatedDate;
    }

    /**
     * @param graduatedDate the graduatedDate to set
     */
    public void setGraduatedDate(Date graduatedDate) {
        this.graduatedDate = graduatedDate;
    }
    
    
}
