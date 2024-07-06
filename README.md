## Programming in Scala for Big Data Systems, Fall 2024
Scala Project for Harvard Extension course CSCI E-88C, Fall, 2024. See course details at [Scala for Big Data](https://courses.dce.harvard.edu/?details&srcdb=202501&crn=16769).


The project requires Java 17, Scala 2.13 and sbt 1.9.2+ environment to run.

### Getting started
 Use the following commands to get started with your project

 - Compile: `sbt compile`
 - Create a "fat" jar: `sbt assembly`
 - Run tests: `sbt test`
 - To install in local repo: `sbt publishLocal`

### Running in containers
To run the project and commands in a container see [Scala Docker](README-scala-docker.md)

### Static Analysis Tools

#### Scalafmt
To ensure clean code, run scalafmt periodically. The scalafmt configuration is defined at https://scalameta.org/scalafmt/docs/configuration.html

For source files,

`sbt scalafmt`

For test files.

`sbt test:scalafmt`

#### Scalafix
To ensure clean code, run scalafix periodically. The scalafix rules are listed at https://scalacenter.github.io/scalafix/docs/rules/overview.html

For source files,

`sbt "scalafix RemoveUnused"`

For test files.

`sbt "test:scalafix RemoveUnused"`

### License
Copyright 2024, Edward Sumitra

Licensed under the MIT License.