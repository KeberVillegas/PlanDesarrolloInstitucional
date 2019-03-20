
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para eliminarPlanN complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="eliminarPlanN">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="as_codigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eliminarPlanN", propOrder = {
    "asCodigo"
})
public class EliminarPlanN {

    @XmlElement(name = "as_codigo")
    protected String asCodigo;

    /**
     * Obtiene el valor de la propiedad asCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAsCodigo() {
        return asCodigo;
    }

    /**
     * Define el valor de la propiedad asCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAsCodigo(String value) {
        this.asCodigo = value;
    }

}
