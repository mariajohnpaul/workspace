package helloworld;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EventHandling extends JFrame {
	
	public class MJHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent mjevent) {
			// TODO Auto-generated method stub
			
			if(mjevent.getSource()==jtf1)
			{
				String st = String.format("field 1: %s", mjevent.getActionCommand());
				JOptionPane.showMessageDialog(null, st);
			}
			
		}

	}


	private JTextField jtf1 ;
	private JTextField jtf2 ;
	private JTextField jtf3 ;
	
	private JPasswordField jpf;
	
	public EventHandling(){
		super("The Title");
		setLayout(new FlowLayout());
		
		jtf1 = new JTextField(10);
		add(jtf1);
		
		jtf2 = new JTextField("Enter the Text");
		add(jtf2);
		
		jtf3 = new JTextField("Not Editable",20);
		jtf3.setEditable(false);
		add(jtf3);
		
		jpf = new JPasswordField("My Pass");
		add(jpf);
		
		MJHandler objhandler = new MJHandler();
		
		jtf1.addActionListener(objhandler);
		jtf2.addActionListener(objhandler);
		jtf3.addActionListener(objhandler);
		jpf.addActionListener(objhandler);
		
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventHandling obj = new EventHandling();
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.setSize(350,100);
		obj.setVisible(true);
	}
		

}
