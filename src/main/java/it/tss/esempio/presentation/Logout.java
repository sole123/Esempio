/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esempio.presentation;

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
public class Logout {
    
    @Inject
    Security security;
    
    public String onLogout(){
        
        security.logout();
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(("Logout successfully performed")));
        return "/index.xhtml?faces-redirect=true";
    }
    
    
}
