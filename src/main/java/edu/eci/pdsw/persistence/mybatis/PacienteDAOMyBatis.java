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

/**
 *
 * @author 2109734
 */
public class PacienteDAOMyBatis implements PacienteDAO{
    @Inject 
    private PacienteMapper paciente;
    
    
    
}
