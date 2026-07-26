-- ============================================================
-- Exercise 3: Stored Procedures (Cognizant DN5.0)
-- Scenario 1: ProcessMonthlyInterest
-- Scenario 2: UpdateEmployeeBonus
-- Scenario 3: TransferFunds
-- ============================================================

USE dn5_banking;

-- SCENARIO 1: Calculate and update balance for all savings accounts
-- by applying 1% interest rate to current balance.
DROP PROCEDURE IF EXISTS ProcessMonthlyInterest;
DELIMITER $$
CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance + (Balance * 0.01),
        LastModified = CURDATE()
    WHERE AccountType = 'Savings';

    SELECT AccountID, AccountType, Balance FROM Accounts
    WHERE AccountType = 'Savings';

    SELECT 'Monthly 1% interest applied to all Savings accounts.' AS Message;
END$$
DELIMITER ;

CALL ProcessMonthlyInterest();


-- SCENARIO 2: Update salary of employees in a department
-- by adding a bonus percentage passed as parameter.
DROP PROCEDURE IF EXISTS UpdateEmployeeBonus;
DELIMITER $$
CREATE PROCEDURE UpdateEmployeeBonus(
    IN p_department VARCHAR(50),
    IN p_bonusPercentage DECIMAL(5,2)
)
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_bonusPercentage / 100)
    WHERE Department = p_department;

    SELECT EmployeeID, Name, Department, Salary FROM Employees
    WHERE Department = p_department;

    SELECT CONCAT('Bonus of ', p_bonusPercentage,
                  '% applied to ', p_department) AS Message;
END$$
DELIMITER ;

-- Apply 10% bonus to IT department
CALL UpdateEmployeeBonus('IT', 10);


-- SCENARIO 3: Transfer funds between accounts,
-- checking source account has sufficient balance first.
DROP PROCEDURE IF EXISTS TransferFunds;
DELIMITER $$
CREATE PROCEDURE TransferFunds(
    IN p_fromAccountId INT,
    IN p_toAccountId INT,
    IN p_amount DECIMAL(12,2)
)
BEGIN
    DECLARE v_sourceBalance DECIMAL(12,2);

    SELECT Balance INTO v_sourceBalance
    FROM Accounts
    WHERE AccountID = p_fromAccountId;

    IF v_sourceBalance >= p_amount THEN
        UPDATE Accounts
        SET Balance = Balance - p_amount, LastModified = CURDATE()
        WHERE AccountID = p_fromAccountId;

        UPDATE Accounts
        SET Balance = Balance + p_amount, LastModified = CURDATE()
        WHERE AccountID = p_toAccountId;

        SELECT CONCAT('SUCCESS: Transferred ', p_amount,
                      ' from Account ', p_fromAccountId,
                      ' to Account ', p_toAccountId) AS Message;
    ELSE
        SELECT CONCAT('FAILED: Insufficient balance. Available: ',
                      v_sourceBalance) AS Message;
    END IF;

    SELECT AccountID, Balance FROM Accounts
    WHERE AccountID IN (p_fromAccountId, p_toAccountId);
END$$
DELIMITER ;

-- Test successful transfer
CALL TransferFunds(1, 2, 200);

-- Test failed transfer (amount exceeds balance)
CALL TransferFunds(1, 2, 99999);