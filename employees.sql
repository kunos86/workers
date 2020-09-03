drop table if exists `tasks`;
drop table if exists `employee`;

CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birth_year` int(4) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `salary` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8mb4;



INSERT INTO `employee` (`id`, `birth_year`, `first_name`, `last_name`, `position`, `salary`) VALUES ('1', '1985', 'Jan', 'Kowalski', 'Dyrektor', '5000');
INSERT INTO `employee` (`id`, `birth_year`, `first_name`, `last_name`, `position`, `salary`) VALUES ('2', '1990', 'Anna', 'Nowak', 'Sekretarka', '3000');
INSERT INTO `employee` (`id`, `birth_year`, `first_name`, `last_name`, `position`, `salary`) VALUES ('3', '1978', 'Andrzej', 'Kowalczyk', 'Kierowca', '3000');
INSERT INTO `employee` (`id`, `birth_year`, `first_name`, `last_name`, `position`, `salary`) VALUES ('4', '1983', 'Krzysztof', 'Adamczyk', 'Mechanik', '3500');

CREATE TABLE `tasks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(512) NULL,
  `estimated_time` VARCHAR(45) NULL,
  `employee_id` bigint NULL,
  PRIMARY KEY (`id`),
  INDEX `task_employee_id_fk_idx` (`employee_id` ASC),
  FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`)  ON DELETE CASCADE
) DEFAULT CHARSET=utf8mb4;


INSERT INTO `tasks` (`id`, `description`, `estimated_time`, `employee_id`) VALUES ('1', 'Spotkanie z klientem', '2h', '1');
INSERT INTO `tasks` (`id`, `description`, `estimated_time`, `employee_id`) VALUES ('2', 'Sprawdzenie listy obecności', '1h', '2');
INSERT INTO `tasks` (`id`, `description`, `estimated_time`, `employee_id`) VALUES ('3', 'Telefony do klientów w sprawie ostatnich zamówień', '2h', '2');
INSERT INTO `tasks` (`id`, `description`, `estimated_time`, `employee_id`) VALUES ('4', 'Wyjazd do Klienta', '2h', '3');
INSERT INTO `tasks` (`id`, `description`, `estimated_time`, `employee_id`) VALUES ('5', 'Wyjazd po fabryki', '1h', '3');
