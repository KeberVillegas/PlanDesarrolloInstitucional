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
@Table(name = "indicadoresp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Indicadoresp.findAll", query = "SELECT i FROM Indicadoresp i"),
    @NamedQuery(name = "Indicadoresp.findByIndCodigo", query = "SELECT i FROM Indicadoresp i WHERE i.indCodigo = :indCodigo"),
    @NamedQuery(name = "Indicadoresp.findByIndObjetivo", query = "SELECT i FROM Indicadoresp i WHERE i.indObjetivo = :indObjetivo"),
    @NamedQuery(name = "Indicadoresp.findByIndDescripcion", query = "SELECT i FROM Indicadoresp i WHERE i.indDescripcion = :indDescripcion"),
    @NamedQuery(name = "Indicadoresp.findByIndFechai", query = "SELECT i FROM Indicadoresp i WHERE i.indFechai = :indFechai")})
public class Indicadoresp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(name="IND_CODIGO", sequenceName = "INDICADORES", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "IND_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "ind_codigo")
    private String indCodigo;
    @Size(max = 100)
    @Column(name = "ind_objetivo")
    private String indObjetivo;
    @Size(max = 1000)
    @Column(name = "ind_descripcion")
    private String indDescripcion;
    @Column(name = "ind_fechai")
    @Temporal(TemporalType.DATE)
    private Date indFechai;

    public Indicadoresp() {
    }

    public Indicadoresp(String indCodigo) {
        this.indCodigo = indCodigo;
    }

    public String getIndCodigo() {
        return indCodigo;
    }

    public void setIndCodigo(String indCodigo) {
        this.indCodigo = indCodigo;
    }

    public String getIndObjetivo() {
        return indObjetivo;
    }

    public void setIndObjetivo(String indObjetivo) {
        this.indObjetivo = indObjetivo;
    }

    public String getIndDescripcion() {
        return indDescripcion;
    }

    public void setIndDescripcion(String indDescripcion) {
        this.indDescripcion = indDescripcion;
    }

    public Date getIndFechai() {
        return indFechai;
    }

    public void setIndFechai(Date indFechai) {
        this.indFechai = indFechai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indCodigo != null ? indCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Indicadoresp)) {
            return false;
        }
        Indicadoresp other = (Indicadoresp) object;
        if ((this.indCodigo == null && other.indCodigo != null) || (this.indCodigo != null && !this.indCodigo.equals(other.indCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Indicadoresp[ indCodigo=" + indCodigo + " ]";
    }
    
}
