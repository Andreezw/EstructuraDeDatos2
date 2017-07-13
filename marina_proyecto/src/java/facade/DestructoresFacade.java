/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Destructores;

/**
 *
 * @author JDevp
 */
@Stateless
public class DestructoresFacade extends AbstractFacade<Destructores> {

    @PersistenceContext(unitName = "marina_proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DestructoresFacade() {
        super(Destructores.class);
    }
    
}
