package com.stackroute.news.util.exception;

public class NewsAlreadyExistsException extends Exception {

	public NewsAlreadyExistsException(String message) {
		super(message);
	}

	public NewsAlreadyExistsException(String message, Throwable cause) {
		super(message, cause);
	}
}
