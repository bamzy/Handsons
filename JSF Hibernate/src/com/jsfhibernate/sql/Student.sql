/* SQL Command To Create Database */
CREATE DATABASE IF NOT EXISTS jsfhibercrud;

/* SQL Command To Use The Database */
USE jsfhibercrud;

/* DROP Any Exisiting Table In The Database With Name As "Student" */
DROP TABLE IF EXISTS student;

/* SQL Command To Create The Table In A Database */
CREATE TABLE student (
	id int NOT NULL,
	Name VARCHAR(100) NOT NULL,
	Department VARCHAR(100) NOT NULL,
	PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;