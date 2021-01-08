package spencer.revature.services;

import java.util.Set;

import spencer.revature.beans.Genre;
import spencer.revature.beans.Pitch;
import spencer.revature.beans.PitchStatus;
import spencer.revature.beans.Story;
import spencer.revature.beans.Users;

public interface PitchService {
	// create
	public Integer addPitch(Pitch p);
	public Story addStory(Story story);
	public PitchStatus addPitchStat(PitchStatus ps);
	// read
	public Set<Pitch> getAll();
	public Pitch getPitchById(Integer id);
	// update
	public void updatePitch(Pitch p);
	public void updatePitchStatus(PitchStatus pitchstatus);
	// delete
	public abstract  void deletePitch(Pitch p);
	
	
	

}
