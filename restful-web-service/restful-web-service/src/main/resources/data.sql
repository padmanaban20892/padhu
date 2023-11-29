//CREATE TABLE users_details  (ID int NOT NULL PRIMARY KEY, name varchar(255), dob varchar(255));
insert into users_details(id,name,dob,area) values(1,'kannan',current_date(),'CH');
insert into users_details(id,name,dob,area) values(2,'ashok',current_date(),'BAN');
insert into users_details(id,name,dob,area) values(3,'mohan',current_date(),'TN');



insert into post(id,user_id,description) values(1,2,'Want to learn Code');
insert into post(id,user_id,description) values(2,3,'Want to learn Code C+');
insert into post(id,user_id,description) values(3,1,'Want to learn  Java');