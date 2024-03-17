package com.mealbox.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mealbox.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
	public Payment findByOrderId(long orderId);
	
}
