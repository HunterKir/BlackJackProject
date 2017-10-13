package com.skilldistillery.cards.blackjack;

public class Player {
	protected Hand hand;
	protected int points;
	public void hit(Player player) {
		//makes the dealer deal a card to the player
		((Dealer) player).dealToPlayer(this);
	}
	
	public void stand() {
		//locks in the player's points
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	
	public void addToHand(Card card) {
		//adds a card to the hand
		hand.addCard(card);
	}
	
}
