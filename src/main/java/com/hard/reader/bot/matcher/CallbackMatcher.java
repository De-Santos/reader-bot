package com.hard.reader.bot.matcher;


import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface CallbackMatcher extends Matcher<SendMessage, Update> {
	SendMessage match(Update update);
}
