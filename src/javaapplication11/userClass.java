/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication11;

import java.util.*;
import java.sql.*;
public class userClass {
     private String userName;
    private String passWord;
  

    public userClass() {
       
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setUserName(String userName) {
       
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        
        this.passWord = passWord;
    }
    
}
