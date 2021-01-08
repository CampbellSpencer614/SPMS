package spencer.revature.services;


import java.util.Set;

import spencer.revature.beans.Genre;
import spencer.revature.beans.Pitch;
import spencer.revature.beans.PitchStatus;
import spencer.revature.beans.Story;
import spencer.revature.beans.Users;
import spencer.revature.data.GenreDAO;
import spencer.revature.data.GenreDAOFactory;
import spencer.revature.data.PitchDAO;
import spencer.revature.data.PitchDAOFactory;
import spencer.revature.data.UserDAOFactory;
import spencer.revature.data.UsersDAO;

public class PitchServiceImpl implements PitchService {

	private PitchDAO pitchdao;
	
	public PitchServiceImpl() {
		PitchDAOFactory pitchDaoFactory = new PitchDAOFactory();
		pitchdao = pitchDaoFactory.getPitchDAO();
	}

	@Override
	public Set<Pitch> getAll() {
		return pitchdao.getAll();
	}
	@Override
	public Integer addPitch(Pitch p) {
		
		return pitchdao.add(p).getId();
	}
	@Override
	public Story addStory(Story story) {
		// TODO Auto-generated method stub
		return pitchdao.addStory(story);
	}

	@Override
	public PitchStatus addPitchStat(PitchStatus ps) {
		return pitchdao.addPitchStatus(ps);
		
	}
	@Override
	public void updatePitchStatus(PitchStatus pitchstatus) {
		pitchdao.updateStatus(pitchstatus);
		
	}
	@Override
	public void updatePitch(Pitch p) {
		pitchdao.update(p);
		
	}
	@Override
	public Pitch getPitchById(Integer id) {
		return pitchdao.getById(id);
	}

	

	@Override
	public void deletePitch(Pitch p) {
		// TODO Auto-generated method stub
		
	}

	

	

}
