package org.techm.gamingpoc;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

/**
 * @author Rajasekhar Mylu
 * 
 * This is the Abstract Class. It overrides the methods from the Game with empty body.
 * The Corresponding Game Class will extend this Abstract Class and implement their own logic.
 *
 */
public class AbstractGameService implements GameService {
	final static Logger logger = Logger.getLogger(org.techm.gamingpoc.AbstractGameService.class);
	private static final String REGULAR_EXPRESSION = "^.*[0-9].*$";
	private static final String INPUT_NOT_VALID_MESSAGE = "INPUT_NOT_VALI_MESSAGE1";
	private static final String VALID_NUMBERS_MESSAGE = "VALID_NUMBERS_MESSAGE";
	private static final String NOT_NEGATIVE_NUMBERS_MESSAGE = "NOT_NEGATIVE_NUMBERS_MESSAGE";	
	private static final String BASIC_RESOURCE_BUNDLE = "ResourceBundle";	
	private static final String CONFIG_PATH = "resources/Config.properties";
	
	Properties  properties =null;
	ResourceBundle resourceBundle = null;	
	Locale locale = null;

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
	
	/**
	 * This method returns the Resource Bundle based on locale set in the Config.properties
	 * @return ResourceBundle
	 */
	@Override
	public ResourceBundle getResourceBundle() {
		if(resourceBundle==null)				
			 resourceBundle = ResourceBundle.getBundle(BASIC_RESOURCE_BUNDLE,getLocale());
		return resourceBundle;
	}	

	/**
	 * This method loads the properties file
	 * @return Properties
	 */	
	protected Properties getProperties() { 
		if(properties!=null)
			return properties;
		InputStream input = null;
		File file = null;		
		try {
			properties = new Properties();
			file = new File(CONFIG_PATH);
			input = new FileInputStream(file);			
			properties.load(input);			
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
					file = null;					
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return properties;
	}	
	
	/**
	 * This method gets Locale
	 * @return Locale
	 */
	protected Locale getLocale() {			
		locale =  new Locale((String)getProperties().get("locale"));
		return locale;
	}
}
