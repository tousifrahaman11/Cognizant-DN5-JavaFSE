# Exercise 1: Singleton Pattern — Logger

## Scenario (Cognizant DN5.0 Handbook)
You need to ensure that a logging utility class in your application has only
one instance throughout the application lifecycle to ensure consistent logging.

## Requirements Implemented
- [x] `Logger` class has a private static instance of itself
- [x] Constructor of `Logger` is private
- [x] Public static method `getInstance()` to retrieve the instance
- [x] Test class (`LoggerTest`) verifies only one instance is created and used

## How to Run
1. Open this folder in VS Code.
2. Open `src/LoggerTest.java`.
3. Click **Run** above `main` (or press `Ctrl+F5`).

## Expected Output