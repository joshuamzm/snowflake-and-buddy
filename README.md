# snowflake-and-buddy

~~Minimal project setup to demonstrate class resolution error between Snowflake JDBC and Buddy libraries.~~

The error was solved removing the Snowflake JDBC dependency from the Uberjar, and including the jar in the classpath when executing the Clojure project's entrypoint.

# Compile project

Execute the following command:

```
clojure -X:uberjar
```

# Fetch Snowflake JDBC Jar

Download [snowflake-jdbc-3.13.24.jar](https://repo1.maven.org/maven2/net/snowflake/snowflake-jdbc/3.13.24/snowflake-jdbc-3.13.24.jar) directly in the `target/` directory.

# Run project

```
java --add-opens=java.base/java.nio=ALL-UNNAMED -cp ./target/* org.acme.main
```

# Program output

```
> java --add-opens=java.base/java.nio=ALL-UNNAMED -cp .\target\* org.acme.main
Get addresses with ZIP code 12020
("191dae24689c5023a4eb448d30263624b6fa7463842c77ae1c5963a86cd56b14"
 "7c8ba03db283bf6aa6e839eb32679e3528cb40e8f696c50096be7b4e67351385")
```