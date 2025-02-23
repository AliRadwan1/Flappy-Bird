package flappyBirdApp;

import java.awt.Image;

public class Pipe {
	public int x;
	public int y;
	public final int width = 64;
	public final int height = 512;
	public Image img;
	public boolean passed = false;

	Pipe(int x, int y, Image img) {
		super();
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

}