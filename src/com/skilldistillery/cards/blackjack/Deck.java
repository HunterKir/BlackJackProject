package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
	private List<Card> deck = new ArrayList<>(52);
	
	public Deck() {
		for (Suit s : Suit.values()) {
            for (Rank r : Rank.values()) {
                deck.add(new Card(r, s));
            }
        }
	}
	

	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	public Card draw() {
		return deck.remove(0);
	}
	
	public int getSize() {
		return deck.size();
	}
}