/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.myfirst.webservice.resources.service;

import com.area.myfirst.webservice.model.Student;
import java.sql.SQLException;

/**
 *
 * @author jordi
 */
public interface StudentService {
    
    Student create(Student student)  throws SQLException;
    
}
