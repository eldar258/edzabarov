CREATE TABLE vacancy (
    vacancy_id SERIAL PRIMARY KEY,
    url VARCHAR(1000),
    name VARCHAR(250),
    post_time TIMESTAMP
);