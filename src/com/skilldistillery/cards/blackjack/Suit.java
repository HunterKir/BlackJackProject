package com.skilldistillery.cards.blackjack;

public enum Suit {
    HEARTS("\u2665"), SPADES("\u2660"), CLUBS("\u2663"), DIAMONDS("\u2666");
	
	private String name;
	
	Suit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	
}
