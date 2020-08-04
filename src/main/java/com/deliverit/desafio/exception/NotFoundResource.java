package com.deliverit.desafio.exception;

public class NotFoundResource extends RuntimeException{
	
	private String msg;

	public NotFoundResource(String msg) {
		super(msg);
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
