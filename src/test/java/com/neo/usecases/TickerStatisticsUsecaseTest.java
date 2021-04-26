package com.neo.usecases;

import static com.neo.usecases.SymbolUsecase.calculateCoinName;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.binance.api.client.domain.market.TickerStatistics;

public class TickerStatisticsUsecaseTest{
	
	private TickerStatisticsUsecase tickerStatisticsUsecase;
	
	@Before
	public void setUp() {
		tickerStatisticsUsecase = new TickerStatisticsUsecase();
	}
	
	@Test
	public void get_btc_24Hr_price_statistics() {
		List<TickerStatistics> result = tickerStatisticsUsecase.getAll24HrPriceStatistics();
		TickerStatistics found = tickerStatisticsUsecase.getSpecificTickerStatistics(result, "BTCUSDT");
		assertNotNull(result);
		assertTrue(result.size() >0);
		assertNotNull(found);
		assertEquals("BTCUSDT", found.getSymbol());
	}
	
	@Test
	public void parse_name_all_24Hr_price_statistics() {
		List<TickerStatistics> result = tickerStatisticsUsecase.getAll24HrPriceStatistics();
		for(int x = 0; x<result.size() ; x++) {
			TickerStatistics TickerStatistic = result.get(x);
			String name = calculateCoinName(TickerStatistic.getSymbol());
			String group = SymbolUsecase.calculateCoinGroup(TickerStatistic.getSymbol());
			
			assertNotNull(name);
			assertNotNull(group);
		}
	}
}
