package pkg;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Date_Duration_Calculator extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Date_Duration_Calculator frame = new Date_Duration_Calculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Date_Duration_Calculator() {
		Date date = new Date();
		System.out.println(date);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 383);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Calculate Duration");
		btnNewButton.setFont(new Font("Bookman Old Style", Font.BOLD, 12));
		
		btnNewButton.setBounds(25, 251, 184, 28);
		contentPane.add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(38, 60, 148, 20);
		contentPane.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(363, 60, 148, 20);
		contentPane.add(dateChooser_1);
		
		JLabel lblNewLabel = new JLabel("Start Date");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(38, 35, 78, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("End Date");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(363, 35, 78, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Today");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateChooser.setDate(date);
			}
		});
		btnNewButton_1.setBounds(38, 91, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Today");
		btnNewButton_2.setBounds(363, 91, 89, 23);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dateChooser_1.setDate(date);
				
			}
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				try {
					Date Date_1 = dateChooser.getDate();
					Date Date_2 = dateChooser_1.getDate();
					long diff_milliseconds = Date_2.getTime() - Date_1.getTime();
					
					//no negative time
					if(diff_milliseconds < 0) {
						String message = "Your second date was before your first!";
						JOptionPane.showMessageDialog(new JFrame(), message, "ERROR",
						        JOptionPane.ERROR_MESSAGE);
					}else {
						long diff_seconds = diff_milliseconds / 1000;
						long diff_minutes = diff_seconds / 60;
						long diff_hours = diff_minutes / 60;
						long diff_days = diff_hours / 24;
						System.out.println(diff_hours);
						String infoMessage = "test";
						String titleBar = "It's been too long";
						JOptionPane.showMessageDialog(null, diff_days + " days\n" + diff_hours + " hours\n" + diff_minutes + " minutes\n" + diff_seconds + " seconds", titleBar, JOptionPane.INFORMATION_MESSAGE);
					}
				}catch(NullPointerException npe) {
					JOptionPane.showMessageDialog(new JFrame(), "You didn't enter a date!", "ERROR",
					        JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
				
				
				
			}
		});
	}
}
