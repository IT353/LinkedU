/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

/**
 *
 * @author ljpetr2
 */
public class AccountBean {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String secQ;
    private String secA;
    private String interests;
    private int login;
    
    
    public AccountBean(){
    }
    
    public AccountBean(String username, String password, String firstName, String lastName, String email, String secQ, String secA, String interests, int login){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.secQ = secQ;
        this.secA = secA;
        this.interests = interests;
        this.login = login;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return the secQ
     */
    public String getSecQ() {
        return secQ;
    }

    /**
     * @param secQ the secQ to set
     */
    public void setSecQ(String secQ) {
        this.secQ = secQ;
    }

    /**
     * @return the secA
     */
    public String getSecA() {
        return secA;
    }

    /**
     * @param secA the secA to set
     */
    public void setSecA(String secA) {
        this.secA = secA;
    }

    /**
     * @return the login
     */
    public int getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(int login) {
        this.login = login;
    }

    /**
     * @return the interests
     */
    public String getInterests() {
        return interests;
    }

    /**
     * @param interests the interests to set
     */
    public void setInterests(String interests) {
        this.interests = interests;
    }
}

