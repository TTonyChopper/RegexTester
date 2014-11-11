import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.*;


public class GFrame extends JFrame
	{
	 int margin;
	
	 public GFrame()
	 {	 
		 super("TP option 3A : Testeur de RegEx");
		 //alternative :
		 //super();
		 //this.setTitle("TP option 3A : Testeur de RegEx");
	 }
	 
	 public Insets getInsets()
	 {
		 Insets in = super.getInsets();
		 return new Insets(in.top+margin,in.left+margin,in.bottom+margin,in.right+margin);
	 }
	 
	 public void setMargin(int m)
	 {
		 margin=m;
	 }
	 
	}
