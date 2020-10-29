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

## Dependency (sorry, this is an internal comment for now)
The aqlparser is not yet available from amven central.
It is available in the internal Nedap Healthcare repositories and can be included in your gradle project using
```gradle
dependencies {
    compile(group: 'com.nedap.healthcare', name: 'aqlparser', version: '0.1.1')
}
```
or using maven
```xml
<dependency>
    <groupId>com.nedap.healthcare</groupId>
    <artifactId>aqlparser</artifactId>
    <version>0.1.1</version>
</dependency>
```


## License

This project is published under the Apache 2 license. The ANTL grammar used in this project is an exception, and is LGPL.

## Publishing (sorry, this is an internal comment for now)
In order to upload a new version of aqlparser to artifactory, update ```version``` in ```build.gradle``` and
```README.md``` and run
```shell script
./gradlew clean
./gradlew artifactoryPublish
```
