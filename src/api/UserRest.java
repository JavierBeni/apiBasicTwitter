package api;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.domain.Message;
import api.domain.User;
import api.services.UserService;

@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserRest {

	//Return all posts of user
	@GET
	@Path("{userId}/wall")
	public Response wall(@PathParam("userId") long userId) {

		User u = getUser(userId);

		if (u == null)
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();
		
		Collections.sort(u.getMessages());

		return Response.ok(u.getMessages()).build();
	}

	//Add one user to the list of following of the user.
	@GET
	@Path("{userId}/follow/{followed}")
	public Response following(@PathParam("userId") long userId, @PathParam("followed") Long followed) {

		System.out.println("followed is: " + followed);
		User u = getUser(userId);

		if (u == null)
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();

		u.getFollowing().add(followed);

		return Response.ok(u).build();
	}

	//Return all messages of followed people
	@GET
	@Path("{userId}/timeline/")
	public Response timeline(@PathParam("userId") long userId) {

		User u = getUser(userId);

		if (u == null)
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();

		ArrayList<Message> messages = new ArrayList<Message>();

		for (Long id : u.getFollowing())
			messages.addAll(getUser(id).getMessages());

		Collections.sort(messages);
		
		return Response.ok(messages).build();
	}

	//Create a new post for the user.
	@POST
	@Path("{userId}")
	public Response postTwit(@PathParam("userId") long userId, String message) {

		System.out.println("message is: " + message);
		User u = getUser(userId);

		if (u == null)
			return Response.status(Status.BAD_REQUEST).entity("User not found").build();

		u.getMessages().add(new Message(new Date().getTime(), message));

		return Response.ok(u).build();
	}

	//Return the user
	public User getUser(Long userId) {

		System.out.println("userId ==> " + userId);
		List<User> found = UserService.users.stream().filter(x -> userId == x.getId().longValue())
				.collect(Collectors.toList());

		if (found.isEmpty())
			return null;

		return found.get(0);
	}

}