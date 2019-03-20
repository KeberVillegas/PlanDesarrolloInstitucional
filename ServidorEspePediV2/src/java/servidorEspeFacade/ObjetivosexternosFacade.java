/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeFacade;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import servidorEspeEntidad.Objetivosexternos;

/**
 *
 * @author Kleber
 */
@Stateless
public class ObjetivosexternosFacade extends AbstractFacade<Objetivosexternos> {
    @PersistenceContext(unitName = "ServidorEspePediV2PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ObjetivosexternosFacade() {
        super(Objetivosexternos.class);
    }
    
}
