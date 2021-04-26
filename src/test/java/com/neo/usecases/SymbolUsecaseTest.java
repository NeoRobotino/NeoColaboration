package com.neo.usecases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.neo.exceptions.InvalidSymbolException;
import com.neo.usecases.SymbolUsecase;

public class SymbolUsecaseTest {

	@Test
	public void calculate_valid_coinGroup_from_valid_symbol() {
		String coinGroup = SymbolUsecase.calculateCoinGroup("BTCUSDT");
		assertEquals("USDT", coinGroup);
	}
	
	@Test
	public void calculate_valid_coinName_from_valid_symbol() {
		String coinName = SymbolUsecase.calculateCoinName("BTCUSDT");
		assertEquals("BTC", coinName);
	}
	
	@Test(expected =InvalidSymbolException.class )
	public void calculate_NOT_valid_coinGroup_from_valid_symbol() {
		SymbolUsecase.calculateCoinGroup("BTCNROT");
	}
	
}
