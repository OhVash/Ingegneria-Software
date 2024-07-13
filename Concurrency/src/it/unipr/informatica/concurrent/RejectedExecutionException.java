package it.unipr.informatica.concurrent;

public class RejectedExecutionException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6748556787095111509L;

	public RejectedExecutionException(String message) {
		super(message);
	}
}
