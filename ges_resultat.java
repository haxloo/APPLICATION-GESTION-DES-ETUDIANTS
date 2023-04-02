package GESTION;

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

public class ges_resultat extends JFrame implements ActionListener{
	
	private JTextField txttl,txtrec,txtNote1,txtNote2,txtNote3;
	private JLabel lbnump,lbnumc,lbNote1,lbNote2,lbNote3;
	private JButton bten,ann,ter;
	private JComboBox cmbonump=new JComboBox();
	private JComboBox cmbonumc=new JComboBox();
	Statement st;
	private JButton lbrec,lbsvt,lbsvtd;
	private String req1C = " select DISTINCT num_crs from  cours";
	private String req2E = " select DISTINCT num_elv from eleve";
	
	
	connection k=new connection();
	
	public ges_resultat()
	{ 
	   initCombo();
	  this.setTitle("Enregistrement_resultat_cours");
	  this.setSize(400,300);
      this.setLocationRelativeTo(null);
      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     //JLabel lbpt=new JLabel("point :");
     JLabel lbnump=new JLabel("numero_eleve:");
     JLabel lbnumc=new JLabel("Numero_cours");
     JLabel lbNote1=new JLabel("Note1");
     JLabel lbNote2=new JLabel("Note2");
     JLabel lbNote3=new JLabel("Note2");
     
         txtrec=new JTextField();
         lbrec=new JButton("Rechercher");
         lbsvt=new JButton("<");
         lbsvtd=new JButton(">");
        
        lbrec.setBounds(30, 5, 110, 20); p.add(lbrec); lbrec.addActionListener(this);       
        txtrec.setBounds(150,5,40,20);  p.add(txtrec); 
        lbsvt.addActionListener(this);  lbsvt.setBounds(200, 5,41,20); p.add(lbsvt); 
        lbsvtd.addActionListener(this);  lbsvtd.setBounds(250, 5,41,20); p.add(lbsvtd); 
     
       
       txtNote1=new JTextField();
       txtNote2=new JTextField();
       txtNote3=new JTextField();
       
  
    
     
     
     bten=new JButton("Modifier");       
     ann=new JButton("Supprimer"); 
     ter=new JButton("Terminer"); ter.addActionListener(this);  ter.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\fer.gif"));
     

     //ann.addActionListener(this);
     
     ann.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\supp.png"));
     
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
    cmbonump.setBounds(200,30,120,25); p.add(cmbonump);
      
    
     cmbonump.setForeground(Color.CYAN); cmbonumc.setPreferredSize(new Dimension( 400 , 200));
     
      lbnumc.setBounds(30,70,120,25);  p.add(lbnumc);  lbnumc.setFont(fe);
      cmbonumc.setBounds(200,70,120,25);p.add(cmbonumc);
     
     lbNote1.setBounds(30,110,120,25);  p.add(lbNote1);  lbNote1.setFont(fe);
      txtNote1.setBounds(80,110,50,25);p.add(txtNote1); txtNote1.setFont(fe);
     
      lbNote2.setBounds(150,110,120,25);  p.add(lbNote2);  lbNote2.setFont(fe);
      txtNote2.setBounds(190,110,50,25);p.add(txtNote2); txtNote2.setFont(fe);
      
      lbNote3.setBounds(260,110,120,25);  p.add(lbNote3);  lbNote3.setFont(fe);
      txtNote3.setBounds(300,110,50,25);p.add(txtNote3); txtNote3.setFont(fe);
      
     
     
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,160,130,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN); 	bten.addActionListener(this);   bten.setIcon(new ImageIcon("C:\\Users\\mohakalil\\Desktop\\img\\modif.png"));
    ann.setBounds(200,160,130,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);    ann.addActionListener(this);
    ter.setBounds(50,200,130,27); p.add(ter);  ter.setFont(fe);  ter.setBackground(Color.CYAN); 
    
     
     //CONTENU DU PANEL
     
     add(p); 
     
   }
	
	
	//recherche de numero cours dans le combo
	private void initCombo(){
		 
		 
			 Statement state;ResultSet res;
			 connection kk=new connection();
			 
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req1C);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonumc.addItem(res.getString("num_crs"));
					
				}res.close();state.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 
	
			try {
				state=kk.etablirconnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						
				state.executeQuery(req2E);
				
				res = state.getResultSet();
				while(res.next()){
					cmbonump.addItem(res.getString("num_elv"));
					
				}res.close();state.close();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
	//fermeture de la fenetre
			
			
}




@Override
public void actionPerformed(ActionEvent a) {
ResultSet rst1;
	
	//terminer
if(a.getSource()==ter)
{  
	if(JOptionPane.showConfirmDialog(this, "Etes vous sure d'avoir Terminier","Incident Majeur",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
{
	   dispose();
}
	}
	
//modification

 if(a.getSource()==bten)
 {
	  String n,n1,n2,n3,p,nn;
	    
	  String cc=(String) cmbonump.getSelectedItem();
	  String cc3=(String) cmbonumc.getSelectedItem();
		n1=txtNote1.getText(); 
		n2=txtNote2.getText();
		n3=txtNote3.getText();
		
		String query="UPDATE  resultat  SET Note1="+n1+", Note2="+n2+",Note3="+n3+" where num_elv='"+cc+"' and num_crs='"+cc3+"'";
		
		
	try {
		st=	k.etablirconnection().createStatement();
		
		st.executeUpdate(query);
		JOptionPane.showMessageDialog(this,"Modifier avec succès");
	
	
		
		
		} catch (SQLException e1) {
	
		 JOptionPane.showMessageDialog(this,"Vous Devez remplir les champs");
			
	}
	 
	 
	 
 }
	
	//boutton suivant
	if(a.getSource()==lbsvt)
	{ String n,p,x,z;
		n=txtrec.getText(); 
		p=txtNote1.getText();
		x=txtNote2.getText();
		z=txtNote3.getText();
		
  String query="SELECT * FROM resultat";
		
	try {
		 st=k.etablirconnection().createStatement();
		
		 rst1=st.executeQuery(query);
		
	  if(rst1.next())
		{   cmbonump.setSelectedItem(rst1.getString("num_elv"));
			cmbonumc.setSelectedItem(rst1.getString("num_crs"));
			txtNote1.setText(rst1.getString("Note1"));
			txtNote2.setText(rst1.getString("Note2"));
			txtNote3.setText(rst1.getString("Note3"));
		
			}
		 
			
	    } catch (SQLException e1)
	
	{
        
		}
	}
	
	//boutton dernier
	if(a.getSource()==lbsvtd)
	{ String n,p,x,z;
		n=txtrec.getText(); 
		p=txtNote1.getText();
		x=txtNote2.getText();
		z=txtNote3.getText();
		
  String query="SELECT * FROM resultat";
		
	try {
		 st=k.etablirconnection().createStatement();
		
		 rst1=st.executeQuery(query);
		
	   	if (rst1.last())
		{   cmbonump.setSelectedItem(rst1.getString("num_elv"));
			cmbonumc.setSelectedItem(rst1.getString("num_crs"));
			txtNote1.setText(rst1.getString("Note1"));
			txtNote2.setText(rst1.getString("Note2"));
			txtNote3.setText(rst1.getString("Note3"));
		
			} 
		else 
			JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
	    } catch (SQLException e1)
	
	{
        
		}
	}

	//suppression
	
	if(a.getSource()==ann)
	{
		String nm;
		nm=txtrec.getText(); 
		
	String req="DELETE FROM resultat WHERE num_elv='"+nm+"'";
	
	try {
		
		 
		if(JOptionPane.showConfirmDialog(this, "Voulez vraiment supprimez ","", JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
		{  
			st.executeUpdate(req);
		
			
		    JOptionPane.showMessageDialog(this,"Suppression effectuez avec succès");
		}
		
		 
	} 

     catch (SQLException e3) {
		  System.out.println("ERREUR2");
	
		
		}
		
   	}
//rechercher
	
	if(a.getSource()==lbrec)
	{ String n;
		n=txtrec.getText(); 
		
String query="SELECT * FROM resultat  WHERE num_elv='"+n+"'";
		
	try {
		st=	k.etablirconnection().createStatement();
		
		 rst1=st.executeQuery(query);
		
	   	if(rst1.next())
		{  cmbonump.setSelectedItem(rst1.getString("num_elv"));
			cmbonumc.setSelectedItem(rst1.getString("num_crs"));
			txtNote1.setText(rst1.getString("Note1"));
			txtNote2.setText(rst1.getString("Note2"));
			txtNote3.setText(rst1.getString("Note3"));
		
			} 
		else 
			JOptionPane.showMessageDialog(this,"INTROUVABLE","Erreur",JOptionPane.ERROR_MESSAGE);
	    } catch (SQLException e1)
	
	{
        
		}
	//boutton suivant
	
	
	//modification du tel
	
	
	
	
	
	}}


/*static public void main(String[] args) {
	
	ges_resultat f=new ges_resultat();
	f.setVisible(true);
	
}*/
}















