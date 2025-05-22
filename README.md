# quizApplication (Spring Boot)

This is a REST-based Quiz Application built using **Spring Boot** and **MySQL**. It allows users to generate quizzes by selecting categories and difficulty levels, attempt them, and view results.

## ✨ Features
- Add, update, delete quiz questions
- Create quizzes dynamically with selected filters
- Retrieve quiz questions for attempting
- Submit answers and get evaluated results
- Error handling and status codes

## 🛠 Technologies Used
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Lombok
- Maven

## 📁 Project Structure
- `model/` – Entity classes like `Question`, `Quiz`, `QuestionWrapper`
- `repository/` – JPA Repositories for DB access
- `service/` – Business logic for quiz and question handling
- `controller/` – REST endpoints for client interaction

## 🚀 Getting Started
1. Clone the repository  
2. Configure MySQL database in `application.properties`  
3. Run the Spring Boot application  
4. Use Postman to test the APIs

## 📬 API Endpoints
- `POST /question/add` – Add a new question
- `POST /quiz/create` – Create a quiz by category and difficulty
- `GET /quiz/get/{id}` – Get quiz questions
- `POST /quiz/submit/{id}` – Submit answers and get score

## 🧪 Sample Data
Use provided SQL scripts or Postman collections to add sample data.

## 🙌 Author
Shivani Borate  
GitHub: [borateshivani](https://github.com/borateshivani)
