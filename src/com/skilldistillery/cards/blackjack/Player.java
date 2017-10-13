package com.skilldistillery.cards.blackjack;

public class Player {
	private Hand hand;
	private int points;
	public void hit() {
		//makes the dealer deal a card to the player
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

	
}
