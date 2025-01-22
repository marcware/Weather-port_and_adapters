CREATE TABLE weather_entity (
    id SERIAL PRIMARY KEY,
    city VARCHAR(255),
    description VARCHAR(255),
    temperature DOUBLE PRECISION
);