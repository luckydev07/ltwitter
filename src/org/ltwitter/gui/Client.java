package org.ltwitter.gui;

import java.awt.*;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;
import winterwell.jtwitter.*;

public class Client implements ActionListener{
	
	Icon img;
	JFrame loginFrame;
	JLabel lblUser,lblPass,lblStatus,lblHeader;
	JTextField txtUser;
	JPasswordField txtPass;
	JTextArea txtStatus;
	JButton btSubmit,btExit;
	JPanel mainPanel, btPanel;
	
	
	public void showForm(){
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Unable to load system look and feel !");
		}
		
		
		//create, configure and show components
		
		loginFrame = new JFrame("LTwitter");
		lblUser = new JLabel("Enter Username");
		lblPass = new JLabel("Enter Password");
		lblStatus = new JLabel("What are you doing now ? ");
		txtUser = new JTextField(20);
		txtPass = new JPasswordField(20);
		
		txtStatus = new JTextArea(10,10);
		txtStatus.setLineWrap(true);
		
		JScrollPane scroller = new JScrollPane(txtStatus);
		scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		btSubmit = new JButton("Submit");
		btSubmit.addActionListener(this);
		btExit = new JButton("Exit");
		btSubmit.addActionListener(this);
		
		img = new ImageIcon("images/LTwitter2.jpg");
		lblHeader = new JLabel(img);
		
		
		//creating panels and adding the above components in suitable manner
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.add(lblUser);
		mainPanel.add(txtUser);
		mainPanel.add(lblPass);
		mainPanel.add(txtPass);
		mainPanel.add(lblStatus);
		mainPanel.add(scroller);
		
		btPanel = new JPanel();
		btPanel.add(btSubmit);
		
		loginFrame.setLayout(new FlowLayout());
		loginFrame.getContentPane().add(lblHeader);
		loginFrame.getContentPane().add(mainPanel);
		loginFrame.getContentPane().add(btPanel);
		
		
		
		
		//centering the frame on the screen
		loginFrame.setSize(300,400);
		Dimension dw = Toolkit.getDefaultToolkit().getScreenSize();
		int wx = loginFrame.getSize().width;
		int wy = loginFrame.getSize().height;
		int x = (dw.width-wx)/2;
		int y = (dw.height-wy)/2;
		loginFrame.setLocation(x, y);
		
		
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ev){
		
		//twitter
		//setting the status of user
		
			
			String user = txtUser.getText();
			char[] pass = txtPass.getPassword();
			
			String password = "";
			
			for (int i=0;i<pass.length;i++)
				password = password+pass[i];
			
			
			try{
				Twitter twitter = new Twitter(user,password);
				twitter.setStatus(txtStatus.getText());
				
				JOptionPane.showMessageDialog(null, "Success");
				
				
				
				
			}catch(TwitterException e){
				
				JOptionPane.showMessageDialog(null, "Some Twitter Error");
			}catch(Exception e){
				
				JOptionPane.showMessageDialog(null, "Some General Error has Occurred.\n" +
						" If you see this after Success Message..Ignore");
			}
			
				txtStatus.setText("");
				
				txtStatus.requestFocus();
		
		
		
		
		
	}
}
