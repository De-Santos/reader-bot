package com.hard.reader.bot.exception;

@SuppressWarnings("unused")
public class UnknownActionException extends BotException {

	public static UnknownActionException create() {
		return new UnknownActionException("Unknown action");
	}

	public UnknownActionException() {
	}

	public UnknownActionException(String message) {
		super(message);
	}

	public UnknownActionException(String message, Throwable cause) {
		super(message, cause);
	}

	public UnknownActionException(Throwable cause) {
		super(cause);
	}

	public UnknownActionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
