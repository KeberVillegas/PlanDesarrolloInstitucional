/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import servidorEspeEntidad.Tipoplan;

/**
 *
 * @author Kleber
 */
@Stateless
public class TipoplanFacade extends AbstractFacade<Tipoplan> {
    @PersistenceContext(unitName = "ServidorEspePediV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoplanFacade() {
        super(Tipoplan.class);
    }
    
}
