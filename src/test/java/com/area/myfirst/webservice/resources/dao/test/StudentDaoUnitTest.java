/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.myfirst.webservice.resources.dao.test;

import com.area.myfirst.webservice.model.Student;
import com.area.myfirst.webservice.resources.dao.StudentDao;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author jordi
 */
public class StudentDaoUnitTest {
   
    Student student;
    Student insertedStudent;
    @Mock
    StudentDao studentDao;
    
    //https://www.adictosaltrabajo.com/2009/01/29/mockito-example/
    @Before
    public void setUp() throws Exception {
        student = new Student();
        student.setName("Pepe");
        student.setSurname("Soto");
        student.setEmail("pepe@gmail.com");
        studentDao=mock(StudentDao.class);

        insertedStudent = new Student();
        insertedStudent.setStudentId(1L);
        insertedStudent.setName("Pepe");
        insertedStudent.setSurname("Soto");
        insertedStudent.setEmail("pepe@gmail.com");
        
        //Stubbing
        when(studentDao.create(student)).thenReturn(insertedStudent);
    }
    
   @Test
   public void testInsertStudent() throws SQLException {

       Student expectedStudent= studentDao.create(student);    
       verify(studentDao).create(student);
       Assert.assertTrue(expectedStudent.getStudentId()>0);
    }
    
}
