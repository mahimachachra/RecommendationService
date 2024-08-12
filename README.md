Prerequisites :
1. Install and setup the require applications. 
   1. Java 17 installed and setup
   2. PostgreSQL (14 version)
   3. Maven
2. Pre-Load the database with the set of videos.
   1. Execute the data.sql file in the resources to create table, indexes and insert the data. 
   2. Once you fetch the videos records data would look like this :
![img.png](img.png)
3. Build your application using mvn clean build
   ![img_1.png](img_1.png)
4. Deploy your application using RecommendationService-1.0-SNAPSHOT.jar
   ![img_2.png](img_2.png)
5. Use postman to hit your local application.
   ![img_3.png](img_3.png)
6. Please find the sample postman collection in the src/main/resources