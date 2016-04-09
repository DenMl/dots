Pircbot
====

**Pircbot** is an IRC client library, a library that allows building custom IRC bots and clients.

**Pircbot-sbt** is an adaptation of Pircbot as an SBT module.

Usage
====

SBT can depend on git repositories, use it like:

```scala
  lazy val root = project.in(file("."))
    .dependsOn(uri("git://github.com/vn971/pircbot-sbt"))
```
