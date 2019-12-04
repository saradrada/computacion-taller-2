package icesi.edu.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import icesi.edu.model.UserApp;
import icesi.edu.model.UserGender;
import icesi.edu.model.UserType;
import icesi.edu.repositories.UserRepository;

public class UserService implements UserServiceInt{
	private UserRepository userRepository;

	@Autowired
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void save(UserApp user) {
		userRepository.save(user);

	}

	public Optional<UserApp> findById(long id) {

		return userRepository.findById(id);
	}

	public Iterable<UserApp> findAll() {
		return userRepository.findAll();
	}
	
	public Iterable<UserApp> findAllAdministrators() {
		return userRepository.findByType(UserType.admin);
	}
	
	public Iterable<UserApp> findAllOperatos() {
		return userRepository.findByType(UserType.operator);
	}


	public void delete(UserApp user) {
		userRepository.delete(user);

	}

	public UserGender[] getGenders() {
		
		return UserGender.values();
	}

	public UserType[] getTypes() {
		// TODO Auto-generated method stub
		return UserType.values();
	}


}
