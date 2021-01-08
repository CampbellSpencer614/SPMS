package spencer.revature.controller;

import spencer.revature.beans.Genre;
import spencer.revature.beans.Users;
import spencer.revature.services.GenreService;
import spencer.revature.services.GenreServiceImpl;
import spencer.revature.services.UserService;
import spencer.revature.services.UserServiceImpl;

import java.util.Set;
import io.javalin.http.Context;

public class CollectionController {
	private static GenreService GenreServ = new GenreServiceImpl();
	

	public static void getGenres(Context ctx) {
		Set<Genre> Genre = GenreServ.getAll();
		if (Genre != null) {
			ctx.status(200);
			ctx.json(Genre);
		} else {
			ctx.status(404);
		}
	}
	
}
