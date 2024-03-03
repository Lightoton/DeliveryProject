# Delivery project [Backend]

Data consist of departments, managers, clients, couriers, support_managers, orders, restaurants, menu, categories,
foods.
___

## Links...
___

## Database structure

### Table Department (Delivery's departments table )

| Column name        | Type        | Description                                   |
|--------------------|-------------|-----------------------------------------------|
| id                 | int         | id key of row - unique, not null, primary key | 
| manager_id         | binary(16)  | manager id                                    |
| support_manager_id | binary(16)  | support_manager's id                          |
| courier_id         | binary(16)  | courier's id                                  |
| client_id          | binary(16)  | client's id                                   |
| order_id           | binary(16)  | order's id                                    | 
| address            | varchar(80) | department's address                          |
| restaurant_id      | binary(16)  | restaurant's id                               |                                
| created_at         | timestamp   | timestamp of row creation                     |
| updated_at         | timestamp   | timestamp of last update                      |

### Table Manager (Delivery's managers table)

| Column name      | Type        | Description                                   |
|------------------|-------------|-----------------------------------------------|
| id               | binary(16)  | id key of row - unique, not null, primary key |
| first_name       | varchar(50) | manager's name                                |         
| last_name        | varchar(50) | manager's last name                           |                              
| salary           | double      | manager's salary                              |                                   
| phone_number     | varchar(20) | manager's phone number                        |                          
| email            | varchar(60) | manager's email                               |
| hire_date        | timestamp   | date of employment                            |
| termination_date | timestamp   | date of dismissal                             |

### Table Support Manager (Delivery's support managers)

| Column name      | Type        | Description                                   |
|------------------|-------------|-----------------------------------------------|
| id               | binary(16)  | id key of row - unique, not null, primary key |
| first_name       | varchar(50) | support manager's name                        |         
| last_name        | varchar(50) | support manager's last name                   |                              
| salary           | double      | support manager's salary                      |                                   
| phone_number     | varchar(20) | support manager's phone number                |                          
| email            | varchar(60) | support manager's email                       |
| status_employee  | varchar(60) | support manager's status                      |
| hire_date        | timestamp   | date of employment                            |
| termination_date | timestamp   | date of dismissal                             |                                                 |

### Table Courier (Delivery's couriers)

| Column name      | Type        | Description                                   |
|------------------|-------------|-----------------------------------------------|
| id               | int         | id key of row - unique, not null, primary key |
| first_name       | varchar(50) | courier's name                                |         
| last_name        | varchar(50) | courier's last name                           | 
| rating           | varchar(10) | courier's rating                              | 
| status_courier   | varchar(60) | courier's status                              | 
| salary           | double      | courier's salary                              | 
| email            | varchar(60) | courier's email                               |
| phone_number     | varchar(20) | courier's phone number                        |
| status_employee  | varchar(60) | courier's status                              |
| hire_date        | timestamp   | date of employment                            |
| termination_date | timestamp   | date of dismissal                             | 

### Table Client (Delivery's clients)

| Column name       | Type        | Description                                   |
|-------------------|-------------|-----------------------------------------------|
| id                | binary(16)  | id key of row - unique, not null, primary key | 
| first_name        | varchar(50) | client's name                                 |         
| last_name         | varchar(50) | client's last name                            | 
| date_of_birth     | timestamp   | client's date of birth                        | 
| email             | varchar(60) | client's email                                |
| phone_number      | varchar(20) | client's phone number                         | 
| rating            | varchar(10) | client's rating                               |
| address           | varchar(80) | client's address                              |
| registration_date | timestamp   | timestamp of row creation                     | 

### Table Order (Delivery's orders)

| Column name         | Type       | Description                                   |
|---------------------|------------|-----------------------------------------------|
| 	id                 | binary(16) | id key of row - unique, not null, primary key | 
| 	restaurant_id      | binary(16) | restaurant's id                               | 
| 	client_id          | binary(16) | client's id                                   | 
| 	support_manager_id | binary(16) | support manager's id                          | 
| 	courier_id         | binary(16) | courier's id                                  |
| 	status_order       | varchar    | order's status                                |
| 	final_amount       | double     | order's amount                                |
| 	created_at         | timestamp  | timestamp of row creation                     |
| 	updated_at         | timestamp  | timestamp of row creation                     |

### Table Restaurant (Delivery's restaurants)

| Column name        | Type        | Description                                     |
|--------------------|-------------|-------------------------------------------------|
| 	id                | binary(16)  | id key of row - unique, not null, primary key   | 
| 	title             | varchar(80) | restaurant's id                                 | 
| 	address           | varchar(80) | restaurant's address                            | 
| 	menu_id           | binary(16)  | menu's id                                       | 
| 	registration_date | timestamp   | date of registration in the delivery department |

### Table Menu (Restaurant's menus)

| Column name       | Type        | Description                                   |
|-------------------|-------------|-----------------------------------------------|
| 	id               | binary(16)  | id key of row - unique, not null, primary key | 
| 	title            | varchar(80) | menu's title                                  | 
| 	average_price    | double      | menu's average price                          | 
| 	category_food_id | binary(16)  | category food id's id                         | 
| 	created_at       | timestamp   | menu creation date                            |

### Table Category Food (Menu's categories of food)

| Column name | Type        | Description                                   |
|-------------|-------------|-----------------------------------------------|
| 	id         | binary(16)  | id key of row - unique, not null, primary key | 
| 	title      | varchar(80) | category's title                              |
| 	food_id    | binary(16)  | food's id                                     | 
| 	created_at | timestamp   | category creation date                        |

### Table Food (Restaurant's foods)

| Column name           | Type        | Description                                   |
|-----------------------|-------------|-----------------------------------------------|
| 	id                   | binary(16)  | id key of row - unique, not null, primary key | 
| 	title                | varchar(80) | food's title                                  | 
| 	calorie              | varchar(80) | food's calorie                                | 
| 	price                | binary(16)  | food's id                                     | 
| 	finishing_cooking_at | timestamp   | time when the food will be prepared           | 
| 	created_at           | timestamp   | date the food was added to the menu           |