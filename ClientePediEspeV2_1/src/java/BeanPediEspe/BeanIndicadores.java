/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPediEspe;

import Servidor.EspePlanService;
import Servidor.Indicadoresp;
import Servidor.Objetivosexternos;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Kleber
 */
@ManagedBean
@ViewScoped
public class BeanIndicadores implements Serializable {

    private EspePlanService service = new EspePlanService();
    Servidor.EspePlan port = service.getEspePlanPort();
    
   @ManagedProperty(value="#{beanLogin}")
    private BeanLogin beanLogin = new BeanLogin();     
   
    
    String indicadorId;
    String obj;
    String des;
    Date fecha = new Date();
    XMLGregorianCalendar fecha2;
    String convertFecha;
    List<Objetivosexternos> listaObj;
    List<Indicadoresp> listaI;
    Date fechaActual = new Date();
    Indicadoresp ind = new Indicadoresp();
/////////////////////////////

    public BeanLogin getBeanLogin() {
        return beanLogin;
    }

    public void setBeanLogin(BeanLogin beanLogin) {
        this.beanLogin = beanLogin;
    }

    public XMLGregorianCalendar getFecha2() {
        return fecha2;
    }

    public void setFecha2(XMLGregorianCalendar fecha2) {
        this.fecha2 = fecha2;
    }
    
   
    //////////////////////////////
    public Indicadoresp getInd() {
        return ind;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }
    
    public void setInd(Indicadoresp ind) {
        this.ind = ind;
    }

    public String getObj() {
        return obj;
    }

    public void setObj(String obj) {
        this.obj = obj;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public List<Objetivosexternos> getListaObj() {
        return port.obtenerObj();
    }

    public void setListaObj(List<Objetivosexternos> listaObj) {
        this.listaObj = listaObj;
    }

    public List<Indicadoresp> getListaI() {
        return port.obtenerI();
    }

    public void setListaI(List<Indicadoresp> listaI) {
        this.listaI = listaI;
    }

    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    //////////////////////////////////////////////////////
    public void insertarI() throws DatatypeConfigurationException {
    
         try {
        DateFormat fecha1 = new SimpleDateFormat("dd-MMM-yy");
        convertFecha = fecha1.format(fecha);
        
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fecha);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);

        port.insertarIndicadores(obj, des,  date2);
        
        ///////////////////////////////
         DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String a = hourdateFormat.format(beanLogin.getFecha());
            Date nuevo = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String stringFechaConHora = a;
            Date fechaConHora = sdf.parse(stringFechaConHora);
            
            GregorianCalendar fechaCreacion1 = new GregorianCalendar();
            fechaCreacion1.setTime(fechaConHora);
            
            GregorianCalendar cal = new GregorianCalendar(); cal.setTime(beanLogin.getFecha());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), 0);
            XMLGregorianCalendar xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), 0);
            
            XMLGregorianCalendar fechaCreacion = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaCreacion1);
            System.out.println("Hora y fecha de creacion: "+fechaCreacion);
            Calendar fecha = new GregorianCalendar();
            
           port.insertarAuditoria(beanLogin.getUser(),"Se Inserto un Indicador-> Nombre Indicador:"+obj,"Indicadores de Objetivos", fechaCreacion);
           this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }     

    }

    public void eliminarI(String s) throws DatatypeConfigurationException {
     
        
           try {
             port.eliminarIndicadores(s);
        ///////////////////////////////
            DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String a = hourdateFormat.format(beanLogin.getFecha());
            Date nuevo = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String stringFechaConHora = a;
            Date fechaConHora = sdf.parse(stringFechaConHora);
            
            GregorianCalendar fechaCreacion1 = new GregorianCalendar();
            fechaCreacion1.setTime(fechaConHora);
            
            GregorianCalendar cal = new GregorianCalendar(); cal.setTime(beanLogin.getFecha());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), 0);
            XMLGregorianCalendar xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), 0);
            
            XMLGregorianCalendar fechaCreacion = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaCreacion1);
            System.out.println("Hora y fecha de creacion: "+fechaCreacion);
            Calendar fecha = new GregorianCalendar();
            
           port.insertarAuditoria(beanLogin.getUser(),"Se Elimino un Indicador","Indicadores de Objetivos", fechaCreacion);
           this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }     
        
    }
    
    public void editarIndicador(Indicadoresp indi){
        indicadorId = indi.getIndCodigo();
        obj = indi.getIndObjetivo();
        des = indi.getIndDescripcion();
        fecha = indi.getIndFechai().toGregorianCalendar().getTime();
        
    }

    public String getIndicadorId() {
        return indicadorId;
    }

    public void setIndicadorId(String indicadorId) {
        this.indicadorId = indicadorId;
    }
    
    public void modificarI() throws DatatypeConfigurationException {
           try {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaActual);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        port.modificarIndicadores(indicadorId, obj,des ,date2);
        
        ///////////////////////////////
            DateFormat hourdateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String a = hourdateFormat.format(beanLogin.getFecha());
            Date nuevo = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            String stringFechaConHora = a;
            Date fechaConHora = sdf.parse(stringFechaConHora);
            
            GregorianCalendar fechaCreacion1 = new GregorianCalendar();
            fechaCreacion1.setTime(fechaConHora);
            
            GregorianCalendar cal = new GregorianCalendar(); cal.setTime(beanLogin.getFecha());
            XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), 0);
            XMLGregorianCalendar xmlTime = DatatypeFactory.newInstance().newXMLGregorianCalendarTime(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), cal.get(Calendar.SECOND), 0);
            
            XMLGregorianCalendar fechaCreacion = DatatypeFactory.newInstance().newXMLGregorianCalendar(fechaCreacion1);
            System.out.println("Hora y fecha de creacion: "+fechaCreacion);
            Calendar fecha = new GregorianCalendar();
            
           port.insertarAuditoria(beanLogin.getUser(),"Se Modifico Indicador-> Nombre Indicador:"+obj,"Indicadores de Objetivos", fechaCreacion);
           this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }     
       
    }

    public void limpiar() {
        this.setObj("");
        this.setDes("");
       // this.setFecha(null);
    }
}
