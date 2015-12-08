package it11168_MouriBook;

import java.util.*;

public class User {
	
	/* A MouriBook User has a name and an e-mail.
	 * Users have a list with friends and one more list 
	 * for Groups that they enroll.
	 */	
	private String name;
	private String mail;
	private ArrayList<User> hasFriends;
	private ArrayList<Group> joinedGroups;
	
	/*
	 * Here is the User class constructor.
	 * Every user must be constructed with a name, an email
	 * a hasFriends list and a joinedGroups list.
	 */
	public User (String name, String mail){
		this.name = name;
		this.mail = mail;
		hasFriends = new ArrayList<User>();
		joinedGroups = new ArrayList<Group>();
	}

	/*
	 * Getters & Setters.
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public ArrayList<User> getHasFriends() {
		return hasFriends;
	}

	public ArrayList<Group> getJoinedGroups() {
		return joinedGroups;
	}
	
	
	/**
	 * This method takes another user as a parameter and returns
	 * if they are friends or not with true or false.
	 * 
	 * @param u
	 * @return true/false
	 */
	public boolean IsUseraFriend(User u){
		boolean isFriend = false;
		for (int i=0; i<hasFriends.size(); i++){
			if (name == hasFriends.get(i).getName() || u.hasFriends.contains(this)){
				isFriend = true;
			} else{
				isFriend = false;
			}
		}
		return isFriend;
	}
	
	/**
	 * This method adds to User hasFriends list another user
	 * that they are not friends yet. 
	 * 
	 * @param u
	 */
	public void AddFriend(User u){
		if(IsUseraFriend(u)){
			System.out.println(" !! Cannot add user " + getName() + " as a friend because ");
			System.out.println(" !! " + getName() + " and " + u.getName() + " are already friends!");			
		} else {			
			hasFriends.add(u);
			u.getHasFriends().add(this);
			System.out.println(getName() + " and " + u.getName() + " are now friends!");
		}
	}
	
	/**
	 * This method takes a Group as a parameter and adds 
	 * the User to this Group.
	 * @param g
	 */
	public void AddGroup (Group g){
		if (g.getMembers().contains(this)){
			System.out.println(" !*! " + name + " has already joined group: " + g.getName());
		} else {
			joinedGroups.add(g);
			g.AddMember(this);
		}
	}

	/**
	 * This method takes another user as a parameter and gives back
	 * a list with common friends of these two users.
	 * This method prints nothing.
	 * 
	 * @param u
	 */
	public ArrayList<User> FindCommonFriends (User u){
		ArrayList<User> commonFriends = new ArrayList<User>();
		for (int i=0; i<hasFriends.size(); i++){
			for (int j=0; j<u.hasFriends.size(); j++){
				if (hasFriends.get(i).name == u.hasFriends.get(j).name){
					commonFriends.add(hasFriends.get(i));
				}
			}
		}	
		return commonFriends;
	}
	
	/**
	 * This method takes another user as a parameter, uses the list described above
	 * and prints the two users common friend list.
	 * 
	 * @param u
	 */
	public void PrintCommonFriends (User u){
		int count=1;		
		System.out.println("**************************************");
		System.out.println("Common friends of " + this.getName() + " and " + u.getName());
		System.out.println("**************************************");
		ArrayList<User> commonFriends = FindCommonFriends(u);
		for (int i=0; i<commonFriends.size(); i++){
			System.out.println(count +": " +commonFriends.get(i).getName());
			count++;
		}
		System.out.println("--------------------------------------");
	}
	
	/**
	 * This method doesn't take any parameter but prints a users friendlist.
	 * 
	 */
	public void PrintHasFriends(){
		int c=0;
		System.out.println("************************");
		System.out.println("Friends of " + this.getName());
		System.out.println("************************");
		for (int i=0; i<hasFriends.size(); i++){
			c++;
			System.out.println(c + ": " + hasFriends.get(i).getName());				
		}
		System.out.println("-----------------------");
	}
	
	/**
	 * This method doesn't take any parameter but prints all groups that a user has joined.
	 * 
	 */
	public void PrintJoinedGroups(){
		int c=1;
		System.out.println("**************************************");
		System.out.println("Groups that " + this.getName() + " has enrolled");
		System.out.println("**************************************");
		for (int i=0; i<joinedGroups.size(); i++){			
			System.out.println(c + ": " + joinedGroups.get(i).getName());
			c++;
		}
		System.out.println("-----------------------------------");		
	}	
}
