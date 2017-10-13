package com.skilldistillery.cards.blackjack;

public class BlackJack {
	private Player player;
	private Player dealer;

	public BlackJack(String name) {
		this.player = new Player(name);
		this.dealer = new Dealer();
	}

	public void determineWinner() {
		// checks for a winner
		if (player.getPoints() > dealer.getPoints()) {
			// player wins hand
		} else if (player.getPoints() < dealer.getPoints()) {
			// dealer wins hand
		} else {
			// draw
		}
	}

	public void endGame() {
		// ends the game, quits the app
		System.out.println("Thanks for playing!");
		System.exit(0);
	}
	
	public void nextHand() {
		player.newHand();
		dealer.newHand();
	}

	public void newGame() {
		// creates a new game
	}

	public void displayPlayerHand() {
		// displays the player's hand
		player.getHand();
	}

	public void displayDealerHand() {
		// displays the dealer's hand
		dealer.getHand();
	}

}
