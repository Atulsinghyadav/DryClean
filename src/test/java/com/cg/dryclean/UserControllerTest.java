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
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.rest.UserController;
import com.cg.dryclean.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {
	
	@Mock
	private UserService userService;
	@InjectMocks
	private UserController userController;
	
	@Test
	public void testGetAllUsers() {
		Usernames a1 = new Usernames();
		a1.setId(1);
		a1.setName("Lily");
		a1.setEmail("Potter");
		a1.setPassword("evans@testmail.com");
		a1.setContactNo("5678876588");
		a1.setRole("customer");
		
		Usernames a2 = new Usernames();
		a2.setId(1);
		a2.setName("James");
		a2.setEmail("Potter");
		a2.setPassword("potter@testmail.com");
		a2.setContactNo("8899776655");
		a2.setRole("customer");
		
		
		List<Usernames> expectedUsers = new ArrayList<>();
		expectedUsers.add(a1);
		expectedUsers.add(a2);

		when(userService.getAllUsers()).thenReturn(expectedUsers);
		ResponseEntity<List<Usernames>> actualResponse = userController.getAllUsers();
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(2, actualResponse.getBody().size());
	}
	
	
	@Test
	public void testGetUser() {
		Usernames a1 = new Usernames();
		a1.setId(1);
		a1.setName("Lily");
		a1.setEmail("Potter");
		a1.setPassword("evans@testmail.com");
		a1.setContactNo("5678876588");
		a1.setRole("customer");
		
		when(userService.getUser(1)).thenReturn(a1);
		ResponseEntity<Usernames> actualResponse = userController.getUser(1);
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
	}
	
	@Test
	public void testAddUser() {
		Usernames a1 = new Usernames();
		a1.setId(1);
		a1.setName("Lily");
		a1.setEmail("Potter");
		a1.setPassword("evans@testmail.com");
		a1.setContactNo("5678876588");
		a1.setRole("customer");
		
		when(userService.addUser(a1)).thenReturn(a1);
		ResponseEntity<Usernames> actualResponse = userController.addUser(a1);
		
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(a1, actualResponse.getBody());
	}
	
	@Test
	public void testUpdateUser() {
		Usernames a1 = new Usernames();
		a1.setId(1);
		a1.setName("Lily");
		a1.setEmail("Potter");
		a1.setPassword("evans@testmail.com");
		a1.setContactNo("5678876588");
		a1.setRole("customer");

		when(userService.updateUser(1,a1)).thenReturn(a1);
		ResponseEntity<Usernames> actualResponse = userController.updateUser(1,a1);
		
		assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
		assertEquals(a1, actualResponse.getBody());
	}
	
}
