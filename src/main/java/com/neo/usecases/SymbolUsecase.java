package com.neo.usecases;

import com.neo.exceptions.InvalidSymbolException;
import static com.neo.constants.ExceptionConstants.*;
import static com.neo.constants.SymbolsConstant.*;

public class SymbolUsecase {

	public static String calculateCoinGroup(String symbol) {
		String group = "";
		if (symbol == null || symbol.trim().isEmpty()) {
			throw new InvalidSymbolException(SYMBOL_CANNOT_BE_NULL+symbol);
		}
		
		symbol = symbol.toUpperCase().trim();
		if (symbol.endsWith(ETH)) {
			group = ETH;
		}else if (symbol.endsWith(BTC)) {
			group = BTC;
		}else if (symbol.endsWith(NGN)) {
			group = NGN;
		}else if (symbol.endsWith(BNB)) {
			group = BNB;
		}else if (symbol.endsWith(USDT)) {
			group = USDT;
		}else if (symbol.endsWith(TUSD)) {
			group = TUSD;
		}else if (symbol.endsWith(PAX)) {
			group = PAX;
		}else if (symbol.endsWith(BUSD)) {
			group = BUSD;
		}else if (symbol.endsWith(USDC)) {
			group = USDC;
		}else if (symbol.endsWith(XRP)) {
			group = XRP;
		}else if (symbol.endsWith(USDS)) {
			group = USDS;
		}else if (symbol.endsWith(TRX)) {
			group = TRX;
		}else if (symbol.endsWith(RUB)) {
			group = RUB;
		}else if (symbol.endsWith(TRY)) {
			group = TRY;
		}else if (symbol.endsWith(EUR)) {
			group = EUR;
		}else if (symbol.endsWith(ZAR)) {
			group = ZAR;
		}else if (symbol.endsWith(BKRW)) {
			group = BKRW;
		}else if (symbol.endsWith(IDRT)) {
			group = IDRT;
		}else if (symbol.endsWith(GBP)) {
			group = GBP;
		}else if (symbol.endsWith(UAH)) {
			group = UAH;
		}else if (symbol.endsWith(AUD)) {
			group = AUD;
		}else if (symbol.endsWith(BIDR)) {
			group = BIDR;
		}else if (symbol.endsWith(DAI)) {
			group = DAI;
		}else if (symbol.endsWith(BRL)) {
			group = BRL;
		}else if (symbol.endsWith(BVND)) {
			group = BVND;
		}else if (symbol.endsWith(VAI)) {
			group = VAI;
		}else { 
			throw new InvalidSymbolException(INVALID_SYMBOL+symbol);
		}
		
		return group;
	}
	
	public static String calculateCoinName(String symbol) {
		String group =calculateCoinGroup(symbol);
		int startIndex = symbol.length() - group.length();
		return symbol.substring(0, startIndex);
	}
	
}
