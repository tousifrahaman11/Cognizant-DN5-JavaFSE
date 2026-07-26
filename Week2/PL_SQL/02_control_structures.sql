
USE dn5_banking;

DROP PROCEDURE IF EXISTS ApplySeniorLoanDiscount;

DELIMITER $$

CREATE PROCEDURE ApplySeniorLoanDiscount()
BEGIN
    -- Variables to hold values fetched one row at a time from the cursor.
    DECLARE v_customerId INT;
    DECLARE v_dob DATE;
    DECLARE v_age INT;
    DECLARE done INT DEFAULT FALSE;

    -- An explicit CURSOR is MySQL's mechanism for looping row-by-row
    -- through a query result, similar to Oracle's cursor FOR loops.
    DECLARE cust_cursor CURSOR FOR
        SELECT CustomerID, DOB FROM Customers;

    -- This handler fires automatically when the cursor runs out of rows,
    -- setting 'done' to TRUE so our loop knows when to stop.
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cust_cursor;

    read_loop: LOOP
        FETCH cust_cursor INTO v_customerId, v_dob;
        IF done THEN
            LEAVE read_loop;
        END IF;

        -- Calculate age from date of birth using MySQL's TIMESTAMPDIFF.
        SET v_age = TIMESTAMPDIFF(YEAR, v_dob, CURDATE());

        -- The actual control structure: IF-THEN logic per the handbook.
        IF v_age > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate - (InterestRate * 0.01)
            WHERE CustomerID = v_customerId;

            SELECT CONCAT('Applied 1% discount for CustomerID ', v_customerId,
                           ' (age ', v_age, ')') AS Message;
        END IF;

    END LOOP;

    CLOSE cust_cursor;
END$$

DELIMITER ;

-- Run it:
CALL ApplySeniorLoanDiscount();

-- Verify: Robert Senior (CustomerID 3, age 71) should now show a
-- discounted rate of 5.94 (was 6.00, minus 1% of 6.00 = 0.06).
SELECT * FROM Loans WHERE CustomerID = 3;


-- =====================================================================
-- Scenario 2: "A customer can be promoted to VIP status based on their
-- balance."
-- Question: iterate through all customers, set IsVIP = TRUE for those
-- with balance over $10,000.
-- =====================================================================

DROP PROCEDURE IF EXISTS PromoteVIPCustomers;

DELIMITER $$

CREATE PROCEDURE PromoteVIPCustomers()
BEGIN
    DECLARE v_customerId INT;
    DECLARE v_balance DECIMAL(12,2);
    DECLARE done INT DEFAULT FALSE;

    DECLARE cust_cursor CURSOR FOR
        SELECT CustomerID, Balance FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN cust_cursor;

    read_loop: LOOP
        FETCH cust_cursor INTO v_customerId, v_balance;
        IF done THEN
            LEAVE read_loop;
        END IF;

        IF v_balance > 10000 THEN
            UPDATE Customers
            SET IsVIP = TRUE
            WHERE CustomerID = v_customerId;

            SELECT CONCAT('CustomerID ', v_customerId,
                           ' promoted to VIP (balance: ', v_balance, ')') AS Message;
        END IF;

    END LOOP;

    CLOSE cust_cursor;
END$$

DELIMITER ;

-- Run it:
CALL PromoteVIPCustomers();

-- Verify: Robert Senior (balance 12000) should now show IsVIP = 1
SELECT CustomerID, Name, Balance, IsVIP FROM Customers;


-- =====================================================================
-- Scenario 3: "The bank wants to send reminders to customers whose
-- loans are due within the next 30 days."
-- Question: fetch all loans due in the next 30 days, print a reminder
-- message for each customer.
-- =====================================================================

DROP PROCEDURE IF EXISTS SendLoanDueReminders;

DELIMITER $$

CREATE PROCEDURE SendLoanDueReminders()
BEGIN
    DECLARE v_loanId INT;
    DECLARE v_customerId INT;
    DECLARE v_customerName VARCHAR(100);
    DECLARE v_endDate DATE;
    DECLARE done INT DEFAULT FALSE;

    -- This cursor's query already filters using a control-structure-like
    -- WHERE condition: "due within the next 30 days" means EndDate is
    -- between today and 30 days from today.
    DECLARE loan_cursor CURSOR FOR
        SELECT l.LoanID, l.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    OPEN loan_cursor;

    read_loop: LOOP
        FETCH loan_cursor INTO v_loanId, v_customerId, v_customerName, v_endDate;
        IF done THEN
            LEAVE read_loop;
        END IF;

        SELECT CONCAT('REMINDER: Dear ', v_customerName,
                       ', your loan (ID ', v_loanId,
                       ') is due on ', v_endDate, '.') AS ReminderMessage;

    END LOOP;

    CLOSE loan_cursor;
END$$

DELIMITER ;

-- Run it:
CALL SendLoanDueReminders();