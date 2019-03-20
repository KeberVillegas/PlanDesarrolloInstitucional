/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeEntidad;

import java.io.Serializable;
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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kleber
 */
@Entity
@Table(name = "tipoplan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipoplan.findAll", query = "SELECT t FROM Tipoplan t"),
    @NamedQuery(name = "Tipoplan.findByTipCodigo", query = "SELECT t FROM Tipoplan t WHERE t.tipCodigo = :tipCodigo"),
    @NamedQuery(name = "Tipoplan.findByTipTipo", query = "SELECT t FROM Tipoplan t WHERE t.tipTipo = :tipTipo")})
public class Tipoplan implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(name="TIP_CODIGO", sequenceName = "TIPO", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "TIP_CODIGO")
    
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "tip_codigo")
    private String tipCodigo;
    @Size(max = 500)
    @Column(name = "tip_tipo")
    private String tipTipo;

    public Tipoplan() {
    }

    public Tipoplan(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipCodigo() {
        return tipCodigo;
    }

    public void setTipCodigo(String tipCodigo) {
        this.tipCodigo = tipCodigo;
    }

    public String getTipTipo() {
        return tipTipo;
    }

    public void setTipTipo(String tipTipo) {
        this.tipTipo = tipTipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipCodigo != null ? tipCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipoplan)) {
            return false;
        }
        Tipoplan other = (Tipoplan) object;
        if ((this.tipCodigo == null && other.tipCodigo != null) || (this.tipCodigo != null && !this.tipCodigo.equals(other.tipCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Tipoplan[ tipCodigo=" + tipCodigo + " ]";
    }
    
}
