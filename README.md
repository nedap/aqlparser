> [!WARNING]
> This project is no longer maintained.
>
> A newer AQL grammar is available in [Archie](https://github.com/openEHR/archie).

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

## Using as a dependency

This project is not yet hosted on a public repository yet, but feel free to add to your own internal repositories for now.
 If you're a Nedap Healthcare employee, see https://github.com/nedap/aqlparser/wiki/Nedap-Healthcare-internal-build-instructions . 
