package minitennis;

import javax.swing.*;

public class Game {
	public static void main(String[] args) throws InterruptedException {
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
			ball.move();
			paddle.move();
			court.repaint();
			Thread.sleep(10);
		}
	}
}
