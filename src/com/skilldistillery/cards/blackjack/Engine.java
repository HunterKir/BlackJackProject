package com.skilldistillery.cards.blackjack;

public class Engine {

	public static void main(String[] args) {
		BlackJack game = new BlackJack(args[0]);
		game.start();
	}

}
