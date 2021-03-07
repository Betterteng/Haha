create type gender as enum ('MALE', 'FEMALE');

ALTER TABLE student
alter column gender type gender
using (gender::gender)
