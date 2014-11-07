package minitennis;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Court extends JPanel {
	Ball ball;
	Paddle paddle;
	
	// init method
	public Court() {
		// setup keyListeners
		this.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {}
			@Override
			public void keyReleased(KeyEvent e) {
				paddle.keyReleased(e);
			}	
			@Override
			public void keyPressed(KeyEvent e) {
				paddle.keyPressed(e);
			}	
		});
		setFocusable(true);
	}
	
	public void addBall(Ball b) {
		this.ball = b;
	}
	
	public void addPaddle(Paddle p) {
		this.paddle = p;
	}
	
	public boolean paddleHit() {
        /*TODO make it so ball hits differently on different parts of paddle
            maybe make method return int 0-3 where 0 is no contact
            and 1,2,3 represent left,center,right hits respectively
         */
		boolean collision = false;
		// relevant ball point (center) and rad
		int bc_x = this.ball.x_pos + this.ball.rad;
		int bc_y = this.ball.y_pos + this.ball.rad;
		int bc_r = this.ball.rad;
		// relevant paddle point (top left) and width
		int pp_x = this.paddle.x_pos;
		int pp_y = this.paddle.y_pos;
		int pp_w = this.paddle.width;
		// calculated distance
		double d;
		
		for ( int x=pp_x; x <= pp_x + pp_w; x++ ) {
            // chunky equation for distance between two points
			d = Math.sqrt(Math.pow((bc_x-x), 2) + Math.pow((bc_y-pp_y), 2));
			if (d <= bc_r)
                collision = true;
		}
		
		return collision;
	}

    //TODO add move() method that moves everything 'on the court'

    @Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;

		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		
		ball.paint(g2d);
		paddle.paint(g2d);
	}
	
}
