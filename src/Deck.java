public class Deck {
	//Declare a new stack
	private CardStack stack;
	
	//Constructor builds and shuffles a 52-card deck
	public Deck() {
		//Initialize new stack
		stack = new CardStack();
		//Call build and shuffle methods
		build();
		shuffle();
	}//END of deck constructor
	
	//Build a 52 card deck
	private void build() {
		//Switch statement to assign suit
		for (int i = 1; i <= 4; i++) {
			char suit = ' ';
			switch(i) {
			case 1: 
				suit = '♣';
				break;
			case 2: 
				suit = '♦';
				break;
			case 3: 
				suit = '♥';
				break;
			case 4: 
				suit = '♠';
				break;
			}
			//Loop through all face values and push to stack
			for (int j = 1; j <= 13; j++) {
				Card c = new Card(suit, j);
				stack.push(c);
			}
		}

	}//END of build method
	
	//Shuffle randomizes the order of the deck
	private void shuffle() {
		stack.shuffle();
	}//END of shuffle method
	
	//Pop removes and returns the top card from the stack 
	public Card draw() {
		return stack.pop();
	}//END of draw method
	
	//Reset clears the deck and rebuilds it
	public void reset() {
		stack.clear();
		build();
		shuffle();
	}//END of reset method
}// END of Deck class