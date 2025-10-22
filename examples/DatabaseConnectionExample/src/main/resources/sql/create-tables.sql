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
