CREATE TABLE groups
(
    "group" INTEGER PRIMARY KEY
);


ALTER TABLE lessons
    ADD CONSTRAINT fk_lessons_group FOREIGN KEY ("group") REFERENCES groups ("group");
