-- staff
INSERT INTO staff (staff_id, first_name, last_name, certifications, position) VALUES('100','Jessica', 'Rabbit', 'dog training', 'dog feeder');
INSERT INTO staff (staff_id, first_name, last_name, certifications, position) VALUES('101','Roger', 'Rabbit', 'small animal training', 'rodent caretaker');

-- customers
INSERT INTO customers (customer_id, first_name, last_name, occupation, hours_at_home) VALUES ('1', 'Luna', 'Nightmare','Princess of the Night', 12);

-- dogs
INSERT INTO animals (animal_id, species, name, breed, color, status, activity_level, goodWithKids, getsAlongWithOtherAnimals, grooming, health, diet) values('D01','dog','SCOUT', 'terrior mix', 'Tan and Black', 'adoptable', 10, 'yes', 'no', 5, 'Quite active and healthy', 'Perfers Beneiful dry dog food, one bowl in the morning and another before bed.');
INSERT INTO animals (animal_id, species, name, breed, color, status, activity_level, goodWithKids, getsAlongWithOtherAnimals, grooming, health, diet) VALUES('D02','dog', 'TOBY', 'cocker spainel', 'golden with white underbelly', 'adoptable', 5, 'yes', 'yes', 8, 'Perfers playing inside but enjoys walks around the block', 'Perfers dry dog food, one bowl in the morning and one before bed');
INSERT INTO animals (animal_id, species, name, breed, color, status, activity_level, goodWithKids, getsAlongWithOtherAnimals, grooming, health, diet) VALUES('D03','dog', 'POOH', 'maltipoo mix', 'white with black ear', 'adoptable',8, 'yes', 'yes', 10, 'Is quite healthy but does have seizures but they are infrequent', 'Enjoys dry dog food prefers IAMS brand, feed one bowl in the morning and another before bed');

-- cats
INSERT INTO animals (animal_id, species, name, breed, color, status, activity_level, goodWithKids, getsAlongWithOtherAnimals, grooming, health, diet) VALUES('C01','cat', 'ELLIE', 'domestic shorthair', 'black', 'adopted', 4, 'yes', 'no', 6, 'a bit over weight needs to go on diet food', 'Feed only science diet indoor cat food to maintain healthy weight, one scoop in the morning and one before bed.');