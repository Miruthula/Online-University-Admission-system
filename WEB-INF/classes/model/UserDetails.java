package model;

import java.util.List;

public class UserDetails {
    private String userid;
    private String username;
    private String userType;
    private boolean applicationExists;
    private List<UserApplication> userApplnApplied;
    private UserApplication currentApplication;

    /**
     * @return the userid
     */
    public String getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(String userid) {
        this.userid = userid;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userType
     */
    public String getUserType() {
        return userType;
    }

    /**
     * @param userType the userType to set
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * @return the applicationExists
     */
    public boolean isApplicationExists() {
        return applicationExists;
    }

    /**
     * @param applicationExists the applicationExists to set
     */
    public void setApplicationExists(boolean applicationExists) {
        this.applicationExists = applicationExists;
    }

    /**
     * @return the userApplnApplied
     */
    public List<UserApplication> getUserApplnApplied() {
        return userApplnApplied;
    }

    /**
     * @param userApplnApplied the userApplnApplied to set
     */
    public void setUserApplnApplied(List<UserApplication> userApplnApplied) {
        this.userApplnApplied = userApplnApplied;
    }

    /**
     * @return the currentApplication
     */
    public UserApplication getCurrentApplication() {
        return currentApplication;
    }

    /**
     * @param currentApplication the currentApplication to set
     */
    public void setCurrentApplication(UserApplication currentApplication) {
        this.currentApplication = currentApplication;
    }

}
