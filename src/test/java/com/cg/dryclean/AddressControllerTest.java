package com.cg.dryclean;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.cg.dryclean.entity.Addresses;
import com.cg.dryclean.rest.AddressController;
import com.cg.dryclean.service.UserService;

@ExtendWith(MockitoExtension.class)
public class AddressControllerTest {
	
	@Mock
	private UserService addressService;
	@InjectMocks
	private AddressController addressController;
	
	@Test
	public void testfindAllAddresses() {
		Addresses a1 = new Addresses();
		a1.setId(1);
		a1.setDoorNo("2");
		a1.setStreet("New");
		a1.setArea("Park");
		a1.setCity("Lko");
		a1.setState("UP");
		a1.setPincode(222222);
		
		Addresses a2 = new Addresses();
		a2.setId(2);
		a2.setDoorNo("10");
		a2.setStreet("Old");
		a2.setArea("Museum");
		a2.setCity("Ayodhya");
		a2.setState("UP");
		a2.setPincode(222333);
		
		
		List<Addresses> expectedAddresses = new ArrayList<>();
		expectedAddresses.add(a1);
		expectedAddresses.add(a2);

		when(addressService.findAllAddresses()).thenReturn(expectedAddresses);
		ResponseEntity<List<Addresses>> actualResponse = addressController.findAllAddresses();
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(2, actualResponse.getBody().size());

	}
	
	@Test
	public void testAddService() {
		Addresses a1 = new Addresses();
		a1.setId(1);
		a1.setDoorNo("2");
		a1.setStreet("New");
		a1.setArea("Park");
		a1.setCity("Lko");
		a1.setState("UP");
		a1.setPincode(222222);
		
		
		when(addressService.addAddress(a1)).thenReturn(a1);
		ResponseEntity<String> actualResponse = addressController.addAddress(a1);

		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals("Address Saved", actualResponse.getBody());

	}

}
