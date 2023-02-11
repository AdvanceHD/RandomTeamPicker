import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Random;
import javax.swing.*;

public class MyFrame extends JFrame {

	JButton button1 = new JButton("Doubles");
	JButton button2 = new JButton("3s & 4s");
	
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
	
	JCheckBox checkBox = new JCheckBox("Dark Mode");
	JLabel label = new JLabel("Random Team Picker");
	JLabel version = new JLabel("v2.11.5");
	JPanel background = new JPanel();
	
	String previousTeam2s = null;
	String previousTeam4s = null;
	
	File mf = new File("mode.dat");
	
	int dMode = 0;
	
	{
	if(!mf.exists()) {
		try {
			FileOutputStream fos = new FileOutputStream("mode.dat");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			
			DataStorage dStorage = new DataStorage();
			
			dStorage.darkMode = dMode;
			
			oos.writeObject(dStorage);
			oos.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
	
	int darkMode = load();
	
	public int load() {
		
		try {
			FileInputStream fis = new FileInputStream("mode.dat");
			BufferedInputStream bis = new BufferedInputStream(fis);
			ObjectInputStream ois = new ObjectInputStream(bis);
			
			DataStorage dStorage = (DataStorage)ois.readObject();
			
			ois.close();
			
			darkMode = dStorage.darkMode;
			
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return darkMode;
	}
	
	{
	switch(darkMode) {
	case 1:
		label.setForeground(Color.white);
		version.setForeground(Color.white);
		background.setBackground(Color.darkGray);
		button1.setBackground(Color.darkGray);
		button1.setForeground(Color.white);
		button2.setBackground(Color.darkGray);
		button2.setForeground(Color.white);
		checkBox.setBackground(Color.darkGray);
		checkBox.setForeground(Color.white);
		checkBox.setSelected(true);
	break;
	}
}
	
	public void toggleVisible(boolean enabled) {
		if(enabled) {
			this.setVisible(true);
		}
		else {
			this.setVisible(false);
		}
	}
	
	MyFrame() {
		ImageIcon image = new ImageIcon(MyFrame.class.getResource("/bed.png"));
		
		label.setBounds(130, 25, 200, 10); //scales label
		version.setBounds(1, 150, 100, 10);
		
		checkBox.setFocusable(false);
		checkBox.setBounds(191, 145, 100, 15);
		
		background.setBounds(0, 0, 400, 200);
		
		checkBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					darkMode = 1;
					
					toggleVisible(false);
					label.setForeground(Color.white);
					version.setForeground(Color.white);
					background.setBackground(Color.darkGray);
					button1.setBackground(Color.darkGray);
					button1.setForeground(Color.white);
					button2.setBackground(Color.darkGray);
					button2.setForeground(Color.white);
					checkBox.setBackground(Color.darkGray);
					checkBox.setForeground(Color.white);
					toggleVisible(true);
					
					try {
						FileOutputStream fos = new FileOutputStream("mode.dat");
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						ObjectOutputStream oos = new ObjectOutputStream(bos);
						
						DataStorage dStorage = new DataStorage();
						
						dStorage.darkMode = darkMode;
						
						oos.writeObject(dStorage);
						oos.close();
						
					} catch(IOException f) {
						f.printStackTrace();
					}
					
				}
				else {
					darkMode = 0;
					
					toggleVisible(false);
					label.setForeground(null);
					version.setForeground(null);
					background.setBackground(null);
					button1.setBackground(null);
					button1.setForeground(null);
					button2.setBackground(null);
					button2.setForeground(null);
					checkBox.setBackground(null);
					checkBox.setForeground(null);
					toggleVisible(true);
					
					try {
						FileOutputStream fos = new FileOutputStream("mode.dat");
						BufferedOutputStream bos = new BufferedOutputStream(fos);
						ObjectOutputStream oos = new ObjectOutputStream(bos);
						
						DataStorage dStorage = new DataStorage();
						
						dStorage.darkMode = darkMode;
						
						oos.writeObject(dStorage);
						oos.close();
						
					} catch(IOException f) {
						f.printStackTrace();
					}
					
				}
			}
		});
		
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
		this.add(checkBox);
		this.add(background);
		this.setVisible(true); //displays frame
	}
}
