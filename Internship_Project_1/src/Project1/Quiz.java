package Project1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Quiz extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel Question, image, Timer;
	private JRadioButton opt1, opt2, opt3, opt4;
	private static int isAnsGiven = 0, time = 5, count = 0, userScore = 0;
	private JButton Next, Lifeline, Submit;
	private ButtonGroup options;
	
	Questions q = new Questions();
	Timer timer;
	String[] userAnswers = new String[10];
	
	Quiz() {
		setBounds(60,15,1425,800);
		getContentPane().setBackground(new Color(240,255,255));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		image = new JLabel("Image");
		image.setIcon(new ImageIcon(ClassLoader.getSystemResource("Images/Quiz.jpg")));
		image.setFont(new Font("Tahoma", Font.PLAIN, 90));
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setBounds(0, 0, 1415, 410);
		getContentPane().add(image);
		image.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		Timer = new JLabel("Time Left:- 15 seconds");
		Timer.setFont(new Font("Tahoma",Font.BOLD, 30));
		Timer.setBounds(1000,425,400,50);
		Timer.setForeground(new Color(0,0,255));
		getContentPane().add(Timer);
		
		Question = new JLabel();
		Question.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		Question.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Question.setBounds(10, 425, 807, 65);
		getContentPane().add(Question);
		
		opt1 = new JRadioButton();
		opt1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		opt1.setBounds(10, 520, 573, 40);
		getContentPane().add(opt1);
		
		opt2 = new JRadioButton();
		opt2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		opt2.setBounds(10, 570, 573, 40);
		getContentPane().add(opt2);

		opt3 = new JRadioButton();
		opt3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		opt3.setBounds(10, 620, 573, 40);
		getContentPane().add(opt3);
		
		opt4 = new JRadioButton();
		opt4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		opt4.setBounds(10, 670, 573, 40);
		getContentPane().add(opt4);
		
		Next = new JButton("Next");
		Next.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Next.setForeground(new Color(255, 255, 255));
		Next.setBackground(new Color(0, 0, 255));
		Next.setBounds(1000, 520, 200, 50);
		Next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opt1.setEnabled(true);
				opt2.setEnabled(true);
				opt3.setEnabled(true);
				opt4.setEnabled(true);
				isAnsGiven = 1;
				if(options.getSelection() != null) {
					userAnswers[count] = options.getSelection().getActionCommand();
				}else {
					userAnswers[count] = "";
				}
				if(count==8) {
					Next.setEnabled(false);
					Submit.setEnabled(true);
				}
				count++;
				setQuestion(count);
				time = 15;
				timer.start();
			}
		});
		getContentPane().add(Next);
		
		Lifeline = new JButton("50-50");
		Lifeline.setForeground(Color.WHITE);
		Lifeline.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Lifeline.setBackground(Color.BLUE);
		Lifeline.setBounds(1000, 595, 200, 50);
		Lifeline.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(count) {
				case 0:
					opt3.setEnabled(false);
					opt4.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
					
				case 1:
					opt1.setEnabled(false);
					opt3.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
					
				case 2:
					opt3.setEnabled(false);
					opt4.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
				
				case 3:
					opt2.setEnabled(false);
					opt4.setEnabled(false);
					Lifeline.setEnabled(false);
					break;

				case 4:
					opt2.setEnabled(false);
					opt3.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
				
				case 5:
					opt2.setEnabled(false);
					opt3.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
				
				case 6:
					opt1.setEnabled(false);
					opt4.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
					
				case 7:
					opt1.setEnabled(false);
					opt3.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
				case 8:
					opt1.setEnabled(false);
					opt4.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
				case 9:
					opt1.setEnabled(false);
					opt2.setEnabled(false);
					Lifeline.setEnabled(false);
					break;
				}
			}
		});
		getContentPane().add(Lifeline);
		
		Submit = new JButton("Submit");
		Submit.setForeground(Color.WHITE);
		Submit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		Submit.setBackground(Color.BLUE);
		Submit.setBounds(1000, 670, 200, 50);
		getContentPane().add(Submit);
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(count==9) {
					if(options.getSelection() != null) {
						userAnswers[count] = options.getSelection().getActionCommand();
					}else {
						userAnswers[count] = "";
					}
				}
				for(int i=0;i<10;i++) {
					if(userAnswers[i] == q.correctAnswer[i]) {
						userScore++;
					}
				}
				timer.stop();
				new Score(userScore);
				setVisible(false);
			}
		});
		Submit.setEnabled(false);
		
		options = new ButtonGroup();
		options.add(opt1);
		options.add(opt2);
		options.add(opt3);
		options.add(opt4);
		
		timer();
		timer.start();
		
		setVisible(true);
		setQuestion(count);
	}
	public void timer() {
		time = 15;
		timer = new Timer(1000, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Timer.setText("Time Left:- " + time + " seconds");
				time--;
				if(time==-1) {
					Timer.setText("TIME UP");
				}
				else if(time==-2) {
					if(count==8) {
						Next.setEnabled(false);
						Submit.setEnabled(true);
					}else if(count==9) {
						timer.stop();
						for(int i=0;i<10;i++) {
							if(userAnswers[i] == q.correctAnswer[i]) {
								userScore++;
							}
						}
						new Score(userScore);
						setVisible(false);
					}else {
						timer.stop();
						Timer.setText("");
						opt1.setEnabled(true);
						opt2.setEnabled(true);
						opt3.setEnabled(true);
						opt4.setEnabled(true);
						count++;
						setQuestion(count);
						timer();
						timer.start();
					}
				}
			}
		});
	}
	public void setQuestion(int count) {
		Question.setText((count+1)+". "+q.question[count]);
		opt1.setText(q.answers[count][0]);
		opt1.setActionCommand(q.answers[count][0]);
		opt2.setText(q.answers[count][1]);
		opt2.setActionCommand(q.answers[count][1]);
		opt3.setText(q.answers[count][2]);
		opt3.setActionCommand(q.answers[count][2]);
		opt4.setText(q.answers[count][3]);
		opt4.setActionCommand(q.answers[count][3]);
		options.clearSelection();
	}
	public static void main(String[] args) {
		new Quiz();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}