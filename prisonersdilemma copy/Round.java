package prisonersdilemma;

public class Round {
	
	private char playerOneMove;
	private char playerTwoMove; 
	private int playerOnePayoff; 
	private int playerTwoPayoff; 
	
	public Round (char pOne, char pTwo){
		this.playerOneMove = pOne; 
		this.playerTwoMove = pTwo; 
	}
	
	
	public int getPlayerOnePayoff() {
		return playerOnePayoff;
	}
	
	public int getPlayerTwoPayoff() {
		return playerTwoPayoff; 
	}
	
	public void play() {
	
		if(playerOneMove == 'c') {
			if(playerTwoMove == 'c') {
				playerOnePayoff = 3; 
				playerTwoPayoff = 3; 
			}
			else {
				playerOnePayoff = 0; 
				playerTwoPayoff = 5; 
			}
		}
		else {
			if(playerTwoMove == 'c') {
				playerOnePayoff = 5; 
				playerTwoPayoff = 0; 
			}
			else {
				playerOnePayoff = 1; 
				playerTwoPayoff = 1;
			}
			
		}
	}

}
