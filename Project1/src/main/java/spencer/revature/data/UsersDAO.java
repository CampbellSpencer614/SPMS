package spencer.revature.data;

import java.util.Set;

import spencer.revature.beans.Users;

public interface UsersDAO extends GenericDAO<Users> {
	public Users add(Users u);
	public Set<Users> getAvailableUsers();
	Users getByUsername(String username);
}
