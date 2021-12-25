Feature: Login Functionality
Background:

And   User Navigates to the login page

Scenario: verify the login function with valid cerdentails

When  User enters valid username and valid password
And   User click on the login button
Then  User is successfully logged in

@Smoke
Scenario: verify the login function with valid cerdentails

When  User enters valid "Admin" and valid "Admin123"
And   User click on the login button
Then  User is successfully logged in
@DataDriven
Scenario Outline: verify the login functionality with invalid Ceredentials
When User enters invalid "<username>" and invalid  "<password>"
And   User click on the login button
Then verify the "<errorMessage>"

Examples:
|username   |      password   | errorMessage|
|admin123   |    Admin123     |Invalid credentials|
|Admin      |    Admin123657  |Invalid credentials|
|Admin123   |    Admin123657  |Invalid credentials|
|Admin123   |                 |Password cannot be empty|
|           |    Admin123657  |Username cannot be empty|

@DataTable
Scenario: verify the login function with invalid Data

When enters enters the invalid Cerdentails and click on login and verify the error
|username   |      password   | errorMessage      |
|admin123   |    Admin123     |Invalid credentials|
|Admin      |    Admin123657  |Invalid credentials|
