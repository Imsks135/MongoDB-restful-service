package com.stackroute.news.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.stackroute.news.model.UserNews;
import com.stackroute.news.service.NewsService;
import com.stackroute.news.util.exception.NewsAlreadyExistsException;
import com.stackroute.news.util.exception.NewsNotFoundException;

@RestController
@RequestMapping("/news")
public class NewsController {

	@Autowired
	private NewsService newsService;

	@GetMapping("/")
	public String home() {
		return "Welcome to News MondoDBRestful Services";
	}

	@PostMapping("/news")
	public ResponseEntity<?> addUser(@RequestBody UserNews userNews) {
		ResponseEntity<?> entity;
		try {
			UserNews createdUser = newsService.addUser(userNews);
			if (createdUser != null) {
				entity = new ResponseEntity<UserNews>(createdUser, HttpStatus.CREATED);
			} else {
				entity = new ResponseEntity<String>("Error--User and news Not added", HttpStatus.CONFLICT);
			}
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Error" + e.getMessage(), HttpStatus.CONFLICT);
		}
		return entity;

	}

	@GetMapping("/news")
	public ResponseEntity<?> getAllUser() {
		ResponseEntity<?> entity = null;
		try {
			List<UserNews> newsList = newsService.getAllUser();
			entity = new ResponseEntity<List<UserNews>>(newsList, HttpStatus.OK);
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Error" + e.getMessage(), HttpStatus.CONFLICT);
		}
		return entity;
	}

	@GetMapping("/news/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable int userId) throws NewsNotFoundException {
		ResponseEntity<?> entity = null;
		try {
			UserNews userNews = newsService.getUserById(userId);
			if (userNews != null) {
				entity = new ResponseEntity<UserNews>(userNews, HttpStatus.OK);
			} else {
				entity = new ResponseEntity<String>("User not found with ID: " + userId, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			entity = new ResponseEntity<String>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return entity;
	}

	@DeleteMapping("/news/{userId}")
	public ResponseEntity<?> deleteProduct(@PathVariable("userId") int userId) {
		ResponseEntity<?> entity = null;
		boolean isDeleted = newsService.deleteUserById(userId);

		if (isDeleted) {
			entity = new ResponseEntity<>("user Id " + userId + " Deleted Successfully", HttpStatus.OK);
		} else {
			entity = new ResponseEntity<String>("item Not Exist...", HttpStatus.BAD_REQUEST);

		}
		return entity;
	}

	@PutMapping("/news/{id}")
	public ResponseEntity<?> updateUserNews(@PathVariable int id, @RequestBody UserNews updatedUserNews) {
	    ResponseEntity<?> entity = null;
	    try {  UserNews existingUserNews = newsService.getUserById(id);
	        
	        if (existingUserNews != null) {
	        entity = new ResponseEntity<UserNews>(updatedUserNews, HttpStatus.OK);
	        } else {
	           
	            throw new NewsAlreadyExistsException("User with ID " + id + " already exists.");
	        }
	    } catch (NewsAlreadyExistsException e) {
	        entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
	    } catch (Exception e) {
	        entity = new ResponseEntity<String>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	    return entity;
	}


}
