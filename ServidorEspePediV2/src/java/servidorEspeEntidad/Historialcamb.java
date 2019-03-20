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
@Table(name = "historialcamb")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Historialcamb.findAll", query = "SELECT h FROM Historialcamb h"),
    @NamedQuery(name = "Historialcamb.findByHistoCodigo", query = "SELECT h FROM Historialcamb h WHERE h.histoCodigo = :histoCodigo"),
    @NamedQuery(name = "Historialcamb.findByHistoUsuario", query = "SELECT h FROM Historialcamb h WHERE h.histoUsuario = :histoUsuario"),
    @NamedQuery(name = "Historialcamb.findByHistoAccion", query = "SELECT h FROM Historialcamb h WHERE h.histoAccion = :histoAccion"),
    @NamedQuery(name = "Historialcamb.findByHistoPantalla", query = "SELECT h FROM Historialcamb h WHERE h.histoPantalla = :histoPantalla"),
    @NamedQuery(name = "Historialcamb.findByHistoFecha", query = "SELECT h FROM Historialcamb h WHERE h.histoFecha = :histoFecha")})
public class Historialcamb implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(name="HISTO_CODIGO", sequenceName = "HISTORIAL", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "HISTO_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "histo_codigo")
    private String histoCodigo;
    @Size(max = 1000)
    @Column(name = "histo_usuario")
    private String histoUsuario;
    @Size(max = 1000)
    @Column(name = "histo_accion")
    private String histoAccion;
    @Size(max = 1000)
    @Column(name = "histo_pantalla")
    private String histoPantalla;
    @Column(name = "histo_fecha")
    @Temporal(TemporalType.DATE)
    private Date histoFecha;

    public Historialcamb() {
    }

    public Historialcamb(String histoCodigo) {
        this.histoCodigo = histoCodigo;
    }

    public String getHistoCodigo() {
        return histoCodigo;
    }

    public void setHistoCodigo(String histoCodigo) {
        this.histoCodigo = histoCodigo;
    }

    public String getHistoUsuario() {
        return histoUsuario;
    }

    public void setHistoUsuario(String histoUsuario) {
        this.histoUsuario = histoUsuario;
    }

    public String getHistoAccion() {
        return histoAccion;
    }

    public void setHistoAccion(String histoAccion) {
        this.histoAccion = histoAccion;
    }

    public String getHistoPantalla() {
        return histoPantalla;
    }

    public void setHistoPantalla(String histoPantalla) {
        this.histoPantalla = histoPantalla;
    }

    public Date getHistoFecha() {
        return histoFecha;
    }

    public void setHistoFecha(Date histoFecha) {
        this.histoFecha = histoFecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (histoCodigo != null ? histoCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Historialcamb)) {
            return false;
        }
        Historialcamb other = (Historialcamb) object;
        if ((this.histoCodigo == null && other.histoCodigo != null) || (this.histoCodigo != null && !this.histoCodigo.equals(other.histoCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Historialcamb[ histoCodigo=" + histoCodigo + " ]";
    }
    
}
