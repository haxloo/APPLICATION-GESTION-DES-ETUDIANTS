package GESTION;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





import java.sql.Date;

import connection.connection;

public class ges_activiites extends JFrame implements ActionListener {
	
	JTextField txtnomact,txtnv,txtequip,txtrec,txtmat;
	JButton btModif,supp,rech,fer,ann;
	Statement st;
	private javax.swing.JFormattedTextField daten =new javax.swing.JFormattedTextField(DateFormat.getDateInstance());
	
	connection k=new connection();
	
	public ges_activiites()
	{ 
	  this.setTitle("");
	  this.setSize(400,350);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnv=new JLabel("Code unite");
     JLabel lbnomact=new JLabel("Libelle");
     JLabel lbequip=new JLabel("Nbr heures");
     JLabel lbmat=new JLabel("Matricule_ens");
     
     
     
     
     txtnv=new JTextField();
     txtnomact=new JTextField();
     txtequip=new JTextField();
     txtmat=new JTextField();
     
    
     txtrec=new JTextField(""); txtrec.setBackground(Color.WHITE);
     btModif=new JButton("Modifiez");
     ann=new JButton("Terminer");
     
     btModif.addActionListener(this);
     ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("gramound",0,15);
     
     supp=new JButton("Supprimer");
    
    // modif=new JButton("Modifier");
     
     rech=new JButton("Rechercher");
  
     
     fer=new JButton("Terminez");  
     
     
     
     supp.addActionListener(this);
    // modif.addActionListener(this);
     rech.addActionListener(this);
  
    // fer.addActionListener(this);
     
     
     
     //ajouts dans le panel
    // lbT.setBounds(15,0,340,20); p.add(lbT);
     
     
      lbnv.setBounds(30,90,110,25);  p.add(lbnv);  lbnv.setFont(fe);
     txtnv.setBounds(200,90,120,25);p.add(txtnv);
     
     lbnomact.setBounds(30,130,120,25);  p.add(lbnomact);  lbnomact.setFont(fe);
      txtnomact.setBounds(200,130,120,25);p.add(txtnomact);
     
     lbequip.setBounds(30,170,120,25);  p.add(lbequip);  lbequip.setFont(fe);
     txtequip.setBounds(200,170,120,25);p.add(txtequip);
     
     lbmat.setBounds(30,200,120,25);  p.add(lbmat);  lbmat.setFont(fe);
     txtmat.setBounds(200,200,120,25);p.add(txtmat);
     
    
  //ajout buttons
     
    btModif.setBounds(50,230,130,27); p.add(btModif); btModif.setFont(fe); btModif.setBackground(Color.CYAN);   btModif.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\modif.png"));
    ann.setBounds(50,270,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
      txtrec.setBounds(180,40, 40, 30); p.add(txtrec);	
     rech.setBounds(30,40,140,30);  p.add(rech); rech.setBackground(Color.CYAN);
    supp.setBounds(200,230,130,25); p.add(supp); supp.setBackground(Color.cyan);
    
     //modif.setBounds(180,110,110,20); p.add(modif);
     
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	

  
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		  
		if(e.getSource()==ann)
			{
	            
			if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			   {
				   dispose();
			   }
			}
	
  //suppression
			
		if(e.getSource()==supp)
		{
			String n;
			n=txtnv.getText(); 
			
		String query="DELETE FROM unite WHERE code_unite='"+n+"'";
		
		try {
			 st=k.etablirconnection().createStatement();
			 
			 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment supprimez ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
			 {
			    st.executeUpdate(query);
			    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succès");
			 } 
			 else if (JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
				}
				
			 }
			   
		
	     catch (SQLException e2) {
			   JOptionPane.showMessageDialog(null, "Erreur de suppresion verifiez le lien ou n'existe pas");
		
			
			}
			
       	}
		
		
		//Modification
		if(e.getSource()==btModif)
		{
			String n,p,a,pr,mat;
			
			n=txtnv.getText(); 
			p=txtnomact.getText();
			pr=txtequip.getText();
			mat=txtmat.getText();
			
			
			
			String query="UPDATE  unite SET libelle='"+p+"', nbr_heures='"+pr+"' , matricule_ens='"+mat+"' where code_unite="+n+"";
			
			
			try {
				 st=k.etablirconnection().createStatement();
				 
				 if(JOptionPane.showConfirmDialog(this, "Voulez vraiment Modifiez ? ",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
				 {
				    st.executeUpdate(query);
				    JOptionPane.showMessageDialog(this,"Modification effectuez avec succès");
				 } 
				 else if (JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
					}
			}
			 catch (SQLException e2) {
				   JOptionPane.showMessageDialog(null, "Erreur de suppresion verifiez le lien ou n'existe pas");
			
				
				}
					}
				 
				   
		
		//recherche
		
		if(e.getSource()==rech)
		{ String n;
			n=txtrec.getText(); 
			
   String query="SELECT * FROM unite  WHERE code_unite="+n+"";
			
		try {
			st=	k.etablirconnection().createStatement();
			
			ResultSet rst =st.executeQuery(query);
			
			if(rst.next())
			{   txtnv.setText(rst.getString("code_unite"));
				txtnomact.setText(rst.getString("libelle"));
				txtequip.setText(rst.getString("nbr_heures"));
				txtmat.setText(rst.getString("matricule_ens"));
				
				
			} 
			else 
				JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
		    } catch (SQLException e1)
		
		{
	        
			}
	
		
		

		}	
		
	}
	
	
	
	
/*
public static void main(String[] args) {
	
	ges_activiites ge=new ges_activiites();
	ge.setVisible(true);
	
	

}*/
	
}
