package game;


import javax.swing.*;
import javax.swing.text.DefaultCaret;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame implements KeyListener{
	
	public static void main(String[] args) {
		new GUI();

	}
	
	
	
	private JTextArea textArea;
	private JTextField input;
	private JPanel panel;
	//private JLabel JLabel;
//	private JTextField room;
	
	public void print(String s) {
		textArea.append(s+"\n\n");
		
	}
	
	
	
	
	
	public GUI() {
		setTitle("Escape Your House");
		setSize(500, 460);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//setLayout(new BorderLayout());
		
		panel= new JPanel();
		
		panel.setLayout(new FlowLayout());
		
	//	JLabel label = new JLabel("What do you want to do?");
		
		

		
		textArea = new JTextArea("Welcome to your beautiful house. You have a party later on today with the cool kids"
				+ "in your class but you misplaced your keys. Your job is to find the keys and make it to the party"
				+ "or else you will be a big LOSER!"
				+ "\n");
		textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
		textArea.setForeground(Color.pink);
		textArea.setRows(20);
		textArea.setColumns(44);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);
		textArea.setBackground(Color.DARK_GRAY);
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		JScrollPane scroll = new JScrollPane(textArea);
		panel.add(scroll);
		
		input = new JTextField(20);
		input.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 15));
		input.addKeyListener(this);
		input.setForeground(Color.DARK_GRAY);
		input.setBackground(Color.pink);
		panel.add(input);
		JLabel label = new JLabel("What do you want to do?");
		panel.add(label);
		add(panel);
		setVisible(true);
		
		
	}




	@Override
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			Game.processCommand(input.getText());
			input.setText("");
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == '\n') {
			if(Game.n != null) {
				Game.processCommand(input.getText());
				//NPC.response(input.getText());
				input.setText("");
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		
	}
	
}
