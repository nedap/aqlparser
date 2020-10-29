# aqlparser

The aqlparser is a library that creates a class representation (Query Object Model, QOM) from a given AQL string.
This QOM can be used to create an AQL query.

Note that this library does not contain any query logic, just the parser and an object model.

## Setup
In order to setup aqlparser, please create a gradle properties file ```.../aqlparser/gradle.properties``` and add
```gradle
artifactory_user=user.name
artifactory_password=...
```
to it. If you're not working at Nedap, just add a random string there.

 Rember that if you build aqlparser for the first time (or altered the grammar), run
```shell script
./gradlew generateGrammarSource
```
first.
