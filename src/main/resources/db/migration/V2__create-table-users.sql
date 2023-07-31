CREATE TABLE users_api_mobile(
   id int identity primary key,
   login varchar(150) NOT NULL,
   password varchar(80) NOT NULL,
   role varchar(50) NOT NULL
);