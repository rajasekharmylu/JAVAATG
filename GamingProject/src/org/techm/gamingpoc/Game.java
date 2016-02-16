package org.techm.gamingpoc;

import java.util.ResourceBundle;

/**
 * This is the Game interface with Abstract methods.
 * @author Rajasekhar Mylu
 *
 */
public interface Game {

	void addScoreForEachBall(int score) throws GameException;	
	
	void addScoreForEachBall(String score) throws GameException;	
	
	int getScoreForEachFrame(int frame) throws GameException;

	int getScoreForEachOver(int over) throws GameException;

	int getScoreForBall(int ball) throws GameException;

	int getTotalScore() throws GameException;
	
	ResourceBundle getResourceBundle();
}
