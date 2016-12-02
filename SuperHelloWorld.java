import javax.swing.JOptionPane;

public class SuperHelloWorld {
	public static void main(String[] args) {
		JOptionPane.showMessageDialog(null, "yo dawg, whattupdoe?");

		// JOptionPane.PLAIN_MESSAGE // this is a plain message 
		// JOptionPane.INFORMATION_MESSAGE // this is a info message 
		// JOptionPane.ERROR_MESSAGE // this is a error message 
		// JOptionPane.WARNING_MESSAGE // this is a warning message 
		JOptionPane.showMessageDialog(null, "Messagehere", "Title here", JOptionPane.INFORMATION_MESSAGE); 

		// Ask for input!
		String name = JOptionPane.showInputDialog("put your name here!") ; 

		JOptionPane.showMessageDialog(
			null, 
			"Bro! Your name is " + name + "!!!!!", 
			"WOAAAAHHHH", 
			JOptionPane.WARNING_MESSAGE
		); 
	}
}
