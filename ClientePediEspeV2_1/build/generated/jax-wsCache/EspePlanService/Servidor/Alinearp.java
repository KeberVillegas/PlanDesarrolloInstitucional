
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para alinearp complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="alinearp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="aliCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aliEspe" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aliNacional" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="aliOperativo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alinearp", propOrder = {
    "aliCodigo",
    "aliEspe",
    "aliNacional",
    "aliOperativo"
})
public class Alinearp {

    protected String aliCodigo;
    protected String aliEspe;
    protected String aliNacional;
    protected String aliOperativo;

    /**
     * Obtiene el valor de la propiedad aliCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliCodigo() {
        return aliCodigo;
    }

    /**
     * Define el valor de la propiedad aliCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliCodigo(String value) {
        this.aliCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad aliEspe.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliEspe() {
        return aliEspe;
    }

    /**
     * Define el valor de la propiedad aliEspe.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliEspe(String value) {
        this.aliEspe = value;
    }

    /**
     * Obtiene el valor de la propiedad aliNacional.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliNacional() {
        return aliNacional;
    }

    /**
     * Define el valor de la propiedad aliNacional.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliNacional(String value) {
        this.aliNacional = value;
    }

    /**
     * Obtiene el valor de la propiedad aliOperativo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAliOperativo() {
        return aliOperativo;
    }

    /**
     * Define el valor de la propiedad aliOperativo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAliOperativo(String value) {
        this.aliOperativo = value;
    }

}
