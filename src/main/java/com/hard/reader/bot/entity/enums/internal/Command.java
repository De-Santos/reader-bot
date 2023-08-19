package com.hard.reader.bot.entity.enums.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Command {
	START("/start"),
	MENU("/menu");

	private final String action;
}
