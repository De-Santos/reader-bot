package com.hard.reader.bot.entity.table;

import com.hard.reader.bot.entity.enums.ReaderRole;
import com.hard.reader.bot.entity.enums.Role;
import com.hard.reader.bot.entity.enums.State;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(columnDefinition = "bigint", unique = true, nullable = false)
	private Long id; // chatId in the telegram

	@OneToMany(mappedBy = "userId", fetch = FetchType.LAZY)
	private List<Report> reports;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> readBooks;

	@ManyToMany(fetch = FetchType.LAZY)
	private List<Book> wishBooks;

	@Column(columnDefinition = "bool DEFAULT 'f'", nullable = false)
	private Boolean hasAdditionalLife;

	@Column(columnDefinition = "bool DEFAULT 't'", nullable = false)
	private Boolean isReader;

	@Enumerated
	@Column(columnDefinition = "int2 DEFAULT 0", nullable = false)
	private Role role;

	@Enumerated
	@Column(columnDefinition = "int2 DEFAULT 0", nullable = false)
	private ReaderRole readerRole;

	@Column(columnDefinition = "date", nullable = false)
	private LocalDate joinDate;

	@Column(columnDefinition = "int4 DEFAULT 0", nullable = false)
	private Integer totalMinutesRead;

	@Enumerated
	@Column(columnDefinition = "int2 DEFAULT 0", nullable = false)
	private State state;

	@Column(columnDefinition = "int2 DEFAULT -1", nullable = false)
	private Short surveyPosition;

}
