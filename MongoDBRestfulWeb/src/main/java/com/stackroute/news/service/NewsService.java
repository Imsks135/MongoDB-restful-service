package com.stackroute.news.service;

import java.util.List;
import com.stackroute.news.model.UserNews;

public interface NewsService {
	
	public List<UserNews> getAllUser();

	public UserNews getUserById(int userId);

	public UserNews addUser(UserNews userNews);

	public boolean deleteUserById(int userId);

}
