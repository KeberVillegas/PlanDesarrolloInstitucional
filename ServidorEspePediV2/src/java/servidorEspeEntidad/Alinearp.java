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
@Table(name = "alinearp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alinearp.findAll", query = "SELECT a FROM Alinearp a"),
    @NamedQuery(name = "Alinearp.findByAliCodigo", query = "SELECT a FROM Alinearp a WHERE a.aliCodigo = :aliCodigo"),
    @NamedQuery(name = "Alinearp.findByAliNacional", query = "SELECT a FROM Alinearp a WHERE a.aliNacional = :aliNacional"),
    @NamedQuery(name = "Alinearp.findByAliEspe", query = "SELECT a FROM Alinearp a WHERE a.aliEspe = :aliEspe"),
    @NamedQuery(name = "Alinearp.findByAliOperativo", query = "SELECT a FROM Alinearp a WHERE a.aliOperativo = :aliOperativo")})
public class Alinearp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name="ALI_CODIGO", sequenceName = "ALINEAR", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "ALI_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "ali_codigo")
    private String aliCodigo;
    @Size(max = 1000)
    @Column(name = "ali_nacional")
    private String aliNacional;
    @Size(max = 1000)
    @Column(name = "ali_espe")
    private String aliEspe;
    @Size(max = 1000)
    @Column(name = "ali_operativo")
    private String aliOperativo;

    public Alinearp() {
    }

    public Alinearp(String aliCodigo) {
        this.aliCodigo = aliCodigo;
    }

    public String getAliCodigo() {
        return aliCodigo;
    }

    public void setAliCodigo(String aliCodigo) {
        this.aliCodigo = aliCodigo;
    }

    public String getAliNacional() {
        return aliNacional;
    }

    public void setAliNacional(String aliNacional) {
        this.aliNacional = aliNacional;
    }

    public String getAliEspe() {
        return aliEspe;
    }

    public void setAliEspe(String aliEspe) {
        this.aliEspe = aliEspe;
    }

    public String getAliOperativo() {
        return aliOperativo;
    }

    public void setAliOperativo(String aliOperativo) {
        this.aliOperativo = aliOperativo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (aliCodigo != null ? aliCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alinearp)) {
            return false;
        }
        Alinearp other = (Alinearp) object;
        if ((this.aliCodigo == null && other.aliCodigo != null) || (this.aliCodigo != null && !this.aliCodigo.equals(other.aliCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Alinearp[ aliCodigo=" + aliCodigo + " ]";
    }
    
}
