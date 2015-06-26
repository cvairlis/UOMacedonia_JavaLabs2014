package ElectionSimulator_uom_2015;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;

import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;

import java.awt.Font;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Color;

import javax.swing.JRadioButton;


/**
 * To programma ElectionSimulator_uom_2015 dhmiourgithike sta plaisia ths 4hs proairetikhs ergasias gia to mathima Java 3ou eksaminou Panepisthmiou Makedonias.
 * 
 * To olo skeptiko vasizetai sth dhmiourgia mias platformas prosomoiwshs eklogikhs diadikasias.
 * 
 * To GUI dhmiourgithike me to Application Window Builder alla sth poreia allaxtike gia na ikanopoiei tis anagkes mas kai na einai genika pio katanohto.
 * 
 * To programma ksekinaei pairnei to LookAndFeel tou systhmatos, 
 * dhmiourgei ena antikeimeno operations ths klashs DataBase kai sth synexeia arxikopoiei-dhmiourgei to GUI.
 * 
 * H DataBase dhmiourgei th diasyndesh me oles tis klaseis ths efarmoghs. 
 * Arxika h DataBase dhmiourgei ena antikeimeno ths klashs ReadFromFile me to opoio exoume prosvash se oles tis methodous sarwshs arxeiwn excel.
 * Epeita dhmiourgei antikeimena twn klasewn SaveAndLoadParties & SaveAndLoadVotersVoted. Ayta ta antikeimena ylopoioun tis vasikes leitourgies seiriopoihshs (load & save).
 * Arxika elegxoun an yparxoun kapoia arxeia .ser kai an den yparxoun:
 * 		 h SaveAndLoadParties dhmiourgei apo to 0 arxeio parties.ser mesa sto opoio seiriopoioume mia lista me antikeimena typou PoliticalParty.
 * 			Ta antikeimena auta dhmiourgountai travontas ta onomata apo to excel arxeio, pairnoun 0 psifous, kai ta eikonidia apo to fakelo bin (resource).
 * 			(aksizei na shmeiwthei edw oti me auto ton tropo travame ta onomata kai ta eikonidia twn kommatwn mia fora sthn arxh kai oxi kathe fora pou trexei to programma).
 *		 h SaveAndLoadVotersVoted dhmiourgei apo to 0 arxeio votersVoted.ser mesa sto opoio seiriopoioume mia lista me String dld ta onomata oswn exoun psifisei.
 *		 	H lista arxika exei sth prwth thesi to String "" dld keno.
 * 
 * Se periptwsh pou ta arxeia yparxoun hdh oi kataskeuates twn parapanw klasewn seiriopoihshs de kanoun tpt kai sth synexeia h DataBase fortwnei apo ta arxeia .ser
 * prwta ta kommata: parties = savedPoliticalParties.deserializingParties(); kai epeita tous psifoforous pou psifisan votersVoted = savedVotersVoted.deserializingVotersVoted();
 * 
 * Se auto to shmeio emfanizetai to GUI kai o xrhsths mporei na pathsei opoiodipote plhktro thelei.
 * 
 * 
 * APAITOUMENES LEITOURGIES POU YLOPOIEI TO PROGRAMMA:
 * 
 * STO PRWTO SENARIO XRHSHS
 * ======================== o xrhsths eisagei to kwdiko kai to afm tou. An perasei h pistopoihsh authentikothtas, to systhma emfanizei to onoma tou xrhsth kai
 * elegxei an o xrhsths exei psifisei (an einai sth lista me tous xrhstes pou exoun psifisei dld). 
 * An exei psifisei den emfanizetai kanena allo eikonidio h koumpi kai emfanizetai mhnyma oti exei hdh psifisei.
 * An den exei psifisei to systhma emfanizei tis epiloges psifou tou xrhsth. An o xrhsths pathsei to koumpi back h kleisei to parathyro prepei na ksanasyndethei gia na psifisei.
 * An o xrhsths epileksei ena komma, emfanizetai ena koumpi VoteNow me to opoio katwxeirwnei th psifo tou. Me to pathma tou koumpiou VoteNow to parathyro kleinei,
 * to systhma pairnei th psifo tou xrhsth, prosthetei mia psifo sto epilegmeno komma, seiriopoiei th kainouria lista me ta kommata (kathe komma exei onoma, psifous kai eikonidia)
 * kai epishs prosthetei to onoma tou sth lista votersVoted thn opoia seiriopoiei kai auth. Exoun prostethei kai diafores ektypwseis sth konsola gia ton elegxo ths swsths leitourgias.
 * An o idios xrhsths prospathisei na ksanapsifisei to systhma tha ton anagnwrisei kai de tha tou epitrepsei th katathesi neas psifou.
 * 
 * 
 * STO DEUTERO SENARIO XRHSHS
 * ========================== sto xrhsth emfanizetai ena parathyro epiloghs arxeiou ths morfhs ".xlsx". An o xrhsths kleisei to parathyro xwris na epileksei kapoio arxeio
 * emfanizetai sto GUI katallhlo mhnyma. An epileksei ena arxeio pairnei pisw ena mhmyma gia th ekvash ths sarwshs tou arxeiou. To systhma se auto to shmeio elegxei tis diastaseis
 * tou prwtou spreadsheet tou arxeiou xlsx. An oi diastaseis einai swstes sarwnei to arxeio kai dinei sthn othonh to apaitoumeno mhnyma. 
 * Sth fash auth o xrhsths de to katalavainei alla to programma pairnei tous sygkentrwmenous psifous apo to dothen eklogiko kentro kai tous synipologizei sto synolo. 
 * Sth synexeia ksana seiriopoiei th lista me ta kommata. Epishs exoun prostethei diafores ektypwseis sth konsola.
 * To parathyro se ayto to shmeio de kleinei kai o xrhsths mporei na pathsei to koumpi back kai na metavei sth kentrikh othonh.
 * 
 * STO TRITO SENARIO XRHSHS
 * ========================== o xrhsths de xreiazetai na eisagei tpt. Opoiadhpote stigmh treksei to programma mporei na pathsei to koumpi GetResults kai na dei ta trexonta
 * apotelesmata ths eklogikhs diadikasias. Dinontai se morfh bar & pie.
 * 
 * 
 * 
 * 
 * Gia thn kalyterh katanohsh tou programmatos prosthesei JavaDocs pou eksigoun tis perissoteres leitourgies klasewn kai methodwn.
 * 
 * 
 * @author VAIRLIS CHARALAMPOS - it11168 UOM
 *
 */


public class basicFrame {

	/*
	 * edw parathetw oses metavlites xreiasthkan na tis xrhsimopoihsw kai ektos ths methodou initialize
	 */
	
	private DataBase operations;
	
	private JFrame frame;
	
	// kentriko panel
	private JPanel SystemPanel;
	
	// panel gia to prwto senario xrhshs
	private JPanel VoteOnlinePanel;
	
	// koumpi gia epistrofh apo to panel senariou 1 sto kentriko panel
	private JButton backButton1;
	
	// panel gia to deutero senario xrhshs
	private JPanel GetVotesPanel;	
	
	// koumpi gia epistrofh apo to panel senariou 2 sto kentriko panel
	private JButton backButton2;
	
	// panels gia to trito senario xrhshs 
	private JPanel GetResults1Panel;
	private JPanel GetResults2Panel;
	
	// pedia keimenou gia thn eisagwgh stoixeiwn tou xrhsth
	private JTextField guestCodeField;
	private JTextField guestAfmField;
	
	// etiketes me keimeno pou emfanizontai meta apo epityxh h anepityxh syndesh tou xrhsth 
	private JLabel validUserWelcomeLabel;
	private JLabel noValidUserWelcomeLabel;
	
	// perioxh keimenou pou topothetaitai to onoma tou eksousiodothmenou xrhsth an den exei psifisei.
	// an exei psifisei edw topotheteitai mnm exete psifisei hdh.
	private JTextArea authenticatedVoterNameArea;
	private JTextArea votesFromFileStringArea;
	
	// koumpia gia tis vasikes leitourgies tou prwtou senariou xrhshs
	private JButton authenticateButton;
	private JButton voteButton;
	
	private JRadioButton donkeysButton = null;
	private JRadioButton cowsButton = null;
	private JRadioButton slothsButton = null;
	private JRadioButton dogsButton = null;
	private ButtonGroup partiesButtons = new ButtonGroup();
	
	private JLabel donkeysLogo;
	private JLabel cowsLogo;
	private JLabel slothsLogo;
	private JLabel dogsLogo;
	
	// koumpia senariou 3 gia th metavash apo to ravdogramma sth pita kai antistrofa
	private JButton toStat1Button;
	private JButton toStat2Button;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				/*
				 * Look and feel for better view.
				 * Uses your system's default look and feel.
				 */
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (Exception e){
					e.printStackTrace();
				}
				try {
					basicFrame window = new basicFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public basicFrame() {		
		// antikeimeno ths klashs DataBase mesw ths opoias ylopoiountai oles oi leitourgies
		operations = new DataBase();
		initialize();
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 524, 525);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		/*
		 * Kentriko panel
		 */
		SystemPanel = new JPanel();
		frame.getContentPane().add(SystemPanel, "name_1202444343242560");
		SystemPanel.setLayout(null);
		
		// welcome text - just text - nothing else
		JTextPane WelcomePane = new JTextPane();
		WelcomePane.setBackground(new Color(204, 204, 204));
		WelcomePane.setEditable(false);
		WelcomePane.setFont(new Font("Tahoma", Font.PLAIN, 14));
		WelcomePane.setText("Welcome to UOM JAVA Ex4 Election Simulator.\r\nThis program created by GreekIT~it11168\r\nfor the UoM 3rd Sem. Java Labs.\r\nChoose one of the following 3 functions.");
		WelcomePane.setBounds(37, 20, 432, 87);
		SystemPanel.add(WelcomePane);
		
		// diaxwristiko gia to mhnyma ths kentrikhs othonhs kai ta koumpia
		JSeparator MenuSeparator = new JSeparator();
		MenuSeparator.setBounds(10, 118, 488, 17);
		SystemPanel.add(MenuSeparator);
		
		/*
		 * Koumpia kentrikou panel
		 * =======================
		 */
		
		// koumpi gia thn emfanish tou panel VoteOnlinePanel
		JButton VoteOnlineButton = new JButton("Vote Online Now");
		VoteOnlineButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		VoteOnlineButton.setBounds(45, 166, 180, 50);
		SystemPanel.add(VoteOnlineButton);
		// to action listener ylopoieitai se kainouria klash pio katw
		VoteOnlineButton.addActionListener(new VoteOnlineButtonListener());
		
		// koumpi gia thn emfanish tou panel GetVotesPanel
		JButton GetVotesButton = new JButton("Get Votes Electronically");
		GetVotesButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GetVotesButton.setBounds(274, 166, 180, 50);
		SystemPanel.add(GetVotesButton);
		// to action listener ylopoieitai se kainouria klash pio katw
		GetVotesButton.addActionListener(new GetVotesButtonListener());
		
		// koumpi gia thn emfanish tou panel GetResultsPanel
		JButton GetResultsButton = new JButton("Get Result Statistics");
		GetResultsButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GetResultsButton.setBounds(160, 269, 180, 50);
		SystemPanel.add(GetResultsButton);
		GetResultsButton.addActionListener(new GetResultsButtonListener());
		
		
		
		/*
		 * panels + koumpia & pedia gia kathe panel
		 * =========================================
		 */
		
		//=======================================================================================
		
		/*
		 *  VoteOnlinePanel gia th diadikasia ths online kataxwrishs psifou (prwto senario xrhshs)
		 *  ===============================================================================
		 */
		VoteOnlinePanel = new JPanel();
		frame.getContentPane().add(VoteOnlinePanel, "name_1202448041475540");
		VoteOnlinePanel.setLayout(null);
		VoteOnlinePanel.setVisible(false);
		
		// diaxwristiko gia to koumpi back tou VoteOnlinePanel
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 45, 488, 7);
		VoteOnlinePanel.add(separator);
		
		// non editable textpanes tou VoteOnlinePanel
		JTextPane kodikosText = new JTextPane();
		kodikosText.setBackground(new Color(204, 204, 204));
		kodikosText.setEditable(false);
		kodikosText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		kodikosText.setText("Enter \"Eidikos Eklogikos Kodikos\":");
		kodikosText.setBounds(48, 57, 195, 20);
		VoteOnlinePanel.add(kodikosText);
		
		JTextPane afmText = new JTextPane();
		afmText.setBackground(new Color(204, 204, 204));
		afmText.setText("Enter \"AFM\":");
		afmText.setFont(new Font("Tahoma", Font.PLAIN, 12));
		afmText.setEditable(false);
		afmText.setBounds(48, 88, 95, 20);
		VoteOnlinePanel.add(afmText);
		
		// editable textfields tou VoteOnline Panel
		guestCodeField = new JTextField();
		guestCodeField.setBounds(277, 57, 46, 20);
		VoteOnlinePanel.add(guestCodeField);
		guestCodeField.setColumns(10);
		
		guestAfmField = new JTextField();
		guestAfmField.setBounds(277, 88, 86, 20);
		VoteOnlinePanel.add(guestAfmField);
		guestAfmField.setColumns(10);
		
		// koumpi gia thn authentikopoihsh enos xrhsth
		authenticateButton = new JButton("ENTER");
		authenticateButton.setBounds(167, 121, 178, 33);
		VoteOnlinePanel.add(authenticateButton);
		authenticateButton.addActionListener(new authenticateButtonListener());
		
		// pedio gia thn emfanish mhnymatos epityxous sundeshs
		validUserWelcomeLabel = new JLabel("You have been recognized as citizen:");
		validUserWelcomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		validUserWelcomeLabel.setBounds(10, 194, 216, 20);
		VoteOnlinePanel.add(validUserWelcomeLabel);
		validUserWelcomeLabel.setVisible(false);
		
		// pedio gia thn emfanish mynhmatos anepityxous syndeshs
		noValidUserWelcomeLabel = new JLabel("You have NOT been recognized as a citizen.");
		noValidUserWelcomeLabel.setBounds(36, 163, 220, 20);
		VoteOnlinePanel.add(noValidUserWelcomeLabel);
		noValidUserWelcomeLabel.setVisible(false);
		
		// pedio gia thn emfanish tou onomatos tou epityxws syndemenou xrhsth
		authenticatedVoterNameArea = new JTextArea();
		authenticatedVoterNameArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		authenticatedVoterNameArea.setEditable(false);
		authenticatedVoterNameArea.setBounds(235, 192, 263, 22);
		VoteOnlinePanel.add(authenticatedVoterNameArea);
		authenticatedVoterNameArea.setVisible(false);
		
		
		backButton1 = new JButton("BACK");
		backButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SystemPanel.setVisible(true);
				back1PressedDisableAll();
				authenticateButton.setEnabled(true);
			}
		});
		backButton1.setBounds(10, 11, 89, 23);
		VoteOnlinePanel.add(backButton1);
		backButton1.setVisible(false);
		
		
		
		//=======telos panel 1================================================================================
		
		
		/*
		 * GetVotesPanel gia thn epistrofh tou String pou tha prokypsei apo th sarwsh tou arxeiou excel (deutero senario xrhshs)
		 * =====================================================================================================================
		 */
		
		GetVotesPanel = new JPanel();
		frame.getContentPane().add(GetVotesPanel, "name_1202450077219780");
		GetVotesPanel.setLayout(null);
		GetVotesPanel.setVisible(false);
		
		// non editable textarea: edw tha mpei to String pou epistrefei h methodos pou diavazei to arxeio excel pou edwse o xrhsths
		votesFromFileStringArea = new JTextArea();
		votesFromFileStringArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		votesFromFileStringArea.setLineWrap(true);
		votesFromFileStringArea.setEditable(false);
		votesFromFileStringArea.setBounds(20, 62, 465, 132);
		GetVotesPanel.add(votesFromFileStringArea);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 45, 488, 7);
		GetVotesPanel.add(separator_1);
		
		backButton2 = new JButton("BACK");
		backButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				votesFromFileStringArea.setText("");
				GetVotesPanel.setVisible(false);
				SystemPanel.setVisible(true);				
			}
		});
		backButton2.setBounds(10, 11, 89, 23);
		GetVotesPanel.add(backButton2);
		
		
		
		//=======telos panel 2================================================================================
		
		
		
		/*
		 * GetResults1Panel gia thn emfanish pitas (trito senario xrhshs)
		 * ===============================================================
		 */
		
		GetResults1Panel = new JPanel();
		frame.getContentPane().add(GetResults1Panel, "name_1202459386488030");
		GetResults1Panel.setVisible(false);
		GetResults1Panel.setLayout(new BorderLayout(0, 0));
		
		GetResults2Panel = new JPanel();
		frame.getContentPane().add(GetResults2Panel, "name_1921340291758950");
		GetResults2Panel.setLayout(new BorderLayout(0, 0));
		
		toStat1Button = new JButton("<< Go to Bar Chart");
		toStat1Button.setFont(new Font("Tahoma", Font.BOLD, 16));
		toStat1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetResults2Panel.setVisible(false);
				GetResults1Panel.setVisible(true);
			}
		});
		GetResults2Panel.add(toStat1Button, BorderLayout.NORTH);
		
		
		JButton backButton3 = new JButton("BACK");
		backButton3.setFont(new Font("Tahoma", Font.BOLD, 12));
		backButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GetResults1Panel.setVisible(false);
				GetResults2Panel.setVisible(false);
				SystemPanel.setVisible(true);
				
				
			}
		});
		GetResults1Panel.add(backButton3, BorderLayout.WEST);
		
		toStat2Button = new JButton("Go to Pie Chart >>");
		toStat2Button.setFont(new Font("Tahoma", Font.BOLD, 16));
		toStat2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GetResults1Panel.setVisible(false);
				GetResults2Panel.setVisible(true);
				
			}
		});
		GetResults1Panel.add(toStat2Button, BorderLayout.NORTH);
		
		
		
		
		//=======telos panel 3 & 4================================================================================
		
		/*
		 * koumpia & logo gia kathe party meta thn afthentikopoihsh tou xrhsth kai efoswn den exei psifisei
		 * mesw ths function1GivePartiesNamesBack & function1GivePartiesIconsBack zhtaw apo th DataBase na mou dwsei 
		 * ta onomata kai ta eikonidia pou exei fortwsei sth mnhmh gia na ta emfanisw sto GUI
		 * 
		 */
		
		/*
		 * koumpi gia to Donkeys
		 */
		String party1Name = operations.function1GivePartiesNamesBack(0);
		donkeysButton = new JRadioButton(party1Name);
		donkeysButton.setActionCommand(party1Name);
		donkeysButton.setBounds(88, 298, 109, 23);
		VoteOnlinePanel.add(donkeysButton);
		donkeysButton.setVisible(false);
		donkeysButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voteButton.setVisible(true);
			}
		});
		
		/*
		 * eikonidio gia to Donkeys
		 */
		Icon party1Icon = operations.function1GivePartiesIconsBack(0);
		donkeysLogo = new JLabel("");
		donkeysLogo.setBounds(76, 226, 95, 65);
		donkeysLogo.setIcon(party1Icon);
		VoteOnlinePanel.add(donkeysLogo);
		donkeysLogo.setVisible(false);
		
		/*
		 * koumpi gia to Cows
		 */
		String party2Name = operations.function1GivePartiesNamesBack(1);
		cowsButton = new JRadioButton(party2Name);
		cowsButton.setActionCommand(party2Name);
		cowsButton.setBounds(294, 298, 109, 23);
		VoteOnlinePanel.add(cowsButton);
		cowsButton.setVisible(false);
		cowsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voteButton.setVisible(true);
			}
		});
		
		/*
		 * eikonidio gia to Cows
		 */
		Icon party2Icon = operations.function1GivePartiesIconsBack(1);
		cowsLogo = new JLabel("");
		cowsLogo.setBounds(266, 226, 95, 65);
		VoteOnlinePanel.add(cowsLogo);
		cowsLogo.setVisible(false);		
		cowsLogo.setIcon(party2Icon);
		
		/*
		 * koumpi gia to Sloths
		 */
		String party3Name = operations.function1GivePartiesNamesBack(2);
		slothsButton = new JRadioButton(party3Name);
		slothsButton.setActionCommand(party3Name);
		slothsButton.setBounds(88, 396, 109, 23);
		VoteOnlinePanel.add(slothsButton);
		slothsButton.setVisible(false);
		slothsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voteButton.setVisible(true);
			}
		});
		
		/*
		 * eikonidio gia to Sloths
		 */
		Icon party3Icon = operations.function1GivePartiesIconsBack(2);
		slothsLogo = new JLabel("");
		slothsLogo.setBounds(76, 324, 95, 65);
		VoteOnlinePanel.add(slothsLogo);
		slothsLogo.setVisible(false);
		slothsLogo.setIcon(party3Icon);
		
		/*
		 * koumpi gia to Dogs
		 */
		String party4Name = operations.function1GivePartiesNamesBack(3);
		dogsButton = new JRadioButton(party4Name);
		dogsButton.setActionCommand(party4Name);
		dogsButton.setBounds(294, 396, 109, 23);
		VoteOnlinePanel.add(dogsButton);
		dogsButton.setVisible(false);
		dogsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				voteButton.setVisible(true);
			}
		});
		
		/*
		 *  eikonidio gia to Dogs
		 */
		Icon party4Icon = operations.function1GivePartiesIconsBack(3);
		dogsLogo = new JLabel("");
		dogsLogo.setBounds(268, 324, 95, 65);
		VoteOnlinePanel.add(dogsLogo);
		dogsLogo.setVisible(false);
		dogsLogo.setIcon(party4Icon);
		
		/*
		 * topothetw ta buttons se group gia na mporei na epilexthei mono ena kata th katathesi psifou
		 */		
		partiesButtons.add(donkeysButton);
		partiesButtons.add(cowsButton);
		partiesButtons.add(slothsButton);
		partiesButtons.add(dogsButton);
		
		/*
		 * koumpi gia thn katathesi psifou
		 */
		voteButton = new JButton("Vote Now");
		voteButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		voteButton.setBounds(349, 427, 119, 33);
		VoteOnlinePanel.add(voteButton);
		voteButton.setVisible(false);
		voteButton.addActionListener(new voteButtonListener());
		
		
	}
	
	
	/*
	 * TELOS INITIALIZE();
	 * ========================
	 * Akolouthoun ylopoihseis twn Listeners
	 */
	
	
	/**
	 * actionslistener gia to koumpi 1 VoteOnlineButton
	 * apla emfanizei to panel gia to prwto senario xrhshs
	 */
	class VoteOnlineButtonListener implements ActionListener {
		 public void actionPerformed (ActionEvent e){
			// o xrhsths pataei to Vote Online Now kai to systhma emfanizei to VoteOnlinePanel
			SystemPanel.setVisible(false);
			VoteOnlinePanel.setVisible(true);
			backButton1.setVisible(true);
			//System.out.println("hello");
		 }
	 }
	
	
	/**
	 * actionslistener gia to koumpi 2 GetVotesButton (deutero senario xrhshs)
	 * anoigei parathyro epiloghs arxeiou .xlsx
	 */
	class GetVotesButtonListener implements ActionListener {
		 
		 public void actionPerformed (ActionEvent e){
			// o xrhsths pataei to Get Votes kai to systhma emfanizei to ena parathuro epiloghs arxeiou excel
			// anoigei parathyro epiloghs arxeiou
			JFileChooser chooser = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Microsoft Excel 2007 (.xlsx)", "xlsx");
				
			chooser.setDialogTitle("Epilekste ena arxeio .xlsx");
			chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			chooser.setAcceptAllFileFilterUsed(false);
			chooser.setFileFilter(filter);
			int returnVal = chooser.showOpenDialog(null);
			// elegxei an o xrhsths perase ena arxeio h efuge h ekleise to parathyro xwris na dwsei kati
			if(returnVal == JFileChooser.APPROVE_OPTION) {   
				try {
					// apothikeuei se string th diadromh tou arxeiou pou dialekse o xrhsths
					String userSelectedPath = chooser.getSelectedFile().toString();
					// energopoieitai h function2 mesw ths opoias epistrefetai sto GUI ena string vlepe JavaDocs
					votesFromFileStringArea.setText(operations.function2(userSelectedPath));
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			} else {
				// an o xrhsths kleisei to parathyro xwris na dialeksei arxeio enhmerwnetai me katallhlo mhnyma
				votesFromFileStringArea.setText("No File Selected !!!");
				//System.out.println("No Selection ");
			}
			SystemPanel.setVisible(false);
			GetVotesPanel.setVisible(true);
		 }
	 }
	
	/**
	 * actionslistener gia to koumpi 2 GetResultsButton (trito senario xrhshs)
	 * Sto GetResults1Panel exw valei to bar chart
	 * sto GetResults2Panel exw valei to pie chart
	 */
	class GetResultsButtonListener implements ActionListener {
		 public void actionPerformed (ActionEvent e){
			// o xrhsths pataei to Get Results kai to systhma emfanizei to GetResults1Panel
			// sto GetResults2Panel o xrhsths metavainei mesw tou koumpiou toStat2Button 
			SystemPanel.setVisible(false);
			GetResults1Panel.setVisible(true);
			
			// prosthetei sto GetResults1Panel to grafhma bar chart 
			GetResults1Panel.add(operations.function3TakeBarChart(), BorderLayout.CENTER);
			// kai sto GetResults2Panel to grafhma pie chart
			GetResults2Panel.add(operations.function3TakePieChart(), BorderLayout.CENTER);
		 }
	 }
	

	/**
	 * When a user hits ENTER, authenticateButton set as disabled, and function1 is on the way.
	 * Have in mind that every class contains JavaDocs for further function analysis. Check them out! 
	 * 		 
	 */
	class authenticateButtonListener implements ActionListener {
		 
		public void actionPerformed (ActionEvent e){	
			// o xrhsths pata to enter tou VoteOnlinePanel kai to koumpi ENTER ginetai anenergo
			authenticateButton.setEnabled(false);
			
			if (operations.function1(guestCodeField.getText(), guestAfmField.getText())){
				if (!operations.function1CheckIfVoted(operations.function1TakeVoterBack())){
					authenticatedVoterNameArea.setText(operations.function1TakeVoterBack().getName());
					authenticationCompletedEnableButtons();
				} else {
					authenticatedVoterNameArea.setVisible(true);
					authenticatedVoterNameArea.setText("Exete psifisei hdh!!!");
				}
			} else {
				noValidUserWelcomeLabel.setVisible(true);
			}
		 }
	 }
	
	
	/**
	 * Pairnei to komma pou epelekse o xrhsths kataxwrei th psifo kai kleinei to parathyro.
	 */
	class voteButtonListener implements ActionListener {
		 public void actionPerformed (ActionEvent e){
			// me  thn entolh partiesButtons.getSelection().getActionCommand() pairnoume pisw poio party epelekse na psifisei o psifoforos
			// kai thn ekxwroume sth leitourgia apothikeusis psifou
			operations.function1Vote(partiesButtons.getSelection().getActionCommand());
			
			operations.function1SaveVoterVoted(operations.function1TakeVoterBack());
			
			// afou oloklhrwthei h katametrhsh psifou kai h katagrafh tou atomou pou oloklhrwse th diadikasia ths psifoforias
			// to parathyro kleinei
			frame.dispose();
		 }
	 }
	

	/**
	 * mazikh energopoihsh koumpiwn
	 */
	public void authenticationCompletedEnableButtons(){
		validUserWelcomeLabel.setVisible(true);
		authenticatedVoterNameArea.setVisible(true);
		donkeysButton.setVisible(true);
		donkeysLogo.setVisible(true);
		cowsButton.setVisible(true);
		cowsLogo.setVisible(true);
		slothsButton.setVisible(true);
		slothsLogo.setVisible(true);
		dogsButton.setVisible(true);
		dogsLogo.setVisible(true);
		backButton1.setVisible(true);			
	}
	
	/**
	 * mazikh apenergopoihsh koumpiwn
	 */
	public void back1PressedDisableAll(){
		VoteOnlinePanel.setVisible(false);
		guestAfmField.setText("");
		guestCodeField.setText("");
		authenticatedVoterNameArea.setText("");
		authenticatedVoterNameArea.setVisible(false);
		validUserWelcomeLabel.setVisible(false);
		noValidUserWelcomeLabel.setVisible(false);
		donkeysButton.setVisible(false);
		donkeysLogo.setVisible(false);
		cowsButton.setVisible(false);
		cowsLogo.setVisible(false);
		slothsButton.setVisible(false);
		slothsLogo.setVisible(false);
		dogsButton.setVisible(false);
		dogsLogo.setVisible(false);
		voteButton.setVisible(false);
	}
	
		
		
}

