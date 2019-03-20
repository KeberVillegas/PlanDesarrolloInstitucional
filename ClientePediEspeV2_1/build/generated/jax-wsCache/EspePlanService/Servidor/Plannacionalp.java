
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para plannacionalp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="plannacionalp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="planCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planFechaf" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="planFechai" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="planMision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="planVision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "plannacionalp", propOrder = {
    "planCodigo",
    "planDescripcion",
    "planFechaf",
    "planFechai",
    "planMision",
    "planNombre",
    "planTipo",
    "planVision"
})
public class Plannacionalp {

    protected String planCodigo;
    protected String planDescripcion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar planFechaf;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar planFechai;
    protected String planMision;
    protected String planNombre;
    protected String planTipo;
    protected String planVision;

    /**
     * Obtiene el valor de la propiedad planCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanCodigo() {
        return planCodigo;
    }

    /**
     * Define el valor de la propiedad planCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanCodigo(String value) {
        this.planCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad planDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanDescripcion() {
        return planDescripcion;
    }

    /**
     * Define el valor de la propiedad planDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanDescripcion(String value) {
        this.planDescripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad planFechaf.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlanFechaf() {
        return planFechaf;
    }

    /**
     * Define el valor de la propiedad planFechaf.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlanFechaf(XMLGregorianCalendar value) {
        this.planFechaf = value;
    }

    /**
     * Obtiene el valor de la propiedad planFechai.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlanFechai() {
        return planFechai;
    }

    /**
     * Define el valor de la propiedad planFechai.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlanFechai(XMLGregorianCalendar value) {
        this.planFechai = value;
    }

    /**
     * Obtiene el valor de la propiedad planMision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanMision() {
        return planMision;
    }

    /**
     * Define el valor de la propiedad planMision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanMision(String value) {
        this.planMision = value;
    }

    /**
     * Obtiene el valor de la propiedad planNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanNombre() {
        return planNombre;
    }

    /**
     * Define el valor de la propiedad planNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanNombre(String value) {
        this.planNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad planTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanTipo() {
        return planTipo;
    }

    /**
     * Define el valor de la propiedad planTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanTipo(String value) {
        this.planTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad planVision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanVision() {
        return planVision;
    }

    /**
     * Define el valor de la propiedad planVision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanVision(String value) {
        this.planVision = value;
    }

}
