CREATE DATABASE  IF NOT EXISTS `securelogin` 
USE `securelogin`;

--
-- Table structure for table `user`
--
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID_UNIQUE` (`userID`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- insert one row into DB
INSERT INTO `user` 
VALUES (1,'SecureUser','8OTC92xYkW7CWPJGhRvqCR0U1CR6L8PhhpRGGxgW4Ts='),(2,'<script>alert(\"Hello\");</script>','XohImNooBHFR0OVvjcYpJ3NgPQ1qq73WKhHvch0VQtg=');