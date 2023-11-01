package database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import database.entity.Customer;

public class CustomerDAO {
	public Customer findById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.id = :id";

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("id", id);

		try {
			Customer result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}

	}

	public List<Customer> findByFirstName(String firstName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Customer c WHERE c.contactFirstName = :firstName";

		TypedQuery<Customer> query = session.createQuery(hql, Customer.class);
		query.setParameter("firstName", firstName);

		List<Customer> result = query.getResultList();
		return result;
	}

	public void save(Customer save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		session.saveOrUpdate(save);
		t.commit();
	}

}
