package com.neo.usecases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.exception.BinanceApiException;

public class CandlestickUsecaseTest {

	private CandlestickUsecase candlestickUsecase;
	
	@Before
	public void setUp() {
		candlestickUsecase = new CandlestickUsecase();
	}
	
	@Test
	public void get_valid_list_candlesSticks() {
		String symbol = "XRPUSDT";
		CandlestickInterval candlestickInterval = CandlestickInterval.FIVE_MINUTES;
		
		List<Candlestick> result = candlestickUsecase.getCandlesStick(symbol, candlestickInterval);
		assertNotNull(result);
		assertTrue(result.size() >0);
	}
	
	@Test(expected = BinanceApiException.class)
	public void try_to_get_candlesSticks_from_NOT_valid_symbol() {
		String symbol = "NROTUSDT";
		CandlestickInterval candlestickInterval = CandlestickInterval.FIVE_MINUTES;
		candlestickUsecase.getCandlesStick(symbol, candlestickInterval);			
	}
}
