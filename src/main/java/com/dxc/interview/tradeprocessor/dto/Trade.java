package com.dxc.interview.tradeprocessor.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Trade {

	@Id
	String tradeId;
	
	String tradeIdVersion;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	Date creDate;	
	
	@JsonFormat(pattern="dd/MM/yyyy")
	Date expireDate;
	
	String accountId;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	String tradeDate;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	Date settleDate;
	
	String numbers;
	
	String isin;
}
