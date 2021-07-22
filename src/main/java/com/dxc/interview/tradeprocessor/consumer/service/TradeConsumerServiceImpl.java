package com.dxc.interview.tradeprocessor.consumer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.interview.tradeprocessor.consumer.repository.TradeRepository;
import com.dxc.interview.tradeprocessor.dto.Trade;

@Service
public class TradeConsumerServiceImpl implements TradeConsumerService {

	@Autowired
	TradeRepository repository;
	
	@Override
	public void processTrade(Trade trade) {
		repository.save(trade);
	}

	@Override
	public List<Trade> findAll(){
		return repository.findAll();
	}
}
