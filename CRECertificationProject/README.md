# 🎓 Certificação Rumos Expert: Test Automation Engineer 
In order to get my final course certification, the challenge was to choose an e-commerce website, where I was given a exercise where I should write a set 
of automated tests using the tools learned during the course.

## 🔧 Tools I used for this project

**IDE** :Eclipse 

**Frameworks used**: Selenium, Cucumber

**Testing framework**: TestNG, Allure Report, JUnit

**Programming language**: JAVA

**Build tool** : Maven

**CI/CD Tool** : Jenkins

**Repository** : GitHub

## 💻 E-commerce website I choose to test

*https://magento-demo.mageplaza.com/*

I opted to choose a different e-commerce website, to replicate what I've learned through the classes, without the familiarity of websites I tested during classes.

## 📑 Pre-requisites for this project

In order to replicate this project you should:

+ Have JDK 21

+ Maven 3.9.9

+ IDE that is compatible with Selenium *IntellIJ* , *Eclipse*, *Aqua* (Those are some examples)

+ On your IDE you should be able install *TestNg*, *JUnit*, *Cucumber*

+ On your computer you should install **Allure**, if it's not instaled

+ You should also install **Jenkins** and **Git**


## 🏆 Testing purpose

The goal is to validate the following:
 - User registration
 - User login
 - Search and visualize products
 - Add product to shopping cart
 - Purchase an item 



# 💪 Getting Started with testing the project

### The logic behind running the tests in this project

To run all the tests, run the comman mvn clean test on the project terminal.

**The test runner has the tag line commented, in order to run all the tests**

To run on test at the time, remove the comment and select the @tag you want to run.

Example1:  

`/*tags = "@tag1", // Tag to select the scenarios to run*/ ` = Run all the tests that are in the features folder

Example2: 

`tags = "@tag1",` = Run all the tests that are in the *UserLogin.featue*, in the features folder

### 💡 The logic behind organizing the project

In order to organize the project, I used the Page Object Model, so that each feature to be tested, was implemented
independently and all the test could run also independtly. 

With this model, I also can reuse code, making the project cleaner and easier to mantain the tests.

Since the goal is to test different features, I created different features filles, where I wrote different test cases and scenarios.

### 📝 Feature explanation example:

The scenario below is writen using Gherkin language, where the feature tested is the successful login
Using scenario outline, I can specify steps for testing using different data sets.


[UserLoginFeature](src/test/resources/Features/UserLogin.feature)


### 📝 Explaining the HomepageSteps usage

Across different scenarios, there is a set of steps that are the same: they all start in the homepage, using a browser.

`Given I am on the homepage using "<browser>"` = This step is present in all the scenarios.

So, the best way I found to reuse and handle this step was to create a HomePageSteps, so everytime I have a scenario where I have to access the browser
the HomePageSteps will handle the request.


Here is the code:

🔗 [HomePageSteps](src/test/java/magentoDemoSteps/steps/HomePageSteps.java)



### 📝 Page Object Models 

**What is Page Object Models?**
>Page Object Model, also known as POM, is a design pattern in Selenium that creates an object repository for storing all web elements. 
>It helps reduce code duplication and improves test case maintenance. 
>In Page Object Model, consider each web page of an application as a class file.

I chose to separate each feature to be tested in different steps, with their respective page objects.

Example: 
- UserLoginSteps.java have the correspondent repository = UserLogin.java
 
### 📝 Packages explained

#### 📝 Browser configuration package

In order to reuse the code in a cleaner and easier way, I created different packges inside the folder test.

Example:
 - browserConfiguration package is where I configured the browsers where the tests will run.

In this case the tests will run on **Chrome**,**Firefox**and**Edge**.


🔗 [BrowserConfiguration](src/test/java/browserConfiguration/BrowserConfiguration.java)
 

#### 📝 TestContext package 

Since I share states between features and steps, in order to use the webdriver across the test, I created this package

**Why did I choose to use TestContext?**

It was the solution I chose to share states between step definitions for each
feature I am testing. 

This way, it is easier to reuse code instead of always
creating a separate instance of the WebDriver. 

**Here is the code**

🔗 [TestContext](src/test/java/testContext/TestContext.java)


**The code explained** 
The TestContext class: Stores the WebDriver. Allows the same WebDriver
to be reused by various parts of the test. Centralizes the logic for
initializing and accessing the WebDriver.

*Objective of the Code:*
The purpose of the TestContext class is to facilitate the sharing of
the WebDriver instance between different parts of your test (for example,
different step definitions in Cucumber). This eliminates the need to recreate
the WebDriver multiple times, saving resources and ensuring that the browser's
state remains consistent throughout the test.


### 🚩 Error handling 
Through the project, while running tests in different browsers, I noticed that in one specific browser, the test was allways failing.

The reason was that the information sent was being sent to fast and the browser couldn't detect what was being written.

Example: 


```
public void clickShoppingCartIcon() {

		// This try catch gives the browser time to process that that
		// An item was added to the shopping cart before clicking
		// On the shopping cart icon

		try {

			// Sleep for 5 seconds (5000 milliseconds)
			Thread.sleep(5000); // This is the simple fixed wait
			shoppingCartIcon = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action.showcart")));
			shoppingCartIcon.click();
		} catch (Exception e) {
			// Catch any other exceptions and print the error
			System.err.println("An error occurred: " + e.getMessage());
		}

	}

```


## 📢 Contributions
There is no contributors yet.

Feel free to contribute with improvements or any other thoughts on how should I improve my code.

## 🙆‍♀️ Author
**Name**: Deborah Silva














 








 
 