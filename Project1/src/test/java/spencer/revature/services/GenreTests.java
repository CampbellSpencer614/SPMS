package spencer.revature.services;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import spencer.revature.beans.Genre;
import spencer.revature.beans.StoryType;
import spencer.revature.data.GenreDAO;
import spencer.revature.data.GenreDAOFactory;
import spencer.revature.data.StoryTypeDAO;
import spencer.revature.data.StoryTypeDAOFactory;

class GenreTests {
	GenreService gs = new GenreServiceImpl();;
	@BeforeAll
	public static void init(){
		
		GenreDAOFactory genreDaoFactory = new GenreDAOFactory();
		GenreDAO genredao = genreDaoFactory.getGenreDAO();
		

		StoryTypeDAOFactory storytypeFactory = new StoryTypeDAOFactory();
		StoryTypeDAO storytypedao = storytypeFactory.getStoryTypeDAO();
	}

	@Test
	void testGenreId() {
		Genre Genre = gs.getGenreById(1);
		assertEquals("Horror", Genre.getGenre());
	}
	@Test
	void testGenreAll() {
		Set<Genre> Genres = gs.getAll();
		assertTrue(Genres.size()>0);
	}
	@Test
	void testGetStoryTypeByID() {
		StoryType st = gs.getStoryTypeById(1);
		assertEquals("novel", st.getStorytype());
	}

}
