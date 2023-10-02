package com.stackroute.news.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stackroute.news.model.UserNews;
import com.stackroute.news.repository.NewsRepository;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	@Override
	public List<UserNews> getAllUser() {
		// TODO Auto-generated method stub
		return newsRepository.findAll();

	}

	@Override
	public UserNews getUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<UserNews> optional = newsRepository.findById(userId);
		UserNews userNews = optional.isPresent() ? optional.get() : null;
		return userNews;

	}

	@Override
	public UserNews addUser(UserNews userNews) {
		// TODO Auto-generated method stub
		userNews.setPublishedAtForNews();
		UserNews createdUser = newsRepository.save(userNews);
		return createdUser;

	}

	@Override
	public boolean deleteUserById(int userId) {
		// TODO Auto-generated method stub
		Optional<UserNews> optional = newsRepository.findById(userId);
		boolean isDeleted = false;
		if (optional != null) {
			newsRepository.deleteById(userId);
			isDeleted = true;
		}
		return isDeleted;

	}

}
