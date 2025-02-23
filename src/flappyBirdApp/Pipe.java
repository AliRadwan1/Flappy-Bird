package flappyBirdApp;

import java.awt.Image;

public class Pipe {
	private int x;
	private int y;
	private final int width = 64;
	private final int height = 512;
	private Image img;
	private boolean passed = false;

	Pipe(int x, int y, Image img) {
//		super(); 
		this.x = x;
		this.y = y;
		this.img = img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public boolean isPassed() {
		return passed;
	}

	public void setPassed(boolean passed) {
		this.passed = passed;
	}

	public Image getImg() {
		return img;
	}

}