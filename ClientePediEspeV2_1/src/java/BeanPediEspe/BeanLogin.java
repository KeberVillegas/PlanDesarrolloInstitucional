/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPediEspe;


import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kleber
 */
@ManagedBean
@SessionScoped
public class BeanLogin implements Serializable{ 
  
    private Date fecha = new Date();
    private String user = "KLEBER VILLEGAS";
    private String accion = "";
            
    static final String DATO_INSERTADO="Insertar";
    static final String DATO_MODIFICADO="Modificar";
    static final String DATO_ELIMINADO="Eliminar";

    public BeanLogin(){}
    
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }  
}
