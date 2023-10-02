package com.stackroute.news.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.stackroute.news.model.UserNews;

@Repository
public interface NewsRepository extends MongoRepository<UserNews,Integer>{


}
