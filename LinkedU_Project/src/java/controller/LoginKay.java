/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.AccountDAO;
import dao.AccountDAOImpl;
import java.util.ArrayList;
import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import model.AccountBean;
import java.util.HashMap;

/**
 *
 * @author Kay
 */
@ManagedBean
@SessionScoped
public class LoginController {

    private AccountBean theModel;
    private String response;
    private String userEmail;
    private String password;
    private String accountType;
    private int log;
    private HashMap accountTrials = new HashMap();
    
    /**
     * Creates a new instance of LoginController
     */
    public LoginController() {
        theModel = new AccountBean();
    }

    /**
     * @return the theModel
     */
    public AccountBean getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(AccountBean theModel) {
        this.theModel = theModel;
    }
    
    public String getResponse() {
        return response;
    }
    
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String logOut() {
        setLog(0);
        this.theModel.setUserEmail(null);
        this.theModel.setPassword(null);
        this.theModel.setAccountType(null);
        return "index.xhtml";
       
    }
    
    public void logIn(AccountBean theModel) {
        setLog(1);
    }
    
    
    public String validateLogin() {
        AccountDAO aAccountDAO = new AccountDAOImpl();   
        ArrayList result = aAccountDAO.findAccount(userEmail, password); 

        if(accountTrials.containsKey(userEmail) && (Integer)accountTrials.get(userEmail) >= 3) {
            response = "There has been too many attempts to log in on this account.The account has been disabled.";
            return "index.xhtml";
        }
        else if(result.size() != 1){   
            
            if(accountTrials.containsKey(userEmail)){
                int trials = (Integer)accountTrials.get(userEmail);
                trials++;
                accountTrials.remove(userEmail);
                accountTrials.put(userEmail, trials);
                
            }
            else{
                accountTrials.put(userEmail, 1);
            }
        }
            
        if (theModel != null && result.size() == 1 ) {
            theModel = (AccountBean) result.get(0);
            
            this.logIn(theModel);
            return "index.xhtml"; 
        }
        else {
            response = "Failure to Login.  Incorrect username or password.";   
            return "index.xhtml";
            }
    }
        
    
    
    public String logStatusIn(ComponentSystemEvent event) {
        String navi = null;

        if (getLog() == 1 && theModel.getAccountType().equals("s")) {

            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("studentProfile?faces-redirect=true");
        }
        else if(getLog() == 1 && theModel.getAccountType().equals("u")) {

            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("universityProfile?faces-redirect=true");
        }
        return navi;
    }
    
    public String logStatusOut(ComponentSystemEvent event) {
        String navi = null;

        if (getLog() == 0) {
            FacesContext fc = FacesContext.getCurrentInstance();
            ConfigurableNavigationHandler nav = (ConfigurableNavigationHandler) fc.getApplication().getNavigationHandler();
            nav.performNavigation("index?faces-redirect=true");
        }
        return navi;
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
     * @return the log
     */
    public int getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(int log) {
        this.log = log;
    }

    /**
     * @return the userEmail
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * @param userEmail the userEmail to set
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * @return the accountType
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType the accountType to set
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
}
