# Selenium-Java-TestNG-Automation-Framework

🔍 Project Overview

The framework is implemented against a live enterprise application (OrangeHRM) and covers critical business workflows including authentication, dashboard validation, and employee management.

🌐 Application Under Test

🔗 https://opensource-demo.orangehrmlive.com/

🧠 Key Highlights 

✔ Clean, modular Page Object Model (POM) architecture
✔ Data-driven testing foundation (Excel-ready)
✔ Parallel execution using TestNG
✔ Reusable utilities (browser setup, screenshots, config handling)
✔ Failure screenshots for faster debugging
✔ CI/CD-ready design (GitHub Actions compatible)
✔ Written with readability, scalability, and maintainability in mind

⚙️ Tech Stack & Tools
Category	Tools
Language	Java (11+)
Automation	Selenium WebDriver 4
Test Framework	TestNG
Build Tool	Maven
Design Pattern	Page Object Model (POM)
Reporting	Extent Reports (HTML)
Data Handling	Apache POI (Excel)
CI/CD	GitHub Actions (optional)
IDE	IntelliJ / Eclipse

🏗️ Framework Structure
SeleniumJavaTestNGDemo/
│
├── pom.xml
├── testng.xml
├── README.md
│
└── src/
    ├── main/java/
    │   ├── pages/        # Page Objects (UI abstraction)
    │   └── utils/        # Browser, config, screenshots, helpers
    │
    └── test/java/
        └── tests/        # Test cases (business scenarios)


🧪 Test Scenarios Covered
✅ Valid Login
❌ Invalid Login Validation
🔐 Logout Flow
📊 Dashboard UI Verification
👤 Add Employee (PIM Module)

Each test is:
Independent
Reusable
Easy to scale

▶️ How to Run the Tests

Prerequisites
Java 11+
Maven installed
Chrome browser

Steps
git clone <repo-url>
cd SeleniumJavaTestNGDemo
mvn clean test


Or run directly using:
testng.xml

📸 Reporting & Debugging
Screenshots captured automatically on test failure
Extent HTML reports (easy to review and share)
Logs structured for quick root-cause analysis

🚀 CI/CD Ready

This framework is structured to run seamlessly in:
GitHub Actions
Jenkins
GitLab CI

