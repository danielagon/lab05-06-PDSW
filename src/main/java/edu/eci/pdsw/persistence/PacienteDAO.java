/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Eps;
import edu.eci.pdsw.samples.entities.Paciente;
import java.util.List;

/**
 *
 * @author 2109734
 */
public interface PacienteDAO {
    public List<Paciente> loadAll() throws PersistenceException;
    public void load(Paciente p) throws PersistenceException;
    public Paciente loadByID(int id, String tipoid) throws PersistenceException;
    public void save(Consulta consulta, int id, String tipoId) throws PersistenceException;
    public void update(int id, String tipoId, String nombre, Eps eps, Paciente p) throws PersistenceException;
}
