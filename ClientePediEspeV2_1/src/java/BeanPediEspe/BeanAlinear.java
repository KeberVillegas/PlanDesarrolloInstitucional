/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BeanPediEspe;

import Servidor.Alinearp;
import Servidor.EspePlanService;
import Servidor.Objetivosexternos;
import Servidor.Plannacionalp;
import Servidor.Planpedip;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author Kleber
 */
@ManagedBean
@ViewScoped
public class BeanAlinear implements Serializable {

    private EspePlanService service = new EspePlanService();
    Servidor.EspePlan port = service.getEspePlanPort();
   // @ManagedProperty(value="#{beanLogin}")
    BeanLogin beanLogin = new BeanLogin();
    List<Objetivosexternos> objetivosPlanNacional;
    String objetivosPlanNacionalSelect, objetivoPlanOperacionalSelect, objetivoPlanEstrategicoSelect;
    Collection<Planpedip> tiposObjetivosPlanEspe;
    List<Objetivosexternos> objetivosPlanEstrategico;
    List<Objetivosexternos> objetivosPlanOperacional;
    List<Planpedip> objTipos;
    Objetivosexternos temp;
    List<ArbolFamilia> familia;
    static final String PLAN_ESTRATEGICO = "21";
    static final String PLAN_OPERACIONAL = "22";
    XMLGregorianCalendar fecha2 =new XMLGregorianCalendarImpl();
    /**
     * Creates a new instance of BeanAlinear
     */
    public BeanAlinear() {
    }

    @PostConstruct
    public void init() {
        //Generador de arbol
       familia = new ArrayList<>();
        
//        Obtiene los objetivos pertenecientes al Plan Nacional
        objetivosPlanNacional = port.obtenerObj();
        
        List<Plannacionalp> pl = port.obtenerPlanN();
        Iterator it = objetivosPlanNacional.iterator();
        while (it.hasNext()) {
            Objetivosexternos obje = (Objetivosexternos) it.next();
            boolean encontrado = false;

            for (Plannacionalp elem : pl) {
                if ((obje.getObjNombre().equals(elem.getPlanCodigo()))) {
                    encontrado = true;
                    break;
                }
              
            }
            if (!encontrado) {
                it.remove();
            }
        }
        /////////////////////////////////
       
//        Obtiene los tipos de Objetivo del Plan ESPE
        tiposObjetivosPlanEspe = port.obtenerPlan();

//        Tabla con la jerarquia de objetivos-nombres de objetivos
        List<Objetivosexternos> codigoXDescp = port.obtenerObj();
        //Codigos de la relaciones.
        List<Alinearp> objetivoToObjetivo = port.obtenerAli();
        

//        objetivos nacionales sin repeticion
        List listaLimpia = new ArrayList();

        Map<String, Alinearp> mapObjetivoToObjetivo = new HashMap<>();

        for (Alinearp x : objetivoToObjetivo) {
            mapObjetivoToObjetivo.put(x.getAliNacional(), x);
        }

        System.out.println("Lista sin repetidos:");
        for (Entry<String, Alinearp> p : mapObjetivoToObjetivo.entrySet()) {
            listaLimpia.add(p.getValue().getAliNacional());
            System.out.println(p.getValue().getAliNacional());
        }
               
        for (Object listaLimpia1 : listaLimpia) {
            List objetivoNacional = new ArrayList();
            boolean encontradoP2=false;
            ArbolFamilia abuelo = new ArbolFamilia(1,listaLimpia1.toString(), null);
            Collection<ArbolFamilia> tempFamilia = new ArrayList<>();
            for (Alinearp x : objetivoToObjetivo) {            
                 
                     if (x.getAliNacional().equals(listaLimpia1.toString())) {
                         
                         for(Object a: objetivoNacional){
                             if(a.equals(x.getAliEspe())){
                                 encontradoP2=true;
                             }
                         }
                         if(!encontradoP2){
                              objetivoNacional.add(x.getAliEspe());
                              ArbolFamilia padreToAbuelo = new ArbolFamilia(2,x.getAliEspe(),abuelo);
                              tempFamilia.add(padreToAbuelo);
                              System.out.println(listaLimpia1.toString());
                         }                      
                    }                       
            }

           abuelo.setArbolFamilia(tempFamilia);
           familia.add(abuelo);

        }
       
        
        for(ArbolFamilia abuelo1: familia){         
            for(ArbolFamilia padre1 : abuelo1.getArbolFamilia()){
                Collection<ArbolFamilia> tempFamiliaPadre = new ArrayList<>();
                for(Alinearp x : objetivoToObjetivo){
                    if(x.getAliNacional().equals(abuelo1.getDescripcion())&& x.getAliEspe().equals(padre1.getDescripcion())){
                         ArbolFamilia hijoToPadre = new ArbolFamilia(3,x.getAliOperativo(),padre1);
                         tempFamiliaPadre.add(hijoToPadre);
                    }
                }
                
                padre1.setArbolFamilia(tempFamiliaPadre);
                
            }
         }
            
        //Descripciones
        for (ArbolFamilia abuelo : familia) {

            for (Objetivosexternos codigoXDescp1 : codigoXDescp) {
                if (codigoXDescp1.getObjCodigo().equals(abuelo.getDescripcion())) {
                    abuelo.setDescripcion(codigoXDescp1.getObjTitulo());
                    break;
                }

            }

            for (ArbolFamilia padre : abuelo.getArbolFamilia()) {
                for (Objetivosexternos codigoXDescp1 : codigoXDescp) {
                    if (codigoXDescp1.getObjCodigo().equals(padre.getDescripcion())) {
                        padre.setDescripcion(codigoXDescp1.getObjTitulo());
                        break;
                    }

                }

                for (ArbolFamilia hijo : padre.getArbolFamilia()) {
                    for (Objetivosexternos codigoXDescp1 : codigoXDescp) {
                        if (codigoXDescp1.getObjCodigo().equals(hijo.getDescripcion())) {
                            hijo.setDescripcion(codigoXDescp1.getObjTitulo());
                            break;
                        }

                    }
                }
            }

        }
         //Estrategico
        obtenerObjetivosPlanEstrategico();
        //Operacional
        obtenerObjetivosPlanOperacional();
       
        
    }

    public void obtenerDescripcion(){
        
        for(Objetivosexternos m : this.objetivosPlanNacional){
            if(m.getObjCodigo().equals(objetivosPlanNacionalSelect)){
                temp = m;
                break;
            }
        }
        
    }
    
    public void guardarObjetivoObjetivo() throws DatatypeConfigurationException{
         
        
   ///////     
               try {
  List<Alinearp> objetivoToObjetivo = port.obtenerAli();
        boolean comprobar = false;
        for(Alinearp chequea : objetivoToObjetivo){
            if(chequea.getAliNacional().equals(objetivosPlanNacionalSelect)&& chequea.getAliEspe().equals(objetivoPlanEstrategicoSelect)&& 
                    chequea.getAliOperativo().equals(objetivoPlanOperacionalSelect)){
               comprobar = true;
               break;
            }
        }
        if(!comprobar){
             port.insertarAlinear(objetivoPlanEstrategicoSelect, objetivosPlanNacionalSelect,objetivoPlanOperacionalSelect);
             //port.insertarAuditoria(beanLogin.getUser(),"Se Inserto un plan Espe", "Registro Planes",fecha2);
         
             this.init();
             limpiar();
            
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Ya existe un registro para el item seleccionado"));
        }
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
            
            port.insertarAuditoria(beanLogin.getUser(),"Se Inserto una Alineacion de Objetivos:", "Registro Objetivo - Objetivo", fechaCreacion);
            //auditoria
            
            this.limpiar();
        } catch (ParseException ex) {
            Logger.getLogger(BeanPlanEspe.class.getName()).log(Level.SEVERE, null, ex);
        }
   ////////          
    }

    public Objetivosexternos getTemp() {
        return temp;
    }

    public void setTemp(Objetivosexternos temp) {
        this.temp = temp;
    }

    public void limpiar() {
        this.setObjetivoPlanOperacionalSelect("");
        this.setObjetivosPlanNacionalSelect("");
        this.setObjetivoPlanEstrategicoSelect("");

    }

    public void obtenerObjetivosPlanEstrategico() {
             
        List<Planpedip> planes = port.obtenerPlan();
        Iterator it = planes.iterator();
        while (it.hasNext()) {
            Planpedip obje = (Planpedip) it.next();
            boolean encontrado = false;

            if (obje.getPlaTipo().equals(BeanAlinear.PLAN_ESTRATEGICO)) {
               encontrado = true;
                //break;
            }  
            if (!encontrado) {

                it.remove();
            }         
        }
      
       
        
        objetivosPlanEstrategico = port.obtenerObj();
        Iterator it2 = objetivosPlanEstrategico.iterator();

        while (it2.hasNext()) {

            Objetivosexternos obje = (Objetivosexternos) it2.next();
            //Planpedip obj = (Planpedip)it.next();
            boolean encontrado = false;
           // System.out.print("combo "+obje.getObjNombre());
            for(Planpedip planes1 : planes){
                if (obje.getObjNombre().equals(planes1.getPlaCodigo())) {
                    encontrado = true;
                     //break;
                }
            }

            if (!encontrado) {
                it2.remove();
            }
        }
      
        

     
    }
    
     public void obtenerObjetivosPlanOperacional() {
        
        List<Planpedip> planes = port.obtenerPlan();
        Iterator it = planes.iterator();
        while (it.hasNext()) {
            Planpedip obje = (Planpedip) it.next();
            boolean encontrado = false;

            if (obje.getPlaTipo().equals(BeanAlinear.PLAN_OPERACIONAL)) {
               encontrado = true;
                //break;
            }  
            if (!encontrado) {
                it.remove();
            }         
        }
        
        objetivosPlanOperacional = port.obtenerObj();
        Iterator it2 = objetivosPlanOperacional.iterator();

        while (it2.hasNext()) {

            Objetivosexternos obje = (Objetivosexternos) it2.next();
            boolean encontrado = false;
           
            for (Planpedip planes1 : planes) {
                 if (planes1.getPlaCodigo().equals(obje.getObjNombre())) {
                    encontrado = true;
                    //break;
                }
            }
           
            if (!encontrado) {
                it2.remove();
            }
        }
    }

    public String getObjetivoPlanEstrategicoSelect() {
        return objetivoPlanEstrategicoSelect;
    }

    public void setObjetivoPlanEstrategicoSelect(String objetivoPlanEstrategicoSelect) {
        this.objetivoPlanEstrategicoSelect = objetivoPlanEstrategicoSelect;
    }

    public List<Objetivosexternos> getObjetivosPlanOperacional() {
        return objetivosPlanOperacional;
    }

    public void setObjetivosPlanOperacional(List<Objetivosexternos> objetivosPlanOperacional) {
        this.objetivosPlanOperacional = objetivosPlanOperacional;
    }
    
    public List<Objetivosexternos> getObjetivosPlanEstrategico() {
            return objetivosPlanEstrategico;
        //return port.obtenerObj();
    }

    public void setObjetivosPlanEstrategico(List<Objetivosexternos> objetivosPlanEstrategico) {
        this.objetivosPlanEstrategico = objetivosPlanEstrategico;
    }

    public String getObjetivosPlanNacionalSelect() {
        return objetivosPlanNacionalSelect;
    }

    public void setObjetivosPlanNacionalSelect(String objetivosPlanNacionalSelect) {
        this.objetivosPlanNacionalSelect = objetivosPlanNacionalSelect;
    }

    public List<Objetivosexternos> getObjetivosPlanNacional() {
        return objetivosPlanNacional;
    }

    public void setObjetivosPlanNacional(List<Objetivosexternos> objetivosPlanNacional) {
        this.objetivosPlanNacional = objetivosPlanNacional;
    }

    public Collection<Planpedip> getTiposObjetivosPlanEspe() {
        return tiposObjetivosPlanEspe;
    }

    public void setTiposObjetivosPlanEspe(Collection<Planpedip> tiposObjetivosPlanEspe) {
        this.tiposObjetivosPlanEspe = tiposObjetivosPlanEspe;
    }

    public String getObjetivoPlanOperacionalSelect() {
        return objetivoPlanOperacionalSelect;
    }

    public void setObjetivoPlanOperacionalSelect(String objetivoPlanOperacionalSelect) {
        this.objetivoPlanOperacionalSelect = objetivoPlanOperacionalSelect;
    }

    public List<ArbolFamilia> getFamilia() {
        return familia;
    }

    public void setFamilia(List<ArbolFamilia> familia) {
        this.familia = familia;
    }

   

}
