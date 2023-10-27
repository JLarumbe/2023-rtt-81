package database.dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import database.entity.OrderDetail;

public class OrderDetailDAO {
	public OrderDetail findById(int id) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM OrderDetail od WHERE od.id = :id";

		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("id", id);

		try {
			OrderDetail result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}
	}

	public OrderDetail findByOrderIdAndProductId(Integer orderId, Integer productId) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		String hql = "FROM OrderDetail od WHERE od.order.id = :orderId AND od.product.id = :productId";

		TypedQuery<OrderDetail> query = session.createQuery(hql, OrderDetail.class);
		query.setParameter("orderId", orderId);
		query.setParameter("productId", productId);

		try {
			OrderDetail result = query.getSingleResult();
			return result;
		} catch (NoResultException nre) {
			return null;
		}

	}

	public void save(OrderDetail save) {
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction t = session.beginTransaction();

		session.saveOrUpdate(save);
		t.commit();
	}
}
