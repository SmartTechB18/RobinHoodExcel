
Feature: Login functionality

	@positive  @E2E  @smoke
  Scenario: Validating user can login succefully with valid credentials
    Given User open chrome browser
    And Open application URL
    When Click on Sign in button on the homepage
    And Eneter user Name
    And Enter password
    And Click on sign in button
    Then User is logged into the account home page
    
    

	@negative  @E2E
  Scenario Outline: Validating user is unable to login with invalid credentials
    Given User open chrome browser
    And Open application URL
    When Click on Sign in button on the homepage
    And Eneter user name <"userName">
    And Enter password <"password">
    And Click on sign in button
    Then User is redirected to error page

    Examples: 
      | userName  							| password 			|
      | abcd@xyz.com 						| Bizbeellc123 	|
      | Bizbeellc.03@gmail.com 	| 1234 					|
      | qwed@fddff.com					| a2a2					|
