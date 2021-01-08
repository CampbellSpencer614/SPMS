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

import spencer.revature.beans.Pitch;
import spencer.revature.beans.PitchStatus;
import spencer.revature.beans.Story;
import spencer.revature.beans.Users;
import spencer.revature.utils.HibernateUtil;

public class PitchHibernate implements PitchDAO {
	private HibernateUtil hu = HibernateUtil.getHibernateUtil();

	@Override
	public Pitch getById(Integer id) {
		Session s = hu.getSession();
		Pitch p = s.get(Pitch.class, id);
		s.close();
		return p;
	}

	@Override
	public Set<Pitch> getAll() {
		Session s = hu.getSession();
		String query = "FROM Pitch";
		Query<Pitch> q = s.createQuery(query, Pitch.class);
		List<Pitch> PitchList = q.getResultList();
		Set<Pitch> PitchSet = new HashSet<>();
		PitchSet.addAll(PitchList);
		s.close();
		return PitchSet;
	}

	@Override
	public void update(Pitch t) {
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
	public Pitch add(Pitch p) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(p);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
		return p;
	}

	@Override
	public PitchStatus addPitchStatus(PitchStatus ps) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(ps);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
		return ps;
	}

	@Override
	public Story addStory(Story story) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.save(story);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
		return story;
	}
	@Override
	public void updateStatus(PitchStatus pitchstatus) {
		Session s = hu.getSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			s.update(pitchstatus);
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
		} finally {
			s.close();
		}
	}
	
	
	@Override
	public void delete(Pitch t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Pitch> getAvailablePitchs() {
		// TODO Auto-generated method stub
		return null;
	}

	


}
