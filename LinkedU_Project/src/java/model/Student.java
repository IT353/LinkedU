/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import javax.servlet.http.Part;

/**
 *The student class stores student information
 * @author kbandel
 */
public class Student {
    
    private String fName;
    private String lName;
    private String userID;
    private String password;
    private String univOfChoice;
    private String[] majorsOfChoice;
    private String[] activities;
    private String essay;
   // private Part essay1;
    //private Part video;
    private String city;
    private String state;
    private String stuEmail;
    private double  gpa;
    private double  sat;
    private double  act;
    private double  psat;
    
    public Student(){
        
    }

    /**
     * @return the fName
     */
    public String getfName() {
        return fName;
    }

    /**
     * @param fName the fName to set
     */
    public void setfName(String fName) {
        this.fName = fName;
    }

    /**
     * @return the lName
     */
    public String getlName() {
        return lName;
    }

    /**
     * @param lName the lName to set
     */
    public void setlName(String lName) {
        this.lName = lName;
    }

    /**
     * @return the univOfChoice
     */
    public String getUnivOfChoice() {
        return univOfChoice;
    }

    /**
     * @param univOfChoice the univOfChoice to set
     */
    public void setUnivOfChoice(String univOfChoice) {
        this.univOfChoice = univOfChoice;
    }

    /**
     * @return the majorsOfChoice
     */
    public String[] getMajorsOfChoice() {
        return majorsOfChoice;
    }

    /**
     * @param majorsOfChoice the majorsOfChoice to set
     */
    public void setMajorsOfChoice(String[] majorsOfChoice) {
        this.setMajorsOfChoice(majorsOfChoice);
    }

    /**
     * @return the activities
     */
    public String[] getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(String[] activities) {
        this.setActivities(activities);
    }

    /**
     * @return the essay
     */
    public String getEssay() {
        return essay;
    }

    /**
     * @param essay the essay to set
     */
    public void setEssay(String essay) {
        this.essay = essay;
    }

    /**
     * @return the gpa
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the sat
     */
    public double getSat() {
        return sat;
    }

    /**
     * @param sat the sat to set
     */
    public void setSat(double sat) {
        this.sat = sat;
    }

    /**
     * @return the act
     */
    public double getAct() {
        return act;
    }

    /**
     * @param act the act to set
     */
    public void setAct(double act) {
        this.act = act;
    }

    /**
     * @return the psat
     */
    public double getPsat() {
        return psat;
    }

    /**
     * @param psat the psat to set
     */
    public void setPsat(double psat) {
        this.psat = psat;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

   

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the stuEmail
     */
    public String getStuEmail() {
        return stuEmail;
    }

    /**
     * @param stuEmail the stuEmail to set
     */
    public void setStuEmail(String stuEmail) {
        this.stuEmail = stuEmail;
    }

   
    
    
}
