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

public class fen_Activites_Pratiques extends JFrame implements ActionListener{
	
	private JTextField txttl,txtt2,txtt3;
	private JLabel lbnump,lbnumc,lbtl;
	private JButton bten,ann;
	private JComboBox cmboniv=new JComboBox();
	Statement st;
	private String req1 = " select DISTINCT matricule_ens from enseignant";

	
	
	
	connection k=new connection();
	
	public fen_Activites_Pratiques()
	{  this.setLocation(500, 200);
  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
	   initCombo();
	  this.setTitle("Unité");
	  this.setSize(400,300);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     //JLabel lbpt=new JLabel("point :");
     JLabel lbnump=new JLabel("Code Unité:");
     JLabel lbnumc=new JLabel("Libelle");
     JLabel lbtl=new JLabel("Nbr Heures");
     JLabel lbtl2=new JLabel("Matricule Enseignant");
     
     
       txttl=new JTextField();
       txtt2=new JTextField();
       txtt3=new JTextField();
  
    
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Terminer");
     
     //bten.addActionListener(this);
    // ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("Serif",0,15);
     
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
    lbnump.setBounds(30,30,120,25); p.add(lbnump);
   // cmboniv.setBounds(200,30,120,25); p.add(cmboniv)
    
     //cmboniv.setForeground(Color.CYAN); cmboniv.setPreferredSize(new Dimension( 400 , 200));
   // lbtl.setBounds(30,30,120,25);  p.add(lbtl);  lbtl.setFont(fe);
    txttl.setBounds(200,30,120,25);p.add(txttl); txttl.setFont(fe);
    
      lbnumc.setBounds(30,70,120,25);  p.add(lbnumc);  lbnumc.setFont(fe);
      txtt2.setBounds(200,70,120,25);p.add(txtt2); txtt2.setFont(fe);
     
      lbtl.setBounds(30,110,120,25);  p.add(lbtl);  lbtl.setFont(fe);
     txtt3.setBounds(200,110,120,25);p.add(txtt3); txtt3.setFont(fe);
     
      
     lbtl2.setBounds(30,150,120,25);  p.add(lbtl2);  lbtl.setFont(fe);
     cmboniv.setBounds(200,150,120,25); p.add(cmboniv);
     
     cmboniv.setPreferredSize(new Dimension( 400 , 200));
     
		
     
     ann.addActionListener(new ActionListener()
     {  
    		@Override
		public void actionPerformed(ActionEvent arg0) {
			
		dispose();
	}
    	 
     });
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,200,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN); 	bten.addActionListener(this); bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,200,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);     ann.addActionListener(this);
    		
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
						
				state.executeQuery(req1);
				
				res = state.getResultSet();
				while(res.next()){
					cmboniv.addItem(res.getString("matricule_ens"));
					
				}res.close();state.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			 
			
		 
	
			
	
	//fermeture de la fenetre
	
	
	
	}


/*static public void main(String[] args) {
	
	fen_Activites_Pratiques f=new fen_Activites_Pratiques();
	f.setVisible(true);
	
}
*/
@Override
public void actionPerformed(ActionEvent a) {

	
	if(a.getSource()==bten)
	{
	
		String n = (String) cmboniv.getSelectedItem();
	
	    String n1 =txttl.getText();
	    String n2 =txtt2.getText();
	    String n3 =txtt3.getText();
	


	String requete = "INSERT INTO unite VALUES ('"+n1+"','"+n2+"','"+n3+"','"+n+"')";
	  Statement state = null;
		try {
			
			 connection kk=new connection();
			 
	state=kk.etablirconnection().createStatement();
				
		  int res =  state.executeUpdate(requete);
		  if(res!=0){
			 //state.execute(requete);
				
				JOptionPane.showMessageDialog(null, "Eneregistrement ajouté avec succès", "info", JOptionPane.INFORMATION_MESSAGE);
				
				   
				   txttl.setText("");
		  
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



	 















