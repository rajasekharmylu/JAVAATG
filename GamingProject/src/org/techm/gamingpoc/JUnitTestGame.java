package org.techm.gamingpoc;

import junit.framework.TestCase;

/**
 * @author Rajasekhar Mylu
 *
 */
public class JUnitTestGame extends TestCase {
	public JUnitTestGame(String name) {
		super(name);
	}

	private BowlingGameService bowlingGame;

	public void setUp() {
		bowlingGame = new BowlingGameService();
	}

	
	public void testTwoFrames() {
		try {
			bowlingGame.addScoreForEachBall(9);
			bowlingGame.addScoreForEachBall(1);
			bowlingGame.addScoreForEachBall(9);
			bowlingGame.addScoreForEachBall(1);			
			assertEquals(29, bowlingGame.getTotalScore());
		} catch (GameException e) {			
			e.printStackTrace();
		}
	}
	
	public void testFourFrames() {
	
		try {
			bowlingGame.addScoreForEachBall(1);
			bowlingGame.addScoreForEachBall(1);
			bowlingGame.addScoreForEachBall(1);
			bowlingGame.addScoreForEachBall(1);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(1);
			bowlingGame.addScoreForEachBall(2);
			assertEquals(20, bowlingGame.getTotalScore());		
		} catch (GameException e) {			
			e.printStackTrace();
		}		
	}

	public void testAllFramesAsStrike() {
		try {
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			
			bowlingGame.addScoreForEachBall(10);
			bowlingGame.addScoreForEachBall(10);
			assertEquals(300, bowlingGame.getTotalScore());
		} catch (GameException e) {			
			e.printStackTrace();
		}
	}

	
}