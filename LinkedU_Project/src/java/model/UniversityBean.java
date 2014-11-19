/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author admin
 */
public class UniversityBean {

    // These correspond to the form elements
    private String unName;
    private String address;
    private String city;
    private String state;
    private String phone;
    private String type;
    private String about;
    private String stuNum;
    private String inTuition;
    private String outTuition;
    private String gpaRange;
    private String actRange;
    private String satRange;
    private String applyExtra;
    private String fullName;
    private String affiliation;
    private String email;
    private String password;


    public UniversityBean(String unName, String address, String city, String state, String phone, 
            String about, String stuNum, String inTuition, String outTuition, String gpaRange, String actRange, 
            String satRange, String applyExtra, String fullName, String affiliation, String email, String password) {
        this.unName = unName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.phone = phone;
        this.about = about;
        this.stuNum = stuNum;
        this.inTuition = inTuition;
        this.outTuition = outTuition;
        this.gpaRange = gpaRange;
        this.actRange = actRange;
        this.satRange = satRange;
        this.applyExtra = applyExtra;
        this.fullName = fullName;
        this.affiliation = affiliation;
        this.email = email;
        this.password = password;
    }

    public UniversityBean() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the unName
     */
    public String getUnName() {
        return unName;
    }

    /**
     * @param unName the unName to set
     */
    public void setUnName(String unName) {
        this.unName = unName;
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
     * @return the stuNum
     */
    public String getStuNum() {
        return stuNum;
    }

    /**
     * @param stuNum the stuNum to set
     */
    public void setStuNum(String stuNum) {
        this.stuNum = stuNum;
    }

    /**
     * @return the inTuition
     */
    public String getInTuition() {
        return inTuition;
    }

    /**
     * @param inTuition the inTuition to set
     */
    public void setInTuition(String inTuition) {
        this.inTuition = inTuition;
    }

    /**
     * @return the outTuition
     */
    public String getOutTuition() {
        return outTuition;
    }

    /**
     * @param outTuition the outTuition to set
     */
    public void setOutTuition(String outTuition) {
        this.outTuition = outTuition;
    }

    /**
     * @return the gpaRange
     */
    public String getGpaRange() {
        return gpaRange;
    }

    /**
     * @param gpaRange the gpaRange to set
     */
    public void setGpaRange(String gpaRange) {
        this.gpaRange = gpaRange;
    }

    /**
     * @return the actRange
     */
    public String getActRange() {
        return actRange;
    }

    /**
     * @param actRange the actRange to set
     */
    public void setActRange(String actRange) {
        this.actRange = actRange;
    }

    /**
     * @return the satRange
     */
    public String getSatRange() {
        return satRange;
    }

    /**
     * @param satRange the satRange to set
     */
    public void setSatRange(String satRange) {
        this.satRange = satRange;
    }

    /**
     * @return the fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName the fullName to set
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return the affiliation
     */
    public String getAffiliation() {
        return affiliation;
    }

    /**
     * @param affiliation the affiliation to set
     */
    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
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
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
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
     * @return the applyExtra
     */
    public String getApplyExtra() {
        return applyExtra;
    }

    /**
     * @param applyExtra the applyExtra to set
     */
    public void setApplyExtra(String applyExtra) {
        this.applyExtra = applyExtra;
    }



    
    
}
