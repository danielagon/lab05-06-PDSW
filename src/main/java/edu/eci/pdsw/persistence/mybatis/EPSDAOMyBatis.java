/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.EPSDAO;
import edu.eci.pdsw.persistence.mybatis.mappers.EpsMapper;
import edu.eci.pdsw.samples.entities.Eps;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author 2109734
 */
public class EPSDAOMyBatis implements EPSDAO{
    
    @Inject
    private EpsMapper eps;

    @Override
    public List<Eps> loadAll() throws PersistenceException{
        List<Eps> allEps=null;
        try{
            allEps=eps.loadAllEPS();
        }catch(Exception e){
            throw new PersistenceException("Error al cargar todas las Eps's ",e);
        }
        return allEps;
    }

    @Override
    public void load() throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadByID(int id) throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() throws PersistenceException{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
