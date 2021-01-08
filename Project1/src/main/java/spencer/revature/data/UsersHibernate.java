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

import spencer.revature.beans.Users;
import spencer.revature.utils.HibernateUtil;

public class UsersHibernate implements UsersDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Users getById(Integer id) {
		Session s = hu.getSession();
		Users u = s.get(Users.class, id);
		s.close();
		return u;
	}

	@Override
	public Set<Users> getAll() {
		Session s = hu.getSession();
		String query = "FROM Users";
		Query<Users> q = s.createQuery(query, Users.class);
		List<Users> UsersList = q.getResultList();
		Set<Users> UsersSet = new HashSet<>();
		UsersSet.addAll(UsersList);
		s.close();
		return UsersSet;
	}

	@Override
	public void update(Users t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public void delete(Users t) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.delete(t);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
	}

	@Override
	public Users add(Users u) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(u);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
		return u;
	}

	@Override
	public Users getByUsername(String username) {
		Session s = hu.getSession();
		String query = "FROM Users AS u where u.username = '"+username+"'";
		Query<Users> q = s.createQuery(query, Users.class);
		List<Users> UsersList = q.getResultList();
		s.close();
		if(UsersList==null)
			return null;
		return UsersList.get(0);
	}
	
	@Override
	public Set<Users> getAvailableUsers() {
		Session s = hu.getSession();
		String query = "FROM Cat where status.name = :status"; ///ned to cahnge dis
		Query<Users> q = s.createQuery(query, Users.class);
		q.setParameter("status", "Available");
		List<Users> UsersList = q.getResultList();
		Set<Users> UsersSet = new HashSet<>();
		UsersSet.addAll(UsersList);
		s.close();
		return UsersSet;
	}


}
