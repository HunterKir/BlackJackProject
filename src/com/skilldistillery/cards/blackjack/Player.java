package com.skilldistillery.cards.blackjack;

public class Player {
	protected Hand hand;
	protected Hand splitHand;
	protected int points;
	protected int splitPoints;
	protected String name;
	protected boolean standing;
	protected int money;
	
	public Player() {
		this.hand = new Hand();
		this.standing = false;
	}
	
	public Player(String name) {
		super();
		this.hand = new Hand();
		this.name = name;
		this.standing = false;
		this.money = 100;
	}
	
	public void hit(Player player) {
		//makes the dealer deal a card to the player
		((Dealer) player).dealToPlayer(this);
	}
	
	public void doubleDown(Player player) {
		//player doubles down on bet, only gets one more card
		((Dealer) player).dealToPlayer(this);
		this.standing = true;
	}
	
	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public boolean isStanding() {
		return standing;
	}
	
	public void stand() {
		//locks in the player's points
		standing = true;
	}
	
	public void split() {
		splitHand = new Hand();
		addToSplitHand(hand.removeCardAtOne());
	}

	public int getPoints() {
		points = hand.calculatePoints();
		if (points > 21) {
			standing = true;
		}
		return points;
	}
	public int getSplitPoints() {
		splitPoints = splitHand.calculatePoints();
		if (splitPoints > 21) {
			standing = true;
		}
		return splitPoints;
	}
	public String getName() {
		return name;
	}
	public void resetSplitHand() {
		this.splitHand = null;
	}
	
	public boolean canSplit() {
		return hand.compareCards();
	}

	public void newHand() {
		this.hand = new Hand();
	}
	
	public void addToHand(Card card) {
		//adds a card to the hand
		hand.addCard(card);
	}
	
	public void addToSplitHand(Card card) {
		splitHand.addCard(card);
	}
	
	public Hand getSplitHand() {
		return splitHand;
	}
	
	public Hand getHand() {
		return hand;
	}

	public void setStanding(boolean standing) {
		this.standing = standing;
	}
	
}
