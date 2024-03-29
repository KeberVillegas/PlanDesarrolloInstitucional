/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPediEspe;

import Servidor.EspePlanService;
import Servidor.Plannacionalp;
import Servidor.Tipoplan;
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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
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
public class BeanPlanNacional implements Serializable {

    private EspePlanService service = new EspePlanService();
    Servidor.EspePlan port = service.getEspePlanPort();
    
    @ManagedProperty(value="#{beanLogin}")
    private BeanLogin beanLogin = new BeanLogin();       
    ///////////////
    Plannacionalp plan = new Plannacionalp();
    String tipoPlan;
    List<Tipoplan> listap;
    List<Plannacionalp> listac;
    List<Plannacionalp> listan;
    String codigo;
    String tituloN;
    String descripcionN;
    String misionN;
    String visionN;
    String convertN;
    String convert1N;
    Date fechaI;
    Date fechaF;

    public BeanLogin getBeanLogin() {
        return beanLogin;
    }

    public void setBeanLogin(BeanLogin beanLogin) {
        this.beanLogin = beanLogin;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Plannacionalp> getListan() {
        return port.obtenerPlanN();
    }

    public void setListan(List<Plannacionalp> listan) {
        this.listan = listan;
    }

    public String getMisionN() {
        return misionN;
    }

    public void setMisionN(String misionN) {
        this.misionN = misionN;
    }

    public Plannacionalp getPlan() {
        return plan;
    }

    public void setPlan(Plannacionalp plan) {
        this.plan = plan;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public List<Tipoplan> getListap() {
        return port.obtenerTipoPlan();
    }

    public void setListap(List<Tipoplan> listap) {
        this.listap = listap;
    }

    public List<Plannacionalp> getListac() {
        return listac;
    }

    public void setListac(List<Plannacionalp> listac) {
        this.listac = listac;
    }

    public String getTituloN() {
        return tituloN;
    }

    public void setTituloN(String tituloN) {
        this.tituloN = tituloN;
    }

    public String getDescripcionN() {
        return descripcionN;
    }

    public void setDescripcionN(String descripcionnN) {
        this.descripcionN = descripcionnN;
    }

    public String getVisionN() {
        return visionN;
    }

    public void setVisionN(String visionN) {
        this.visionN = visionN;
    }

    public String getConvertN() {
        return convertN;
    }

    public void setConvertN(String convertN) {
        this.convertN = convertN;
    }

    public String getConvert1N() {
        return convert1N;
    }

    public void setConvert1N(String convert1N) {
        this.convert1N = convert1N;
    }

    public Date getFechaI() {
        return fechaI;
    }

    public void setFechaI(Date fechaI) {
        this.fechaI = fechaI;
    }

    public Date getFechaF() {
        return fechaF;
    }

    public void setFechaF(Date fechaF) {
        this.fechaF = fechaF;
    }

    /////////////
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }

    //////INSERTAR PLAN///
    public void insertarPlanN() throws DatatypeConfigurationException {
//        System.out.println("hola jj");
//        DateFormat fecha1 = new SimpleDateFormat("dd-MMM-yy");
//        convertN = fecha1.format(fechaI);
//        convert1N = fecha1.format(fechaF);GregorianCalendar c = new GregorianCalendar();     
             try {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaI);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);      
        c.setTime(fechaF);
        XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        port.insertarPlanN(tipoPlan, tituloN, descripcionN, misionN, visionN, date2, date1);
    
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
            
            port.insertarAuditoria(beanLogin.getUser(),"Se Inserto un Plan Nacional-> Tipo:"+tipoPlan+" Titulo:"+tituloN,"Registro Plan Nacional", fechaCreacion);
            this.limpiar();
           
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }

    ///////////////////
    public void eliminarPlanN(String s) throws DatatypeConfigurationException {
      
         try {
               port.eliminarPlanN(s);
       
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
          
            port.insertarAuditoria(beanLogin.getUser(),"Se Elimino un Plan Nacional", "Visualizar Planes", fechaCreacion);
           
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    ////////////////////
     public void editarPlanN(Plannacionalp indi){
        codigo = indi.getPlanCodigo();
        tipoPlan=indi.getPlanTipo();
        tituloN = indi.getPlanNombre();
        descripcionN= indi.getPlanDescripcion();
        misionN=indi.getPlanMision();
        visionN=indi.getPlanVision();
        fechaI = indi.getPlanFechai().toGregorianCalendar().getTime();
        fechaF = indi.getPlanFechaf().toGregorianCalendar().getTime();
        
    }

    ////////////////////
    public void modificarPlanN() throws DatatypeConfigurationException {
        
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaI);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);       
        c.setTime(fechaF);
        XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        port.modificarPlanN(codigo, tipoPlan, tituloN, descripcionN, visionN, misionN, date1, date1);  
    }

    public void limpiar() {
        this.setTipoPlan("");
        this.setTituloN("");
        this.setDescripcionN("");
        this.setMisionN("");
        this.setVisionN("");
        this.setFechaI(null);
        this.setFechaF(null);
    }
}
