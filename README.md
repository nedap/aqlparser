# aqlparser

The aqlparser is a library that creates a class representation (Query Object Model, QOM) from a given AQL string.
This QOM can be used to create an AQL query.

Note that this library does not contain any query logic. This logic is e.g. contained in the query package of chiron.
 
## Dependency
The aqlparser is available internally from artifactory and can be included in your gradle project using
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

## Setup
In order to setup aqlparser, please create a gradle properties file ```.../aqlparser/gradle.properties``` and add
```gradle
artifactory_user=user.name
artifactory_password=...
```
to it. Rember that if you build aqlparser for the first time (or altered the grammar), run
```shell script
./gradlew generateGrammarSource
```
first.

## Publishing
In order to upload a new version of aqlparser to artifactory, update ```version``` in ```build.gradle``` and 
```README.md``` and run 
```shell script
./gradlew clean
./gradlew artifactoryPublish
```