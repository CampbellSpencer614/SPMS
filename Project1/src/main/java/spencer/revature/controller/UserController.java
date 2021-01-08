package spencer.revature.controller;

import spencer.revature.beans.Users;
import spencer.revature.services.UserService;
import spencer.revature.services.UserServiceImpl;

import java.util.Set;
import io.javalin.http.Context;

public class UserController {
	private static UserService UserServ = new UserServiceImpl();
	public static void checkLogin(Context ctx) {
		Users u = ctx.sessionAttribute("user");
		if (u != null) {
			ctx.json(u);
			ctx.status(200);
		} else {
			ctx.status(400);
		}
	}
	public static void logIn(Context ctx) {
		//System.out.println("Logging in");
		String username = ctx.queryParam("user");
		String password = ctx.queryParam("pass");
		//System.out.println(username+" "+password);
		Users u = UserServ.getUserByUsername(username);
		if (u != null) {
			if (u.getPass().equals(password))
			{
				System.out.println("Logged in as " + u.getUsername());
				ctx.status(200);
				ctx.json(u);
				ctx.sessionAttribute("user", u);
			}
			else
			{
				// password mismatch
				ctx.status(400);
			}
		}
		else
		{
			// username not found
			ctx.status(404);
		}
	}
	
	public static void logOut(Context ctx) {
		System.out.println("Logging out");
		ctx.req.getSession().invalidate();
		ctx.status(200);
	}
	
	public static void getAllUsers(Context ctx) {
		Set<Users> Users = UserServ.getAll();
		if (Users != null) {
			ctx.status(200);
			ctx.json(Users);
		} else {
			ctx.status(404);
		}
	}
	
	public static void getUserById(Context ctx) {
		Integer id = Integer.valueOf(ctx.pathParam("id"));
		Users u = UserServ.getUserById(id);
		if (u != null) {
			ctx.status(200);
			ctx.json(u);
		} else {
			ctx.status(404);
		}
	}
}
