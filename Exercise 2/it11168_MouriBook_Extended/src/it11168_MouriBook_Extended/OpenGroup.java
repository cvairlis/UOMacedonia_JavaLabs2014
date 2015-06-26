package it11168_MouriBook_Extended;

import java.util.ArrayList;
import java.util.LinkedList;

public class OpenGroup extends Group{
	
	private ArrayList<User> Members;
	private LinkedList<Post> Posts;
	
	/**
	 * This constructor implements the inheritance.
	 * 
	 * @param name
	 * @param description
	 * 
	 * @Added Members and Posts
	 */
	public OpenGroup(String name, String description) {
		super(name, description);
		Members = new ArrayList<User>();
		Posts = new LinkedList<Post>();
	}


	public ArrayList<User> getMembers() {
		return Members;
	}

	public void setMembers(ArrayList<User> members) {
		Members = members;
	}

	public LinkedList<Post> getPosts() {
		return Posts;
	}

	public void setPosts(LinkedList<Post> posts) {
		Posts = posts;
	}

	/**
	 * This method takes a User as a parameter and answers
	 * if this user is member of this group.
	 * 
	 * @param u
	 * @return true/false
	 */
	public boolean IsMember (User u) {
		if(!this.getMembers().contains(u)){
			return false ;
		} else { 
			System.out.println(u.getName() + " has already joined group: " + this.getName());
			return true; 
		}
	}
	
	/**
	 * This method takes a user as a parameter and adds it to the selected Group. 
	 * 
	 * @param u
	 */
	public void AddMember(User u){
		if (!IsMember(u)){
			Members.add(u);	
		}				
	}
	
	/**
	 * This method takes a post as a parameter and adds it to the selected Group Posts List. 
	 * 
	 * @param post
	 */	
	public void AddPost(Post post) {
		if (!getMembers().contains(this))
			Posts.add(post);
	}
		
	/**
	 * Every post has a comment field with Post type.
	 * This method takes two posts as parameters and sets in the post comment
	 * the given reply Post.
	 * 
	 * @param post, reply
	 */	
	public void AddReplyToPost(Post post, Post reply){
			post.setComment(reply);
	}
	
	/**
	 * This method prints every Post of the OpenGroup Wall.
	 * The procedure looks like complex, so i comment it to understand
	 * 
	 */
	public void PrintWall(){
		System.out.println("Group " + getName() + " wall");
		//for every post of the wall take the post and go to Print it.
		for (Post p: Posts){
			p.PrintPosts();
		}
	}
	
	
	/**
	 * This method returns as a String the latest Post of the selected Wall.
	 * 
	 */
	public String getLatestPost(){
		//dhmiourgoume mia topikh metavliti String replies 
		String replies = "";
		//sto alfarithmitiko replies prosthetoume to Post pou zhthte
		replies = replies + Posts.getLast().toString();
		//gia kathe post pou theloume na ektypwsoume ftiaksame thn takeAllReplies
		//sth klash Post h opoia epistrefei ena alfarithmitiko me ola comments
		//pou eginan katw apo auto to post
		replies = replies + Posts.getLast().takeAllReplies();
		//telika epistrefoume to string replies to opoio paei sth main gia ektypwsh
		return replies;
	}
	
	
}
