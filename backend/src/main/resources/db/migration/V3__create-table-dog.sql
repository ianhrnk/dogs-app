CREATE TABLE dog (
    id TEXT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age INTEGER,
    breed_id SERIAL,
    user_id TEXT,
    FOREIGN KEY (breed_id) REFERENCES breed(id),
    FOREIGN KEY (user_id) REFERENCES users(id)
);
