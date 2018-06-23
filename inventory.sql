DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS inventory;
CREATE TABLE accounts(
	id INTEGER PRIMARY KEY AUTO_INCREMENT,
	username VARCHAR(255) NOT NULL,
	role VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	status VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL, 
	repassword VARCHAR(255)NOT NULL,
	date VARCHAR(255)NOT NULL);
ALTER TABLE accounts AUTO_INCREMENT=1001;
CREATE TABLE inventory(
	list_price INTEGER NOT NULL,
	sale_price INTEGER NOT NULL,
	house_type VARCHAR(255) NOT NULL,
	lot_area INTEGER NOT NULL,
	bedroom INTEGER NOT NULL,
	toilet INTEGER NOT NULL,
	carport VARCHAR(255),
	balcony VARCHAR(255),
	available INTEGER);

INSERT INTO accounts ( username, role, email, status, password, repassword, date ) VALUES ( 'kenneth', 'Admin', 'kennethparo1598@gmail.com', 'Active', '12345', '12345', 'June 19, 2018');
INSERT INTO accounts ( username, role, email, status, password, repassword, date ) VALUES ( 'vincent', 'Engineer','vincentparo@gmail.com', 'Active', '123', '123', 'June 19, 2018');
INSERT INTO accounts ( username, role, email, status, password, repassword, date ) VALUES ( 'kennethvincent', 'Accounting Personnel', 'kennethvincent@gmail.com', 'Active', '12345' , '12345', 'June 19, 2018');
INSERT INTO accounts ( username, role, email, status, password, repassword, date ) VALUES ( 'kennethparo', 'Marketing Personnel', 'kennethparo@gmail.com', 'Active', '1234' , '1234', 'June 19, 2018');

INSERT INTO inventory ( list_price , sale_price , house_type , lot_area , bedroom, toilet, carport, balcony, available ) VALUES ( 1350000 , 1550000 , 'Single Firewall' , 66 , 2, 1, "Provision", "None", 19 );
INSERT INTO inventory ( list_price , sale_price , house_type , lot_area , bedroom, toilet, carport, balcony, available ) VALUES ( 1050000 , 1400000 , 'Town house' , 44 , 2, 1, "None", "None", 28 );
INSERT INTO inventory ( list_price , sale_price , house_type , lot_area , bedroom, toilet, carport, balcony, available ) VALUES ( 2700000 , 3000000 , 'Single Firewall' , 99 , 4, 3, "Provision", "None", 19 );
