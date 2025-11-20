INSERT INTO Customer (id, firstName, lastName, email, contactNumber) VALUES
('11111111-1111-1111-1111-111111111111', 'John', 'Doe', 'john.doe@example.com', '+49 151 111111'),
('22222222-2222-2222-2222-222222222222', 'Emma', 'Schmidt', 'emma.schmidt@example.com', '+49 152 222222'),
('33333333-3333-3333-3333-333333333333', 'Paul', 'Müller', 'paul.mueller@example.com', '+49 153 333333'),
('44444444-4444-4444-4444-444444444444', 'Sofia', 'Keller', 'sofia.keller@example.com', '+49 154 444444'),
('55555555-5555-5555-5555-555555555555', 'Liam', 'Becker', 'liam.becker@example.com', '+49 155 555555'),
('66666666-6666-6666-6666-666666666666', 'Mia', 'Hofmann', 'mia.hofmann@example.com', '+49 156 666666'),
('77777777-7777-7777-7777-777777777777', 'Noah', 'Wagner', 'noah.wagner@example.com', '+49 157 777777'),
('88888888-8888-8888-8888-888888888888', 'Laura', 'Berger', 'laura.berger@example.com', '+49 158 888888'),
('99999999-9999-9999-9999-999999999999', 'Felix', 'Schuster', 'felix.schuster@example.com', '+49 159 999999'),
('aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', 'Hannah', 'Vogel', 'hannah.vogel@example.com', '+49 160 101010');


INSERT INTO RestaurantTable (id, tableNumber, description, seatingCapacity, outdoor) VALUES
('bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', 1, 'Small table near window', 2, FALSE),
('cccccccc-cccc-cccc-cccc-cccccccccccc', 2, 'Corner table', 4, FALSE),
('dddddddd-dddd-dddd-dddd-dddddddddddd', 3, 'Large table for groups', 6, FALSE),
('eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', 4, 'Outdoor table with umbrella', 4, TRUE),
('ffffffff-ffff-ffff-ffff-ffffffffffff', 5, 'Outdoor table near garden', 2, TRUE),
('12121212-1212-1212-1212-121212121212', 6, 'Quiet area inside', 4, FALSE),
('23232323-2323-2323-2323-232323232323', 7, 'High-table with bar stools', 2, FALSE),
('34343434-3434-3434-3434-343434343434', 8, 'Outdoor table – shaded', 4, TRUE),
('45454545-4545-4545-4545-454545454545', 9, 'Family table', 6, FALSE),
('56565656-5656-5656-5656-565656565656', 10, 'Romantic table with candles', 2, FALSE);

INSERT INTO Reservation (id, customer_id, restauranttable_id, reservationTime, numberOfGuests) VALUES
('abababab-abab-abab-abab-abababababab', '11111111-1111-1111-1111-111111111111', 'bbbbbbbb-bbbb-bbbb-bbbb-bbbbbbbbbbbb', '2025-02-15 18:30:00', 2),
('bcbcbcbc-bcbc-bcbc-bcbc-bcbcbcbcbcbc', '33333333-3333-3333-3333-333333333333', 'eeeeeeee-eeee-eeee-eeee-eeeeeeeeeeee', '2025-02-16 19:00:00', 4),
('cdcdcdcd-cdcd-cdcd-cdcd-cdcdcdcdcdcd', '77777777-7777-7777-7777-777777777777', '34343434-3434-3434-3434-343434343434', '2025-02-17 20:00:00', 3),
('dededede-dede-dede-dede-dededededede', '88888888-8888-8888-8888-888888888888', '45454545-4545-4545-4545-454545454545', '2025-02-18 18:00:00', 5),
('efefefef-efef-efef-efef-efefefefefef', 'aaaaaaaa-aaaa-aaaa-aaaa-aaaaaaaaaaaa', '56565656-5656-5656-5656-565656565656', '2025-02-19 21:00:00', 2);
