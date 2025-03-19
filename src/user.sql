CREATE TABLE IF NOT EXISTS "user" (
    id SERIAL PRIMARY KEY,
    is_online BOOLEAN NOT NULL,
    response_time_ms DOUBLE PRECISION NOT NULL,
    error_rate DOUBLE PRECISION NOT NULL,
    active_players INT NOT NULL,
    last_checked TIMESTAMP DEFAULT NOW()
);
