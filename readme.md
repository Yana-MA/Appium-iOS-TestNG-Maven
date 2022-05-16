# Tools

Tools used: 
- Java
- Selenium Webdriver
- Appium
- Maven
- TestNG  
- Allure

# Task description:

1) Create small test automation framework for 'Google mobile app specification'
   a) Framework should be configurable (at least we should be able to specify 
   the iOS version via command line)
   b) Test framework should provide test reporting with detailed results at 
   the end of tests execution (with screenshots)
2) Test 1: Open the app and search for the keyword ‘alphasense’. Make sure the 
   search is giving the results
3) Test 2: Search for the keyword ‘alphasense’, open the first link from the results 
   and verify the link is loaded properly
4) Test 3: Search for the keyword ‘alphasense’ and scroll down to the bottom of the 
   page and click on ‘More results’ button
5) Test 4: Create your own test and get it failed so that the report will contain a 
   failure report with the necessary information to debug further.
   
# How to run the tests

1. `appium` to start the server
2.  `mvn clean test -DsuiteXmlFile=testng.xml -Dplatform="15.0" -DdeviceName="iPhone 13" -Dudid="53644E91-174F-454C-8EE7-925DBB215C31"` 
(to run tests with parameters you will need: platform version, device name, udid)
3. `allure serve` to generate allure report

# Report

<img width="900" alt="Screen Shot 2022-05-16 at 2 50 17 PM" src="https://user-images.githubusercontent.com/19862702/168587211-2660a03e-601c-4d0f-b911-9bc0a17c0e90.png">


