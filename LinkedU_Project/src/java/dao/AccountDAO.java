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
    public ArrayList findAll();
    public ArrayList findAccount(String aName, String aPass);
    public ArrayList findByName(String aName); // either get one back or several if multiple same name allowed  
    public int updateAccount(AccountBean pro);  
    public int login(AccountBean pro);
    public int logout(AccountBean pro);
}
