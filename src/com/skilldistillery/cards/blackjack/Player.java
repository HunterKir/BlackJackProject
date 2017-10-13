package com.skilldistillery.cards.blackjack;

public class Player {
	protected Hand hand;
	protected int points;
	protected String name;
	protected boolean standing;
	
	public Player() {
		this.hand = new Hand();
		this.standing = false;
	}
	
	public Player(String name) {
		super();
		this.name = name;
		this.standing = false;
	}
	
	
	public void hit(Player player) {
		//makes the dealer deal a card to the player
		((Dealer) player).dealToPlayer(this);
	}
	
	public boolean isStanding() {
		return this.standing;
	}
	
	public void stand() {
		//locks in the player's points
		this.standing = true;
	}

	public int getPoints() {
		points = hand.calculatePoints();
		return points;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addToHand(Card card) {
		//adds a card to the hand
		hand.addCard(card);
	}
	
}
