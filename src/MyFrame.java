import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import javax.swing.*;

public class MyFrame extends JFrame {

	JButton button1;
	JButton button2;
	
	Random random = new Random();

	String teamDoubles() {
		String team;
		int number = random.nextInt(8)+1;
		switch(number) {
		case 1: team = "Blue";
			break;
		case 2: team = "Red";
			break;
		case 3: team = "Lime";
			break;
		case 4: team = "Yellow";
			break;
		case 5: team = "Cyan";
			break;
		case 6: team = "Gray";
			break;
		case 7: team = "White";
			break;
		case 8: team = "Pink";
			break;
		default: team = "Error";
		}
		
		return team;
	}
	
	String team4s() {
		String team;
		int number = random.nextInt(4)+1;
		switch(number) {
		case 1: team = "Blue";
			break;
		case 2: team = "Red";
			break;
		case 3: team = "Lime";
			break;
		case 4: team = "Yellow";
			break;
		default: team = "Error";
		}
		
		return team;
	}
	
	String previousTeam2s = null;
	String previousTeam4s = null;
	
	MyFrame() {
		ImageIcon image = new ImageIcon(MyFrame.class.getResource("/bed.png"));
		
		JLabel label = new JLabel("Random Team Picker");
		JLabel version = new JLabel("v2.9.5");
		//JCheckBox checkBox = new JCheckBox("Dark Mode"); //part of dark version only
		
		label.setBounds(130, 25, 200, 10); //scales label
		version.setBounds(1, 150, 100, 10);
		
		//checkBox.setFocusable(false); //part of dark version only
		//checkBox.setBounds(191, 145, 100, 15); //part of dark version only
		
		button1 = new JButton("Doubles");
		button1.setFocusable(false);
		button1.setBounds(40, 50, 150, 75);
		/*button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if (e.getSource() == button1) {
					String team = teamDoubles();
					
					while(team == previousTeam2s) {
						team = teamDoubles();
					}
					
					switch(team) {
					case "Blue": button1.setBackground(Color.blue);
						button1.setForeground(Color.white);
						break;
					case "Red": button1.setBackground(Color.red);
						button1.setForeground(Color.black);
						break;
					case "Lime": button1.setBackground(Color.green);
						button1.setForeground(Color.black);
						break;
					case "Yellow": button1.setBackground(Color.yellow);
						button1.setForeground(Color.black);
						break;
					case "Cyan": button1.setBackground(Color.cyan);
						button1.setForeground(Color.black);
						break;
					case "Gray": button1.setBackground(Color.gray);
						button1.setForeground(Color.white);
						break;
					case "White": button1.setBackground(Color.white);
						button1.setForeground(Color.black);
						break;
					case "Pink": button1.setBackground(Color.magenta);
						button1.setForeground(Color.black);
						break;
					}
					
					button1.setText("Your team is "+team+".");
					previousTeam2s = team;
				}
			}
		});*/ 							//OLD CODE
		
		button1.addActionListener(
				(e) -> {
					String team = teamDoubles();
						
					while(team == previousTeam2s) {
						team = teamDoubles();
					}
						
					switch(team) {
					case "Blue": button1.setBackground(Color.blue);
						button1.setForeground(Color.white);
						break;
					case "Red": button1.setBackground(Color.red);
						button1.setForeground(Color.black);
						break;
					case "Lime": button1.setBackground(Color.green);
						button1.setForeground(Color.black);
						break;
					case "Yellow": button1.setBackground(Color.yellow);
						button1.setForeground(Color.black);
						break;
					case "Cyan": button1.setBackground(Color.cyan);
						button1.setForeground(Color.black);
						break;
					case "Gray": button1.setBackground(Color.gray);
						button1.setForeground(Color.white);
						break;
					case "White": button1.setBackground(Color.white);
						button1.setForeground(Color.black);
						break;
					case "Pink": button1.setBackground(Color.magenta);
						button1.setForeground(Color.black);
						break;
					}
					
					button1.setText("Your team is "+team+".");
					previousTeam2s = team;
				});
		
		button2 = new JButton("3s & 4s");
		button2.setFocusable(false);
		button2.setBounds(195, 50, 150, 75);
		/*button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (e.getSource() == button2) {
						String team = team4s();
						
						while(team == previousTeam4s) {
							team = team4s();
						}
						
						switch(team) {
						case "Blue": button2.setBackground(Color.blue);
							button2.setForeground(Color.white);
							break;
						case "Red": button2.setBackground(Color.red);
							button2.setForeground(Color.black);
							break;
						case "Lime": button2.setBackground(Color.green);
							button2.setForeground(Color.black);
							break;
						case "Yellow": button2.setBackground(Color.yellow);
							button2.setForeground(Color.black);
							break;
						}
						
						button2.setText("Your team is "+team+".");
						previousTeam4s = team;
					}
				}
			});*/						//OLD CODE
		
		button2.addActionListener(
				(e) -> {
					String team = team4s();
					
					while(team == previousTeam4s) {
						team = team4s();
					}
					
					switch(team) {
					case "Blue": button2.setBackground(Color.blue);
						button2.setForeground(Color.white);
						break;
					case "Red": button2.setBackground(Color.red);
						button2.setForeground(Color.black);
						break;
					case "Lime": button2.setBackground(Color.green);
						button2.setForeground(Color.black);
						break;
					case "Yellow": button2.setBackground(Color.yellow);
						button2.setForeground(Color.black);
						break;
					}
					
					button2.setText("Your team is "+team+".");
					previousTeam4s = team;
				});
		
		/*int darkMode;
		
		ModeFileWriter fileWriter = new ModeFileWriter();
		ModeFileReader fileReader = new ModeFileReader();
		File modeFile = new File("mode.txt");
		
		if(modeFile.exists()) {
			darkMode = fileReader.reader();
		}
		else {
			fileWriter.writer(48);
			darkMode = 48;
		}
		
		if(darkMode == 49) {
			checkBox.setSelected(true);
		}
		
		if(checkBox.isSelected()) {
			fileWriter.writer(49);
			darkMode = 49;
		}
		else {
			fileWriter.writer(48);
			darkMode = 48;
		}*/
		
		this.setTitle("Random Team Picker "+version.getText());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(400, 200); //sets resolution
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setIconImage(image.getImage()); //sets application icon
		this.add(version);
		this.add(label);
		this.add(button1);
		this.add(button2);
		//this.add(checkBox); //part of dark version only
		
		/*switch(darkMode) {
		case 48: this.setVisible(true);
		break;
		case 49:
			label.setForeground(Color.white); //part of dark version only
			version.setForeground(Color.white); //part of dark version only
			JPanel background = new JPanel(); //part of dark version only
			background.setBounds(0, 0, 400, 200); //part of dark version only
			background.setBackground(Color.darkGray); //part of dark version only
			this.add(background); //part of dark version only
			this.setVisible(true);
		break;
		}*/
		
		this.setVisible(true); //displays frame
	}
	
}
