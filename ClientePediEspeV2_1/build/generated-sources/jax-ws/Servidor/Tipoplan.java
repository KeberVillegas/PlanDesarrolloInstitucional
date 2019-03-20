
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoplan complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="tipoplan">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipTipo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tipoplan", propOrder = {
    "tipCodigo",
    "tipTipo"
})
public class Tipoplan {

    protected String tipCodigo;
    protected String tipTipo;

    /**
     * Obtiene el valor de la propiedad tipCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipCodigo() {
        return tipCodigo;
    }

    /**
     * Define el valor de la propiedad tipCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipCodigo(String value) {
        this.tipCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad tipTipo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTipTipo() {
        return tipTipo;
    }

    /**
     * Define el valor de la propiedad tipTipo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTipTipo(String value) {
        this.tipTipo = value;
    }

}
