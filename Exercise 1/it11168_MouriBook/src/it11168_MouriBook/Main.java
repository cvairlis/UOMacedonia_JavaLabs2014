package it11168_MouriBook;


public class Main {

	public static void main(String[] args) {
		
		User u1 = new User("Teo","teo@uom.gr");
		User u2 = new User("Makis","makis@uom.gr");
		User u3 = new User("Petros","petros@uom.gr");
		User u4 = new User("Stefania","stefania@uom.gr");
		User u5 = new User("Nikoleta","nikoleta@uom.gr");
		User u6 = new User("Marina","marina@uom.gr");
		
		Group g1 = new Group("Efarmosmeni","Ena group gia kammenous");
		Group g2 = new Group("Oikonomikwn Epistimon","Ena group gia giapides");
		
						
		u1.AddFriend(u2);
		u2.AddFriend(u3);
		u1.AddFriend(u3);
		u1.AddFriend(u4);
		u1.AddFriend(u5);
		u4.AddFriend(u2);
		u4.AddFriend(u5);
		u6.AddFriend(u1);
		u5.AddFriend(u2);
		
		//u1.FindCommonFriends(u3);
		//u3.FindCommonFriends(u1);
				
		u1.PrintCommonFriends(u3);
		u3.PrintCommonFriends(u1);
		
		u1.AddGroup(g1);
		u1.AddGroup(g2);
		u2.AddGroup(g1);
		u5.AddGroup(g1);
		u6.AddGroup(g1);
		
		u1.PrintHasFriends();
		u2.PrintHasFriends();
		
		u1.PrintJoinedGroups();
		g1.PrintGroupMembers();
	}
}
