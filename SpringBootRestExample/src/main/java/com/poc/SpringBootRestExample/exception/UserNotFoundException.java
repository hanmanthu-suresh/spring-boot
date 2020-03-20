package com.poc.SpringBootRestExample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.OK)
public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String msg;

	public UserNotFoundException(int id, String msg) {
		super(msg);
		this.id = id;
		this.msg = msg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
