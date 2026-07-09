-- =====================================================================
-- Cognizant DN5.0 - PL/SQL Programming Module
-- Schema matching the handbook's "Schema to be Created" section.
-- Converted from Oracle PL/SQL syntax to MySQL syntax:
--   NUMBER        -> INT / DECIMAL
--   VARCHAR2(n)   -> VARCHAR(n)
--   DATE          -> DATE  (same keyword, works in both)
-- =====================================================================

CREATE DATABASE IF NOT EXISTS dn5_banking;
USE dn5_banking;

-- Drop tables if they exist, in reverse dependency order, so we can
-- re-run this script safely during development without errors.
DROP TABLE IF EXISTS Transactions;
DROP TABLE IF EXISTS Loans;
DROP TABLE IF EXISTS Accounts;
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Customers;

CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100),
    DOB DATE,
    Balance DECIMAL(12,2),
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID INT PRIMARY KEY,
    CustomerID INT,
    AccountType VARCHAR(20),
    Balance DECIMAL(12,2),
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID INT PRIMARY KEY,
    AccountID INT,
    TransactionDate DATE,
    Amount DECIMAL(12,2),
    TransactionType VARCHAR(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID INT PRIMARY KEY,
    CustomerID INT,
    LoanAmount DECIMAL(12,2),
    InterestRate DECIMAL(5,2),
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    Name VARCHAR(100),
    Position VARCHAR(50),
    Salary DECIMAL(12,2),
    Department VARCHAR(50),
    HireDate DATE
);

-- =====================================================================
-- Sample data (converted from docx's Oracle INSERT statements)
-- Oracle's TO_DATE('1985-05-15','YYYY-MM-DD') becomes MySQL's '1985-05-15'
-- directly, since MySQL auto-parses ISO-format date strings.
-- Oracle's SYSDATE becomes MySQL's CURDATE().
-- =====================================================================

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', '1985-05-15', 1000, CURDATE());

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', '1990-07-20', 1500, CURDATE());

-- Extra customer above 60 years old, needed to properly test Exercise 1
-- Scenario 1 (loan interest discount for customers above 60).
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (3, 'Robert Senior', '1955-02-10', 12000, CURDATE());

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, CURDATE());

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, CURDATE());

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (3, 3, 'Savings', 12000, CURDATE());

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, CURDATE(), 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, CURDATE(), 300, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5.00, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 MONTH));

-- Loan for the senior customer, with a 5% rate, so Exercise 1 Scenario 1
-- has something to actually apply a 1% discount to.
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 3, 8000, 6.00, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 36 MONTH));

-- A loan due within the next 30 days, to test Exercise 1 Scenario 3.
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (3, 2, 3000, 4.50, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 15 DAY));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', '2015-06-15');

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Bob Brown', 'Developer', 60000, 'IT', '2017-03-20');

-- Quick sanity check - run this after the script to confirm data loaded.
SELECT * FROM Customers;
SELECT * FROM Loans;