import java.util.ArrayList;
import java.util.Collections;

public class CardStack {
	//Declare private ArrayList to hold cards objects 
	private ArrayList<Card> cards;
	
	//Constructor 
	public CardStack() {
		//Initialize empty ArrayList
		cards = new ArrayList<>();
	}//END of CardStack constructor
	
	//Push adds a new card onto the top of the stack
	public void push(Card c) {
		cards.add(c);
	}//END of push method
	
	//Pop removes and returns the top card from the stack
	public Card pop() {
		//If the stack is empty, display message and return null
		if(isEmpty()){
			System.out.println("Deck is empty!");
			return null;
		}
		//Else, remove and return the top card in the stack
		else {		
			return cards.remove(cards.size()-1);
		}
	}//END of pop method
	
	//Peek returns the top card from the stack without removing it
	public Card peek() {
		//If the stack is empty, return null
		if(isEmpty()){
			return null;
		}
		//Else, return top card in the stack
		else {
			return cards.get(cards.size()-1);
		}
	}
	
	//Shuffle randomizes the order of the cards in the deck
	public void shuffle(){
		Collections.shuffle(cards);
	}	
	
	//Returns true if the stack has no cards
	public boolean isEmpty() {
		return cards.isEmpty();
	}
	
	//Clears the entire stack so you can reuse the deck
	public void clear() {
		cards.clear();
	}
	
	public void printDeck() {
		for(Card c: cards) {
			System.out.println(c);
		}
		
	}
	
}//END of CardStack class
