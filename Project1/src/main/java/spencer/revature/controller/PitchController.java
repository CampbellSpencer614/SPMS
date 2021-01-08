package spencer.revature.controller;

import spencer.revature.beans.Draft;
import spencer.revature.beans.Genre;
import spencer.revature.beans.Pitch;
import spencer.revature.beans.PitchStatus;
import spencer.revature.beans.Story;
import spencer.revature.beans.StoryType;
import spencer.revature.beans.Users;
import spencer.revature.services.GenreService;
import spencer.revature.services.GenreServiceImpl;
import spencer.revature.services.PitchService;
import spencer.revature.services.PitchServiceImpl;
import spencer.revature.services.UserService;
import spencer.revature.services.UserServiceImpl;

import java.util.Set;


import io.javalin.http.Context;

public class PitchController {
	private static PitchService PitchServ = new PitchServiceImpl();
	private static UserService UserServ = new UserServiceImpl();
	private static GenreService GenreServ = new GenreServiceImpl();
	
	public static void addPitch(Context ctx) {
		Pitch pitch = new Pitch();
		PitchStatus ps = new PitchStatus();
		Story story = new Story();
		StoryType st = new StoryType();
		Draft draft = new Draft();
		
		Integer storyTypeId = Integer.parseInt(ctx.queryParam("storytype"));
		Integer genreId = Integer.parseInt(ctx.queryParam("genre"));
		
		st.setId(storyTypeId);
		
		story.setTitle(ctx.queryParam("title"));
		story.setTagline(ctx.queryParam("tagline"));
		story.setDetailed_desc(ctx.queryParam("desc"));
		story.setStoryType(st);
		story.setGenre(GenreServ.getGenreById(genreId));
		draft.setId(1);
		story.setDraft(draft);
		pitch.setUser(UserServ.getUserByUsername(ctx.queryParam("username")));
		ps.setStatus("submitted");
		
		story=PitchServ.addStory(story);
		ps=PitchServ.addPitchStat(ps);
		pitch.setStory(story);
		pitch.setPitchStatus(ps);
		PitchServ.addPitch(pitch);
		ctx.status(201);
	}

	public static void getAllPitchs(Context ctx) {
		Set<Pitch> Pitchs = PitchServ.getAll();
		if (Pitchs != null) {
			ctx.status(200);
			ctx.json(Pitchs);
		} else {
			ctx.status(404);
		}
	}
	public static void updatePitch(Context ctx) {
		Pitch pitch = ctx.bodyAsClass(Pitch.class);
		if (pitch  != null) {
			ctx.status(200);
			PitchServ.updatePitch(pitch);
		} else {
			ctx.status(404);
		}
	}
		public static void updatePitchStatus(Context ctx) {
			PitchStatus pitchstatus = ctx.bodyAsClass(PitchStatus.class);
			if (pitchstatus  != null) {
				ctx.status(202);
				PitchServ.updatePitchStatus(pitchstatus);
			} else {
				ctx.status(404);
			}
	}
		public static void getPitchById(Context ctx) {
			Integer id = Integer.valueOf(ctx.pathParam("id"));
			Pitch p = PitchServ.getPitchById(id);
			if (p != null) {
				ctx.status(200);
				ctx.json(p);
			} else {
				ctx.status(404);
			}
		}
	
}
