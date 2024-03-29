package BeanPediEspe;

import Servidor.EspePlanService;
import Servidor.Plannacionalp;
import Servidor.Planpedip;
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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
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
public class BeanPlanEspe implements Serializable {

    private EspePlanService service = new EspePlanService();
    Servidor.EspePlan port = service.getEspePlanPort();

    @ManagedProperty(value="#{beanLogin}")
    private BeanLogin beanLogin = new BeanLogin();       
    ///////////////
    List<Tipoplan> listap;
    List<Planpedip> listac;
    String codigo;
    String titulo;
    String descripcion;
    String mision;
    String vision;
    String convert;
    String convert1;
    Date fechaI;
    Date fechaF;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public BeanLogin getBeanLogin() {
        return beanLogin;
    }

    public void setBeanLogin(BeanLogin beanLogin) {
        this.beanLogin = beanLogin;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    } 
     String tipoPlan;
    Planpedip plan = new Planpedip();

    public List<Tipoplan> getListap() {
        return port.obtenerTipoPlan();
    }

    public void setListap(List<Tipoplan> listap) {
        this.listap = listap;
    }

    public List<Planpedip> getListac() {
         List<Planpedip> planes = port.obtenerPlan();
         List<Tipoplan> tipoPlan = port.obtenerTipoPlan();
         
         for(Planpedip plan1 : planes){
             for(Tipoplan tipoPlan1 : tipoPlan)
             {
                 if(plan1.getPlaTipo().equals(tipoPlan1.getTipCodigo())){
                     plan1.setPlaTipo(tipoPlan1.getTipTipo());
                     break;
                 }
             }
             
         }        
        return planes;
    }

    public void setListac(List<Planpedip> listac) {
        this.listac = listac;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
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

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }

    public Planpedip getPlan() {
        return plan;
    }

    public void setPlan(Planpedip plan) {
        this.plan = plan;
    }

    /////////////
    public void click() {
        RequestContext requestContext = RequestContext.getCurrentInstance();

        requestContext.update("form:display");
        requestContext.execute("PF('dlg').show()");
    }
///////////////////////////////////
      public void editarPlan(Planpedip indi){
          codigo = indi.getPlaCodigo();
           List<Tipoplan> tempTipo = port.obtenerTipoPlan();
          for (Tipoplan tempTipo1 : tempTipo) {
              if (tempTipo1.getTipTipo().equals(indi.getPlaTipo())) {
                  tipoPlan = tempTipo1.getTipCodigo();
                  break;
              }
          }
          titulo = indi.getPlaNombre();
          descripcion = indi.getPlaDescripcion();
          mision = indi.getPlaMision();
          vision = indi.getPlaVision();
          fechaI = indi.getPlaFechai().toGregorianCalendar().getTime();
          fechaF = indi.getPlaFechaf().toGregorianCalendar().getTime();
        
    }
    //////INSERTAR PLAN///
    public void insertarPlan() throws DatatypeConfigurationException {
        try {
            //        System.out.println("hola jj");
//        DateFormat fecha1 = new SimpleDateFormat("dd-MMM-yy");
//        convert = fecha1.format(fechaI);
//        convert1 = fecha1.format(fechaF);
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(fechaI);
            XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            
            GregorianCalendar d = new GregorianCalendar();
            d.setTime(fechaF);
            XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(d);
            
            port.insertar(tipoPlan, titulo, descripcion, mision, vision, date2, date1);
            ///AUDITORIA
            
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
            
            port.insertarAuditoria(beanLogin.getUser(),"Se Inserto un plan Espe-> Titulo:"+titulo, "Registro Planes", fechaCreacion);
            //auditoria
            
            this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    ///////////////////
    public void eliminarPlan(String s) throws DatatypeConfigurationException  {
       
        try {
         port.eliminarPlan(s);
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
          
            port.insertarAuditoria(beanLogin.getUser(),"Se Elimino un Plan Espe", "Visualizar Planes", fechaCreacion);
           
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
    }

    ////////////////////
    public void modificarPlan() throws DatatypeConfigurationException {
//        GregorianCalendar c = new GregorianCalendar();
//        c.setTime(fechaI);
//        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
//        
//        GregorianCalendar d = new GregorianCalendar();
//        d.setTime(fechaF);
//        XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(d);
//        
//        port.modificarPlan(codigo, tipoPlan,titulo, descripcion, vision, mision, date2, date1);
        /////////////////////////////////////
        try {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(fechaI);
        XMLGregorianCalendar date2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
        
        GregorianCalendar d = new GregorianCalendar();
        d.setTime(fechaF);
        XMLGregorianCalendar date1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(d);
        
        port.modificarPlan(codigo, tipoPlan,titulo, descripcion, vision, mision, date2, date1);
        
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
            
            port.insertarAuditoria(beanLogin.getUser(),"Se Modifico un Plan Espe-> Titulo:"+titulo,"Visualizar Planes", fechaCreacion);
           
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

////////////////////   
    public void limpiar() {
        this.setTipoPlan("");
        this.setTitulo("");
        this.setDescripcion("");
        this.setMision("");
        this.setVision("");
        this.setFechaI(null);
        this.setFechaF(null);
    }
}
