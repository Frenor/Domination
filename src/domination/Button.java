package domination;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Button extends JApplet {
	private JButton b1 = new JButton("Academy");
	private JButton b2 = new JButton("Haven");
	private JButton b3 = new JButton("Inferno"); 
	private JButton b4 = new JButton("Necropolis"); 
	private JButton b5 = new JButton("Sylvan");

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String name = ((JButton) e.getSource()).getText();
			Main.init(name);
		}
	}

	private ButtonListener bl = new ButtonListener();

	public void init() {
		b1.addActionListener(bl);
		b2.addActionListener(bl);
		b3.addActionListener(bl);
		b4.addActionListener(bl);
		b5.addActionListener(bl);		
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(b1);
		cp.add(b2);
		cp.add(b3);
		cp.add(b4);
		cp.add(b5);
	}

	public static void main(String[] args) {
		run(new Button(), 400, 200);
	}

	public static void run(JApplet applet, int width, int height) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(applet);
		frame.setSize(width, height);
		applet.init();
		applet.start();
		frame.setVisible(true);
	}
}