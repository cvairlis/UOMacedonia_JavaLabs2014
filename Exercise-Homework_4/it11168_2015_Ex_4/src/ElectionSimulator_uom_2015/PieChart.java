package ElectionSimulator_uom_2015;

import java.awt.Color;
import java.awt.Dimension;

import java.util.ArrayList;

import org.jfree.chart.ChartFactory;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 * Klash PieChart gia th dhmiourgia grafimatos me pita.
 * Dexetai mia lista me politika kommata dhmiourgei to grafhma to topothetei se panel kai diathetei methodo epistrofhs tou panel autou.
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */
public class PieChart {
	
	JFreeChart chart;
	
	public PieChart(ArrayList<PoliticalParty> parties){
		
		int synolikoiPsifoi = getSumOfVotes(parties);
		
		double party1Per = giveMe2DigitsAfterPoint(parties.get(0).getVotes(), synolikoiPsifoi);
		double party2Per = giveMe2DigitsAfterPoint(parties.get(1).getVotes(), synolikoiPsifoi);
		double party3Per = giveMe2DigitsAfterPoint(parties.get(2).getVotes(), synolikoiPsifoi);
		double party4Per = giveMe2DigitsAfterPoint(parties.get(3).getVotes(), synolikoiPsifoi);
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		
		dataset.setValue(parties.get(0).getName(), party1Per);
		dataset.setValue(parties.get(1).getName(), party2Per);
		dataset.setValue(parties.get(2).getName(), party3Per);
		dataset.setValue(parties.get(3).getName(), party4Per);
		
		chart = createChart(dataset);
		
	}
	
	
	private JFreeChart createChart(PieDataset dataset){
		JFreeChart chart = ChartFactory.createPieChart(
				"Results (Pie)", 
				dataset,
				true,
				true,
				true);		
		chart.setBackgroundPaint(Color.GRAY);
		return chart;
	}
	
	/**
	 * Methodos pou dhmiourgei ena ChartPanel apo to chart pou dhmiourghse h klash kai to epistrefei sto GUI gia na prostethei se kapoio panel. 
	 * @return ChartPanel to be added in a JPanel
	 */	
	public ChartPanel getChartPanel(){
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new Dimension(200,50));
		return chartPanel;
	}
	
	
	
	/**
	 * Ypologizei kai epistrefei to synolo twn psifwn olwn twn kommatwn.
	 * 
	 * @param ArrayList<PoliticalParty> X
	 * @return int with sum of all votes
	 */
	public int getSumOfVotes(ArrayList<PoliticalParty> par){
		int sum = 0;
		for (PoliticalParty p: par){
			sum = sum + p.getVotes();
		}
		return sum;
	}
	
	
	/**
	 * H methodos dexetai dyo akeraious kai epistrefei enan double me 2 psifia meta th teleia.
	 * Skopos ths methodou einai na parei to pososto tou kathe kommatos.
	 * px an ena komma exei parei 52 psifous kai oi synolikoi psifoi einai 513 h methodos dexetai to 53 san up kai to 513 san down kai epistrefei 10.33
	 * 
	 * @param up
	 * @param down
	 * @return
	 */
	public double giveMe2DigitsAfterPoint(int up, int down){
		double upDouble = up;
		double downDouble = down;
		double per = upDouble/downDouble*100;
		per = Math.floor(per * 100) / 100;
		return per;
	}

}
