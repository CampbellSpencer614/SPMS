package spencer.revature.services;


import java.util.Set;

import spencer.revature.beans.Genre;
import spencer.revature.beans.StoryType;
import spencer.revature.beans.Users;
import spencer.revature.data.GenreDAO;
import spencer.revature.data.GenreDAOFactory;
import spencer.revature.data.StoryTypeDAO;
import spencer.revature.data.StoryTypeDAOFactory;
import spencer.revature.data.UserDAOFactory;
import spencer.revature.data.UsersDAO;

public class GenreServiceImpl implements GenreService {

	private GenreDAO genredao;
	private StoryTypeDAO storytypedao;
	
	public GenreServiceImpl() {
		GenreDAOFactory genreDaoFactory = new GenreDAOFactory();
		genredao = genreDaoFactory.getGenreDAO();
		

		StoryTypeDAOFactory storytypeFactory = new StoryTypeDAOFactory();
		storytypedao = storytypeFactory.getStoryTypeDAO();
	}
	
	@Override
	public StoryType getStoryTypeById(Integer id) {
		return storytypedao.getById(id);
	}
	
	@Override
	public Set<Genre> getAll() {
		return genredao.getAll();
	}
	@Override
	public Integer addGenre(Genre g) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Genre getGenreById(Integer id) {
		return genredao.getById(id);
	}

	@Override
	public void updateGenre(Genre g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteGenre(Genre g) {
		// TODO Auto-generated method stub
		
	}

}
