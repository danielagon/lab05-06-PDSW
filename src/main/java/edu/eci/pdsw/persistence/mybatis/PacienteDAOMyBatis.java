/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.AbstractModule;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Inject;
import com.google.inject.Injector;
import edu.eci.pdsw.persistence.PacienteDAO;
import edu.eci.pdsw.persistence.mybatis.mappers.PacienteMapper;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author 2109734
 */
public class PacienteDAOMyBatis implements PacienteDAO{
    @Inject 
    private PacienteMapper paciente;

    @Override
    public List<Paciente> loadAll() throws PersistenceException{
        List<Paciente> pacientes=null;
        try{
            pacientes=paciente.loadPacientes();
        }catch(Exception e){
            throw new PersistenceException("Error al cargar todos los pacientes",e);
        }
        return pacientes;
    }

    @Override
    public void load(Paciente p)throws PersistenceException {
        try{
            paciente.insertarPaciente(p);
        }catch(Exception e){
            throw new PersistenceException("Error al registrar el paciente"+p.getId(),e);
        }
    }

    @Override
    public Paciente loadByID(int id, String tipoid) throws PersistenceException{
        Paciente p;
        try{
            p=paciente.loadPacienteById(id,tipoid);
        }catch(Exception e){
            throw new PersistenceException("Error al cargar el paciente por Id"+id,e);
        }
        return p;
    }

    @Override
    public void save(Consulta consulta, int id, String tipoId) throws PersistenceException{
        try{
            paciente.insertConsulta(consulta, id, tipoId);
            
        }catch(Exception e){
            throw new PersistenceException("Error al guardar la consulta "+consulta.getId()+" al paciente "+id,e);
        }
    }

    @Override
    public void update(int id, String tipoId, String nombre, Eps eps, Paciente p) throws PersistenceException {
        try{
            paciente.actualizarPaciente(0, tipoId, nombre, eps, p);
        }catch(Exception e){
            throw new PersistenceException("Error al actualizar el paciente "+p.getId(),e);
        }
        
    }
    
    
    
}
