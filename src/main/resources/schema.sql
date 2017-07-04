DROP TABLE IF EXISTS `test_entity`;
CREATE TABLE IF NOT EXISTS `test_entity` (
	`test_entity_id` INT(10) UNSIGNED NOT NULL,
	`code` SMALLINT(5) UNSIGNED NOT NULL DEFAULT '1',
	PRIMARY KEY (`test_entity_id`),
	UNIQUE INDEX `test_entity_id_unique` (`test_entity_id`)
)
ENGINE=InnoDB
;