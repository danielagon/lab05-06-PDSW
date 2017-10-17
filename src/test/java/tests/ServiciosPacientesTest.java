/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.ServiciosHistorialPacientesFactory;
import edu.eci.pdsw.samples.services.ServiciosPacientes;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * 
 * 
 * CLASES DE EQUIVALENCIA REGISTRO NUEVO PACIENTE
 * 
 * 
 *CE1: DESCRIPCION: Debe registrar un nuevo paciente
 *     RESULTADOS: True
 * 
 *CE2: DESCRIPCION: cedula del paciente nula
 *     RESULTADO: Excepcion
 * 
 *CE3 DESCRIPCION: tipo de identificacion nulo 
 *    RESULTADO: Excepcion
 * 
 *
 * CLASES DE EQUIVALENCIA Registro nueva consulta a paciente
 * 
 * CE1: DESCRIPCION: El paciente no se encentre registrado
 *      RESULTADO: Excepcion
 * 
 * CE2: DESCRIPCION: El paciente existe
 *      RESULTADO: El id de la consulta aumenta 1 y se agrega la consulta al paciente
 */
public class ServiciosPacientesTest {
    
    private ServiciosPacientes servicios;
    private Eps eps;
    private Paciente paciente;
    private Consulta consulta;
    
    private Eps nuevaEps;
    private Paciente paciente1;
            
    
    public ServiciosPacientesTest() {
        eps = new Eps("Sanitas", "2728748323-0");
        paciente = new Paciente(23456,"CC", "Paula ", java.sql.Date.valueOf("1956-05-01"), eps);
        this.nuevaEps = new Eps("SaludCoop","31284720");
        this.paciente1 = new Paciente(23131, "CC", "Paciente1", java.sql.Date.valueOf("1974-08-31"),nuevaEps);

    }
    
    @Before
    public void setUp(){
        servicios=ServiciosHistorialPacientesFactory.getInstance().getTestingServiciosPaciente();
    }
    
    @Test
    public void registrarPaciente() {
        try{
            servicios.registrarNuevoPaciente(paciente1);
            assertTrue(servicios.consultarPaciente(23131, "CC").equals(paciente1));
        }catch (ExcepcionServiciosPacientes e){
            e.getMessage();
        }
    }
    
    @Test
    public void registrarConsultaPaciente(){
        try{
            servicios.registrarNuevoPaciente(paciente);
            consulta= new Consulta(java.sql.Date.valueOf("2016-09-15"), "Dolor de estomago", 831);
            Paciente paciente1=servicios.consultarPaciente(23456, "CC");
            servicios.agregarConsultaPaciente(23456, "CC",consulta); 
            paciente=servicios.consultarPaciente(23456, "CC");
            
            assertTrue(paciente.getConsultas().size()==paciente1.getConsultas().size()+1);
        }catch(ExcepcionServiciosPacientes e){
            e.getMessage();
        }
        
    }
}
