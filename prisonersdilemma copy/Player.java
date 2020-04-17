package prisonersdilemma;

import java.util.Comparator;

public class Player {
	
	private int playerID; //way to identify player 
	private String strategy; //t4t, g, ac, ad
	private int score = 0; //current cumulative payoff for that player
	private String history = ""; //history of moves made (string aka array of chars)
	private char firstMove; 
	

	public Player(int i, String s){ 
		this.playerID = i; 
		this.strategy = s; 
		if(s == "tfort") {
			this.firstMove = 'c';
		}
		if(s == "g"){
			this.firstMove = 'c';
		}
		if(s == "ac") {
			this.firstMove = 'c';
		}
		if(s == "ad") {
			this.firstMove = 'd';
		}
		this.history += this.firstMove; 
 
	}
	
	public void addPoints(int n) {
		this.score+= n; 
	}
	
	public void addMove(char c) {
		this.history += c;
	}
	
	public char getLastMove(int n) {
		return history.charAt(n);  
	}
	
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	public String getStrategy() {
		return strategy;
	}
	public void setStrategy(String strategy) {
		this.strategy = strategy;
		
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getHistory() {
		return history;
	}
	public void setHistory(String history) {
		this.history = history;
	}
	public char getFirstMove() {
		return firstMove;
	}

	public void setFirstMove(char firstMove) {
		this.firstMove = firstMove;
	}
	

	

}

class Sortbyscore implements Comparator<Player> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(Player a, Player b) 
    { 
        return b.getScore() - a.getScore(); 
    } 
} 



