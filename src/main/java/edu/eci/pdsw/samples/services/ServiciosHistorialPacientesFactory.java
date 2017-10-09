/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.samples.services;

import com.google.inject.AbstractModule;
import static com.google.inject.Guice.createInjector;
import com.google.inject.Injector;
import edu.eci.pdsw.samples.services.impl.ServiciosPacientesImpl;
import static com.google.inject.Guice.createInjector;
import edu.eci.pdsw.persistence.EPSDAO;
import edu.eci.pdsw.persistence.PacienteDAO;
import edu.eci.pdsw.persistence.mybatis.EPSDAOMyBatis;
import edu.eci.pdsw.persistence.mybatis.PacienteDAOMyBatis;
import edu.eci.pdsw.persistence.mybatis.mappers.PacienteMapper;


/**
 *
 * @author hcadavid
 */
public class ServiciosHistorialPacientesFactory {

    private static ServiciosHistorialPacientesFactory instance = new ServiciosHistorialPacientesFactory();

    private static Injector injector;

    public ServiciosHistorialPacientesFactory() {

        injector = createInjector(new AbstractModule() {

            @Override
            protected void configure() {
                //bind(ServiciosPacientes.class).to(ServiciosPacientesImpl.class);
                bind(PacienteDAO.class).to(PacienteDAOMyBatis.class);
                bind(EPSDAO.class).to(EPSDAOMyBatis.class);
            }

        }
        );

    }

    public ServiciosPacientes getServiciosPaciente() {
        return injector.getInstance(ServiciosPacientes.class);
    }

    public static ServiciosHistorialPacientesFactory getInstance() {
        return instance;
    }

}
