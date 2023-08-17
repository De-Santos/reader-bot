package com.hard.reader.bot.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface BotService {
	SendMessage echo(Update update);

	SendMessage sayHello(Update update);

	SendMessage start(Update update);
}
