package database.dao;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import database.entity.Product;

public class ProductDAO {
	public Product findById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		String hql = "FROM Product p WHERE p.id = :id"; // Example of HQL to get all records of user class
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("id", id);

		Product result = query.getSingleResult();

		return result;
	}
}
