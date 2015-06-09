package helloworld;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Windows1 extends JFrame{
	
	public Windows1(String my_name)
	{
		super("The Title Bar");
		setLayout(new FlowLayout());
		
		JLabel item = new JLabel("Hi John the entered name is "+my_name);
		item.setToolTipText("This is Hint");
		
		add(item);
	}
	
	public static void main(String [] args)
	{
		String my_name = JOptionPane.showInputDialog("Enter the name");
		
		Windows1 obj = new Windows1(my_name);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(275,180);
		obj.setVisible(true);
	}

}
