package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import requette.req2;

public class Jlabel extends JFrame {
  
 
private JPanel p;



	
	public Jlabel()
	{    this.setResizable(false);
		 this.setTitle("A Propos");
		 this.setSize(400,300);
		 JPanel p=new JPanel();
		  
		  p.setLayout(null);
	
		 
		  Font fer = new Font("BOLD",0, 16);
		  
		  this.setLocation(500, 200);
		  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
         
      JLabel ch1=new JLabel("Mini_Projet réalisé par:"); ch1.setBounds(40, 10, 180,  20); p.add(ch1); ch1.setForeground(Color.black);
	  JLabel ch2=new JLabel("Mamady Kourouma : Developpeur Licence 4");      ch2.setFont(fer); ch2.setBounds(40, 40, 400,  20);   p.add(ch2);
	  JLabel ch3=new JLabel("Salif Bangoura :        Developpeur   Licence 4");  ch3.setFont(fer);                        ch3.setBounds(40, 60, 400,  20);   p.add(ch3);
	  JLabel ch4=new JLabel("Mamadou Aliou Sow :     Developpeur Licence 4");   ch4.setFont(fer);                ch4.setBounds(40, 80, 400,  20);   p.add(ch4);
	  JLabel ch5=new JLabel("");                                   ch5.setBounds(40, 100, 200, 20);   p.add(ch5);
	  JLabel ch6=new JLabel("Maitre de Mini-Projet:"
	  		+"               ");                      p.add(ch6); ch6.setBounds(40,200,200,20);
	  		
	   JLabel ch7=new JLabel("Moha Kalil Kourouma");                 
	   ch7.setBounds(40, 230, 200,20);  ch7.setFont(fer); ch7.setForeground(Color.BLUE); 
	   
	   
	   
	   p.add(ch7);
	   
	  		                                                     
	  		p.add(ch6);
	
	  	                  

	   
	
	  //ajout contenair
	 
	  add(p);
	  
}
	/*
	public static void main(String[] args) {
  Jlabel jb=new Jlabel(); 
  jb.setVisible(true);

  
	}
*/

}






