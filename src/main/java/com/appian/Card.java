package com.appian;

import java.util.ArrayList;
import java.util.List;

public class Card {
	private Suit suit;
	
	private faceValue value;

	public Card(Suit suit, faceValue value) {
		this.suit = suit;
		this.value = value;		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (suit != other.suit)
			return false;
		if (value != other.value)
			return false;
		return true;
	}

	public enum Suit {
		HEARTS, SPADES, CLUBS, DIAMONDS
	}
	
	public enum faceValue{
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGTH,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING
	}
	
	public static List<Card> getAllPosibleCards(){
		List<Card> posibleCards = new ArrayList<>();
		
		for(Card.Suit suit : Card.Suit.values())
			for(Card.faceValue faceValue : Card.faceValue.values())
				posibleCards.add(new Card(suit, faceValue));
		
		return posibleCards;
	}
}
