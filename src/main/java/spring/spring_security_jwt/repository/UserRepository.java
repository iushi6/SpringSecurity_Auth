package spring.spring_security_jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import spring.spring_security_jwt.modal.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser,Long>{

	

	


}
