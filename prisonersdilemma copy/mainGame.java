package prisonersdilemma;

import java.util.Arrays;

public class mainGame {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Here is the main gameplay");
		
		//create desired number of players
		
		int numPlayers = 100; // n value in homework
		double p = .03; //percentage of players changed each time
		int k = 20; // number of generations
		
		Player[] players = new Player[numPlayers];
		
		for (int i=0; i< players.length; i++) {
			String strat = ""; 
			if(i%4 == 0) {
				strat = "tfort"; 
			}
			else if (i%4 == 1) {
				strat = "g"; 
			}
			else if (i%4 == 2) { 
				strat = "ac"; 
			}
			else {
				strat = "ad"; 
			}
			
			players[i] = new Player(i, strat); 
		}
		
		for(int runs = 0; runs<k; runs++){
			
			Generation G = new Generation(players, numPlayers); 
			Player[] newPlayersArray = G.runGeneration(); 
			
			int tftCounter = 0; 
			int gCounter = 0; 
			int acCounter = 0; 
			int adCounter = 0; 
			
			int tftSum = 0; 
			int gSum = 0; 
			int acSum = 0; 
			int adSum = 0; 
			
			
			for(int i = 0; i<players.length; i++) {
				if(players[i].getStrategy() == "tfort") {
					tftCounter++;
					tftSum += players[i].getScore(); 
				}
				if(players[i].getStrategy() == "g") {
					gCounter++; 
					gSum += players[i].getScore();
				}
				if(players[i].getStrategy() == "ac") {
					acCounter++;
					acSum += players[i].getScore();
				}
				if(players[i].getStrategy() == "ad") {
					adCounter++; 
					adSum += players[i].getScore();
				}
				
			}
			
			double tftPercentage = ((double)tftCounter/(double)numPlayers)*100; 
			double gPercentage = ((double)gCounter/(double)numPlayers)*100; 
			double acPercentage = ((double)acCounter/(double)numPlayers)*100; 
			double adPercentage = ((double)adCounter/(double)numPlayers)*100; 
			
			int totalSum = tftSum+gSum+acSum+adSum;
			
			double tftAverageScore = 0;
			double gAverageScore = 0; 
			double acAverageScore = 0;  
			double adAverageScore = 0; 
			
			if(tftCounter !=0) {
				 tftAverageScore = tftSum/tftCounter; 
			}
			else{
				 tftAverageScore = 0; 
			}
			if(gCounter !=0) {
				 gAverageScore = gSum/gCounter; 
			}
			else{
				 gAverageScore = 0; 
			}
			if(acCounter !=0) {
				 acAverageScore = acSum/acCounter; 
			}
			else{
				 acAverageScore = 0; 
			}
			if(adCounter !=0) {
				 adAverageScore = adSum/adCounter; 
			}
			else{
				 adAverageScore = 0; 
			}
			
			
			int generationNumber = runs +1; 
			
			System.out.println("Percentage of Population for each Player:");
			System.out.println("Gen " + generationNumber + " : T4T:  " + tftPercentage + "% G:  " + gPercentage + "%  AC: " + acPercentage + "%  AD: " + adPercentage + "%");
			
			System.out.println("Sum of Payoff for each type");
			System.out.println("Gen " + generationNumber + " : T4T:  " + tftSum + " G:  " + gSum + "  AC: " + acSum + "  AD: " + adSum + " Total: " + totalSum);
			
			System.out.println("Average of Payoff for each type");
			System.out.println("Gen " + generationNumber + " : T4T:  " + tftAverageScore + " G:  " + gAverageScore + "  AC: " + acAverageScore + "  AD: " + adAverageScore);
	
//			System.out.println("Percentage of Population for each Player:");
//			System.out.println( tftPercentage + " , " + gPercentage + ", " + acPercentage + " ," + adPercentage );
			
//			System.out.println("Sum of Payoff for each type");
//			System.out.println( tftSum + "  " + gSum + " " + acSum + "  " + adSum + "  " + totalSum);
			
//			System.out.println("Average of Payoff for each type");
//			System.out.println(tftAverageScore + "   " + gAverageScore + "  " + acAverageScore + "  " + adAverageScore);
		
// one more change to get this to work
			
			Player[] topPercentPlayers = new Player[(int)(p * numPlayers)];
			
			for(int i = 0; i<topPercentPlayers.length; i++) {
				topPercentPlayers[i] = newPlayersArray[i];
			}
			
			for(int i = (newPlayersArray.length - topPercentPlayers.length); i<newPlayersArray.length; i++) {
				for(int j = 0; j< topPercentPlayers.length; j++){
					newPlayersArray[i] = topPercentPlayers[j]; 	
				}	
			}
		
			players = newPlayersArray; 
			
			
				
		}
		
		
        
        
  
	}

}
