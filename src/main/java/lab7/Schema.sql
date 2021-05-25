
create table Author (id serial PRIMARY KEY,name text,patronymic text,lastName text);
create table Book (id serial PRIMARY KEY,Author_id integer references Author(id),section text,title,dateOfPublishing date,price integer );
create table Library (id serial PRIMARY KEY,book_id integer references Book(id),titleOfLibrary text);
create table Person (id serial PRIMARY KEY,name text,patronymic text,lastName text);


