CREATE TABLE users (
    id TEXT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    cep VARCHAR(9),
    city VARCHAR(255),
    state VARCHAR(255),
    street VARCHAR(255),
    street_number VARCHAR(255)
);
