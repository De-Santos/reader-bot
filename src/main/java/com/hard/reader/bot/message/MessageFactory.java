package com.hard.reader.bot.message;

import com.hard.reader.bot.entity.table.User;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface MessageFactory {
	SendMessage buildStartMessage(Update update, User user);
}
