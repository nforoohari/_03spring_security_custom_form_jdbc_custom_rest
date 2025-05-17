

DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `members`;



CREATE TABLE `members` (
  `user_id` varchar(50) NOT NULL,
  `pass` char(68) NOT NULL,
  `active` tinyint NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `members`
VALUES
('mahsa','{bcrypt}$2a$10$nr64B.4AKVh2kcmc5jRcUucp.3fHWS2zzispXKEYT76i83mT2Syp.',1),
('ashkan','{bcrypt}$2a$10$nr64B.4AKVh2kcmc5jRcUucp.3fHWS2zzispXKEYT76i83mT2Syp.',1),
('neda','{bcrypt}$2a$10$nr64B.4AKVh2kcmc5jRcUucp.3fHWS2zzispXKEYT76i83mT2Syp.',1);




CREATE TABLE `roles` (
  `user_id` varchar(50) NOT NULL,
  `role` varchar(50) NOT NULL,
  UNIQUE KEY `authorities5_idx_1` (`user_id`,`role`),
  CONSTRAINT `authorities5_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `members` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;



INSERT INTO `roles`
VALUES
('neda','ROLE_EMPLOYEE'),
('ashkan','ROLE_EMPLOYEE'),
('ashkan','ROLE_MANAGER'),
('mahsa','ROLE_EMPLOYEE'),
('mahsa','ROLE_MANAGER'),
('mahsa','ROLE_ADMIN');
