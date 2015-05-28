/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.managedBean;

import com.query.DataQuery;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author MiPc
 */
@ManagedBean(name="usuario")
@SessionScoped
public class LoginBean implements Serializable{

   private String username;
   private String password;
   private DataQuery query =new  DataQuery();
   
   public String loginControl(){
       if(query.loginControl(username, password)){
           return "admin.xhtml?faces-redirect=true";
       }
       RequestContext.getCurrentInstance().update("growl");
       FacesContext context = FacesContext.getCurrentInstance();
       context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Nombre de usuario o password incorrectos"));
       return "";
   }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
   
   
    
}
