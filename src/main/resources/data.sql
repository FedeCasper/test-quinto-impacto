INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('Juan', 'Perez', 'juan@gmail.com', '1234');
INSERT INTO tbl_administrators (id, departament) VALUES (1, 'administracion');

INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('María', 'Gonzalez', 'maria@gmail.com', '1234');
INSERT INTO tbl_profesors (id, course) VALUES (2, 'Java');

INSERT INTO tbl_users (name, last_Name, email, password) VALUES ('Ignacio', 'Lillo', 'ignacio@gmail.com', '1234');
INSERT INTO tbl_students (id, course, status, create_At) VALUES (3, 'Java', 'active', TIMESTAMP '2023-11-15 12:30:00');