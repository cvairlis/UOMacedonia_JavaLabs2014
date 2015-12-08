package ElectionSimulator_uom_2015;

import java.text.NumberFormat;


/**
 * Klash gia thn proswmoiwsh tou eklogikou apotelesmatos.
 * Kathe eklogiko apotelesma xarakthrizetai apo to eklogikoKentro , perigrafi, arithmos eggegrammenwn, arithmo psifwn kai psifous gia kathe komma.
 * Dhmiourghsa auth th klash gia na mporesw me aplo tropo na parw pisw to toString gia to deutero senario xrhshs.
 * 
 * Xrhsimopoiw NumberFormat gia na parw pisw to pososto kathe kommatos kai etsi vgainoun pisw pososta pou athrizontas ta vgainei 100%
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */

public class ElectionResult {
	
	private int eklogikoKentro;
	private String perigrafi;
	private int eggegrammenoi;
	private int synolikoiPsifoi;
	private int donkeysVotes;
	private int cowsVotes;
	private int slothsVotes;
	private int dogsVotes;
		
	public ElectionResult(){
	}

	public ElectionResult(int eklKentro, String perigrafi, int eggegrammenoi, int totalPsifoi, 
			int donkeysVotes, int cowsVotes, int slothsVotes, int dogsVotes){
		this.eklogikoKentro=eklKentro;
		this.perigrafi=perigrafi;
		this.eggegrammenoi=eggegrammenoi;
		this.synolikoiPsifoi=totalPsifoi;
		this.donkeysVotes=donkeysVotes;
		this.cowsVotes=cowsVotes;
		this.slothsVotes=slothsVotes;
		this.dogsVotes=dogsVotes;
	}
	
	public int getDonkeysVotes() {
		return donkeysVotes;
	}

	public void setDonkeysVotes(int donkeysVotes) {
		this.donkeysVotes = donkeysVotes;
	}
	
	public String getDonkeysRate(){
		double d = (double)donkeysVotes/ (double)synolikoiPsifoi;
		NumberFormat defaultFormat = NumberFormat.getPercentInstance();
		defaultFormat.setMinimumFractionDigits(1);
		return defaultFormat.format(d);
	}

	public int getCowsVotes() {
		return cowsVotes;
	}

	public void setCowsVotes(int cowsVotes) {
		this.cowsVotes = cowsVotes;
	}

	public String getCowsRate(){
		double d = (double)cowsVotes/ (double)synolikoiPsifoi;
		NumberFormat defaultFormat = NumberFormat.getPercentInstance();
		defaultFormat.setMinimumFractionDigits(1);
		return defaultFormat.format(d);
	}
	
	
	
	
	public int getSlothsVotes() {
		return slothsVotes;
	}

	public void setSlothsVotes(int slothsVotes) {
		this.slothsVotes = slothsVotes;
	}

	public String getSlothsRate(){
		double d = (double)slothsVotes/ (double)synolikoiPsifoi;
		NumberFormat defaultFormat = NumberFormat.getPercentInstance();
		defaultFormat.setMinimumFractionDigits(1);
		return defaultFormat.format(d);
	}
	
	
	public int getDogsVotes() {
		return dogsVotes;
	}

	public void setDogsVotes(int dogsVotes) {
		this.dogsVotes = dogsVotes;
	}
	
	public String getDogsRate(){
		double d = (double)dogsVotes/ (double)synolikoiPsifoi;
		NumberFormat defaultFormat = NumberFormat.getPercentInstance();
		defaultFormat.setMinimumFractionDigits(1);
		return defaultFormat.format(d);
	}
	

	public int getEklogikoKentro() {
		return eklogikoKentro;
	}

	public void setEklogikoKentro(int eklogikoKentro) {
		this.eklogikoKentro = eklogikoKentro;
	}

	public String getPerigrafi() {
		return perigrafi;
	}

	public void setPerigrafi(String perigrafi) {
		this.perigrafi = perigrafi;
	}

	public int getEggegrammenoi() {
		return eggegrammenoi;
	}

	public void setEggegrammenoi(int eggegrammenoi) {
		this.eggegrammenoi = eggegrammenoi;
	}

	public int getSynolikoiPsifoi() {
		return synolikoiPsifoi;
	}

	public void setSynolikoiPsifoi(int synolikoiPsifoi) {
		this.synolikoiPsifoi = synolikoiPsifoi;
	}

	
	
	
	
	/**
	 * h methodos dexetai ena String me th morfh double, to pollaplasiazei me to 100
	 * kai epistrefei thn akeraia timh tou.
	 * 
	 * @param String str
	 * @return Int toInt
	 */
	public int StringToIntRate(String str){	
		double toDouble = Double.parseDouble(str)*100;
		int toInt = (int) toDouble;
		return toInt;
	}
	
	
	@Override
	public String toString() {
		return "Kategrafisan apotelesmata apo " + "\n" 
				+ "----> "+ eklogikoKentro + " " + perigrafi + " " + "\n"
				+ "Eggegrammenoi: "	+ eggegrammenoi + " Psifisan: " + synolikoiPsifoi + "." + "\n"
				+ "\nElavan: Donkeys " + getDonkeysRate() + ", Cows " + getCowsRate()
				+ ", Sloths " + getSlothsRate() + ", Dogs " + getDogsRate() + ". ";
	}
	

	
	
}
