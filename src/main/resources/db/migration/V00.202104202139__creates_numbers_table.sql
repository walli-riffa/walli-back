CREATE TABLE numbers (
    id uuid PRIMARY KEY NOT NULL DEFAULT uuid_generate_v4(),
    number INTEGER NOT NULL,
    active BOOLEAN NOT NULL,
    customers_id uuid UNIQUE,
    CONSTRAINT fk_customers
        FOREIGN KEY(customers_id)
            REFERENCES customers(id)
);