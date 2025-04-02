# Grapefy-Appium_SkillDemo

## Overview
Grapefy-Appium_SkillDemo is a project developed to showcase skills in Java, Appium, BDD, Cucumber, Gherkin, mobile automation, and CI/CD integration. It highlights strong capabilities in cross-platform mobile testing, test design strategies, and agile collaboration.

## Features
- Built using **Appium**, **Gherkin**, and **JUnit5** for mobile BDD automation.
- Integrated with **Maven Wrapper** for simplified build and dependency management.
- CI/CD enabled via **GitHub Actions** for automated execution.
- Automatically generates detailed reports using **Cucumber Reports**.

## Prerequisites
Make sure to have the following tools and dependencies installed before setting up the project:
- [Amazon Corretto JDK 17.0.14](https://aws.amazon.com/corretto/)
- [Maven](https://maven.apache.org/install.html) *(optional if using Maven Wrapper)*
- [Git](https://git-scm.com/downloads)
- Appium, Selenium-Java, Cucumber, Cucumber-reporting, and JUnit5 libraries (managed via Maven)

## APK Path
- The APK used for testing is located at:
  ```
  src/test/resources/apk
  ```

## Appium Server Initialization
If you're running this on a new machine, start the Appium server for the first time with:
```sh
appium server --allow-insecure chromedriver_autodownload
```
On subsequent runs, use:
```sh
appium server
```

## Device Setup
Before executing tests:
- Start an Android emulator **or** connect a physical device.
- Ensure the correct APK is already installed on the device.

## Installation
1. Clone the repository:
   ```sh
   git clone https://github.com/DiegoPatcheco/Grapefy-Appium_SkillDemo.git
   ```
2. Navigate to the project directory:
   ```sh
   cd Grapefy-Appium_SkillDemo
   ```
3. Build the project using Maven Wrapper:
   ```sh
   ./mvnw clean install
   ```
   *(Windows users can use `mvnw.cmd` instead)*

## Running Tests
To execute the test suite:
```sh
./mvnw clean test
```

You can also run a specific suite using the script:
```sh
./runSuite.sh
```

## Cucumber Report
- The **Cucumber Report** is automatically generated after test execution.
- To open the report locally:
  ```sh
  ./openReport.sh
  ```

## CI/CD Integration
- Integrated with **GitHub Actions** to automatically run tests on every push or pull request.
- Cucumber reports and test results are uploaded as artifacts and accessible from the Actions tab.

## Contributing
Contributions are welcome! To contribute:
1. Fork this repository.
2. Create a new feature branch.
3. Commit your changes.
4. Push your branch and open a pull request.

## Author
Developed by [Diego Patcheco](https://github.com/DiegoPatcheco).

