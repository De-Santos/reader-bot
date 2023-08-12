package com.hard.reader.bot.bots;

import com.hard.reader.bot.config.BotConfig;
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

	@Override
	public void onUpdateReceived(Update update) {
		log.info("Obtained this message: {}", update.getMessage().getText());
		if (update.hasMessage() && update.getMessage().hasText()) {
			String chatId = update.getMessage().getChatId().toString();
			String text = update.getMessage().getText();

			SendMessage message = new SendMessage();
			message.setChatId(chatId);
			message.setText("You said: " + text);

			try {
				this.execute(message);
			} catch (TelegramApiException e) {
				log.error("Failed to send a message", e);
			}
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
