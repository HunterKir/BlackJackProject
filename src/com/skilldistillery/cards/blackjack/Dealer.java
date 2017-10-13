package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {
	private Deck deck;
	
	public Dealer() {
		this.deck = new Deck();
		this.hand = new Hand();
	}
	public void dealToPlayer(Player player) {
		//deals one card to the player
		player.addToHand(deck.draw());
	}
	
	public void dealToDealer() {
		//deals one card to the dealer
		this.addToHand(deck.draw());
	}
	
	public void clearTable() {
		//clears the table of cards
	}
	
	public void getNewDeck() {
		//gives the dealer a new, shuffled deck
		this.deck = new Deck();
		deck.shuffle();
	}
	
	@Override
	public void hit(Player player) {
		// if the dealer has less than 17, or the player has more points, deal a card to the dealer
		if (this.points < 17) {
			dealToDealer();
		}
		else if (this.points < player.getPoints()) {
			dealToDealer();
		}
		else {
			stand();
		}
	}
	
}
