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
@Table(name = "objetivoind")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Objetivoind.findAll", query = "SELECT o FROM Objetivoind o"),
    @NamedQuery(name = "Objetivoind.findByObjiCodigo", query = "SELECT o FROM Objetivoind o WHERE o.objiCodigo = :objiCodigo"),
    @NamedQuery(name = "Objetivoind.findByObjiObjetivo", query = "SELECT o FROM Objetivoind o WHERE o.objiObjetivo = :objiObjetivo"),
    @NamedQuery(name = "Objetivoind.findByObjiIndicador", query = "SELECT o FROM Objetivoind o WHERE o.objiIndicador = :objiIndicador"),
    @NamedQuery(name = "Objetivoind.findByObjiPorcentaje", query = "SELECT o FROM Objetivoind o WHERE o.objiPorcentaje = :objiPorcentaje"),
    @NamedQuery(name = "Objetivoind.findByObjiNomplan", query = "SELECT o FROM Objetivoind  o  WHERE  o.objiNomplan = :objiNomplan" )})
public class Objetivoind implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="OBJI_CODIGO", sequenceName = "OBJIND", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "OBJI_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "obji_codigo")
    private String objiCodigo;
    @Size(max = 500)
    @Column(name = "obji_objetivo")
    private String objiObjetivo;
    @Size(max = 500)
    @Column(name = "obji_indicador")
    private String objiIndicador;
    @Column(name = "obji_porcentaje")
    private Integer objiPorcentaje;
    @Size(max = 1000)
    @Column(name = "obji_nomplan")
    private String objiNomplan;

    public Objetivoind() {
    }

    public Objetivoind(String objiCodigo) {
        this.objiCodigo = objiCodigo;
    }

    public String getObjiCodigo() {
        return objiCodigo;
    }

    public void setObjiCodigo(String objiCodigo) {
        this.objiCodigo = objiCodigo;
    }

    public String getObjiObjetivo() {
        return objiObjetivo;
    }

    public void setObjiObjetivo(String objiObjetivo) {
        this.objiObjetivo = objiObjetivo;
    }

    public String getObjiIndicador() {
        return objiIndicador;
    }

    public void setObjiIndicador(String objiIndicador) {
        this.objiIndicador = objiIndicador;
    }

    public Integer getObjiPorcentaje() {
        return objiPorcentaje;
    }

    public void setObjiPorcentaje(Integer objiPorcentaje) {
        this.objiPorcentaje = objiPorcentaje;
    }

    public String getObjiNomplan() {
        return objiNomplan;
    }

    public void setObjiNomplan(String objiNomplan) {
        this.objiNomplan = objiNomplan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (objiCodigo != null ? objiCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Objetivoind)) {
            return false;
        }
        Objetivoind other = (Objetivoind) object;
        if ((this.objiCodigo == null && other.objiCodigo != null) || (this.objiCodigo != null && !this.objiCodigo.equals(other.objiCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Objetivoind[ objiCodigo=" + objiCodigo + " ]";
    }
    
}
