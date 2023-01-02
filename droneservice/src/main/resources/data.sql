drop table if exists drones;
drop table if exists medications;

create table `drones` (
    id int AUTO_INCREMENT primary key,
    serial_number varchar(100) unique,
    `model` varchar(100),
    `weight_limit` decimal(10,3),
    `battery_percentage` decimal(10, 3),
    `state`varchar(100),
    `medications` varchar(100)
)
