package com.hard.reader.bot.entity.table;

import com.hard.reader.bot.entity.enums.ReaderRole;
import com.hard.reader.bot.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "bigint", nullable = false)
	private Long chatId;

	@OneToMany(mappedBy = "userId")
	private List<Report> reports;

	@Column(columnDefinition = "bool DEFAULT 'f'", nullable = false)
	private Boolean hasAdditionalLife;

	@Column(columnDefinition = "bool DEFAULT 't'", nullable = false)
	private Boolean isReader;

	@Enumerated
	@Column(columnDefinition = "int2 DEFAULT 0", nullable = false)
	private Role role;

	@Enumerated
	private ReaderRole readerRole;

	@Column(columnDefinition = "date", nullable = false)
	private LocalDate joinDate;

	@Column(columnDefinition = "int4 DEFAULT 0", nullable = false)
	private Integer totalMinutesRead;
}
