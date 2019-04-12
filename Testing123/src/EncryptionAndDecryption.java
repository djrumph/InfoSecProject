import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EncryptionAndDecryption extends JFrame implements ActionListener //Main class
{
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args)
	{
		new EncryptionAndDecryption().setVisible(true);
	}
	private EncryptionAndDecryption() {
		super("Encryption And Decryption");
		
	
		setSize(410,350);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		
		JTextField t1,t2,t3;
		t1 = new JTextField(""); // key
		t1.setBounds(165, 45, 60, 30);
		
		t2 = new JTextField(""); // phrase
		t2.setBounds(50, 110, 300, 30);
		
		JLabel l1 = new JLabel("Enter Key");
		l1.setBounds(167, 20, 200, 30);
		
		JLabel l2 = new JLabel("Enter Phrase");
		l2.setBounds(158, 85, 200, 30);
		
		t3 = new JTextField("");
		t3.setBounds(50, 240, 300, 30);
		
		JButton button = new JButton("Encrypt");
		button.setBounds(110, 180, 80, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String phrase = t2.getText();
				int key = Integer.parseInt(t1.getText());
				t3.setText(encryption(phrase,key));
			}          
	      });
		
		JButton button2 = new JButton("Decrypt");
		button2.setBounds(210, 180, 80, 30);
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String phrase = t2.getText();
				int key = Integer.parseInt(t1.getText());	
				t3.setText(decryption(phrase,key));
			}          
	      });
				
		
		add(l1);
		add(l2);
		add(t1);
		add(t2);
		add(t3);
		add(button);
		add(button2);
	
	}

	String encryption(String phrase, int key)
	{
		int array[] = new int[phrase.length()]; //  set array to size of string
				char temp;//	temp space for characters.
				String answer = "";
				for(int i = 0; i<phrase.length(); i++) //  first loop to take characters from sting and put into array
				{
					
					temp = phrase.charAt(i);				// put each character (one at a time) into temp so it can be cast into a int.
					array[i] = ((int)temp+key-i);			// add key to the new int inside of temp and assign to the index i of array
					
				}
			
				for(int i = 0; i<phrase.length();i++) // second loop to take each number in array and make them letters again.
				{
					temp = (char) array[i]; //  cast the int from array in index i and put into temp spot and print temp each loop giving the simulated encrypted message.
					answer= answer + temp;
				}
		
		return answer;
	}
	String decryption(String phrase, int key) // same as encryption method
	{
		int array[] = new int[phrase.length()]; 
		char temp;								
		String answer = "";
		for(int i = 0; i<phrase.length(); i++) 
		{
			
			temp = phrase.charAt(i);				
			array[i] = ((int)temp-key+i);			
			
		}
	
		for(int i = 0; i<phrase.length();i++) 
		{
			temp = (char) array[i]; 
			answer= answer + temp;
		}
		
		return answer;
	}
@Override
public void actionPerformed(ActionEvent e) {
	
}
	
	
}
Code for project !now with Jframe!.txt
Displaying Code for project !now with Jframe!.txt.
