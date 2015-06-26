package ElectionSimulator_uom_2015;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Klash gia thn ylopoihsh ths seiriopoihsh-aposeiriopoishs ths listas twn onomatwn xrhstwn.
 * Trexei kathe fora pou anoigei to programma kai elegxei an yparxei to arxeio votersVoted.ser.
 * An den yparxei to dhmiourgei apo thn arxh me kai topothetei ws prwto stoixeio to "keno".
 * 
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */
public class SaveAndLoadVotersVoted {
	
	
	String pathVoted = "votersVoted.ser";
	ArrayList<String> votersVoted;
	
	public SaveAndLoadVotersVoted(){
		if (!saveFileExists(pathVoted)){
			votersVoted = new ArrayList<String>();
			votersVoted.add("keno");
			serializingVotersVoted(votersVoted);
		}		
	}
	
	
	/**
	 * Methodos h opoia apothikeuei-seiriopoiei mia lista me onomata typou String.
	 * @param ArrayList<String> _voterNames
	 */
	public void serializingVotersVoted(ArrayList<String> _voterNames) {
		try {
			FileOutputStream fileOut = new FileOutputStream(pathVoted);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(_voterNames);
			out.close();
			fileOut.close();			
		} catch (IOException io){
			io.printStackTrace();
		} finally {
			System.out.println("Serializing VotersVoted attempted.");
		}
	}
	
	/**
	 * Methodos h opoia anakta-aposeiriopoiei kai epistrefei mia lista me onomata typou String.
	 * 
	 * @return ArrayList<String>
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<String> deserializingVotersVoted() {
		
		ArrayList<String> votersVoted = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathVoted);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			votersVoted = (ArrayList<String>) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException io){
			io.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
		System.out.println("Deserializing VotersVoted attempted.");
		return votersVoted;
		
		
	}
	
	
	/**
	 * Methodos me thn opoia elegxoume an to arxeio .ser yparxei h oxi.
	 * @param serFileName
	 * @return true / false
	 */
	public boolean saveFileExists(String path){
		File f = new File(path);
		return f.exists();
	}	

}
