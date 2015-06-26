package it11168_MouriBook;

import java.util.*;

public class Group {
	
	/* A MouriBook Group has a name and a description.
	 * Every group has also a list with members.
	 */
	private String name;
	private String description;
	private ArrayList<User> Members;
	
	/*
	 * Here is the Group class constructor.
	 */
	public Group(String name,String description){
		this.name=name;
		this.description = description;
		Members = new ArrayList<User>();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<User> getMembers() {
		return Members;
	}

	public void setMembers(ArrayList<User> members) {
		Members = members;
	}

	/**
	 * This method takes a User as a parameter and answers
	 * if this user is member of this group.
	 * 
	 * @param u
	 * @return true/false
	 */
	public boolean IsMember (User u) {
		if(this.getMembers().contains(u)){
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
		if (IsMember(u)){
			Members.add(u);	
		}
							
	}

	/**
	 * This method doesn't take any parameter but prints all members of a selected Group.
	 * 
	 */
	public void PrintGroupMembers(){
		int counter=0;
		int s=Members.size();
		System.out.println("*******************************");
		System.out.println("Members of group " + this.getName());
		System.out.println("*******************************");
		
		for(int i=0; i<s; i++){
			counter++;
			System.out.println(counter + ": " + Members.get(i).getName());
		}
		System.out.println("------------------------------");
	}
	
	
}
