create table tbl_transaction(
    id int auto_increment,
    status_transaction_id int not null,
    name varchar(45) not null,
    constraint pk_tbl_transaction primary key(id)
);

insert into tbl_transaction(status_transaction_id, name)
values(1, 'dickanirwansyah'),(1, 'irmakhnisa'), (2, 'ahmadluthfiyahya'),(3,'sabrinatsaqila');

create table tbl_status_transaction(
    id int auto_increment,
    name varchar(45),
    constraint pk_tbl_status_transaction_id primary key(id)
);

select
    tt.id,
        case
        when tst.id = 1 then 'transaction is success'
        when tst.id = 2 then 'transaction is cancel'
        when tst.id = 3 then 'transaction is onprogress'
        end as status,
    tt.name
from tbl_transaction tt
left join tbl_status_transaction tst
on tt.status_transaction_id = tst.id;

insert into tbl_status_transaction(name) values('success'),('cancel'),('onprogress');

create table status(
    id int auto_increment,
    name varchar(45),
    constraint pk_status_id primary key(id)
);

insert into status(name) values ('available'),('unavailable');

create table categoryInsurance(
    id int auto_increment,
    name varchar(45),
    flag_active varchar(45),
    created_at date,
    updated_at date,
    constraint pk_categsory_id primary key(id)
);

create table productInsurance(
    id int auto_increment,
    name varchar(45),
    category_insurance_id int,
    status_id int,
    constraint pk_product_insurance_id primary key(id)
);

-- SP --

DELIMITER $$
CREATE PROCEDURE getSPListStatus()
BEGIN
SELECT id, name from status;
END $$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE getSPStatusById(paramId INTEGER)
BEGIN
SELECT id, name from status where id=paramId;
END $$
DELIMITER;

DELIMITER $$
CREATE PROCEDURE getSPStatusByName(paramName VARCHAR(45))
BEGIN
SELECT id, name from status where name=paramName;
END $$
DELIMITER;

-- store procedure categoryInsurance
DELIMITER $$
CREATE PROCEDURE getSPListCategoryInsurance()
BEGIN
SELECT id, name, flag_active as flagActive, created_at as createdAt, updated_at as updatedAt FROM categoryInsurance;
END $$
DELIMITER;

--learn sql--
create table tbl_customers(
    customer_id int auto_increment,
    customer_name varchar(45),
    contact_name varchar(45),
    address varchar(45),
    city varchar(45),
    postal_code varchar(45),
    country varchar(45),
    constraint pk_tbl_customers_id primary key(customer_id)
);

--pengertian union
--gabungan antar 2 atau lebih table yang dimana fieldnya memilki value atau kemiripan data

insert into tbl_customers(customer_name, contact_name, address, city, postal_code, country)
values
('nadyamudrika', '098878292929', 'ciawi', 'bogor', '12450', 'indonesia'),
('sendifirdaus', '09828298292', 'chelsea', 'chelsea', '13450', 'london'),
('jamilah', '08727282828', 'liverpool', 'liverpool', '13451', 'london');


create table tbl_suppliers(
    supplier_id int auto_increment,
    supplier_name varchar(45),
    contact_name varchar(45),
    address varchar(45),
    city varchar(45),
    postal_code varchar(45),
    country varchar(45),
    constraint pk_tbl_suppliers_id primary key(supplier_id)
);

insert into tbl_suppliers(supplier_name, contact_name, address, city, postal_code, country)
values
('soniahasna', '098282982929', 'berlin', 'berlin', '12431', 'germany'),
('samsul', '098627287272', 'porto', 'porto', '12777', 'portugal'),
('sheilamajid', '098292929292', 'madrid', 'madrid', '12355', 'spanyol');

---create procedure calculation age yyyy-MM-dd --
DELIMITER $$
CREATE PROCEDURE determineAgess(IN birthDate DATE)
BEGIN
    SELECT FLOOR(DATEDIFF(NOW(), DATE(birthdate))/365) as USIA;
END $$
DELIMITER ;

--####################################### STORE PROCEDURE #################################

--store procedure tbl_trx--
create table tbl_trx(
    id int auto_increment,
    trxdate date,
    income_id int,
    status varchar(45),
    constraint pk_tbl_trx_id primary key(id),
    constraint fk_tbl_trx_income_id foreign key(income_id) references tbl_income(id)
);

DELIMITER $$
CREATE PROCEDURE spTrx()
BEGIN

    update tbl_trx as trx inner join tbl_income as tbi on trx.income_id = tbi.id
    set trx.status = case
        when tbi.status='avg income' then 'OK'
        when tbi.status='low income' then 'NOT OK'
        end;

    select
        trx1.id,
        trx1.trxdate,
        trx1.status,
        ti1.name,
        case
            when ti1.status = 'avg income' then 'un rejected'
            when ti1.status = 'low income' then 'rejected'
            end as value
        from tbl_trx trx1 join tbl_income ti1 on trx1.income_id = ti1.id;

END $$

---############################# store procedure ##################################

--store procedure tbl_income--
create table tbl_income(
    id int auto_increment,
    name varchar(45),
    income double,
    status varchar(45),
    constraint pk_tbl_income_id primary key(id)
);

--create procedure--
DELIMITER $$
CREATE PROCEDURE spIf(
in variableName varchar(45), in variableIncome double
)
begin

    declare statusVariable varchar(45);

     if variableIncome <= 6000000
        then set statusVariable = 'low income';
     elseif variableIncome > 6000000
        then set statusVariable = 'avg income';
     else
        set statusVariable = 'hight income';
     end if;

     insert into tbl_income(name, income, status) values (variableName, variableIncome, statusVariable);

end $$
