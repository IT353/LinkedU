/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import model.AccountBean;

/**
 *
 * @author admin
 */
public interface AccountDAO {
    public int createAccount(AccountBean aAccount);
    public ArrayList findAllAccounts(); //returns all from LoginInfo table
    public ArrayList findAccount(String aEmail, String aPass);  //finds an account from LoginInfo, exact result 
    public int updateAccount(AccountBean pro);
}
