/**
 * 
 */
package com.nand.exception;

/**
 * root exception represents an error in parsing rule
 * 
 * @author Nand
 *
 */
public class RuleParseException extends Exception {

	/**
	 * 
	 */
	public RuleParseException() {
	}

	/**
	 * @param message
	 */
	public RuleParseException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public RuleParseException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RuleParseException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public RuleParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
