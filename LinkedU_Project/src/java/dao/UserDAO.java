/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.UserBean;

/**
 *
 * @author admin
 */
public interface UserDAO {
    
    public int createUser(UserBean aUser);
    public UserBean[] findAll();
    public UserBean findByName(String aUser);   
    public int updateUser(UserBean aUser); 
}
