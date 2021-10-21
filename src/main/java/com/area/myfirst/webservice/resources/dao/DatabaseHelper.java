/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.myfirst.webservice.resources.dao;

import javax.annotation.Resource;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

/**
 *
 * @author jordi
 */
@Dependent
public class DatabaseHelper {
        
    @Produces
    @Resource(lookup = "jdbc/mysql")
    @DefaultDataSource
    DataSource defaultDS;
}
