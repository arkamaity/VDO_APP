package com.maity.UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingContainerDemo {
	
	public static void main(String[] args) {
	   JFrame f = new JFrame("Let's Meet");
	    SignInJPanel signPanel= new SignInJPanel("en");
	    f.add(signPanel);
	    Image icon = Toolkit.getDefaultToolkit().getImage("G:\\Icon_VD.png");
	    
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setIconImage(icon);
	    f.setSize(300, 300);
	    f.setBackground(Color.red);
	    f.setLayout(null);
	    f.setVisible(true);
	  }
   /*private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;
   private JLabel msglabel;

   public SwingContainerDemo(){
      prepareGUI();
   }
   public static void main(String[] args){
      SwingContainerDemo  swingContainerDemo = new SwingContainerDemo();  
      swingContainerDemo.showJWindowDemo();
   }
   private void prepareGUI(){
      mainFrame = new JFrame("Java Swing Examples");
      mainFrame.setSize(400,400);
      mainFrame.setLayout(new GridLayout(3, 1));
      
      mainFrame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            System.exit(0);
         }        
      });    
      headerLabel = new JLabel("", JLabel.CENTER);        
      statusLabel = new JLabel("",JLabel.CENTER);    
      statusLabel.setSize(350,100);

      msglabel = new JLabel("Welcome to TutorialsPoint SWING Tutorial.", JLabel.CENTER);

      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());

      mainFrame.add(headerLabel);
      mainFrame.add(controlPanel);
      mainFrame.add(statusLabel);
      mainFrame.setVisible(true);  
   }
   private void showJWindowDemo(){
      headerLabel.setText("Container in action: JWindow");   
      final MessageWindow window = new MessageWindow(
         mainFrame, "Welcome to TutorialsPoint SWING Tutorial.");

      JButton okButton = new JButton("Open a Window");
      okButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
            window.setVisible(true);
            statusLabel.setText("A Window shown to the user."); 
         }
      });
      controlPanel.add(okButton);
      mainFrame.setVisible(true);  
   }
   class MessageWindow extends JWindow{
      private String message; 
      public MessageWindow(JFrame parent, String message) { 
         super(parent);               
         this.message = message; 
         setSize(300, 300);       
         setLocationRelativeTo(parent);         
      }
      public void paint(Graphics g) { 
         super.paint(g);
         g.drawRect(0,0,getSize().width - 1,getSize().height - 1); 
         g.drawString(message,50,150); 
      } 
   }*/
}