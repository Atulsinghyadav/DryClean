package com.cg.dryclean.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.dryclean.entity.OrderLineItem;
import com.cg.dryclean.service.OrderService;
@CrossOrigin(origins= "http://localhost:3000")
@RestController
public class OrderLineItemController {
	
	@Autowired
	private OrderService orderLineItemService;
	
	//To add an OrderLineItem
	@PostMapping("/addOrderLineItem")
	public ResponseEntity <String> addOrderLineItem(@RequestBody OrderLineItem item)
	{
		orderLineItemService.addItem(item);
		return ResponseEntity.ok("Added");
	}
	
	//To update an OrderLineItem
	@PutMapping("/orderLineItem/{id}")
	 public ResponseEntity <String> updateOrderLineItem(@PathVariable int id, @RequestBody OrderLineItem orderLineItem) 
	{
	    orderLineItemService.updateOrderLineItem(id, orderLineItem);
	    return ResponseEntity.ok("Updated");
	}	
}
