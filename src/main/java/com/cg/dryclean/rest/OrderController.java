package com.cg.dryclean.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Orders;
import com.cg.dryclean.service.OrderService;


@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//NOT WORKING
	//get all orders for admin	
	@GetMapping("/getAllOrders")
	public ResponseEntity <List<Orders>> findAllOrders()
	{	
		System.out.println("inside controller-getAllOrder");
		List<Orders> orderList = orderService.findAllOrders();
		return ResponseEntity.ok(orderList);
	}
	
	//to retrieve orders using order id	
	@GetMapping("/orders/{orderid}")
	public ResponseEntity<Orders> getOrderById(@PathVariable int orderid)
	{
		Orders ord = orderService.findOrderById(orderid);
		return ResponseEntity.ok(ord);
	}
	
	//to retrieve orders using user id	
	@GetMapping("/myorders/{userid}")
	public ResponseEntity<Orders> getOrderByUserId(@PathVariable("userid") int userid)
	{
		Orders ord = orderService.getOrderByUser(userid);
		return ResponseEntity.ok(ord);
	}
	
	//to add orders	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addAddress(@RequestBody Orders order)
	{
		orderService.addOrder(order);
		return ResponseEntity.ok("Order Saved");
	}
	
	//to delete orders
	@DeleteMapping("/orders/{orderId}") 
	public String deleteEmployee(@PathVariable int orderId) 
	{ 
		Orders order = orderService.findOrderById(orderId);
		System.out.println(orderId);
		if(order==null) 
		{ 
			throw new RuntimeException("Order id not found"+orderId); 
		} 	
		orderService.deleteOrderById(orderId); 
		return "Deleted Order Id :"+orderId; 
	} 
	
}
