package api.domain;

public class Message implements Comparable<Message>{
	
	private Long id;
	private String content;
	
	public Message(Long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}
	
	public Message() {
		super();
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public int compareTo(Message m) {
		Long compareId = ((Message) m).getId();
		return (int) (this.id - compareId);

	}

}
