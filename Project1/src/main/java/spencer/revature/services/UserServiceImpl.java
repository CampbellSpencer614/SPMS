package spencer.revature.services;


import java.util.Set;

import spencer.revature.beans.Users;
import spencer.revature.data.UserDAOFactory;
import spencer.revature.data.UsersDAO;

public class UserServiceImpl implements UserService {

	private UsersDAO userdao;
	
	public UserServiceImpl() {
		UserDAOFactory userDaoFactory = new UserDAOFactory();
		userdao = userDaoFactory.getUserDAO();
	}

	@Override
	public Set<Users> getAll() {
		return userdao.getAll();
	}
	
	@Override
	public Users getUserById(Integer id) {
		return userdao.getById(id);
	}

	@Override
	public Users getUserByUsername(String username) {
		//unused
		return userdao.getByUsername(username);
	}

	@Override
	public void updateUser(Users u) {
		// unused
		
	}

	@Override
	public void deletePerson(Users u) {
		// unused
		
	}


	@Override
	public Integer addPerson(Users u) {
		// unused
		return null;
	}

}
