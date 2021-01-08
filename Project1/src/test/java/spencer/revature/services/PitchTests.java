package spencer.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.Test;

import spencer.revature.beans.Pitch;
import spencer.revature.beans.PitchStatus;
import spencer.revature.beans.Story;
import spencer.revature.beans.StoryType;
import spencer.revature.beans.Users;

class PitchTests {
	PitchService ps = new PitchServiceImpl();
	
	@Test
	void testPitchGetAll() {
		Set<Pitch> p = ps.getAll();
		assertTrue(p.size()>0);
	}
	@Test
	void testUpdatePitchStatus() {
		Pitch p = ps.getPitchById(10);
		PitchStatus pstat = p.getPitchStatus();
		pstat.setStatus("bogus");
		ps.updatePitchStatus(pstat);
		p = ps.getPitchById(10);
		String line = pstat.getStatus();
		pstat.setStatus("submitted");
		ps.updatePitchStatus(pstat);
		assertEquals("bogus", line);
	}
	@Test
	void testUpdatePitch() {
		Pitch p = ps.getPitchById(5);
		Users testUser = new Users();
		testUser.setId(3);
		p.setUser(testUser);
		ps.updatePitch(p);
		p = ps.getPitchById(5);
		int userid = p.getUser().getId();
		testUser.setId(2);
		p.setUser(testUser);
		ps.updatePitch(p);
		assertEquals(3, userid);
	}
	@Test
	void testPitchByID() {
		Pitch p = ps.getPitchById(5);
		assertEquals(5, p.getId());
	}

}
