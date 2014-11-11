import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.util.regex.*;


public class Widgets extends GFrame implements
	ActionListener,//Pour evenements bouton
	WindowListener,//Pour evenements fenetre
	DocumentListener,// Pour saisie de texte
	KeyListener//Pour appui touche
	//Initialisation des 8 objets qui apparaissent dans la fenetre
{ 
     private JLabel Text1;
     private JLabel Text2;
     private JLabel Text3;
     private JTextField Barre1;
     private JTextField Barre2;
     private JComboBox Liste1;
     private JLabel Image1;
     private JLabel Image2;
     private JButton Bouton;
     private Icon Vide = new ImageIcon("./Void.jpg");
     private Icon Feurouge = new ImageIcon("./FeuRouge.jpg");
     private Icon Feuvert = new ImageIcon("./FeuVert.jpg");
       
public Widgets(int m)
     {	   
      setMargin(m);   
      addWindowListener(this);
      
      setMinimumSize(new Dimension(16*35, 16*8));
      setLocationRelativeTo(null);
      
      GridBagLayout grid = new GridBagLayout();
      setLayout (grid);
      GridBagConstraints C= new GridBagConstraints();
      
      //Placement du premier        
      //C.fill = GridBagConstraints.BOTH;
      C.gridx=0;
      C.gridy=0;
      C.gridwidth=1;
      C.gridheight=1;
      C.weightx=1;
      C.weighty=1;
      C.ipady=4;
      
      
      Text1 = new JLabel("RegEx");
      grid.setConstraints(Text1,C);
      add(Text1);
      
    //Placement du deuxieme
      C.gridy=2;
      
      
      Text2 = new JLabel("Candidat");
      grid.setConstraints(Text2,C);
      add(Text2);
      
    //Placement du troisieme
      C.gridy=4;
      
      
      Text3 = new JLabel("Captures");
      grid.setConstraints(Text3,C);
      add(Text3);    

    //Placement du quatrieme        
      C.gridx=1;
      C.gridy=0;
      C.gridwidth=35;
      C.gridheight=1;
      
      
      Barre1 = new JTextField(35);
      grid.setConstraints(Barre1,C);
      add(Barre1);
      Barre1.getDocument().addDocumentListener(this);
      Barre1.addKeyListener(this);
      
    //Placement du cinquieme        
      C.gridy=2;      
      
      
      Barre2 = new JTextField(35);
      grid.setConstraints(Barre2,C);
      add(Barre2);
      Barre2.getDocument().addDocumentListener(this);
      Barre2.addKeyListener(this);
      
    //Placement du sixieme        
      C.gridy=4;

      
      String[] captures={""};
      Liste1 = new JComboBox(captures);
      grid.setConstraints(Liste1,C);
      add(Liste1);
      
    //Placement du septieme        
      C.gridx=36;
      C.gridy=0;
      C.gridwidth=1;
      C.gridheight=1;      
      
      
      Image1 = new JLabel();
      grid.setConstraints(Image1,C);
      Image1.setDisabledIcon(Feurouge);
      Image1.setIcon(Vide); 
      add(Image1);
      
    //Placement du huitieme        
      C.gridy=2;
      
      
      Image2 = new JLabel();
      grid.setConstraints(Image2,C);      
      //image2.setEnabled(false);
      Image2.setDisabledIcon(Feuvert);
      //image2.setIcon(Feurouge);
      Image2.setIcon(Vide);
      //image2.setEnabled(true);
      add(Image2);

    //Placement du neuvieme       
      C.gridy=4;      
     
      
      Bouton = new JButton("Tester !");
      grid.setConstraints(Bouton,C);
      add(Bouton);
      Bouton.addActionListener(this);
      Bouton.setEnabled(false);
   
      
      //Afficher
      pack();
      setVisible(true);
	  
    } 
public void windowActivated(WindowEvent arg0) {}
public void windowClosed(WindowEvent arg0) {}
public void windowClosing(WindowEvent arg0) {}
public void windowDeactivated(WindowEvent arg0) {}
public void windowDeiconified(WindowEvent arg0) {}
public void windowIconified(WindowEvent arg0) {}
public void windowOpened(WindowEvent arg0) {}
public void actionPerformed(ActionEvent e) 
{
	if(e.getSource() == Bouton) {
		String Texte1=Barre1.getText();
		String Texte2=Barre2.getText();
		Pattern p=Pattern.compile(Texte1);
		Matcher m= p.matcher(Texte2);
		Boolean ok=m.matches();
		if (ok)
		{
			System.out.print(ok);
			if ((Liste1.getItemAt(0)).equals(""))
			{Liste1.removeItemAt(0);
			}
			Liste1.addItem(Texte2);
			Image2.setEnabled(false);
		}else 
		{Image1.setEnabled(false);
		}	
	}
}
public void insertUpdate(DocumentEvent e)
{ 
	if(e.getDocument() == Barre1.getDocument()) 
	{	 if(Bouton.isEnabled()==false)
		 {Bouton.setEnabled(true);
		 }
	     if(Image1.isEnabled()==false)
	     {Image1.setEnabled(true);
	     }else if(Image2.isEnabled()==false)
	     {Image2.setEnabled(true);
	     }	
	}else if(e.getDocument() == Barre2.getDocument()) 
	{	 if(Bouton.isEnabled()==false)
	 	 {Bouton.setEnabled(true);
	 	 }
		if(Image1.isEnabled()==false)
		{Image1.setEnabled(true);
		}else if(Image2.isEnabled()==false)
		{Image2.setEnabled(true);
		}	
    }
}
public void changedUpdate(DocumentEvent e) {}
public void removeUpdate(DocumentEvent e) {}
public void keyPressed(KeyEvent e)
{	if(e.getKeyCode() == e.VK_BACK_SPACE)
	{String Text1=Barre1.getText();
	 String Text2=Barre2.getText();
	 if(Image1.isEnabled()==false)
		{Image1.setEnabled(true);
		}else if(Image2.isEnabled()==false)
		{Image2.setEnabled(true);
		}	
	 if((Text1.length()==1&&Text2.equals(""))||(Text2.length()==1&&Text1.equals("")))
	 {Bouton.setEnabled(false);
	 }
	}if(e.getKeyCode() == e.VK_ENTER)
	{ Bouton.doClick();
	}
}
public void keyReleased(KeyEvent e){}
public void keyTyped(KeyEvent e) {}


}