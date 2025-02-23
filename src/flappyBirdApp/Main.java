package flappyBirdApp;

import javax.swing.*;
import java.awt.*;

public class Main {

	public static void main(String[] args) {
		int boardWidth = 340;
		int boardHeight = 640;
		
		JFrame frame = new JFrame("Flappy Bird");
//		frame.setVisible(true);
		frame.setSize(boardWidth, boardHeight); // sets size
		frame.setLocationRelativeTo(null);
		frame.setResizable(false); // to not make the user able to resize the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		FlappyBird flappyBird = new FlappyBird();
		
		frame.add(flappyBird);
		frame.pack(); // to make the width and height not include the title bar
		flappyBird.requestFocus();
		
		frame.setVisible(true);

	}

}
