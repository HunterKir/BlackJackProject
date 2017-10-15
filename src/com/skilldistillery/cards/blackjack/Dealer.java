package com.skilldistillery.cards.blackjack;

public class Dealer extends Player {
	private Deck deck;
	private int bettingPool;
	private int sidePool;
	
	public Dealer() {
		this.deck = new Deck();
		this.hand = new Hand();
		this.name = "Dealer";
		this.bettingPool = 0;
		this.sidePool = 0;
	}
	public Dealer(String name) {
		this.deck = new Deck();
		this.hand = new Hand();
		this.name = name;
		this.bettingPool = 0;
		this.sidePool = 0;
	}
	public void dealToPlayer(Player player) {
		//deals one card to the player
		player.addToHand(deck.draw());
		checkDeck();
	}
	
	public void dealToSplit(Player player) {
		player.addToSplitHand(deck.draw());
		checkDeck();
	}
	
	public int getSidePool() {
		return sidePool;
	}
	public void setSidePool(int sidePool) {
		this.sidePool = sidePool;
	}
	public int getBettingPool() {
		return bettingPool;
	}
	public void setBettingPool(int bettingPool) {
		this.bettingPool = bettingPool;
	}
	
	public void givePool(Player player) {
		//dealer gives the winner the contents of the pool
		player.setMoney(player.getMoney() + bettingPool);
		this.bettingPool = 0;
	}
	public void giveSidePool(Player player) {
		//dealer gives the winner the contents of the pool
		player.setMoney(player.getMoney() + sidePool);
		this.sidePool = 0;
	}
	
	public Card showOne() {
		return hand.getCardAtIndex(1);
	}
	
	public void dealToDealer() {
		//deals one card to the dealer
		this.addToHand(deck.draw());
		checkDeck();
	}
	
	public void getNewDeck() {
		//gives the dealer a new, shuffled deck
		this.deck = new Deck();
		deck.shuffle();
	}
	
	public void shuffle() {
		deck.shuffle();
	}
	
	public void checkDeck() {
		if (deck.getSize() == 0) {
			getNewDeck();
			System.out.println(this.name + " gets a new deck.");
		}
	}
	
	@Override
	public void hit(Player player) {
		// if the dealer has less than 17, or the player has more points, deal a card to the dealer
		this.points = hand.calculatePoints();
		if (this.points < 17) {
			dealToDealer();
		}
		else if (this.points > 21) {
			stand();
		}
		else if (player.isStanding() && this.points < player.getPoints()) {
			dealToDealer();
		}
		else {
			stand();
		}
	}
	
}
