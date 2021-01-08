package spencer.revature.data;

public class PitchDAOFactory {
	public PitchDAO getPitchDAO() {
        
        return new PitchHibernate();
    }
}
