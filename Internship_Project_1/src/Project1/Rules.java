package Project1;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Rules extends JFrame{
	private JButton Start;
	private JLabel Label, Label1;
	private JCheckBox Confirm;
	private String name;
	
	protected Rules(String n) {
		getContentPane().setBackground(new Color(240, 255, 255));
		this.name = n;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400,100,676,665);
		getContentPane().setLayout(null);
		setVisible(true);
		
		Label = new JLabel("Hello " + name + ". Welcome to the 'Quiz Masters' Quiz");
		Label.setBackground(new Color(255, 255, 255));
		Label.setForeground(new Color(0, 128, 255));
		Label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Label.setBounds(10, 0, 595, 61);
		getContentPane().add(Label);
		
		Label1 = new JLabel();
		Label1.setBackground(new Color(255, 255, 255));
		Label1.setForeground(new Color(128, 0, 255));
		Label1.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		Label1.setText(
			"<html>" + 
				"These are some of the rules that you need to follow before attempting the quiz:-" + 
				"<br><br>" + 
				"1. This Quiz will have 10 Questions, all Multiple-Choice with 4 options." + 
				"<br><br>" + 
				"2. You will have 15 seconds to attempt each question." + 
				"<br><br>" + 
				"3. Once you have selected your answer, you can click the Next Button to answer the next question." + 
				"<br><br>" + 
				"4. Once the timer runs out or the next button is clicked, the next question will appear and you won't be able to go back to the previous question." + 
				"<br><br>" + 
				"5. The Submit button will be disabled until the last question appears. After you have answered the last question, you can submit your quiz and check your score." + 
				"<br><br>" + 
				"6. For a correct answer, you will get 1 point. If the timer runs out and you haven't answered the question or the answer is incorrect, then you will get 0 points for the question." + 
				"<br><br>" + 
				"GOOD LUCK." + 
				"<html>"
		);
		Label1.setBounds(10, 58, 655, 454);
		getContentPane().add(Label1);
		
		Confirm = new JCheckBox("I accept all the rules and I am ready to play the quiz");
		Confirm.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == 1) {
					Start.setBackground(Color.BLUE);
					Start.setForeground(Color.WHITE);
					Start.setEnabled(true);
				}
				else {
					Start.setBackground(Color.white);
					Start.setForeground(Color.black);
					Start.setEnabled(false);
				}
			}
		});
		Confirm.setBackground(new Color(255, 255, 255));
		Confirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Confirm.setBounds(10, 527, 589, 39);
		getContentPane().add(Confirm);
		
		Start = new JButton("Start");
		Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Quiz();
				setVisible(false);
			}
		});
		Start.setForeground(new Color(0, 0, 0));
		Start.setBackground(new Color(255, 255, 255));
		Start.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Start.setBounds(223, 572, 155, 46);
		getContentPane().add(Start);
		Start.setEnabled(false);
		
	}
	public static void main(String[] args) {
		new Rules("User");
	}
}