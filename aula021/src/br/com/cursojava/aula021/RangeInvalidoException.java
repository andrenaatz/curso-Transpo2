package br.com.cursojava.aula021;

public class RangeInvalidoException extends Exception {

	public RangeInvalidoException() {
		super();
	}

	public RangeInvalidoException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public RangeInvalidoException(String message, Throwable cause) {
		super(message, cause);
	}

	public RangeInvalidoException(String message) {
		super(message);
	}

	public RangeInvalidoException(Throwable cause) {
		super(cause);
	}
	
	

}
