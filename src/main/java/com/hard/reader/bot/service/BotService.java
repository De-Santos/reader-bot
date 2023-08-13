package com.hard.reader.bot.service;

import com.hard.reader.bot.entity.enums.internal.Callback;
import com.hard.reader.bot.keyborad.buttons.impl.HelloButton;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Log4j2
@Component
@RequiredArgsConstructor
public class BotService {

	public SendMessage echo(Update update) {
		log.info("Echo message: {}", update.getMessage().getText());
		String chatId = update.getMessage().getChatId().toString();
		String text = update.getMessage().getText();

		InlineKeyboardMarkup markup = new InlineKeyboardMarkup();
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		keyboard.add(Collections.singletonList(new HelloButton().get()));
		markup.setKeyboard(keyboard);

		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		message.setText("You said: " + text);
		message.setReplyMarkup(markup);
		return message;
	}

	public SendMessage sayHello(Update update) {
		log.info("Bot sad: 'hello'");
		SendMessage message = new SendMessage();
		message.setChatId(update.getCallbackQuery().getMessage().getChatId());
		message.setText(Callback.SAY_HELLO.getAction());
		return message;
	}
}
