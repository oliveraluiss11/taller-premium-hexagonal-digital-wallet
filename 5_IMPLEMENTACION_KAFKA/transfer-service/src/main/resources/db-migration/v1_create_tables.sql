-- Drop the table if it exists
DROP TABLE IF EXISTS T_TRANSFER;

-- Create the new table
CREATE TABLE T_TRANSFER (
    transferId SERIAL PRIMARY KEY,
    originWalletId VARCHAR(50),
    destinationWalletId VARCHAR(50),
    amount DECIMAL,
    currency VARCHAR(3),
    registrationDate TIMESTAMP DEFAULT NOW()
);
