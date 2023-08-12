package com.hard.reader.bot.entity.table;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tags")
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "char(55)", unique = true, nullable = false)
	private String name;

	@Column(columnDefinition = "tsvector")
	private String txt;
}
