/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esempio.presentation;


import it.tss.esempio.presentation.util.JsfUtil;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named
@RequestScoped
public class Login {

    @Inject
    Security security;
    @Inject
    SessionData sessionData;
    
    
    private String usr;
    private String pwd;

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String onLogin() {
        //boolean login = security.login(usr, pwd);
        if (security.login(usr, pwd)) {
            sessionData.setLoggedUser(usr);
            JsfUtil.addSuccessMessage("Login effettuata con successo!");
            //FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "!", "Login effettuata con successo!"));
            return "/index.xhtml?faces-redirect=true";
        }
        FacesContext.getCurrentInstance().
                    addMessage("", new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Login errata",
                            ""));
        return null;
    }
}  
