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
    private String fName;
    private String lName;
    private String password;
    private String email;
    private String dob;
    private String city;
    private String state;
    private String about;
    private String intHob;
    private String uniChoices;
    private String majChoices;
    private String highSchool;
    private String gradDate;
    private String gpa;
    private String act;
    private String sat;
    private String activities;

    public UserBean(String fName, String lName, String password, String email, String dob, String city, 
            String state, String about, String intHob, String uniChoices, String majChoices, 
            String highSchool, String gradDate, String gpa, String act, String sat, String activities) {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.email = email;
        this.dob = dob;
        this.city = city;
        this.state = state;
        this.about = about;
        this.intHob = intHob;
        this.uniChoices = uniChoices;
        this.majChoices = majChoices;
        this.highSchool = highSchool;
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
     * @return the highSchool
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
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
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setAddress(String city) {
        this.city = city;
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
     * @return the about
     */
    public String getAbout() {
        return about;
    }

    /**
     * @param about the about to set
     */
    public void setAbout(String about) {
        this.about = about;
    }

    /**
     * @return the uniChoices
     */
    public String getUniChoices() {
        return uniChoices;
    }

    /**
     * @param uniChoices the uniChoices to set
     */
    public void setUniChoices(String uniChoices) {
        this.uniChoices = uniChoices;
    }

    /**
     * @return the majChoices
     */
    public String getMajChoices() {
        return majChoices;
    }

    /**
     * @param majChoices the majChoices to set
     */
    public void setMajChoices(String majChoices) {
        this.majChoices = majChoices;
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

    
    
}
