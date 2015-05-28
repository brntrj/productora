/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import com.entidades.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author MiPc
 */
public class DataQuery {
    
    EntityManagerFactory emf;
    EntityManager em;

    public DataQuery() {
        emf = Persistence.createEntityManagerFactory("productoraPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }
    
    public boolean loginControl(String username, String password){

        try {
            //Usuario u= em.createNamedQuery("Usuario.control", Usuario.class).setParameter("username",username).setParameter("password",password).getSingleResult();
            Usuario u = em.createNamedQuery("Usuario.control", Usuario.class).setParameter("username", username).setParameter("password", password).getSingleResult();
            if(u != null){
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
    
}
