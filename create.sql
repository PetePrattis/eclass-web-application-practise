CREATE TABLE courses(
	course_code TEXT NOT NULL,
    AM INTEGER NOT NULL,
	department TEXT NOT NULL
);

CREATE TABLE grades(
	uname TEXT NOT NULL,
	AM INTEGER NOT NULL,
    department TEXT NOT NULL,
	course_code TEXT NOT NULL,
	grade INTEGER  
);

CREATE TABLE professors(
	uname TEXT NOT NULL,
	fname TEXT NOT NULL,
	sname TEXT NOT NULL,
	AM INTEGER NOT NULL 
);

CREATE TABLE secretaries(
	uname TEXT NOT NULL,
	fname TEXT NOT NULL,
	sname TEXT NOT NULL,
	AM INTEGER NOT NULL 
);

CREATE TABLE students(
	uname TEXT NOT NULL,
	fname TEXT NOT NULL,
	sname TEXT NOT NULL,
	department TEXT NOT NULL,
	AM INTEGER NOT NULL 
);

CREATE TABLE usercounter(
	counter INTEGER NOT NULL
);

COPY courses FROM 'C:\Users\Panagiotis Prattis\Desktop\courses.csv'
WITH(FORMAT CSV, DELIMITER ',', HEADER);

COPY grades FROM 'C:\Users\Panagiotis Prattis\Desktop\grades.csv'
WITH(FORMAT CSV, DELIMITER ',', HEADER);

COPY professors FROM 'C:\Users\Panagiotis Prattis\Desktop\professorsfile.csv'
WITH(FORMAT CSV, DELIMITER ',', HEADER);

COPY secretaries FROM 'C:\Users\Panagiotis Prattis\Desktop\secretariesfile.csv'
WITH(FORMAT CSV, DELIMITER ',', HEADER);

COPY students FROM 'C:\Users\Panagiotis Prattis\Desktop\studentsfile.csv'
WITH(FORMAT CSV, DELIMITER ',', HEADER);

COPY usercounter FROM 'C:\Users\Panagiotis Prattis\Desktop\usercounter.csv'
WITH(FORMAT CSV, DELIMITER ',', HEADER);