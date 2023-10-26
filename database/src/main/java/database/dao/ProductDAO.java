package database.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import database.entity.Product;

public class ProductDAO {
	public Product findById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String hql = "FROM Product p WHERE p.id = :id";
		
		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("id", id);

		try {
			Product result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public List<Product> findByProductName(String productName) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM Product p WHERE p.productName LIKE :productName";

		TypedQuery<Product> query = session.createQuery(hql, Product.class);
		query.setParameter("productName", "%"+productName+"%");

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
