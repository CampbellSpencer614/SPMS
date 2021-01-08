package spencer.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;



import org.hibernate.Session;
import org.hibernate.Transaction;

import spencer.revature.beans.Genre;
import spencer.revature.beans.StoryType;
import spencer.revature.beans.Users;
import spencer.revature.utils.HibernateUtil;

public class StoryTypeHibernate implements StoryTypeDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public StoryType getById(Integer id) {
		Session s = hu.getSession();
		StoryType g = s.get(StoryType.class, id);
		s.close();
		return g;
	}

	@Override
	public Set<StoryType> getAll() {
		Session s = hu.getSession();
		String query = "FROM StoryType";
		Query<StoryType> q = s.createQuery(query, StoryType.class);
		List<StoryType> StoryTypeList = q.getResultList();
		Set<StoryType> StoryTypeSet = new HashSet<>();
		StoryTypeSet.addAll(StoryTypeList);
		s.close();
		return StoryTypeSet;
	}

	
	@Override
	public StoryType add(StoryType t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(StoryType t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StoryType t) {
		// TODO Auto-generated method stub
		
	}


}
