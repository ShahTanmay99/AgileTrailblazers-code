Environment: Spring MVC, Swagger, JPA, Hibernate, Mysql.

SpringMVC: Initializer.java and ApplicationInitializer.java are the main files where the configuration files are linked

            Initializer.java:- Contains Servlet mapping and Api starting path.

            SwaggerConfig.java :- Defines Configuration details for swagger. As for API documentation,
                                    I am using Swagger which is tool used for API Documentation

            JPAConfig.java:- I have used Java Persistence API for Java specification for accessing,
                             persisting, and managing data between Java objects / classes and a relational database.
                             application.properties files in resources folder consists specific hibernate properties which I mapped in JPAConfig.java.

            Application Stack:-
                Application consists of 3 layers :- Database layer, Service Layer and Data Access layer.

                When application gets initialized, our endpoints will be ready. We can send any wheather update to /weather Endpoint.
                Weather details will be stored in MySQl localhost. We can also use cloud service like AWS RDS for storing our data.
                We just need to change application.properties file in resources folder. When we send our data to our end-pont it will pass
                from several layers before storing it into our Database. When we link to any of our enpoint it will select end-point based
                on value we provided above each method. After selecting the value, it will look for method to which it is associated.
                It will go through service layer for necessary validation, because it is good practice to verify before persisting data to database.
                After validation, it will pass through repository layer, which is responsible for talking with our Database.

                Entity:- It contains classes which will define POJO for structuring API.
                Controller:- WeatherController.java class is annotated with "@controller", and is responsible for mapping endpoints.
                            According to defination, I have created 2 endpoints /weather for adding weather deatils and
                            /weather/lat1={latitude1}&lon1={longitude1}&lat2={latitude2}&lon2={longitude2} for comparing weather of two cities.
                            Both endpoint will return WeatherDetails object, which consist name, tempreture and co-ordinates of city.
                            Initially, we will need to insert few weather details using /weather endpoint. I did these using Postman, which is a tool
                            used for testing API's.
                Exception:- It contains java files for throwing necessary exception. We have two of that BadRequestException
                            and NotFoundException.
                Repository:- Layer which directly talks with Database. I have used named queries for finding city with required latitude and
                            longitude.

                To run the application, one needs to make configuration settings. I have used Tomcat9 as a server, one needs to
                add war artifact to server configuration. Also need to setup MySql server with a schema named 'weather', because we
                have specified our schema name in application.properties file. After configuring settings, we need to run our application.
                During the time of compilation Spring will mp our endpoints and methods associated with it, if everything goes right we will
                see a log which says "artifact deployed successfully" and our application will be running successfully on localhost:8000

                Use Postman to test endpoints which we have mapped. Because we cannot test POST request in browser, it does not allow us to send
                body.

                We can also deploy our application in AWS environment using ElasticBeanstalk service offered by AWS. It have many
                use cases, we can scale our application whenever we want, we can scale and add more web servers if any particular threshold
                is met using AWS CloudWatch service. One can send notification whenever resource is added, removed, exhausted or under used using
                AWS SNS service. Use of Elastic Load Balancer will distribute workload across available web servers evenly.


