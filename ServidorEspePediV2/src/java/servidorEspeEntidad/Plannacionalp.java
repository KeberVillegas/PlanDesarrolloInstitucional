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
@Table(name = "plannacionalp")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Plannacionalp.findAll", query = "SELECT p FROM Plannacionalp p"),
    @NamedQuery(name = "Plannacionalp.findByPlanCodigo", query = "SELECT p FROM Plannacionalp p WHERE p.planCodigo = :planCodigo"),
    @NamedQuery(name = "Plannacionalp.findByPlanTipo", query = "SELECT p FROM Plannacionalp p WHERE p.planTipo = :planTipo"),
    @NamedQuery(name = "Plannacionalp.findByPlanNombre", query = "SELECT p FROM Plannacionalp p WHERE p.planNombre = :planNombre"),
    @NamedQuery(name = "Plannacionalp.findByPlanDescripcion", query = "SELECT p FROM Plannacionalp p WHERE p.planDescripcion = :planDescripcion"),
    @NamedQuery(name = "Plannacionalp.findByPlanMision", query = "SELECT p FROM Plannacionalp p WHERE p.planMision = :planMision"),
    @NamedQuery(name = "Plannacionalp.findByPlanVision", query = "SELECT p FROM Plannacionalp p WHERE p.planVision = :planVision"),
    @NamedQuery(name = "Plannacionalp.findByPlanFechai", query = "SELECT p FROM Plannacionalp p WHERE p.planFechai = :planFechai"),
    @NamedQuery(name = "Plannacionalp.findByPlanFechaf", query = "SELECT p FROM Plannacionalp p WHERE p.planFechaf = :planFechaf")})
public class Plannacionalp implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
     @SequenceGenerator(name="PLAN_CODIGO", sequenceName = "PLANNACIONAL", allocationSize = 1)
     @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "PLAN_CODIGO")
    @Basic(optional = false)
    @Size(min = 1, max = 1000)
    @Column(name = "plan_codigo")
    private String planCodigo;
    @Size(max = 500)
    @Column(name = "plan_tipo")
    private String planTipo;
    @Size(max = 500)
    @Column(name = "plan_nombre")
    private String planNombre;
    @Size(max = 1000)
    @Column(name = "plan_descripcion")
    private String planDescripcion;
    @Size(max = 1000)
    @Column(name = "plan_mision")
    private String planMision;
    @Size(max = 1000)
    @Column(name = "plan_vision")
    private String planVision;
    @Column(name = "plan_fechai")
    @Temporal(TemporalType.DATE)
    private Date planFechai;
    @Column(name = "plan_fechaf")
    @Temporal(TemporalType.DATE)
    private Date planFechaf;

    public Plannacionalp() {
    }

    public Plannacionalp(String planCodigo) {
        this.planCodigo = planCodigo;
    }

    public String getPlanCodigo() {
        return planCodigo;
    }

    public void setPlanCodigo(String planCodigo) {
        this.planCodigo = planCodigo;
    }

    public String getPlanTipo() {
        return planTipo;
    }

    public void setPlanTipo(String planTipo) {
        this.planTipo = planTipo;
    }

    public String getPlanNombre() {
        return planNombre;
    }

    public void setPlanNombre(String planNombre) {
        this.planNombre = planNombre;
    }

    public String getPlanDescripcion() {
        return planDescripcion;
    }

    public void setPlanDescripcion(String planDescripcion) {
        this.planDescripcion = planDescripcion;
    }

    public String getPlanMision() {
        return planMision;
    }

    public void setPlanMision(String planMision) {
        this.planMision = planMision;
    }

    public String getPlanVision() {
        return planVision;
    }

    public void setPlanVision(String planVision) {
        this.planVision = planVision;
    }

    public Date getPlanFechai() {
        return planFechai;
    }

    public void setPlanFechai(Date planFechai) {
        this.planFechai = planFechai;
    }

    public Date getPlanFechaf() {
        return planFechaf;
    }

    public void setPlanFechaf(Date planFechaf) {
        this.planFechaf = planFechaf;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (planCodigo != null ? planCodigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Plannacionalp)) {
            return false;
        }
        Plannacionalp other = (Plannacionalp) object;
        if ((this.planCodigo == null && other.planCodigo != null) || (this.planCodigo != null && !this.planCodigo.equals(other.planCodigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "servidorEspeEntidad.Plannacionalp[ planCodigo=" + planCodigo + " ]";
    }
    
}
