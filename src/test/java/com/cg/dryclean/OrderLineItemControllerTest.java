package com.cg.dryclean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cg.dryclean.entity.OrderLineItem;
import com.cg.dryclean.rest.OrderLineItemController;
import com.cg.dryclean.service.OrderService;


@ExtendWith(MockitoExtension.class)
public class OrderLineItemControllerTest {
	@Mock
	private OrderService orderLineItemService;
	@InjectMocks
	private OrderLineItemController orderLineItemController;
	
	@Test
	public void testAddOrderLineItem() {
		OrderLineItem a1 = new OrderLineItem();
		a1.setId(1);
		a1.setName("Gown");
		a1.setQuantity(2);
		a1.setMaterial("Silk");
		a1.setInstructions("clean");

		when(orderLineItemService.addItem(a1)).thenReturn(a1);
		ResponseEntity<String> actualResponse = orderLineItemController.addOrderLineItem(a1);

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Added", actualResponse.getBody());
	}
	
	
	@Test
	public void testUpdateOrderLineItem() {
		OrderLineItem a1 = new OrderLineItem();
		a1.setId(1);
		a1.setName("Gown");
		a1.setQuantity(2);
		a1.setMaterial("Silk");
		a1.setInstructions("clean");

		when(orderLineItemService.updateOrderLineItem(1,a1)).thenReturn(a1);
		ResponseEntity<String> actualResponse = orderLineItemController.updateOrderLineItem(1,a1);

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Updated", actualResponse.getBody());
	}
	
}
