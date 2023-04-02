package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connection.connection;

public class fen_Resultats extends JFrame implements ActionListener{
	
	private JTextField txtNote1,txtNote2,txtNote3;
	private JLabel lbnume,lbnumc,lbNote1,lbNote2,lbNote3;
	private JButton bten,ann;

	private JComboBox cmbonumc=new JComboBox();
	private JComboBox cmbonume=new JComboBox();
	Statement st;
	
	private String req1E = " select DISTINCT matricule_etu from etudiant";
	private String req2C = " select DISTINCT code_unite from  unite";
	
	
	
	connection k=new connection();
	
	public fen_Resultats()
	{ 
	   initCombo();
	  this.setTitle("EtudiantUnité");
	  this.setSize(750,300);
	  this.setLocation(500, 200);
	  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbNote1=new JLabel  ("Note cc :");
     JLabel lbNote2=new JLabel("Note Tp :");
     JLabel lbNote3=new JLabel("Note Examen :");
     JLabel lbnume=new JLabel("Code Unite:");
     JLabel lbnumc=new JLabel("Matricule etudiant");
     
     
       txtNote1=new JTextField();
       txtNote2=new JTextField();
       txtNote3=new JTextField();
       
    
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Terminer");
     
     //bten.addActionListener(this);
    // ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("Black",0,15);
     
     /*supp=new JButton("Supprimer");
     
     modif=new JButton("Modifier");
     
     rech=new JButton("Rechercher");
     
     fer=new JButton("Terminez");
     
     
     
     supp.addActionListener(this);
     modif.addActionListener(this);
     rech.addActionListener(this);
     */
    // fer.addActionListener(this);
     
     
     
     //ajouts dans le panel
     
 
       
    lbnumc.setBounds(30,30,120,25); p.add(lbnumc);
   cmbonumc.setBounds(200,30,120,25); p.add(cmbonumc);
    
    
     cmbonumc.setForeground(Color.black); cmbonumc.setPreferredSize(new Dimension( 400 , 200));
     
      lbnume.setBounds(30,70,120,25);  p.add(lbnume);  lbnume.setFont(fe);
      cmbonume.setBounds(200,70,120,25);p.add(cmbonume);
     
      lbNote1.setBounds(20,110,100,25);  p.add(lbNote1);  lbNote1.setFont(fe);
      txtNote1.setBounds(200,110,50,25);p.add(txtNote1);
      
      lbNote2.setBounds(300,110,100,25);   p.add(lbNote2);  lbNote2.setFont(fe);
      txtNote2.setBounds(400,110,50,25);p.add(txtNote2);
      
      lbNote3.setBounds(500,110,100,25);  p.add(lbNote3); lbNote3.setFont(fe);
      txtNote3.setBounds(600,110,100,25);p.add(txtNote3);
      
     
      
     
     
		
     
     ann.addActionListener(new ActionListener()
     {  
    		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		dispose();
	}
    	 
     });
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,160,130,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN); 	bten.addActionListener(this); bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,160,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);     ann.addActionListener(this);
    		
     /*supp.setBounds(180,80,110,20); p.add(supp);
     modif.setBounds(180,110,110,20); p.add(modif);
     rech.setBounds(30,150,110,20);  p.add(rech);*/
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	//recherche de numero cours dans le combo
	private void initCombo(){
		 
		 
			 Statement state;ResultSet res;
			 connection kk=new connection();
			 try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req1E);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonumc.addItem(res.getString("matricule_etu"));
					
				}res.close();state.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
	
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req2C);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonume.addItem(res.getString("code_unite"));
					
				}res.close();state.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
			
	//fermeture de la fenetre
	
	
	
	}


/*static public void main(String[] args) {
	
	fen_Resultats f=new fen_Resultats();
	f.setVisible(true);
	
}*/


@Override
public void actionPerformed(ActionEvent a) {

	
	if(a.getSource()==bten)
	{
	
 	String n = (String) cmbonumc.getSelectedItem();
	String  n2=(String) cmbonume.getSelectedItem();
	float nbr1 =  Float.valueOf(txtNote1.getText());
	float nbr2 =  Float.valueOf(txtNote2.getText());
	float nbr3 =  Float.valueOf(txtNote3.getText());


	String requete = "INSERT INTO etudiantunite VALUES ('"+n+"','"+n2+"','"+nbr1+"','"+nbr2+"','"+nbr3+"')";
	  Statement state = null;
		try {
			
			 connection kk=new connection();
			 
	state=kk.etablirconnection().createStatement();
				
		  int res =  state.executeUpdate(requete);
		  if(res!=0){
			 //state.execute(requete);
				
				JOptionPane.showMessageDialog(null, "Eneregistrement ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
				
				
				   
				   txtNote1.setText("");
				   txtNote2.setText("");
				   txtNote3.setText("");
				 
				  
				  
				}
				//res.close();
				state.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "info", JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}

	    
	}

	
}}



	 















