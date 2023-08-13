package com.hard.reader.bot.utils.matcher;

public interface Matcher<T, A> {
	T match(A argument);
}
