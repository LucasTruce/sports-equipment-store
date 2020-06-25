drop table if exists storedb.roles_privileges;
drop table if exists storedb.privilege;
drop table if exists storedb.user_roles;
drop table if exists storedb.role;
drop type if exists storedb.roleName;
drop table if exists storedb.users;
drop table if exists storedb.product;
drop table if exists storedb.product_category;

create type storedb.roleName as enum ('ROLE_ADMIN', 'ROLE_USER');
create table storedb.role(id bigint not null generated by default as identity (increment 1 start 3), role_name storedb.roleName, primary key (id));
create table storedb.users(id bigint not null generated by default as identity (increment 1 start 3), account_expired boolean, account_locked boolean, credentials_expired boolean, email varchar(255), enabled boolean not null , password varchar(255), username varchar(255), constraint users_pkey primary key (id));
create table storedb.user_roles(user_id bigint not null, role_id bigint not null, constraint user_id_fkey foreign key (user_id) references storedb.users (id) match simple on update no action on delete cascade, constraint role_id_fkey foreign key (role_id) references storedb.role (id) match simple on update no action on delete cascade);
create table storedb.privilege(id bigint not null generated  by default as identity (increment 1 start 1), name varchar(255), primary key (id));
create table storedb.roles_privileges(role_id bigint not null, privilege_id bigint not null, constraint role_id_fkey foreign key (role_id) references storedb.role (id) match simple on update no action on delete cascade , constraint privilege_id_fkey foreign key (privilege_id) references storedb.privilege (id) match simple on update no action on delete cascade );
create table storedb.product_category(id bigint not null generated by default as identity (increment 1 start 3), name varchar(255), primary key (id));
create table storedb.product(id bigint not null generated by default as identity (increment 1 start 6),name varchar(255),description varchar(255),unit_price float,image_url varchar(255),active boolean,units_in_stock int,date_created date, last_updated date, category_id bigint not null, primary key (id), constraint category_fkey foreign key (category_id) references storedb.product_category (id) match simple on update no action on delete cascade );

insert into storedb.role(id, role_name) values (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');
insert into storedb.users(id, username, password, email, enabled,account_expired, credentials_expired, account_locked) values (1, 'admin', '$2a$10$1MCvXZ31oYf3w6kC2svDLuFL78chu4kSZg4Uzq4P1caKYHDAz/v4e', 'admin@gmail.com', true, false, false, false), (2, 'user', '$2a$10$C1dDHVnBXzFbAZ4BhuiFb.8e8Z4irndJ1gC0PIRhHY3YUYDT0/Pf2', 'user@gmail.com', true, false, false, false);
insert into storedb.user_roles(user_id, role_id) values (1,1), (2,2);
insert into storedb.privilege(id, name) values (1, 'can_read'), (2, 'can_update'), (3, 'can_write'), (4, 'can_delete');
insert into storedb.roles_privileges(role_id, privilege_id) values (1, 1), (1,2), (1,3), (1,4), (2,1), (2,2);

insert into storedb.product_category(id, name) values (1, 'Odzież'), (2, 'Sprzęt sportowy');
insert into storedb.product(id, name, description, unit_price, image_url, active, units_in_stock, date_created, last_updated, category_id) values (1, 'Kurtka', 'Some quick example text to build on the card title and make up the bulk of the card''s content.', 25.99, 'https://res.cloudinary.com/verdoux/image/upload/v1593001550/mkyqn9vy4f57vk0yq6pd.png', true, 5, NULL, NULL, 1), (2, 'Buty', 'Some quick example text to build on the card title and make up the bulk of the card''s content.', 59.99, 'https://res.cloudinary.com/verdoux/image/upload/v1593001550/mkyqn9vy4f57vk0yq6pd.png', true, 5, NULL, NULL, 1), (3, 'Spodnie', 'Some quick example text to build on the card title and make up the bulk of the card''s content.', 33.33, 'https://res.cloudinary.com/verdoux/image/upload/v1593001550/mkyqn9vy4f57vk0yq6pd.png', true, 2, NULL, NULL, 1), (4, 'Czapka', 'Some quick example text to build on the card title and make up the bulk of the card''s content.', 14.99, 'https://res.cloudinary.com/verdoux/image/upload/v1593001550/mkyqn9vy4f57vk0yq6pd.png', true, 20, NULL, NULL, 1), (5, 'Kij do gry w golfs', 'Some quick example text to build on the card title and make up the bulk of the card''s content.', 59.99, 'https://res.cloudinary.com/verdoux/image/upload/v1593001550/mkyqn9vy4f57vk0yq6pd.png', true, 33, NULL, NULL, 2);



