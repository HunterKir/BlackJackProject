package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand;
	
	public Hand() {
		this.hand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		//adds a card to the hand
		hand.add(card);
	}
}
