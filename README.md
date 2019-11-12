# poll-management-restful
Poll management RESTful service
To launch the project
1. Clone the project from github.
2. Create 'poll-management' schema(database) on your PostreSQL.
3. If PostgreSQL is not installed on your localhost, please, change the ip of database in 'resources/application.properties file of the project for your db's ip address.
4. Build with maven 'mvn clean package' command.
5. From the project's 'target' directory launch the project with command java -jar name-of-the-built-file.jar
On startup Liquibase creates two empty working tables - 'poll' and 'polls_questions'
6. To see the API of the application launch Swagger: http://localhost:8080/swagger-ui.html
7. Perform requests using http client (e.g Postman or the like).
!!!ATTENTION!!!
For POST /createpoll 
and PUT /update/{pollId} 
for request BODY use such json structure:
{
   "questions":[

{"question":"question-oneMORE", "displayOrder": 1},
{"question":"question-twoMORE", "displayOrder": 2},
{"question":"question-threeMORE", "displayOrder": 3}
		],
  "pollName":"pollname one",
   "startDate":"2012-10-10",
   "endDate":"2012-10-10",
	  "active" : true
}


Request bodies generated by Swagger are not valid

