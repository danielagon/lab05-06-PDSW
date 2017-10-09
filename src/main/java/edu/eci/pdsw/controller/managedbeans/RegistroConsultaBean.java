/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.controller.managedbeans;


import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;

import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
    private Date fechayHora;
    private String resumen;
    private long costo;
    private List<Paciente> pacientes;
    private Paciente pacienteSeleccionado;
    private Set<Consulta> consultas;
    private List<String> listaTiposId;
    
    
    public void registrarConsulta() throws ExcepcionServiciosPacientes{
        try{
            servicepacientes.agregarConsultaPaciente(pacienteSeleccionado.getId(), pacienteSeleccionado.getTipoId(), new Consulta(fechayHora,resumen,costo));
            consultas=pacienteSeleccionado.getConsultas();
        }catch (ExcepcionServiciosPacientes e){
           showMessage("Paciente no registrado", e.getMessage());
        }
    }

    public List<String> getListaTiposId() {
        listaTiposId = new ArrayList<>();
        listaTiposId.add("CC-Cedula de Ciudadania");
        listaTiposId.add("TI-Tarjeta de Identidad");
        listaTiposId.add("CE-Cedula de Extranjeria");
        listaTiposId.add("Registro Civil de Nacimiento");
        return listaTiposId;
    }

    public void setListaTiposId(List<String> listaTiposId) {
        this.listaTiposId = listaTiposId;
    }
    
    
    public Set<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Set<Consulta> consultas) {
        this.consultas = consultas;
    }
    
    
    public List<Paciente> getPacientes() {
        try{
        pacientes=servicepacientes.consultarPacientes();
        }catch (ExcepcionServiciosPacientes e){
            showMessage("Paciente no registrado", e.getMessage());
        }
        return pacientes;
    }

    public void setPacientes(List<Paciente> paciente) {
        int posicion=0;
        for (int i=0; i<epsRegistradas.size();i++){
            if (epsRegistradas.get(i).getNombre().equals(eps)){
                posicion=i;
            }
        }
        try{
            servicepacientes.registrarNuevoPaciente(new Paciente(id,tipoId,nombre,fechaNac,epsRegistradas.get(posicion)));
            pacientes=servicepacientes.consultarPacientes();
        }catch(ExcepcionServiciosPacientes e){
            showMessage("Paciente no registrado", e.getMessage());
        }
    }

    public Paciente getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }
    
    public Date getFechayHora() {
        return fechayHora;
    }

    public void setFechayHora(Date fechayHora) {
        this.fechayHora = fechayHora;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public long getCosto() {
        return costo;
    }

    public void setCosto(long costo) {
        this.costo = costo;
    }
    
    
    
    public List<String> getEpsNombres() {
        try{
        epsRegistradas=servicepacientes.obtenerEPSsRegistradas();
        }catch (ExcepcionServiciosPacientes e){
            showMessage("", e.getMessage());
        }
        epsNombres=new ArrayList<String>();
        for (Eps i:epsRegistradas){
            epsNombres.add(i.getNombre());
        }
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

    public void seleccionarPaciente(){
        consultas = pacienteSeleccionado.getConsultas();
    }

    public RegistroConsultaBean() {
        
    }

    public void showMessage(String estado, String mensaje) {
        FacesMessage message;
        message = new FacesMessage(FacesMessage.SEVERITY_INFO, estado, mensaje);
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }


}
