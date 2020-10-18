package api.domain;

import java.util.ArrayList;

public class User{

	private Long id;
	private String username;
	private ArrayList<Message> messages;
	private ArrayList<Long> following;

	public User() {
	}

	public User(long id, String username, ArrayList<Message> messages, ArrayList<Long> following) {
		super();
		this.id = id;
		this.username = username;
		this.messages = messages;
		this.following = following;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Message> getMessages() {
		return messages;
	}

	public void setMessages(ArrayList<Message> messages) {
		this.messages = messages;
	}

	public ArrayList<Long> getFollowing() {
		return following;
	}

	public void setFollowing(ArrayList<Long> following) {
		this.following = following;
	}

	
}
