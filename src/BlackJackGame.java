import java.util.ArrayList;
import java.util.Scanner;

public class BlackJackGame {
	
	static ArrayList<Player> players;
	private Player dealer;
	private Deck deck;
	private int numPlayers;
	private boolean active;
	private Scanner sc;
	
	public BlackJackGame() {
		players = new ArrayList<>();
		dealer = new Player(true);
		deck = new Deck();
		numPlayers = 0;
		active = true;
		sc = new Scanner(System.in);
	}
	
	//Start sends a message to user and calls methods to run the game
	public void start() {
		System.out.println("Welcome to BlackJack!");
		//Account for players
		System.out.println("How many players will be dealt in?");
		numPlayers = sc.nextInt();

		for (int i = 0; i < numPlayers; i++) {
			Player p = new Player(false);
			players.add(p);
		}
		
		//Add dealer to end of player list
		players.add(dealer);

		//Game runs through a while loop
		while (active) {
			System.out.println("Dealer is dealing...  ");

			//Hands are distributed and hit or stand takes place as well as the dealers
			deal();

			//Finds and displays results of round
			findResults();

			//Quit program
			System.out.println("Next round is about to begin...");
			System.out.println("To quit, press 0. To keep playing, press anything else:   ");
			if (sc.next() != "0")
				active = false;
		}
	}
	
	//Deals the 
	private void deal() {
		for(int i = 0; i<2; i++) {
			//deal two cards to each player
			for(int j = 0; j<(numPlayers +1); j++) {
				players.get(i).hit(deck.draw());
			}
		}
		displayTable(false);
		// stand or hit segment
		for (int i = 0; i < numPlayers; i++) {
			if (players.get(i).getStand())
				continue;
			System.out.println("Will player " + (i + 1) + " hit or stand? ");
			System.out.println("Enter h or s: ");
			// hit
			if (sc.nextLine().equals("h")) {
				players.get(i).hit(deck.draw());
				players.get(i).displayCards(false);
				i--;
				sc.nextLine();
				continue;
			}
			// stand
			else if (sc.nextLine().equals("s")) {
				players.get(i).setStand(true);
				System.out.println("Player " + (i + 1) + "has: " + players.get(i).calcHandTotal());
				sc.nextLine();
				continue;
			}

		}
		// automate dealer decision with BJ rules
		System.out.println("Its the dealers turn!: ");
		dealer.displayCards(true);
		while (dealer.calcHandTotal() < 17) {
			dealer.hit(deck.draw());
			System.out.println("Dealer hits...");
			dealer.displayCards(true);
		}
	}//END of deal method

	//Display players hands
	private void displayTable(boolean b) {
		for (int i = 0; i < numPlayers; i++) {
			int j = i + 1;
			System.out.println("Player " + j + "'s hand: ");
			players.get(i).displayCards(false);
		}
		// handle dealer
		System.out.println();
		System.out.println();
		System.out.println("Dealers hand: ");
		dealer.displayCards(b);
		
	}//END of displayTable method

	private void findResults() {
		System.out.println("/////////////////////////////////////////");
		System.out.println("This rounds over, Lets see what happened: ");
		System.out.println("/////////////////////////////////////////");
		displayTable(true);
		for (int i = 0; i < numPlayers; i++) {
			// dealer beats
			if (players.get(i).calcHandTotal() > dealer.calcHandTotal() && players.get(i).calcHandTotal() < 22) {
				players.get(i).addWins();
				System.out.println("Player " + (i + 1) + "(" + players.get(i).getWins() + " win(s)) beat the dealer");

			}
			// tie
			if (players.get(i).calcHandTotal() == dealer.calcHandTotal() && players.get(i).calcHandTotal() < 22) {
				players.get(i).addWins();
				System.out.println("Player " + (i + 1) + "(" + players.get(i).getWins() + " win(s)) tied the dealer");

			}
			// beats dealer
			else {
				System.out.println("The dealer beat player " + (i + 1) + "(" + players.get(i).getWins() + " wins(s))");
			}
		}	
	}//END of findResults method
	
	
}//END of BlackJackGame class

