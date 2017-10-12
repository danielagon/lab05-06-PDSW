/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.samples.entities.Eps;
import java.util.List;
import javax.persistence.PersistenceException;

/**
 *
 * @author 2109734
 */
public interface EPSDAO {
    public List<Eps> loadAll() throws PersistenceException;
    public void load();
    public void loadByID(int  id);
    public void save();
    public void update();
}
