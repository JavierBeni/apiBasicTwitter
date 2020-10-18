package api.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HEAD;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import api.domain.User;
import api.domain.Message;

@Path("/users")
@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class UserService {

	// User database pre-initialization
	public static final List<User> users = new ArrayList<User>();

	static {
		users.add(new User(1L, "oscar",
				new ArrayList<Message>(
						List.of(new Message(1L, "primer twit de oscar"), new Message(2L, "segundo twit of oscar"))),
				new ArrayList<Long>(List.of(2L, 3L))));
		users.add(new User(2L, "juan",
				new ArrayList<Message>(
						List.of(new Message(1L, "primer twit de oscar"), new Message(2L, "segundo twit of oscar"))),
				new ArrayList<Long>(List.of(3L))));
		users.add(new User(3L, "maria",
				new ArrayList<Message>(
						List.of(new Message(1L, "primer twit de oscar"), new Message(2L, "segundo twit of oscar"))),
				new ArrayList<Long>()));
	}

	@GET
	public Response findAllUsers() {
		return Response.ok(this.users).build();
	}

	@POST
	public Response createUser(User userRequest) {
		userRequest.setId(users.size() + 1l);
		this.users.add(userRequest);
		return Response.ok(userRequest).build();
	}

}
