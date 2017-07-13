/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Barco;

/**
 *
 * @author JDevp
 */
@Stateless
public class BarcoFacade extends AbstractFacade<Barco> {

    @PersistenceContext(unitName = "marina_proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BarcoFacade() {
        super(Barco.class);
    }
    
}
