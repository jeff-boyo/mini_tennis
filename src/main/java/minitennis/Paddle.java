package minitennis;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Paddle {
    //TODO add constant for paddle speed [x_vel = +/-1 * PADDLE_SPEED]
    //TODO add constant for paddle height [currently hardcoded to 4/5]
	int x_pos, x_vel, y_pos;
	int width, height;
	private Court court;

	// init method
	public Paddle(Court c, int w, int h) {
		this.court = c;
		this.width = w;
		this.height = h;
		// center paddle in bottom 1/5th of court
		this.x_pos = c.getWidth()/2 - w/2;
		this.y_pos = c.getHeight() * 4/5;
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			x_vel = -3;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			x_vel = 3;
	}
	
	public void keyReleased(KeyEvent e) {
		x_vel = 0;
	}
	
	public void move() {
		if (x_pos+x_vel > 0 && x_pos+width+x_vel < court.getWidth())
			x_pos = x_pos + x_vel;
		
		// reset vertical position to bottom 1/5th of screen
		// (in case window size has changed)
		y_pos = court.getHeight() * 4/5;
	}

	public void paint(Graphics2D g) {
		g.fillRoundRect(x_pos, y_pos, width, height, height/2, height/2);
	}
}
