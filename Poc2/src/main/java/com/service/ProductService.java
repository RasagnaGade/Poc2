package com.service;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.model.Orders;
import com.model.Product;


@Service
public class ProductService {
	
	@Autowired
	private ProductDao productRepo;
	
	@Autowired
	private OrderDao orderRepo;
	
	
	
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}
	
	
	public Iterable<Product> getAllProduct() {
		return productRepo.findAll();
		
	}
	
	public Optional<Product> getProductById(Integer product_Id) {
		return productRepo.findById(product_Id);
	}
	
	
	public Iterable<Orders> getAllOrders(){
		return orderRepo.findAll();
	}
	
	public int placeOrder(int product_id,int quantity, Orders order) {
		int result = 1;
		
		Product product = productRepo.findById(product_id).orElse(new Product());
		
		if(product == null) {
			return result;
		}
		order.setQuantity(quantity);
		order.setProduct(product);
		orderRepo.save(order);
		
		result = 0;
		return result;
	}
	
	public int updateOrder(Integer order_id, Integer quantity ) {
		int result = 1;
		
		Orders order = orderRepo.findById(order_id).orElse(new Orders());
		if(order.getOrder_id() == 0) {
			return result;
		}
		
		order.setQuantity(quantity);
		orderRepo.save(order);
		
		result=0;
		
		return result;
	}

}
