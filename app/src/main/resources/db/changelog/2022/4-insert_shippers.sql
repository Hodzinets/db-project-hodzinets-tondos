INSERT INTO Shippers(ShipperID, CompanyName, Phone)
VALUES (1, 'Speedy Express', '(503) 555-9831')
     , (2, 'United Package', '(503) 555-3199')
     , (3, 'Federal Shipping', '(503) 555-9931');

ALTER SEQUENCE shippers_shipperid_seq RESTART WITH 4;