/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeWeb;

import java.util.*;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import servidorEspeEntidad.Alinearp;
import servidorEspeEntidad.Indicadoresp;
import servidorEspeEntidad.Objetivoind;
import servidorEspeEntidad.Objetivosexternos;
import servidorEspeEntidad.Plannacionalp;
import servidorEspeEntidad.Planpedip;
import servidorEspeEntidad.Tipoplan;

/**
 *
 * @author Kleber
 */
@WebService()
public class EspePlan {

    @EJB
    ServiceEspePlan planServicio;
////////////////////AUDITORIA///////////
       @WebMethod(operationName = "InsertarAuditoria")
    public String insertarAuditoria(@WebParam(name = "usuario") String usuario, @WebParam(name = "accion") String accion, @WebParam(name = "pantalla") String pantalla,@WebParam(name = "fechaA") Date fechaAu) {
        return planServicio.insertarAuditoria(usuario, accion, pantalla, fechaAu);
    }
///////////////////////////////////////    
    @WebMethod(operationName = "InsertarTipo")
    public String insertarTipoPlan(@WebParam(name = "tipo") String tipoPlan) {

        return planServicio.insetarTipoPlan(tipoPlan);
    }

    @WebMethod(operationName = "Insertar")
    public String insertarPlan(@WebParam(name = "tipo") String tip, @WebParam(name = "titulo") String tit, @WebParam(name = "descripcion") String desp, @WebParam(name = "vision") String vi, @WebParam(name = "mision") String mi,
            @WebParam(name = "fechaI") Date fechai, @WebParam(name = "fechaF") Date fechaf) {
        return planServicio.insertarPlan(tip, tit, desp, vi, mi, fechai, fechaf);
    }
    
    @WebMethod(operationName = "buscarPlan")
    public Planpedip buscarPlan(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.buscarPlan(as_codigo);
    }

    @WebMethod(operationName = "eliminarPlan")
    public String eliminarPlan(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.eliminarPlan(as_codigo);
    }
    
    @WebMethod(operationName = "modificarPlan")
    public String modificarPlan(@WebParam(name = "as_codigo") String as_codigo,@WebParam(name = "tipo") String tip, @WebParam(name = "titulo") String tit, @WebParam(name = "descripcion") String desp, @WebParam(name = "vision") String vi, @WebParam(name = "mision") String mi,
            @WebParam(name = "fechaI") Date fechai, @WebParam(name = "fechaF") Date fechaf) {
        return planServicio.modificarPlan(as_codigo, tip, tit, desp, vi, mi, fechai, fechaf);
    }
  
    /////OBTENER TIPO///
    @WebMethod(operationName = "obtenerTipoPlan")
    public List<Tipoplan> obtenerCiudades() {
        return planServicio.obtenerTipo();
    }

    /////OBTENER PLAN//
    @WebMethod(operationName = "obtenerPlan")
    public List<Planpedip> obtenerpPlan() {
        return planServicio.obtenerPlan();
    }

    /////INSERTAR OBJ
    @WebMethod(operationName = "InsertarObj")
    public String insertarObj(@WebParam(name = "tipo") String tip, @WebParam(name = "tit") String tit, @WebParam(name = "descripcion") String des, @WebParam(name = "fecha") Date fe) {
        return planServicio.insertarObj(tip,tit,des, fe);
    }

    @WebMethod(operationName = "obtenerObj")
    public List<Objetivosexternos> obtenerpObj() {
        return planServicio.obtenerObj();
    }
    ///ELIMINAR OBJ/////

    @WebMethod(operationName = "buscarObj")
    public Objetivosexternos buscarObj(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.buscarObj(as_codigo);
    }

    @WebMethod(operationName = "eliminarObj")
    public String eliminarObj(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.eliminarObj(as_codigo);
    }
    @WebMethod(operationName = "ModificarObj")
    public String modificarObj(@WebParam(name = "cod") String cod,@WebParam(name = "tipo") String tip, @WebParam(name = "tit") String tit, @WebParam(name = "descripcion") String des, @WebParam(name = "fecha") Date fe) {
        return planServicio.modificarObj(cod,tip,tit,des, fe);
    }

    //////////////PLAN NACIONAL////////
        @WebMethod(operationName = "InsertarPlanN")
    public String insertarPlanN(@WebParam(name = "tipo") String tip, @WebParam(name = "titulo") String tit, @WebParam(name = "descripcion") String desp, @WebParam(name = "vision") String vi, @WebParam(name = "mision") String mi,
            @WebParam(name = "fechaI") Date fechai, @WebParam(name = "fechaF") Date fechaf) {
        return planServicio.insertarPlanN(tip, tit, desp, vi, mi, fechai, fechaf);
    }
       
    @WebMethod(operationName = "buscarPlanN")
    public Plannacionalp buscarPlanN(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.buscarPlanN(as_codigo);
    }

    @WebMethod(operationName = "eliminarPlanN")
    public String eliminarPlanN(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.eliminarPlanN(as_codigo);
    }
    @WebMethod(operationName = "modificarPlanN")
    public String modificarPlanN(@WebParam(name = "as_codigo") String as_codigo,@WebParam(name = "tipo") String tip, @WebParam(name = "titulo") String tit, @WebParam(name = "descripcion") String desp, @WebParam(name = "vision") String vi, @WebParam(name = "mision") String mi,
            @WebParam(name = "fechaI") Date fechai, @WebParam(name = "fechaF") Date fechaf) {
        return planServicio.modificarPlanN(as_codigo, tip, tit, desp, vi, mi, fechaf, fechaf);
        
    }
     //////////////PLAN INDICADORES////////
        @WebMethod(operationName = "InsertarIndicadores")
    public String insertarIndicador(@WebParam(name = "Obj") String obj,@WebParam(name = "descripcion") String desp, @WebParam(name = "fechaI") Date fechaI) {
        return planServicio.insertarIndicadore(obj, desp, fechaI);
    }
       
    @WebMethod(operationName = "buscarIndicadores")
    public Indicadoresp Indicador(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.buscarIndicadores(as_codigo);
    }

    @WebMethod(operationName = "eliminarIndicadores")
    public String eliminarIndicador(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.EliminarIndicadores(as_codigo);
    }
    @WebMethod(operationName = "modificarIndicadores")
    public String modificarIndicador(@WebParam(name = "Cod") String cod,@WebParam(name = "Obj") String obj,@WebParam(name = "descripcion") String desp,@WebParam(name = "fechaI") Date fechaI) {
        return planServicio.ModificarIndicadores(cod, obj, desp, fechaI);
    }
    
     @WebMethod(operationName = "obtenerPlanN")
    public List<Plannacionalp> obtenerPlanN() {
        return planServicio.obtenerPlanN();
    }
     @WebMethod(operationName = "obtenerI")
    public List<Indicadoresp> obtenerI() {
        return planServicio.obtenerIn();
    }
    /////////////////////////////////////////////////////
         @WebMethod(operationName = "obtenerIndicadiresObj")
    public List<Objetivoind> obtenerIndObj() {
        return planServicio.obtenerIn1();
    }
    //////////Objetio - Indicador////////////////////////
    
      @WebMethod(operationName = "InsertarIndObj")
    public String insertarObjInd(@WebParam(name = "indicador") String ind,@WebParam(name = "objetivo") String obj,@WebParam(name = "NombrePlan")String nombre ,@WebParam(name = "porcentaje") int porcentaje) {
        return planServicio.insertarObjInd(obj, ind,nombre,porcentaje);
    }
    
     @WebMethod(operationName = "buscarOI")
    public Objetivoind buscarIndObj(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.buscarIO(as_codigo);
    }

    @WebMethod(operationName = "eliminarOI")
    public String eliminarIndObj(@WebParam(name = "as_codigo") String as_codigo) {
        return planServicio.eliminarIO(as_codigo);
    }
    
//        @WebMethod(operationName = "ModificarIndObj")
//    public String modificarObjInd(@WebParam(name = "cod") String codigo,@WebParam(name = "indicador") String ind,@WebParam(name = "objetivo") String obj,@WebParam(name = "NombrePlan")String nombre ,@WebParam(name = "porcentaje") int porcentaje) {
//        return planServicio.modificarIO(codigo,obj, ind,nombre,porcentaje);
//    }
    
        @WebMethod(operationName = "ModificarIndObj")
    public String modificarObjInd(@WebParam(name = "cod") String codigo,@WebParam(name = "porcentaje") int porcentaje) {
        return planServicio.modificarIO(codigo, porcentaje);
    }
    
    //////////////
          @WebMethod(operationName = "InsertarAlinear")
    public String insertarAlinear(@WebParam(name = "espe1") String espe,@WebParam(name = "nacional1") String nacional,@WebParam(name = "operativo1") String operativo) {
        return planServicio.insertarAli(espe, nacional,operativo);
    }
     @WebMethod(operationName = "obtenerAli")
    public List<Alinearp> obtenerAli() {
        return planServicio.obtenerAlinear();
    }
    
}
