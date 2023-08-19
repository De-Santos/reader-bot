package com.hard.reader.bot.keyborad.factory;

import com.hard.reader.bot.keyborad.buttons.impl.CreateReportButton;
import com.hard.reader.bot.keyborad.buttons.impl.HelloButton;
import com.hard.reader.bot.keyborad.buttons.impl.HelpButton;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@UtilityClass
public class KeyboardMarkupFactory {

	private static final InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

	private static final CreateReportButton CREATE_REPORT_BUTTON = new CreateReportButton();
	private static final HelpButton HELP_BUTTON = new HelpButton();

	private static final HelloButton HELLO_BUTTON = new HelloButton(); // test button

	public static InlineKeyboardMarkup createMenuMarkup() {
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		keyboard.add(List.of(CREATE_REPORT_BUTTON.get()));
		keyboard.add(List.of(HELP_BUTTON.get()));
		markup.setKeyboard(keyboard);
		return markup;
	}

	public static InlineKeyboardMarkup createHelloMarkup() {
		List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
		keyboard.add(Collections.singletonList(HELLO_BUTTON.get()));
		markup.setKeyboard(keyboard);
		return markup;
	}
}
