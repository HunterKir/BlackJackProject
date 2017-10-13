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
	
	public int calculatePoints() {
		int total = 0;
		for (Card card : hand) {
			total += card.getValue();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(hand);
		return builder.toString();
	}
	
}
