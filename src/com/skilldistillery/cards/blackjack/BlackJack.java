package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackJack {
	static Scanner kb = new Scanner(System.in);
	private Player player;
	private Dealer dealer;
	private boolean inGame = true;
	private boolean nextHand = true;

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
			if (nextHand) {
				displayPlayerMoney();
				placeBet();
			}
			displayHands();
			nextHand = false;
			displayMenu();
			determineWinner();
			menuSelect(inputFilter(kb.next()));
			dealerMove();
		}
	}
	
	public void displayPlayerMoney() {
		System.out.println("You have $" + player.getMoney() + ".");
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
		} else if (input == 3) {
			doubleDown();
			while (!dealer.isStanding()) {
				dealerMove();
			}
		} else if (input == 4) {
			//split
			player.split();
			displayPlayerMoney();
			System.out.println("Bet on your second hand.");
			
		}
	}

	public void dealerMove() {
		if (player.isStanding()) {
			dealer.hit(player);
		}
	}
	
	public void doubleDown() {
		if (player.getMoney() < (dealer.getBettingPool()/2)) {
			System.out.println("You don't have enough money to double down on that bet!");
		}
		else {
			player.doubleDown(dealer);
			player.setMoney(player.getMoney() - (dealer.getBettingPool()/2));
			dealer.setBettingPool(dealer.getBettingPool()*2);
		}
	}
	public void displayMenu() {
		System.out.println("1: HIT     2: STAND     3. DOUBLE DOWN     4. SPLIT");
	}
	
	public void placeBet() {
		boolean invalidBet = true;
		while (invalidBet) {
			System.out.println("Place your bet.");
			int money = inputFilter(kb.next());
			if (verifyBet(money)) {
				dealer.setBettingPool(money * 2);
				player.setMoney(player.getMoney() - money);
				invalidBet = false;
			}
		}
		
	}
	public boolean verifyBet(int money) {
		if (player.getMoney() >= money) {
			return true;
		}
		else {
			System.out.println("You don't have that much money!");
			return false;
		}
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
			if (player.getPoints() == 21) {
				System.out.println("----------");
				System.out.println("BLACKJACK!");
				System.out.println("----------");
			}
			System.out.println("You won $" + dealer.getBettingPool() + "!");
			dealer.givePool(player);
			playAnother();
			nextHand = true;
		} else if (dealer.getPoints() == 21 || player.getPoints() > 21) {
			displayHands();
			if (dealer.getPoints() == 21) {
				System.out.println("----------");
				System.out.println("BLACKJACK!");
				System.out.println("----------");
				System.out.println("You lost $" + (dealer.getBettingPool()/2) + "!");
			}
			else {
				System.out.println("-----");
				System.out.println("BUST!");
				System.out.println("-----");
				System.out.println("You lost $" + (dealer.getBettingPool()/2) + "!");
			}
			if (player.getMoney() > 0) {
				playAnother();
				nextHand = true;
			}
			else {
				System.out.println("You're out of money! GAME OVER.");
				endGame();
			}
		} else if (player.getPoints() > dealer.getPoints() && (player.isStanding() && dealer.isStanding())) {
			displayHands();
			System.out.println("You won $" + dealer.getBettingPool() + "!");
			dealer.givePool(player);
			playAnother();
			nextHand = true;
		} else if (player.getPoints() < dealer.getPoints() && (player.isStanding() && dealer.isStanding())) {
			displayHands();
			System.out.println("You lost $" + (dealer.getBettingPool()/2) + "!");
			if (player.getMoney() > 0) {
				playAnother();
				nextHand = true;
			}
			else {
				System.out.println("You're out of money! GAME OVER.");
				endGame();
			}
		} else if (player.getPoints() == dealer.getPoints() && player.isStanding() && dealer.isStanding()){
			// draw
			System.out.println("-----");
			System.out.println("PUSH!");
			System.out.println("-----");
			nextHand = true;
			dealer.setBettingPool(dealer.getBettingPool()/2);
			dealer.givePool(player);
			playAnother();
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
		System.out.println("Total winnings = $" + (player.getMoney()-100) + ".");
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
