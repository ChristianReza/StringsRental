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

import datamodels.dto.InstrumentDTO;
import datamodels.dto.ParentGuardianDTO;
import datamodels.dto.SchoolDTO;
import datamodels.entities.InstrumentEntity;
import datamodels.entities.ParentGuardianEntity;
import datamodels.entities.SchoolEntity;
import datamodels.entities.StudentEntity;
import datamodels.enums.InstrumentType;
import datamodels.enums.Size;

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

	public static List<StudentEntity> listStudents(String keyword) {
		List<StudentEntity> resultList = new ArrayList<StudentEntity>();

		Session session = getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			System.out.println((StudentEntity) session.get(StudentEntity.class, 1)); // use "get" to fetch data
			// Query q = session.createQuery("FROM Employee");
			List<?> students = session.createQuery("FROM EmployeeReza").list();
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

	public static void createStudent(String firstName, String lastName, SchoolDTO schoolDistrict,
			InstrumentDTO instrument, ParentGuardianDTO parentGuardian, int gradeLevel) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		createInstrument(instrument);
		createParentGuardian(parentGuardian);
		try {
			tx = session.beginTransaction();
			session.save(
					new StudentEntity(
							firstName,
							lastName,
							new SchoolEntity(schoolDistrict),
							new InstrumentEntity(instrument),
							new ParentGuardianEntity(parentGuardian),
							gradeLevel));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createParentGuardian(String firstName, String lastName, String cc, String phoneNumber,
			String address, String email) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new ParentGuardianEntity(firstName, lastName, cc, phoneNumber, address, email));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createParentGuardian(ParentGuardianDTO parentGuardian) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new ParentGuardianEntity(parentGuardian.getFirstName(), parentGuardian.getLastName(),
					parentGuardian.getCc(), parentGuardian.getPhoneNumber(), parentGuardian.getAddress(),
					parentGuardian.getEmail()));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createInstrument(String serialNumber, InstrumentType instrumentType, Size size,
			StudentEntity student) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new InstrumentEntity(serialNumber, instrumentType, size, student));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createInstrument(InstrumentDTO instrument) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new InstrumentEntity(
					instrument.getSerialNumber(),
					instrument.getInstrumentType(),
					instrument.getSize(),
					new StudentEntity(instrument.getStudent()))
					);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void createSchool(String name, String phoneNumber, String address) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new SchoolEntity(name, phoneNumber, address));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public static void createSchool(SchoolDTO school) {
		Session session = getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(new SchoolEntity(
					school.getname(),
					school.getPhoneNumber(),
					school.getAddress())
					);
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
