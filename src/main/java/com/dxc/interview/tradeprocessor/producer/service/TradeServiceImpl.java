package com.dxc.interview.tradeprocessor.producer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.interview.tradeprocessor.consumer.repository.TradeRepository;
import com.dxc.interview.tradeprocessor.dto.Trade;

@Service
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;
	
	@Override
	public List<Trade> findAll() {
		
		return tradeRepository.findAll();
	}

}
