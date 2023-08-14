package com.hard.reader.bot.entity.table;


import com.hard.reader.bot.entity.enums.ReportType;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "report_surveys")
public class ReportSurvey {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "int2 DEFAULT -1", nullable = false)
	private Short position;

	@Column(columnDefinition = "char(100)", nullable = false)
	private String definition;

	@Column(nullable = false)
	private String question;

	@Column(columnDefinition = "bool DEFAULT 't'", nullable = false)
	private Boolean active;

	@Enumerated
	@Column(columnDefinition = "int2 DEFAULT 0", nullable = false)
	private ReportType reportType;
}
