/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.services.ExcepcionServiciosPacientes;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesMock;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hcadavid
 * 
 * CLASES DE EQUIVALENCIA
 * 
 * CE1: DESCRIPCION: El paciente no se encentre registrado
 *      RESULTADO: Excepcion
 * 
 * CE2: DESCRIPCION: El paciente no existe
 *      RESULTADO: Excepcion
 * 
 * CE3: DESCRIPCION: El paciente existe
 *      RESULTADO: El id de la consulta aumenta 1 y se agrega la consulta al paciente
 */
public class ServiciosPacientesTest {
    
    public ServiciosPacientesTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void registroConsultas(){
        ServiciosPacientesMock servicios=new ServiciosPacientesMock();
        try{
            servicios.agregarConsultaPaciente(0, "CC", new Consulta(java.sql.Date.valueOf("2000-01-01"), "Dolor de cabeza", 454));  
        }catch(ExcepcionServiciosPacientes e){
            assertEquals(e.getMessage(),"Paciente 0 no esta registrado");
        }
    }
    
}
