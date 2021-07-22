package com.dxc.interview.tradeprocessor.consumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dxc.interview.tradeprocessor.dto.Trade;

@Repository
public interface TradeRepository extends JpaRepository<Trade, String>{

	
}
