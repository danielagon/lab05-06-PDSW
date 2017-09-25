/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.managebeans;


import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author 2106913
 */
@ManagedBean(name = "HistorialPacientes")
@SessionScoped
public class RegistroConsultaBean implements Serializable {
    private String nombre;
    private String tipoId;
    private int id;
    private String eps;
    private List<String> epsNombres;
    private Date fechaNac;
    private List<Eps> epsRegistradas;
    private final ServiciosPacientes servicepacientes = ServiciosHistorialPacientesFactory.getInstance().getServiciosPaciente();
    
    public void registrarPaciente() throws ExcepcionServiciosPacientes{
        int posicion=0;
        for (int i=0; i<epsRegistradas.size();i++){
            if (epsRegistradas.get(i).getNombre().equals(eps)){
                posicion=i;
            }
        }
        try{
            System.out.println(servicepacientes.consultarPacientes().size());
            servicepacientes.registrarNuevoPaciente(new Paciente(id,tipoId,nombre,fechaNac,epsRegistradas.get(posicion)));
            System.out.println(servicepacientes.consultarPacientes().size());
        }catch(ExcepcionServiciosPacientes e){
            
        }
        
    }
    
    public List<String> getEpsNombres() {
        return epsNombres;
    }

    public void setEpsNombres(List<String> epsNombres) {
        this.epsNombres = epsNombres;
    }
    
    public List<Eps> getEpsRegistradas() {
        return epsRegistradas;
    }

    public void setEpsRegistradas(List<Eps> epsRegistradas) {
        this.epsRegistradas = epsRegistradas;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoId() {
        return tipoId;
    }

    public void setTipoId(String tipoId) {
        this.tipoId = tipoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }
    

    

    

    public RegistroConsultaBean() {
        try{
            epsRegistradas=servicepacientes.obtenerEPSsRegistradas();
        }catch (ExcepcionServiciosPacientes e){
            
        }
        epsNombres=new ArrayList<String>();
        for (Eps i:epsRegistradas){
            
            epsNombres.add(i.getNombre());
        }
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


}
