package com.hard.reader.bot.entity.table;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "char(128)", nullable = false)
	private String name;

	@Column(columnDefinition = "char(128)", nullable = false)
	private String author;

	@ManyToMany
	private List<Tag> tags;

	@Column(columnDefinition = "char(500)")
	private String description;

	@Column(columnDefinition = "int4 DEFAULT 0", nullable = false)
	private Integer likes;

	@Column(columnDefinition = "int4 DEFAULT 0", nullable = false)
	private Integer dislikes;

	@Column(columnDefinition = "tsvector")
	private String txt;
}
