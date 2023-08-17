package com.hard.reader.bot.utils.additional;

import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.Update;

@UtilityClass
public class UpdateUtils {
	public static Long getChatId(Update update) {
		if (update.hasMessage()) {
			return update.getMessage().getChatId();
		} else if (update.hasCallbackQuery()) {
			return update.getCallbackQuery().getMessage().getChatId();
		} else {
			throw new IllegalArgumentException("Could not get chatId");
		}
	}
}
