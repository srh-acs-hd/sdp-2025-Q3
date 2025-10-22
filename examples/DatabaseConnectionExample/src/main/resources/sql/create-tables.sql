-- ==========================
-- Database Table Definitions
-- ==========================
-- This script creates the tables required for the example database:
--   - CourseOfStudies: Stores information about each course of studies.
--   - Student: Stores information about students and their associated course of studies.
--
-- Table: CourseOfStudies
--   Columns:
--     id   - UUID, primary key, generated automatically
--     name - Name of the course (required)
--     description - Description of the course (optional)
--
-- Table: Student
--   Columns:
--     id   - UUID, primary key, generated automatically
--     firstName - Student's first name (required)
--     lastName  - Student's last name (required)
--     city      - City where the student lives (optional)
--     courseOfStudies_id - Foreign key referencing CourseOfStudies(id), set to NULL if the course is deleted
--
-- Usage:
--   Run this script to create the necessary tables before inserting any data.
--   Make sure the uuid-ossp extension is enabled for UUID generation.

-- Enable UUID extension (for PostgreSQL)
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- ==========================
-- Table: CourseOfStudies
-- ==========================
CREATE TABLE CourseOfStudies (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    name VARCHAR(100) NOT NULL,
    description TEXT
);

-- ==========================
-- Table: Student
-- ==========================
CREATE TABLE Student (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    courseOfStudies_id UUID REFERENCES CourseOfStudies(id) ON DELETE SET NULL
);
