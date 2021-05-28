package com.appian;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class Deck {
	List<Card> cards = new ArrayList<>();
	Random randomNumbers;
	
	public Deck(Random randomNumbers) {
		this.randomNumbers = randomNumbers;
		cards = Card.getAllPosibleCards();
	}

	public Optional<Card> dealOneCard() {
		Optional<Card> cardDealt = Optional.empty();

		if(!cards.isEmpty())
			cardDealt = Optional.of(cards.remove(0));
			
		return cardDealt;
	}

	public void shuffle() {
		List<Card> randomCards = new ArrayList<>();
		
		while(!cards.isEmpty())
			randomCards.add(removeRandomCard());
		
		cards = randomCards;
	}

	private Card removeRandomCard() {
		return cards.remove(getRandomNumber());
	}

	private int getRandomNumber() {
		return randomNumbers.nextInt(cards.size());
	}

}
