## Project
- Build Tool : Maven
- Language : Java

### Library
Database
- [Hibernate](https://hibernate.org/) : java library for ORM
- [H2](https://www.h2database.com/) : java library for in memory database
- [Java Persistence API](https://www.oracle.com/java/technologies/persistence-jsp.html) : java library for standard interface for accessing databases in java

CLI
- [Picocli](https://picocli.info/) : java library for command line application. [source](https://github.com/remkop/picocli)
- Picocli Shell JLine3 : java library for handling console input. [source](https://github.com/remkop/picocli/tree/master/picocli-shell-jline3)
- [Jansi](https://fusesource.github.io/jansi/) : java library for ANSI escape codes. [source](https://github.com/fusesource/jansi)

### Plugin
- Shade Plugin : [Apache Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/)
- Shade Plugin : [Apache Maven Assembly Plugin](http://maven.apache.org/plugins/maven-assembly-plugin/) (not use)
- Compile Plugin : [Apache Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)

> Shade Plugin is to make a single jar(=uber jar) with dependencies.

### How to use

run

```
$ java -cp ./com.lec-0.0.1-SNAPSHOT.jar com.lec.my.App
or
$ java -jar com.lec-0.0.1-SNAPSHOT.jar
```

stop 

```
$ "Ctrl" + 'D'
```