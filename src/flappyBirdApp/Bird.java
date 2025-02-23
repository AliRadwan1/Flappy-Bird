package flappyBirdApp;

import java.awt.Image;

public class Bird {
	public int x;// 360 / 8;
	public int y;// = 640 / 2;
	public int width = 34;
	public int height = 24;
	public Image img;

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

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

}
