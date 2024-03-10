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

| Column name      | Type       | Description                                   |
|------------------|------------|-----------------------------------------------|
| id               | binary(16) | id key of row - unique, not null, primary key |
| user_info        | binary(16) | id personal information about the user        |         
| salary           | double     | manager's salary                              |                                   
| hire_date        | timestamp  | date of employment                            |
| termination_date | timestamp  | date of dismissal                             |

### Table Support Manager (Delivery's support managers)

| Column name      | Type        | Description                                   |
|------------------|-------------|-----------------------------------------------|
| id               | binary(16)  | id key of row - unique, not null, primary key |
| user_info        | binary(16)  | id personal information about the user        |         
| salary           | double      | support manager's salary                      |                                   
| status_employee  | varchar(60) | support manager's status                      |
| hire_date        | timestamp   | date of employment                            |
| termination_date | timestamp   | date of dismissal                             |                                                 

### Table Courier (Delivery's couriers)

| Column name      | Type        | Description                                   |
|------------------|-------------|-----------------------------------------------|
| id               | int         | id key of row - unique, not null, primary key |
| user_info        | binary(16)  | id personal information about the user        |         
| rating           | varchar(10) | courier's rating                              | 
| status_courier   | varchar(60) | courier's status                              | 
| salary           | double      | courier's salary                              | 
| status_employee  | varchar(60) | courier's status                              |
| hire_date        | timestamp   | date of employment                            |
| termination_date | timestamp   | date of dismissal                             | 

### Table Client (Delivery's clients)

| Column name       | Type        | Description                                   |
|-------------------|-------------|-----------------------------------------------|
| id                | binary(16)  | id key of row - unique, not null, primary key | 
| user_info         | binary(16)  | id personal information about the user        |         
| date_of_birth     | timestamp   | client's date of birth                        | 
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

### Table Menu (Restaurant's menu)

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

### Table UserInfo (User's info)

| Column name  | Type        | Description                                   |
|--------------|-------------|-----------------------------------------------|
| id           | binary(16)  | id key of row - unique, not null, primary key | 
| firstname    | varchar(50) | user's name                                   |
| lastname     | varchar(50) | user's last name                              | 
| email        | varchar(60) | user's email                                  |
| phone_number | varchar(20) | user's phone number                           | 
| username     | varchar(50) | user's username                               |
| password     | varchar(32) | user's password                               |
| role         | binary(16)  | user's roles                                  |
| updated_at   | timestamp   | date of update of user information            |

### Table Role (User's roles)

| Column name | Type        | Description                                   |
|-------------|-------------|-----------------------------------------------|
| 	id         | binary(16)  | id key of row - unique, not null, primary key | 
| 	role_name  | varchar(80) | role's title                                  | 
| 	authority  | binary(16)  | authority's id                                |
| updated_at  | timestamp   | date of update of role's information          |

### Table Authority (Role's authority)

| Column name | Type        | Description                                   |
|-------------|-------------|-----------------------------------------------|
| 	id         | binary(16)  | id key of row - unique, not null, primary key | 
| 	authority  | varchar(80) | name of authority                             | 
| 	role       | binary(16)  | role id                                       |
| updated_at  | timestamp   | date of update of authority's information     |

### Enums Status Courier

| Enum name                    | Description                                                                          |
|------------------------------|--------------------------------------------------------------------------------------|
| FREE                         | courier is available for ordering                                                    |
| GET_ORDER                    | the courier took the order                                                           |
| ON_THE_WAY_TO_THE_RESTAURANT | the courier accepted the order and goes to the restaurant                            |
| ON_THE_WAY_TO_THE_CLIENT     | the courier has picked up the order from the restaurant and is heading to the client |
| ARRIVED                      | the courier arrived to the client                                                    |

### Enums Status Employee

| Enum name   | Description                                             |
|-------------|---------------------------------------------------------|
| WORK        | employee is working                                     |
| NOTWORK     | the employee does not work (not his shift or a day off) |
| ON_VACATION | employee on vacation                                    |
| DISMISSED   | employee fired                                          |

### Enums Status Order

| Enum name        | Description                   |
|------------------|-------------------------------|
| AWAITING_PAYMENT | the order is awaiting payment |
| IN_PROGRESS      | the order is being fulfilled  |
| COMPLETED        | order completed               |

### Enums Rating

| Enum name | Description |
|-----------|-------------|
| STAR0     |             |
| STAR1     |             |
| STAR2     |             |
| STAR3     |             |
| STAR4     |             |
| STAR5     |             |
| STAR6     |             |
| STAR7     |             |
| STAR8     |             |
| STAR9     |             |
| STAR10    |             |


