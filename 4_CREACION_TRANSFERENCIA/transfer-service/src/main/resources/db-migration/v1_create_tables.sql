-- Drop the table if it exists
DROP TABLE IF EXISTS T_TRANSFER;

-- Create the new table
CREATE TABLE T_TRANSFER (
    transferId SERIAL PRIMARY KEY,
    originWalletId BIGINT,
    destinationWalletId BIGINT,
    amount DECIMAL,
    currency VARCHAR(3),
    registrationDate TIMESTAMP DEFAULT NOW()
);
