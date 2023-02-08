package com.cg.dryclean.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.OrderLineItem;
import com.cg.dryclean.service.OrderService;

@RestController
public class OrderLineItemController {
	
	@Autowired
	private OrderService orderLineItemService;
	
	@PostMapping("/addOrderLineItem")
	public ResponseEntity <String> addOrderLineItem(@RequestBody OrderLineItem item)
	{
		orderLineItemService.addItem(item);
		return ResponseEntity.ok("Added");
	}
	
	//	updating Items
	//	....................................
	@PutMapping("/orderLineItem/{id}")
	 public OrderLineItem updateOrderLineItem(@PathVariable int id, @RequestBody OrderLineItem orderLineItem) 
	{
	    return orderLineItemService.updateOrderLineItem(id, orderLineItem);
	}	
}
