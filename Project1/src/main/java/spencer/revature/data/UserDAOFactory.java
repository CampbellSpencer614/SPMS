package spencer.revature.data;

public class UserDAOFactory {
	public UsersDAO getUserDAO() {
        
        return new UsersHibernate();
    }
}
