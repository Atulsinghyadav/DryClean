package com.cg.dryclean.rest;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.Orders;
import com.cg.dryclean.service.OrderService;

@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	//To get a list of all Orders	
	@GetMapping("/getAllOrders")
	public ResponseEntity <List<Orders>> findAllOrders()
	{	
		List<Orders> orderList = orderService.findAllOrders();
		return ResponseEntity.ok(orderList);
	}
	
	//To retrieve orders using Order Id	
	@GetMapping("/orders/{orderid}")
	public ResponseEntity<Orders> getOrderById(@PathVariable int orderid)
	{
		Orders ord = orderService.findOrderById(orderid);
		return ResponseEntity.ok(ord);
	}

	//To retrieve orders using User Id	
	@GetMapping("/user/orders/{userId}")
	public ResponseEntity<List<Orders>> getOrdersByUserId(@PathVariable int userId) 
	{
	    List<Orders> orders = orderService.getAllOrdersByUserId(userId);
	    return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	//To retrieve orders using Order Status	
	
	@GetMapping("/orders/status/{orderStatus}")
	public ResponseEntity<List<Orders>> getOrdersByOrderStatus(@PathVariable String orderStatus) 
	{
		List<Orders> orders = orderService.getAllOrdersByOrderStatus(orderStatus);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
	
	
	//To add a new Order	
	@PostMapping("/addOrder")
	public ResponseEntity<String> addOrder(@RequestBody Orders order)
	{
		orderService.addOrder(order);
		return ResponseEntity.ok("Order Saved");
	}
	
	//To change order status (Pending,Out For Delivery, Delivered etc)
	@PutMapping("/orders/changeStatus/{orderId}")
	public ResponseEntity<String> changeOrderStatus(@PathVariable int orderId,@RequestBody Orders order) 
	{
		orderService.changeOrderStatus(orderId,order);
		return ResponseEntity.ok("Order Status Saved");
	}
	
	//To generate a cancellation request for order
	@PutMapping("/orders/cancelOrder/{orderId}")
	public ResponseEntity<String> cancelOrder(@PathVariable int orderId) 
	{
		orderService.cancelOrder(orderId);
		return ResponseEntity.ok("Requested to cancel");
	}
	
}
