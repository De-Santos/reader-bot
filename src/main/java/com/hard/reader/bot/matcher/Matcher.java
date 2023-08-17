package com.hard.reader.bot.matcher;

public interface Matcher<T, A> {
	T match(A argument);
}
