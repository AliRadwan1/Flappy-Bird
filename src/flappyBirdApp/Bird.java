package flappyBirdApp;

import java.awt.Image;

public class Bird {
	private int x;// 360 / 8;
	private int y;// = 640 / 2;
	private final int width = 34;
	private final int height = 24;
	private Image img;

	Bird(Image img, int x, int y) {
		this.img = img;
		this.x = x;
		this.y = y;
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

	public Image getImg() {
		return img;
	}

}
