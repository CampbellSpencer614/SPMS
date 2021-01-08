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
import spencer.revature.beans.Users;
import spencer.revature.utils.HibernateUtil;

public class GenreHibernate implements GenreDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Genre getById(Integer id) {
		Session s = hu.getSession();
		Genre g = s.get(Genre.class, id);
		s.close();
		return g;
	}

	@Override
	public Set<Genre> getAll() {
		Session s = hu.getSession();
		String query = "FROM Genre";
		Query<Genre> q = s.createQuery(query, Genre.class);
		List<Genre> GenreList = q.getResultList();
		Set<Genre> GenreSet = new HashSet<>();
		GenreSet.addAll(GenreList);
		s.close();
		return GenreSet;
	}

	@Override
	public Genre add(Genre t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Genre t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Genre t) {
		// TODO Auto-generated method stub
		
	}


}
