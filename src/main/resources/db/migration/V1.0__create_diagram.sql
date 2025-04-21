SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE SCHEMA IF NOT EXISTS `freedb_hotel-utp` DEFAULT CHARACTER SET utf8mb4;

USE `freedb_hotel-utp`;

CREATE TABLE `freedb_hotel-utp`.`status` (
                          `id` integer PRIMARY KEY,
                          `uuid` char(36) UNIQUE,
                          `description` varchar(100),
                          `active` integer,
                          `created_by` varchar(15),
                          `created_at` timestamp,
                          `last_modified_by` varchar(15),
                          `last_modified_at` timestamp
);


CREATE TABLE `freedb_hotel-utp`.`room_type` (
                             `id` integer PRIMARY KEY,
                             `uuid` char(36) UNIQUE,
                             `description` varchar(100),
                             `active` integer,
                             `created_by` varchar(15),
                             `created_at` timestamp,
                             `last_modified_by` varchar(15),
                             `last_modified_at` timestamp
);


CREATE TABLE `freedb_hotel-utp`.`rol` (
                       `id` integer PRIMARY KEY,
                       `uuid` char(36) UNIQUE,
                       `code` varchar(50),
                       `description` varchar(100),
                       `active` integer,
                       `created_by` varchar(15),
                       `created_at` timestamp,
                       `last_modified_by` varchar(15),
                       `last_modified_at` timestamp
);


CREATE TABLE `freedb_hotel-utp`.`users` (
                         `id` integer PRIMARY KEY,
                         `uuid` char(36) UNIQUE,
                         `document_number` varchar(15) UNIQUE,
                         `full_name` varchar(150),
                         `phone` varchar(15),
                         `email` varchar(100),
                         `password` varchar(250),
                         `status_id` integer NOT NULL,
                         `active` integer,
                         `created_by` varchar(15),
                         `created_at` timestamp,
                         `last_modified_by` varchar(15),
                         `last_modified_at` timestamp
);

CREATE TABLE `freedb_hotel-utp`.`users_role` (
                              `id` integer PRIMARY KEY,
                              `uuid` char(36) UNIQUE,
                              `user_id` integer NOT NULL,
                              `rol_id` integer NOT NULL,
                              `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);


CREATE TABLE `freedb_hotel-utp`.`hotel` (
                         `id` integer PRIMARY KEY,
                         `uuid` char(36) UNIQUE,
                         `category` int,
                         `address` varchar(150),
                         `location` varchar(100),
                         `status_id` integer NOT NULL,
                         `active` integer,
                         `created_by` varchar(15),
                         `created_at` timestamp,
                         `last_modified_by` varchar(15),
                         `last_modified_at` timestamp
);

CREATE TABLE `freedb_hotel-utp`.`hotel_room` (
                              `id` integer PRIMARY KEY,
                              `uuid` char(36) UNIQUE,
                              `hotel_id` integer NOT NULL,
                              `room_type_id` integer NOT NULL,
                              `room_number` integer,
                              `price_per_hour` decimal(10,2),
                              `price_per_night` decimal(10,2),
                              `is_reserved` integer,
                              `status_id` integer NOT NULL,
                              `active` integer,
                              `created_by` varchar(15),
                              `created_at` timestamp,
                              `last_modified_by` varchar(15),
                              `last_modified_at` timestamp
);

ALTER TABLE `freedb_hotel-utp`.`users` ADD CONSTRAINT `user_posts` FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `freedb_hotel-utp`.`users_role` ADD CONSTRAINT `user_roles_user` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`);

ALTER TABLE `freedb_hotel-utp`.`users_role` ADD CONSTRAINT `user_roles_rol` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);

ALTER TABLE `freedb_hotel-utp`.`hotel` ADD FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `freedb_hotel-utp`.`hotel_room` ADD FOREIGN KEY (`status_id`) REFERENCES `status` (`id`);

ALTER TABLE `freedb_hotel-utp`.`hotel_room` ADD FOREIGN KEY (`hotel_id`) REFERENCES `hotel` (`id`);

ALTER TABLE `freedb_hotel-utp`.`hotel_room` ADD FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`);


INSERT  INTO `freedb_hotel-utp`.`status` (`id`, `uuid`, `description`, `active`, `created_by`, `created_at`)
VALUES (1, '55a744e6-49f5-4b24-9bb8-96379274cdbd', 'Activo', 1, 'admin', CURRENT_TIMESTAMP),
       (2, '77d2623c-8bb0-418a-bc09-5c277f80aa93', 'Inactivo', 0, 'admin', CURRENT_TIMESTAMP);

INSERT  INTO `freedb_hotel-utp`.`room_type` (`id`, `uuid`, `description`, `active`, `created_by`, `created_at`)
VALUES (1, 'cc96e3cb-ebf6-4fa7-8496-47764590679c', 'Habitación individual', 1, 'admin', CURRENT_TIMESTAMP),
       (2, 'f02be042-95f5-4ce3-b7cd-efa0406e2545', 'Habitación doble estándar (una cama doble)', 0, 'admin', CURRENT_TIMESTAMP),
       (3, '26f2bf93-5f23-4380-a96e-b680fae07ba4', 'Habitación doble estándar (dos camas separadas)', 0, 'admin', CURRENT_TIMESTAMP),
       (4, '00d78805-b95b-4e9d-92ef-908d58e9fa9b', 'Habitación doble deluxe', 0, 'admin', CURRENT_TIMESTAMP),
       (5, '183b580d-2eea-4422-9a00-e4fe0d675185', 'Suite júnior', 0, 'admin', CURRENT_TIMESTAMP),
       (6, '90aef3b6-9915-40c4-b69b-be5c9e380145', 'Suite ejecutiva', 0, 'admin', CURRENT_TIMESTAMP),
       (7, '7c03ee78-b6d9-4c06-8c81-bba5e6cd14a0', 'Suite presidencial', 0, 'admin', CURRENT_TIMESTAMP);



INSERT  INTO `freedb_hotel-utp`.`rol` (`id`, `uuid`,`code`, `description`, `active`, `created_by`, `created_at`)
VALUES (1, '6bb31ba7-7ee3-41ca-be1f-662baad66c49','ROOT', 'Super Administrador', 1, 'admin', CURRENT_TIMESTAMP),
       (2, '55354268-ccb2-466c-9e91-6e9a4709d6d5','ADMIN', 'Administrador', 1, 'admin', CURRENT_TIMESTAMP),
       (3, 'e1b7ecb0-0854-4dd0-9482-8cce27757e23','RECEPCIONISTA', 'Recepcionista', 1, 'admin', CURRENT_TIMESTAMP),
       (5, '6783f6b7-27c2-4fee-b0b9-58a38973b271', 'CLIENT','Cliente', 1, 'admin', CURRENT_TIMESTAMP);



INSERT  INTO `freedb_hotel-utp`.`users` (`id`, `uuid`, `document_number`, `full_name`, `phone`, `email`, `password`, `status_id`, `active`, `created_by`, `created_at`)
VALUES (1,'b0f3a3d4-5c8e-4b7c-9f6d-5a2e0f3b8c1e','ROOT72854591','Super Administrador','99999999','99999999@gmail.com','$2a$04$xFLIJ/VvhNlssxdkVF2BceQhLa4ai5QJ2moqkBOgmyiP5r6/Cbj5S',1,1,'ADMIN',CURRENT_TIMESTAMP);


INSERT  INTO `freedb_hotel-utp`.`users_role` (`id`, `uuid`, `user_id`, `rol_id`, `active`, `created_by`, `created_at`)
VALUES (1, 'b0f2a3d4-5c8e-4b7c-9f6d-5a2e0f3b8c1e', 1, 1, 1, 'admin', CURRENT_TIMESTAMP);


INSERT  INTO `freedb_hotel-utp`.`hotel` (`id`, `uuid`, `category`, `address`, `location`, `status_id`, `active`, `created_by`, `created_at`)
VALUES (1, 'a2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 5, 'Lima Centro', '-12.066188148973394, -77.03696239441621', 1, 1, 'admin', CURRENT_TIMESTAMP);


INSERT  INTO `freedb_hotel-utp`.`hotel_room` (`id`, `uuid`, `hotel_id`, `room_type_id`, `room_number`, `price_per_hour`, `price_per_night`, `is_reserved`, `status_id`, `active`, `created_by`, `created_at`)
VALUES (1, 'a2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 1, 101, 50.00, 200.00, 0, 1, 1, 'admin', CURRENT_TIMESTAMP),
       (2, 'b2f3b4c5-6d7e-8f9a-b0c1-d2e3f4g5h6i7', 1, 2, 102, 75.00, 300.00, 0, 1, 1, 'admin', CURRENT_TIMESTAMP);

