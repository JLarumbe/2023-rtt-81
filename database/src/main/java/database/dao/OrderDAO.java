package database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import database.entity.Order;

public class OrderDAO {
	public Order findById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Order o WHERE o.id = :id";

		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id", id);

		try {
			Order result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Order> findByCustomerId(Integer customerId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Order o WHERE o.customer.id = :customerId";

		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("customerId", customerId);

		List<Order> result = query.getResultList();

		return result;
	}

	public void save(Order save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		session.saveOrUpdate(save);
		t.commit();
	}

}
