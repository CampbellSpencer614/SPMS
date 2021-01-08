package spencer.revature.app;

import static io.javalin.apibuilder.ApiBuilder.*;

import spencer.revature.controller.CollectionController;
import spencer.revature.controller.PitchController;
import spencer.revature.controller.UserController;

import io.javalin.Javalin;

public class Project1Javalin {
	
	public static void main(String[] args) {
		Javalin app = Javalin.create((config) -> {
			config.addStaticFiles("/static"); // pulling from src/main/resources
			config.enableCorsForAllOrigins();
		});
		
		app.start(8080);
		
		app.routes(() -> {
			// all requests to /users go to this handler
			path("users", () -> {
				get(UserController::checkLogin); // get logged in user
				put(UserController::logIn); // log in user
				delete(UserController::logOut); // log out user
				path ("all", () -> {
					get(UserController::getAllUsers); // get all users
				});
				path (":id", () -> {
					get(UserController::getUserById); // get user by id
				});
			});
			path("genres", () -> {
				get(CollectionController::getGenres); // get collections
			});
			path("pitch", () -> {
				put(PitchController::addPitch); // create pitch
				path ("all", () -> {
					get(PitchController::getAllPitchs); // get all pitches
				});
				path ("update", () -> {
					//put(PitchController::updatePitchStatus); // update pitch
				});
				path (":id", () -> {
					put(PitchController::updatePitchStatus); // update pitchstatus
					get(PitchController::getPitchById); // get pitch by id
				});
			});
		});
	}
}
