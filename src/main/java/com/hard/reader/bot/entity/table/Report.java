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

	@Column(columnDefinition = "jsonb", nullable = false)
	private String reportData;

	@Column(columnDefinition = "time")
	private LocalDateTime time;
}
