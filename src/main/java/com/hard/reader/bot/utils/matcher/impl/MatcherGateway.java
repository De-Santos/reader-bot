package com.hard.reader.bot.utils.matcher.impl;

import com.hard.reader.bot.exception.UnknownActionException;
import com.hard.reader.bot.utils.matcher.CallbackMatcher;
import com.hard.reader.bot.utils.matcher.CommandMatcher;
import com.hard.reader.bot.utils.matcher.Matcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.hard.reader.bot.utils.assertion.Assertion.isCallBackQuery;
import static com.hard.reader.bot.utils.assertion.Assertion.isTextMessage;

@Log4j2
@Component
@RequiredArgsConstructor
public class MatcherGateway implements Matcher<SendMessage, Update> {

	public final CommandMatcher commandMatcher;
	public final CallbackMatcher callbackMatcher;

	@Override
	public SendMessage match(Update update) {
		if (isTextMessage(update)) {
			return commandMatcher.match(update);
		} else if (isCallBackQuery(update)) {
			return callbackMatcher.match(update);
		} else {
			log.error("Unknown action");
			throw UnknownActionException.create();
		}
	}
}
