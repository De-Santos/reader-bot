package com.hard.reader.bot.utils.matcher.impl;

import com.hard.reader.bot.entity.enums.internal.Callback;
import com.hard.reader.bot.service.BotService;
import com.hard.reader.bot.utils.matcher.CallbackMatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
@Component
@RequiredArgsConstructor
public class CallbackMatcherImpl implements CallbackMatcher {

	private final BotService botService;

	@Override
	public SendMessage match(Update update) {
		log.info("Callback have gotten");
		if (Callback.SAY_HELLO.getAction().equals(update.getCallbackQuery().getData())) {
			return botService.sayHello(update);
		} else {
			SendMessage message = new SendMessage();
			message.setChatId(update.getCallbackQuery().getMessage().getChatId());
			message.setText("Unknown inline callback: " + update.getCallbackQuery().getData());
			return message;
		}
	}
}