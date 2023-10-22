package org.springframework.web;

public class HttpMediaTypeNotSupportedException extends RuntimeException {

	  private static final long serialVersionUID = 1L;

	  public HttpMediaTypeNotSupportedException(String msg) {
	    super(msg);
	  }
}

