drop table if exists `tasks`;
drop table if exists `worker`;

CREATE TABLE `worker` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `birthYear` int(4) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `position` varchar(255) DEFAULT NULL,
  `salary` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
)DEFAULT CHARSET=utf8;



INSERT INTO `worker` (`id`, `birthYear`, `first_name`, `last_name`, `position`, `salary`) VALUES ('1', '1985', 'Jan', 'Kowalski', 'Dyrektor', '5000');
INSERT INTO `worker` (`id`, `birthYear`, `first_name`, `last_name`, `position`, `salary`) VALUES ('2', '1990', 'Anna', 'Nowak', 'Sekretarka', '3000');
INSERT INTO `worker` (`id`, `birthYear`, `first_name`, `last_name`, `position`, `salary`) VALUES ('3', '1978', 'Andrzej', 'Kowalczyk', 'Kierowca', '3000');
INSERT INTO `worker` (`id`, `birthYear`, `first_name`, `last_name`, `position`, `salary`) VALUES ('4', '1983', 'Krzysztof', 'Adamczyk', 'Mechanik', '3500');

CREATE TABLE `tasks` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `desctiption` VARCHAR(512) NULL,
  `estimated_time` VARCHAR(45) NULL,
  `worker_id` bigint NULL,
  PRIMARY KEY (`id`),
  INDEX `task_worker_id_fk_idx` (`worker_id` ASC),
  FOREIGN KEY (`worker_id`)
    REFERENCES `worker` (`id`)
) DEFAULT CHARSET=utf8;


INSERT INTO `tasks` (`id`, `desctiption`, `estimated_time`, `worker_id`) VALUES ('1', 'Spotkanie z klientem', '2h', '1');
INSERT INTO `tasks` (`id`, `desctiption`, `estimated_time`, `worker_id`) VALUES ('2', 'Sprawdzenie listy obecności', '1h', '2');
INSERT INTO `tasks` (`id`, `desctiption`, `estimated_time`, `worker_id`) VALUES ('3', 'Telefony do klientów w sprawie ostatnich zamówień', '2h', '2');
INSERT INTO `tasks` (`id`, `desctiption`, `estimated_time`, `worker_id`) VALUES ('4', 'Wyjazd do Klienta', '2h', '3');
INSERT INTO `tasks` (`id`, `desctiption`, `estimated_time`, `worker_id`) VALUES ('5', 'Wyjazd po fabryki', '1h', '3');
