/**
 */
package util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import datamodels.dto.StudentDTO;
import datamodels.entities.StudentEntity;

/**
 * @since JavaSE-1.8
 */
public class UtilDBReza {
	static SessionFactory sessionFactory = null;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		}
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}

	public static List<StudentEntity> listStudents() {
		List<StudentEntity> resultList = new ArrayList<StudentEntity>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null; // each process needs transaction and commit the changes in DB.

		try {
			tx = session.beginTransaction();
			List<?> students = session.createQuery("FROM StudentEntity").list();
			for (Iterator<?> iterator = students.iterator(); iterator.hasNext();) {
				StudentEntity student = (StudentEntity) iterator.next();
				resultList.add(student);
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}

	public static List<StudentEntity> findByFirstName(String keyword) {
		List<StudentEntity> resultList = new ArrayList<StudentEntity>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> students = session.createQuery("FROM StudentEntity").list();
			for (Iterator<?> iterator = students.iterator(); iterator.hasNext();) {
				StudentEntity student = (StudentEntity) iterator.next();
				if (student.getFirstName().startsWith(keyword)) {
					resultList.add(student);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static List<StudentEntity> FindByInstrumentSerialNum(String keyword) {
		List<StudentEntity> resultList = new ArrayList<StudentEntity>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> students = session.createQuery("FROM StudentEntity").list();
			for (Iterator<?> iterator = students.iterator(); iterator.hasNext();) {
				StudentEntity student = (StudentEntity) iterator.next();
				if (student.getInstrumentSerialNumber().equals(keyword)) {
					resultList.add(student);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static List<StudentEntity> UpdateSerialNumByStudentFirstNameAndParentLast(
			String studentFirstName, String oldSerialNumber, String newSerialNumber) {
		List<StudentEntity> resultList = new ArrayList<StudentEntity>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			List<?> students = session.createQuery("FROM StudentEntity").list();
			for (Iterator<?> iterator = students.iterator(); iterator.hasNext();) {
				StudentEntity student = (StudentEntity) iterator.next();
				if (student.getInstrumentSerialNumber().equals(oldSerialNumber) 
						&& student.getFirstName().equals(studentFirstName)) {
					student.setInstrumentSerialNumber(newSerialNumber);
					resultList.add(student);
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return resultList;
	}
	
	public static void createStudent(StudentDTO student) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(
					new StudentEntity(
							student.getFirstName(),
							student.getLastName(),
							student.getSchoolName(),
							student.getSchoolPhone(),
							student.getSchoolAddress(),
							student.getInstrumentSerialNumber(),
							student.getInstrumentType(),
							student.getInstrumentSize(),
							student.getParentGuardianCC(),
							student.getParentGuardianPhone(),
							student.getParentGuardianAddress(),
							student.getParentGuardianEmail(),
							student.getGradeLevel()
							));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
