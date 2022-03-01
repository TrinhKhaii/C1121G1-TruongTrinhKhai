use classicmodels;

select * from customers where customerName = 'Land of Toys Inc.';
explain select * from customers where customerName = 'Land of Toys Inc.';

alter table customers add index customers_name_idx(customerName);
explain select * from customers where customerName = 'Land of Toys Inc.';

alter table customers add index full_name_idx(contactFirstName, contactLastName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';

alter table customers drop index full_name_idx;