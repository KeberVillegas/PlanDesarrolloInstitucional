
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para objetivosexternos complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="objetivosexternos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objFecha" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="objNombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objTitulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetivosexternos", propOrder = {
    "objCodigo",
    "objDescripcion",
    "objFecha",
    "objNombre",
    "objTitulo"
})
public class Objetivosexternos {

    protected String objCodigo;
    protected String objDescripcion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar objFecha;
    protected String objNombre;
    protected String objTitulo;

    /**
     * Obtiene el valor de la propiedad objCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjCodigo() {
        return objCodigo;
    }

    /**
     * Define el valor de la propiedad objCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjCodigo(String value) {
        this.objCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad objDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjDescripcion() {
        return objDescripcion;
    }

    /**
     * Define el valor de la propiedad objDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjDescripcion(String value) {
        this.objDescripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad objFecha.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getObjFecha() {
        return objFecha;
    }

    /**
     * Define el valor de la propiedad objFecha.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setObjFecha(XMLGregorianCalendar value) {
        this.objFecha = value;
    }

    /**
     * Obtiene el valor de la propiedad objNombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjNombre() {
        return objNombre;
    }

    /**
     * Define el valor de la propiedad objNombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjNombre(String value) {
        this.objNombre = value;
    }

    /**
     * Obtiene el valor de la propiedad objTitulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjTitulo() {
        return objTitulo;
    }

    /**
     * Define el valor de la propiedad objTitulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjTitulo(String value) {
        this.objTitulo = value;
    }

}
