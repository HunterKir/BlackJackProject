package com.skilldistillery.cards.blackjack;

public class Engine {

	public static void main(String[] args) {
		BlackJack game = null;
		if (args.length == 1) {
			game = new BlackJack(args[0]);
		}
		else if (args.length == 2) {
			game = new BlackJack(args[0], args[1]);
		}
		game.start();
	}

}
