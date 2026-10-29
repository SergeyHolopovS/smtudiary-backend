CREATE TABLE lessons
(
    id      UUID PRIMARY KEY,
    name    VARCHAR(255),
    title   VARCHAR(64)  NOT NULL,
    teacher VARCHAR(128),
    type    INTEGER      NOT NULL,
    room    VARCHAR(64)  NOT NULL,
    "group" VARCHAR(16)  NOT NULL,
    day     VARCHAR(255) NOT NULL
);
