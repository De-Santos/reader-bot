package com.hard.reader.bot.config;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Log4j2
@Configuration
public class BotStartConfiguration {

	@Autowired
	public void init(LongPollingBot bot) {
		try {
			TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
			botsApi.registerBot(bot);
		} catch (TelegramApiException e) {
			log.error("Failed to register telegram bot", e);
		}
	}
}
