# Bank Management System (ATM Simulation)

A Java desktop application that simulates core ATM and bank account operations such as account creation, login, deposit, withdrawal, balance enquiry, mini statement, and PIN change.

## Problem Statement
Traditional basic banking operations are often split across multiple manual steps. This project provides a single desktop interface to perform essential ATM workflows end-to-end for learning and demonstration.

## Project Overview
The application is built using Java Swing for UI, JDBC for database connectivity, and MySQL for persistent storage.

### Main Flow
1. User completes 3-step account signup.
2. System generates card number and PIN.
3. User logs in with card number + PIN.
4. User performs transactions from ATM menu.
5. All transactions are stored in database and balance is calculated from transaction history.

## Features
- Login with card number and PIN
- Multi-page account registration:
  - Personal details
  - Additional details
  - Account details and service selection
- ATM transactions:
  - Deposit
  - Cash withdrawal
  - Fast cash
  - Balance enquiry
  - Mini statement
  - PIN change
- JDBC-based MySQL integration

## Tech Stack
- Java (Core Java)
- Swing/AWT (Desktop UI)
- JDBC (Database connectivity)
- MySQL (Relational database)
- JCalendar (`com.toedter.calendar.JDateChooser`) for date input in signup form

## Project Structure
- `src/BankManagementSystem/Login.java` - Login screen
- `src/BankManagementSystem/SignUpOne.java` - Signup page 1
- `src/BankManagementSystem/SignUpTwo.java` - Signup page 2
- `src/BankManagementSystem/SignUpThree.java` - Signup page 3
- `src/BankManagementSystem/Transactions.java` - Main ATM menu
- `src/BankManagementSystem/Deposit.java` - Deposit screen
- `src/BankManagementSystem/Withdrawl.java` - Withdrawal screen
- `src/BankManagementSystem/FastCash.java` - Fast cash screen
- `src/BankManagementSystem/BalanceEnquiry.java` - Balance check
- `src/BankManagementSystem/MiniStatement.java` - Transaction summary
- `src/BankManagementSystem/PinChange.java` - PIN update
- `src/BankManagementSystem/Conn.java` - Database connection class
- `icons/` - UI images

## Prerequisites
- JDK 8 or above
- MySQL Server
- MySQL Connector/J driver in classpath
- JCalendar library in classpath
- IDE (IntelliJ IDEA recommended)

## Database Setup
1. Create a database named `bankmanagementsystem`.
2. Create required tables used in code:
   - `signup`
   - `signuptwo`
   - `signupthree`
   - `login`
   - `bank`
3. Update database credentials in `src/BankManagementSystem/Conn.java` if needed.

Current connection string in code:
- `jdbc:mysql://localhost:3306/bankmanagementsystem`

## How to Run
1. Open project in IntelliJ IDEA.
2. Add MySQL Connector/J and JCalendar libraries.
3. Ensure MySQL service is running.
4. Run `Login.java` as main class.

## Why This Stack
- Java + Swing is fast for building desktop-based academic projects.
- JDBC provides direct and simple SQL integration.
- MySQL is reliable and easy for structured transactional data.
- This stack is ideal for demonstrating OOP + DB connectivity fundamentals.

## OOP Concepts Used
- **Class & Object**: each module is implemented as a class.
- **Inheritance**: screens extend `JFrame`.
- **Interface Implementation**: classes implement `ActionListener`.
- **Polymorphism**: `actionPerformed` behaves differently in each screen.
- **Encapsulation**: each class groups related data + behavior.
- **Abstraction**: feature-wise screen separation and common DB connector class.

## Pros
- End-to-end ATM workflow in one project
- GUI-based interactive implementation
- Practical use of JDBC and SQL operations
- Good academic mini-project for interview demonstration

## Limitations
- SQL queries are string-concatenated (SQL injection risk)
- Credentials are hardcoded in source code
- Limited input validation
- UI and business logic are tightly coupled

## Real-World Impact
This project demonstrates the fundamentals of digital banking operations and can serve as a strong foundation for advanced systems with better security, layered architecture, and transaction safety.

## Future Improvements
- Use `PreparedStatement` for secure SQL
- Hash and secure PIN storage
- Add proper exception logging
- Introduce layered architecture (UI/Service/Repository)
- Add unit/integration tests
- Improve validation and user feedback

## Author
Nadeem (or your name)

---
If this repository helped you, consider starring it on GitHub.
