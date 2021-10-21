/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.myfirst.webservice.resources.service;

import com.area.myfirst.webservice.model.Student;
import com.area.myfirst.webservice.resources.dao.StudentDao;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author jordi
 */
@Dependent
public class StudentServiceImpl implements StudentService {

    @Inject
    StudentDao studentDao;
    
    private static final Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());
    
    @Override
    public Student create(Student student)  throws SQLException {
       logger.info("StudentServiceImpl create method is called");
       Student insertedStudent = studentDao.create(student);
       logger.info("StudentServiceImpl create method is finished");
       return insertedStudent;       
    }
    
}
