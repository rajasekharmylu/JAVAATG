package org.techm.gamingpoc;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * @author Rajasekhar
 *
 */
public class TestGame {	
	
	final static Logger logger = Logger.getLogger(TestGame.class);	
	private static final String SPACE= " ";
	final static Scanner scanner = new Scanner(System.in);		

	public static void main(String[] args) {
		
		try{			    
				Game bowlingGame = new BowlingGame();
				logger.info(bowlingGame.getResourceBundle().getString("PLEASE_ENTER_INPUTS_MESSAGE"));
				String input = scanner.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(input, SPACE);		
				while(tokenizer.hasMoreTokens()){
					bowlingGame.addScoreForEachBall(tokenizer.nextToken());					
				}					
				if(!((BowlingGame)bowlingGame).isFirstThrowInFrame()){
					bowlingGame.addScoreForEachBall(0);
				}	
				logger.info(bowlingGame.getResourceBundle().getString("YOUR_SCORE")+bowlingGame.getTotalScore());				
				scanner.close();
			} catch (GameException e) {			
				logger.error("Error:"+e);
			}
	}
	

}
