import javax.swing.*;
public class GUIComponents {

	public static void main(String[] args) {
		// JButton jbtOK = new JButton("OK");
		// JButton jbtCancel = new JButton("Cancel");
		
		JLabel labelAdj = new JLabel("ADJECTIVE")
		JTextField textAdj = new JTextField("smelly");

		JLabel labelNoun = new JLabel("NOUN");
		JTextField textNoun = new JTextField("poop");

		JLabel labelAnimal = new JLabel("ANIMAL");
		JTextField textAnimal = new JTextField("kitty-cat");

		JLabel labelNoise = new JLabel("NOISE");
		JTextField textNoise = new JTextField("screeeeech");


		JButton btn = new JButton("HERE WE GO!!!")
		JTextField result = new JTextField("Wait for it...");

		// Create Panel

		// Set that magical thing to make it all one line

		// Add items to panel

		// Add action listener

		btn.addActionListener(new ActionListener() {
			String adj = textAdj.getText();
			String nou = textNoun.getText();
			String ani = textAnimal.getText();
			String noi = textNoise.getText();

            @Override
            public void actionPerformed(ActionEvent e) {
                 result.setText(
					"AJDC Macdonald had a " + adj + ", E-I-E-I-O\n" + 
					"and on that " + nou + " he had a " + ani + ", E-I-E-I-O\n" +
                );
				// with a NOUN NOUN here
				// and a NOUN NOUN there,
				// here a NOUN, there a NOUN,
				// everywhere a NOUN NOUN,
				// AJDC Macdonald had a NOUN, E-I-E-I-O.	
            }
        });

		


		

			)
		
		JPanel panel = new JPanel();
		panel.add(labelAdj);
		panel.add(textAdj);
		panel.add(labelNoun);
		panel.add(textNoun);
		panel.add(labelAnimal);
		panel.add(textAnimal);
		panel.add(labelNoise);
		panel.add(textNoise);
		
		JFrame frame = new JFrame();
		frame.add(panel);
		frame.setTitle("Show GUI components");
		frame.setSize(450, 100);
		frame.setLocation(200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
