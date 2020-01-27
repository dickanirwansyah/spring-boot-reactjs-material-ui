create table leads(
    id int not null auto_increment,
    name varchar(45) not null,
    email varchar(45) not null,
    active boolean not null,
    constraint pk_leads_id primary key(id)
);

insert into leads(name, email, active) values
('Muhammad Dicka Nirwansyah', 'dickanirwansyah@gmail.com', true),
('Irma Khairunnisa', 'irma11@gmail.com', true),
('Ahmad Luthfi Yahya', 'luthfiyahya@gmail.com', false),
('Ahmad Alif Bahari', 'alifbahari@gmail.com', false);

select id, name, email from leads where active in (select active from leads where active=true) order by name asc;

--create SP
DELIMITER //
CREATE PROCEDURE getLeadsByEmail
(
    paramEmail varchar (45)
)
BEGIN
   select * from leads where email=paramEmail;
END //
DELIMITER ;


--split string
create table customer(
    id int auto_increment,
    name varchar(255),
    phones varchar(500),
    constraint pk_customer_id primary key (id)
);

insert into customer(name, phones) values('dicka nirwansyah', '02175906535,08788616532,086189992'),
('irma khairunnisa', '021878992929,07899929292');


create table trx_transaction(
    order_id int not null auto_increment,
    transaction_date date not null,
    customer_id int not null,
    constraint pk_trx_transaction_order_id primary key(order_id),
    constraint fk_trx_customer_id foreign key(customer_id) foreign key(customer_id)
);

create table trx_transaction_detail(
    order_id int not null,
    product_id int not null,
    qty_ordered
);

create table product(
    id int not null auto_increment,
    name varchar(45),
    price decimal(13, 4),
    category_id int not null,
    stock int not null,
    constraint pk_product_id primary key(id),
    constraint fk_product_id foreign key (category_id) references category(id)
);

create table category(
    id int not null auto_increment,
    name varchar(45),
    status int,
    constraint pk_category_id primary key(id)
);



insert into product(name, price, category_id, stock) values('maestro', 10000, 1, 10),
('smart kids', 20000, 3, 11), ('smart health', 30000, 2, 9);

insert into category(name, status) values('unit link', 1),
('kesehatan', 1), ('pendidikan', 0);


---BELAJAR QUERY MYSQL ---

create table orders(
    orderNumber int not null auto_increment,
    orderDate date,
    requiredDate date,
    shippedDate date,
    status varchar(45),
    comments varchar(45),
    customerNumber varchar(45),
    constraint pk_orders_orderNumber primary key (orderNumber)
);

INSERT INTO orders(orderDate, requiredDate, shippedDate, status, comments, customerNumber)
values('2020-01-01', '2020-01-02', '2020-01-21', 'shipped', 'ok', 1),
('2020-01-01', '2020-01-02', '2020-01-21', 'disputed', 'ok', 3),
('2020-01-02', '2020-01-04', '2020-01-19', 'cancel', 'not', 2),
('2020-01-01', '2020-01-02', '2020-01-21', 'in process', 'process', 4),
('2020-01-05', '2020-01-06', '2020-01-18', 'in process', 'process', 7),
('2020-01-01', '2020-01-06', '2020-01-11', 'on hold', 'hold', 6),
('2020-01-07', '2020-01-14', '2020-01-21', 'on hold', 'hold', 5),
('2020-01-08', '2020-01-10', '2020-01-15', 'shipped', 'ok', 9);

create table products(
    id int not null auto_increment,
    name varchar(45),
    status varchar(45),
    stock int,
    price_item decimal(14,3),
    constraint pk_product_id primary key (id)
);

INSERT INTO products (name, status, stock, price_item) values
('sabun scrub garnier', 'available', 100, 20000),
('masker nivea', 'available', 90, 13000),
('spray nivea for men', 'unavailable', 0, 50000),
('minoxidil liquid', 'available', 80, 150000),
('minoxidil foam', 'unavailable', 0, 250000),
('hairose', 'available', 30, 250000),
('biotin', 'unavailable', 0, 150000),
('tas namastudio', 'available', 2, 400000),
('sendal runo project', 'available', 3, 350000),
('sepatu docmart', 'unavailable', 0, 1000000),
('sepatu vans', 'unvailable', 0, 8500000);

create table orders_details(
    id int not null auto_increment,
    orderNumber int not null,
    productCode int not null,
    quantityOrdered int not null,
    priceEach decimal(13, 4),
    orderLineNumber int,
    constraint pk_orderDetails_id primary key (id),
    constraint fk_orderDetails_orderNumber foreign key(orderNumber) references orders(orderNumber),
    constraint fk_orderDetails_productCode foreign key(productCode) references products(id)
);

INSERT INTO orders_details(orderNumber, productCode, quantityOrdered, priceEach, orderLineNumber) values
(1, 1, 2, 40000, 1),
(1, 2, 3, 26000, 1),
(1, 2, 1, 50000, 1),
(2, 1, 2, 40000, 2),
(3, 6, 2, 500000, 3),
(3, 8, 1, 400000, 3),
(4, 1, 6, 120000, 4),
(4, 4, 1, 150000, 4),
(5, 8, 1, 400000, 5),
(6, 9, 1, 350000, 6),
(7, 6, 2, 500000, 7),
(7, 1, 3, 60000, 7),
(8, 2, 4, 52000, 8),
(9, 1, 10, 200000, 9),
(9, 4, 2, 300000, 9),
(9, 9, 1, 350000, 9);

-- show status and amount by orders
select o.status, sum(od.quantityOrdered * priceEach) as calculateTotal
from orders o inner join orders_details od on (o.orderNumber = od.orderNumber)
where o.status='cancel'
group by o.status;
