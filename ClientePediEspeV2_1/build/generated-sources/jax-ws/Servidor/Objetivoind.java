
package Servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para objetivoind complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="objetivoind">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="objiCodigo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objiIndicador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objiNomplan" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objiObjetivo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="objiPorcentaje" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "objetivoind", propOrder = {
    "objiCodigo",
    "objiIndicador",
    "objiNomplan",
    "objiObjetivo",
    "objiPorcentaje"
})
public class Objetivoind {

    protected String objiCodigo;
    protected String objiIndicador;
    protected String objiNomplan;
    protected String objiObjetivo;
    protected Integer objiPorcentaje;

    /**
     * Obtiene el valor de la propiedad objiCodigo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjiCodigo() {
        return objiCodigo;
    }

    /**
     * Define el valor de la propiedad objiCodigo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjiCodigo(String value) {
        this.objiCodigo = value;
    }

    /**
     * Obtiene el valor de la propiedad objiIndicador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjiIndicador() {
        return objiIndicador;
    }

    /**
     * Define el valor de la propiedad objiIndicador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjiIndicador(String value) {
        this.objiIndicador = value;
    }

    /**
     * Obtiene el valor de la propiedad objiNomplan.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjiNomplan() {
        return objiNomplan;
    }

    /**
     * Define el valor de la propiedad objiNomplan.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjiNomplan(String value) {
        this.objiNomplan = value;
    }

    /**
     * Obtiene el valor de la propiedad objiObjetivo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getObjiObjetivo() {
        return objiObjetivo;
    }

    /**
     * Define el valor de la propiedad objiObjetivo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setObjiObjetivo(String value) {
        this.objiObjetivo = value;
    }

    /**
     * Obtiene el valor de la propiedad objiPorcentaje.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getObjiPorcentaje() {
        return objiPorcentaje;
    }

    /**
     * Define el valor de la propiedad objiPorcentaje.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setObjiPorcentaje(Integer value) {
        this.objiPorcentaje = value;
    }

}
