Feature: Login into application

  Scenario: Scenario for successful Login into application
    Given Initialize the browser as chrome
    And Navigate to login site
    And Click on Login link in home page to navigate to secure sign in page
    When User enters username and password and logs in
    Then Verify the user is successfully logged in