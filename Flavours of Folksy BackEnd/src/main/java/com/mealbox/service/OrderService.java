package com.mealbox.service;
import java.util.List;

import com.mealbox.entity.TransactionDetails;



public interface OrderService {
	TransactionDetails createTransaction(Double amount);
}