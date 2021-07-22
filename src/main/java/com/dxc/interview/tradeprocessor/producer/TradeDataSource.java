package com.dxc.interview.tradeprocessor.producer;

import java.util.List;

import javax.jms.Queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.interview.tradeprocessor.dto.Trade;
import com.dxc.interview.tradeprocessor.producer.service.TradeService;

@RestController
@RequestMapping("/transaction")
public class TradeDataSource {
	
	private static final Logger log = LoggerFactory.getLogger(TradeDataSource.class);

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Autowired
	private Queue tradeQueue;
	
	@Autowired
	private TradeService tradeService;
	
	@PostMapping("/execute")
	public ResponseEntity<String> executeTransaction(@RequestBody Trade trade){
		log.debug("..publishing message..");		
		log.debug(trade.toString());
		jmsTemplate.convertAndSend(tradeQueue, trade);
		
		log.debug("..published message..");
		return new ResponseEntity<>("Publish Success", HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/trades")
	public ResponseEntity<List<Trade>> findAllTrades() {
		log.debug("../trades ..");
		return new ResponseEntity<>(tradeService.findAll(),HttpStatus.OK);
		
	}

	@GetMapping("")
	public String testUrl() {
		log.debug("..service is up message..");
		return "service is up and running";
	}


	
}