package com.neo.usecases;

import java.util.List;

import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.BinanceApiRestClient;
import com.binance.api.client.domain.market.TickerStatistics;
import static com.neo.constants.ExceptionConstants.INVALID_SYMBOL;
import com.neo.exceptions.InvalidSymbolException;

public class TickerStatisticsUsecase{

	public List<TickerStatistics> getAll24HrPriceStatistics() {
		BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
		BinanceApiRestClient client = factory.newRestClient();
		return client.getAll24HrPriceStatistics();
	}
	
	public TickerStatistics getSpecificTickerStatistics(List<TickerStatistics> tickerStatistics, String symbol) {
		for(int x = 0; x< tickerStatistics.size() ;x++) {
			TickerStatistics tickerStatistic = tickerStatistics.get(x);
			if (symbol.equalsIgnoreCase(tickerStatistic.getSymbol()) ){
				return tickerStatistic;
			}
		}
		throw new InvalidSymbolException(INVALID_SYMBOL+symbol);
	}
}

