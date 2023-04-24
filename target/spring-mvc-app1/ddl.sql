DROP table if exists employees;
CREATE TABLE employees(
                       id int auto_increment primary key,
                       name varchar(40) NOT NULL,
                       surname varchar(40) not null ,
                       phone varchar(14) not null,
                       email varchar(100),
                       position varchar(40) not null
);

INSERT INTO employees (name, surname, phone, email, position) VALUES ('Taras', 'Gerasymchuk', '+380502224545', 'yaubirossetu-9015@yopmail.com', 'Manager');
INSERT INTO employees (name, surname, phone, email, position) VALUES ('Oleg', 'Voloshyn', '+380678989546', 'foiddiffixebro-1832@yopmail.com', 'Youtuber');
INSERT INTO employees (name, surname, phone, email, position) VALUES ('Alex', 'Tarasov', '+380978787546', 'tafruffaudoippa-5747@yopmail.com', 'Director');