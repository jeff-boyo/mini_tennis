package minitennis;

import java.awt.Graphics2D;


public class Ball {
	// some variables
	int x_pos = 0;
	int x_vel = 1;
	int y_pos = 0;
	int y_vel = 1;
	int rad, diam;
	private Court court;

	// init method
	public Ball(Court c, int r) {
		this.court = c;
		this.rad = r;
		this.diam = r*2;
	}

	public void move() {
		// about to hit a wall? reverse velocity!
		if ( x_pos+diam+x_vel > court.getWidth())	x_vel = -1;
		if ( x_pos+x_vel < 0 )						x_vel =  1;
		if ( y_pos+diam+y_vel > court.getHeight())	y_vel = -1;
		if ( y_pos+y_vel < 0 )						y_vel =  1;
		
		// bounce off the paddle
		if( this.court.paddleHit() ) 				y_vel = -1;
		
		// go go go!!!
		x_pos = x_pos + x_vel;
		y_pos = y_pos + y_vel;
	}

	public void paint(Graphics2D g) {
		g.fillOval(x_pos, y_pos, diam, diam);
	}

}
