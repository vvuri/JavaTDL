CREATE TABLE IF NOT EXISTS flight (
    id SERIAL PRIMARY KEY,
    name INTEGER REFERENCES company(id),
    destination VARCHAR(256) NOT NULL
);