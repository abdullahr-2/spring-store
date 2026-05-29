ALTER TABLE ab_sql.products
    ADD `description` VARCHAR(255) NULL;

ALTER TABLE ab_sql.products
    MODIFY `description` VARCHAR (255) NOT NULL;