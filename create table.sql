CREATE TABLE `nuhs`.`ideas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(1000) NULL,
  `details` VARCHAR(1000) NULL,
  `user` VARCHAR(45) NULL,
  `department` VARCHAR(45) NULL,
  `category` VARCHAR(45) NULL,
  `product` VARCHAR(45) NULL,
  `immediate_needs` VARCHAR(1000) NULL,
  `cih_comments` VARCHAR(1000) NULL,
  `cih_panel_decision` VARCHAR(1000) NULL,
  `cih_oic` VARCHAR(45) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);
  
ALTER TABLE `nuhs`.`ideas` 
ADD COLUMN `created_by` VARCHAR(45) NULL AFTER `cih_oic`,
ADD COLUMN `updated_by` VARCHAR(45) NULL AFTER `created_by`,
ADD COLUMN `created_datetime` DATETIME NULL AFTER `updated_by`,
ADD COLUMN `updated_datetime` DATETIME NULL AFTER `created_datetime`;


CREATE TABLE `nuhs`.`result_response` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `result_id` INT NOT NULL,
  `predictor` VARCHAR(45) NULL,
  `adid` VARCHAR(45) NOT NULL,
  `result_response` VARCHAR(45) NOT NULL,
  `dt_responded` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);




