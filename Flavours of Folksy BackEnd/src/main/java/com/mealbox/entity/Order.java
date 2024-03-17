package com.mealbox.entity;

import java.util.Date;
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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
@Entity
@Table(name = "order_table")
@SequenceGenerator(name = "generator6", sequenceName = "gen", initialValue = 1000)

public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator6")
	@Column(name = "order_id")
	private long  orderId;
	
	@Column(name = "discount")
	@NotNull  // The CharSequence, Collection, Map or Array object is not null, but can be empty.
	private int discount;
	
	@Column(name = "duration")
	@NotEmpty  // The CharSequence, Collection, Map or Array object is not null and size > 0. ie) @size min=1 
	private String duration;
	
	@Column(name = "gst")
	@NotNull
	private int gst;
	
	@Column(name = "meal_Price")
	@NotNull  
	private int meal_Price;
	
	@Column(name = "meal_category")
	@NotBlank  //The string is not null and the trimmed length is greater than zero.
	private String mealCategory;
	
	@Column(name = "meal_plan")
	@NotBlank
	private String meal_plan;
	
	@Column(name = "meal_type")
	@NotBlank
	private String meal_type;
	
	@Column(name = "quantity")
	@NotNull
	private int quantity;
	
	@Column(name = "meal_type_price")
	@NotNull
	private int mealTypePrice;
	
	@Column(name = "tax")
	@NotNull
	private int tax;
	
	@Column(name = "grandTotal")
	@NotNull
	private int grandTotal;
	
	@Column(name = "deliveryCharge")
	@NotNull
	private int deliveryCharge;
	
	@Column(name = "ordered_date")
	private Date orderedDate;
	
	
	@Column(name = "payment_status")
	private String paymentStatus;
	
	@Column(name = "order_status")
	private String orderStatus;
	
	@ManyToOne( cascade=CascadeType.MERGE)
	@JoinColumn(name="user_id")
    private User user;
	
}