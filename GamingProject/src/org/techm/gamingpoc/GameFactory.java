package org.techm.gamingpoc;

public class GameFactory {
		
	//use getGameService method to get object of type GameService 
	   public static GameService getGameService(String gameType){
	      if(gameType == null){
	         return null;
	      }		
	      if(gameType.equalsIgnoreCase("BOWLING")){
	         return new BowlingGameService();
	         
	      } else if(gameType.equalsIgnoreCase("CRICKET")){
	         return new CricketGameService();
	         
	      } else if(gameType.equalsIgnoreCase("FOOTBAL")){
	         return new FootBallGameService();
	      }	      
	      return null;
	   }
}
