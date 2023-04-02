package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import connection.connection;

public class fen_users extends JFrame implements ActionListener {
	
	JTextField txtlog,txtpwd;
	JButton bten,supp,ann;
	Statement st;
	
	
	connection k=new connection();
	
	public fen_users()
	{ 
	  this.setTitle("Nouveau Users");
	  this.setSize(400,200);
	  this.setLocation(500, 200);
	  	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
      
     JPanel p=new JPanel();  p.setBackground(Color.white);
     p.setLayout(null);
     JLabel lblog=new JLabel("Speudo");
     JLabel lbpwd=new JLabel("Password");
     
     JLabel lbT=new JLabel("Saisie Info New User");
     
     
     txtlog=new JTextField();
     txtpwd=new JTextField();
     
    
     
     
     bten=new JButton("OK");
     ann=new JButton("Annuler");
     
     bten.addActionListener(this);
     ann.addActionListener(this);
     
     
     //boutton
     Font fe=new Font("Serif",0,15);
     
     
     lblog.setBounds(30,40,170,25);  p.add(lblog);  lblog.setFont(fe);
     txtlog.setBounds(200,40,120,25);p.add(txtlog);
     
     lbpwd.setBounds(30,70,120,25);  p.add(lbpwd);  lbpwd.setFont(fe);
      txtpwd.setBounds(200,70,120,25);p.add(txtpwd);
     
     //ajouts dans le panel
    lbT.setBounds(130,5,130,30); p.add(lbT);
    lbT.setForeground(Color.black); lbT.setPreferredSize(new Dimension( 400 , 200));
     
     
     
    // txtrec.setBounds(180,150,110,20);p.add(txtrec);
 
     
     
     //ajout buttons
     
    bten.setBounds(50,120,120,27); p.add(bten); bten.setFont(fe); bten.setBackground(Color.CYAN);
    ann.setBounds(200,120,120,27); p.add(ann);  ann.setFont(fe);  ann.setBackground(Color.CYAN);
   
     
     add(p); 
       }
	
	
@Override
	public void actionPerformed(ActionEvent e) {
		
		//enregistrement
		
		if(e.getSource()==bten)
		{
			String nu,n;
			nu=txtlog.getText(); 
			n=txtpwd.getText();
			
			
			
			String query="Insert into user_app values('"+nu+"','"+n+"')";
			
			
			try {
				  
				 st=k.etablirconnection().createStatement();
				 
	 if(JOptionPane.showConfirmDialog(this,"Voulez Vous Enregistrez","Attention",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION);
	 
				 
				 if(txtlog.getText().length()!=0)
					 
				 { 
					 st.executeUpdate(query);
				   
				 JOptionPane.showMessageDialog(this,"Enregistrez avec succès");
				 
			
				
				   txtlog.setText("");
				   txtpwd.setText("");
				 
					
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
	
	fen_users f=new fen_users();
	f.setVisible(true);
	
	

}*/
	
}
