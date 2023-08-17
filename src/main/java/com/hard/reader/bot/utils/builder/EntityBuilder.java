package com.hard.reader.bot.utils.builder;

import com.hard.reader.bot.entity.enums.ReaderRole;
import com.hard.reader.bot.entity.enums.Role;
import com.hard.reader.bot.entity.enums.State;
import com.hard.reader.bot.entity.table.User;
import com.hard.reader.bot.utils.additional.UpdateUtils;
import lombok.experimental.UtilityClass;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.time.LocalDate;

@UtilityClass
public class EntityBuilder {
	public static User build(Update update) {
		return User.builder()
				.id(UpdateUtils.getChatId(update))
				.hasAdditionalLife(false)
				.isReader(true)
				.role(Role.USER)
				.readerRole(ReaderRole.NONE)
				.joinDate(LocalDate.now())
				.totalMinutesRead(0)
				.state(State.MENU)
				.build();
	}
}
