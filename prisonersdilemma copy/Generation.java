package prisonersdilemma;

import java.util.Arrays;

public class Generation {

	private Player[] players;
	private int numPlayers; 
	
	public Generation (Player[] p, int n) {
		this.players = p; 
		this.numPlayers = n; 
	}
	
	public Player[] runGeneration() {

		
		for(int i = 0; i<players.length; i++) {
			Player one = players[i];
			
			for (int j = 0; j< players.length && j !=i; j++) {
				Player two = players[j]; 
				Game g = new Game(); 
				g.setNumRounds(5); // sets the m value
				g.setPlayerOne(one);
				g.setPlayerTwo(two);
				g.playGame();
			}		
		}
		
		//sorted array of players based on score
        Arrays.sort(players, new Sortbyscore()); 
        return players; 
	}
}
