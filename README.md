## Project
- Build Tool : Maven
- Language : Java

## Library
Database
- [Hibernate](https://hibernate.org/) : java library for ORM
- [H2](https://www.h2database.com/) : in-memory database
- [MySQL](https://www.h2database.com/) :relational database (RDB)
- [Java Persistence API](https://www.oracle.com/java/technologies/persistence-jsp.html) : java library for standard interface for accessing databases in java

CLI
- [Picocli](https://picocli.info/) : java library for command line application. [source](https://github.com/remkop/picocli)
- Picocli Shell JLine3 : java library for handling console input. [source](https://github.com/remkop/picocli/tree/master/picocli-shell-jline3)
- [Jansi](https://fusesource.github.io/jansi/) : java library for ANSI escape codes. [source](https://github.com/fusesource/jansi)

GUI
- [Javax Swing](https://docs.oracle.com/javase/8/docs/technotes/guides/swing/index.html)

## Plugin
- Shade Plugin : [Apache Maven Shade Plugin](https://maven.apache.org/plugins/maven-shade-plugin/)
- Shade Plugin : [Apache Maven Assembly Plugin](http://maven.apache.org/plugins/maven-assembly-plugin/) (not use)
- Compile Plugin : [Apache Maven Compiler Plugin](https://maven.apache.org/plugins/maven-compiler-plugin/)

> Shade Plugin is to make a single jar(=uber jar) with dependencies.

## Pattern
- Singleton Pattern

## How to set database
- H2 (auto)
- MySQL (use docker)

```
$ docker run --name mysql -e MYSQL_ROOT_PASSWORD=mypass -d -p 3306:3306 mysql
$ docker exec -it mysql /bin/bash
$ mysql -u root -p mypass
$ show databases;
$ CREATE DATABASE lec_java;
$ use lec_java;
$ show tables;
```

## How to run

**CLI Version**

Run

```
$ java -cp ./com.lec-0.0.1-SNAPSHOT.jar com.lec.my.App
or
$ java -jar com.lec-0.0.1-SNAPSHOT.jar
```

Stop 

```
$ "Ctrl" + 'D'
```

## How to use

**CLI Version**

Login

```
> login admin 1234
```

Register

```
> register student -id 2021160124 -p 1234 -n alice
```


Read

```
> read
> read -a
```

Update

```
> update -p 4567
```

Logout

```
> logout
```

**UI Version**

Login  
Register  
Read  
Update  
Logout  