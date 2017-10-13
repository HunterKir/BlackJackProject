package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand;
	private boolean ace;
	public Hand() {
		this.hand = new ArrayList<>();
	}
	
	public void addCard(Card card) {
		//adds a card to the hand
		hand.add(card);
	}
	
	public int calculatePoints() {
		int total = 0;
		int aces = 0;
		for (Card card : hand) {
			total += card.getValue();
			if (card.getValue() == 11) {
				aces++;
			}
		}
		while (aces > 0) {
			if (total > 21) {
				total -= 10;
			}
			aces--;
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
