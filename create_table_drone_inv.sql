CREATE DATABASE  IF NOT EXISTS `drone_incidents`;
USE `drone_incidents`;

--
-- Table structure for table `drone_inventory`
--
-- DROP TABLE `drone_inventory`;
--
CREATE TABLE `drone_inventory` (
	`droneID` int(11) NOT NULL AUTO_INCREMENT,
	`make` varchar(90) NOT NULL,
	`model` varchar(90) NOT NULL,
	`year` varchar(90) NOT NULL,
	`last_service` varchar(90) NOT NULL,
	`service_loc` varchar(45) NOT NULL,
	`VIN` int(8) NOT NULL,
	`faa_lic` varchar(45) NOT NULL,
  PRIMARY KEY (`droneID`),
  UNIQUE KEY `droneID_UNIQUE` (`droneID`),
  UNIQUE KEY `VIN_UNIQUE` (`VIN`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


-- DROP TABLE `incident`;
--
CREATE TABLE `incident` (
	`incidentID` int(11) NOT NULL AUTO_INCREMENT,
    `cause_of_failure` varchar(50) NOT NULL,
    `GPS_location` int(1) NOT NULL,
    `reported_by` varchar(20) NOT NULL,
    `damage_to_drone` varchar(20) NOT NULL,
    `external_dmg` varchar(20) NOT NULL,
    `police_incidence_report` varchar(99) NOT NULL,
    `emergency_phone_contact` varchar(13) NOT NULL,
    PRIMARY KEY(`incidentID`),
    UNIQUE KEY `incidentID_UNIQUE` (`incidentID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


-- DROP TABLE `emergencyPrevention`;
--
CREATE TABLE `emergencyPrevention` (
	`emergencyID` int(11) NOT NULL AUTO_INCREMENT,
    `emergencyContact` varchar(13) NOT NULL,
    `drone_operator` varchar(20) NOT NULL,
    `operator_actions` varchar(99) NOT NULL,
    `operator_comments` varchar(99) NOT NULL,
    PRIMARY KEY(`emergencyID`),
    UNIQUE KEY`emergencyID_UNIQUE` (`emergencyID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- DROP TABLE `incidentWitness`;
--
CREATE TABLE `incidentWitness`(
	`witnessID` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(20) NOT NULL,
    `phone` varchar(13) NOT NULL,
    `email` varchar(20) NOT NULL,
    `address` varchar(30) NOT NULL,
    `witness_type` varchar(20) NOT NULL,
    `witnessReport` varchar(80) NOT NULL,
    `emergencyContact` varchar(20) NOT NULL,
    PRIMARY KEY(`witnessID`),
    UNIQUE KEY `witnessID_UNIQUE` (`witnessID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
    
