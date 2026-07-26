-- =====================================================================
-- Adds the IsVIP column required by Exercise 1, Scenario 2:
-- "Write a PL/SQL block that iterates through all customers and sets
-- a flag IsVIP to TRUE for those with a balance over $10,000."
--
-- This column was not in the handbook's original "Schema to be Created"
-- section, but Scenario 2 explicitly requires it, so we add it here.
-- =====================================================================

USE dn5_banking;

ALTER TABLE Customers
ADD COLUMN IsVIP BOOLEAN DEFAULT FALSE;

-- Confirm the column was added
DESCRIBE Customers;