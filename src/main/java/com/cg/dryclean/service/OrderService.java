package com.cg.dryclean.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dryclean.entity.OrderLineItem;
import com.cg.dryclean.entity.Orders;
import com.cg.dryclean.entity.Services;
import com.cg.dryclean.repository.OrderLineItemRepo;
import com.cg.dryclean.repository.OrderRepo;
import com.cg.dryclean.repository.ServiceRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ServiceRepo serviceRepo;
	@Autowired
	private OrderLineItemRepo orderLineItemRepo;
	
	
	//add Order
	public Orders addOrder(Orders order)
	{	
		return orderRepo.save(order);
	}
		
	//delete order by id
	public void deleteOrderById(int orderId)
	{
		orderRepo.deleteById(orderId);
	}

	//	updating Order
	//	....................................
	
	//get order details for id
	public Orders findOrderById(int orderId) 
	{
		return orderRepo.findById(orderId).get();
	}
	
	//get order details for id
	public Orders getOrderByUser(int userId) 
	{
		return orderRepo.findById(userId).get();
	}
	
	//get all orders
	public List<Orders> findAllOrders()
	{	System.out.println("inside service-findAll");
		return orderRepo.findAll();
		
	}
		
	
	//adding a service
	public Services addService(Services service)
	{	
		return serviceRepo.save(service);
	}
	//get all services
	public List<Services> findAllServices()
	{
		return serviceRepo.findAll();
	}
	
	
	//adding an item
	public OrderLineItem addItem(OrderLineItem item) 
	{	
		return orderLineItemRepo.save(item);
	}
	//	updating Items
	public OrderLineItem updateOrderLineItem(int id, OrderLineItem orderLineItem)
	{
		OrderLineItem existingItem = orderLineItemRepo.findById(id).get();
		existingItem.setName(orderLineItem.getName());
		existingItem.setQuantity(orderLineItem.getQuantity());
		existingItem.setMaterial(orderLineItem.getMaterial());
		existingItem.setInstructions(orderLineItem.getInstructions());
		return orderLineItemRepo.save(existingItem);
	}
	
}
