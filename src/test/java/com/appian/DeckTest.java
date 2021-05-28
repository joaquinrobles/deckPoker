package com.appian;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DeckTest {
	Deck deck;
	Integer randomSeed = Integer.MAX_VALUE;

	@BeforeEach
	void initialise() {
		deck = new Deck(new Random(randomSeed));
	}
		
	@Test
	void should_deal_card_in_order_without_shuffle() {
		assertEquals(Card.getAllPosibleCards().get(0), deck.dealOneCard().get());
		assertEquals(Card.getAllPosibleCards().get(1), deck.dealOneCard().get());
	}
	
	@Test
	void should_no_deal_after_all_cards_dealt() {
		dealAllCards();		
		assertFalse(deck.dealOneCard().isPresent());
	}
	
	@Test
	void should_deal_card_randomly_with_shuffle() {
		Random randomNumbers = new Random(randomSeed);
		
		deck.shuffle();
		
		assertEquals(Card.getAllPosibleCards().get(randomNumbers.nextInt(getTotalNumberOfCards())), deck.dealOneCard().get());
	}

	private int getTotalNumberOfCards() {
		return Card.getAllPosibleCards().size();
	}

	private void dealAllCards() {
		for(int i=0; i<getTotalNumberOfCards(); i++)
			deck.dealOneCard();
	}

}
