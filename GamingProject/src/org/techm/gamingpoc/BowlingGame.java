package org.techm.gamingpoc;

import java.io.Serializable;

import org.apache.log4j.Logger;


/**
 * * @author Rajasekhar Mylu
 * 
 * This Program takes a string of space separated numbers from 0 to 10 and calculates what that would be as a score in ten pin bowling.
 *
 */
public class BowlingGame extends AbstractGame implements Serializable{	
	
	private static final long serialVersionUID = 1L;	
	private static final String INPUT_NOT_VALI_MESSAGE2 = "INPUT_NOT_VALI_MESSAGE2";	
	final static Logger logger = Logger.getLogger(org.techm.gamingpoc.BowlingGame.class);
	private int ball = 0;
	private int currentFrame = 0;
	private int[] knockDownBalls = new int[22];
	private int currentThrow = 0;
	private boolean firstThrowInFrame = true;
	private final int FRAME_MAX_SCORE = 10;
	private final int MAX_VALUE = 10;		
	

	/**
	 * This method validates the inputs given and adds the Balls Scored for each throw to a Score Board (Array). 
	 *  	 
	 **/
	@Override
	public void addScoreForEachBall(final String score) throws GameException {
		validateInputs(score);
		addScoreForEachBall(Integer.valueOf(score));
	}
	
	/**
	 * This method validates the inputs given and adds the Balls Scored for each throw to a Score Board (Array).
	 **/
	@Override
	public void addScoreForEachBall(final int score) throws GameException {		
		validateInputs(score);
		knockDownBalls[currentThrow++] = score; //Add knock down balls to array.Used later for calculating final score
		if(isFirstThrowInFrame()){
			if(score==FRAME_MAX_SCORE)
				setCurrentFrame(Math.min(MAX_VALUE, getCurrentFrame() + 1)); //WOW!.Its Strike!!.Hence Current Frame Completed.Jump to New Frame						
			else
				setFirstThrowInFrame(false);					
		}else{
			setFirstThrowInFrame(true);	
			setCurrentFrame(Math.min(MAX_VALUE, getCurrentFrame() + 1));//Current Frame Completed.Jump to New Frame		
		}		
	}	

	/**
	 * This method calculates the Balls thrown for each given frame and then returns the score.
	 * It checks no.of balls thrown in each frame ball by ball.
	 * If the First Ball of the Frame is Strike, then score = FRAME[BALL1] + Score for Next Two Throws. 
	 * If the Balls thrown in the frame is Spare, then score = FRAME[BALL1 + BALL2] + Score for Next Ball Throw. 
	 * If the Balls thrown in the frame is Not Spare nor Strike, then score = FRAME[BALL1 + BALL2]. 
	 * @return score
	 * @throws GameException 
	 */
	@Override
	public int getScoreForEachFrame(final int frame) throws GameException {
		validateInputs(frame);
		int score = 0;
		for (int i = 0; i < frame; i++) {
			if(isStrikeInFrame()){
				ball++;
				score += FRAME_MAX_SCORE + getScoreForBall(ball) + getScoreForBall(ball+1);
			}else if(isSpareInFrame()){
				ball = ball + 2;
				score += FRAME_MAX_SCORE + getScoreForBall(ball);
			}else{				
				score +=  (knockDownBalls[ball++] + knockDownBalls[ball++]);//Getting the Score for Current Ball and Increasing the Ball for Frame 
			}
		}
		return score;
	}
	
	
	/**
	 * This method validates the input provided against REGULAR_EXPRESSION.Input Should contain 
	 * @param score
	 * @throws GameException
	 */
	private void validateInputs(String score) throws GameException{		
		try {
			validateInputs(Integer.valueOf(score));
		} catch (NumberFormatException e) {					
			throw new GameException(getResourceBundle().getString(INPUT_NOT_VALI_MESSAGE2));
		}
	
	}	
	

	/**
	 * @param firstThrowInFrame
	 */
	private void setFirstThrowInFrame(boolean firstThrowInFrame) {
		this.firstThrowInFrame = firstThrowInFrame;
	}	
	
	/**
	 * @return
	 */
	public boolean isFirstThrowInFrame(){
		return firstThrowInFrame;
	}

	/**
	 * @return
	 */
	private int getCurrentFrame() {
		return currentFrame;
	}

	/**
	 * @param currentFrame
	 */
	private void setCurrentFrame(int currentFrame) {
		this.currentFrame = currentFrame;
	}
	
	@Override
	public int getTotalScore() throws GameException {
		return getScoreForEachFrame(getCurrentFrame());			
	}
	
	@Override
	public int getScoreForBall(final int ball) {		
		return knockDownBalls[ball];
	}
	
	/**
	 * This method checks for Spare in Frame. If yes returns TRUE. Otherwise FALSE; 
	 * @return true/false;
	 */
	private boolean isSpareInFrame(){
		return (knockDownBalls[ball] + knockDownBalls[ball+1]) == FRAME_MAX_SCORE;
	}	
	
	/**
	 * This method checks for Strike in Frame. If yes returns TRUE. Otherwise FALSE; 
	 * @return true/false;
	 */
	private boolean isStrikeInFrame(){
		return (knockDownBalls[ball]) == FRAME_MAX_SCORE;
	}	
	
}
