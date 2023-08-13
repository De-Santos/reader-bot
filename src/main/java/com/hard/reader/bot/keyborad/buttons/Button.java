package com.hard.reader.bot.keyborad.buttons;

import com.hard.reader.bot.entity.enums.internal.Callback;

public interface Button {
	Callback getCallback();

	String getName();
}
