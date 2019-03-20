
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para InsertarAlinear complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="InsertarAlinear">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="espe1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nacional1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operativo1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InsertarAlinear", propOrder = {
    "espe1",
    "nacional1",
    "operativo1"
})
public class InsertarAlinear {

    protected String espe1;
    protected String nacional1;
    protected String operativo1;

    /**
     * Obtiene el valor de la propiedad espe1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEspe1() {
        return espe1;
    }

    /**
     * Define el valor de la propiedad espe1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEspe1(String value) {
        this.espe1 = value;
    }

    /**
     * Obtiene el valor de la propiedad nacional1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNacional1() {
        return nacional1;
    }

    /**
     * Define el valor de la propiedad nacional1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNacional1(String value) {
        this.nacional1 = value;
    }

    /**
     * Obtiene el valor de la propiedad operativo1.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOperativo1() {
        return operativo1;
    }

    /**
     * Define el valor de la propiedad operativo1.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOperativo1(String value) {
        this.operativo1 = value;
    }

}
