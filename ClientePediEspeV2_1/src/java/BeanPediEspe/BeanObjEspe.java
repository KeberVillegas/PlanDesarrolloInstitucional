package BeanPediEspe;

import Servidor.EspePlanService;
import Servidor.Objetivosexternos;
import Servidor.Plannacionalp;
import Servidor.Planpedip;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
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

public class BeanObjEspe implements Serializable {

    private EspePlanService service = new EspePlanService();
    Servidor.EspePlan port = service.getEspePlanPort();
    
    @ManagedProperty(value="#{beanLogin}")
    private BeanLogin beanLogin = new BeanLogin();       
    
    String codigo;
    String descp;
    String tit;
    Date fecha = new Date();
    Date fechaMod = new Date();
    String convertFecha;

    List<Planpedip> listac;
    List<Objetivosexternos> listad;
    List<Plannacionalp> listaN;
    List<String> listg = new ArrayList<String>();
    String tipo1;
    List<Plannacionalp> c;

    Objetivosexternos obj = new Objetivosexternos();
    ////////////////////////

    public BeanLogin getBeanLogin() {
        return beanLogin;
    }

    public void setBeanLogin(BeanLogin beanLogin) {
        this.beanLogin = beanLogin;
    }

///////////////////
    @PostConstruct
    public void init() {

        List<Objetivosexternos> i = new ArrayList<>();

        c = new ArrayList<>();

        listaN = port.obtenerPlanN();
        listac = port.obtenerPlan();

        for (Planpedip elem : listac) {
            Plannacionalp x = new Plannacionalp();
            x.setPlanCodigo(elem.getPlaCodigo());
            x.setPlanNombre(elem.getPlaNombre());
            c.add(x);

        }
        for (Plannacionalp c1 : listaN) {
            Plannacionalp x = new Plannacionalp();
            x.setPlanCodigo(c1.getPlanCodigo());
            x.setPlanNombre(c1.getPlanNombre());
            c.add(x);
        }

    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }
    
    public List<Plannacionalp> getC() {
        return c;
    }

    public void setC(List<Plannacionalp> c) {
        this.c = c;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Objetivosexternos getObj() {
        return obj;
    }

    public void setObj(Objetivosexternos obj) {
        this.obj = obj;
    }

    public String getTit() {
        return tit;
    }

    public void setTit(String tit) {
        this.tit = tit;
    }

    public List<Objetivosexternos> getListad() {
  
        List<Objetivosexternos> d = port.obtenerObj();
        for (Objetivosexternos d1 : d) {

            for (Planpedip elem : listac) {
                if (elem.getPlaCodigo().equals(d1.getObjNombre())) {
                    d1.setObjNombre(elem.getPlaNombre());
                    break;
                }
            }

            for (Plannacionalp c1 : listaN) {
                if (c1.getPlanCodigo().equals(d1.getObjNombre())) {
                    d1.setObjNombre(c1.getPlanNombre());
                    break;
                }

            }

        }

        return d;
    }

    public void setListad(List<Objetivosexternos> listad) {
        this.listad = listad;
    }

    public List<Planpedip> getListac() {
        return listac;
    }

    public void setListac(List<Planpedip> listac) {
        this.listac = listac;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    ///////////////////////////////////////////////////////////
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    ///////////////
    public void editarObjetivo(Objetivosexternos indi) {
        codigo = indi.getObjCodigo();
        tipo1 = indi.getObjNombre();
        tit = indi.getObjTitulo();
        descp = indi.getObjDescripcion();
        fecha = indi.getObjFecha().toGregorianCalendar().getTime();

    }

    //////////////////////////////////////////////////////
    public void insertarObj() throws DatatypeConfigurationException {
//        DateFormat fecha1 = new SimpleDateFormat("dd-MMM-yy");
//        convertFecha = fecha1.format(fecha);     
        try {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fecha);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        port.insertarObj(tipo1, tit, descp, date2);
        
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
            
           port.insertarAuditoria(beanLogin.getUser(),"Se Inserto un Objetivo-> Nombre Plan:"+tipo1+" Nombre:"+tit,"Objetivos del Plan", fechaCreacion);
           this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

    ////////////////////////////////////////////
    public void eliminarObj(String s) throws DatatypeConfigurationException {
     
              try {
           port.eliminarObj(s);
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
            
           port.insertarAuditoria(beanLogin.getUser(),"Se Elimino un Objetivo","Visualizar Objetivos", fechaCreacion);
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }     
        

    }

    public void modificarObj() throws DatatypeConfigurationException {
     
          try {
      
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaMod);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        port.modificarObj(codigo, tipo1, tit, descp, date2);
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
            
           port.insertarAuditoria(beanLogin.getUser(),"Se Modifico un Objetivo-> Nombre Plan:"+tipo1+" Nombre:"+tit,"Visualizar Objetivos", fechaCreacion);
           this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }

    public void limpiar() {
        this.setTipo1("");
        this.setTit("");
        this.setDescp("");
       // this.setFecha(null);
    }

}
