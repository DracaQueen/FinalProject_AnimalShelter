drop table if exists adoption_form;
drop table if exists animals;
drop table if exists staff;
drop table if exists customers;

CREATE TABLE customers
(customer_id int AUTO_INCREMENT NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
spouse VARCHAR(50),
children int,
occupation VARCHAR(50) NOT NULL,
hours_at_home int NOT NULL,
notes TEXT,
Primary key (customer_id)
);
CREATE TABLE staff
( staff_id int  AUTO_INCREMENT NOT NULL,
first_name VARCHAR(50) NOT NULL,
last_name VARCHAR(50) NOT NULL,
certifications VARCHAR(50),
duties VARCHAR(50) NOT NULL,
PRIMARY KEY (staff_id)
);
CREATE TABLE animals
(animal_id VARCHAR(50),
name VARCHAR(50) NOT NULL,
species VARCHAR(50) NOT NULL,
breed VARCHAR(50) NOT NULL,
color VARCHAR(50) NOT NULL,
health TEXT NOT NULL,
history TEXT ,
diet TEXT NOT NULL,
status enum('adoptable', 'not_ready', 'adopted') NOT NULL,
activity_level INT,
goodWithKids enum ('yes','no'),
getsAlongWithOtherAnimals enum ('yes', 'no'),
grooming int,
likes TEXT,
dislikes TEXT,
PRIMARY KEY (animal_id)
);
CREATE TABLE adoption_form
(form_id int AUTO_INCREMENT NOT NULL,
customer_id int,
species VARCHAR(50),
activity_level INT,
likes TEXT,
dislikes TEXT,
goodWithKids enum ('Yes','No'),
getsAlongWithOtherAnimals enum ('Yes', 'No'),
PRIMARY KEY (form_id),
foreign key (customer_id) references customers (customer_id) ON DELETE CASCADE
);

