package com.cg.dryclean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cg.dryclean.entity.Orders;
import com.cg.dryclean.rest.OrderController;
import com.cg.dryclean.service.OrderService;


@ExtendWith(MockitoExtension.class)
public class OrderControllerTest {

	@Mock
	private OrderService orderService;
	@InjectMocks
	private OrderController orderController;
	
	@Test
	public void testfindAllOrders() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");
		
		Orders a2 = new Orders();
		a2.setId(1);
		a2.setAmount(150.00);
		a2.setOrderDate(new Date());
		a2.setDeliveryDate(new Date());
		a2.setPaymentStatus("Not Paid");
		a2.setOrderStatus("Pending");
		
		List<Orders> expectedOrders = new ArrayList<>();
		expectedOrders.add(a1);
		expectedOrders.add(a2);

		when(orderService.findAllOrders()).thenReturn(expectedOrders);
		ResponseEntity<List<Orders>> actualResponse = orderController.findAllOrders();
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(2, actualResponse.getBody().size());
	}
	
	@Test
	public void testGetOrderById() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");
		
		when(orderService.findOrderById(1)).thenReturn(a1);
		ResponseEntity<Orders> actualResponse = orderController.getOrderById(1);
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
	}
	
	
	@Test
	public void testGetOrdersByUserId() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");
		
		Orders a2 = new Orders();
		a2.setId(1);
		a2.setAmount(150.00);
		a2.setOrderDate(new Date());
		a2.setDeliveryDate(new Date());
		a2.setPaymentStatus("Not Paid");
		a2.setOrderStatus("Pending");
		
		List<Orders> expectedOrders = new ArrayList<>();
		expectedOrders.add(a1);
		expectedOrders.add(a2);

		when(orderService.getAllOrdersByUserId(1)).thenReturn(expectedOrders);
		ResponseEntity<List<Orders>> actualResponse = orderController.getOrdersByUserId(1);
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(2, actualResponse.getBody().size());
	}
	
	@Test
	public void testGetOrdersByOrderStatus() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");
		
		Orders a2 = new Orders();	
		a2.setId(1);
		a2.setAmount(150.00);
		a2.setOrderDate(new Date());
		a2.setDeliveryDate(new Date());
		a2.setPaymentStatus("Not Paid");
		a2.setOrderStatus("Pending");
		
		List<Orders> expectedOrders = new ArrayList<>();
		expectedOrders.add(a1);
		expectedOrders.add(a2);

		when(orderService.getAllOrdersByOrderStatus("Pending")).thenReturn(expectedOrders);
		ResponseEntity<List<Orders>> actualResponse = orderController.getOrdersByOrderStatus("Pending");
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(2, actualResponse.getBody().size());
	}
	
	@Test
	public void testAddOrder() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");
		
	
		when(orderService.addOrder(a1)).thenReturn(a1);
		ResponseEntity<String> actualResponse = orderController.addOrder(a1);

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Order Saved", actualResponse.getBody());
	}
	
	@Test
	public void testChangeOrderStatus() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");

		when(orderService.changeOrderStatus(1,a1)).thenReturn(a1);
		ResponseEntity<String> actualResponse = orderController.changeOrderStatus(1,a1);
		
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Order Status Saved", actualResponse.getBody());
	}
	
	@Test
	public void testCancelOrder() {
		Orders a1 = new Orders();
		a1.setId(1);
		a1.setAmount(150.00);
		a1.setOrderDate(new Date());
		a1.setDeliveryDate(new Date());
		a1.setPaymentStatus("Not Paid");
		a1.setOrderStatus("Pending");

		when(orderService. cancelOrder(1)).thenReturn(a1);
		ResponseEntity<String> actualResponse = orderController. cancelOrder(1);
		
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Requested to cancel", actualResponse.getBody());
	}
	
}
