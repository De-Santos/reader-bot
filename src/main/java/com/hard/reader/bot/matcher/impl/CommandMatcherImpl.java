package com.hard.reader.bot.matcher.impl;

import com.hard.reader.bot.entity.enums.internal.Command;
import com.hard.reader.bot.exception.UnknownActionException;
import com.hard.reader.bot.matcher.CommandMatcher;
import com.hard.reader.bot.service.BotService;
import com.hard.reader.bot.utils.assertion.Assertion;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
@Component
@RequiredArgsConstructor
class CommandMatcherImpl implements CommandMatcher {

	private final BotService botService;

	@Override
	public SendMessage match(Update update) {
		if (Assertion.isCommand(update)) {
			if (Assertion.isThisCommand(Command.START, update)) return botService.start(update);
			else throw new IllegalArgumentException("Commands not implemented yet");
		} else if (Assertion.isMessage(update)) {
			return botService.echo(update);
		} else {
			log.error("Unknown action");
			throw UnknownActionException.create();
		}
	}
}
