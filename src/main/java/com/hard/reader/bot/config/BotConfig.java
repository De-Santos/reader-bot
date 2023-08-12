package com.hard.reader.bot.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ComponentScan
public class BotConfig {
	@Value("${bot.token}")
	private String token;
	@Value("${bot.name}")
	private String botName;
}
