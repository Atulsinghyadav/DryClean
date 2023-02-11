package com.cg.dryclean.entity;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private double amount;
	private Date orderDate;
	private Date deliveryDate;
	private String paymentStatus;
	private String orderStatus;
	
//	bidirectional
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id",referencedColumnName = "id")
	private Usernames users;
	
	
//	unidirectional
//	@OneToOne(cascade = CascadeType.ALL)
	@OneToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
	private Services service;
	
//	unidirectional
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderLineItem_id", referencedColumnName = "id")
	private OrderLineItem orderLineItem;
	
}
