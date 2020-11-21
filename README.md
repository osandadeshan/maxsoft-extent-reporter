# MaxSoft Extent Reporter

## Introduction
The main reason for developing this plugin is to provide an easy way to generate the Extent report for test automation.  

## Technologies/Frameworks used
- Java
- Extent Report
- Selenium
- Apache Maven

## Supported Platforms
- Windows
- Linux
- Mac OS

## Supported Languages
- Java

## Advantages
- Automatically generates the Extent report after the test execution.
- Reporter details can be configured through a property file.
- No need to implement classes for Extent reporting.
- Easy to use.

## Pre Requisites
1. Java
2. Maven

## How to use
1. Add MaxSoft Extent Reporter dependency into pom.xml
```xml
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
	
	<dependencies>
        <dependency>
            <groupId>com.github.osandadeshan</groupId>
            <artifactId>MaxSoft-Extent Reporter</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
```

2. Create "**config.properties**" in "***src/test/resources/config.properties***"

    # Test Configs
    application_url=http://automationpractice.com/index.php?controller=authentication&back=my-account
    browser=Chrome
    
    # Extent Report Configs
    extent_reporter_theme=dark
    capture_screenshot_on_failure=true
    extent_document_title=Test Execution Report
    extent_reporter_name=Test Execution Report
    application_name=AutomationPractice.com
    environment=Production
    operating_system=Windows 10 - 64 Bit
    test_developer=Osanda Nimalarathna	

3. In the test automation code, find the place you are launching the WebDriver

4. Pass your WebDriver object to the "**setDriver()**" method which can be imported from "***com.maxsoft.extentreport.DriverHolder.setDriver***"
```java
WebDriver driver = new ChromeDriver();
setDriver(driver);
```
5.  Update the places where your are using WebDriver object, into **getDriver()** method which can be imported from "***com.maxsoft.extentreport.DriverHolder.getDriver***"
```java
getDriver().manage().window().maximize();
```

6. Create the TestNG.xml by adding the MaxSoft Extent Reporter listener
```xml
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >
<suite name="Regression Test Suite">
    <listeners>
        <listener class-name="com.maxsoft.extentreport.ExtentReportListener"/>
    </listeners>
    <test name="Regression Test">
        <classes>
            <class name="test.LoginTest" />
        </classes>
    </test>
</suite>
```

## License
<img src="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0b/License_icon-mit-2.svg/2000px-License_icon-mit-2.svg.png" alt="MIT License" width="100" height="100"/> [MaxSoft Extent Reporter](https://medium.com/maxsoft-extent-reporter) is released under [MIT License](https://opensource.org/licenses/MIT)

## Copyright
Copyright 2020 MaxSoft.
