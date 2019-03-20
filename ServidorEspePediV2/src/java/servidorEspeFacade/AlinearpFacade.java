/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import servidorEspeEntidad.Alinearp;

/**
 *
 * @author Kleber
 */
@Stateless
public class AlinearpFacade extends AbstractFacade<Alinearp> {
    @PersistenceContext(unitName = "ServidorEspePediV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AlinearpFacade() {
        super(Alinearp.class);
    }
    
}
