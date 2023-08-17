package com.hard.reader.bot.service.impl;

import com.hard.reader.bot.dao.UserRepository;
import com.hard.reader.bot.entity.enums.internal.Callback;
import com.hard.reader.bot.entity.table.User;
import com.hard.reader.bot.keyborad.buttons.impl.HelloButton;
import com.hard.reader.bot.message.MessageFactory;
import com.hard.reader.bot.service.BotService;
import com.hard.reader.bot.utils.additional.UpdateUtils;
import com.hard.reader.bot.utils.builder.EntityBuilder;
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
public class BotServiceImpl implements BotService {

	private final UserRepository userRepository;
	private final MessageFactory messageFactory;

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

	public SendMessage start(Update update) {
		final Long chatId = UpdateUtils.getChatId(update);
		log.info("Create new user by start command by chatId: {}", chatId);
		return messageFactory.buildStartMessage(update, saveUserIfNotExists(update));
	}

	public User saveUserIfNotExists(Update update) {
		return userRepository.findById(UpdateUtils.getChatId(update))
				.orElseGet(() -> userRepository.save(EntityBuilder.build(update)));
	}
}
