package flappyBirdApp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
	int boardWidth = 360;
	int boardHeight = 640;

	// Images
	Image backgroundImg;
	Image birdImg;
	Image topPipeImg;
	Image bottomPipeImg;

	// Bird
	int birdX = boardWidth / 8;
	int birdY = boardHeight / 2;
	int birdWidth = 34;
//	int birdHeight = 24;
//
//	class Bird {
//		int x = birdX;
//		int y = birdY;
//		int width = birdWidth;
//		int height = birdHeight;
//		Image img;
//
//		Bird(Image img) {
//			this.img = img;
//		}
//	}

	// pipe
	int pipeX = boardWidth;
	int pipeY = 0;
	int pipeWidth = 64;
	int pipeHeight = 512;
//
//	class Pipe {
//		int x = pipeX;
//		int y = pipeY;
//		int width = pipeWidth;
//		int height = pipeHeight;
//		Image img;
//		boolean passed = false;
//
//		Pipe(Image img) {
//			this.img = img;
//		}
//	}

	// game logic

	Bird bird;
	int velocityX = -4; // move the pipes to the left speed
	int velocityY = 0; // move bird up/down
	int gravity = 1;

	ArrayList<Pipe> pipes;
	Random random = new Random();

	Timer PlacePipesTimer;
	Timer gameloop;
	boolean gameOver = false;
	double score = 0;

	public FlappyBird() {
		setPreferredSize(new Dimension(boardWidth, boardHeight));
//		setBackground(Color.blue);

		setFocusable(true);
		addKeyListener(this);

		// load Images
//		System.out.println(getClass().getResource("flappybirdbg.png"));
		backgroundImg = new ImageIcon(getClass().getResource("/Image/flappybirdbg.png")).getImage();
		birdImg = new ImageIcon(getClass().getResource("/Image/flappybird.png")).getImage();
		topPipeImg = new ImageIcon(getClass().getResource("/Image/toppipe.png")).getImage();
		bottomPipeImg = new ImageIcon(getClass().getResource("/Image/bottompipe.png")).getImage();

		bird = new Bird(birdImg, birdX, birdY);
		pipes = new ArrayList<Pipe>();

		// place pipes timer
		PlacePipesTimer = new Timer(1500, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				placePipe();

			}
		});
		PlacePipesTimer.start();

		// gameloop timer
		gameloop = new Timer(1000 / 60, this); // 1000/16 = 16.6
		gameloop.start();

	}

	public void placePipe() {
		int randomPipeY = (int) (pipeY - pipeHeight / 4 - Math.random() * (pipeHeight / 2));
		int openingSpace = boardHeight / 4;

		Pipe topPipe = new Pipe(pipeX, pipeY, topPipeImg);
		topPipe.y = randomPipeY;
		pipes.add(topPipe);

		Pipe bottomPipe = new Pipe(pipeX, pipeY, bottomPipeImg);
		bottomPipe.y = topPipe.y + pipeHeight + openingSpace;
		pipes.add(bottomPipe);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	public void draw(Graphics g) {
		// background
		g.drawImage(backgroundImg, 0, 0, boardWidth, boardHeight, null);

		// bird
		g.drawImage(bird.img, bird.x, bird.y, bird.width, bird.height, null);

		// pipes
		for (int i = 0; i < pipes.size(); i++) {
			Pipe pipe = pipes.get(i);
			g.drawImage(pipe.img, pipe.x, pipe.y, pipe.width, pipe.height, null);
		}

		// score
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		if (gameOver) {
			g.drawString("Game Over: " + String.valueOf((int) score), 10, 35);
		} else {
			g.drawString(String.valueOf((int) score), 10, 35);
		}
	}

	public void move() {
		// bird
		velocityY += gravity;
		bird.y += velocityY;
		bird.y = Math.max(bird.y, 0);

		// pipe
		for (int i = 0; i < pipes.size(); i++) {
			Pipe pipe = pipes.get(i);
			pipe.x += velocityX;

			if (!pipe.passed && bird.x > pipe.x + pipe.width) {
				pipe.passed = true;
				score += 0.5; // 0.5 because there are 2 pipes! so 0.5*2 = 1, 1 for each set of pipes
			}

			if (collision(bird, pipe)) {
				gameOver = true;
			}
		}

		if (bird.y > boardHeight) {
			gameOver = true;
		}
	}

	boolean collision(Bird a, Pipe b) {
		return a.x < b.x + b.width && // a's top left corner doesn't reach b's top right corner
				a.x + a.width > b.x && // a's top right corner passes b's top left corner
				a.y < b.y + b.height && // a's top left corner doesn't reach b's bottom left corner
				a.y + a.height > b.y; // a's bottom left corner passes b's top left corner
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		move();
		repaint();

		if (gameOver) {
			PlacePipesTimer.stop();
			gameloop.stop();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			velocityY = -9;

			if (gameOver) {
				// restarting the game by resetting the conditions
				// restart game by resetting conditions
				bird.y = birdY;
				velocityY = 0;
				pipes.clear();
				gameOver = false;
				score = 0;
				gameloop.start();
				PlacePipesTimer.start();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
