
package Servidor;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "EspePlan", targetNamespace = "http://servidorEspeWeb/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface EspePlan {


    /**
     * 
     * @param descripcion
     * @param fechaI
     * @param vision
     * @param tipo
     * @param fechaF
     * @param titulo
     * @param mision
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "Insertar")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "Insertar", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.Insertar")
    @ResponseWrapper(localName = "InsertarResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarRequest", output = "http://servidorEspeWeb/EspePlan/InsertarResponse")
    public String insertar(
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo,
        @WebParam(name = "titulo", targetNamespace = "")
        String titulo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "vision", targetNamespace = "")
        String vision,
        @WebParam(name = "mision", targetNamespace = "")
        String mision,
        @WebParam(name = "fechaI", targetNamespace = "")
        XMLGregorianCalendar fechaI,
        @WebParam(name = "fechaF", targetNamespace = "")
        XMLGregorianCalendar fechaF);

    /**
     * 
     * @param tipo
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarTipo")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarTipo", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarTipo")
    @ResponseWrapper(localName = "InsertarTipoResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarTipoResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarTipoRequest", output = "http://servidorEspeWeb/EspePlan/InsertarTipoResponse")
    public String insertarTipo(
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo);

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Tipoplan>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerTipoPlan", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerTipoPlan")
    @ResponseWrapper(localName = "obtenerTipoPlanResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerTipoPlanResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerTipoPlanRequest", output = "http://servidorEspeWeb/EspePlan/obtenerTipoPlanResponse")
    public List<Tipoplan> obtenerTipoPlan();

    /**
     * 
     * @param asCodigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarIndicadores", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarIndicadores")
    @ResponseWrapper(localName = "eliminarIndicadoresResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarIndicadoresResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/eliminarIndicadoresRequest", output = "http://servidorEspeWeb/EspePlan/eliminarIndicadoresResponse")
    public String eliminarIndicadores(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param descripcion
     * @param fechaI
     * @param obj
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarIndicadores")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarIndicadores", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarIndicadores")
    @ResponseWrapper(localName = "InsertarIndicadoresResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarIndicadoresResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarIndicadoresRequest", output = "http://servidorEspeWeb/EspePlan/InsertarIndicadoresResponse")
    public String insertarIndicadores(
        @WebParam(name = "Obj", targetNamespace = "")
        String obj,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "fechaI", targetNamespace = "")
        XMLGregorianCalendar fechaI);

    /**
     * 
     * @param descripcion
     * @param fechaI
     * @param obj
     * @param cod
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificarIndicadores", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarIndicadores")
    @ResponseWrapper(localName = "modificarIndicadoresResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarIndicadoresResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/modificarIndicadoresRequest", output = "http://servidorEspeWeb/EspePlan/modificarIndicadoresResponse")
    public String modificarIndicadores(
        @WebParam(name = "Cod", targetNamespace = "")
        String cod,
        @WebParam(name = "Obj", targetNamespace = "")
        String obj,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "fechaI", targetNamespace = "")
        XMLGregorianCalendar fechaI);

    /**
     * 
     * @param indicador
     * @param objetivo
     * @param nombrePlan
     * @param porcentaje
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarIndObj")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarIndObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarIndObj")
    @ResponseWrapper(localName = "InsertarIndObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarIndObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarIndObjRequest", output = "http://servidorEspeWeb/EspePlan/InsertarIndObjResponse")
    public String insertarIndObj(
        @WebParam(name = "indicador", targetNamespace = "")
        String indicador,
        @WebParam(name = "objetivo", targetNamespace = "")
        String objetivo,
        @WebParam(name = "NombrePlan", targetNamespace = "")
        String nombrePlan,
        @WebParam(name = "porcentaje", targetNamespace = "")
        int porcentaje);

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Alinearp>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerAli", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerAli")
    @ResponseWrapper(localName = "obtenerAliResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerAliResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerAliRequest", output = "http://servidorEspeWeb/EspePlan/obtenerAliResponse")
    public List<Alinearp> obtenerAli();

    /**
     * 
     * @param nacional1
     * @param espe1
     * @param operativo1
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarAlinear")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarAlinear", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarAlinear")
    @ResponseWrapper(localName = "InsertarAlinearResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarAlinearResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarAlinearRequest", output = "http://servidorEspeWeb/EspePlan/InsertarAlinearResponse")
    public String insertarAlinear(
        @WebParam(name = "espe1", targetNamespace = "")
        String espe1,
        @WebParam(name = "nacional1", targetNamespace = "")
        String nacional1,
        @WebParam(name = "operativo1", targetNamespace = "")
        String operativo1);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarObj")
    @ResponseWrapper(localName = "eliminarObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/eliminarObjRequest", output = "http://servidorEspeWeb/EspePlan/eliminarObjResponse")
    public String eliminarObj(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param descripcion
     * @param fechaI
     * @param vision
     * @param tipo
     * @param asCodigo
     * @param fechaF
     * @param titulo
     * @param mision
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificarPlanN", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarPlanN")
    @ResponseWrapper(localName = "modificarPlanNResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarPlanNResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/modificarPlanNRequest", output = "http://servidorEspeWeb/EspePlan/modificarPlanNResponse")
    public String modificarPlanN(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo,
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo,
        @WebParam(name = "titulo", targetNamespace = "")
        String titulo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "vision", targetNamespace = "")
        String vision,
        @WebParam(name = "mision", targetNamespace = "")
        String mision,
        @WebParam(name = "fechaI", targetNamespace = "")
        XMLGregorianCalendar fechaI,
        @WebParam(name = "fechaF", targetNamespace = "")
        XMLGregorianCalendar fechaF);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarPlanN", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarPlanN")
    @ResponseWrapper(localName = "eliminarPlanNResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarPlanNResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/eliminarPlanNRequest", output = "http://servidorEspeWeb/EspePlan/eliminarPlanNResponse")
    public String eliminarPlanN(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns Servidor.Plannacionalp
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarPlanN", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarPlanN")
    @ResponseWrapper(localName = "buscarPlanNResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarPlanNResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/buscarPlanNRequest", output = "http://servidorEspeWeb/EspePlan/buscarPlanNResponse")
    public Plannacionalp buscarPlanN(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Plannacionalp>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerPlanN", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerPlanN")
    @ResponseWrapper(localName = "obtenerPlanNResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerPlanNResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerPlanNRequest", output = "http://servidorEspeWeb/EspePlan/obtenerPlanNResponse")
    public List<Plannacionalp> obtenerPlanN();

    /**
     * 
     * @param descripcion
     * @param fechaI
     * @param vision
     * @param tipo
     * @param asCodigo
     * @param fechaF
     * @param titulo
     * @param mision
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "modificarPlan", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarPlan")
    @ResponseWrapper(localName = "modificarPlanResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarPlanResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/modificarPlanRequest", output = "http://servidorEspeWeb/EspePlan/modificarPlanResponse")
    public String modificarPlan(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo,
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo,
        @WebParam(name = "titulo", targetNamespace = "")
        String titulo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "vision", targetNamespace = "")
        String vision,
        @WebParam(name = "mision", targetNamespace = "")
        String mision,
        @WebParam(name = "fechaI", targetNamespace = "")
        XMLGregorianCalendar fechaI,
        @WebParam(name = "fechaF", targetNamespace = "")
        XMLGregorianCalendar fechaF);

    /**
     * 
     * @param descripcion
     * @param fecha
     * @param tipo
     * @param cod
     * @param tit
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ModificarObj")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ModificarObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarObj")
    @ResponseWrapper(localName = "ModificarObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/ModificarObjRequest", output = "http://servidorEspeWeb/EspePlan/ModificarObjResponse")
    public String modificarObj(
        @WebParam(name = "cod", targetNamespace = "")
        String cod,
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo,
        @WebParam(name = "tit", targetNamespace = "")
        String tit,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "fecha", targetNamespace = "")
        XMLGregorianCalendar fecha);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns Servidor.Planpedip
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarPlan", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarPlan")
    @ResponseWrapper(localName = "buscarPlanResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarPlanResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/buscarPlanRequest", output = "http://servidorEspeWeb/EspePlan/buscarPlanResponse")
    public Planpedip buscarPlan(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param descripcion
     * @param fechaI
     * @param vision
     * @param tipo
     * @param fechaF
     * @param titulo
     * @param mision
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarPlanN")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarPlanN", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarPlanN")
    @ResponseWrapper(localName = "InsertarPlanNResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarPlanNResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarPlanNRequest", output = "http://servidorEspeWeb/EspePlan/InsertarPlanNResponse")
    public String insertarPlanN(
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo,
        @WebParam(name = "titulo", targetNamespace = "")
        String titulo,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "vision", targetNamespace = "")
        String vision,
        @WebParam(name = "mision", targetNamespace = "")
        String mision,
        @WebParam(name = "fechaI", targetNamespace = "")
        XMLGregorianCalendar fechaI,
        @WebParam(name = "fechaF", targetNamespace = "")
        XMLGregorianCalendar fechaF);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns Servidor.Objetivosexternos
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarObj")
    @ResponseWrapper(localName = "buscarObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/buscarObjRequest", output = "http://servidorEspeWeb/EspePlan/buscarObjResponse")
    public Objetivosexternos buscarObj(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarPlan", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarPlan")
    @ResponseWrapper(localName = "eliminarPlanResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarPlanResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/eliminarPlanRequest", output = "http://servidorEspeWeb/EspePlan/eliminarPlanResponse")
    public String eliminarPlan(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param descripcion
     * @param fecha
     * @param tipo
     * @param tit
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarObj")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarObj")
    @ResponseWrapper(localName = "InsertarObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarObjRequest", output = "http://servidorEspeWeb/EspePlan/InsertarObjResponse")
    public String insertarObj(
        @WebParam(name = "tipo", targetNamespace = "")
        String tipo,
        @WebParam(name = "tit", targetNamespace = "")
        String tit,
        @WebParam(name = "descripcion", targetNamespace = "")
        String descripcion,
        @WebParam(name = "fecha", targetNamespace = "")
        XMLGregorianCalendar fecha);

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Objetivosexternos>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerObj")
    @ResponseWrapper(localName = "obtenerObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerObjRequest", output = "http://servidorEspeWeb/EspePlan/obtenerObjResponse")
    public List<Objetivosexternos> obtenerObj();

    /**
     * 
     * @param asCodigo
     * @return
     *     returns Servidor.Indicadoresp
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarIndicadores", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarIndicadores")
    @ResponseWrapper(localName = "buscarIndicadoresResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarIndicadoresResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/buscarIndicadoresRequest", output = "http://servidorEspeWeb/EspePlan/buscarIndicadoresResponse")
    public Indicadoresp buscarIndicadores(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Indicadoresp>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerI", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerI")
    @ResponseWrapper(localName = "obtenerIResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerIResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerIRequest", output = "http://servidorEspeWeb/EspePlan/obtenerIResponse")
    public List<Indicadoresp> obtenerI();

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Planpedip>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerPlan", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerPlan")
    @ResponseWrapper(localName = "obtenerPlanResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerPlanResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerPlanRequest", output = "http://servidorEspeWeb/EspePlan/obtenerPlanResponse")
    public List<Planpedip> obtenerPlan();

    /**
     * 
     * @param accion
     * @param pantalla
     * @param fechaA
     * @param usuario
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "InsertarAuditoria")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "InsertarAuditoria", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarAuditoria")
    @ResponseWrapper(localName = "InsertarAuditoriaResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.InsertarAuditoriaResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/InsertarAuditoriaRequest", output = "http://servidorEspeWeb/EspePlan/InsertarAuditoriaResponse")
    public String insertarAuditoria(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "accion", targetNamespace = "")
        String accion,
        @WebParam(name = "pantalla", targetNamespace = "")
        String pantalla,
        @WebParam(name = "fechaA", targetNamespace = "")
        XMLGregorianCalendar fechaA);

    /**
     * 
     * @return
     *     returns java.util.List<Servidor.Objetivoind>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "obtenerIndicadiresObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerIndicadiresObj")
    @ResponseWrapper(localName = "obtenerIndicadiresObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ObtenerIndicadiresObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/obtenerIndicadiresObjRequest", output = "http://servidorEspeWeb/EspePlan/obtenerIndicadiresObjResponse")
    public List<Objetivoind> obtenerIndicadiresObj();

    /**
     * 
     * @param asCodigo
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "eliminarOI", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarOI")
    @ResponseWrapper(localName = "eliminarOIResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.EliminarOIResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/eliminarOIRequest", output = "http://servidorEspeWeb/EspePlan/eliminarOIResponse")
    public String eliminarOI(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

    /**
     * 
     * @param cod
     * @param porcentaje
     * @return
     *     returns java.lang.String
     */
    @WebMethod(operationName = "ModificarIndObj")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "ModificarIndObj", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarIndObj")
    @ResponseWrapper(localName = "ModificarIndObjResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.ModificarIndObjResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/ModificarIndObjRequest", output = "http://servidorEspeWeb/EspePlan/ModificarIndObjResponse")
    public String modificarIndObj(
        @WebParam(name = "cod", targetNamespace = "")
        String cod,
        @WebParam(name = "porcentaje", targetNamespace = "")
        int porcentaje);

    /**
     * 
     * @param asCodigo
     * @return
     *     returns Servidor.Objetivoind
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "buscarOI", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarOI")
    @ResponseWrapper(localName = "buscarOIResponse", targetNamespace = "http://servidorEspeWeb/", className = "Servidor.BuscarOIResponse")
    @Action(input = "http://servidorEspeWeb/EspePlan/buscarOIRequest", output = "http://servidorEspeWeb/EspePlan/buscarOIResponse")
    public Objetivoind buscarOI(
        @WebParam(name = "as_codigo", targetNamespace = "")
        String asCodigo);

}
