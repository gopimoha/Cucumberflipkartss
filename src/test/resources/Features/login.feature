Feature: to validate login functionality of flipkart page

Scenario Outline: to valid login functionality of flipkart page using invalid credentials
Given the user has to be in loginpage
When the user has to click login buton
And  the user has to fill "<username>" and "<password>"
And the user has to click the login button
Then the user should navigate to invalid login page

Examples:
|username|password|
|gopi@123|8844|
|manoj@123|38933|
suresh05@gmail.com|77778|
  
 
