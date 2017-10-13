package com.skilldistillery.cards.blackjack;

public class BlackJack {
	private Player player;
	private Player dealer;
	
	public BlackJack(String name) {
		this.player = new Player(name);
		this.dealer = new Dealer();
	}
	public void determineWinner() {
		//checks for a winner
		if (player.isStanding() && dealer.isStanding()) {
			if (player.getPoints() > dealer.getPoints()) {
				//player wins hand
			}
			else if (player.getPoints() < dealer.getPoints()) {
				//dealer wins round
			}
			else {
				//draw
			}
		}
	}
	
	public void endGame() {
		//ends the game, quits the app
		System.out.println("Thanks for playing!");
		System.exit(0);
	}
	
	public void newGame() {
		//creates a new game
	}
	
	public void displayPlayerHand() {
		//displays the player's hand
	}
	
	public void displayDealerHand() {
		//displays the dealer's hand
	}
	
	public void pointsInHand() {
		//calculates the amount of points in the player's and dealer's hands
	}
}
