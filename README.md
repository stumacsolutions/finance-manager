# Gradle Commands
This section documents custom Gradle commands built into this project.
Those tasks provided automatically by the various plugins which have 
been incorporated are not documented here.

## ./gradlew acceptanceTest
This command will run the acceptance tests for the project. Cucumber has
been used to implement acceptance tests. The Gherkin feature files are
located under src/test/resources/features. The Java code implementing 
the steps is located under src/test/java/acceptance/steps.

## ./gradlew checkstyle
This command is a simple convenience command which wraps up the tasks 
provided by the checkstyle plugin.

## ./gradlew findbugs
This command is a simple convenience command which wraps up the tasks 
provided by the findbugs plugin.

## ./gradlew jdepend
This command is a simple convenience command which wraps up the tasks 
provided by the jdepend plugin.

## ./gradlew mutationTest
This command will perform mutation testing on the project. This ensures
that the tests are of a high standard and are performing meaningful
assertions.
