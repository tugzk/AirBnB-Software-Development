/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airbnb;

/**
 *
 * @author tugrul
 */
public class User {
    String name;
    
    public User(String uname){
        this.name = uname;
    }
    
    public String getUname(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
