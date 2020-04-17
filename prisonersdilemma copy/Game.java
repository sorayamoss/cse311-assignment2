package prisonersdilemma;

public class Game {
	
	private Player playerOne; 
	private Player playerTwo; 
	private int numRounds; 
	
	//set player one for this set of games
	public void setPlayerOne(Player p) {
		this.playerOne = p;
	}
	
	//set player two for this set of games
	public void setPlayerTwo(Player p) {
		this.playerTwo = p;
	}
	
	//set number for rounds in a set of repeated prisoners dilemmas (m)
	public void setNumRounds(int m) {
		this.numRounds = m; 
	}
	
	
	//run game play
	public void playGame() {
		char playerOneMove = playerOne.getFirstMove(); 
		char playerTwoMove = playerTwo.getFirstMove(); 
		
		//start with one round with each players first move
		Round firstRound = new Round(playerOneMove, playerTwoMove); 
		firstRound.play();
		playerOne.addPoints(firstRound.getPlayerOnePayoff());
		playerTwo.addPoints(firstRound.getPlayerTwoPayoff());
		
		//set player one and player two moves if they are always cooperating or always defecting
		if(playerOne.getStrategy() == "ac") {
			playerOneMove = 'c'; 
		}
		if(playerOne.getStrategy() == "ad") {
			playerOneMove = 'd'; 
		}
		
		if(playerTwo.getStrategy() == "ac") {
			playerTwoMove = 'c'; 
		}
		if(playerTwo.getStrategy() == "ad") {
			playerTwoMove = 'd'; 
		}

		//run game for desired amount of rounds
		for(int i = 1; i<numRounds; i++){
			
			//grudger strategy here (because can change each round
			if (playerOne.getStrategy() == "g") {
				if(playerTwo.getHistory().contains("d")) {
					playerOneMove = 'd'; 
				}
				else{
					playerOneMove = 'c'; 
				}
			}
			
			if (playerTwo.getStrategy() == "g") {
				if(playerOne.getHistory().contains("d")) {
					playerTwoMove = 'd'; 
				}
				else{
					playerTwoMove = 'c'; 
				}
			}
			
			//tit for tat strategy here (because can change each round
			if(playerOne.getStrategy() == "tfort") {
				playerOneMove = playerTwo.getLastMove(i-1); 
			}
			
			if(playerTwo.getStrategy() == "tfort") {
				playerTwoMove = playerOne.getLastMove(i-1); 
			}
			
			//at this point the strategy for each player should be set
			playerOne.addMove(playerOneMove);
			playerTwo.addMove(playerTwoMove);
			
			Round round = new Round(playerOneMove, playerTwoMove); 
			round.play();
			
			playerOne.addPoints(round.getPlayerOnePayoff());
			playerTwo.addPoints(round.getPlayerTwoPayoff());
			
			
		}	
	}
}
