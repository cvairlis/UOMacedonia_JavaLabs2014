package it11168_MouriBook_Extended;

public abstract class Group {
	
	private String name;
	private String description;
		
	
	public Group(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void AddMember(User u);
	public abstract void AddPost(Post post);
	public abstract void AddReplyToPost(Post post, Post reply);
	public abstract void PrintWall();
	public abstract String getLatestPost();
	
}
