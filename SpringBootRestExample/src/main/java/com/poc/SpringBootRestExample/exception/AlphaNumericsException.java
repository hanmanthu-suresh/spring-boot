package com.poc.SpringBootRestExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class AlphaNumericsException extends NumberFormatException{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String msg;
	public AlphaNumericsException(String id, String msg) {
		super(msg);
		this.id = id;
		this.msg = msg;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
