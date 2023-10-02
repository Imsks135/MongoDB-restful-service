package com.stackroute.news.model;

import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class News {

	private int newsId;
	private String title;
	private String author;
	private String description;
	private Instant publishedAt =Instant.now();
	private String content;
	private String url;
	private String urlToImage;

}
