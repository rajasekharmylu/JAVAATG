package sample.programs;

import junit.framework.TestCase;

public class TestBowlingGame extends TestCase {
	public TestBowlingGame(String name) {
		super(name);
	}

	private BowlingGame bowlingGame;

	public void setUp() {
		bowlingGame = new BowlingGame();
	}

	
	public void testTwoFrames() {
		bowlingGame.addBalls(9);
		bowlingGame.addBalls(1);
		bowlingGame.addBalls(9);
		bowlingGame.addBalls(1);
		assertEquals(29, bowlingGame.getTotalScore());
		
	}
	
	public void testFourFrames() {
		bowlingGame.addBalls(1);
		bowlingGame.addBalls(1);
		bowlingGame.addBalls(1);
		bowlingGame.addBalls(1);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(1);
		bowlingGame.addBalls(1);
		assertEquals(18, bowlingGame.getTotalScore());		
	}

	public void testAllFramesAsStrike() {
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		
		bowlingGame.addBalls(10);
		bowlingGame.addBalls(10);
		
		assertEquals(300, bowlingGame.getTotalScore());
	}

	
}