package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {
	
	public void dealToPlayer() {
		//deals one card to the player
	}
	
	public void dealToDealer() {
		//deals one card to the dealer
	}
	
	public void clearTable() {
		//clears the table of cards
	}
	
	@Override
	public void hit() {
		// if the dealer has less than 17, or the player has more points, deal a card to the dealer
	}
	
	@Override
	public void stand() {
		//if the dealer has over 17, and the player does not have more points, lock in points
	}
}
