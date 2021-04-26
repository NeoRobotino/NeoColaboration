package com.neo.usecases;

import java.util.List;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;

public class CandlestickUsecase {

	public List<Candlestick> getCandlesStick(String symbol, CandlestickInterval candlestickInterval) {
		BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
		BinanceApiRestClient client = factory.newRestClient();
		return client.getCandlestickBars(symbol, candlestickInterval);
	}
	
}
