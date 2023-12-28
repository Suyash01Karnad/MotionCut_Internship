package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {
	
	private JLabel Label, Label1, Label2;
	private JButton Play, Exit;
	private JTextField T1;
	static String Name;
	
	private Login() {
		getContentPane().setBackground(new Color(240, 255, 255));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(250,150,1000,500);
		
		Label = new JLabel("This is a Label");
		Label.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/Login.jpg")));
		Label.setBackground(new Color(255, 255, 255));
		Label.setHorizontalAlignment(SwingConstants.CENTER);
		Label.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Label.setBounds(0, 0, 480, 460);
		getContentPane().add(Label);
		
		Label1 = new JLabel("QUIZ     MASTERS");
		Label1.setForeground(new Color(128, 0, 255));
		Label1.setBackground(new Color(240, 240, 240));
		Label1.setFont(new Font("PMingLiU-ExtB", Font.BOLD, 40));
		Label1.setHorizontalAlignment(SwingConstants.CENTER);
		Label1.setBounds(530, 10, 400, 82);
		getContentPane().add(Label1);
		
		T1 = new JTextField();
		T1.setHorizontalAlignment(SwingConstants.LEADING);
		T1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		T1.setBounds(530, 211, 400, 53);
		getContentPane().add(T1);
		T1.setColumns(10);
		
		Label2 = new JLabel("Enter Your Username");
		Label2.setForeground(new Color(0, 128, 255));
		Label2.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
		Label2.setHorizontalAlignment(SwingConstants.CENTER);
		Label2.setBounds(530, 148, 400, 53);
		getContentPane().add(Label2);
		
		Play = new JButton("Play");
		Play.setForeground(new Color(255, 255, 255));
		Play.setBackground(new Color(0, 0, 255));
		Play.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Play.setBounds(530, 342, 171, 46);
		getContentPane().add(Play);
		Play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Name = T1.getText();
				setVisible(false);
				new Rules(Name);
			}
		});
		
		Exit = new JButton("Exit");
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		Exit.setForeground(new Color(255, 255, 255));
		Exit.setBackground(new Color(0, 0, 255));
		Exit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Exit.setBounds(759, 342, 171, 46);
		getContentPane().add(Exit);
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Login();
	}
}
