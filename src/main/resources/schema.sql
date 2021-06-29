CREATE TABLE user (
    `id`    INTEGER(11)     NOT NULL    PRIMARY KEY     AUTO_INCREMENT,
    `username`      VARCHAR(100)        NOT NULL,
    `password`      VARCHAR (100)       NOT NULL,
    `email`         VARCHAR(100)        NOT NULL,
    `firstName`     VARCHAR (50)       NOT NULL,
    `lastName`      VARCHAR (40)       NOT NULL,
    `role`      VARCHAR (30)        NOT NULL,
    `createDate`    DATE    NOT NULL
)