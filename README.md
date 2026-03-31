# NopCommerce Automation Framework

This project is a UI automation framework built using Selenium WebDriver, Java, TestNG, and Maven to test a locally hosted nopCommerce application.

## Project Overview
The framework automates core e-commerce user flows such as registration, login validation, product selection, cart actions, and other purchase-related scenarios.

## Application Under Test
This automation framework runs against a locally hosted nopCommerce application instance.

local URL:
`http://localhost:5000`


## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Extent Reports
- GitHub

## Framework Design
- Page Object Model (POM)
- Reusable Base Test setup
- Config-driven execution
- Screenshot capture on failure
- HTML reporting using Extent Reports

## Automated Test Scenarios
- User registration
- Invalid login validation
- Product selection
- Shopping cart validation
- Gift card flow
- Other end-to-end e-commerce scenarios

## Prerequisites
Before running the automation framework, make sure you have:

- Java installed
- Maven installed
- Chrome or Edge browser installed
- nopCommerce application downloaded and running locally
- Application URL updated in the configuration file

## How to Run the Application Locally
1. Download the nopCommerce application package
2. Extract it on your local machine
3. Complete the required application setup
4. Start the application locally
5. Verify that it opens in the browser

Example:
`http://localhost:5000`

## How to Run the Automation Tests
1. Clone this repository
2. Open the project in your IDE
3. Update the URL in the properties/config file
4. Run the test suite

Using Maven:
mvn clean test

## Reporting
1. Test execution generates reports
2. Failed test cases capture screenshots for easier debugging

## Future Improvements
1. GitHub Actions CI integration
2. Cross-browser execution improvements
3. Better explicit waits
4. Parallel execution
5. Headless execution support

Author: Pradeep Garikimukku
Role: Software QA Analyst
Tech: Selenium | TestNG | Java | CI/CD | Agile | Manual & Automation Testing
