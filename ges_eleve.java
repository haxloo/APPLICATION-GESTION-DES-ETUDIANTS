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

public class ges_eleve extends JFrame implements ActionListener {
	
	JTextField txtnom,txtpren,txtdat,txtnum,txtann,txtpd,txtrec;
	JButton btModif,supp,rech,fer,ann;
	Statement st;
	private javax.swing.JFormattedTextField daten =new javax.swing.JFormattedTextField(DateFormat.getDateInstance());
	
	connection k=new connection();
	
	public ges_eleve()
	{ 
	  this.setTitle("");
	  this.setSize(400,350);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lbnum=new JLabel("matricule etu");
     JLabel lbnom=new JLabel("Nom");
     JLabel lbpren=new JLabel("Prenom");
     JLabel lbdat=new JLabel("Date de Naissance"); 
     JLabel lbann=new JLabel("adresse");
     JLabel lbpd=new JLabel("id_section");
     JLabel lbT=new JLabel("AJout D'un Nouveau etudiant");
     
     
     
     txtnum=new JTextField();
     txtnom=new JTextField();
     txtpren=new JTextField();
     txtdat=new JTextField("ZZZZ-YY-XX");
     txtann=new JTextField();
     txtpd=new JTextField();
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
     
     
      lbnum.setBounds(30,40,110,25);  p.add(lbnum);  lbnum.setFont(fe);
     txtnum.setBounds(200,40,120,25);p.add(txtnum);
     
     lbnom.setBounds(30,70,120,25);  p.add(lbnom);  lbnom.setFont(fe);
      txtnom.setBounds(200,70,120,25);p.add(txtnom);
     
     lbpren.setBounds(30,100,120,25);  p.add(lbpren);  lbpren.setFont(fe);
     txtpren.setBounds(200,100,120,25);p.add(txtpren);
     
     lbdat.setBounds(30,130,120,25);  p.add(lbdat);  lbdat.setFont(fe);
     txtdat.setBounds(200,130,120,25);  p.add(txtdat);
     
      
     lbpd.setBounds(30,160,120,25); p.add(lbpd);  lbpd.setFont(fe);
     txtpd.setBounds(200,160,120,25);p.add(txtpd);
     
     lbann.setBounds(30,190,120,25); p.add(lbann);  lbann.setFont(fe);
     txtann.setBounds(200,190,120,25);p.add(txtann);
     
    //ajout buttons
     
    btModif.setBounds(50,230,130,27); p.add(btModif); btModif.setFont(fe); btModif.setBackground(Color.CYAN); 
    ann.setBounds(50,270,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
      txtrec.setBounds(210, 10, 40, 25); p.add(txtrec);	
     rech.setBounds(50,5,130,25);  p.add(rech);
    supp.setBounds(200,230,130,25); p.add(supp); supp.setBackground(Color.cyan);
    
     //modif.setBounds(180,110,110,20); p.add(modif);
     
     //fer.setBounds(100,190,110,20); p.add(fer);*/
     
     //CONTENU DU PANEL
     
     add(p); 
       
		
		
	}
	
	
	

  
	
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		/*if(e.getSource()==bten)
		{
			String nu,n,p,a1;
			nu=txtnum.getText(); 
			n=txtnom.getText();
			p=txtpren.getText();
			String d=txtdat.getText();
			float pd = Float.valueOf(txtpd.getText());

			a1=txtann.getText();
			
			String query="Insert into eleve values('"+nu+"','"+n+"','"+p+"','"+d+"','"+pd+"','"+a1+"')";
			
			
		try {
			  
			 st=k.etablirconnection().createStatement();
			 
 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
 
			 
			 if(txtnum.getText().length()!=0)
				 
			 { 
				 st.executeUpdate(query);
			   
			 JOptionPane.showMessageDialog(this,"Enregistrez avec succès");
			 
			 txtnum.setText("");
			   txtnom.setText("");
			   txtpren.setText("");
			   txtdat.setText("");
			 
				
			 }  else {JOptionPane.showMessageDialog (null,"veuillez remplire les champs !");}
			 
			
			 } catch (SQLException e1) {
		
			//e1.printStackTrace();
				JOptionPane.showMessageDialog(this,"errure d'ajout");
		}
	
		
		}
		*/
		//fermeture fenetre Enregistrement
  //JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION);
			//dispose();
		
		
			if(e.getSource()==ann)
			{
	            //JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION);
				//dispose();
			
			
			   if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			   {
				   dispose();
			   }
			}
	
 //suppression
			
		if(e.getSource()==supp)
		{
			String n;
			n=txtnum.getText(); 
			
		String query="DELETE FROM etudiant WHERE matricule_etu='"+n+"'";
		
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
			String n,p,a,pr;
			
			n=txtnum.getText(); 
			p=txtnom.getText();
			pr=txtpren.getText();
			String d=txtdat.getText();
			float pd = Float.valueOf(txtpd.getText());
			String an=txtann.getText();
			
			String query="UPDATE  etudiant  SET nom_etu='"+p+"', prenom_etu='"+pr+"',date_naissance='"+d+"',adresse='"+pd+"',id_section="+an+" where  matricule_etu="+n+"";
			
			
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
			
   String query="SELECT * FROM etudiant  WHERE matricule_etu='"+n+"'";
			
		try {
			st=	k.etablirconnection().createStatement();
			
			ResultSet rst =st.executeQuery(query);
			
			if(rst.next())
			{   txtnum.setText(rst.getString("matricule_etu"));
				txtnom.setText(rst.getString("nom_etu"));
				txtpren.setText(rst.getString("prenom_etu"));
				txtdat.setText(rst.getString("date_naissance"));
				txtpd.setText(rst.getString("adresse"));
				txtann.setText(rst.getString("id_section"));
				
			} 
			else 
				JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
		    } catch (SQLException e1)
		
		{
	        
			}
	
		
		

		}	
		
	}
	
	
	
	

/*public static void main(String[] args) {
	
	ges_eleve ge=new ges_eleve();
	ge.setVisible(true);
	
	

}*/
	
}
