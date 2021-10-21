/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.myfirst.webservice.resources.dao;

import com.area.myfirst.webservice.model.Student;
import java.sql.SQLException;

/**
 *
 * @author jordi
 */
public interface StudentDao {
    Student create(Student student) throws SQLException;
}
