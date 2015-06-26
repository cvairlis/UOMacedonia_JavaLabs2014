package ElectionSimulator_uom_2015;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Klash BarChart gia th dhmiourgia grafimatos me mpara.
 * Dexetai mia lista me politika kommata dhmiourgei to grafhma to topothetei se panel kai diathetei methodo epistrofhs tou panel autou.
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */
public class BarChart {
	
	JFreeChart chart;
	
	public BarChart(ArrayList<PoliticalParty> parties){
		
		String party1Name = parties.get(0).getName();
		String party2Name = parties.get(1).getName();
		String party3Name = parties.get(2).getName();
		String party4Name = parties.get(3).getName();
		String category = "Political Parties";
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		
		dataset.addValue(parties.get(0).getVotes(), party1Name, category);
		dataset.addValue(parties.get(1).getVotes(), party2Name, category);
		dataset.addValue(parties.get(2).getVotes(), party3Name, category);
		dataset.addValue(parties.get(3).getVotes(), party4Name, category);
		
		chart = createChart(dataset);		
	}
	
	
	private JFreeChart createChart(CategoryDataset dataset){
		JFreeChart chart = ChartFactory.createBarChart(
				"Results (Bar)", 
				"Political Parties", 
				"Votes",
				dataset,
				PlotOrientation.VERTICAL,
				true,
				true,
				false);
		chart.setBackgroundPaint(Color.gray);
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
	
	

}
