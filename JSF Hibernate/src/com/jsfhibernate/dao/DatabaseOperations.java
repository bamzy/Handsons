package com.jsfhibernate.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jsfhibernate.pojo.Student;
import com.jsfhibernate.util.HibernateUtil;

public class DatabaseOperations {

	private static Transaction transObj;
	private static Session sessionObj = HibernateUtil.getSessionFactory().openSession();

	// Method To Add New Student Details In Database
	public void addStudentInDb(Student studentObj) {		
		try {
			transObj = sessionObj.beginTransaction();
			sessionObj.save(studentObj);
			System.out.println("Student Record With Id: " + studentObj.getId() + " Is Successfully Created In Database");

			// XHTML Response Text
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("createdStudentId",  studentObj.getId());						
		} catch (Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}

	// Method To Delete A Particular Student Record From The Database
	public void deleteStudentInDb(int delStudentId) {
		try {
			transObj = sessionObj.beginTransaction();
			Student studId = (Student)sessionObj.load(Student.class, new Integer(delStudentId));
			sessionObj.delete(studId);
			System.out.println("Student Record With Id: " + delStudentId + " Is Successfully Deleted From Database");

			// XHTML Response Text
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("deletedStudentId",  delStudentId);	
		} catch (Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}

	// Method To Fetch Particular Student Details From The Database
	public List<Student> getStudentById(int studentId) {	
		Student particularStuDObj = new Student();
		List<Student> particularStudentList = new ArrayList<Student>();            
		try {
			transObj = sessionObj.beginTransaction();
			Query queryObj = sessionObj.createQuery("from Student where id= :student_id").setInteger("student_id", studentId);			
			particularStuDObj = (Student)queryObj.uniqueResult();
			particularStudentList = queryObj.list();			
			System.out.println("Student Record With Id: " + studentId + " Is Fetched Successfully From Database");

			// XHTML Response Text
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findStudentById",  studentId);
		} catch(Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
		return particularStudentList;
	}

	// Method To Update Particular Student Details In The Database	
	public void updateStudentRecord(Student updateStudentObj) {
		try {
			transObj = sessionObj.beginTransaction();
			sessionObj.update(updateStudentObj);		
			System.out.println("Student Record With Id: " + updateStudentObj.getId() + " Is Successfully Updated In Database");	

			// XHTML Response Text
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("updatedStudentRecord",  "Success");
		} catch(Exception exceptionObj){
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
	}

	@SuppressWarnings("unchecked")
	public List<Student> retrieveStudent() {		
		Student studentsObj;
		List<Student>allStudents = new ArrayList<Student>();
		try {
			transObj = sessionObj.beginTransaction();
			Query queryObj = sessionObj.createQuery("from Student");
			allStudents = queryObj.list();
			for(Student stud : allStudents) {
				studentsObj = new Student(); 								
				studentsObj.setName(stud.getName());
				studentsObj.setDepartment(stud.getDepartment());								
				allStudents.add(studentsObj);  
			}			
			System.out.println("All The Students Records Are Fetched Successfully From Database");

			// XHTML Response Text
			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("findStudentById", "true");
		} catch(Exception exceptionObj) {
			exceptionObj.printStackTrace();
		} finally {
			transObj.commit();
		}
		return allStudents;
	}
}