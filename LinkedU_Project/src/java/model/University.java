/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *This class holds information about universities
 * @author kbandel
 */
public class University {
    
    private String uName;
    private String city;
    private String state;
    private String type;
    private String univEmail;
    private String userID;
    private String password;
    private boolean isIvyLeague;
    private boolean isPaidMember;
    
    
    
    /**
     * default constructor
     */
    
    public University(){
        
    }
    
    
    
    /**
     * @return the uName
     */
    public String getuName() {
        return uName;
    }

    /**
     * @param uName the uName to set
     */
    public void setuName(String uName) {
        this.uName = uName;
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
     * @return the isIvyLeague
     */
    public boolean isIsIvyLeague() {
        return isIvyLeague;
    }

    /**
     * @param isIvyLeague the isIvyLeague to set
     */
    public void setIsIvyLeague(boolean isIvyLeague) {
        this.isIvyLeague = isIvyLeague;
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
     * @return the isPaidMember
     */
    public boolean isIsPaidMember() {
        return isPaidMember;
    }

    /**
     * @param isPaidMember the isPaidMember to set
     */
    public void setIsPaidMember(boolean isPaidMember) {
        this.isPaidMember = isPaidMember;
    }

    /**
     * @return the univEmail
     */
    public String getUnivEmail() {
        return univEmail;
    }

    /**
     * @param univEmail the univEmail to set
     */
    public void setUnivEmail(String univEmail) {
        this.univEmail = univEmail;
    }
    
    
    
}
