CREATE TABLE lessons
(
    id      UUID PRIMARY KEY,
    name    VARCHAR(255),
    time    VARCHAR(64)  NOT NULL,
    teacher VARCHAR(128),
    week    INTEGER      NOT NULL,
    room    VARCHAR(64)  NOT NULL,
    "group" INTEGER      NOT NULL,
    day     VARCHAR(255) NOT NULL
);
