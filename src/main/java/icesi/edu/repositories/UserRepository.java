package icesi.edu.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import icesi.edu.model.UserApp;
import icesi.edu.model.UserType;

public interface UserRepository extends CrudRepository<UserApp, Long> {

	List<UserApp> findByName(String name);
	
	List<UserApp> findByUsername(String username);
	
	List<UserApp> findByType(UserType type);

}
