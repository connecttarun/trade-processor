package com.dxc.interview.tradeprocessor.consumer.service;

import java.util.List;

import com.dxc.interview.tradeprocessor.dto.Trade;

public interface TradeConsumerService {

	void processTrade(Trade trade);

	List<Trade> findAll();

	
}
