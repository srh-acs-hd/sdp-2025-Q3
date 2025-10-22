-- ==========================
-- Insert CourseOfStudies
-- ==========================
INSERT INTO CourseOfStudies (name, description)
VALUES
('Computer Science', 'Study of computation, algorithms, and software development.'),
('Business Administration', 'Study of business management, finance, and leadership.'),
('Mechanical Engineering', 'Design and analysis of machines and physical systems.'),
('Psychology', 'Scientific study of mind, behavior, and mental processes.'),
('Architecture', 'Design and construction of buildings and spatial environments.');

-- ==========================
-- Insert Students for each CourseOfStudies
-- ==========================

-- Computer Science
INSERT INTO Student (firstName, lastName, city, courseOfStudies_id)
VALUES
('Alice', 'Miller', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Bob', 'Schneider', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Clara', 'Weber', 'Stuttgart', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Daniel', 'Becker', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Eva', 'Fischer', 'Frankfurt', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Felix', 'Hoffmann', 'Tübingen', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Greta', 'Wagner', 'Ludwigshafen', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Hannah', 'Richter', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Jonas', 'Schmidt', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Computer Science')),
('Lukas', 'Keller', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Computer Science'));

-- Business Administration
INSERT INTO Student (firstName, lastName, city, courseOfStudies_id)
VALUES
('Anna', 'Lehmann', 'Frankfurt', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Benjamin', 'Maier', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Carla', 'Krause', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('David', 'Brandt', 'Stuttgart', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Elena', 'Vogel', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Fabian', 'Bauer', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Gina', 'Schäfer', 'Ludwigshafen', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Henry', 'Lorenz', 'Frankfurt', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Isabel', 'Arnold', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Business Administration')),
('Julian', 'Berger', 'Stuttgart', (SELECT id FROM CourseOfStudies WHERE name='Business Administration'));

-- Mechanical Engineering
INSERT INTO Student (firstName, lastName, city, courseOfStudies_id)
VALUES
('Aaron', 'Fuchs', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Bianca', 'Wolff', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Chris', 'Peters', 'Stuttgart', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Diana', 'Otto', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Erik', 'Scholz', 'Frankfurt', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Florian', 'Kunz', 'Tübingen', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Greta', 'Hartmann', 'Ludwigshafen', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Hans', 'Böhm', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Ina', 'Zimmermann', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering')),
('Jan', 'Engel', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Mechanical Engineering'));

-- Psychology
INSERT INTO Student (firstName, lastName, city, courseOfStudies_id)
VALUES
('Alicia', 'Graf', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Benedikt', 'Voigt', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Claudia', 'Haas', 'Stuttgart', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Dennis', 'Krüger', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Elisa', 'Kaiser', 'Frankfurt', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Fabienne', 'Walter', 'Tübingen', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Gerrit', 'Horn', 'Ludwigshafen', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Helena', 'Roth', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Ismael', 'Seidel', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Psychology')),
('Johanna', 'Franke', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Psychology'));

-- Architecture
INSERT INTO Student (firstName, lastName, city, courseOfStudies_id)
VALUES
('Alexandra', 'Winter', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Bastian', 'Busch', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Celine', 'Paul', 'Stuttgart', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Dominik', 'Kraft', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Eva', 'Reuter', 'Frankfurt', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Felix', 'Böhme', 'Tübingen', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Gina', 'Marx', 'Ludwigshafen', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Holger', 'Zimmer', 'Heidelberg', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Irene', 'Dietrich', 'Karlsruhe', (SELECT id FROM CourseOfStudies WHERE name='Architecture')),
('Jonas', 'Haase', 'Mannheim', (SELECT id FROM CourseOfStudies WHERE name='Architecture'));
