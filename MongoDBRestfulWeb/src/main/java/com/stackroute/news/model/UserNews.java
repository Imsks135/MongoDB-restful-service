package com.stackroute.news.model;

import java.time.Instant;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document
public class UserNews {

	@Id
	private int userId;
	private List<News> newsList;

	public void setPublishedAtForNews() {
		Instant currentTime = Instant.now();
		for(News news:newsList) {
			news.setPublishedAt(currentTime);
		}
    }
}
