CREATE TABLE video (
video_id SERIAL PRIMARY KEY,
title VARCHAR(255) NOT NULL,
description TEXT,
author VARCHAR(255),
url VARCHAR(255) NOT NULL,
views INT NOT NULL DEFAULT 0
);

CREATE INDEX idx_views ON video(views);

INSERT INTO video (title, description, author, url, views) VALUES ('Introduction to Spring Boot', 'Learn the basics of Spring Boot framework.', 'Jane Doe', 'http://example.com/spring-boot-intro', 1500);
INSERT INTO video (title, description, author, url, views) VALUES ('Advanced Spring Boot Features', 'Explore advanced features of Spring Boot.', 'John Smith', 'http://example.com/spring-boot-advanced', 800);
INSERT INTO video (title, description, author, url, views) VALUES ('Building REST APIs with Spring', 'A complete guide to building REST APIs using Spring.', 'Emily Johnson', 'http://example.com/rest-api-spring', 2300);
INSERT INTO video (title, description, author, url, views) VALUES ('Spring Boot and Hibernate Integration', 'Learn how to integrate Spring Boot with Hibernate.', 'Linda Wilson', 'http://example.com/spring-hibernate', 1200);
INSERT INTO video (title, description, author, url, views) VALUES ('Microservices Architecture with Spring Boot', 'A comprehensive guide to microservices with Spring Boot.', 'Chris Evans', 'http://example.com/microservices-spring', 500);
INSERT INTO video (title, description, author, url, views) VALUES ('Building Web Applications with Spring MVC', 'Learn how to build web applications using Spring MVC.', 'Sarah Davis', 'http://example.com/spring-mvc', 950);
INSERT INTO video (title, description, author, url, views) VALUES ('Testing Spring Boot Applications', 'Best practices for testing Spring Boot applications.', 'James Garcia', 'http://example.com/testing-spring-boot', 400);
