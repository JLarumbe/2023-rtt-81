package database.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetail;

//	@Column(name = "customer_id", insertable = false, updatable = false)
//	private Integer customerId;

	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	@Column(name = "required_date")
	@Temporal(TemporalType.DATE)
	private Date requiredDate;

	@Column(name = "shipped_date")
	@Temporal(TemporalType.DATE)
	private Date shippedDate;

	@Column(name = "status")
	private String status;

	@Column(name = "comments", columnDefinition = "text")
	private String comments;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Integer getCustomerId() {
//		return customerId;
//	}
//
//	public void setCustomerId(Integer customerId) {
//		this.customerId = customerId;
//	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderDetail> getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(List<OrderDetail> orderdetail) {
		this.orderDetail = orderdetail;
	}

}
