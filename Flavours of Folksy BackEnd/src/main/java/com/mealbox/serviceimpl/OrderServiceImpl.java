package com.mealbox.serviceimpl;

import java.text.SimpleDateFormat;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mealbox.entity.TransactionDetails;
import com.mealbox.repository.OrderRepository;
import com.mealbox.service.OrderService;
import com.mealbox.service.UserService;
import com.razorpay.RazorpayClient;


@Transactional
	@Service
	public class OrderServiceImpl implements OrderService {
		
		private static final String ORDER_PLACED = "Placed";

	    private static final String KEY = "rzp_test_AXBzvN2fkD4ESK";
	    private static final String KEY_SECRET = "bsZmiVD7p1GMo6hAWiy4SHSH";
	    private static final String CURRENCY = "INR";

		@Autowired
		public OrderRepository orderRepository;

		
		@Autowired
		private UserService userService;



		@Override
		public TransactionDetails createTransaction(Double amount) {
			try {

	            JSONObject jsonObject = new JSONObject();
	            jsonObject.put("amount", (amount * 100) );
	            jsonObject.put("currency", CURRENCY);

	            RazorpayClient razorpayClient = new RazorpayClient(KEY, KEY_SECRET);

	            com.razorpay.Order order = razorpayClient.orders.create(jsonObject);

	            TransactionDetails transactionDetails =  prepareTransactionDetails(order);
	            return transactionDetails;
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return null;
	    }

	    private TransactionDetails prepareTransactionDetails(com.razorpay.Order order) {
	        String orderId = order.get("id");
	        String currency = order.get("currency");
	        Integer amount = order.get("amount");

	        TransactionDetails transactionDetails = new TransactionDetails(orderId, currency, amount, KEY);
	        return transactionDetails;
	    }

		

			
		
		

}
