CREATE TABLE users
(
	id SERIAL PRIMARY KEY, 
	first_name CHARACTER VARYING(30) NOT NULL,
	last_name CHARACTER VARYING(30) NOT NULL,
	email CHARACTER VARYING(30) NOT NULL,
	password CHARACTER VARYING(20) NOT NULL,
	phone CHARACTER VARYING(15) NOT NULL
);

CREATE TABLE organizer
(
	id SERIAL PRIMARY KEY, 
	name CHARACTER VARYING(30) NOT NULL,
	email CHARACTER VARYING(30) NOT NULL,
	phone CHARACTER VARYING(15) NOT NULL,
	address CHARACTER VARYING(30) NOT NULL,
	description CHARACTER VARYING(150) NOT NULL
);

CREATE TABLE events
(
	id SERIAL PRIMARY KEY,
	name CHARACTER VARYING(30) NOT NULL,
	description CHARACTER VARYING(150) NOT NULL,
	date_time TIMESTAMP NOT NULL,
	location CHARACTER VARYING(10) NOT NULL,
	ticket_price NUMERIC(6,2)NOT NULL, 
	organizer_id int REFERENCES organizer(id)
);

CREATE TABLE reservation
(
	id SERIAL PRIMARY KEY,
	reserved_at TIMESTAMP,
	ticket_count int NOT NULL,
	total_price NUMERIC(10,2),
	status CHARACTER VARYING(10) NOT NULL,
	user_id int REFERENCES users(id), 
	event_id int REFERENCES events(id)
);

--INSERT INTO users (first_name, last_name, email, password, phone) 
--	VALUES ('Kate', 'Nova', 'kateN@gmail.com', '12345','+375291112233');
--INSERT INTO users (first_name, last_name, email, password, phone)  
--	VALUES ('Max', 'West', 'west1@gmail.com', '54321','+375293332211');
	
--SELECT * FROM users;

--INSERT INTO organizer (name, email, phone, address, description)
--	VALUES ('Company1', 'company1@gmail.com', '+375295554433', 'Street 1', 'Some text about the company1');
--INSERT INTO organizer (name, email, phone, address, description)
--	VALUES ('Company2', 'company2@gmail.com', '+375291234567', 'Street 33', 'Some text about the company2');

--SELECT * FROM organizer;

--INSERT INTO events (name, description, date_time, location, ticket_price, organizer_id)
--	VALUES ('Party1', 'Some text1', '2023/07/01 12:30:00', 'Minsk', 22.99, 1);
--INSERT INTO events (name, description, date_time, location, ticket_price, organizer_id)
--	VALUES ('Party2', 'Some text2', '2023/06/21 21:45:00', 'Minsk', 44.99, 2);
	
--SELECT * FROM events;

--INSERT INTO reservation (reserved_at, ticket_count, total_price, status, user_id, event_id)
--	VALUES (NOW(), 3, 3*22.99, 'Active', 1, 1);
--INSERT INTO reservation (reserved_at, ticket_count, total_price, status, user_id, event_id)
--	VALUES (NOW(), 1, 1*44.99, 'Сompleted', 2, 2);
	
--SELECT * FROM reservation;

--SELECT reservation.*, users.first_name FROM reservation INNER JOIN users ON users.id=reservation.user_id;
--SELECT reservation.*, events.name FROM reservation INNER JOIN events ON events.id=reservation.event_id;
--SELECT events.*, organizer.name FROM events INNER JOIN organizer ON organizer.id = events.organizer_id;