package org.techm.gamingpoc;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * This is the Test Main Class for Bowling Game.
 * This will scan the user inputs from the console and pass it to Game Engine and Prints the Total Score of the Bowling Game in console
 * @author Rajasekhar Mylu
 *
 */
public class TestGameService {	
	
	final static Logger logger = Logger.getLogger(TestGameService.class);	
	private static final String SPACE= " ";
	private static final String WELCOME_MESSAGE= "WELCOME_MESSAGE";
	private static final String USERNAME_KEY= "userName";
	private static final String ENTER_YOUR_INPUTS= "PLEASE_ENTER_INPUTS_MESSAGE";
	private static final String YOUR_SCORE= "YOUR_SCORE";
	private static final String GAME_TYPE="BOWLING";
	final static Scanner scanner = new Scanner(System.in);		

	public static void main(String[] args) {		
		try{	
				GameService gameService = GameFactory.getGameService(GAME_TYPE);
				logger.info(gameService.getResourceBundle().getString(WELCOME_MESSAGE)+SPACE+((BowlingGameService)gameService).getProperties().getProperty(USERNAME_KEY));
				logger.info(gameService.getResourceBundle().getString(ENTER_YOUR_INPUTS));
				String input = scanner.nextLine();
				StringTokenizer tokenizer = new StringTokenizer(input, SPACE);		
				while(tokenizer.hasMoreTokens()){
					gameService.addScoreForEachBall(tokenizer.nextToken());					
				}					
				if(!((BowlingGameService)gameService).isFirstThrowInFrame()){
					gameService.addScoreForEachBall(0);
				}	
				logger.info(gameService.getResourceBundle().getString(YOUR_SCORE)+gameService.getTotalScore());				
				scanner.close();				
			} catch (GameException e) {			
				logger.error("Error:"+e);
			}
	}
	

}
