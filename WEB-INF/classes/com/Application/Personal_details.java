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
public class Personal_details implements Serializable
{

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public int getUserType() {
        return UserType;
    }

    public void setUserType(int UserType) {
        this.UserType = UserType;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int User_ID) {
        this.User_ID = User_ID;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String First_Name) {
        this.First_Name = First_Name;
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

  

   
    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getSecurity_Question() {
        return Security_Question;
    }

    public void setSecurity_Question(String Security_Question) {
        this.Security_Question = Security_Question;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String Answer) {
        this.Answer = Answer;
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

    public String getVisa_Status() {
        return Visa_Status;
    }

    public void setVisa_Status(String Visa_Status) {
        this.Visa_Status = Visa_Status;
    }

    public Personal_details(int User_ID, String First_Name, String Last_Name, String Email, String Phone_Number, String DOB, String Username, String Password, String Security_Question, String Answer, int UserType, String Gender, String Address_Line1, String Address_Line2, String City, String State, String Postal_Code, String Country_Of_Citizenship, String Visa_Status) {
        this.User_ID = User_ID;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Email = Email;
        this.Phone_Number = Phone_Number;
        this.DOB = DOB;
        this.Username = Username;
        this.Password = Password;
        this.Security_Question = Security_Question;
        this.Answer = Answer;
        this.UserType = UserType;
        this.Gender = Gender;
        this.Address_Line1 = Address_Line1;
        this.Address_Line2 = Address_Line2;
        this.City = City;
        this.State = State;
        this.Postal_Code = Postal_Code;
        this.Country_Of_Citizenship = Country_Of_Citizenship;
        this.Visa_Status = Visa_Status;
    }
    public Personal_details(){}
    
    private int User_ID;
    private String First_Name;
    private String Last_Name;
    private String Email;
    private String Phone_Number;
    private String DOB;
    private String Username;
    private String Password;
    private String Security_Question;
    private String Answer;
    private int UserType;
    private String Gender;
    private String Address_Line1;
    private String Address_Line2;
    private String City;
    private String State;
    private String Postal_Code;
    private String Country_Of_Citizenship;
    private String Visa_Status;
    
}
