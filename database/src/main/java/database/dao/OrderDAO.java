package database.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.entity.Order;

public class OrderDAO {
	public Order findById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Order o WHERE o.id = :id"; // Example of HQL to get all records of user class
		TypedQuery<Order> query = session.createQuery(hql, Order.class);
		query.setParameter("id", id);

		Order result = query.getSingleResult();

		return result;
	}
}
