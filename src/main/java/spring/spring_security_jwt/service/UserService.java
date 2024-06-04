package spring.spring_security_jwt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.spring_security_jwt.model.AppUser;
import spring.spring_security_jwt.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<AppUser> getAllUsers(){
		return userRepository.findAll();
	}
	
	public Optional<AppUser> getUserById(Long id){
		return userRepository.findById(id);
	}
	
	public AppUser saveUser(AppUser user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
    	userRepository.deleteById(id);
    }
}
