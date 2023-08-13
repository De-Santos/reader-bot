package com.hard.reader.bot.bots;

import com.hard.reader.bot.config.BotConfig;
import com.hard.reader.bot.utils.matcher.CommandMatcher;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Log4j2
@Component()
@RequiredArgsConstructor
public class PollingBot extends TelegramLongPollingBot {

	private final BotConfig config;
	private final CommandMatcher matcher;

	@Override
	public void onUpdateReceived(Update update) {
		this.sendMessage(matcher.match(update));
	}

	public void sendMessage(SendMessage message) {
		try {
			this.execute(message);
		} catch (TelegramApiException e) {
			log.error("Failed to send a message", e);
		}
	}

	@Override
	public String getBotUsername() {
		return config.getBotName();
	}

	@Override
	public String getBotToken() {
		return config.getToken();
	}
}
