package ElectionSimulator_uom_2015;



import java.io.Serializable;

/**
 * Klash gia thn proswmoiwsh tou enos psifoforou.
 * Kathe psifoforos xarakthrizetai apo to onoma tou, to kwdiko tou kai to AFM tou. 
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */

public class Voter implements Serializable {
	
	private static final long serialVersionUID = 5065669315912335351L;
	
	private String name;
	private String code;
	private String afm;

	public Voter() {}
	
	public Voter(String code, String afm) {
		this.code=code;
		this.afm=afm;
	}
	
	public Voter(String name, String code, String afm){
		this.name=name;
		this.code=code;
		this.afm=afm;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getAfm() {
		return afm;
	}

	public void setAfm(String afm) {
		this.afm = afm;
	}
	

	@Override
	public String toString() {
		return "Voter [name=" + name + ", code=" + code + ", afm=" + afm + "]";
	}

	
	
}
