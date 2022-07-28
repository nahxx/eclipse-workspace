package com.varxyz.banking.mvc.controller;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferCommand {
	private String withdrawNum;
	private String depositNum;
	private double amount;
	private String passwd;
}
