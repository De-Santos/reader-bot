package com.hard.reader.bot.entity.table;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "reports")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User userId;

	@Column(columnDefinition = "bool", nullable = false)
	private Boolean isLast; // TODO: 8/12/2023 add trigger function in database

	@Column(columnDefinition = "int8")
	private Long bookId; // TODO: 8/11/2023 add liquibase script: constraint that where will be only existed id in books

	@Column(columnDefinition = "text", nullable = false)
	private String reportData;

	@Column(columnDefinition = "time")
	private LocalDateTime time;
}
