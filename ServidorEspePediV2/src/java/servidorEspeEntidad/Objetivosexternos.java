/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeEntidad;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kleber
 */
@Entity
@Table(name = "objetivosexternos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetivosexternos.findAll", query = "SELECT o FROM Objetivosexternos o"),
    @NamedQuery(name = "Objetivosexternos.findByObjCodigo", query = "SELECT o FROM Objetivosexternos o WHERE o.objCodigo = :objCodigo"),
    @NamedQuery(name = "Objetivosexternos.findByObjDescripcion", query = "SELECT o FROM Objetivosexternos o WHERE o.objDescripcion = :objDescripcion"),
    @NamedQuery(name = "Objetivosexternos.findByObjFecha", query = "SELECT o FROM Objetivosexternos o WHERE o.objFecha = :objFecha"),
    @NamedQuery(name = "Objetivosexternos.findByObjNombre", query = "SELECT o FROM Objetivosexternos o WHERE o.objNombre = :objNombre"),
    @NamedQuery(name = "Objetivosexternos.findByObjTitulo", query = "SELECT o FROM Objetivosexternos o WHERE o.objTitulo = :objTitulo")})
public class Objetivosexternos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(name="OBJ_CODIGO", sequenceName = "OBJETIVOS", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "OBJ_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "obj_codigo")
    private String objCodigo;
    @Size(max = 1000)
    @Column(name = "obj_descripcion")
    private String objDescripcion;
    @Column(name = "obj_fecha")
    @Temporal(TemporalType.DATE)
    private Date objFecha;
    @Size(max = 500)
    @Column(name = "obj_nombre")
    private String objNombre;
    @Size(max = 500)
    @Column(name = "obj_titulo")
    private String objTitulo;

    public Objetivosexternos() {
    }

    public Objetivosexternos(String objCodigo) {
        this.objCodigo = objCodigo;
    }

    public String getObjCodigo() {
        return objCodigo;
    }

    public void setObjCodigo(String objCodigo) {
        this.objCodigo = objCodigo;
    }

    public String getObjDescripcion() {
        return objDescripcion;
    }

    public void setObjDescripcion(String objDescripcion) {
        this.objDescripcion = objDescripcion;
    }

    public Date getObjFecha() {
        return objFecha;
    }

    public void setObjFecha(Date objFecha) {
        this.objFecha = objFecha;
    }

    public String getObjNombre() {
        return objNombre;
    }

    public void setObjNombre(String objNombre) {
        this.objNombre = objNombre;
    }

    public String getObjTitulo() {
        return objTitulo;
    }

    public void setObjTitulo(String objTitulo) {
        this.objTitulo = objTitulo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objCodigo != null ? objCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetivosexternos)) {
            return false;
        }
        Objetivosexternos other = (Objetivosexternos) object;
        if ((this.objCodigo == null && other.objCodigo != null) || (this.objCodigo != null && !this.objCodigo.equals(other.objCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Objetivosexternos[ objCodigo=" + objCodigo + " ]";
    }
    
}
