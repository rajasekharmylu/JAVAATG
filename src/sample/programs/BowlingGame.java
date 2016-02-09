package sample.programs;

import java.util.StringTokenizer;
import java.util.regex.Pattern;

/**
 * @author Rajasekhar
 *
 */
public class BowlingGame {	
	
	private int ball = 0;
	private int itsCurrentFrame = 0;
	private int[] knockDownBalls = new int[22];
	private int currentThrow = 0;
	private boolean isItFirstThrowInFrame = true;	
	
	public boolean isFirstThrowInFrame(){
		return isItFirstThrowInFrame;
	}

	
	public void addBalls(int balls){
		knockDownBalls[currentThrow++] = balls; //Add knock down balls to array.Used later for calculating score
		if(isItFirstThrowInFrame){
			if(balls==10)
				itsCurrentFrame = Math.min(10, itsCurrentFrame + 1); //Strike!!.Jump to New Frame						
			else
				isItFirstThrowInFrame = false;					
		}else{
			isItFirstThrowInFrame = true;	
			itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);//Current Frame Completed.Jump to New Frame		
		}				
	}
	
	public int getTotalScore(){
		return scoreForEachFrame(itsCurrentFrame);		
	}
	
	public int scoreForEachFrame(int theFrame) {
		int score = 0;
		for (int i = 0; i < theFrame; i++) {
			if(knockDownBalls[ball]==10){
				ball++;
				score += 10 + (knockDownBalls[ball] + knockDownBalls[ball+1]);
			}else if((knockDownBalls[ball] + knockDownBalls[ball+1])==10){
				ball = ball + 2;
				score += 10 + (knockDownBalls[ball]);
			}else{
				score +=  (knockDownBalls[ball++] + knockDownBalls[ball++]);
			}
		}
		return score;
	}

	public static void main(String[] args) {
		BowlingGame bowlingGame = new BowlingGame();
		String bowlingFrames = "1 1 1 1 10 1 1 2 0";
		//Scanner scanner = new Scanner(System.in);		
		final String SPACE = " ";
		StringTokenizer tokenizer = new StringTokenizer(bowlingFrames, SPACE);		
		while(tokenizer.hasMoreTokens()){
			Pattern pattern = Pattern.compile("^.*[0-9].*$");
			String token = tokenizer.nextToken();	
			if(pattern.matcher(token).matches()){			
				bowlingGame.addBalls(Integer.valueOf(token));	
				continue;
			}
			System.out.println("Pattern not matched...");
			break;			
		}	
		
		if(!bowlingGame.isFirstThrowInFrame()){
			bowlingGame.addBalls(0);
		}	
	
		System.out.println("Score : "+bowlingGame.getTotalScore());
		
	}
	
}
