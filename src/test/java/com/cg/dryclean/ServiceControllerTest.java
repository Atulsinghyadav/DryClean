package com.cg.dryclean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cg.dryclean.entity.Services;
import com.cg.dryclean.rest.ServiceController;
import com.cg.dryclean.service.OrderService;

@ExtendWith(MockitoExtension.class)
public class ServiceControllerTest {
	@Mock
	private OrderService serviceService;
	@InjectMocks
	private ServiceController serviceController;
	
	@Test
	public void testFindAllServices() {
		Services s1 = new Services();
		s1.setId(1);
		s1.setType("Laundry");
		s1.setCharges(new BigDecimal(150.00));
		
		Services s2 = new Services();
		s2.setId(2);
		s2.setType("DryClean");
		s2.setCharges(new BigDecimal(200.00));
		
		List<Services> expectedServices = new ArrayList<>();
		expectedServices.add(s1);
		expectedServices.add(s2);

		when(serviceService.findAllServices()).thenReturn(expectedServices);
		ResponseEntity<List<Services>> actualResponse = serviceController.findAllServices();
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(2, actualResponse.getBody().size());

	}
	
	@Test
	public void testAddService() {
		Services s1 = new Services();
		s1.setId(1);
		s1.setType("Laundry");
		s1.setCharges(new BigDecimal(150.00));
		Services expectedService = s1;
		
		when(serviceService.addService(expectedService)).thenReturn(expectedService);
		ResponseEntity<String> actualResponse = serviceController.addNewService(expectedService);

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Service Saved", actualResponse.getBody());

	}

}