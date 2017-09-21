/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesMock;
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
 *CE1: DESCRIPCION: El nuevo paciente ya esta registrado (cedula sea igual)
 *     RESULTADOS: Excepcion
 * 
 *CE2: DESCRIPCION: cedula del paciente nula
 *     RESULTADO: Excepcion
 * 
 *CE3 DESCRIPCION: tipo de identificacion nulo 
 *    RESULTADO: Excepcion
 * 
 *
 * 
 */
public class ServiciosPacientesTest {
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void registroPaciente(){
        ServiciosPacientesMock servicios= new ServiciosPacientesMock();
        try{
            servicios.registrarNuevoPaciente(new Paciente(77777,null, "Ricardo Pinto", java.sql.Date.valueOf("1956-05-01"), eps6));
        }catch (ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(),"El tipo de identificaión no es valido");
        }
        
    }
    
}
