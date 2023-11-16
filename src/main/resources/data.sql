INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('Juan', 'Perez', 'juan@gmail.com', '1234');
INSERT INTO tbl_administrators (id, departament, status, create_At) VALUES (1, 'Mentoria', 'active', TIMESTAMP '2024-03-15 12:30:00');

INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('María', 'Gonzalez', 'maria@gmail.com', '1234');
INSERT INTO tbl_professors (id, course, status, create_At) VALUES (2, 'Javascript', 'active', TIMESTAMP '2024-11-15 12:30:00');

INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('Ignacio', 'Lillo', 'ignacio@gmail.com', '1234');
INSERT INTO tbl_students (id, course, status, create_At) VALUES (3, 'Java', 'active', TIMESTAMP '2023-11-15 12:30:00');

INSERT INTO tbl_courses(name, shift, status) VALUES ('Full Stack Java', 'Morning', 'active');
INSERT INTO tbl_courses(name, shift, status) VALUES ('Full Stack MERN', 'Afternoon', 'active');
INSERT INTO tbl_courses(name, shift, status) VALUES ('Web Developer', 'Night', 'active');