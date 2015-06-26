package it11168_MouriBook_Extended;



import java.sql.Timestamp;
import java.util.*;

public class User {
	
	/* A MouriBook User has a name and an e-mail.
	 * Users have a list with friends and one more list 
	 * for Groups that they enroll.
	 */
	
	private String name;
	private String mail;
	/* Every user has a hasFriend list
	 * Inside this list we store every User friends.
	 * For example u1.hasFriends.size() returns how many friends has u1 = user 1= Teo.
	 * Of course, hasFriends contains User entities, that's why User is inside<>.
	 */
	private ArrayList<User> hasFriends;
	/* The same things here.
	 * Every user has a list that shows the Groups he has enrolled.
	 * joinedGroups contains Group entities.
	 */
	private ArrayList<Group> joinedGroups;
	
	boolean IsFriend;
	
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
		int s=hasFriends.size();
		for (int i=0; i<s; i++){
			if (this.name == hasFriends.get(i).getName()){
				IsFriend = true;
			} else{
				IsFriend = false;
			}
		}
		return IsFriend;
	}
	
	/**
	 * This method adds to User hasFriends list another user
	 * that they are not friends yet. 
	 * 
	 * @param u
	 */
	public void AddFriend(User u){
		if(IsUseraFriend(u) == false){
			hasFriends.add(u);
			u.getHasFriends().add(this);
			System.out.println(this.getName() + " and " + u.getName() + " are now friends!");
		} else {
			System.out.println("Cannot add user " +this.getName() + " as a friend because ");
			System.out.println(this.getName() + " and " + u.getName() + " are already friends!");
		}
	}
	
	/**
	 * This method takes a Group as a parameter and adds 
	 * the User to this Group.
	 * @param g
	 */
	public void AddGroup (Group g){
		joinedGroups.add(g);
		g.AddMember(this);
	}

	/**
	 * This method takes another user as a parameter and gives back
	 * a list with common friends of these two users.
	 * This method prints nothing.
	 * 
	 * @param u
	 */
	public List<User> FindCommonFriends (User u){
		
		/* 2 for below do this: instance example
		 * 1st for loop: takes Makis as a Friend of Teo and goes to 2nd for loop 
		 *                              to find if Makis is a friend of Marina, too.
		 *                    |                                         
		 * u1:                |              u6:
		 * Teo                |              Marina
		 * hasFriends:        |              hasFriends:
		 *            |u2, Makis   |                   |u1, Teo     |
		 *            |u3, Petros  |                   |u2, Makis   |   
		 *            |u4, Stefania|                   |u3, Petros  |
		 *            |u6, Marina  |                   |u5, Nikoleta|
		 * 	                                
		 * 
		 * finally put Makis in commonFriends list of user1 Teo.
		 * and goes on.
		 */
		ArrayList<User> commonFriends = new ArrayList<User>();
		for (User friend: hasFriends){
			for (User friendOfOther: u.hasFriends){
				if (friend.getMail().equals(friendOfOther.getMail())){
					commonFriends.add(friend);
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
		//this.FindCommonFriends(u);
		for (User user: FindCommonFriends(u)){
			System.out.println(count +": " + user.getName());
			count++;
		}
		System.out.println("**************************************");
	}
	
	
	/**
	 * This method returns a list with Suggested Friend for one User.
	 * This list is after going to be printed at PrintSuggestedFriends() method.
	 * 
	 * @return a List<User> with Users
	 */
	public List<User> FindSuggestedFriends(){
		
		List<User> suggestedFriends = new ArrayList<User>();
		for (User friend: hasFriends){
			for (User fr: friend.hasFriends){
				if ((!this.hasFriends.contains(fr))&&(!fr.getName().equals(this.getName()))){
					suggestedFriends.add(fr);
				}
			}
		}
		return suggestedFriends;
	}
	
	/**
	 * This method prints Suggested Friends for a User.
	 * According to the instruction that:
	 * -if user A has Friends B, D and
	 * 	   user B has Friends D, E  then:
	 * 		Suggested friend for user A is E.
	 * Are the users that they are NOT in the hasFriend list of user A,
	 * but they are in the hasFriend list of every other friend of user A.  
	 * 
	 */
	public void PrintSuggestedFriends(){
		
		System.out.println("----------------------------------");
		System.out.println("Suggested Friends for " + this.getName() + " :");
		System.out.println("----------------------------------");	
		for (User user: FindSuggestedFriends()){
			System.out.println(user.getName());
			
		}
		System.out.println("----------------------------------");
	}
	
	
	

	public Post CreatePost(String str) {
		Timestamp stamp = new Timestamp(System.currentTimeMillis());
		Date date = new Date(stamp.getTime());
		//new Post(date, string, this, null);		
		return new Post(date, str, this, null);
	}
	
}

