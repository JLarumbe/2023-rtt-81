package database.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import database.entity.Customer;
import database.entity.OrderDetail;
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
	
	public List<Product> findByProductName(String productName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Product p WHERE p.productName = :productName";

		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("productName", productName);

		List<Product> result = query.getResultList();
		return result;
	}

	public void save(Product save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		session.saveOrUpdate(save);
		t.commit();
	}
}
