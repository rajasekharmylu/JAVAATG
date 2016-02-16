package org.techm.gamingpoc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author Rajasekhar
 *
 */
public class AbstractGame implements Game {
	final static Logger logger = Logger.getLogger(org.techm.gamingpoc.AbstractGame.class);
	private static final String REGULAR_EXPRESSION = "^.*[0-9].*$";
	private static final String INPUT_NOT_VALID_MESSAGE = "INPUT_NOT_VALI_MESSAGE1";
	private static final String VALID_NUMBERS_MESSAGE = "VALID_NUMBERS_MESSAGE";
	private static final String NOT_NEGATIVE_NUMBERS_MESSAGE = "NOT_NEGATIVE_NUMBERS_MESSAGE";	
	FileInputStream fis = null;
	File file = new File("resources/ResourceBundle.properties");
	ResourceBundle resourceBundle = null;

	@Override
	public void addScoreForEachBall(int score) throws GameException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getScoreForEachFrame(int frame) throws GameException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScoreForEachOver(int over) throws GameException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScoreForBall(int ball) throws GameException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTotalScore() throws GameException{
		// TODO Auto-generated method stub
		return 0;
	}	
	
	/**
	 * This method validates the input provide against REGULAR_EXPRESSION.Input Should contain 
	 * @param score
	 * @throws GameException
	 */
	public void validateInputs(int score) throws GameException{
		Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
		if(!pattern.matcher(String.valueOf(score)).matches()){			
			throw new GameException(getResourceBundle().getString(INPUT_NOT_VALID_MESSAGE));
		}else{
			 if(score > 10)
				 throw new GameException(getResourceBundle().getString(VALID_NUMBERS_MESSAGE));
			 if(score < 0)
				 throw new GameException(getResourceBundle().getString(NOT_NEGATIVE_NUMBERS_MESSAGE));
		}
	}

	@Override
	public void addScoreForEachBall(String score) throws GameException {
		// TODO Auto-generated method stub		
	}	
	
	public ResourceBundle getResourceBundle() {
		if(resourceBundle!=null)
			return resourceBundle;
		try {
			fis = new FileInputStream(file);
			resourceBundle = new PropertyResourceBundle(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return resourceBundle;
	}
}
