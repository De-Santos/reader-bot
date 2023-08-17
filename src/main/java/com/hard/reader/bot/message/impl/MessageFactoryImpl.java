package com.hard.reader.bot.message.impl;

import com.hard.reader.bot.entity.table.User;
import com.hard.reader.bot.message.MessageFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

@Log4j2
@Component
public class MessageFactoryImpl implements MessageFactory {
	// TODO: 8/17/2023 add messages from configuration

	private final StringBuilder builder = new StringBuilder();

	private void clearBuilder() {
		builder.setLength(0);
	}

	public SendMessage buildStartMessage(Update update, User user) {
		clearBuilder();
		builder.append("Hello user: ")
				.append(update.getMessage().getFrom().getUserName())
				.append(", ")
				.append("your role is: ")
				.append(user.getReaderRole());
		return SendMessage.builder()
				.chatId(update.getMessage().getChatId())
				.text(builder.toString())
				.build();
	}
}
