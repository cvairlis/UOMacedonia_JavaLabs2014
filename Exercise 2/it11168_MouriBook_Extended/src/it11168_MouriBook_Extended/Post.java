package it11168_MouriBook_Extended;


import java.util.Date;


public class Post {	
	private Date timestamp;
	private String post;
	private User user;
	private Post comment;	
	
	public Post (Date timestamp, String post, User user, Post comment){
		this.timestamp=timestamp;
		this.post=post;
		this.user=user;
		this.comment=comment;
	}


	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getPost() {
		return post;
	}

	public Post getComment() {
		return comment;
	}
	
	public void setComment(Post comment) {
		this.comment = comment;
	}


	
	/**
	 * Prints a Post and all all this post replies on the screen.
	 */	
	public void PrintPosts (){	
		//prints the post out the screen
		System.out.println(this.toString());
		PrintReplies();
	}
	
	/**
	 * Prints Replies of a Post.
	 * Firstly, there's a check. 
	 * If the post has no replies, prints nothing.
	 * 
	 */
	public void PrintReplies (){
		/* edw elegxoume an to post pou typwsame exei comments
		 * arxika eixa ton elegxo sth parapanw methodo PrintPosts
		 * if (getComment()!=null)
		 * PrintReplies();
		 * meta evala ton elegxo se auth th methodo, to thewrisa pio swsto
		 */
		if (getComment()!=null){
			//meta ton elegxo apothikeuw se topikh metavliti Post
			//to post to opoio tha emfanizetai sto toixo san reply
			Post po = getComment();
			//oso to sxolio den einai null ektypwse to
			while (po!=null){
				System.out.println("  -> " + po.toString());
				//se auto to shmeio pairnw to epomeno post gia elegxo
				//to epomeno post einai pleon to sxolio se auto to post
				po = po.getComment();
			}
		}
	}

	
	/**
	 * This method makes printing easy and quick.
	 * Prints and manages a Post with a specific order.
	 * For example a Post in our screen looks like this:
	 *     | Sun Dec 07 04:30:23 EET 2014 | Teo : This is my first post in this group! Welcome myself!!!
	 */	
	public String toString(){
		String out = "";
		out = 
				"| " +this.timestamp+ " | " +this.getUser().getName()+ " : " +this.post;
		return out;
	}
	
	/**
	 * This method implements the String Output for every post.
	 *  
	 * @return String
	 */
	public String takeAllReplies(){
		//arxika allazoume grammh
		String nextLine = " \n";
		//arxikopoioume to alfarithmitiko pou theloume na epistrepsoume
		String repl = "";
		//auto to symvolo tha prostithetai se kathe sxolio
		String next="  -> ";
		//orizoume mia metavliti typoy Post me onoma temp
		//etsi wste sthn epanalipsi while kathe fora na elegxei
		//an yparxei epomeno comment
		Post temp= getComment();
		//oso yparxei epomeno comment - dld oso to epomeno comment den einai null
		while (temp!=null){
			//ftiaxnoume to String
			repl = nextLine + repl + next + temp;
			temp = temp.getComment();
		}
		return repl;
	}
	
}
