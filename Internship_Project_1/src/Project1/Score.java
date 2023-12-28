package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Score extends JFrame{
	
	Score(int n) {
		getContentPane().setBackground(new Color(240, 255, 255));
		new JFrame();
		setBounds(250,100,1000,570);
		getContentPane().setLayout(null);
		
		JLabel score = new JLabel();
		score.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/Score.jpg")));
		score.setBounds(0, 0, 500, 531);
		getContentPane().add(score);
		
		JLabel End = new JLabel("QUIZ    ENDED!!");
		End.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		End.setHorizontalAlignment(SwingConstants.CENTER);
		End.setForeground(Color.blue);
		End.setBounds(527, 10, 430, 75);
		getContentPane().add(End);
		
		JLabel qscore = new JLabel("Your final Quiz Score is:-");
		qscore.setForeground(new Color(128, 0, 255));
		qscore.setFont(new Font("Tahoma", Font.PLAIN, 30));
		qscore.setBounds(527, 131, 430, 54);
		getContentPane().add(qscore);
		
		JLabel value = new JLabel(n+"/10");
		value.setHorizontalAlignment(SwingConstants.CENTER);
		value.setFont(new Font("Tahoma", Font.BOLD, 50));
		value.setForeground(new Color(128, 0, 255));
		value.setBounds(676, 239, 157, 61);
		getContentPane().add(value);
		
		JLabel thanks = new JLabel("Thank You for giving the Quiz, "+Login.Name);
		thanks.setForeground(new Color(0, 0, 255));
		thanks.setFont(new Font("Tahoma", Font.PLAIN, 19));
		thanks.setBounds(527, 334, 430, 23);
		getContentPane().add(thanks);
		
		JButton exit = new JButton("Exit");
		exit.setBackground(new Color(0, 0, 255));
		exit.setForeground(new Color(255, 255, 255));
		exit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		exit.setBounds(693, 456, 125, 41);
		getContentPane().add(exit);
		
		JLabel lblNewLabel = new JLabel("Have a Good Day!");
		lblNewLabel.setForeground(new Color(0, 0, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(527, 383, 170, 23);
		getContentPane().add(lblNewLabel);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		setVisible(true);
	}
	public static void main(String[] args) {
		new Score(0);
	}
}
