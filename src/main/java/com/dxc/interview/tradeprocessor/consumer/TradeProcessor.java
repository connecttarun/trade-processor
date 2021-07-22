package com.dxc.interview.tradeprocessor.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.dxc.interview.tradeprocessor.consumer.service.TradeConsumerService;
import com.dxc.interview.tradeprocessor.dto.Trade;

@Component
public class TradeProcessor {

private static final Logger log = LoggerFactory.getLogger(TradeProcessor.class);

@Autowired
private TradeConsumerService tradeService;

	@JmsListener(destination="trades.queue")
	public void processor(Trade trade) {

		log.debug("..received message.. ");
		tradeService.processTrade(trade);		
		log.debug(trade.toString());
	}
}
