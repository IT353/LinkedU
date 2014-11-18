/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class UserBean {

    // These correspond to the form elements
    private String fullName;
    private String password;
    private String email;
    private String dob;
    private String address;
    private String intHob;
    private String school;
    private String gradDate;
    private String gpa;
    private String act;
    private String sat;
    private String activities;

    public UserBean(String fullName, String password, String email, String dob, String address, String intHob, String school, String gradDate, String gpa, String act, String sat, String activities) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.intHob = intHob;
        this.school = school;
        this.gradDate = gradDate;
        this.gpa = gpa;
        this.act = act;
        this.sat = sat;
        this.act = act;
        this.sat = sat;
        this.activities = activities;
    }

    public UserBean() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the firstName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the gpa
     */
    public String getGpa() {
        return gpa;
    }

    /**
     * @param gpa the gpa to set
     */
    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school the school to set
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the act
     */
    public String getAct() {
        return act;
    }

    /**
     * @param act the act to set
     */
    public void setAct(String act) {
        this.act = act;
    }

    /**
     * @return the sat
     */
    public String getSat() {
        return sat;
    }

    /**
     * @param sat the sat to set
     */
    public void setSat(String sat) {
        this.sat = sat;
    }

    /**
     * @return the dob
     */
    public String getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the intHob
     */
    public String getIntHob() {
        return intHob;
    }

    /**
     * @param intHob the intHob to set
     */
    public void setIntHob(String intHob) {
        this.intHob = intHob;
    }

    /**
     * @return the activities
     */
    public String getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(String activities) {
        this.activities = activities;
    }

    /**
     * @return the gradDate
     */
    public String getGradDate() {
        return gradDate;
    }

    /**
     * @param gradDate the gradDate to set
     */
    public void setGradDate(String gradDate) {
        this.gradDate = gradDate;
    }

    
    
}
