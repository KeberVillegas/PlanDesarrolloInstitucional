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
@Table(name = "planpedip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Planpedip.findAll", query = "SELECT p FROM Planpedip p"),
    @NamedQuery(name = "Planpedip.findByPlaCodigo", query = "SELECT p FROM Planpedip p WHERE p.plaCodigo = :plaCodigo"),
    @NamedQuery(name = "Planpedip.findByPlaTipo", query = "SELECT p FROM Planpedip p WHERE p.plaTipo = :plaTipo"),
    @NamedQuery(name = "Planpedip.findByPlaDescripcion", query = "SELECT p FROM Planpedip p WHERE p.plaDescripcion = :plaDescripcion"),
    @NamedQuery(name = "Planpedip.findByPlaMision", query = "SELECT p FROM Planpedip p WHERE p.plaMision = :plaMision"),
    @NamedQuery(name = "Planpedip.findByPlaVision", query = "SELECT p FROM Planpedip p WHERE p.plaVision = :plaVision"),
    @NamedQuery(name = "Planpedip.findByPlaFechai", query = "SELECT p FROM Planpedip p WHERE p.plaFechai = :plaFechai"),
    @NamedQuery(name = "Planpedip.findByPlaFechaf", query = "SELECT p FROM Planpedip p WHERE p.plaFechaf = :plaFechaf"),
    @NamedQuery(name = "Planpedip.findByPlaNombre", query = "SELECT p FROM Planpedip p WHERE p.plaNombre = :plaNombre")})
public class Planpedip implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
   //@GeneratedValue(strategy = GenerationType.IDENTITY)
      // @GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(name="PLA_CODIGO", sequenceName = "PLANPEDI", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "PLA_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "pla_codigo")
    private String plaCodigo;
    @Size(max = 100)
    @Column(name = "pla_tipo")
    private String plaTipo;
    @Size(max = 1000)
    @Column(name = "pla_descripcion")
    private String plaDescripcion;
    @Size(max = 1000)
    @Column(name = "pla_mision")
    private String plaMision;
    @Size(max = 1000)
    @Column(name = "pla_vision")
    private String plaVision;
    @Column(name = "pla_fechai")
    @Temporal(TemporalType.DATE)
    private Date plaFechai;
    @Column(name = "pla_fechaf")
    @Temporal(TemporalType.DATE)
    private Date plaFechaf;
    @Size(max = 500)
    @Column(name = "pla_nombre")
    private String plaNombre;

    public Planpedip() {
    }

    public Planpedip(String plaCodigo) {
        this.plaCodigo = plaCodigo;
    }

    public String getPlaCodigo() {
        return plaCodigo;
    }

    public void setPlaCodigo(String plaCodigo) {
        this.plaCodigo = plaCodigo;
    }

    public String getPlaTipo() {
        return plaTipo;
    }

    public void setPlaTipo(String plaTipo) {
        this.plaTipo = plaTipo;
    }

    public String getPlaDescripcion() {
        return plaDescripcion;
    }

    public void setPlaDescripcion(String plaDescripcion) {
        this.plaDescripcion = plaDescripcion;
    }

    public String getPlaMision() {
        return plaMision;
    }

    public void setPlaMision(String plaMision) {
        this.plaMision = plaMision;
    }

    public String getPlaVision() {
        return plaVision;
    }

    public void setPlaVision(String plaVision) {
        this.plaVision = plaVision;
    }

    public Date getPlaFechai() {
        return plaFechai;
    }

    public void setPlaFechai(Date plaFechai) {
        this.plaFechai = plaFechai;
    }

    public Date getPlaFechaf() {
        return plaFechaf;
    }

    public void setPlaFechaf(Date plaFechaf) {
        this.plaFechaf = plaFechaf;
    }

    public String getPlaNombre() {
        return plaNombre;
    }

    public void setPlaNombre(String plaNombre) {
        this.plaNombre = plaNombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (plaCodigo != null ? plaCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Planpedip)) {
            return false;
        }
        Planpedip other = (Planpedip) object;
        if ((this.plaCodigo == null && other.plaCodigo != null) || (this.plaCodigo != null && !this.plaCodigo.equals(other.plaCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Planpedip[ plaCodigo=" + plaCodigo + " ]";
    }
    
}
