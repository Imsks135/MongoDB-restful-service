

## Seed code - NewzApp Assignment

### Problem Statement

In this case study NewsService, We will build rest API which uses Mongodb embedded documents and perform CRUD


### Steps to be followed:

    Step 1: Add relevant dependencies in pom.xml file. 
    Step 2: Use NewsServiceDB in mongo
    Step 3: Write code for model class.
	    - News class should have below field
	 * (newsId,title,author,description,publishedAt,content,url,urlToImage)
	 This class should also contain the getters and setters for the 
	 * fields along with the no-arg , parameterized	constructor and toString method.
	 * The value of publishedAt should not be accepted from the user but should be
	 * always initialized with the system date.

	    -UserNews  class should have two fields (userId, newslist).Out of these two fields,
	 * the field userId should be annotated with @Id.


    Step 4: Write code for NewsRepository if needed.
    step 5: build  Service interface and class methods
    step 6: build exception classes.
    step 7:  build code for NewsController class based on instructions.
 



### Project structure

The folders and files you see in this repositories, is how it is expected to be in projects, which are submitted for automated evaluation by Hobbes

    Project
	|
	├── com.stackroute.news
	|	    └── NewsServiceApplication.java               // Spring boot's main class
	├──
	├── com.stackroute.news.controller
	|		└── NewsController.java                       // This class is responsible for processing all requests related to News and builds an appropriate model and passes it to the view for rendering.

	├── com.stackroute.news.model
	|		└── News.java                                 
	|		                       
	|		└── UserNews.java                             // This class will be used as the data model.
	├── com.stackroute.news.repository
	|		└── NewsRepository.java                       // This class is implementing the MongoRepository interface for News Repository
	├── com.stackroute.news.service
	|		└── NewsService.java                          // This interface contains all the behaviours of NewsRepository
	|		└── NewsServiceImpl.java                      // This class implements the NewsService interface. This class has to be annotated with @Service annotation.
	├── com.stackroute.news.util.exception
	|		└── NewsAlreadyExistsException.java           // This class implements custom exception
	|		└── NewsNotFoundException.java                // This class implements custom exception
	├── src/main/resources
	|		└── application.properties                               // This file contains all the properties for Database Connectivity
	|	
	

### Important instructions for Participants
> - We expect you to write the assignment on your own by following through the guidelines, learning plan, and the practice exercises
> - The code must not be plagirized, the mentors will randomly pick the submissions and may ask you to explain the solution
> - The code must be properly indented, code structure maintained as per the boilerplate and properly commented
> - Follow through the problem statement shared with you

### Further Instructions on Release

*** Release 0.1.0 ***

- Right click on the Assignment select Run As -> spring boot app to run your Assignment.
