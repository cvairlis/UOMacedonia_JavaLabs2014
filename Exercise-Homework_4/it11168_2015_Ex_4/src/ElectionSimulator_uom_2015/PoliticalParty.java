package ElectionSimulator_uom_2015;


import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.Icon;

/**
 * Klash gia thn proswmoiwsh tou enos politikou kommatos.
 * Kathe komma xarakthrizetai apo to onoma tou, to posous psifous exei parei kai to eikonidio tou gia na epistrafei sto GUI. * 
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */
public class PoliticalParty implements Serializable {
	
	
	private static final long serialVersionUID = 4162134699994385948L;
	
	private String name;
	private int votes;
	private Icon icon;
	
	private ArrayList<PoliticalParty> parties = new ArrayList<PoliticalParty>();
	
	
	public PoliticalParty(){
	}
	
	public PoliticalParty(String name, int votes, Icon icon){
		this.name=name;
		this.votes=votes;
		this.icon=icon;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Icon getIcon() {
		return icon;
	}

	public void setIcon(Icon icon) {
		this.icon = icon;
	}

	/**
	 * Methodos h opoia prosthetei ena politiko komma se mia lista me Politika kommata.
	 * @param pol typou PoliticalParty
	 */
	public void add(PoliticalParty pol){
		parties.add(pol);
	}
	
	/**
	 * Methodos h opoia prosthetei enan arithmo apo psifous stous psifous pou exei hdh to komma.
	 * eksipiretei to senario xrhshs 2
	 * @param numVotes
	 */
	public void addVotes(int numVotes){
		votes=votes+numVotes;
	}

	@Override
	public String toString() {
		return "PoliticalParty [name=" + name + ", votes=" + votes + "]";
	}
	

	
	
}
