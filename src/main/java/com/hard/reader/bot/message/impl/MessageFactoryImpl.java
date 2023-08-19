package com.hard.reader.bot.message.impl;

import com.hard.reader.bot.entity.table.User;
import com.hard.reader.bot.message.MessageFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.hard.reader.bot.keyborad.factory.KeyboardMarkupFactory.createMenuMarkup;
import static com.hard.reader.bot.utils.additional.UpdateUtils.getChatId;
import static com.hard.reader.bot.utils.additional.UpdateUtils.getUserName;

@Log4j2
@Component
public class MessageFactoryImpl implements MessageFactory {
	// TODO: 8/17/2023 add messages from configuration

	private static final StringBuilder builder = new StringBuilder();

	private static void clearBuilder() {
		builder.setLength(0);
	}

	public SendMessage buildStartMessage(Update update, User user) {
		clearBuilder();
		builder.append("Hello user: ")
				.append(getUserName(update))
				.append(", ")
				.append("your role is: ")
				.append(user.getReaderRole());
		return SendMessage.builder()
				.chatId(getChatId(update))
				.text(builder.toString())
				.replyMarkup(createMenuMarkup())
				.build();
	}

	@Override
	public SendMessage buildMenuMessage(Update update) {
		clearBuilder();
		builder.append("Hi, ")
				.append(getUserName(update))
				.append(", what do you want to do today ?");
		return SendMessage.builder()
				.chatId(getChatId(update))
				.text(builder.toString())
				.replyMarkup(createMenuMarkup())
				.build();
	}
}
