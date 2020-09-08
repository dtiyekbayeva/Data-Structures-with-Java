package NBA_Player_Project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;  

public class GUIandTest extends JFrame {

//list to add playerclass2 objects 
	LinkedList<PlayerClass2> PlayerList = new LinkedList<PlayerClass2>();

//lists to parse strings to integers and extract max/min values
	ArrayList<Integer> arrayYearStart = new ArrayList<Integer>();
	ArrayList<Integer> arrayYearEnd = new ArrayList<Integer>();
	
//maps to iterate through in order to get player's name and corresponding value	
	HashMap<String, Integer>YearBornMap = new HashMap<String, Integer>();
	HashMap<String, String>WeightMap = new HashMap<String, String>();
	HashMap<String, String>BUMap = new HashMap<String, String>();

//integers to add for correct year conversion later
	int century20th = 1900;
	int century21st = 2000;
	
//GUI container to hold objects
	private JPanel contentPane;
	
//GUI textbox, put it here so I can change the text in listener methods
	JTextArea textarea = new JTextArea();


	public static  void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIandTest frame = new GUIandTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		public GUIandTest() {

//reading input file and assigning tokens, using -1 to avoid null exception
		Scanner sc = null;
		try {
			sc = new Scanner(new File("nba_player_data.csv"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(sc.hasNextLine()){
              String line = sc.nextLine();
              String[] details = line.split(",", -1);
              String name = details[0];
              String year_start = details[1];
              String year_end = details[2];
              String weight = details[3];
              String birth_date = details[4];
              String college = details[5];
          	  PlayerClass2 p = new PlayerClass2(name, year_start, year_end, weight, birth_date, college);
              PlayerList.add(p);
		}
		sc.close();

//iterating through dataset
					for (int i=1; i<PlayerList.size(); i++) {
//2 digit year to 4 digit year conversion. Assumed that my dataset is up to 2018 
//and used -+10 to separate 20th and 21st centuries
//populating maps with required data
						if (!PlayerList.get(i).getbirth_date().isEmpty()
								&&
						Integer.parseInt(PlayerList.get(i).
						getbirth_date().substring(PlayerList.get(i).getbirth_date().length()-2))>10) {
							YearBornMap.put(PlayerList.get(i).getname(), century20th+
								Integer.parseInt(PlayerList.get(i).
								getbirth_date().substring(PlayerList.get(i).getbirth_date().length()-2)));}
						else if (!PlayerList.get(i).getbirth_date().isEmpty()
								&&
						Integer.parseInt(PlayerList.get(i).
						getbirth_date().substring(PlayerList.get(i).getbirth_date().length()-2))<10) {
							YearBornMap.put(PlayerList.get(i).getname(), century21st+
								Integer.parseInt(PlayerList.get(i).
								getbirth_date().substring(PlayerList.get(i).getbirth_date().length()-2)));
						}
						
						
					WeightMap.put(PlayerList.get(i).getname(), PlayerList.get(i).getweight());
					BUMap.put(PlayerList.get(i).getname(), PlayerList.get(i).getcollege());
					arrayYearStart.add(Integer.parseInt(PlayerList.get(i).getyear_start()));
					arrayYearEnd.add(Integer.parseInt(PlayerList.get(i).getyear_end()));
					}	
					
					
//GUI setup	
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 913, 550);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);
			
			
			textarea.setOpaque(false);
			textarea.setWrapStyleWord(true);
			textarea.setLineWrap(true);
			textarea.setBackground(SystemColor.info);
			textarea.setText("Welcome to the NBA players' dataset!"
					+ "\n\nThis dataset includes data from year "
					+ Collections.min(arrayYearStart) + " till year "
					+ Collections.max(arrayYearEnd) + "."
					+ "\n\nClick buttons on the right to find out some interesting fact.");
			textarea.setBounds(40, 70, 300, 500);
			textarea.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
			contentPane.add(textarea);
			
//Buttons, using lambda for actionListener			
			JButton btnBUGradute = new JButton("BU Graduates");
			btnBUGradute.setHorizontalAlignment(SwingConstants.LEADING);
			btnBUGradute.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			btnBUGradute.addActionListener(event ->  showBUGradute());
			btnBUGradute.setBounds(661, 50, 215, 55);
			contentPane.add(btnBUGradute);
			
			JButton btnHeavisetPlayer = new JButton("Heaviset Player");
			btnHeavisetPlayer.setHorizontalAlignment(SwingConstants.LEADING);
			btnHeavisetPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			btnHeavisetPlayer.addActionListener(event ->  showHeavisetPlayer());
			btnHeavisetPlayer.setBounds(661, 150, 215, 55);
			contentPane.add(btnHeavisetPlayer);
			
			JButton btnYoungestPlayer = new JButton("Youngest Player");
			btnYoungestPlayer.setHorizontalAlignment(SwingConstants.LEADING);
			btnYoungestPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			btnYoungestPlayer.addActionListener(event ->  showYoungestPlayer());
			btnYoungestPlayer.setBounds(661, 250, 215, 55);
			contentPane.add(btnYoungestPlayer);
			
			JButton btnOldestPlayer = new JButton("Oldest Player");
			btnOldestPlayer.setHorizontalAlignment(SwingConstants.LEADING);
			btnOldestPlayer.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
			btnOldestPlayer.addActionListener(event -> showOldestPlayer());
			
			btnOldestPlayer.setBounds(661, 350, 215, 55);
			contentPane.add(btnOldestPlayer);

//Image holder
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBackground(Color.LIGHT_GRAY);
			ImageIcon img1 = new ImageIcon("nbalogo.jpg");
			lblNewLabel.setIcon(img1);
			lblNewLabel.setBounds(0, 0, 900, 505);
			contentPane.add(lblNewLabel);
		}
	
//Listener methods
		
//Iterating through hashmap and using equals method to retrieve data		
		private void showBUGradute()
		{
			for (String key : BUMap.keySet()) {
				if (BUMap.get(key).equalsIgnoreCase("boston university")){
					textarea.setText("Player, " + key + ", graduated from Boston University!");
				}
			}
		}
		
//Iterating through hashmaps and using Collections.max/min to retrieve max/min values
		private void showHeavisetPlayer()
		{
			for (String key : WeightMap.keySet()) {
				if(WeightMap.get(key).equals(Collections.max(WeightMap.values()))) {
					textarea.setText("The Heaviest Player in this dataset is " +
				key + " and his weight is " + Collections.max(WeightMap.values()) + " pounds!");
				}
			}
		}

	
		private void showYoungestPlayer()
		{
			for (String key : YearBornMap.keySet()) {
				if(YearBornMap.get(key).equals(Collections.max(YearBornMap.values()))) {
					textarea.setText("The Youngest Player in this dataset is " +
				key + " and he was born in " + Collections.max(YearBornMap.values()) +"!");
				}
			}
		}
	
		
		private void showOldestPlayer()
		{
			for (String key : YearBornMap.keySet()) {
				if(YearBornMap.get(key).equals(Collections.min(YearBornMap.values()))) {
					textarea.setText("The Oldest Player in this dataset is " +
				key + " and he was born in " + Collections.min(YearBornMap.values()) +"!");
				}
			}
		}
}

