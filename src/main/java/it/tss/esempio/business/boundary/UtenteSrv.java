/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esempio.business.boundary;

import it.tss.esempio.business.entity.Utente;
import java.util.Date;
import java.util.List;
import java.util.prefs.Preferences;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author tss
 */
@Named(value = "userService")
@Stateless
public class UtenteSrv {
    
    @PersistenceContext
    private EntityManager em;
    
   
    
    public Utente save(Utente u){
       // u.setLastUpdate(new Date());
        Utente saved = em.merge(u);
        return saved;
    }
    
    public void delete(Utente u){
        em.remove(u);
    }
   
    
    public Utente findByUsrPwd(String usr, String pwd){
        return em.createNamedQuery("Utente.findByUsrPwd", Utente.class)
                .setParameter("username",usr )
                .setParameter("password", pwd)
                .getSingleResult();
    }
/*
    public Utente findByNick(String nick) {
        return em.createNamedQuery("Utente.findByNick", Utente.class)
                .setParameter("usr",nick )
                .getSingleResult();
    }
    
    public Utente findById(String id){
        System.out.println("findById(),....");
        Long key = Long.parseLong(id);
        return em.find(Utente.class, key);
    }

    public List<Utente> findLikeNick(String nick) {
        List result = em.createNamedQuery("Utente.findByNick")
                .setParameter("usr", nick + "%")
                .getResultList();
        return result;
    }*/

}
