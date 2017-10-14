package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackJack {
	static Scanner kb = new Scanner(System.in);
	private Player player;
	private Dealer dealer;
	private boolean inGame = true;

	public BlackJack(String name) {
		this.player = new Player(name);
		this.dealer = new Dealer();
	}

	public void deal() {
		dealer.dealToPlayer(player);
		dealer.dealToDealer();
	}

	public void start() {
		dealer.shuffle();
		deal();
		deal();
		while (inGame) {
			determineWinner();
			displayHands();
			displayMenu();
			menuSelect(inputFilter(kb.next()));
			dealerMove();
		}
	}

	public void menuSelect(int input) {
		if (input == 1) {
			// hit
			player.hit(dealer);
		} else if (input == 2) {
			// stand
			player.stand();
			while (!dealer.isStanding()) {
				dealerMove();
			}
		}
	}

	public void dealerMove() {
		if (player.isStanding()) {
			dealer.hit(player);
		}
	}

	public void displayMenu() {
		System.out.println("1: HIT     2: STAND");
	}

	public static int inputFilter(String input) {
		int num = 0;
		boolean loop = true;
		while (loop) {
			try {
				num = Integer.parseInt(input);
				loop = false;
			} catch (NumberFormatException e) {
				System.out.println("Invalid input. Try again.");
				input = kb.nextLine();
			}
		}
		return num;
	}

	public void determineWinner() {
		// checks for a winner
		if (player.getPoints() == 21 || dealer.getPoints() > 21) {
			displayHands();
			System.out.println("you win");
			playAnother();
		} else if (dealer.getPoints() == 21 || player.getPoints() > 21) {
			displayHands();
			System.out.println("house wins");
			playAnother();
		} else if (player.getPoints() > dealer.getPoints() && (player.isStanding() && dealer.isStanding())) {
			displayHands();
			System.out.println("you win");
			playAnother();
		} else if (player.getPoints() < dealer.getPoints() && (player.isStanding() && dealer.isStanding())) {
			displayHands();
			// dealer wins hand
			System.out.println("house wins");
			playAnother();
		} else {
			// draw
		}
	}

	public void playAnother() {
		boolean invalid = true;
		System.out.println("Play another hand?");
		System.out.println("1: YES     2: NO");
		while (invalid) {
			int input = inputFilter(kb.next());
			if (input == 1) {
				nextHand();
				player.setStanding(false);
				dealer.setStanding(false);
				deal();
				deal();
				invalid = false;
			} else if (input == 2) {
				endGame();
				invalid = false;
			} else {
				System.out.println("Invalid input. Try again.");
			}
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
	
	public void displayHands() {
		System.out.println(dealer.getName() + "'s hand:");
		if (!player.isStanding()) {
			System.out.println(dealer.showOne());
		}
		else {
			System.out.println(dealer.getHand());
		}
		System.out.println(player.getName() + "'s hand:");
		System.out.println(player.getHand());
		
	}


}
