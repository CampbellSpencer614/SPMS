package spencer.revature.data;

import java.util.Set;

import spencer.revature.beans.Genre;
import spencer.revature.beans.Pitch;
import spencer.revature.beans.PitchStatus;
import spencer.revature.beans.Story;
import spencer.revature.beans.Users;

public interface PitchDAO extends GenericDAO<Pitch> {
	public Pitch add(Pitch u);
	public Set<Pitch> getAvailablePitchs();
	public PitchStatus addPitchStatus(PitchStatus ps);
	public Story addStory(Story story);
	public void updateStatus(PitchStatus pitchstatus);
}
