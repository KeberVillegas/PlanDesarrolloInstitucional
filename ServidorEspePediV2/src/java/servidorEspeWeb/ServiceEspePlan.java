/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidorEspeWeb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import servidorEspeEntidad.Alinearp;
import servidorEspeEntidad.Historialcamb;
import servidorEspeEntidad.Indicadoresp;
import servidorEspeEntidad.Objetivoind;
import servidorEspeEntidad.Objetivosexternos;
import servidorEspeEntidad.Plannacionalp;
import servidorEspeEntidad.Planpedip;
import servidorEspeEntidad.Tipoplan;
import servidorEspeFacade.AlinearpFacade;
import servidorEspeFacade.HistorialcambFacade;
import servidorEspeFacade.IndicadorespFacade;
import servidorEspeFacade.ObjetivoindFacade;
import servidorEspeFacade.ObjetivosexternosFacade;
import servidorEspeFacade.PlannacionalpFacade;
import servidorEspeFacade.PlanpedipFacade;
import servidorEspeFacade.TipoplanFacade;

/**
 *
 * @author Kleber
 */
@Stateless
public class ServiceEspePlan {

    @EJB
    TipoplanFacade tipoplanFacade;
    @EJB
    PlanpedipFacade planEspe;
    @EJB
    ObjetivosexternosFacade objetivos;
    @EJB
    PlannacionalpFacade plann;
    @EJB
    IndicadorespFacade indicadores;
    @EJB
    ObjetivoindFacade objInd;
    @EJB
    AlinearpFacade  alinear;
    @EJB
    HistorialcambFacade historial;
    /////////////Auditoria////////
      public String insertarAuditoria(String usuario, String accion, String pantalla,Date fechaA) {
        Historialcamb a = new Historialcamb();
        a.setHistoUsuario(usuario);
        a.setHistoAccion(accion);
        a.setHistoPantalla(pantalla);
        a.setHistoFecha(fechaA);
        historial.create(a);
        return a.getHistoCodigo();
    }
    ////////INSERTAR TIPO DE PLAN//////
    public String insetarTipoPlan(String tipdes) {
        Tipoplan tip = new Tipoplan();
        System.out.println("hola");
        tip.setTipTipo(tipdes);
        tipoplanFacade.create(tip);
        return tip.getTipCodigo();
    }

//    public Date DeStringADate(String fecha) {
//        SimpleDateFormat formato = new SimpleDateFormat("dd-MMM-yy");
//        String strFecha = fecha;
//        Date fechaDate = null;
//        try {
//            fechaDate = formato.parse(strFecha);
//            System.out.println(fechaDate.toString());
//            return fechaDate;
//        } catch (ParseException ex) {
//            return fechaDate;
//        }
//    }

    /////OBTENER TIPO DE PLAN///////
    public List<Tipoplan> obtenerTipo() {
        List lista = new ArrayList();
        lista = tipoplanFacade.findAll();
        return lista;
    }

    public List<Planpedip> obtenerPlan() {
        List lista1 = new ArrayList();
        lista1 = planEspe.findAll();
        return lista1;
    }

    ////////
    public String insertarPlan(String tipo, String titulo, String des, String vi, String mi, Date fechaI, Date fechaF) {
        Planpedip a = new Planpedip();
        a.setPlaTipo(tipo);
        a.setPlaNombre(titulo);
        a.setPlaDescripcion(des);
        a.setPlaVision(vi);
        a.setPlaMision(mi);
        a.setPlaFechai(fechaI);
        a.setPlaFechaf(fechaF);
        planEspe.create(a);
        return a.getPlaCodigo();
    }

    //////////////////ELIMINAR PLAN/////////
    public Planpedip buscarPlan(String as_codigo) {
        Planpedip a = new Planpedip();
        a = planEspe.find(as_codigo);
        return a;
    }

    public String eliminarPlan(String as_codigo) {
        Planpedip a = new Planpedip();
        a = buscarPlan(as_codigo);
        planEspe.remove(a);
        return "fue eliminado correctamente";
    }

    ////////////////////MODIFICAR PLAN////////
    public String modificarPlan(String as_codigo, String tipo, String titulo, String des, String vi, String mi, Date fechaI, Date fechaF) {
        Planpedip a = new Planpedip();
        a = buscarPlan(as_codigo);
        a.setPlaTipo(tipo);
        a.setPlaNombre(titulo);
        a.setPlaDescripcion(des);
        a.setPlaVision(vi);
        a.setPlaMision(mi);
        a.setPlaFechai(fechaI);
        a.setPlaFechaf(fechaF);
        planEspe.edit(a);
        return a.getPlaCodigo();
    }

    /////////////////////INSERTAR OBJETIVOS/////
    public String insertarObj(String tip, String tit, String des, Date fecha) {
        Objetivosexternos obj = new Objetivosexternos();
        obj.setObjNombre(tip);
        obj.setObjTitulo(tit);
        obj.setObjDescripcion(des);
        obj.setObjFecha(fecha);
        objetivos.create(obj);
        return obj.getObjCodigo();
    }

    public List<Objetivosexternos> obtenerObj() {
        List lista3 = new ArrayList();
        lista3 = objetivos.findAll();
        return lista3;
    }

    //////ELIMINAR OBJETIVOS/////
    public Objetivosexternos buscarObj(String as_codigo) {
        Objetivosexternos a = new Objetivosexternos();
        a = objetivos.find(as_codigo);
        return a;
    }

    public String eliminarObj(String as_codigo) {
        Objetivosexternos a = new Objetivosexternos();
        a = buscarObj(as_codigo);
        objetivos.remove(a);
        return "fue eliminado correctamente";
    }

    public String modificarObj(String as_codigo, String tip, String tit, String des, Date fecha) {
        Objetivosexternos a = new Objetivosexternos();
        a = buscarObj(as_codigo);
        a.setObjNombre(tip);
        a.setObjTitulo(tit);
        a.setObjDescripcion(des);
        a.setObjFecha(fecha);
        objetivos.edit(a);
        return a.getObjCodigo();
    }
    ////////////////////PLAN NACIONAL//////////////

    public String insertarPlanN(String tipo, String titulo, String des, String vi, String mi, Date fechaI, Date fechaF) {
        Plannacionalp a = new Plannacionalp();
        a.setPlanTipo(tipo);
        a.setPlanNombre(titulo);
        a.setPlanDescripcion(des);
        a.setPlanVision(vi);
        a.setPlanMision(mi);
        a.setPlanFechai(fechaI);
        a.setPlanFechaf(fechaF);
        plann.create(a);
        return a.getPlanCodigo();
    }

    //////////////////ELIMINAR PLAN/////////
    public Plannacionalp buscarPlanN(String as_codigo) {
        Plannacionalp a = new Plannacionalp();
        a = plann.find(as_codigo);
        return a;
    }

    public String eliminarPlanN(String as_codigo) {
        Plannacionalp a = new Plannacionalp();
        a = buscarPlanN(as_codigo);
        plann.remove(a);
        return "fue eliminado correctamente";
    }

    ////////////////////MODIFICAR PLAN////////
    public String modificarPlanN(String as_codigo, String tipo, String titulo, String des, String vi, String mi, Date fechaI, Date fechaF) {
        Plannacionalp a = new Plannacionalp();
        a = buscarPlanN(as_codigo);
        a.setPlanTipo(tipo);
        a.setPlanNombre(titulo);
        a.setPlanDescripcion(des);
        a.setPlanVision(vi);
        a.setPlanMision(mi);
        a.setPlanFechai(fechaI);
        a.setPlanFechaf(fechaF);
        plann.edit(a);
        return a.getPlanCodigo();
    }

    public List<Plannacionalp> obtenerPlanN() {
        List listaN = new ArrayList();
        listaN = plann.findAll();
        return listaN;
    }

    //////////////////////////////INDICADORES Modificacion////
    public String insertarIndicadore(String obj, String des, Date fechaI) {
        Indicadoresp a = new Indicadoresp();
        a.setIndObjetivo(obj);
        a.setIndDescripcion(des);
       // a.setIndFechai(DeStringADate(fechaI));
        a.setIndFechai(fechaI);

        indicadores.create(a);
        return a.getIndCodigo();
    }

    //////////////////ELIMINAR INDICADORES/////////
    public Indicadoresp buscarIndicadores(String as_codigo) {
        Indicadoresp a = new Indicadoresp();
        a = indicadores.find(as_codigo);
        return a;
    }

    public String EliminarIndicadores(String as_codigo) {
        Indicadoresp a = new Indicadoresp();
        a = buscarIndicadores(as_codigo);
        indicadores.remove(a);
        return "fue eliminado correctamente";
    }

    ////////////////////MODIFICAR Indicadores////////
    public String ModificarIndicadores(String as_codigo, String obj, String des, Date fechaI) {
        Indicadoresp a = new Indicadoresp();
        a = buscarIndicadores(as_codigo);
        a.setIndObjetivo(obj);
        a.setIndDescripcion(des);
        a.setIndFechai(fechaI);
        indicadores.edit(a);
        return a.getIndCodigo();
    }

    public List<Indicadoresp> obtenerIn() {
        List listaN = new ArrayList();
        listaN = indicadores.findAll();
        return listaN;
    }
    
    public List<Objetivoind> obtenerIn1() {
        List listaN = new ArrayList();
        listaN = objInd.findAll();
        return listaN;
    }

    //////////objetivo - indicador//////
    public String insertarObjInd(String obj, String ind,String nombre, int por) {
        Objetivoind a = new Objetivoind();
        a.setObjiObjetivo(obj);
        a.setObjiIndicador(ind);
        a.setObjiNomplan(nombre);
        a.setObjiPorcentaje(por);
        objInd.create(a);
        return a.getObjiCodigo();
    }
    public Objetivoind buscarIO(String as_codigo)
    {
        Objetivoind a= new Objetivoind();
        a=objInd.find(as_codigo);
        return a;                
    }
    public String eliminarIO(String as_codigo)
    {
         Objetivoind a= new Objetivoind();
         a=buscarIO(as_codigo);
         objInd.remove(a);
         return "fue eliminado correctamente";                  
    }
    
//      public String modificarIO(String as_codigo, String obj, String ind, String nombre, int port) {
//        Objetivoind  a = new Objetivoind ();
//        a = buscarIO(as_codigo);
//        a.setObjiObjetivo(obj);
//        a.setObjiIndicador(ind);
//        a.setObjiNomplan(nombre);
//        a.setObjiPorcentaje(port);
//        objInd.edit(a);
//        return a.getObjiCodigo();
//    }
    
     public String modificarIO(String as_codigo, int port) {
        Objetivoind  a = new Objetivoind ();
        a = buscarIO(as_codigo);
        a.setObjiPorcentaje(port);
        objInd.edit(a);
        return a.getObjiCodigo();
    }
    
   
    ///////////ALINEAR///
    
     public String insertarAli(String espe, String nacional, String operativo) {
        Alinearp a = new Alinearp();
        a.setAliEspe(espe);
        a.setAliNacional(nacional);
        a.setAliOperativo(operativo);
        alinear.create(a);
        return a.getAliCodigo();
    }
      public List<Alinearp> obtenerAlinear() {
        List listaN = new ArrayList();
        listaN = alinear.findAll();
        return listaN;
    }
//      public Objetivoind buscarObjInd(String as_codigo) {
//        Objetivoind a = new Objetivoind();
//        a = objInd.find(as_codigo);
//        return a;
//    }
//
//    public String EliminarObjInd(String as_codigo) {
//        Objetivoind a = new Objetivoind();
//        a = buscarObjInd(as_codigo);
//        objInd.remove(a);
//        return "fue eliminado correctamente";
//    }

}
