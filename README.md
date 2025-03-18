# E-Commerce Backend System

## Project Overview
This project is a backend system for an e-commerce clothing store, built using **Spring Boot** and **MySQL**. It provides RESTful APIs for user authentication, product management, cart operations, order processing, and category management.

## Tech Stack
- **Backend:** Spring Boot (Java)
- **Database:** MySQL
- **Frontend:** React with Tailwind CSS
- **Tools:** Eclipse IDE, Postman (for testing APIs)

## Features
- **User Authentication** (Login, Register, Role-based access control)
- **Product Management** (CRUD operations for products and categories)
- **Cart Management** (Add, Remove, View cart items)
- **Order Processing** (Place orders, Retrieve order history)
- **Product Variants** (Size, Color selection)

## Database Schema
### Tables & Relationships
1. **Users Table** (`users`)
   - `id` (Primary Key)
   - `name`
   - `email` (Unique)
   - `password`
   - `role` (USER, ADMIN, SUPER_ADMIN)

2. **Categories Table** (`categories`)
   - `id` (Primary Key)
   - `name`

3. **Products Table** (`products`)
   - `id` (Primary Key)
   - `name`
   - `description`
   - `price`
   - `category_id` (Foreign Key referencing `categories`)

4. **Product Variants Table** (`product_variants`)
   - `id` (Primary Key)
   - `product_id` (Foreign Key referencing `products`)
   - `size`
   - `color`
   - `stock`

5. **Cart Items Table** (`cart_items`)
   - `id` (Primary Key)
   - `user_id` (Foreign Key referencing `users`)
   - `product_variant_id` (Foreign Key referencing `product_variants`)
   - `quantity`

6. **Orders Table** (`orders`)
   - `id` (Primary Key)
   - `user_id` (Foreign Key referencing `users`)
   - `total_price`
   - `status` (Processing, Shipped, Delivered)

7. **Order Items Table** (`order_items`)
   - `id` (Primary Key)
   - `order_id` (Foreign Key referencing `orders`)
   - `product_variant_id` (Foreign Key referencing `product_variants`)
   - `quantity`
   - `price`

## API Endpoints
### User Authentication
(To be implemented)

### Product Management
| Method | Endpoint                         | Description                        |
|--------|----------------------------------|------------------------------------|
| `GET`  | `/api/products`                 | Retrieve all products             |
| `GET`  | `/api/products/category/{id}`   | Retrieve products by category ID  |
| `POST` | `/api/products`                 | Add a new product                 |
| `GET`  | `/api/products/{id}`            | Retrieve a product by ID          |
| `PUT`  | `/api/products/{id}`            | Update a product by ID            |
| `DELETE` | `/api/products/{id}`         | Delete a product by ID            |

### Category Management
| Method | Endpoint              | Description               |
|--------|-----------------------|---------------------------|
| `GET`  | `/api/categories`     | Retrieve all categories   |
| `POST` | `/api/categories`     | Add a new category        |

### Cart Management
| Method   | Endpoint                | Description                  |
|----------|-------------------------|------------------------------|
| `GET`    | `/api/cart/{userId}`     | Retrieve cart items for a user |
| `POST`   | `/api/cart/add`          | Add an item to the cart      |
| `DELETE` | `/api/cart/remove/{id}`  | Remove an item from the cart |

### Order Management
| Method   | Endpoint           | Description                  |
|----------|--------------------|------------------------------|
| `POST`   | `/api/orders`      | Create a new order          |
| `GET`    | `/api/orders/{id}` | Retrieve an order by ID     |

### Product Variants
| Method   | Endpoint                            | Description                            |
|----------|-------------------------------------|----------------------------------------|
| `GET`    | `/api/product-variants`            | Retrieve all product variants         |
| `GET`    | `/api/product-variants/product/{id}` | Retrieve variants by product ID       |
| `POST`   | `/api/product-variants`            | Add a new product variant             |

## Setup & Installation
### Prerequisites
- Java 17+
- MySQL database
- Eclipse IDE / IntelliJ IDEA
- Postman (for API testing)
- Node.js & npm (for frontend setup)

### Steps to Run the Backend
1. Clone the repository
   ```bash
   git clone https://github.com/your-repo-url.git
   ```
2. Navigate to the backend folder
   ```bash
   cd backend
   ```
3. Configure `application.properties` with MySQL credentials
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce
   spring.datasource.username=root
   spring.datasource.password=password
   ```
4. Run the Spring Boot application
   ```bash
   mvn spring-boot:run
   ```

### Steps to Run the Frontend
1. Navigate to the frontend folder
   ```bash
   cd frontend
   ```
2. Install dependencies
   ```bash
   npm install
   ```
3. Start the frontend development server
   ```bash
   npm run dev
   ```

## Future Enhancements
- Implement JWT Authentication for secure API access
- Add Payment Integration (Stripe, Razorpay)
- Implement Order Tracking
- Admin Dashboard for managing products and orders

## License
This project is licensed under the MIT License.

