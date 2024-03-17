package com.mealbox.entity;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

    @Data
	@Entity
	@Table(name="payment_table")
	@SequenceGenerator(name = "generator5", sequenceName = "gen5", initialValue = 100)
	public class Payment {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator5")
		@Column(name = "payment_id")
	private long paymentId;
		

	@Column(name="total_price")
	private  double totalPrice;

	@Column(name="order_id",unique=true)
	private  long orderId;


	@Column(name = "paid_date")
	private LocalDate PaidDate;

	@Column(name = "paid_amount", nullable = false)
	private double paidAmount;


	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
	@JsonIgnore
	private User user;
	
	public Payment()
	{
	  }

}
