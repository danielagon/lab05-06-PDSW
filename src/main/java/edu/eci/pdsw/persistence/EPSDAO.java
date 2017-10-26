/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

import edu.eci.pdsw.samples.entities.Eps;
import java.util.List;

/**
 *
 * @author 2109734
 */
public interface EPSDAO {
    public List<Eps> loadAll() throws PersistenceException;
    public void load() throws PersistenceException;
    public void loadByID(int  id) throws PersistenceException;
    public void save() throws PersistenceException;
    public void update() throws PersistenceException;
}
