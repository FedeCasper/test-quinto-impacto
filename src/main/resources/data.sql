INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('Juan', 'Perez', 'juan@gmail.com', '{bcrypt}$2a$10$X8AY4e8m1E/XGoneeV8dA.JHHE3kJvZV2et5clidE2ksMt4bDTXvC');
INSERT INTO tbl_administrators (id, departament, status, user_rol, create_At) VALUES (1, 'Mentoria', 'active', 'ADMIN', TIMESTAMP '2024-03-15 12:30:00');

INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('María', 'Gonzalez', 'maria@gmail.com', '{bcrypt}$2a$10$X8AY4e8m1E/XGoneeV8dA.JHHE3kJvZV2et5clidE2ksMt4bDTXvC');
INSERT INTO tbl_professors (id, course, status, user_rol, create_At) VALUES (2, 'Javascript', 'active', 'PROFESSOR', TIMESTAMP '2024-11-15 12:30:00');

INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('Ignacio', 'Lillo', 'ignacio@gmail.com', '{bcrypt}$2a$10$X8AY4e8m1E/XGoneeV8dA.JHHE3kJvZV2et5clidE2ksMt4bDTXvC');
INSERT INTO tbl_students (id, status, user_rol, create_At) VALUES (3, 'active', 'STUDENT', TIMESTAMP '2023-11-15 12:30:00');

INSERT INTO tbl_courses(name, shift, status) VALUES ('Full Stack Java', 'Morning', 'active');
INSERT INTO tbl_courses(name, shift, status) VALUES ('Full Stack MERN', 'Afternoon', 'active');
INSERT INTO tbl_courses(name, shift, status) VALUES ('Web Developer', 'Night', 'active');