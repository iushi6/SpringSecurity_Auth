package spring.spring_security_jwt.controller;


	import java.util.List;
	import java.util.Optional;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;

import spring.spring_security_jwt.model.AppUser;
import spring.spring_security_jwt.service.UserService;


	@RestController
	@RequestMapping
	public class UserController {
		
		
		@Autowired
		private UserService userService;
		
		
		@GetMapping("/all")
		public List<AppUser> getAllUsers(){
			return userService.getAllUsers();
		}
		
		@GetMapping("/{id}")
		public ResponseEntity<AppUser> getUserById(@PathVariable Long id){
			Optional<AppUser> em = userService.getUserById(id);
			if(em.isPresent()) {
				return ResponseEntity.ok(em.get());
			}else {
				return ResponseEntity.notFound().build();
			}
		}
		
		  @PostMapping
		    public AppUser createUser(@RequestBody AppUser user) {
		        return userService.saveUser(user);
		    }
		  
		  @PutMapping("/{id}")
		    public ResponseEntity<AppUser> updateEmployee(@PathVariable Long id, @RequestBody AppUser userDetails) {
		        Optional<AppUser> optionalUser = userService.getUserById(id);
		        if (optionalUser.isPresent()) {
		        	AppUser u = optionalUser.get();
		            u.setFirstname(userDetails.getFirstname());
		            u.setLastname(userDetails.getLastname());
		            u.setEmail(userDetails.getEmail());
		            u.setDepartment(userDetails.getDepartment());
		            return ResponseEntity.ok(userService.saveUser(u));
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }

		    @DeleteMapping("/{id}")
		    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		        Optional<AppUser> optionalUser = userService.getUserById(id);
		        if (optionalUser.isPresent()) {
		        	userService.deleteUser(id);
		            return ResponseEntity.noContent().build();
		        } else {
		            return ResponseEntity.notFound().build();
		        }
		    }
		    
		}