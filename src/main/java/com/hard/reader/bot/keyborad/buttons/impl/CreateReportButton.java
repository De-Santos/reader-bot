package com.hard.reader.bot.keyborad.buttons.impl;

import com.hard.reader.bot.entity.enums.internal.Callback;
import com.hard.reader.bot.keyborad.buttons.InlineButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;


public class CreateReportButton implements InlineButton {

	private static final InlineKeyboardButton BUTTON = new InlineKeyboardButton();

	private static final String NAME = "New report";
	private static final Callback CALLBACK = Callback.CREATE_REPORT;

	@Override
	public Callback getCallback() {
		return CALLBACK;
	}

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	public InlineKeyboardButton get() {
		BUTTON.setText(NAME);
		BUTTON.setCallbackData(CALLBACK.getAction());
		return BUTTON;
	}
}
