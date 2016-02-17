package org.techm.gamingpoc;

import java.util.ResourceBundle;

/**
 * This is the Game interface with Abstract methods.
 * @author Rajasekhar Mylu
 *
 */
public interface GameService {

	void addScoreForEachBall(int score) throws GameException;	
	
	void addScoreForEachBall(String score) throws GameException;	
		
	int getScoreForBall(int ball) throws GameException;

	int getTotalScore() throws GameException;
	
	ResourceBundle getResourceBundle();
}
