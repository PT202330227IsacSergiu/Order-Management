# Documentation

### 1. Objective
The main objective was to design a Java program for order management. Each order is placed by a client who can order products from a warehouse. Data about each entity is stored in a MySQL database (Client, Product, Order), alongside the creation of classes. Operations such as insert, delete, update, and report are performed on the database tables. The program features a graphical user interface for database modifications. Command details are displayed in a .pdf file.

### 2. Problem Analysis, Modeling, Use Cases
Modeling was carried out across 4 execution levels, each belonging to a package:
1. Model (includes classes: Client, Product, Order): classes associated with the database tables.
2. DataAccess (includes classes: Abstract, DAO, ClientDAO, ProductDAO, OrderDAO): queries were created for each operation.
3. BusinessLogic (includes classes: ClientBLL, ProductBLL, OrderBLL): concrete operation definitions for each class. DataAccess methods are called here.
4. Presentation (includes View and Controller classes for each Model class): each class is assigned a graphical interface (View) and a controller for interaction and operations.

### 3. Design
#### Connection Package:
- **ConnectionFactory Class**: Handles database connection with arguments: <Logger> LOGGER, <String> DRIVER, <String> DBURL, <String> USER, <String> PASS. Methods include constructor, createConnection(), get methods for connection, close method for connection.

#### Model Package:
- **Client Class**: Represents a client with arguments: <Integer> id, <String> name, <String> address, <String> phone_number. Methods include toString(), setters, and getters.
- **Product Class**: Represents a product with arguments: <Integer> id, <String> name, <Double> price, <Integer> quantity. Methods include toString(), setters, and getters.
- **Order Class**: Represents an order with arguments: <Integer> id, <String> name, <String> address, <String> phone_number. Methods include toString(), setters, and getters.
- **Bill Record**: Represents an order with details. Fields include <Order> order. Methods are already generated.

#### DataAccess Package:
- **AbstractDAO<T> Class**: Generic class handling database connection via ConnectionFactory method calls and implements queries for class/table <T>. Arguments include <Logger> LOGGER, <Class<T>> type. Methods include findAll(), createSelectQuery(), findById(), insert(), createInsertQuery(), update(), createUpdateQuery(), delete(), createDeleteQuery(), createLastRowQuery(), lastElement().
- **ClientDAO Class**: Extends AbstractDAO class and specializes it for Client class.
- **ProductDAO Class**: Extends AbstractDAO class and specializes it for Product class.
- **OrderDAO Class**: Extends AbstractDAO class and specializes it for Order class.

#### Presentation Package:
- **ClientController Class**: Represents the graphical interface of the Client class. Methods include setter and getter methods for text fields, buttons, and tables, updateData().
- **ClientController Class**: Interacts with the graphical interface of the ClientView class. Methods include insertListener(), selectListener(), updateListener(), deleteListener(), backListener(), convertDataToStrings().
- **ProductView Class**: Represents the graphical interface of the Product class. Methods include setter and getter methods for text fields, buttons, and tables, updateData().
- **ProductController Class**: Interacts with the graphical interface of the ProductView class. Methods include insertListener(), selectListener(), updateListener(), deleteListener(), backListener(), convertDataToStrings().
- **OrderView Class**: Represents the graphical interface of the Order class. Methods include setter and getter methods for text fields, buttons, and tables, updateData().
- **OrderController Class**: Interacts with the graphical interface of the OrderView class. Methods include insertListener(), selectListener(), deleteListener(), backListener(), convertDataToStrings().
- **GeneralView Class**: Represents the main menu interface to access the other three interfaces. Methods include clientsBtnListener(), productsBtnListener(), ordersBtnListener().
- **GeneralController Class**: Interacts with the graphical interface of the GeneralView class. Methods include clientsBtnListener(), productsBtnListener(), ordersBtnListener().

#### BusinessLogic Package:
- **ClientBLL Class**: Utilizes operations from DataAccess for Client operations. Arguments include <ClientDAO> clientDAO, <List<Validator<Client>>> validators. Methods include insertClient(), updateClient(), findClientById(), findClients(), deleteClient(), lastElementId().
- **ProductBLL Class**: Utilizes operations from DataAccess for Product operations. Arguments include <ProductDAO> productDAO, <List<Validator<Product>>> validators. Methods include insertProduct(), updateProduct(), findProductById(), findProducts(), deleteProduct(), lastElementId().
- **OrderBLL Class**: Utilizes operations from DataAccess for Order operations. Arguments include <OrderDAO> orderDAO, <List<Validator<Order>>> validators. Methods include insertOrder(), findOrders(), lastElementId().

#### Validators Package:
- **Validator Interface**: Presents the validate() method.
- **ClientValidator Package**: Presents the PhoneNumberValidator class implementing the Validator interface.
- **ProductValidator Package**: Presents the PriceValidator, QuantityValidator classes both implementing the Validator interface.
- **OrderValidator Package**: Presents the QuantityValidator class implementing the Validator interface.

### 4. Implementation
- Client, Product, Order: toString() methods return a formatted string representation of the object.
- Bill: writeToLog(int id) creates a PDF file containing order information.
- AbstractDAO: Methods implemented for basic database operations.
- ConnectionFactory: Methods for database connection handling.
- BusinessLogic Classes: Methods implemented for CRUD operations.
- Validator Classes: Methods implemented for validation of phone numbers, prices, and quantities.

### 5. Bibliography
1. Tutorialspoint - https://www.tutorialspoint.com/
2. Creating PDF Files in Java | Baeldung
3. Stack Overflow - Where Developers Learn, Share, & Build Careers

