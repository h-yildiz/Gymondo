
# Gymondo Automation Challenge

There are 3 scenarios created and 2 of them automated.


## Installation

Install [Maven](https://maven.apache.org/install.html)

Install [JDK](https://docs.oracle.com/en/java/javase/18/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A)

Install the dependencies by running the command below in command line:

```
mvn install
```
## Running Tests

Go to project root directory and open the CukesRunner file:

Run all the missions at once:

```
mvn test
```
Run only Login feature:

```
mvn test -Dcucumber.options="src/test/resources/features/login.feature"
```

Run only My Plan feature:

```
mvn test -Dcucumber.options="src/test/resources/features/myPlan.feature"
```
Note: 2. Scenario is not implemented in myPlan.feature file and it will be skipped when the test is run.