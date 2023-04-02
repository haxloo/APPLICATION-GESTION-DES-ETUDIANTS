package connection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Acceuil.Menu_accueil;



public class login extends JFrame {
	
	JTextField txtlog;
	JPasswordField txtpwd;
	JButton con,ann;
	Statement st;
	ResultSet rt;
	connection kk=new connection();
	public static int id_user=0;
	public login()
	
	{     this.setTitle("IDENTIFICATION");
		  this.setSize(400,300);
	      this.setLocationRelativeTo(null);
	      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      
	      JPanel p=new JPanel();
		     p.setLayout(null);
		     
		        
		     
		     txtlog=new JTextField("BDDAdmin");
		     txtpwd=new JPasswordField();
		     
		     JLabel txt=new JLabel("IDENTIFICATION");
		    
		     
	      JLabel lblog=new JLabel("Utilisateur");
	     
	      
	         JLabel lbpwd=new JLabel("Mot de passe");
	        
	         
	         
	         con=new JButton("Connexion");
	        
	         ann=new JButton("Terminer");
	      
	         
	         Font fer = new Font("BOLD",0, 16);
	         lblog.setFont(fer);
	         lbpwd.setFont(fer);
	         con.setFont(fer);
	         ann.setFont(fer);
	         txt.setFont(fer);
	         JLabel ac=new JLabel();
	     
	          ac.setBounds(5, 90, 160, 90);
	          p.add(ac)	;      //positionnement des lable et boutons
	         
	         txt.setBounds(150,50,200,30); p.add(txt);
	         txt.setSize(150,20);
	         //txt.setBackground(arg0);
	       
	      lblog.setBounds(130,100,150,23);  p.add(lblog);
	      txtlog.setBounds(230,100,130,23); p.add(txtlog);
	      
	      lbpwd.setBounds(130,140,170,23); p.add(lbpwd);
	      txtpwd.setBounds(230,140,130,23); p.add(txtpwd);
	      
	      con.setBounds(130,200,110,20); p.add(con);
	      ann.setBounds(250,200,110,20); p.add(ann);
	      
	      
	 //les événements pour la connection
	      
	      con.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				String c,p;
				c=txtlog.getText(); 
				p=txtpwd.getText();
				
				String query="SELECT * FROM user_app WHERE user_name='"+c+"' and motdepasse='"+p+"'"; 
				
				
				try {
					st=kk.etablirconnection().createStatement();
					rt=st.executeQuery(query);
					
					if(rt.next()) {
						
						if(c.equalsIgnoreCase(rt.getString("user_name")) && p.equalsIgnoreCase(rt.getString("motdepasse")))
						{
							if(c.equalsIgnoreCase("BDDAdmin")) {
								id_user=1;
							}else {
								if(c.equalsIgnoreCase("Etudiant")) {
									id_user=2;
								}else {
									id_user=3;
								}
							}
							Menu_accueil f=new Menu_accueil();
							f.setVisible(true); 
							dispose();
							
							
						}else {
							System.out.println("introuvable");
						}
						
						
					}
					 
					else 
						JOptionPane.showMessageDialog(null, "l'utilisateur ou le mot de passe sont faux");
					
				} catch (SQLException e) {
					
					
					//e.printStackTrace();
				}
				
				
				
				
				
				
			}
			
			
		}
	      );
	      
	      
	      
	      //evenements pour la fermeture "close"
	      
	      ann.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
				
			}
		});
	       
	      
	     this.setContentPane(p);
	   }


		public static void main(String[] args) {
			
			login fen=new login();
			fen.setVisible(true);
		}

	}

	


