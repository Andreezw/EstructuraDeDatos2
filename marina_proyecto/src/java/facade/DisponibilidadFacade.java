/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import models.Disponibilidad;

/**
 *
 * @author JDevp
 */
@Stateless
public class DisponibilidadFacade extends AbstractFacade<Disponibilidad> {

    @PersistenceContext(unitName = "marina_proyectoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DisponibilidadFacade() {
        super(Disponibilidad.class);
    }
    
}
