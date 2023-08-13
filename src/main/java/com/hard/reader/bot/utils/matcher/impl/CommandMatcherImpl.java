package com.hard.reader.bot.utils.matcher.impl;

import com.hard.reader.bot.exception.UnknownActionException;
import com.hard.reader.bot.service.BotService;
import com.hard.reader.bot.utils.matcher.CommandMatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
@Component
@RequiredArgsConstructor
public class CommandMatcherImpl implements CommandMatcher {

	private final BotService botService;
	private final CallbackMatcherImpl callbackMatcher;

	@Override
	public SendMessage match(Update update) {
		if (update.hasCallbackQuery()) {
			return callbackMatcher.match(update);
		} else if (update.hasMessage() && update.getMessage().hasText()) {
			return botService.echo(update);
		} else {
			log.error("Unknown action");
			throw UnknownActionException.create();
		}
	}
}
