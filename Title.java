import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.io.FileNotFoundException;
import javax.sound.sampled.*;

public class Title extends JFrame implements ActionListener {
  
      ImageIcon iconQ = new ImageIcon ("Assets/GUI/quit.png");
      ImageIcon iconP = new ImageIcon ("Assets/GUI/play.png");
      ImageIcon bkg = new ImageIcon ("Assets/GUI/titleeesceeen.png");
      
      JButton buttonQuit = new JButton (iconQ);
      JButton buttonPlay = new JButton (iconP);
      JLabel background = new JLabel();     
      public void actionPerformed(ActionEvent e){
      	
		if(e.getSource() == buttonQuit){
			int selection = JOptionPane.showConfirmDialog(null, "Do you want to quit the game?");
			 //System.exit(0);
			if (selection == JOptionPane.YES_OPTION){
     			System.exit(0);
     	}
		}if(e.getSource() == buttonPlay){
				Game_Phase1 ml = new Game_Phase1();
				dispose();
            }	
	}
     
   public Title(){
   		setTitle("Gotta Smash Em All!");						
    	setVisible(true);  
    	setSize(680,480); 
    	//setLocation(380,150);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(EXIT_ON_CLOSE); 
    	setResizable(false);
    	
    	
       	//Container c = getContentPane();
    	//setLayout(null); //(x,  y,  w,  h )
    	buttonQuit.setBounds (340, 210, 170, 60);
		add(buttonQuit);
		buttonQuit.addActionListener(this);
		
		buttonPlay.setBounds (158, 210, 170, 60);
		add(buttonPlay);
		buttonPlay.addActionListener(this);
		
		background.setSize(640,480);
		background.setIcon(bkg);
		add(background);
		
	try {
         // Open an audio input stream.
         File soundFile = new File("Assets/Sound/Dr. Mario (NES) Music - Menu Theme.wav");
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
         clip.open(audioIn);
         clip.start();
         clip.loop(Clip.LOOP_CONTINUOUSLY);
      } catch (UnsupportedAudioFileException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      } catch (LineUnavailableException e) {
         e.printStackTrace();
      }
		
		
	}
      
   public static void main(String args[]){
		Title bg = new Title();
	}
}