# 🚀 Flight Reservation System  
A project where users can list movies, stars, and genres, as well as add movies to their favorites.

## **🛠️ Technologies Used**  
- **Spring Boot** – For backend development  
- **Spring Security** – For authentication and authorization  
- **JPA (Hibernate)** – For database management  
- **PostgreSQL** – As the database  

## **🔑 API Endpoints**  

| Method  | Endpoint | Description |
|---------|--------------------------------|------------------------------|
| **POST** | `/auth/register` | Register a new user |
| **POST** | `/auth/login` | User login |
| **GET**  | `/auth/verify` | Verify member |
| **GET** | `/films` | Get all films |
| **GET** | `/films/{id}` | Get film by ID |
| **GET** | `/films/by-genre` | Get film by genre  |
| **GET** | `/genres` | Get all genres |
| **POST** | `/{username}/favorites` | Add film to favorites |
| **GET** | `/{username}/favorites` | Get favorite films |
| **DELETE** | `/{username}/favorites/{filmId}` | Delete film from favorites |
| **GET** | `/stars` | Get all stars |
| **GET** | `/stars/{id}` | Get stars info |

## **👨‍💻 Berk Şener**  
🔗 [LinkedIn](https://www.linkedin.com/in/berksener)
