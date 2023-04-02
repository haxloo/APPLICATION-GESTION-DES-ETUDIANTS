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

public class Fen_Activites extends JFrame implements ActionListener {
	
	private JTextField txtnv,txteqp;
	private JLabel lbact;
	private JButton bten,ann;
	private JComboBox txtnomAc=new JComboBox();
	Statement st;
	
	
	connection k=new connection();
	
	public Fen_Activites()
	{ 
	  this.setTitle("Enregistrement_prof");
	  this.setSize(400,300);
	  this.setLocation(500, 200);
	  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnv=new JLabel("Niveau :");
     JLabel lbeqp=new JLabel("Equipe:");
     JLabel lbact=new JLabel("Nom d'activités");
     
     
     
     txtnv=new JTextField();
    
     txteqp=new JTextField();
  
    
     
     
     bten=new JButton("Sauver");
     ann=new JButton("Terminer");
     
     bten.addActionListener(this);
     ann.addActionListener(this);
     
     
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
    lbnv.setBounds(30,30,120,25); p.add(lbnv);
    txtnv.setBounds(200,30,120,25); p.add(txtnv);
    
    txtnv.setForeground(Color.black); txtnv.setPreferredSize(new Dimension( 400 , 200));
     
      lbact.setBounds(30,70,120,25);  p.add(lbact);  lbact.setFont(fe);
      txtnomAc.setBounds(200,70,120,25);p.add(txtnomAc);
     
      lbeqp.setBounds(30,110,120,25);  p.add(lbeqp);  lbeqp.setFont(fe);
      txteqp.setBounds(200,110,120,25);p.add(txteqp);
     
      txtnomAc. addItem( "gymnastique") ;
      txtnomAc. addItem("footing");
      txtnomAc. addItem("football");
      txtnomAc. addItem( "hand-ball");
      txtnomAc. addItem( "basket-ball");
       txtnomAc.addItem("natition");
       txtnomAc.addItem("atheletisme");
        
		
     
     
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,160,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN);  bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\save.png"));
    ann.setBounds(200,160,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
    		
     /*supp.setBounds(180,80,110,20); p.add(supp);
     modif.setBounds(180,110,110,20); p.add(modif);
     rech.setBounds(30,150,110,20);  p.add(rech);*/
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		if(e.getSource()==bten)
		{
			String nu,n,p;
			nu=txtnv.getText(); 
			n= (String) txtnomAc.getSelectedItem();
			p=txteqp.getText();
			
			
			
			String query="Insert into Activites values('"+nu+"','"+n+"','"+p+"')";
			
			
		try {
			  
			 st=k.etablirconnection().createStatement();
			 
 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
 
			 
			 if(txtnv.getText().length()!=0)
				 
			 { 
				 st.executeUpdate(query);
			   
			 JOptionPane.showMessageDialog(this,"Enregistrez avec succès");
			 
			
			   txteqp.setText("");
			   txtnv.setText("");
			  
				
			 }  else {JOptionPane.showMessageDialog (null,"veuillez remplire les champs !");}
			 
			
			 } catch (SQLException e1) {
		
			//e1.printStackTrace();
				JOptionPane.showMessageDialog(this,"errure d'ajout");
		}
	
		
		}
		
		//fermeture fenetre Enregistrement

		if(e.getSource()==ann)
		{
            //JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION);
			//dispose();
		
		
		   if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		   {
			   dispose();
		   }
		}
	}
		  
		
	

/*public static void main(String[] args) {
	
	Fen_Activites f=new Fen_Activites();
	f.setVisible(true);
	
	

}*/
	
}
