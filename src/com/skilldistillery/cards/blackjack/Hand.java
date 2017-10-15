package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {
	private List<Card> hand = new ArrayList<>();
	public Hand() {
	}
	
	public void addCard(Card card) {
		//adds a card to the hand
		hand.add(card);
	}
	
	public Card revealOne() {
		return hand.get(1);
	}
	
	public Card cardAtOne() {
		return hand.remove(1);
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
