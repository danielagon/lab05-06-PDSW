/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.persistence.mybatis;

import com.google.inject.Inject;
import edu.eci.pdsw.persistence.EPSDAO;
import edu.eci.pdsw.persistence.mybatis.mappers.EpsMapper;

/**
 *
 * @author 2109734
 */
public class EPSDAOMyBatis implements EPSDAO{
    @Inject
    private EpsMapper eps;
}
