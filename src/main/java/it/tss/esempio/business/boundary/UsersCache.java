/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esempio.business.boundary;


import it.tss.esempio.business.entity.Utente;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Singleton;
import javax.enterprise.event.Observes;
import javax.enterprise.event.TransactionPhase;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author tss
 */
@Named()
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
public class UsersCache {
    @Inject
    Utente utente;
    
    private Map<String, Utente> users = new ConcurrentHashMap<>();

    public void addUser(Utente u) {
        users.put(u.getUsername(), u);
    }

    public void removeUser(Utente u) {
        users.remove(u.getUsername());
    }

  /*  public List<Utente> loggedUsers() {
        List<Utente> result = new ArrayList<>();
        for (Utente utente : users.values()) {
            if (!utente.getPref().isOffline()) {
                result.add(utente);
            }
        }
        return result;
    }*/

    public List<Utente> loggedUsers1() {

        return new ArrayList<>(users.values());

    }

}
