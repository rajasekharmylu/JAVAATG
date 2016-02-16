package org.techm.gamingpoc;

/**
 * @author Rajasekhar
 *
 */
public class GameException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GameException(String message){  
		  super(message);  
	}  
	
	public GameException(String message, Throwable cause) {
        super(message, cause);
    }

}
