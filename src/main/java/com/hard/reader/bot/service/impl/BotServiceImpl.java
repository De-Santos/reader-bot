package com.hard.reader.bot.service.impl;

import com.hard.reader.bot.dao.UserRepository;
import com.hard.reader.bot.entity.enums.internal.Callback;
import com.hard.reader.bot.entity.table.User;
import com.hard.reader.bot.message.MessageFactory;
import com.hard.reader.bot.service.BotService;
import com.hard.reader.bot.utils.builder.EntityBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.hard.reader.bot.keyborad.factory.KeyboardMarkupFactory.createHelloMarkup;
import static com.hard.reader.bot.utils.additional.UpdateUtils.getChatId;

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

		SendMessage message = new SendMessage();
		message.setChatId(chatId);
		message.setText("You said: " + text);
		message.setReplyMarkup(createHelloMarkup());
		return message;
	}

	public SendMessage sayHello(Update update) {
		log.info("Bot sad: 'hello'");
		SendMessage message = new SendMessage();
		message.setChatId(update.getCallbackQuery().getMessage().getChatId());
		message.setText(Callback.SAY_HELLO.getAction());
		return message;
	}

	public SendMessage getStart(Update update) {
		log.info("Call start command by chatId: {}", getChatId(update));
		return messageFactory.buildStartMessage(update, saveUserIfNotExists(update));
	}

	@Override
	public SendMessage getMenu(Update update) {
		log.info("Call menu command by chatId: {}", getChatId(update));
		return messageFactory.buildMenuMessage(update);
	}

	public User saveUserIfNotExists(Update update) {
		return userRepository.findById(getChatId(update))
				.orElseGet(() -> userRepository.save(EntityBuilder.build(update)));
	}
}
