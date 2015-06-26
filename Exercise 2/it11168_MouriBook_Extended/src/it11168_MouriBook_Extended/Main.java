package it11168_MouriBook_Extended;
/**
 * @author Vairlis Charalampos
 * it11168 - for UoM JAVA Labs 2014-2015
 * Solution for: Ex_02_-_MouriBook_Extended.pdf
 */

public class Main {

	public static void main(String[] args) {
		
		/*
		 * Here is another - maybe silly - way to create Users.
		 * It is impossible to create an Administrator Object to do createUser or other more complex functions.
		 * 
		 * for ex:
		 * Administrator admin = new Administrator("Charis", "charis@uom.gr");
		 * User u1 = admin.CreateUser("Teo", "teo@uom.gr") ;
		 * :P
		 * This is just to say, I don't implement this in this Java project.
		 */		
		User u1 = new User("Teo", "teo@uom.gr");
		User u2 = new User("Makis","makis@uom.gr");
		User u3 = new User("Petros","petros@uom.gr");
		User u4 = new User("Stefania","stefania@uom.gr");
		User u5 = new User("Nikoleta","nikoleta@uom.gr");
		User u6 = new User("Marina","marina@uom.gr");
		
		Group g1 = new OpenGroup("Efarmosmeni","Ena group gia kammenous pliroforikous");
		Group g2 = new PrivateGroup("Oikonomikwn Epistimwn","Oloi oi asxetoi giapides se ena meros!");
								
		u1.AddFriend(u2);
		u1.AddFriend(u3);
		u1.AddFriend(u4);		
		u6.AddFriend(u1);
		u6.AddFriend(u2);
		u6.AddFriend(u3);
		u6.AddFriend(u5);		
		u2.AddFriend(u3);
		
			
		u1.PrintCommonFriends(u6);
		u1.PrintSuggestedFriends();
		
		u3.PrintSuggestedFriends();
		
		
		g1.AddMember(u1);
		g1.AddMember(u2);
		
		
		
		Post p1 = u1.CreatePost("This is my first post in this group! Welcome myself!!!");
		Post p2 = u1.CreatePost("second post! hope you don't get bored with me!");
		
		Post p3 = u6.CreatePost("This is user 6, hello dudes!");
		
		g1.AddPost(p1);
		g1.AddPost(p2);
		g1.AddPost(p3);
		
		
		Post p1reply = u2.CreatePost("Hello to you too! Enjoy our group!");	
		g1.AddReplyToPost(p1, p1reply);
		
		Post p1Reply2 = u3.CreatePost("Hello Makis!");	
		g1.AddReplyToPost(p1reply, p1Reply2);
		
		g1.PrintWall();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		g2.AddMember(u3);
		g2.AddMember(u4);
		
		
		Post pp1 = u3.CreatePost("I am glad and honoured to be in this faboulous group!");
		g2.AddPost(pp1);

		Post pp1Reply = u4.CreatePost("Slowly, you may rip a stocking");	
		g2.AddReplyToPost(pp1, pp1Reply);
		
		Post pp1Reply2 = u5.CreatePost("Ha Ha Ha Ha");
		g2.AddReplyToPost(pp1Reply, pp1Reply2);
		
		
		/* 
		 * g2.AddMember(u6);
		 * Post pp1Reply3 = u6.CreatePost("Yeah it prints it correctly");
		 * g2.AddReplyToPost(pp1Reply, pp1Reply3);
		 * 
		 * This comment is here to check the getLatestPost works correctly.
		 * You take the code and put it to run here below or above.
		 * If you use this piece of code you with retrieve one additional reply:
		 * Something like:
		 * 
		 * Latest Post of Group 2
		 * | Sun Dec 07 08:16:33 EET 2014 | Petros : I am glad and honoured to be in this faboulous group!
		 *   -> | Sun Dec 07 08:16:33 EET 2014 | Stefania : Slowly, you may rip a stocking 
		 *   -> | Sun Dec 07 08:16:33 EET 2014 | Marina : Yeah it prints it correctly 
		 */
			
		
		g2.PrintWall();
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("Latest Post of Group 1");
		System.out.println(g1.getLatestPost());
		
		System.out.println("Latest Post of Group 2");
		System.out.println(g2.getLatestPost());	
	}
}
