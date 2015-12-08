package ElectionSimulator_uom_2015;


import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 * Klash gia thn ylopoihsh ths seiriopoihsh-aposeiriopoishs ths listas twn politikwn kommatwn.
 * Trexei kathe fora pou anoigei to programma kai elegxei an yparxei to arxeio parties.ser.
 * An den yparxei to dhmiourgei apo thn arxh me 0 psifous se kathe komma.
 * 
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */

public class SaveAndLoadParties {
	
	// onoma arxeiou apothikeusis - anaktisis
	String pathParties = "parties.ser";
	
	PoliticalParty politicalParty;
	ArrayList<PoliticalParty> parties;
	ArrayList<PoliticalParty> partiesFromFile;
	
	
	public SaveAndLoadParties(){
			
		// edw mpainei mono an de vrei kapoio hdh seiriopoihmeno arxeio parties.ser
		if (!saveFileExists(pathParties))
		{			
			ReadFromFile readParties = new ReadFromFile();
			List<String> getPartiesFromXL = readParties.getPartiesFromFile();
				
			parties = new ArrayList<PoliticalParty>();
			
			
			/* 
			 * pairnei ta onomata twn kommatwn apo to arxeio excel
			 * kai dhmiourgei tessera antikeimena typou PoliticalParty me onomata apo to arxeio pou diavase, 0 psifous se kathe komma
			 * kai topothetei kai eikonidio to opoio allazei prwta megethos. 
			 * To eikonidio prepei na yparxei sto fakelo bin.
			 * 
			 */
				
			PoliticalParty donkeysParty = new PoliticalParty(getPartiesFromXL.get(0), 0, resizeIcon("/donkeys.png"));
			PoliticalParty cowsParty = new PoliticalParty(getPartiesFromXL.get(1), 0, resizeIcon("/cows.png"));
			PoliticalParty slothsParty = new PoliticalParty(getPartiesFromXL.get(2), 0, resizeIcon("/sloths.png"));
			PoliticalParty dogsParty = new PoliticalParty(getPartiesFromXL.get(3), 0, resizeIcon("/dogs.png"));
			
			parties.add(donkeysParty);
			parties.add(cowsParty);
			parties.add(slothsParty);
			parties.add(dogsParty);
				
			serializingParties(parties);
		}		
	}
	
	
	
	/**
	 * Methodos h opoia apothikeuei-seiriopoiei mia lista me antikeimena typou PoliticalParty.
	 * @param ArrayList<PoliticalParty> _parties
	 */
	public void serializingParties(ArrayList<PoliticalParty> _parties) {
		
		try {
			FileOutputStream fileOut = new FileOutputStream(pathParties);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(_parties);
			out.close();
			fileOut.close();			
		} catch (IOException io){
			io.printStackTrace();
		} finally {
			System.out.println("Serializing Political Parties attempted.");
		}
	}
	
	/**
	 * Methodos h opoia anakta-aposeiriopoiei kai epistrefei mia lista me antikeimena typou PoliticalParty.
	 * 
	 * @return ArrayList<PoliticalParty>
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<PoliticalParty> deserializingParties() {
		ArrayList<PoliticalParty> parties = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathParties);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			parties = (ArrayList<PoliticalParty>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException io){
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("Deserializing Parties attempted.");
		return parties;
	}
	
	
	
	/**
	 * Methodos gia thn allagh megethous tou kathe eikonidiou etsi wste na tairiazei sto JLabel pou tha prostethei sto GUI.
	 * @param String path (bin)
	 * @return Icon
	 */
	public Icon resizeIcon(String path){
		
		ImageIcon icon = null;		
		if (path.equals("/donkeys.png")){
			icon = new ImageIcon(getClass().getResource(path));
		} else if (path.equals("/cows.png")){
			icon = new ImageIcon(getClass().getResource(path));
		} else if (path.equals("/sloths.png")){
			icon = new ImageIcon(getClass().getResource(path));
		} else if (path.equals("/dogs.png")){
			icon = new ImageIcon(getClass().getResource(path));
		}
		Image img = icon.getImage();
		return new ImageIcon(img.getScaledInstance(95, 65, Image.SCALE_FAST));
		
	}
	

	/**
	 * Methodos me thn opoia elegxoume an to arxeio .ser yparxei h oxi.
	 * @param serFileName
	 * @return true / false
	 */
	public boolean saveFileExists(String serFileName){
		File f = new File(serFileName);
		return f.exists();
	}
	
	

}
