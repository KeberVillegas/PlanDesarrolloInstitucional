/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPediEspe;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kleber
 */

public class ArbolFamilia implements Serializable{

    private Integer id;
    private String descripcion;
    private Collection<ArbolFamilia> arbolFamilia;
    private ArbolFamilia padre;
    
    ArbolFamilia(){}

    public ArbolFamilia(Integer id, String descripcion, ArbolFamilia padre) {
        this.id = id;
        this.descripcion = descripcion;
        this.padre = padre;
    }
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<ArbolFamilia> getArbolFamilia() {
        return arbolFamilia;
    }

    public void setArbolFamilia(Collection<ArbolFamilia> arbolFamilia) {
        this.arbolFamilia = arbolFamilia;
    }

    public ArbolFamilia getPadre() {
        return padre;
    }

    public void setPadre(ArbolFamilia padre) {
        this.padre = padre;
    }

}
