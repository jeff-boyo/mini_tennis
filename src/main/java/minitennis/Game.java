package minitennis;

import javax.swing.*;

public class Game {
	public static void main(String[] args) throws InterruptedException {
		/*TODO make Game extend JFrame if possible?
		    this seems messy the way it is. I tried to make Game
		    extend JFrame and made the code look a lot cleaner in
		    the process, but unfortunately it no longer worked.
		    ideally: 'JFrame frame' -> 'Game game'
		 */
        JFrame frame = new JFrame("Mini Tennis");
		Court court = new Court();
			frame.add(court);
			frame.setSize(500, 800);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Ball ball = new Ball(court, 10);
			court.addBall(ball);
		Paddle paddle = new Paddle(court, 60, 5);
			court.addPaddle(paddle);

		// main game loop
		while (true) {
            //TODO switch to single court.move() method
			ball.move();
			paddle.move();
			court.repaint();
			Thread.sleep(10);
		}
	}
}
