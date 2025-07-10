CREATE TABLE Customers (
    CustomerID INT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    City VARCHAR(50),
    SignupDate DATE
);

CREATE TABLE Orders (
    OrderID INT PRIMARY KEY,
    CustomerID INT,
    OrderDate DATE,
    TotalAmount DECIMAL(10,2),
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID) ON DELETE SET NULL
);

CREATE TABLE Products (
    ProductID INT PRIMARY KEY,
    ProductName VARCHAR(100) NOT NULL,
    Category VARCHAR(50),
    Price DECIMAL(10,2)
);

CREATE TABLE OrderDetails (
    OrderDetailID INT PRIMARY KEY,
    OrderID INT, 
    ProductID INT, 
    Quantity INT,
    Price DECIMAL(10,2),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID) ON DELETE SET NULL,
    FOREIGN KEY (ProductID) REFERENCES Products(ProductID) ON DELETE SET NULL
);

INSERT INTO Customers VALUES
(21, 'Nikhil Vyas', 'nikhil.vyas@example.com', 'Ahmedabad', '2024-10-25'),
(22, 'Anjali Kulkarni', 'anjali.k@example.com', 'Pune', '2025-03-10'),
(23, 'Ravi Thakur', 'ravi.thakur@example.com', 'Jaipur', '2024-09-15'),
(24, 'Shreya Iyer', 'shreya.iyer@example.com', 'Chennai', '2023-05-12'),
(25, 'Vivek Mishra', 'vivek.m@example.com', 'Lucknow', '2025-05-20');

INSERT INTO Products VALUES
(121, 'Ultrabook Pro', 'Electronics', 105000.00),
(122, 'Tablet', 'Electronics', 28000.00),
(123, 'Bookshelf', 'Furniture', 18000.00),
(124, 'Ergonomic Chair', 'Furniture', 9500.00),
(125, 'Ballpoint Pen', 'Stationery', 12.00),
(126, 'Planner', 'Stationery', 70.00);

INSERT INTO Orders VALUES
(1021, 21, '2025-04-25', 105000.00),
(1022, 22, '2025-05-30', 46000.00),
(1023, 23, '2025-06-12', 18000.00),
(1024, 24, '2025-06-01', 12012.00),
(1025, 25, '2025-04-15', 12.00);

INSERT INTO OrderDetails VALUES
(21, 1021, 121, 1, 105000.00),
(22, 1022, 122, 1, 28000.00),
(23, 1022, 123, 1, 18000.00),
(24, 1023, 124, 1, 9500.00),
(25, 1024, 125, 1, 12.00),
(26, 1025, 125, 1, 12.00);

SELECT * FROM Customers;
SELECT * FROM Orders WHERE OrderDate >= CURDATE() - INTERVAL 30 DAY;
SELECT ProductName, Price FROM Products;
SELECT COUNT(ProductID), Category FROM Products GROUP BY Category;

SELECT * FROM Customers WHERE City = 'Pune';
SELECT * FROM Orders WHERE TotalAmount > 5000;
SELECT * FROM Customers WHERE SignupDate >= '2024-01-01';

SELECT Orders.*, Customers.Name AS CustomerName FROM Orders LEFT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
SELECT OD.OrderID, P.ProductName FROM OrderDetails OD JOIN Products P ON OD.ProductID = P.ProductID;
SELECT Customers.Name FROM Customers LEFT JOIN Orders ON Customers.CustomerID = Orders.CustomerID WHERE Orders.OrderID IS NULL;

SELECT C.CustomerID, C.Name, SUM(O.TotalAmount) FROM Orders O JOIN Customers C ON O.CustomerID = C.CustomerID GROUP BY C.CustomerID, C.Name;
SELECT P.ProductName, SUM(OD.Quantity) AS TotalQuantity FROM OrderDetails OD JOIN Products P ON P.ProductID = OD.ProductID GROUP BY P.ProductID, P.ProductName ORDER BY TotalQuantity DESC LIMIT 1;
SELECT C.Name, AVG(O.TotalAmount) FROM Orders O JOIN Customers C ON O.CustomerID = C.CustomerID GROUP BY C.CustomerID, C.Name;
SELECT P.Category, SUM(OD.Price * OD.Quantity) AS TotalSales FROM OrderDetails OD JOIN Products P ON OD.ProductID = P.ProductID GROUP BY P.Category;

SELECT C.CustomerID, C.Name FROM Customers C JOIN Orders O ON C.CustomerID = O.CustomerID GROUP BY C.CustomerID, C.Name HAVING SUM(O.TotalAmount) > (SELECT AVG(TotalAmount) FROM Orders);
SELECT ProductID, ProductName FROM Products WHERE ProductID NOT IN (SELECT ProductID FROM OrderDetails);
SELECT O.CustomerID, O.OrderDate FROM Orders O WHERE O.OrderDate = (SELECT MAX(OrderDate) FROM Orders O2 WHERE O2.CustomerID = O.CustomerID);

SELECT C.CustomerID, C.Name, SUM(O.TotalAmount) AS TotalSpent FROM Customers C JOIN Orders O ON C.CustomerID = O.CustomerID GROUP BY C.CustomerID, C.Name ORDER BY TotalSpent DESC;
SELECT C.CustomerID, C.Name, COUNT(O.OrderID) AS NumOrders FROM Customers C JOIN Orders O ON C.CustomerID = O.CustomerID GROUP BY C.CustomerID, C.Name ORDER BY NumOrders DESC, C.Name ASC LIMIT 3;
SELECT P.ProductID, P.ProductName, COUNT(DISTINCT O.CustomerID) AS UniqueCustomers FROM OrderDetails OD JOIN Orders O ON OD.OrderID = O.OrderID JOIN Products P ON OD.ProductID = P.ProductID GROUP BY P.ProductID, P.ProductName;