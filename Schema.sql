-- ===========================
-- TABLES
-- ===========================

CREATE TABLE PATIENTS (
    patient_id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthdate DATE NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    contact_number VARCHAR(15) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE APPOINTMENTS (
    appointment_id INT PRIMARY KEY AUTO_INCREMENT,
    patient_id INT NOT NULL,
    appointment_date DATETIME NOT NULL,
    reason TEXT,
    FOREIGN KEY (patient_id) REFERENCES PATIENTS(patient_id) ON DELETE CASCADE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- ===========================
-- STORED PROCEDURES
-- ===========================

DELIMITER $$

-- Create patient
CREATE PROCEDURE CreatePatient (
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_birthdate DATE,
    IN p_gender ENUM('Male', 'Female', 'Other'),
    IN p_contact_number VARCHAR(15),
    IN p_email VARCHAR(100)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    INSERT INTO PATIENTS (first_name, last_name, birthdate, gender, contact_number, email)
    VALUES (p_first_name, p_last_name, p_birthdate, p_gender, p_contact_number, p_email);

    COMMIT;
END $$

-- Read patient by ID
CREATE PROCEDURE ReadPatient (
    IN p_patient_id INT
)
BEGIN
    SELECT * FROM PATIENTS WHERE patient_id = p_patient_id;
END $$

-- Update patient by ID
CREATE PROCEDURE UpdatePatient (
    IN p_patient_id INT,
    IN p_first_name VARCHAR(100),
    IN p_last_name VARCHAR(100),
    IN p_birthdate DATE,
    IN p_gender ENUM('Male', 'Female', 'Other'),
    IN p_contact_number VARCHAR(15),
    IN p_email VARCHAR(100)
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    UPDATE PATIENTS
    SET first_name = p_first_name,
        last_name = p_last_name,
        birthdate = p_birthdate,
        gender = p_gender,
        contact_number = p_contact_number,
        email = p_email,
        updated_at = CURRENT_TIMESTAMP
    WHERE patient_id = p_patient_id;

    COMMIT;
END $$

-- Delete patient by ID
CREATE PROCEDURE DeletePatient (
    IN p_patient_id INT
)
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
    END;

    START TRANSACTION;

    DELETE FROM PATIENTS WHERE patient_id = p_patient_id;

    COMMIT;
END $$

DELIMITER ;


-- ===========================
-- Sample inputs
-- ===========================


INSERT INTO PATIENTS (first_name, last_name, birthdate, gender, contact_number, email) VALUES
('Juan', 'Dela Cruz', '1990-05-12', 'Male', '09171234567', 'juan.delacruz@example.com'),
('Maria', 'Reyes', '1985-03-22', 'Female', '09281234567', 'maria.reyes@example.com'),
('Jose', 'Santos', '1978-11-10', 'Male', '09391234567', 'jose.santos@example.com'),
('Anna', 'Lopez', '1995-07-08', 'Female', '09181234567', 'anna.lopez@example.com'),
('Mark', 'Garcia', '2000-01-30', 'Male', '09291234567', 'mark.garcia@example.com'),
('Liza', 'Cruz', '1993-09-14', 'Female', '09191234567', 'liza.cruz@example.com'),
('Carlos', 'Torres', '1982-06-20', 'Male', '09161234567', 'carlos.torres@example.com'),
('Elaine', 'Fernandez', '1998-02-17', 'Female', '09471234567', 'elaine.fernandez@example.com'),
('Patrick', 'Navarro', '1991-04-05', 'Male', '09581234567', 'patrick.navarro@example.com'),
('Janine', 'Vega', '1989-08-25', 'Female', '09691234567', 'janine.vega@example.com');

INSERT INTO APPOINTMENTS (patient_id, appointment_date, reason) VALUES
(1, '2025-06-01 10:00:00', 'Routine Checkup'),
(2, '2025-06-02 14:30:00', 'Follow-up Consultation'),
(3, '2025-06-03 09:15:00', 'Blood Test'),
(4, '2025-06-04 11:00:00', 'Prescription Refill'),
(5, '2025-06-05 08:45:00', 'Skin Allergy'),
(6, '2025-06-06 13:00:00', 'Headache Evaluation'),
(7, '2025-06-07 15:30:00', 'Annual Physical Exam'),
(8, '2025-06-08 10:45:00', 'Dental Referral'),
(9, '2025-06-09 12:15:00', 'Flu Symptoms'),
(10, '2025-06-10 16:00:00', 'Lab Result Review');
