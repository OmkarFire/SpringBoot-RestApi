package in.sp.main.services;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sp.main.entities.User;
import in.sp.main.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userrepository;
	
	@Override
	public User createUser(User user) {
		
		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		
		return userrepository.findAll();
	}

	@Override
	public Optional<User> getUserDetailsById(int id) {


		return userrepository.findById(id);
	}

	@Override
	public User updateUserDetails(int id, User newuser) {
		
		User userData=userrepository.findById(id).orElse(null);
		if(userData !=null)
		{
			return userrepository.save(newuser);
		}
		else
		{
			throw new RuntimeException("User not found with id :"+id);
		}
		
	}

	@Override
	public void deleteUser(int id) {
		
		userrepository.deleteById(id);;
	}
	
}
