/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wbh.usr;
 

public class utilisateur {

    private String uname;
    private String password;
    private String email;
 
    //getter 
    public String getUname() {
      
    return this.uname ;
    }

    public String getPassword() {
        return this.password ;
    }

    public String getEmail() {
        
        return this.email ;
    }

   
    //setter

    public void setUname(String uname) {
         this.uname=uname ;
    }

    public void setPassword(String password) {
    
        this.password =password ;
    }

    public void setEmail(String email) {
        
        this.email =email ;
    }
/*
    public Date getRegisteredon() {
        return this.registeredon ;
    }
    public void setRegisteredon(Date registeredon) {
        this.registeredon = registeredon;
    }
*/
}

