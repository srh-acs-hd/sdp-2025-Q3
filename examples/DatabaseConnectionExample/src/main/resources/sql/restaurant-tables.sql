
CREATE TABLE Customer (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    contactNumber VARCHAR(100)
);

CREATE TABLE RestaurantTable (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    tableNumber INT not null,
    description TEXT,
    seatingCapacity INT not null,
    outdoor BOOLEAN NOT NULL DEFAULT FALSE
);

CREATE TABLE Reservation (
    id UUID PRIMARY KEY DEFAULT uuid_generate_v4(),
    customer_id UUID REFERENCES Customer(id),
    restauranttable_id UUID REFERENCES RestaurantTable(id),
    reservationTime TIMESTAMP NOT NULL,
    numberOfGuests INT NOT NULL
);