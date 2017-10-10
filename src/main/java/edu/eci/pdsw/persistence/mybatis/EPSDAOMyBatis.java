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

/**
 *
 * @author 2109734
 */
public class EPSDAOMyBatis implements EPSDAO{
    private List<Eps> allEps;
    @Inject
    private EpsMapper eps;

    @Override
    public void loadAll() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        allEps=eps.loadAllEPS();
        for (Eps e:allEps){
            System.out.println("PROBAAAANDOO");
            System.out.println(e.getNombre());
        }
    }

    @Override
    public void load() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void save() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
