/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence;

/**
 *
 * @author 2109734
 */
public interface PacienteDAO {
    public void loadAll();
    public void load();
    public void loadByID(int  id);
    public void save();
    public void update();
}
