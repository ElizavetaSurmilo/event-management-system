CREATE SCHEMA IF NOT EXISTS event_manager_schema;

CREATE TABLE IF NOT EXISTS event_manager_schema.user
(
	id SERIAL PRIMARY KEY,
	first_name CHARACTER VARYING(30) NOT NULL,
	last_name CHARACTER VARYING(30) NOT NULL,
	email CHARACTER VARYING(30) NOT NULL,
	password CHARACTER VARYING(20) NOT NULL,
	phone CHARACTER VARYING(15) NOT NULL
);

CREATE TABLE IF NOT EXISTS event_manager_schema.organizer
(
	id SERIAL PRIMARY KEY,
	name CHARACTER VARYING(30) NOT NULL,
	email CHARACTER VARYING(30) NOT NULL,
	phone CHARACTER VARYING(15) NOT NULL,
	address CHARACTER VARYING(30) NOT NULL,
	description CHARACTER VARYING(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS event_manager_schema.event
(
	id SERIAL PRIMARY KEY,
	name CHARACTER VARYING(30) NOT NULL,
	description CHARACTER VARYING(150) NOT NULL,
	date_time TIMESTAMP NOT NULL,
	location CHARACTER VARYING(10) NOT NULL,
	ticket_price NUMERIC(6,2)NOT NULL, 
	organizer_id int REFERENCES event_manager_schema.organizer(id)
);

CREATE TABLE IF NOT EXISTS event_manager_schema.reservation
(
	id SERIAL PRIMARY KEY,
	reserved_at TIMESTAMP,
	ticket_count int NOT NULL,
	total_price NUMERIC(10,2),
	status CHARACTER VARYING(10) NOT NULL,
	user_id int REFERENCES event_manager_schema.user(id),
	event_id int REFERENCES event_manager_schema.event(id)
);