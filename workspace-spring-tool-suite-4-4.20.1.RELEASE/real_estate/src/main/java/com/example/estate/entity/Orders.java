package com.example.estate.entity;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Orders {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderCode;
	
	@ManyToOne
	@JoinColumn(name = "userCode")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "productCode")
	private Product product;
	
	@Column
	private int priceSum;
	
	@Column	
    private String refunReason;
	
	@Column	
    private String delRequest;
	
	@Column	
    private int productCount;
	
	@Column	
    private String reZipCode;
	
	@CreationTimestamp
	private Timestamp orderDate;

	public Long getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(Long orderCode) {
		this.orderCode = orderCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPriceSum() {
		return priceSum;
	}

	public void setPriceSum(int priceSum) {
		this.priceSum = priceSum;
	}

	public String getRefunReason() {
		return refunReason;
	}

	public void setRefunReason(String refunReason) {
		this.refunReason = refunReason;
	}

	public String getDelRequest() {
		return delRequest;
	}

	public void setDelRequest(String delRequest) {
		this.delRequest = delRequest;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getReZipCode() {
		return reZipCode;
	}

	public void setReZipCode(String reZipCode) {
		this.reZipCode = reZipCode;
	}

	public Timestamp getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}

	
	
}
