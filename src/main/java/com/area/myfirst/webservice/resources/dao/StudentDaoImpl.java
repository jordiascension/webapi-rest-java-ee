/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.myfirst.webservice.resources.dao;

import com.area.myfirst.webservice.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.sql.DataSource;


/**
 *
 * @author jordi
 */
@Dependent
public class StudentDaoImpl implements StudentDao{
    
    private static final Logger logger = Logger.getLogger(StudentDaoImpl.class.getName());
    
    DataSource dataSource;
    
    @Inject
    public StudentDaoImpl(@DefaultDataSource DataSource dataSource){
        this.dataSource = dataSource;
    }
   
   //JDBC POOL & JDBC RESOURCE 
   //https://blog.payara.fish/using-mysql-with-payara
    //asadmin add-library mysql-connector-java-8.0.26.jar
    @Override
    public Student create(Student student) throws SQLException {
        logger.info("StudentDaoImpl add method is called");
        Student insertedStudent = new Student();
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement("Insert into Student" +
                     " (firstname, lastname, email) values (?,?,?)",
                     Statement.RETURN_GENERATED_KEYS)) {
             ps.setString(1, student.getName());
             ps.setString(2, student.getSurname());
             ps.setString(3, student.getEmail());
             //Just one connection in the pool
             ps.executeUpdate();
             
             try (ResultSet keys = ps.getGeneratedKeys()) {
                  keys.next();
                  Long returnedKey = keys.getLong(1);
                  insertedStudent.setStudentId(returnedKey);
                  insertedStudent.setName(student.getName());
                  insertedStudent.setSurname(student.getSurname());
                  insertedStudent.setEmail(student.getEmail());
             }
        }
        logger.info("StudentDaoImpl add method is finished");
        return insertedStudent;
    }
    
}
