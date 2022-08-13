# automation_example
This is an example of account creation test on http://automationpractice.com

This example is using **selenium-uitaf** open source project for UI test automation, 
and shows how to use it in business oriented and BDD oriented test development approaches.

The test assumes that Chrome browser is installed on the target machine where this test should run.
<br>This project is targeting Java 8 only!

To build the solution just follow these steps:
1)	Clone this repository to your machine
2)	Build the solution by invoking following command:  `mvn clean package`
3)	Execute the solution by invoking `java -jar target\example-1.0-SNAPSHOT.jar`

The test will invoke 4 Chrome browser instances and will fill the Account Registration form with randomly generated data.
At the end of the test, report with execution results will be launched in the default browser.
