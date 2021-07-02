CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE customers (
    id uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
    name text NOT NULL,
    phone text,
    email text
);