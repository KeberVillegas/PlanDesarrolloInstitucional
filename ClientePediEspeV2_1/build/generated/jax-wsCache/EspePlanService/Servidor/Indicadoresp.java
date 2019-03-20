
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Clase Java para indicadoresp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="indicadoresp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="indCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indDescripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="indFechai" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="indObjetivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "indicadoresp", propOrder = {
    "indCodigo",
    "indDescripcion",
    "indFechai",
    "indObjetivo"
})
public class Indicadoresp {

    protected String indCodigo;
    protected String indDescripcion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar indFechai;
    protected String indObjetivo;

    /**
     * Obtiene el valor de la propiedad indCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndCodigo() {
        return indCodigo;
    }

    /**
     * Define el valor de la propiedad indCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndCodigo(String value) {
        this.indCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad indDescripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndDescripcion() {
        return indDescripcion;
    }

    /**
     * Define el valor de la propiedad indDescripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndDescripcion(String value) {
        this.indDescripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad indFechai.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getIndFechai() {
        return indFechai;
    }

    /**
     * Define el valor de la propiedad indFechai.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setIndFechai(XMLGregorianCalendar value) {
        this.indFechai = value;
    }

    /**
     * Obtiene el valor de la propiedad indObjetivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIndObjetivo() {
        return indObjetivo;
    }

    /**
     * Define el valor de la propiedad indObjetivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIndObjetivo(String value) {
        this.indObjetivo = value;
    }

}
