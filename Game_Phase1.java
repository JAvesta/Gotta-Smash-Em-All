import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.geom.*;
import java.util.Random;
import java.awt.image.*; 
import java.lang.Math;
import java.io.*;
import java.io.InputStream;

public class Game_Phase1 extends JFrame{
	
	//Array
	private int GameData[] = new int[]{0,0};
	//score, highscore

	// Class
	public BACKGROUND ToBeInFrame = new BACKGROUND(); 

	//JFRAMES
	JFrame RoachSpace = new JFrame();
	
	// JLabels
	JLabel Score = new JLabel("Score:");
	JLabel Countdown = new JLabel("Time:");
	JLabel Time1 = new JLabel();	
	JLabel Record = new JLabel("Record:");
	 
	
	//ImageIcon
	ImageIcon iconQ = new ImageIcon("Assets/GUI/quitsmall.png");
	ImageIcon iconO = new ImageIcon("Assets/GUI/options.png");
	
	//JButton 
	JButton Trial = new JButton(iconQ);
	JButton Options = new JButton(iconO);
	
	// variables
	Timer t = new Timer(10,ToBeInFrame);
	Image RoachA,RoachB, RoachC, RoachD, RoachE;
	Image Background, Convert2 ;
	Timer countdown;

	int timeLeft = 30;
//	private int score;
//	private int highscore = 0;
	int Follow=0;
	int LocX, LocY;
	int ClockStatus =0;
	
	int RoachAx=0,RoachAy=0,RoachAStatus=1,RoachALoc=0;
	int AvelX =2, AvelY =2;
	
	int RoachBx=0,RoachBy=0,RoachBStatus=1,RoachBLoc=0;
	int BvelX =2, BvelY =2;
	
	int RoachCx=0,RoachCy=0,RoachCStatus=1,RoachCLoc=0;
	int CvelX =2, CvelY =2;
	
	int RoachDx=0,RoachDy=0,RoachDStatus=1,RoachDLoc=0;
	int DvelX =2, DvelY =2;
	
	int RoachEx=0,RoachEy=0,RoachEStatus=1,RoachELoc=0;
	int EvelX =2, EvelY =2;
	
	String UL="Assets/GUI/135.png",UR="Assets/GUI/45.png",DL="Assets/GUI/225.png",DR="Assets/GUI/315.png";
	//METHODS
	int changex ( int x)
 	 	{
 	 		int d,Xmax=980,Xmin=0;
 	 		
 	 		d = (int)(Math.random()* (Xmax - Xmin + 1) + Xmin);
 	 		x=d;
 	 	
 	 	return x ;
 	 	} 	
 	int changey( int y)
 	 	{
 	 		int d,Ymax=650,Ymin=0;
 	 		d = (int)(Math.random()* (Ymax - Ymin + 1) + Ymin);
 	 		y=d;
 	 	
 	 	return y ;
 	 	}  		
   	public Image getScaledImage(Image Img, int wt, int ht) {
    BufferedImage resizedImg = new BufferedImage(wt, ht, BufferedImage.TYPE_INT_ARGB);
    Graphics2D g2 = resizedImg.createGraphics();

    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.drawImage(Img, 0, 0, wt, ht, null);
    g2.dispose();

    return resizedImg;
}
 
	 

	 public Game_Phase1() 
    {
    //	t.start();

    
    
    // JFRAME ROACHSPACE  SETTINGS	
    RoachSpace.setVisible(true);
    RoachSpace.setSize(1400,1000);
    RoachSpace.setResizable(false);
    RoachSpace.setLocationRelativeTo(null);
    RoachSpace.setTitle("KILL THOSE COCKROACHES");
	RoachSpace.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  	
  	//JPanel > ToBeInFrame
  	ToBeInFrame.setLayout(null);
  	ToBeInFrame.setBackground(Color.black);
  	ToBeInFrame.setFocusable(true);

  	//JButton 
  		// JButton Trial
 		Trial.setBounds(1250,20,120,40);
     	// JButton Options
     	Options.setBounds(1095,20,150,40);
 
 	
 		Font fStats = new Font("Helvetica", Font.BOLD, 18);
 	//JLabel
 		//Score
 		Score.setForeground(Color.white);
 		Score.setFont(fStats);
 		Score.setBounds(1100,70,150,40);
 		//Countdown
 		Countdown.setForeground(Color.white);
 		Countdown.setBounds(1100,100,80,40);
 		Countdown.setFont(fStats);
 		//time
 		Time1.setForeground(Color.white);
 		Time1.setBounds(1150,100,80,40);
 		Time1.setFont(fStats);	
 		//Record
 		Record.setForeground(Color.WHITE);
 		Record.setBounds(1100,130,150,40);
 		Record.setFont(fStats);	
 		
 			
 	//Add   
    	// JFrame > JPanel
    	RoachSpace.add(ToBeInFrame);
    	// JPanel > SHIT
    	ToBeInFrame.add(Trial);
 		ToBeInFrame.add(Options);
     	ToBeInFrame.add(Score);
     	ToBeInFrame.add(Countdown);
     	ToBeInFrame.add(Record);       
         ToBeInFrame.add(Time1);  

    

     
     // FUNCTION
     	 ToBeInFrame.RUN();

    
     	  }

    public class BACKGROUND extends JPanel implements ActionListener 
   	
   	{
   		
   		Timer timer =new Timer(30,this);
   	   	
   		//Methoda
		public void RUN()
		{
		Trial.addActionListener(this);
		Options.addActionListener(this);
		timestart();
		countdown();
		loadHighscore();
		}
   		public void timestart()
   	{
   		timer.start();
   		ClockStatus++;
   	}	
   	 	public void countdown()
   		{
   			countdown = new Timer (1000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	
                if(timeLeft == 0){
                    Time1.setText("" + timeLeft);
                    countdown.stop();
                    if(GameData[0] > GameData[1]){
                    	GameData[1] = GameData[0];
                    	Record.setText("Highscore: " + GameData[1]);
                    	JOptionPane.showMessageDialog(null, "Your final score is: " + GameData[0], "You beat the high score!", JOptionPane.INFORMATION_MESSAGE);
                    }else{
            JOptionPane.showMessageDialog(null, "Your final score is: " + GameData[0], "Game Over!", JOptionPane.INFORMATION_MESSAGE);
        }     
        			saveHighscore();
                    GameData[0] = 0;
                    timeLeft = 30;
                    Time1.setText(""+ timeLeft);
                    Score.setText("Score " + GameData[0]);
                    
                    countdown.start();
            }
                Time1.setText("" + timeLeft);
                timeLeft--;
                
        
            }
        });
        countdown.start();
   		}
   		
   		
   		private void loadHighscore(){
        BufferedReader br = null;
        String line = "";
        try {
            br = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/highscore.txt"));
            line = br.readLine();
            br.close();
        } catch (IOException e) {
            line = "";
        }

        if(line != ""){
            GameData[1] = Integer.parseInt(line);
            Record.setText("Highscore: " + GameData[1]);
        }
    }
    
    private void saveHighscore(){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(System.getProperty("user.dir") + "/highscore.txt", false));
            bw.write("" + GameData[1]);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error while saving highscore", JOptionPane.ERROR_MESSAGE);
        }
    }		
    	public void paintComponent(Graphics g)
    		{
    			
    			Graphics RA = (Graphics2D) g;
    			Graphics RB = (Graphics2D) g;
    			Graphics RC = (Graphics2D) g;
    			Graphics RD = (Graphics2D) g;
    			Graphics RE = (Graphics2D) g;
    			Graphics B = (Graphics2D) g;
    			
    			super.paintComponent(g);
    			Bkg(B);
    			if(RoachAStatus==1)
    			{
    			CRoachA(RA);
    			}
    			if(RoachBStatus==1)
    			{
    			CRoachB(RB);
    			}
    			if(RoachCStatus==1)
    			{
    			CRoachC(RC);
    			}
    			if(RoachDStatus==1)
    			{
    			CRoachD(RD);
    			}
    			if(RoachEStatus==1)
    			{
    			CRoachE(RE);
    			}
    			
    			}
    	
    	
    	private void Bkg(Graphics g)
    	{
    		Background = new ImageIcon("Assets/GUI/Plain Bkg 1.png").getImage();
   			Convert2 = getScaledImage(Background, 1080,880);
   		
   			g.drawImage(Convert2,0,-70,null);
   			
    	}
    	
    		private void clearBoard(){
    		Background = new ImageIcon("Assets/GUI/Plain Bkg 1.png").getImage();
   			Convert2 = getScaledImage(Background, 1300,700);
   		
    	}
    	
    	
    	public void CRoachA(Graphics g)
    	{
    	if (AvelX > 0 && AvelY > 0)
    	RoachA = new ImageIcon(DR).getImage();
    	else if (AvelX < 0 && AvelY > 0)
    	RoachA = new ImageIcon(DL).getImage();
    	else if (AvelX > 0 && AvelY < 0)
    	RoachA = new ImageIcon(UR).getImage();
    	else
		RoachA = new ImageIcon(UL).getImage();
		
	   	if(RoachALoc==0)
	   	{
	   	RoachAx=changex(RoachAx);
	   	RoachAy=changey(RoachAy);
	   	RoachALoc=1;
	   	}
	   	g.drawImage(RoachA,RoachAx+30,RoachAy+30,null);
    	}
    	public void CRoachB(Graphics g)
    	{
    	if (BvelX > 0 && BvelY > 0)
    	RoachB = new ImageIcon(DR).getImage();
    	else if (BvelX < 0 && BvelY > 0)
    	RoachB = new ImageIcon(DL).getImage();
    	else if (BvelX > 0 && BvelY < 0)
    	RoachB = new ImageIcon(UR).getImage();
    	else
		RoachB = new ImageIcon(UL).getImage();
		
	   	if(RoachBLoc==0)
	   	{
	   	RoachBx=changex(RoachBx);
	   	RoachBy=changey(RoachBy);
	   	RoachBLoc=1;
	   	}
	   	g.drawImage(RoachB,RoachBx+20,RoachBy+20,null);
    	}
    	public void CRoachC(Graphics g)
    	{
    	if (CvelX > 0 && CvelY > 0)
    	RoachC = new ImageIcon(DR).getImage();
    	else if (CvelX < 0 && CvelY > 0)
    	RoachC = new ImageIcon(DL).getImage();
    	else if (CvelX > 0 && CvelY < 0)
    	RoachC = new ImageIcon(UR).getImage();
    	else
		RoachC = new ImageIcon(UL).getImage();
		
	   	if(RoachCLoc==0)
	   	{
	   	RoachCx=changex(RoachCx);
	   	RoachCy=changey(RoachCy);
	   	RoachCLoc=1;
	   	}
	   	g.drawImage(RoachC,RoachCx+20,RoachCy+20,null);
    	}
    	public void CRoachD(Graphics g)
    	{
    	if (DvelX > 0 && DvelY > 0)
    	RoachD = new ImageIcon(DR).getImage();
    	else if (DvelX < 0 && DvelY > 0)
    	RoachD = new ImageIcon(DL).getImage();
    	else if (DvelX > 0 && DvelY < 0)
    	RoachD = new ImageIcon(UR).getImage();
    	else
		RoachD = new ImageIcon(UL).getImage();
		
	   	if(RoachDLoc==0)
	   	{
	   	RoachDx=changex(RoachDx);
	   	RoachDy=changey(RoachDy);
	   	RoachDLoc=1;
	   	}
	   	g.drawImage(RoachD,RoachDx+20,RoachDy+20,null);
    	}
    	public void CRoachE(Graphics g)
    	{
    	if (EvelX > 0 && EvelY > 0)
    	RoachE = new ImageIcon(DR).getImage();
    	else if (EvelX < 0 && EvelY > 0)
    	RoachE = new ImageIcon(DL).getImage();
    	else if (EvelX > 0 && EvelY < 0)
    	RoachE = new ImageIcon(UR).getImage();
    	else
		RoachE = new ImageIcon(UL).getImage();
		
	   	if(RoachELoc==0)
	   	{
	   	RoachEx=changex(RoachEx);
	   	RoachEy=changey(RoachEy);
	   	RoachELoc=1;
	   	}
	   	g.drawImage(RoachE,RoachEx+20,RoachEy+20,null);
    	}



    	@Override
    	public void actionPerformed(ActionEvent e)
    {
		if(e.getSource() == Trial){
			int selection = JOptionPane.showConfirmDialog(null, "Do you want to quit the game?");
			 //System.exit(0);
			if (selection == JOptionPane.YES_OPTION)
     			System.exit(0);
     	}
    	
    	if (ClockStatus!=0)
    	{

//A
    		if(RoachAStatus==1)
    		{
   				if (RoachAx<-20 || RoachAx > 980)
	   			AvelX =-AvelX;
	 			if (RoachAy<-20 || RoachAy> 650) {
	   			AvelY = -AvelY; }
	   	
	   		RoachAx += AvelX;
	   		RoachAy += AvelY;
    		repaint();
    		}

//B     		
    		if(RoachBStatus==1)
    		{
   				if (RoachBx<-20 || RoachBx > 980)
	   			BvelX =-BvelX;
	 			if (RoachBy<-20 || RoachBy> 650) {
	   			BvelY = -BvelY; }
	   	
	   		RoachBx += BvelX;
	   		RoachBy += BvelY;
    		repaint();
    		}
//C
			if(RoachCStatus==1)
    		{
   				if (RoachCx<-20 || RoachCx > 980)
	   			CvelX =-CvelX;
	 			if (RoachCy<-20 || RoachCy> 650) {
	   			CvelY = -CvelY; }
	   	
	   		RoachCx += CvelX;
	   		RoachCy += CvelY;
    		repaint();
    		}
//D
			if(RoachDStatus==1)
    		{
   				if (RoachDx<-20 || RoachDx > 980)
	   			DvelX =-DvelX;
	 			if (RoachDy<-20 || RoachDy> 650) {
	   			DvelY = -DvelY; }
	   	
	   		RoachDx += DvelX;
	   		RoachDy += DvelY;
    		repaint();
    		}
//E
			if(RoachEStatus==1)
    		{
   				if (RoachEx<-20 || RoachEx > 980)
	   			EvelX =-EvelX;
	 			if (RoachEy<-20 || RoachEy> 650) {
	   			EvelY = -EvelY; }
	   	
	   		RoachEx += EvelX;
	   		RoachEy += EvelY;
    		repaint();
    		}

    
    	}




    	if(e.getSource() == Trial )
    	{
    		RoachAStatus =1;
    		RoachBStatus =1;
    	    RoachCStatus =1;
    	    RoachDStatus =1;
    	    RoachEStatus =1;


    	}
    	
    	
    // method for mouse click roach go away not working yet	
   
   	ToBeInFrame.addMouseListener(new MouseAdapter(){   
    public void mouseClicked(MouseEvent e){
        LocX = e.getX();
        LocY = e.getY();
        
    //A    
        int Ax = Math.abs(RoachAx - LocX+50);
        int Ay = Math.abs(RoachAy - LocY+50);
  
  
          if(Ax<= 50 && Ay <= 50)
        {
        	//System.out.println("A");
        	GameData[0]++;
        	Score.setText("Score: " + GameData[0]);
        	RoachAStatus=0;
        	RoachAx = 0;
        	RoachAy = 0;
        	RoachALoc = 0;
        	repaint(); 
        	RoachAStatus = 1;	 	
        		 	
        }
    //B    
        int Bx =Math.abs(RoachBx -LocX+50);
        int By =Math.abs(RoachBy -LocY+50);
        if(Bx <= 50 && By <= 50)
        {
        	//System.out.println("B");
        	GameData[0]++;
        	Score.setText("Score: " + GameData[0]);
        	RoachBStatus=0;
        	RoachBx = 0;
        	RoachBy = 0;
        	RoachBLoc = 0;
        	repaint();
        	RoachBStatus=1;  	
        }        
    //C  
        int Cx =Math.abs(RoachCx -LocX+50);
        int Cy =Math.abs(RoachCy -LocY+50);
        if(Cx <= 50 && Cy <= 50)
        {
      		//System.out.println("C");
        	GameData[0]++;
        	Score.setText("Score: " + GameData[0]);
        	RoachCStatus=0;
        	RoachCx = 0;
        	RoachCy = 0;
        	RoachCLoc = 0;
        	repaint();
        	RoachCStatus=1;   	
        }        
    //D  
        int Dx =Math.abs(RoachDx -LocX+50);
        int Dy =Math.abs(RoachDy -LocY+50);
        if(Dx <= 50 && Dy <= 50)
        {
        	//System.out.println("D");
        	GameData[0]++;
        	Score.setText("Score: " + GameData[0]);
        	RoachDStatus=0;
        	RoachDx = 0;
        	RoachDy = 0;
        	RoachDLoc = 0;
        	repaint();
        	RoachDStatus=1;   	        
        }        
    //E 
        int Ex =Math.abs(RoachEx -LocX+50);
        int Ey =Math.abs(RoachEy -LocY+50);
        if(Ex <= 50 && Ey <= 50)
        {
        	//System.out.println("E");
        	GameData[0]++;
        	Score.setText("Score: " + GameData[0]);
        	RoachEStatus=0;
        	RoachEx = 0;
        	RoachEy = 0;
        	RoachELoc = 0;
        	repaint();
        	RoachEStatus=1;   	
        }        
        
        
    }
    });
    
    	//
    }    
			
    			
    		}
    		
    
 
    	
    public static void main (String args[])
    {
	 new Game_Phase1();
    }
    
}