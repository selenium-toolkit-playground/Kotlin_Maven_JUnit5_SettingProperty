# Selenium-Java-Toolkit-JUnit5-Playground
This is the sample-Project and show you how to use the Selenium-Toolkit.
The Selenium-Toolkit is a Java based test-toolkit for selenium-testing with testNg or Junit.
This sample-Project shows how to use it with JUnit5.

The goal of the toolkit is, to support you by creating and maintainig your seleniumtests.
It also give you a nice Report to have a better overview.

## Instructions and Help
Please visit our Page [Showcase](https://selenium-toolkit.com/showcase/) to learn more about the different Parts of the Toolkit and how its working

## Installation

Download this project to get started.
There should be all inside this Project what you need for a fast start.

## Run tests
```xml
mvn test site
```
if you don't want to see old runs or use Allure-Jenkins-Plugin, add clean:
```xml
mvn clean test site
```

you are also able to just click on a "Run Test" button in your IDEA and then run "mvn site" to create the Report.

## Watch Report
Open the file target/site/allure-maven.html in Chrome

## Add Toolkit to your existing Project

**This is the instruction, how you can add this toolkit into your existing Test-Project, if you don't want to download this Project.

If you starts on the Green or don't want to do all this things, please simply use this Project.**



### Pom modifications
and optional the other 2 Dependencies for DB-Connections

pom.xml:
```xml
<dependency>
    <groupId>com.selenium-toolkit</groupId>
    <artifactId>selenium-java-toolkit-JUnit5-pro</artifactId>
    <version>1.3.23</version>
    <scope>test</scope>
</dependency>
```


### Define Properties
pom.xml:
```xml
<properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.8</maven.compiler.source>
    <maven.compiler.target>1.8</maven.compiler.target>
    <aspectj.version>1.8.10</aspectj.version>
</properties>
```

### Configure Build and Reporting
pom.xml:
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>2.22.2</version>
            <configuration>
                <testFailureIgnore>true</testFailureIgnore>
                <includes>
                    <include>**/*.java</include>
                </includes>
                <systemProperties>
                    <property>
                        <name>projectArtifactId</name>
                        <value>${project.artifactId}</value>
                    </property>
                </systemProperties>
                <argLine>
                    -javaagent:"${settings.localRepository}/org/aspectj/aspectjweaver/${aspectj.version}/aspectjweaver-${aspectj.version}.jar"
                </argLine>

            </configuration>
            <dependencies>
                <dependency>
                    <groupId>org.aspectj</groupId>
                    <artifactId>aspectjweaver</artifactId>
                    <version>${aspectj.version}</version>
                </dependency>
            </dependencies>
        </plugin>
    </plugins>
</build>
<reporting>
<excludeDefaults>true</excludeDefaults>
<plugins>
    <plugin>
        <groupId>com.selenium-toolkit</groupId>
        <artifactId>allure-maven</artifactId>
        <version>2.10_acl_2.8.1-1.3.23</version>
    </plugin>
</plugins>
</reporting>
```

### Usage
#### Configure the Toolkit
You are able to define 2 type of Configurations:

Read more about the [Configuration-Class](https://selenium-toolkit.com/showcase/#tab-ConfigurationClass) or the TestData-Management and how to switch them.
or about the [Configuration-Property](https://selenium-toolkit.com/showcase/#tab-Configuration) or the TestData-Management and how to switch them.

### Run tests
```xml
mvn test site
```
if you don't want to see old runs or use Allure-Jenkins-Plugin, add clean:
```xml
mvn clean test site
```

### Watch Report
Open the file target/site/allure-maven.html

## Configure Report Categories (optional)
If you want you can define [Categories](https://docs.qameta.io/allure/#_categories_2), please see doku in link.

## Contributing


