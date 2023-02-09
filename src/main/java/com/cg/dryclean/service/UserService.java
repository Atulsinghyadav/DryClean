package com.cg.dryclean.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.dryclean.entity.Addresses;
import com.cg.dryclean.entity.Usernames;
import com.cg.dryclean.exception.AddressNotFoundException;
import com.cg.dryclean.exception.EmptyInputException;
import com.cg.dryclean.exception.UserNotFoundException;
import com.cg.dryclean.repository.AddressRepo;
import com.cg.dryclean.repository.UsersRepo;

@Service
public class UserService {
	
	@Autowired
	private UsersRepo usersRepo;
	@Autowired
	private AddressRepo addressRepo;
	
	//to display all users present in database
	public List<Usernames> getAllUsers() 
	{
	    return usersRepo.findAll();
	}
	
	//to display user with a specific id
	public Usernames getUser(int userid)
	{
		//if there is no user with given id then throw user-defined exception		
		if(!usersRepo.existsById(userid)) 
		{
			throw new UserNotFoundException();
		}
		return usersRepo.findById(userid).get();
	}
	
	//to add a new user into database
	public Usernames addUser(Usernames user)
	{	
		//if user name is empty then throw user-defined exception
		if(user.getName().isEmpty() || user.getName().length()==0) 
		{
			throw new EmptyInputException();
		}
		return usersRepo.save(user);
	}
	
	//to change password of existing user
	public Usernames changePassword(int id, Usernames user)
	{
		Usernames existingUser = usersRepo.findById(id).get();
		existingUser.setPassword(user.getPassword());
		return usersRepo.save(existingUser);
	}
	
	//to update existing user details	
	public Usernames updateUser(int id, Usernames user)
	{
		//if there is no user with given id then throw user-defined exception		
		if(!usersRepo.existsById(id)) 
		{
			throw new UserNotFoundException();
		}
		Usernames existingUser = usersRepo.findById(id).get();
		existingUser.setName(user.getName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		existingUser.setContactNo(user.getContactNo());
		existingUser.setRole(user.getRole());
		existingUser.setAddress(user.getAddress());
		return usersRepo.save(existingUser);
	}
	
	//to display all addresses present in database
	public List<Addresses> findAllAddresses()
	{
		return addressRepo.findAll();
	}
	
	//to add a new address into database
	public Addresses addAddress(Addresses address)
	{
		//if street name is empty then throw user-defined exception
		if(address.getStreet().isEmpty() || address.getStreet().length()==0) 
		{
			throw new EmptyInputException();
		}
		return addressRepo.save(address);
	}
	
	//to display address with a specific id
	public Addresses findAddressById(int id)
	{
		//if there is no address with given id then throw user-defined exception
		if(!addressRepo.existsById(id)) 
		{
			throw new AddressNotFoundException();
		}
		return addressRepo.findById(id).get();
	}
	
	//to update existing address details	
	public Addresses updateAddress(int id, Addresses address) 
	{
		//if there is no address with given id then throw user-defined exception
		if(!addressRepo.existsById(id)) 
		{
			throw new AddressNotFoundException();
		}
		Addresses existingAdd = addressRepo.findById(id).get();
		existingAdd.setDoorNo(address.getDoorNo());
		existingAdd.setStreet(address.getStreet());
		existingAdd.setArea(address.getArea());
		existingAdd.setCity(address.getCity());
		existingAdd.setState(address.getState());
		existingAdd.setPincode(address.getPincode());
		return addressRepo.save(existingAdd);
	}
	
	//to delete address with a specific id
	public void deleteAddressById(int addressid)
	{
		//if there is no address with given id then throw user-defined exception
		if(!addressRepo.existsById(addressid)) 
		{
			throw new AddressNotFoundException();
		}
		addressRepo.deleteById(addressid);
	}
	 
}