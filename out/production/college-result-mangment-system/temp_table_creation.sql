
-- Creating the table

-- CREATE TABLE student_result (
--   srn VARCHAR(255) NOT NULL,
--   name VARCHAR(255),
--   marks INT DEFAULT 0,
--   UE20CS351_script LONGBLOB,
--   UE20CS352_script LONGBLOB,
--   UE20CS353_script LONGBLOB,
--   E3_script LONGBLOB,
--   E4_script LONGBLOB,
--   PRIMARY KEY(srn)
-- );



-- Inserting data into the table

INSERT INTO student_result (srn,name, marks, UE20CS351_script, UE20CS352_script, UE20CS353_script, E3_script, E4_script)
VALUES ('PES1UG20CSXXX','Student1', 75, LOAD_FILE('image_1.jpg'), LOAD_FILE('image_2.jpg'), LOAD_FILE('image_3.jpg'), LOAD_FILE('image_4.jpg'), LOAD_FILE('image_5.jpg'));
