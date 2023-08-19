package com.hard.reader.bot.entity.enums.internal;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Callback {
	EXIT("exit"),
	STEP_BACK("back"),
	SAY_HELLO("hello"),
	HELP("help"),
	CREATE_REPORT("create report");

	private final String action;
}
