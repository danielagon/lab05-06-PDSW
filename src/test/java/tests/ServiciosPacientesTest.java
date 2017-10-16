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
import java.util.logging.Level;
import java.util.logging.Logger;
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
 *CE1: DESCRIPCION: El nuevo panew ServiciosPacientesImpl()ciente ya esta registrado (cedula sea igual)
 *     RESULTADOS: Excepcion
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
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
        servicios= ServiciosHistorialPacientesFactory.getInstance().getTestingServiciosPaciente();
    }    
    
    @Test
    public void registrarPacienteRepetido(){
        
        try{
            servicios.registrarNuevoPaciente(new Paciente(8393,"CC", "Ricardo Pinto", java.sql.Date.valueOf("1956-05-01"), new Eps("SaludTotal", "8439009323-9")));
            servicios.registrarNuevoPaciente(new Paciente(8393,"CC", "Ricardo Pinto", java.sql.Date.valueOf("1956-05-01"), new Eps("SaludTotal", "8439009323-9")));
        }catch (ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(),"El paciente ya se encuentra registrado");
        }
    }
    
    @Test
    public void registrarPacienteIdentificacionInvalida(){
        
        try{
            servicios.registrarNuevoPaciente(new Paciente(0,"CC", "Rodolfo Pinto", java.sql.Date.valueOf("1956-05-01"), new Eps("SaludTotal", "8439009323-9")));
        }catch (ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(),"El numero de identificacion no es valido");
        }
    }
    
    @Test
    public void registroPaciente(){
        try{
            servicios.registrarNuevoPaciente(new Paciente(145,"ho", "Ricardo Pinto", java.sql.Date.valueOf("1956-05-01"), new Eps("SaludTotal", "8439009323-9")));
        }catch (ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(),"El tipo de identificaión no es valido");
        }
    }
    @Test 
    public void registroConsultas(){
        try{
            servicios.agregarConsultaPaciente(0, "CC", new Consulta(java.sql.Date.valueOf("2000-01-01"), "Dolor de cabeza", 454));  
        }catch(ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(),"Paciente 0 no esta registrado");
        }
    }
    
    @Test
    public void registrarConsultaPaciente(){
        try{
            Paciente paciente=new Paciente(1243,"CC", "Ricardo Pinto", java.sql.Date.valueOf("1956-05-01"), new Eps("SaludTotal", "8439009323-9"));
            servicios.registrarNuevoPaciente(paciente);
            int numeroConsultas=paciente.getConsultas().size();
            servicios.agregarConsultaPaciente(1243, "CC", new Consulta(java.sql.Date.valueOf("2000-01-01"), "Dolor de cabeza", 454)); 
            assertEquals(numeroConsultas,paciente.getConsultas().size());
        }catch(ExcepcionServiciosPacientes e){
            e.printStackTrace();
        }
        
    }
}
