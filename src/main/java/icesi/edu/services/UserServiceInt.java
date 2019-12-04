package icesi.edu.services;

import java.util.Optional;

import icesi.edu.model.UserApp;
import icesi.edu.model.UserGender;
import icesi.edu.model.UserType;

public interface UserServiceInt {

	public void save(UserApp user);

	public Optional<UserApp> findById(long id);

	public Iterable<UserApp> findAll();

	public Iterable<UserApp> findAllAdministrators();

	public Iterable<UserApp> findAllOperatos();

	public void delete(UserApp user);

	public UserGender[] getGenders();

	public UserType[] getTypes();
}
