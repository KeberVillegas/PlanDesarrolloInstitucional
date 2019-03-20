
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para planpedip complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="planpedip">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="plaCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plaDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plaFechaf" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="plaFechai" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="plaMision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plaNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plaTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plaVision" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "planpedip", propOrder = {
    "plaCodigo",
    "plaDescripcion",
    "plaFechaf",
    "plaFechai",
    "plaMision",
    "plaNombre",
    "plaTipo",
    "plaVision"
})
public class Planpedip {

    protected String plaCodigo;
    protected String plaDescripcion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plaFechaf;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar plaFechai;
    protected String plaMision;
    protected String plaNombre;
    protected String plaTipo;
    protected String plaVision;

    /**
     * Obtiene el valor de la propiedad plaCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaCodigo() {
        return plaCodigo;
    }

    /**
     * Define el valor de la propiedad plaCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaCodigo(String value) {
        this.plaCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad plaDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaDescripcion() {
        return plaDescripcion;
    }

    /**
     * Define el valor de la propiedad plaDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaDescripcion(String value) {
        this.plaDescripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad plaFechaf.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlaFechaf() {
        return plaFechaf;
    }

    /**
     * Define el valor de la propiedad plaFechaf.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlaFechaf(XMLGregorianCalendar value) {
        this.plaFechaf = value;
    }

    /**
     * Obtiene el valor de la propiedad plaFechai.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getPlaFechai() {
        return plaFechai;
    }

    /**
     * Define el valor de la propiedad plaFechai.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setPlaFechai(XMLGregorianCalendar value) {
        this.plaFechai = value;
    }

    /**
     * Obtiene el valor de la propiedad plaMision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaMision() {
        return plaMision;
    }

    /**
     * Define el valor de la propiedad plaMision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaMision(String value) {
        this.plaMision = value;
    }

    /**
     * Obtiene el valor de la propiedad plaNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaNombre() {
        return plaNombre;
    }

    /**
     * Define el valor de la propiedad plaNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaNombre(String value) {
        this.plaNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad plaTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaTipo() {
        return plaTipo;
    }

    /**
     * Define el valor de la propiedad plaTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaTipo(String value) {
        this.plaTipo = value;
    }

    /**
     * Obtiene el valor de la propiedad plaVision.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaVision() {
        return plaVision;
    }

    /**
     * Define el valor de la propiedad plaVision.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaVision(String value) {
        this.plaVision = value;
    }

}
