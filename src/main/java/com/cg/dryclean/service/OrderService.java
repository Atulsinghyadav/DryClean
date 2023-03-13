package com.cg.dryclean.service;
import java.math.BigDecimal;
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
	
	//*****ORDER CONTROLLER METHODS*****	
	//To get a list of all Orders
	public List<Orders> findAllOrders()
	{	
		return orderRepo.findAll();	
	}
	
	//To retrieve orders using Order Id	
	public Orders findOrderById(int orderId) 
	{	
		//if there is no order with given id then throw user-defined exception		
		if(!orderRepo.existsById(orderId)) 
		{
			throw new OrderNotFoundException();
		}
		return orderRepo.findById(orderId).get();
	}
	
	//To retrieve orders using User Id	
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
	
	//To retrieve orders using Order Status
	public List<Orders> getAllOrdersByOrderStatus(String orderStatus) {
				
		//get all orders then filter out based on Order Status 
		List<Orders> newOrders = orderRepo.findAll().stream()
				.filter(e -> e.getOrderStatus() .toLowerCase().equals(orderStatus.toLowerCase()))
				.collect(Collectors.toList());	
			
		return newOrders;
	}
	
	//To add a new Order
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
		order.setAmount(calculateAmount(order,ser));

		return orderRepo.save(order);
	}
		
	//To calculate order amount
	public double calculateAmount(Orders order , Services ser) 
	{
		BigDecimal serviceCharge = ser.getCharges() ;
		Integer quantity = order.getOrderLineItem().getQuantity();
		Integer intServiceCharge = Integer.valueOf(serviceCharge.intValue());
		Integer totalcharge = intServiceCharge  + (100 * quantity);
		double dtotal = (double)totalcharge;
		return dtotal ;
	}
	
	//To change order status (Pending,Out For Delivery, Delivered etc) 
	public Orders changeOrderStatus(int orderId, Orders order) 
	{
		Orders newOrder = orderRepo.findById(orderId).get();
		newOrder.setOrderStatus(order.getOrderStatus());

		return orderRepo.save(newOrder);
	}
	
	//To generate a cancellation request for order
	public Orders cancelOrder(int orderId) 
	{
		Orders newOrder = orderRepo.findById(orderId).get();
		newOrder.setOrderStatus("Requested to cancel");

		return orderRepo.save(newOrder);
	}
	
	
	//*****SERVICE CONTROLLER METHODS*****
	//To get a list of all available services
	public List<Services> findAllServices()
	{
		return serviceRepo.findAll();
	}
		
	//To add a new Service to the database
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
	//To delete a Service to the database
	public void deleteServiceById(int id)
    {
      //if there is no order with given id then throw user-defined exception    
      
      serviceRepo.deleteById(id);
    }
	
	
	//*****ORDER-LINE-ITEM CONTROLLER METHODS*****
	//To add an OrderLineItem
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
	
	//To update an OrderLineItem
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
