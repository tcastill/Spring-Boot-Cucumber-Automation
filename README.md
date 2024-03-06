# Getting Started

## Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.3/maven-plugin/reference/html/#build-image)
* [Spring Boot Testcontainers support](https://docs.spring.io/spring-boot/docs/3.2.3/reference/html/features.html#features.testing.testcontainers)
* [Testcontainers](https://java.testcontainers.org/)

## Test Containers Support

This project uses [Testcontainers at development time](https://docs.spring.io/spring-boot/docs/3.2.3/reference/html/features.html#features.testing.testcontainers.at-development-time).

Testcontainers has been configured to use the following Docker images:

Please review the tags of the used images and set them to the same as you're running in production.

Navigate to the yaml file and execute $docker-compose up

To add more ocker images you can execute:
$docker-compose up --scale chrome=3

The grid console is on http://localhost:4444/grid/console

Common docker commands

1. docker container ls -a
2. docker ps -a
3. docker stop $(docker ps -a -q)
4. docker rm $(docker ps -a -q)

Run multiple profiles to selenium GRID spring.profiles.active=remote,production;browser=firefox

How to access Files

Data JPA
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference

Logging logging.level.root=ERROR/WARN/INFO/DEBUG/TRACE

Langugae code types German = de-DE Finnis = fi-FI Swedish = sv-SE English = en-US

## How to run a test
At the terminal run
- $mvn clean test

There is also a script you can use to run the test
- $./run.sh test

## Running The Test Options
Additional options can be used for test options. Just append them to the command line starting with a -D.

e.g. $mvn clean test -Dbrower=chrome

| Option               |            Values            |                                                                  Description |
|:---------------------|:----------------------------:|-----------------------------------------------------------------------------:|
| browser              |    chrome, firefox, edge     | UI test will run in the browser this is set to. Chrome is the default value. |
| headless             |         true, false          |              All UI test will run in the background. Default is set to true. |
| parallel             |    add in command to run     |                All test will run sequencially unless this parameter is added |
| cucumber.filter.tags | @Smoke, @Regression, @Sanity |                       Run specific tests with a cucumber tag. Example @Smoke |
