/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import servidorEspeEntidad.Historialcamb;

/**
 *
 * @author Kleber
 */
@Stateless
public class HistorialcambFacade extends AbstractFacade<Historialcamb> {
    @PersistenceContext(unitName = "ServidorEspePediV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HistorialcambFacade() {
        super(Historialcamb.class);
    }
    
}
