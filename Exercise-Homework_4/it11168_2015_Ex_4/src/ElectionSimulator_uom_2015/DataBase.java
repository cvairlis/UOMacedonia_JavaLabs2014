package ElectionSimulator_uom_2015;


import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;

import org.jfree.chart.ChartPanel;


/**
 * H klash DataBase dhmiourgithike gia thn ylopoihsh olwn twn apaitoumenwn leitourgiwn.
 * Ousiastika dinei th dynatothta sto GUI na travaei otidhpote dedomena thelei. px ena onoma xrhsth, ena true/false analoga an vrethike sto arxeio me tous eksousiodothmenous xrhstes ka.
 * 
 * Prosthetw se sxolia kai javadocs parakatw arketes plhrofories gia th katanoish ths leitourgias ths DataBase.
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *  
 */
public class DataBase {
	
	/*
	 * perioxh metavlitwn pou xrhsipopoiountai se olh th klash DataBase
	 */
	
	private ReadFromFile getFromExcelFile;
	private ElectionResult result;
	
	private Voter guestVoter;
	
	private SaveAndLoadParties savedPoliticalParties = new SaveAndLoadParties();
	private SaveAndLoadVotersVoted savedVotersVoted;
	
	ArrayList<PoliticalParty> parties;
	ArrayList<String> votersVoted;

	
	public DataBase(){
		// o kataskeuasths ths DataBase fortwnei sth mnhmh ta aparaithta stoixeia 
		// tetoia einai
		getFromExcelFile = new ReadFromFile();
		savedPoliticalParties = new SaveAndLoadParties();
		savedVotersVoted = new SaveAndLoadVotersVoted();
		// mia lista me politika kommata (typou PoliticalParty)
		parties = savedPoliticalParties.deserializingParties();
		// mia lista me onomata autwn pou exoun psifisei (typou String)
		votersVoted = savedVotersVoted.deserializingVotersVoted();
	}
	
	
	
	/**
	 * H methodos auth einai h kardia tou mhxanismou authentikopoihshs xrhstwn.
	 * 
	 * 1. diavazei to dothen arxeio me tous eksousiodothmenous xrhstes-anthrwpous
	 * 2. dhmiourgei mia lista typou Voter
	 * 3. elegxei an yparxei o xrhsths (apo to dothen code kai afm)
	 * 4. an yparxei epistrefei true / an den yparxei epistrefei false
	 * 
	 * @return true / false (user found in excel file / user not found in excel file)
	 */
	public boolean function1(String code, String afm){
		
		List<Voter> permittedVoterList = getFromExcelFile.getPermittedVotersFromExcelFile();
		for (Voter v: permittedVoterList){
			if (v.getAfm().equals(afm) && v.getCode().equals(code)){
				guestVoter = new Voter(v.getName(), v.getAfm(), v.getCode());
				return true;
			}		
		}
		return false;
	}
	
	/**
	 *  Me th methodo auth epistrefoume pisw sto GUI ton Voter pou perase thn authentikopoihsh.
	 *  Thimitheite oti kathe enas Voter xarakthrizetai apo to onoma tou ton kwdiko tou kai to AFM tou.
	 *  
	 * @return Voter v
	 */
	public Voter function1TakeVoterBack(){
		return guestVoter;
	}
	
		
	
	/**
	 * H methodos elegxei an o xrhsths exei h oxi psifisei kai epistrefei true h false antistoixa.
	 * Thimitheite oti kathe fora pou trexei to programma fortwnetai h lista ta onomata twn xrhstwn (strings) pou exoun psifisei.
	 *  
	 * @param Voter v
	 * @return true / false
	 */
	public boolean function1CheckIfVoted(Voter v){
		
		for (String s: votersVoted){
			if(s.contains(v.getName())){
				return true;
			} 
		}
		return false;
		
	}
	
	
	/**
	 * H methodos epistrefei sto GUI to onoma enos kommatos me vasi to poia thesi exei sth lista me ta parties
	 * px gia na parw to onoma tou Donkeys prepei na eisagw index=0 sth methodo. Gia to onoma tou Cows prepei na dwsw 1, gia Sloths 2 kai gia Dogs 3.
	 * 
	 * @param index (number of the element in list)
	 * @return String name of selected party
	 */
	public String function1GivePartiesNamesBack(int index){
		return parties.get(index).getName();
	}
	
	
	/**
	 * H methodos epistrefei sto GUI to icon enos kommatos. 
	 * Thymitheite oti kathe komma xarakthrizetai apo to onoma, to icon kai to posous psifous exei parei.
	 * 
	 * me vasi to poia thesi exei sth lista me ta parties
	 * px gia na parw to icon tou Donkeys prepei na eisagw index=0 sth methodo
	 * 
	 * @param index (number of list element)
	 * @return Icon of selected party
	 */
	public Icon function1GivePartiesIconsBack(int index){
		return parties.get(index).getIcon();
	}
	
	
	/**
	 * H methodos kataxwrei th psifo tou psifoforou sto epilegmeno komma 
	 * kai seiriopoiei ek neou th lista parties
	 * 
	 * @param String partyName
	 */
	public void function1Vote(String partyName){
		for (int i=0; i<4; i++ ){
			if (parties.get(i).getName().equals(partyName)){
				parties.get(i).setVotes(parties.get(i).getVotes()+1);
			}
		}
		// save th lista me ta parties gia na apothikeutei kai h psifos
		savedPoliticalParties.serializingParties(parties);
	}
	
	
	/**
	 * H methodos kataxwrei to onoma xrhsth pou oloklhrwse th kataxwrisi psifou sth lista votersVoted.
	 * H psifos einai mystikh synepws kratame mono ta onomata autwn pou psifisan kai oxi ti psifisan.
	 * Epishs seiriopoiei ekneou th lista savedVotersVoted
	 * 
	 * @param v
	 */
	public void function1SaveVoterVoted(Voter v){
		votersVoted.add(v.getName());
		savedVotersVoted.serializingVotersVoted(votersVoted);
		System.out.println("O " + v.getName() + " molis psifise.");
		// proeraitikh methodos ektypwshs sth konsola
		printAll();
	}
	
	/**
	 * H methodos xrhsimopoieitai gia thn ektypwsh twn trexontwn dedomenwn.
	 * 
	 * px: 
	 *  1. Donkeys : 1458
	 *	2. Cows : 1200
	 *	3. Sloths : 30
	 *	4. Dogs : 242
	 *
	 * energopoeitai kathe fora pou psifizei enas xrhsths h sarwnetai ena xlsx arxeio.
	 */
	public void printAll(){
		System.out.println("Trexousa katastash psifwn:");
		int count = 1;
		for (PoliticalParty p: parties){
			System.out.println(count + ". " + p.getName() + " : " + p.getVotes());
			count++;
		}
		System.out.println("");
	}
	
	/**
	 * Methodos me thn opoia epistrefoume sto GUI ena String pou enhmerwnoume
	 * xrhsth sxetika me ta apotelesmata tou arxeiou pou sarwthike.
	 * 
	 * Dothentos enos path (apo to parathyro epiloghs arxeiou) h function2
	 * xrhsimopoiei to antikeimeno readFromFile pou dhmiourghthike sto kataskeuasth ths DataBase 
	 * kai mesw ths methodou getResultsFromExcelFile pairnei pisw enan 2d pinaka.
	 * 
	 * An o pinakas sarwthike swsta dhmiourgei ena antikeimeno ElectionResult
	 * kataxwrei mesa ta xarakthristika tou apotelesmatos kai ta epistrefei sto GUI me ena String.
	 * 
	 * An o pinakas de sarwthike swsta shmainei oti sth prwth grammh prwth sthlh
	 * tha yparxei to String keno. An symvainei kati tetoio epistrefetai ston xrhsth ena string 
	 * me to stoixeio sth prwth grammh & th deuterh sthlh. Ekei mesa yparxei ena string
	 * me plhrofories sxetika me to ti phge strava.
	 * 
	 * @param path
	 * @return String "katametrithikan ktl..."
	 * @throws Exception
	 */
	public String function2(String path) throws Exception {
		
		String[][] infoArray = getFromExcelFile.getResultsFromExcelFile(path);
		String returnedResults;
		
		if (infoArray[0][0]=="keno"){
			returnedResults = infoArray[0][1];
		} else {			
			int eklKentro = StringToInt(infoArray[1][0]);
			String perigrafiText = infoArray[1][1];
			int eggegramenoi = StringToInt(infoArray[1][2]);
			int synolikoiPsifoi = StringToInt(infoArray[5][4]);
		
			int psifoiDonkeys = StringToInt(infoArray[1][4]);
			parties.get(0).addVotes(psifoiDonkeys);
			
			int psifoiCows =StringToInt(infoArray[2][4]);
			parties.get(1).addVotes(psifoiCows);
			
			int psifoiSloths = StringToInt(infoArray[3][4]);
			parties.get(2).addVotes(psifoiSloths);
		
			int psifoiDogs = StringToInt(infoArray[4][4]);
			parties.get(3).addVotes(psifoiDogs);
			
			result = new ElectionResult(
					eklKentro, perigrafiText, eggegramenoi, synolikoiPsifoi, 
					psifoiDonkeys, psifoiCows, psifoiSloths, psifoiDogs);
			
			returnedResults = result.toString();
			
			printAll();
			
		} 
		// seirialize
		savedPoliticalParties.serializingParties(parties);
		return returnedResults;
	}

	
	/**
	 * h methodos dexetai ena String me th morfh double kai epistrefei int
	 * @param String str
	 * @return Int toInt
	 */
	public int StringToInt(String str){
		double toDouble = Double.parseDouble(str);
		int toInt = (int) toDouble;
		return toInt;
		
	}
	
	/**
	 * H methodos dhmiourgei ena antikeimeno ths Klashs BarChart, pernaei mesa tou th lista me ta kommata
	 * kai epistrefei ena Bar ChartPanel me to grafhma etoimo na prostethei sto GUI.
	 * 
	 * @return ChartPanel for bar chart
	 */
	public ChartPanel function3TakeBarChart(){
		BarChart bar = new BarChart(parties);
		return bar.getChartPanel();		
	}
	
	/**
	 * H methodos dhmiourgei ena antikeimeno ths Klashs PieChart, pernaei mesa tou th lista me ta kommata
	 * kai epistrefei ena Pie ChartPanel me to grafhma etoimo na prostethei sto GUI.
	 * 
	 * @return ChartPanel for pie chart
	 */
	public ChartPanel function3TakePieChart(){
		PieChart pie = new PieChart(parties);
		return pie.getChartPanel();		
	}
	
}
