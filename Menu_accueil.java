package Acceuil;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;

import requette.req1;
import requette.req2;

import Affichage.listAct;
import Affichage.listEleve;
import Affichage.listactiv_pratiq;
import Affichage.listcharge;
import Affichage.listcours;
import Affichage.listprofesseurs;
import Affichage.listresults;
import Affichage.listusers;
import GESTION.ges_activiites;

import GESTION.ges_eleve;
import GESTION.ges_prof;
import GESTION.ges_resultat;
import connection.login;
//import Affichage.req1;
import frame.Fen_Activites;
import frame.Fen_ajout_Elève;
import frame.Fen_ajout_Professeurs;
import frame.Fen_ajout_cours;
import frame.Jlabel;
import frame.fen_Activites_Pratiques;
import frame.fen_Resultats;
import frame.fen_charge;
import frame.fen_users;




public class Menu_accueil extends JFrame implements ActionListener{
	
	private JMenuItem enr,cr,prf,act,nvrlt,qt,appr,lisE,Act_P,lisAP,lisEl,lisCrs,lisProf,luse;
	private JMenuBar menu;
	private JMenu Fich,aff,app,admin;
	private JMenuItem nv,st,cont;
	private JPanel img,img2,dpimg;
	private JToolBar menubar ;
	private JButton req;
	int id_user =login.id_user;
      private JButton b = new JButton("   Liste des Etudiants          ");
	  private JButton b1 = new JButton("  Liste des Section          ");
	  private JButton b2 = new  JButton(" Liste des Enseignants");
	 
	  private JButton b4 = new JButton("  Les resultats         ");
	  private JButton b5 = new JButton("  Liste Unités" );
	 
	  private JButton b7 = new JButton("     requete01            ");
	  private JButton b8 = new JButton("     requete02            ");
	 
	  private JButton b001= new JButton("    Etudiant               ");
	  private JButton b002 =new JButton("    Enseignant         ");
	  private JButton b006= new JButton("    Unité          ");
	 
	  
	  private JTabbedPane onglet=new JTabbedPane(); 
	  
	private JPanel re=new JPanel();
	private JPanel re2=new JPanel();
	private JPanel re1=new JPanel();
	private JPanel re3=new JPanel();
	
	
	
	
	//private JButton enr1;
	//javax.swing.JLabel img2;
	
	 private String requete01 = "SELECT COLUMN_NAME as 'NOM de colonne', DATA_TYPE as 'TYPE', CHARACTER_MAXIMUM_LENGTH as 'TAILLE' FROM information_schema.COLUMNS WHERE table_name = 'eleves'";
	public <split, split1> Menu_accueil()
	{ 
		JSplitPane split;
		JSplitPane split1;
		
		 Container c=getContentPane();
		 JLabel ne =  new JLabel();
		 ne.setIcon(new ImageIcon(""));
		 
		 
		 // JLabel nea =  new JLabel();
		  ne.setPreferredSize(new java.awt.Dimension(800,400));
		
		   
		
		 
		
		this.setTitle("Acceuil");
		  this.setSize(900,700);
	      this.setLocation(250,50);
	     
	    b.addActionListener(this);   
	    b1.addActionListener(this); 
	    b2.addActionListener(this); 
	   
	    b4.addActionListener(this); 
	    b5.addActionListener(this); 
	   
	  
	      JLabel txt=new JLabel("BIENVENUE");
	      
	    JMenuBar menu=new JMenuBar();
	    setJMenuBar(menu);
	    //menus
	   JMenu Fich=new JMenu("archive");
	    menu.add(Fich);
	    
	    
	    
	   Fich.setMnemonic('a');
	   img=new JPanel(); img.add(ne); //img.add(nea); 
	  
	    
	    
	   // b.setBounds(10, 22,100, 20);
	    
	    JLabel fondimg=new JLabel();
	 
	    //
	    fondimg.setSize(900, 800);
	 
	    //ONGLET
	   // re.setSize(10,900);
	    re.setBounds(5, 20,218, 800);
	    onglet.setSize(400, 830);
		 onglet.setBorder(null);
		onglet.setBackground(Color.white);
		 re.setLayout(new BorderLayout());
		 
	     re1.add(b,BorderLayout.WEST ); b.setBackground(Color.white);  b.setPreferredSize(new Dimension(200,24)); 
		 re1.add(b1,BorderLayout.WEST); b1.setBackground(Color.white); b1.setPreferredSize(new Dimension(200,25));
		 re1.add(b2,BorderLayout.WEST); b2.setBackground(Color.white); b2.setPreferredSize(new Dimension(200,25));
		 
		 re1.add(b4,BorderLayout.WEST); b4.setBackground(Color.white);  b4.setPreferredSize(new Dimension(200,25));
		 re1.add(b5,BorderLayout.WEST); b5.setBackground(Color.white);  b5.setPreferredSize(new Dimension(200,25));
		 
		
		 onglet.add("affichage",re1);   re.add(onglet); 
		 re2.add(b7,BorderLayout.WEST ); b7.setBackground(Color.white); b7.addActionListener(this);
		 re2.add(b8,BorderLayout.WEST ); b8.setBackground(Color.white); b8.addActionListener(this);
		 
		 re2.setBackground(Color.white);
		 //gestion tables
		 re3.add(b001,BorderLayout.WEST ); b001.setBackground(Color.white); b001.setPreferredSize(new Dimension(150,25));  b001.addActionListener(this);
		 re3.add(b002,BorderLayout.WEST); b002.setBackground(Color.white);  b002.setPreferredSize(new Dimension(150,25));  b002.addActionListener(this);
		 re3.add(b006,BorderLayout.WEST); b006.setBackground(Color.white);  b006.setPreferredSize(new Dimension(150,25));  b006.addActionListener(this);
		
	      onglet.add("Gestion",re3);
	      re3.setBackground(Color.white);
		 
	      
		 
		 onglet.add("requête",re2);  
		 
		
		
		   re1.setBackground(Color.white);
			split = new javax.swing.JSplitPane(javax.swing.JSplitPane.VERTICAL_SPLIT, new javax.swing.JScrollPane(null), null);
		    split.setDividerLocation(100);
		    split.setDividerSize(2);
		    split1 = new javax.swing.JSplitPane(javax.swing.JSplitPane.HORIZONTAL_SPLIT, re, split);
		    split1.setDividerLocation(220);
		    split1.setDividerSize(2);
		  
		
		
		 

		 
	    img.setBounds(210,100,1400,625);
	    img.setBackground(Color.white);
	    
	     img.setLayout(new BorderLayout());
	     
	   // img.add(new JLabel("hello"));
	      
	      
	    JButton im2=new JButton("BIENVENUE");
	   // img.add(dpimg);
	    img2=new JPanel(); 
	    img2.setLayout(null);
	    im2.setBounds(240,30, 200, 40);
	    img2.setBounds(210,2,1400,90); 
	    img2.setBackground(Color.WHITE);	
	    img2.add(im2);
	   
	    
	    //MENU BARE
	    
	    menubar=new JToolBar();
	    menubar.setBounds(5, 2, 1400,19);
	    //button requête
	    req=new JButton("Exécuter la Requête");
	    menubar.add(req);	    
	    
	    //sous menu(-
	    
	   JMenu nv=new JMenu("Nouveau");
	    Fich.add(nv);
	    nv.setMnemonic('N');
	    
	   //JLabel image = new JLabel(new ImageIcon("images/ulg.jpg"));
	    
	    JMenuItem enr=new JMenuItem("Nouveau Etudiant");  
	    
	    nv.add(enr);
	   enr.setMnemonic('e');
	   
	    enr.setBounds(0,0,0,20);
	    JMenuItem cr=new JMenuItem("Nouvelle section"); 
	  
	    nv.add(cr);
	    cr.setMnemonic('c');
	  
	    JMenuItem prf=new JMenuItem("Nouveau Enseignant"); prf.setMnemonic('p');
	   
	     nv.add(prf);
	    
	     JMenuItem act=new JMenuItem("Nouvelle  unité");
	     act.setMnemonic('v');
	     
	     JMenuItem nvrlt=new JMenuItem("Nouveau Etudiant Unité");


	     nv.add(nvrlt);  nvrlt.setMnemonic('r');
	     
	    
	     
	     JMenuItem Act_p=new JMenuItem("Nouvelle  unité");
	     nv.add(Act_p);
	     
	     //affichage des onglets et requêtes
	     
	    
	     //image de font
	     
	  //  cr.addActionListener(this);
	     
	  
	    
	    JPanel i=new JPanel(); 
	    i.setLayout(null);
	    
	    //enr1=new JButton("Enregistrement");
	   // enr1.setBounds(300,150,100,30);
	 qt=new JMenuItem("Quitter");
	 qt.setMnemonic('q');
	    Fich.add(qt);
	  
	  qt.addActionListener(new ActionListener()
	  {
            @Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
	}
		  
	  });
	    
	    
	   JMenu aff=new JMenu("Consultation");
	    menu.add(aff); aff.setMnemonic('c');
	    
	    
	    JMenu admin=new JMenu("admin");
	    menu.add(admin); admin.setMnemonic('d');
	    
	    JMenu NU=new JMenu("Nouveau");
	    admin.add(NU);
	    NU.setMnemonic('n');
	    
	    JMenuItem us=new JMenuItem("User");
	    NU.add(us); us.setMnemonic('u');
	    
	    JMenu lUS=new JMenu("les Users");
	    admin.add(lUS);
	   
	    JMenuItem luse=new JMenuItem("liste des Utilisateurs"); 
	    lUS.add(luse);
	     
	    
	
	   
	
		 
		
		 
		 
	   
  JMenu st=new JMenu ("Structure de table");
	    aff.add(st);
	    
	    lisEl=new JMenuItem("Liste des etudiants"); 
		 st.add(lisEl);
		 
	    
	    lisE=new JMenuItem("Liste Resultats"); 
		 st.add(lisE);
		 
		
		lisAP=new JMenuItem("Liste Unités"); 
		st.add(lisAP);		
		
		
		
		lisCrs=new JMenuItem("Liste des Section");  
		st.add(lisCrs);
		 
		lisProf=new JMenuItem("Liste des Enseignants");  
		st.add(lisProf);
		
		 
				
	  
	    
	    i.add(re); 
	    img.add(fondimg); 
	    i.add(menubar);
	    i.add(img); i.add(img2); 
	    
	    add(i); 
	    
	    //ajouts des fenetres et ses evenements
	  
	   
	    
	    lisEl.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				listEleve el=new listEleve();
				if(login.id_user==1) {
				el.setVisible(true);}
				el.setResizable(false);
			}
	    	
	    	
	    	
	    });
	    
	    us.addActionListener(new ActionListener()
	    {@Override
		  public void actionPerformed(ActionEvent arg0) {
				fen_users user=new fen_users();
				if(login.id_user==1) {
				user.setVisible(true);}
				user.setResizable(true);
				
			} });
	    
	    
	  
	    
	   nvrlt.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				fen_Resultats w=new fen_Resultats();
				if(login.id_user==1) {
				w.setVisible(true);}
				w.setResizable(true);
				
			}
	    	
	    	
	    });
	    
	    act.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				Fen_Activites f=new Fen_Activites();
				if(login.id_user==1) {
				f.setVisible(true);}
				f.setResizable(true);
				
			}
	    	
	    	
	    	
	    });
	    
	    
	    luse.addActionListener(new ActionListener()
		   {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				listusers use=new listusers();
				if(login.id_user==1) {
				use.setVisible(true);}
			}
			   
		   });
		   
	    
	    
	    lisE.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				listresults  el=new listresults();
				if(login.id_user==1) {
				el.setVisible(true);
				}
				
			}	
	    });
	    
	    
	    //Lista Activités_pratiques
	    Act_p.addActionListener(new ActionListener()
	    {
                 @Override
			public void actionPerformed(ActionEvent arg0) {
               fen_Activites_Pratiques act=new  fen_Activites_Pratiques ();
               if(login.id_user==1) {
				act.setVisible(true);}
				
			}
	    	
	    });
	    
	   lisAP.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			listactiv_pratiq lAP=new listactiv_pratiq();
			if(login.id_user==1) {
			lAP.setVisible(true);
			}
			
		}
		   
   });
	    
	   
	  
	   
	   
	   lisProf.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			listprofesseurs pr=new listprofesseurs();
			if(login.id_user==1) {
			pr.setVisible(true);
			}
			
		}});
	   
	   
	   lisCrs.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			listcours crs=new listcours();
			if(login.id_user==1) {
			crs.setVisible(true);
			}
			
			
		}});
	   
	   
	  
	   
	   
	   
	   
	   
	   
	   
	    prf.addActionListener(new ActionListener()
	    {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Fen_ajout_Professeurs pr=new Fen_ajout_Professeurs();
				if(login.id_user==1) {
				pr.setVisible(true);
				}
				pr.setResizable(false);
				
			}
	    	
	    	
	    });
	    
	  cr.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Fen_ajout_cours f=new Fen_ajout_cours();
			if(login.id_user==1) {
			f.setVisible(true);
			}
			f.setResizable(false);
			
			
		}
		   
	   });
		   
	   
	   enr.addActionListener(new ActionListener()
	   {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Fen_ajout_Elève fe=new Fen_ajout_Elève();
			if(login.id_user==1) {
			fe.setVisible(true);
			}
			fe.setResizable(false);
			
		}
		   
		   
	   });}
	
	
//affichage onglets et requêtes

@Override
public void actionPerformed(ActionEvent e) {
	
	
	if(e.getSource()==b)
	{
		listEleve el=new listEleve();
		if(login.id_user==1 || login.id_user==3 ) {
		el.setVisible(true); }
	}

	if(e.getSource()==b1)
	{
		listcours cr=new listcours();
		if(login.id_user==1) {
				cr.setVisible(true);
		}
				cr.setResizable(true);
	}
	
	if(e.getSource()==b2)
	{ 
		listprofesseurs pr=new listprofesseurs();
		if(login.id_user==1 || login.id_user==2) {
		pr.setVisible(true);
		}
		
	}
	
	
	if(e.getSource()==b4)
	{
		listresults re=new listresults();
		if(login.id_user==1) {
		re.setVisible(true);
		}
		re.setResizable(false);
	}
	
	if(e.getSource()==b5)
	{
		listactiv_pratiq actp=new listactiv_pratiq();
		if(login.id_user==1) {
		actp.setVisible(true);
		}
		actp.setResizable(false);
				
	}
	
	
	if(e.getSource()==b7)
	  {     

		//JOptionPane.showConfirmDialog(this, "Voulez vous affichez le nom,prenom des éléves qui sont dans l'équipe SEQUENCE","Question", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.showConfirmDialog(this, "Voulez vous affichez le nom,prenom des étudiants par  note",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
		{ String m=JOptionPane.showInputDialog(this,"Enter notes d'examens","Messages",2);
			req1 r=new req1(m);
			if(login.id_user==1) {
	   r.setVisible(true);}
	   r.setResizable(false);}
		
		else if(JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
			
} }
	

	if(e.getSource()==b8)
	  {  
		//JOptionPane.showConfirmDialog(this, "Voulez vous affichez le nom,prenom des éléves qui sont dans l'équipe SEQUENCE","Question", JOptionPane.YES_NO_OPTION);
		if(JOptionPane.showConfirmDialog(this, "les noms et prénoms des étudiants qui ne sont pas inscrits dans l'unité donnée",null, JOptionPane.OK_OPTION)==JOptionPane.OK_OPTION)
		{ String m2=JOptionPane.showInputDialog(this,"Enter notes d'examens","Messages",2);
		
			req2 r2=new req2(m2);
			if(login.id_user==1) {
	   r2.setVisible(true); } }
		
		else if(JOptionPane.OK_CANCEL_OPTION==JOptionPane.NO_OPTION){ 
			
} }
	
  
  
	
  
  if(e.getSource()==b001)
  {  
	   ges_eleve ge=new ges_eleve();
	   if(login.id_user==1 || login.id_user==3 ) {
	   ge.setVisible(true);  }
	}
  
  if(e.getSource()==b002)
  {  
	   ges_prof gp=new ges_prof();
	   if(login.id_user==1 ||  login.id_user==2) {
	   gp.setVisible(true);  }
	   gp.setResizable(false);
	}
  
  
  
  
  
  

  
  
  if(e.getSource()==b006)
  {  
	   ges_activiites gap=new ges_activiites();
	   if(login.id_user==1) {
	   gap.setVisible(true);  }
	   gap.setResizable(false);
	}
  
  
 
 
	 
  
 
	  }

  

public static void main(String[] args)
 {
	
		Menu_accueil x=new Menu_accueil();
		x.setVisible(true);
		
		x.setResizable(false);
		 

	}

	
}


