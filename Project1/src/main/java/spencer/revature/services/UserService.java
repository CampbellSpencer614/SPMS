package spencer.revature.services;

import java.util.Set;

import spencer.revature.beans.Users;

public interface UserService {
	// create
	public abstract Integer addPerson(Users u);
	// read
	public Set<Users> getAll();
	public Users getUserById(Integer id);
	public Users getUserByUsername(String username);
	// update
	public abstract  void updateUser(Users u);
	// delete
	public abstract  void deletePerson(Users u);

}
