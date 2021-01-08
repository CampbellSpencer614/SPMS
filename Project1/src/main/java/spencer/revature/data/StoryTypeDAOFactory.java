package spencer.revature.data;

public class StoryTypeDAOFactory {
	public StoryTypeDAO getStoryTypeDAO() {
        
        return new StoryTypeHibernate();
    }
}
