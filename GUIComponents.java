import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
public class GUIComponents 
{

	public static void main(String[] args) 
	{
		// JButton jbtOK = new JButton("OK");
		// JButton jbtCancel = new JButton("Cancel");
		
		JLabel labelAdj = new JLabel("ADJECTIVE");
		JTextField textAdj = new JTextField("smelly");

		JLabel labelNoun = new JLabel("NOUN");
		JTextField textNoun = new JTextField("poop");

		JLabel labelAnimal = new JLabel("ANIMAL");
		JTextField textAnimal = new JTextField("kitty-cat");

		JLabel labelNoise = new JLabel("NOISE");
		JTextField textNoise = new JTextField("screeeeech");


		JButton btn = new JButton("HERE WE GO!!!");
		JTextArea result = new JTextArea("Wait for it...");

		// Create Panel

		JPanel panel = new JPanel();
		// Set that magical thing to make it all one line
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		// Add items to panel
		panel.add(labelAdj);
		panel.add(textAdj);
		panel.add(labelNoun);
		panel.add(textNoun);
		panel.add(labelAnimal);
		panel.add(textAnimal);
		panel.add(labelNoise);
		panel.add(textNoise);
		panel.add(btn);
		panel.add(result);

		//Add JFrame
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setTitle("Show GUI components");
		frame.setSize(450, 1000);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

				// Add action listener
				btn.addActionListener(new ActionListener()
		{

            @Override
            public void actionPerformed(ActionEvent e) 
            {
            	String adj = textAdj.getText();
				String nou = textNoun.getText();
				String ani = textAnimal.getText();
				String noi = textNoise.getText();
                 result.setText(
					adj + " Macdonald had a " + nou + ", E-I-E-I-O\n" + 
					"and in that " + nou + " he had a " + ani + ", E-I-E-I-O\n" +
	               	"with a "+ noi + " " + noi +" here\n" +
					"and a " + noi + " " + noi + " there,\n" +
					"here a " + noi + ", there a " +  noi + ",\n" +
					"everywhere a " + noi + " " +  noi + ",\n" +
					adj + "Macdonald had a " + nou + ", E-I-E-I-O.");
				
        	}
		});

		
	}

}
