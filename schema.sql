drop table if exists person;
drop table if exists category;
drop table if exists expense;
drop table if exists balance;
drop table if exists bill;
create extension if not exists "uuid-ossp";

create table person(
  id uuid default uuid_generate_v4() primary key,
  name varchar not null,
  email varchar unique not null,
  salary decimal(10,2),
  salary_due_date date,
  password varchar(255) not null,
  createdAt timestamp not null default current_timestamp
);

create table category(
  id uuid default uuid_generate_v4() primary key,
  person_id UUID not null,
  name varchar(100) not null,
  isValid boolean,
  percentage int,
  createdAt timestamp not null default current_timestamp,
  constraint fk_user foreign key (person_id) references person(id)
);

create table bill(
  id uuid default uuid_generate_v4() primary key,
  person_id UUID not null,
  month int not null,
  value DECIMAL(10,2) not null,
  dueDate date not null,
  parcel int,
  createdAt timestamp not null default current_timestamp,
  constraint fk_user foreign key (person_id) references person(id)
);

drop type if exists expense_type;
create type expense_type as enum ('FIXED', 'MUTABLE');

create table expense(
  id uuid default uuid_generate_v4() primary key,
  person_id UUID not null,
  category_id UUID,
  bill_id UUID,
  expense_type expense_type not null default 'MUTABLE',
  value DECIMAL(10,2) not null,
  dueDate date,
  month int not null,
  isPaid boolean default false,
  createdAt timestamp not null default current_timestamp,
  constraint fk_user foreign key (person_id) references person(id),
  constraint fk_category foreign key (category_id) references category(id),
  constraint fk_bill foreign key (bill_id) references bill(id)
);

create table balance(
  id uuid default uuid_generate_v4() primary key,
  person_id UUID not null,
  month int not null,
  value DECIMAL(10,2) not null,
  createdAt timestamp not null default current_timestamp,
  constraint fk_user foreign key (person_id) references person(id)
);
