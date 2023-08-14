package com.hard.reader.bot.utils.assertion;

import com.hard.reader.bot.entity.enums.internal.Callback;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.Update;

@UtilityClass
public class Assertion {

	public static boolean isCommand(Update update) {
		if (!update.hasMessage()) return false;
		String text = update.getMessage().getText();
		return text.startsWith("/");
	}

	public static boolean isTextMessage(Update update) {
		return update.hasMessage() && update.getMessage().hasText();
	}

	public static boolean isMessage(Update update) {
		if (!update.hasMessage()) return false;
		String text = update.getMessage().getText();
		return !text.startsWith("/");
	}

	public static boolean isCallBackQuery(Update update) {
		return update.hasCallbackQuery();
	}

	public static boolean isThisCallback(Callback callback, Update update) {
		if (!update.hasCallbackQuery()) return false;
		return callback.getAction().equals(update.getCallbackQuery().getData());
	}
}
