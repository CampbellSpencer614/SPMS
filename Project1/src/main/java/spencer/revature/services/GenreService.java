package spencer.revature.services;

import java.util.Set;

import spencer.revature.beans.Genre;
import spencer.revature.beans.StoryType;
import spencer.revature.beans.Users;

public interface GenreService {
	// create
	public abstract Integer addGenre(Genre g);
	// read
	public Set<Genre> getAll();
	public Genre getGenreById(Integer id);
	public StoryType getStoryTypeById(Integer id);
	// update
	public abstract  void updateGenre(Genre g);
	// delete
	public abstract  void deleteGenre(Genre g);
	

}
