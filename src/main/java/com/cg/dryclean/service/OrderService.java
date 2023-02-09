package com.cg.dryclean.service;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dryclean.entity.OrderLineItem;
import com.cg.dryclean.entity.Orders;
import com.cg.dryclean.entity.Services;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.exception.EmptyInputException;
import com.cg.dryclean.exception.OrderLineItemNotFoundException;
import com.cg.dryclean.exception.OrderNotFoundException;
import com.cg.dryclean.exception.UserNotFoundException;
import com.cg.dryclean.repository.OrderLineItemRepo;
import com.cg.dryclean.repository.OrderRepo;
import com.cg.dryclean.repository.ServiceRepo;
import com.cg.dryclean.repository.UsersRepo;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private ServiceRepo serviceRepo;
	@Autowired
	private OrderLineItemRepo orderLineItemRepo;
	@Autowired
	private UsersRepo usersRepo;
	
	//add Order
	public Orders addOrder(Orders order)
	{	
		//if user name is empty then throw user-defined exception
		if(order.getOrderLineItem().getName().isEmpty() ||
		   order.getOrderLineItem().getQuantity().intValue()==0 ||
		   order.getOrderLineItem().getMaterial().isEmpty() ) 
		{
			throw new EmptyInputException();
		}
		Services ser = serviceRepo.findById(order.getService().getId()).get();
		order.setService(ser);
		
		Usernames user = usersRepo.findById(order.getUsers().getId()).get();
		order.setUsers(user);
		
		return orderRepo.save(order);
	}
		
	//delete order by id
	public void deleteOrderById(int orderId)
	{
		//if there is no order with given id then throw user-defined exception		
		if(!orderRepo.existsById(orderId)) 
		{
			throw new OrderNotFoundException();
		}
		orderRepo.deleteById(orderId);
	}
	
	//get order details for id
	public Orders findOrderById(int orderId) 
	{	
		//if there is no order with given id then throw user-defined exception		
		if(!orderRepo.existsById(orderId)) 
		{
			throw new OrderNotFoundException();
		}
		return orderRepo.findById(orderId).get();
	}

	
	//get order details for user id
	public List<Orders> getAllOrdersByUserId(int userId) {
		
		//if there is no user with given id then throw user-defined exception		
		if(!usersRepo.existsById(userId)) 
		{
			throw new UserNotFoundException();
		}
		
		//get all orders then filter out based on usedId 
		List<Orders> newOrders = orderRepo.findAll().stream()
			    .filter(e -> e.getUsers().getId() == userId)
			    .collect(Collectors.toList());	
		
		return newOrders;
	}
	
	//get all orders
	public List<Orders> findAllOrders()
	{	
		return orderRepo.findAll();	
	}
		
	//adding a service
	public Services addService(Services service)
	{	
		if(service.getType().isEmpty() ||
		   service.getType().length()==0 ||
		   service.getCharges().intValue()==0 ) 
		{
					throw new EmptyInputException();
		}
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
		//if orderLineItem details are empty then throw user-defined exception
		if(item.getName().isEmpty() ||
		   item.getQuantity().intValue()==0 ||
		   item.getMaterial().isEmpty() ) 
		{
			throw new EmptyInputException();
		}
		return orderLineItemRepo.save(item);
	}
	
	//	updating Items
	public OrderLineItem updateOrderLineItem(int id, OrderLineItem orderLineItem)
	{
		//if there is no OrderLineitem with given id then throw user-defined exception		
		if(!orderLineItemRepo.existsById(id)) 
		{
			throw new OrderLineItemNotFoundException();
		}
		OrderLineItem existingItem = orderLineItemRepo.findById(id).get();
		existingItem.setName(orderLineItem.getName());
		existingItem.setQuantity(orderLineItem.getQuantity());
		existingItem.setMaterial(orderLineItem.getMaterial());
		existingItem.setInstructions(orderLineItem.getInstructions());
		return orderLineItemRepo.save(existingItem);
	}
	
}
